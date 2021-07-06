package com.solalva.expensetracker.domain.features.financialAccounts.useCases

import com.solalva.expensetracker.domain.features.financialAccounts.IFinancialAccountsRepository
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account

class GetAccountsUseCase(
    private val financialAccountsRepository: IFinancialAccountsRepository
) {
    suspend operator fun invoke(): List<Account> = financialAccountsRepository.getAccounts()
}
