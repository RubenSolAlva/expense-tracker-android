package com.solalva.expensetracker.presentation.features.main.models

import com.solalva.expensetracker.R

data class TransactionIcon(
    val transactionIcon: Int
)

val transactionIconStatus: Map<String, TransactionIcon> =
    mapOf(
        "Tax" to TransactionIcon(
            transactionIcon = R.drawable.ic_tax
        ),
        "Grocery" to TransactionIcon(
            transactionIcon = R.drawable.ic_grocery
        ),
        "Entertainment" to TransactionIcon(
            transactionIcon = R.drawable.ic_entertainment
        ),
        "Gym" to TransactionIcon(
            transactionIcon = R.drawable.ic_gym
        ),
        "Health" to TransactionIcon(
            transactionIcon = R.drawable.ic_health
        ),
        "Salary" to TransactionIcon(
            transactionIcon = R.drawable.ic_salary
        ),
        "Dividends" to TransactionIcon(
            transactionIcon = R.drawable.ic_dividend
        )
    )
