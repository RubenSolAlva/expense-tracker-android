package com.solalva.expensetracker.data.features.transactions.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.solalva.expensetracker.data.features.financialAccounts.entities.AccountEntity
import com.solalva.expensetracker.data.features.transactionCategories.entities.TransactionCategoryEntity
import java.util.*

@Entity(
    tableName = "transactions",
    foreignKeys = [
        ForeignKey(
            entity = AccountEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("financialAccountId")
        ),
        ForeignKey(
            entity = TransactionCategoryEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("transactionCategoryId")
        )],
    indices = [
        Index("financialAccountId"),
        Index("transactionCategoryId")
    ]
)

data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val financialAccountId: Int,
    val transactionCategoryId: Int,
    val amount: Float,
    val time: Long = Date().time
)
