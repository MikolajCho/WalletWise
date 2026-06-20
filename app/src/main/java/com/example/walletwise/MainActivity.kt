package com.example.walletwise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.work.*
import com.example.walletwise.databinding.ActivityMainBinding
import com.example.walletwise.utils.DateUtils
import com.example.walletwise.worker.DailyReminderWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Konfiguracja nawigacji
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Podpięcie BottomNavigation
        binding.bottomNavigation.setupWithNavController(navController)

        // Uruchomienie powiadomień codziennych
        scheduleDailyReminder()

        // Obsługa kliknięcia w powiadomienie
        if (intent.getBooleanExtra("open_add", false)) {
            navController.navigate(R.id.addExpenseFragment)
        }
    }

    private fun scheduleDailyReminder() {
        val request = PeriodicWorkRequestBuilder<DailyReminderWorker>(1, TimeUnit.DAYS)
            .setInitialDelay(DateUtils.msUntil20h(), TimeUnit.MILLISECONDS)
            .setConstraints(Constraints.Builder().build())
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "daily_reminder",
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }
}
