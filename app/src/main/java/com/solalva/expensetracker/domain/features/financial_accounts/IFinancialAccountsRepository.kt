package com.solalva.expensetracker.domain.features.financial_accounts

import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.Account
import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.FinancialAccount

interface IFinancialAccountsRepository  {
    suspend fun getAccounts(): List<Account>
    suspend fun getFinancialAccounts(): List<FinancialAccount>
}
