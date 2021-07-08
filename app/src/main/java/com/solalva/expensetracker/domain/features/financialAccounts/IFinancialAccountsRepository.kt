package com.solalva.expensetracker.domain.features.financialAccounts

import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.FinancialAccount

interface IFinancialAccountsRepository  {
    suspend fun getAccounts(): List<Account>
    suspend fun getFinancialAccounts(): List<FinancialAccount>
}
