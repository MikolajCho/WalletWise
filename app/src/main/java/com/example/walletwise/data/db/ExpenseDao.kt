package com.example.walletwise.data.db

import androidx.room.*
import com.example.walletwise.data.model.Expense

@Dao
interface ExpenseDao {

    // Zwykłe funkcje zawieszalne (suspend) - zwracają listę i koniec.
    @Query("SELECT * FROM expenses ORDER BY date DESC")
    suspend fun getAllExpenses(): List<Expense>

    @Query("SELECT * FROM expenses WHERE date BETWEEN :start AND :end ORDER BY date DESC")
    suspend fun getExpensesByMonth(start: Long, end: Long): List<Expense>

    @Query("SELECT * FROM expenses WHERE category = :category ORDER BY date DESC")
    suspend fun getExpensesByCategory(category: String): List<Expense>

    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpenseById(id: Long): Expense?

    @Query("SELECT SUM(amount) FROM expenses WHERE date BETWEEN :start AND :end")
    suspend fun getTotalForMonth(start: Long, end: Long): Double?

    @Query("""
        SELECT category, SUM(amount) as total
        FROM expenses
        WHERE date BETWEEN :start AND :end
        GROUP BY category
    """)
    suspend fun getCategoryTotalsForMonth(start: Long, end: Long): List<CategoryTotal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense): Long

    @Update
    suspend fun update(expense: Expense)

    @Delete
    suspend fun delete(expense: Expense)
}

data class CategoryTotal(
    val category: String,
    val total: Double
)
