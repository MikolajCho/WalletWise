package com.example.walletwise.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.walletwise.data.model.Expense

@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Jeśli INSTANCE nie jest nullem, zwróć go.
            // Jeśli jest, stwórz bazę w sposób bezpieczny dla wielu wątków (synchronized)
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "walletwise_database"
                )
                    .fallbackToDestructiveMigration() // To pozwala na reset bazy przy zmianach w kodzie
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
