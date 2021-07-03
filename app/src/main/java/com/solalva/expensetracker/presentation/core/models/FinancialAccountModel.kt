package com.solalva.expensetracker.presentation.core.models

import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.FinancialAccount

data class FinancialAccountModel(
    val account: AccountModel,
    val transactions: List<TransactionModel>,
    val balance: Float
)

fun FinancialAccount.transform() = FinancialAccountModel(
    account.transform(),
    transactions.map { it.transform() },
    balance
)