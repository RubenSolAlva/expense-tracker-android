package com.solalva.expensetracker.presentation.features.main.models

import com.solalva.expensetracker.R
import com.solalva.expensetracker.presentation.features.main.models.TransactionCategoryName.TAX
import com.solalva.expensetracker.presentation.features.main.models.TransactionCategoryName.GROCERY
import com.solalva.expensetracker.presentation.features.main.models.TransactionCategoryName.ENTERTAINMENT
import com.solalva.expensetracker.presentation.features.main.models.TransactionCategoryName.GYM
import com.solalva.expensetracker.presentation.features.main.models.TransactionCategoryName.HEALTH
import com.solalva.expensetracker.presentation.features.main.models.TransactionCategoryName.SALARY
import com.solalva.expensetracker.presentation.features.main.models.TransactionCategoryName.DIVIDENDS

data class TransactionIcon(
    val transactionIcon: Int
)

val transactionIconStatus: Map<String, TransactionIcon> =
    mapOf(
        TAX.transactionCategoryName to TransactionIcon(
            transactionIcon = R.drawable.ic_tax
        ),
        GROCERY.transactionCategoryName to TransactionIcon(
            transactionIcon = R.drawable.ic_grocery
        ),
        ENTERTAINMENT.transactionCategoryName to TransactionIcon(
            transactionIcon = R.drawable.ic_entertainment
        ),
        GYM.transactionCategoryName to TransactionIcon(
            transactionIcon = R.drawable.ic_gym
        ),
        HEALTH.transactionCategoryName to TransactionIcon(
            transactionIcon = R.drawable.ic_health
        ),
        SALARY.transactionCategoryName to TransactionIcon(
            transactionIcon = R.drawable.ic_salary
        ),
        DIVIDENDS.transactionCategoryName to TransactionIcon(
            transactionIcon = R.drawable.ic_dividend
        )
    )
