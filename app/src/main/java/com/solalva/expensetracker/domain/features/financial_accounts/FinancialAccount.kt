package com.solalva.expensetracker.domain.features.financial_accounts

import com.solalva.expensetracker.domain.features.transactions.Transaction

data class FinancialAccount(
    val account: Account,
    val transactions: List<Transaction>,
    val balance: Float
)
