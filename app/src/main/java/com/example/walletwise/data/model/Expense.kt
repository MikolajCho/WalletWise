package com.example.walletwise.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val category: String,          // stored as Category.name
    val description: String = "",
    val date: Long,                // epoch ms
    val receiptImagePath: String? = null
)
