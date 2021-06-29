package com.solalva.expensetracker.data.features.financial_accounts.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.solalva.expensetracker.data.features.financial_accounts.entities.AccountEntity
import com.solalva.expensetracker.data.features.financial_accounts.entities.FinancialAccountEntity

@Dao
interface FinancialAccountDao {
    @Query("SELECT * FROM financial_accounts")
    fun getAccounts(): List<AccountEntity>

    @Transaction
    @Query("SELECT * FROM financial_accounts")
    fun getFinancialAccounts(): List<FinancialAccountEntity>
}
