package com.solalva.expensetracker.domain.features.transactions

import com.solalva.expensetracker.domain.features.transaction_categories.TransactionCategory
import java.util.Date

data class Transaction(
    val id: Int,
    val transactionCategory: TransactionCategory,
    val amount: Float,
    val time: Date
)
