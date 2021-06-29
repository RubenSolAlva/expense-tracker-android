package com.solalva.expensetracker.di

import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import org.koin.dsl.module
import com.solalva.expensetracker.data.core.exceptions.handlers.ExceptionHandlerManager
import com.solalva.expensetracker.data.core.exceptions.handlers.LogExceptionHandler

val expenseTrackerModule = module {
    // Exceptions
    single<ExceptionHandler> { ExceptionHandlerManager(listOf(LogExceptionHandler())) }
}
