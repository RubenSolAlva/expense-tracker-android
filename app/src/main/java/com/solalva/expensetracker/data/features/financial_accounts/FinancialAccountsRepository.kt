package com.solalva.expensetracker.data.features.financial_accounts

import com.solalva.expensetracker.data.features.financial_accounts.dao.FinancialAccountDao
import com.solalva.expensetracker.data.features.financial_accounts.entities.AccountEntity
import com.solalva.expensetracker.data.features.financial_accounts.entities.FinancialAccountEntity
import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.Account
import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.FinancialAccount
import com.solalva.expensetracker.domain.features.financial_accounts.IFinancialAccountsRepository

class FinancialAccountsRepository (
    private val financialAccountDao: FinancialAccountDao
) : IFinancialAccountsRepository {

    override suspend fun getAccounts(): List<Account> =
        financialAccountDao.getAccounts().map(AccountEntity::transform)

    override suspend fun getFinancialAccounts(): List<FinancialAccount> =
        financialAccountDao.getFinancialAccounts().map(FinancialAccountEntity::transform)
}
