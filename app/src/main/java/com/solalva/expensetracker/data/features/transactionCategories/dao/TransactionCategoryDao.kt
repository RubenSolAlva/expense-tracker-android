package com.solalva.expensetracker.data.features.transactionCategories.dao

import androidx.room.Dao
import androidx.room.Query
import com.solalva.expensetracker.data.features.transactionCategories.entities.TransactionCategoryEntity

@Dao
interface TransactionCategoryDao {
    @Query("SELECT * FROM transaction_categories WHERE transactionType = :transactionType")
    fun getByTransactionType(transactionType: Int): List<TransactionCategoryEntity>
}
