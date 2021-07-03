package com.solalva.expensetracker.domain.features.financial_accounts.useCases

import com.solalva.expensetracker.domain.features.financial_accounts.IFinancialAccountsRepository
import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.Account

class GetAccountsUseCase(
    private val financialAccountsRepository: IFinancialAccountsRepository
) {
    suspend operator fun invoke(): List<Account> = financialAccountsRepository.getAccounts()
}
