package com.solalva.expensetracker.data.core.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.solalva.expensetracker.data.features.financialAccounts.dao.FinancialAccountDao
import com.solalva.expensetracker.data.features.financialAccounts.entities.AccountEntity
import com.solalva.expensetracker.data.features.transactionCategories.dao.TransactionCategoryDao
import com.solalva.expensetracker.data.features.transactionCategories.entities.TransactionCategoryEntity
import com.solalva.expensetracker.data.features.transactions.dao.TransactionDao
import com.solalva.expensetracker.data.features.transactions.entities.TransactionEntity

@Database(
    entities = [
        AccountEntity::class,
        TransactionCategoryEntity::class,
        TransactionEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun financialAccountDao(): FinancialAccountDao
    abstract fun transactionCategoryDao(): TransactionCategoryDao
    abstract fun transactionDao(): TransactionDao
}
