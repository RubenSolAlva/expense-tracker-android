package com.solalva.expensetracker.di

import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import org.koin.dsl.module
import com.solalva.expensetracker.data.core.exceptions.handlers.ExceptionHandlerManager
import com.solalva.expensetracker.data.core.exceptions.handlers.LogExceptionHandler
import com.solalva.expensetracker.presentation.features.main.MainViewModel
import com.solalva.expensetracker.presentation.features.transaction.TransactionViewModel
import org.koin.android.viewmodel.dsl.viewModel

val expenseTrackerModule = module {
    // Exceptions
    single<ExceptionHandler> { ExceptionHandlerManager(listOf(LogExceptionHandler())) }

    // DataSources

    // Repositories

    // UseCases

    //ViewModels
    viewModel { MainViewModel(get()) }
    viewModel { TransactionViewModel(get()) }
}
