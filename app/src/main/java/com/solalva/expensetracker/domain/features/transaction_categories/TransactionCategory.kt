package com.solalva.expensetracker.domain.features.transaction_categories

import com.solalva.expensetracker.domain.features.transaction_categories.enums.TransactionType

class TransactionCategory(
    val id: Int,
    val name: String,
    val transactionType: TransactionType
)
