package com.solalva.expensetracker.domain.features.financialAccounts.useCases

import com.solalva.expensetracker.domain.features.financialAccounts.IFinancialAccountsRepository
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.FinancialAccount

class GetFinancialAccountsUseCase(
    private val financialAccountsRepository: IFinancialAccountsRepository
) {
    suspend operator fun invoke(): List<FinancialAccount> =
        financialAccountsRepository.getFinancialAccounts()
}
