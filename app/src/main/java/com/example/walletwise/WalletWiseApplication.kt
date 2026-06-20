package com.example.walletwise

import android.app.Application
import com.example.walletwise.data.db.AppDatabase
import com.example.walletwise.data.repository.ExpenseRepository
import com.example.walletwise.utils.NotificationHelper

class WalletWiseApplication : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { ExpenseRepository(database) }

    override fun onCreate() {
        super.onCreate()
        NotificationHelper.createNotificationChannel(this)
    }
}
