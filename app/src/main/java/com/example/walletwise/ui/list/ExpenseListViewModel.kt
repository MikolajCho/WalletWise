package com.example.walletwise.ui.list

import android.app.Application
import androidx.lifecycle.*
import com.example.walletwise.WalletWiseApplication
import com.example.walletwise.data.model.Category
import com.example.walletwise.data.model.Expense
import com.example.walletwise.utils.DateUtils
import kotlinx.coroutines.launch

class ExpenseListViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = (app as WalletWiseApplication).repository

    // Zmienne do przechowywania daty i kategorii (żeby wiedzieć co wyświetlać)
    var rok = DateUtils.currentYear()
    var miesiac = DateUtils.currentMonth()
    var wybranaKategoria: Category? = null

    // To co widzi Fragment (lista i suma)
    val wydatki = MutableLiveData<List<Expense>>()
    val sumaMiesiaca = MutableLiveData<Double>()

    // Główna funkcja: czyści listę, pobiera nową z bazy i ją ustawia
    fun odswiezDane() {
        val (start, end) = DateUtils.getMonthRange(rok, miesiac)
        
        viewModelScope.launch {
            // Pobieramy listę z bazy (przez repozytorium)
            val listaZBazy = repo.getExpensesByMonth(start, end)
            
            // Jeśli użytkownik kliknął jakiś filtr kategorii, to filtrujemy
            val listaKoncowa = if (wybranaKategoria == null) {
                listaZBazy
            } else {
                listaZBazy.filter { it.category == wybranaKategoria!!.name }
            }
            
            // Ustawiamy wynik
            wydatki.value = listaKoncowa
            sumaMiesiaca.value = listaKoncowa.sumOf { it.amount }
        }
    }

    fun poprzedniMiesiac() {
        if (miesiac == 0) {
            miesiac = 11
            rok--
        } else {
            miesiac--
        }
        odswiezDane()
    }

    fun nastepnyMiesiac() {
        if (miesiac == 11) {
            miesiac = 0
            rok++
        } else {
            miesiac++
        }
        odswiezDane()
    }

    fun usunWydatek(expense: Expense) = viewModelScope.launch {
        repo.delete(expense)
        odswiezDane()
    }
}
