package com.solalva.expensetracker.data.features.financial_accounts.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.solalva.expensetracker.data.features.transactions.entities.TransactionChildEntity
import com.solalva.expensetracker.data.features.transactions.entities.TransactionEntity
import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.FinancialAccount

data class FinancialAccountEntity(
    @Embedded
    val account: AccountEntity,
    @Relation(parentColumn = "id", entityColumn = "financialAccountId", entity = TransactionEntity::class)
    val transactions: List<TransactionChildEntity>
) {

    fun transform() = FinancialAccount(
        account.transform(),
        transactions.map { it.transform() },
        transactions.map { it.transaction.amount }.sum()
    )
}
