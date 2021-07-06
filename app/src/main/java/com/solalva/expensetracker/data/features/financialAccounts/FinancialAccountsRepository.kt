package com.solalva.expensetracker.data.features.financialAccounts

import com.solalva.expensetracker.data.features.financialAccounts.dao.FinancialAccountDao
import com.solalva.expensetracker.data.features.financialAccounts.entities.AccountEntity
import com.solalva.expensetracker.data.features.financialAccounts.entities.FinancialAccountEntity
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.FinancialAccount
import com.solalva.expensetracker.domain.features.financialAccounts.IFinancialAccountsRepository

class FinancialAccountsRepository (
    private val financialAccountDao: FinancialAccountDao
) : IFinancialAccountsRepository {

    override suspend fun getAccounts(): List<Account> =
        financialAccountDao.getAccounts().map(AccountEntity::transform)

    override suspend fun getFinancialAccounts(): List<FinancialAccount> =
        financialAccountDao.getFinancialAccounts().map(FinancialAccountEntity::transform)
}
