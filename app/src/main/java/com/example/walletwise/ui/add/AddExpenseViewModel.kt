package com.example.walletwise.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.walletwise.WalletWiseApplication
import com.example.walletwise.data.model.Category
import com.example.walletwise.data.model.Expense
import kotlinx.coroutines.launch

class AddExpenseViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = (app as WalletWiseApplication).repository

    // Wynik zapisywania lub ładowania
    private val _saveResult = MutableLiveData<SaveResult?>(null)
    val saveResult: LiveData<SaveResult?> = _saveResult

    // Pola formularza
    var amount: String = ""
    var selectedCategory: Category? = null
    var description: String = ""
    var date: Long = System.currentTimeMillis()
    var receiptImagePath: String? = null

    // ID edytowanego wydatku (jeśli edycja)
    private var editingExpenseId: Long? = null

    // Ładowanie danych do edycji
    fun loadExpense(id: Long) = viewModelScope.launch {
        val expense = repo.getExpenseById(id) ?: return@launch
        editingExpenseId = expense.id
        amount = expense.amount.toString()
        selectedCategory = Category.fromName(expense.category)
        description = expense.description
        date = expense.date
        receiptImagePath = expense.receiptImagePath
        _saveResult.value = SaveResult.Loaded(expense)
    }

    // Zapisywanie wydatku
    fun save() = viewModelScope.launch {
        val amountDouble = amount.replace(",", ".").toDoubleOrNull()
        if (amountDouble == null || amountDouble <= 0) {
            _saveResult.value = SaveResult.Error("Podaj poprawną kwotę")
            return@launch
        }
        val cat = selectedCategory
        if (cat == null) {
            _saveResult.value = SaveResult.Error("Wybierz kategorię")
            return@launch
        }

        val expense = Expense(
            id = editingExpenseId ?: 0,
            amount = amountDouble,
            category = cat.name,
            description = description.trim(),
            date = date,
            receiptImagePath = receiptImagePath
        )

        if (editingExpenseId != null) {
            repo.update(expense)
        } else {
            repo.insert(expense)
        }
        _saveResult.value = SaveResult.Success
    }

    fun resetResult() {
        _saveResult.value = null
    }
}

// Klasa pomocnicza do obsługi stanów zapisu
sealed class SaveResult {
    object Success : SaveResult()
    data class Error(val message: String) : SaveResult()
    data class Loaded(val expense: Expense) : SaveResult()
}
