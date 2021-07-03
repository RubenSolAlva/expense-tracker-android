package com.solalva.expensetracker.domain.features.transactions.dataClass

import com.solalva.expensetracker.domain.features.transaction_categories.dataClass.TransactionCategory
import java.util.Date

data class Transaction(
    val id: Int,
    val transactionCategory: TransactionCategory,
    val amount: Float,
    val time: Date
)
