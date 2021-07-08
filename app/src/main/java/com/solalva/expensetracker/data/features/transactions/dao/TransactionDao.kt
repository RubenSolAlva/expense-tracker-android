package com.solalva.expensetracker.data.features.transactions.dao

import androidx.room.Dao
import androidx.room.Insert
import com.solalva.expensetracker.data.features.transactions.entities.TransactionEntity

@Dao
interface TransactionDao {
    @Insert
    fun insert(vararg transaction: TransactionEntity)
}
