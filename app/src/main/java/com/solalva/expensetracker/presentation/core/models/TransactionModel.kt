package com.solalva.expensetracker.presentation.core.models

import com.solalva.expensetracker.domain.features.transactions.dataClass.Transaction
import java.util.Date

data class TransactionModel(
    val id: Int,
    val transactionCategory: TransactionCategoryModel,
    val amount: Float,
    val time: Date
)

fun Transaction.transform() = TransactionModel(
    id,
    transactionCategory.transform(),
    amount,
    time
)
