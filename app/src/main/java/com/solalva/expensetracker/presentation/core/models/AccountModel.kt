package com.solalva.expensetracker.presentation.core.models

import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.Account

data class AccountModel(
    val id: Int,
    val name: String
) {
    override fun toString(): String = name
}

fun Account.transform() = AccountModel(
    id,
    name
)
