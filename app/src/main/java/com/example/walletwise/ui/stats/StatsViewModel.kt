package com.example.walletwise.ui.stats

import android.app.Application
import androidx.lifecycle.*
import com.example.walletwise.WalletWiseApplication
import com.example.walletwise.data.db.CategoryTotal
import com.example.walletwise.utils.DateUtils
import kotlinx.coroutines.launch

// Prosta klasa z danymi dla ekranu
class StatsUiState(
    var kategorie: List<CategoryTotal> = emptyList(),
    var suma: Double = 0.0,
    var rok: Int = DateUtils.currentYear(),
    var miesiac: Int = DateUtils.currentMonth()
)

class StatsViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = (app as WalletWiseApplication).repository

    // LiveData przechowująca stan statystyk
    val stanUi = MutableLiveData<StatsUiState>()

    // Zmienne pomocnicze
    private var aktualnyRok = DateUtils.currentYear()
    private var aktualnyMiesiac = DateUtils.currentMonth()

    fun wczytajStatystyki() {
        viewModelScope.launch {
            val (start, end) = DateUtils.getMonthRange(aktualnyRok, aktualnyMiesiac)
            
            // Pobieramy dane z bazy
            val dane = repo.getCategoryTotalsForMonth(start, end)
            val sumaMiesiaca = dane.sumOf { it.total }

            // Tworzymy nowy obiekt stanu i wysyłamy do fragmentu
            stanUi.value = StatsUiState(
                kategorie = dane,
                suma = sumaMiesiaca,
                rok = aktualnyRok,
                miesiac = aktualnyMiesiac
            )
        }
    }

    fun poprzedniMiesiac() {
        if (aktualnyMiesiac == 0) {
            aktualnyMiesiac = 11
            aktualnyRok--
        } else {
            aktualnyMiesiac--
        }
        wczytajStatystyki()
    }

    fun nastepnyMiesiac() {
        if (aktualnyMiesiac == 11) {
            aktualnyMiesiac = 0
            aktualnyRok++
        } else {
            aktualnyMiesiac++
        }
        wczytajStatystyki()
    }
}
