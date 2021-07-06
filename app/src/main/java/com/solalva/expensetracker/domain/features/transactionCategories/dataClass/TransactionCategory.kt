package com.solalva.expensetracker.domain.features.transactionCategories.dataClass

import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType

data class TransactionCategory(
    val id: Int,
    val name: String,
    val transactionType: TransactionType
)
