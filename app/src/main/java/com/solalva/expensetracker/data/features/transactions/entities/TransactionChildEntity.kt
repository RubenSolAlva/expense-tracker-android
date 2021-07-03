package com.solalva.expensetracker.data.features.transactions.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.solalva.expensetracker.data.features.transaction_categories.entities.TransactionCategoryEntity
import com.solalva.expensetracker.domain.features.transactions.dataClass.Transaction
import java.util.Date

data class TransactionChildEntity(
    @Embedded
    val transaction: TransactionEntity,
    @Relation(parentColumn = "transactionCategoryId", entityColumn = "id")
    val transactionCategory: TransactionCategoryEntity
) {
    fun transform() = Transaction(
        transaction.id,
        transactionCategory.transform(),
        transaction.amount,
        Date(transaction.time)
    )
}
