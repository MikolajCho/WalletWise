package com.example.walletwise.ui.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.walletwise.WalletWiseApplication
import com.example.walletwise.data.model.Expense
import kotlinx.coroutines.launch

class ExpenseDetailViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = (app as WalletWiseApplication).repository

    // Pojedynczy wydatek
    private val _expense = MutableLiveData<Expense?>()
    val expense: LiveData<Expense?> = _expense

    // Flaga usunięcia
    private val _deleted = MutableLiveData(false)
    val deleted: LiveData<Boolean> = _deleted

    fun loadExpense(id: Long) = viewModelScope.launch {
        _expense.value = repo.getExpenseById(id)
    }

    fun delete() = viewModelScope.launch {
        _expense.value?.let {
            repo.delete(it)
            _deleted.value = true
        }
    }
}
