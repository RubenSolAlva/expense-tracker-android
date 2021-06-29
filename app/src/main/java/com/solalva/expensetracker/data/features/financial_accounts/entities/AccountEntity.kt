package com.solalva.expensetracker.data.features.financial_accounts.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.solalva.expensetracker.domain.features.financial_accounts.Account

@Entity(tableName = "financial_accounts")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
) {
    fun transform() = Account(
        id,
        name
    )
}
