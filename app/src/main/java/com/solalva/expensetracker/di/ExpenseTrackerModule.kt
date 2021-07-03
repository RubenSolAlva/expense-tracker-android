package com.solalva.expensetracker.di

import androidx.room.Room
import com.solalva.expensetracker.data.core.dataBase.RoomDatabase
import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import org.koin.dsl.module
import com.solalva.expensetracker.data.core.exceptions.handlers.ExceptionHandlerManager
import com.solalva.expensetracker.data.core.exceptions.handlers.LogExceptionHandler
import com.solalva.expensetracker.data.features.financial_accounts.FinancialAccountsRepository
import com.solalva.expensetracker.data.features.transaction_categories.TransactionCategoriesRepository
import com.solalva.expensetracker.data.features.transactions.TransactionsRepository
import com.solalva.expensetracker.domain.features.financial_accounts.IFinancialAccountsRepository
import com.solalva.expensetracker.domain.features.transaction_categories.ITransactionCategoriesRepository
import com.solalva.expensetracker.domain.features.transactions.ITransactionsRepository
import com.solalva.expensetracker.presentation.features.main.MainViewModel
import com.solalva.expensetracker.presentation.features.transaction.TransactionViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel

private const val DATABASE_NAME = "expense-tracker_database"
private const val DATABASE_FILE_PATH = "$DATABASE_NAME.db"

val expenseTrackerModule = module {
    // Exceptions
        // LogExceptionHandler implemented but you can implement others:
            //  - Firebase
            //  - AppDynamics
            //  - MixPanel ...
    single<ExceptionHandler> { ExceptionHandlerManager(listOf(LogExceptionHandler())) }

    // DataSources (Local)
    single {
        Room.databaseBuilder(
            androidContext(),
            RoomDatabase::class.java,
            DATABASE_NAME
        ).createFromAsset(DATABASE_FILE_PATH).build()
    }
    single { get<RoomDatabase>().financialAccountDao() }
    single { get<RoomDatabase>().transactionCategoryDao() }
    single { get<RoomDatabase>().transactionDao() }

    // Repositories
    single<IFinancialAccountsRepository> { FinancialAccountsRepository(get()) }
    single<ITransactionCategoriesRepository> { TransactionCategoriesRepository(get()) }
    single<ITransactionsRepository> { TransactionsRepository(get()) }

    // UseCases

    //ViewModels
    viewModel { MainViewModel(get()) }
    viewModel { TransactionViewModel(get()) }
}
