package com.solalva.expensetracker.domain.features.transaction_categories

import com.solalva.expensetracker.domain.features.transaction_categories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transaction_categories.enums.TransactionType

interface ITransactionCategoriesRepository {
    suspend fun getTransactionCategoriesByTransactionType(
        transactionType: TransactionType
    ): List<TransactionCategory>
}