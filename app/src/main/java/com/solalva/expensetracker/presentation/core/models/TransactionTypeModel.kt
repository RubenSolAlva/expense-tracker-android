package com.solalva.expensetracker.presentation.core.models

import com.solalva.expensetracker.domain.features.transaction_categories.enums.TransactionType


enum class TransactionTypeModel {
    EXPENSE,
    INCOME
}

fun transform(transactionType: TransactionType) = when (transactionType) {
    TransactionType.EXPENSE -> TransactionTypeModel.EXPENSE
    TransactionType.INCOME -> TransactionTypeModel.INCOME
}
