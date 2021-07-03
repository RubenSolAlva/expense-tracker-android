package com.solalva.expensetracker.domain.features.financial_accounts.useCases

import com.solalva.expensetracker.domain.features.financial_accounts.IFinancialAccountsRepository
import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.FinancialAccount

class GetFinancialAccountsUseCase(
    private val financialAccountsRepository: IFinancialAccountsRepository
) {
    suspend operator fun invoke(): List<FinancialAccount> =
        financialAccountsRepository.getFinancialAccounts()
}
