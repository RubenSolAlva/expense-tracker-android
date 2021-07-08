package com.solalva.expensetracker.domain.features.transactions

import java.util.Date

interface ITransactionsRepository {
    suspend fun saveTransaction(
        financialAccountId: Int,
        transactionCategoryId: Int,
        amount: Float,
        time: Long = Date().time
    )
}
