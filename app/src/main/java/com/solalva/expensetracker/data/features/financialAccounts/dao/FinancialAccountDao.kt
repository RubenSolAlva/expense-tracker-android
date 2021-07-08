package com.solalva.expensetracker.data.features.financialAccounts.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.solalva.expensetracker.data.features.financialAccounts.entities.AccountEntity
import com.solalva.expensetracker.data.features.financialAccounts.entities.FinancialAccountEntity

@Dao
interface FinancialAccountDao {
    @Query("SELECT * FROM financial_accounts")
    fun getAccounts(): List<AccountEntity>

    @Transaction
    @Query("SELECT * FROM financial_accounts")
    fun getFinancialAccounts(): List<FinancialAccountEntity>
}
