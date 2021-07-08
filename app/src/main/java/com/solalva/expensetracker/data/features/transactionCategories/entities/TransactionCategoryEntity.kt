package com.solalva.expensetracker.data.features.transactionCategories.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.solalva.expensetracker.data.features.transactionCategories.entities.TransactionCategoryEntity.Companion.EXPENSE_TYPE
import com.solalva.expensetracker.data.features.transactionCategories.entities.TransactionCategoryEntity.Companion.INCOME_TYPE
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType

@Entity(tableName = "transaction_categories")
data class TransactionCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val transactionType: Int
) {

    companion object {
        const val EXPENSE_TYPE = 0
        const val INCOME_TYPE = 1
    }

    fun transform() = TransactionCategory(
        id,
        name,
        transform(transactionType)
    )

    private fun transform(type: Int) = when (type) {
        EXPENSE_TYPE -> TransactionType.EXPENSE
        INCOME_TYPE -> TransactionType.INCOME
        else -> throw IllegalArgumentException("TransactionCategory not valid")
    }
}

fun TransactionType.transform() = when (this) {
    TransactionType.EXPENSE -> EXPENSE_TYPE
    TransactionType.INCOME -> INCOME_TYPE
}
