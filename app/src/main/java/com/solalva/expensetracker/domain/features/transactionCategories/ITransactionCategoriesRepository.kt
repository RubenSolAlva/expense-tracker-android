package com.solalva.expensetracker.domain.features.transactionCategories

import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType

interface ITransactionCategoriesRepository {
    suspend fun getTransactionCategoriesByTransactionType(
        transactionType: TransactionType
    ): List<TransactionCategory>
}