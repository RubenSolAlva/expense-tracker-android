package com.solalva.expensetracker.presentation.core.models

import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory

class TransactionCategoryModel(
    val id: Int,
    val name: String,
    val transactionType: TransactionTypeModel
) {
    override fun toString(): String = name
}

fun TransactionCategory.transform() = TransactionCategoryModel(
    id,
    name,
    transform(transactionType)
)
