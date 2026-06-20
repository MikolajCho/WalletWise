package com.example.walletwise.data.repository

import com.example.walletwise.data.db.AppDatabase
import com.example.walletwise.data.db.CategoryTotal
import com.example.walletwise.data.model.Expense

class ExpenseRepository(db: AppDatabase) {

    private val dao = db.expenseDao()

    // Wszystkie funkcje są proste: wołają bazę i zwracają wynik
    suspend fun getAllExpenses(): List<Expense> = dao.getAllExpenses()

    suspend fun getExpensesByMonth(start: Long, end: Long): List<Expense> =
        dao.getExpensesByMonth(start, end)

    suspend fun getExpenseById(id: Long): Expense? = dao.getExpenseById(id)

    suspend fun getCategoryTotalsForMonth(start: Long, end: Long): List<CategoryTotal> =
        dao.getCategoryTotalsForMonth(start, end)

    suspend fun insert(expense: Expense) = dao.insert(expense)
    suspend fun update(expense: Expense) = dao.update(expense)
    suspend fun delete(expense: Expense) = dao.delete(expense)
}
