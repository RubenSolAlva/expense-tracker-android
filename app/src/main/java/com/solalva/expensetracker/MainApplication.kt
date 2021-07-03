package com.solalva.expensetracker

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.solalva.expensetracker.di.expenseTrackerModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDependencyInjection()
    }

    private fun setupDependencyInjection() = startKoin {
        androidContext(this@MainApplication)
        modules(expenseTrackerModule)
    }
}
