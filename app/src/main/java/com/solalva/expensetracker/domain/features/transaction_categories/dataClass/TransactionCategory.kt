package com.solalva.expensetracker.domain.features.transaction_categories.dataClass

import com.solalva.expensetracker.domain.features.transaction_categories.enums.TransactionType

data class TransactionCategory(
    val id: Int,
    val name: String,
    val transactionType: TransactionType
)
