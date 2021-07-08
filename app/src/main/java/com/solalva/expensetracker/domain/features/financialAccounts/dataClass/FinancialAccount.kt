package com.solalva.expensetracker.domain.features.financialAccounts.dataClass

import com.solalva.expensetracker.domain.features.transactions.dataClass.Transaction

data class FinancialAccount(
    val account: Account,
    val transactions: List<Transaction>,
    val balance: Float
)
