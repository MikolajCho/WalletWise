package com.example.walletwise.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.walletwise.utils.NotificationHelper

class DailyReminderWorker(
    private val ctx: Context,
    params: WorkerParameters
) : CoroutineWorker(ctx, params) {

    override suspend fun doWork(): Result {
        NotificationHelper.showReminder(ctx)
        return Result.success()
    }
}
