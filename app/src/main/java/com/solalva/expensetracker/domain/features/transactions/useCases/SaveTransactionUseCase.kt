package com.solalva.expensetracker.domain.features.transactions.useCases

import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType
import com.solalva.expensetracker.domain.features.transactions.ITransactionsRepository

class SaveTransactionUseCase(
    private val transactionsRepository: ITransactionsRepository
) {
    suspend operator fun invoke(
        account: Account,
        transactionCategory: TransactionCategory,
        amount: Float
    ) = transactionsRepository.saveTransaction(
        account.id,
        transactionCategory.id,
        transformAmount(amount, transactionCategory.transactionType)
    )

    private fun transformAmount(
        amount: Float,
        transactionType: TransactionType
    ): Float = when {
        transactionType == TransactionType.EXPENSE && amount >= 0 -> amount * -1
        transactionType == TransactionType.INCOME && amount <= 0 -> amount * -1
        else -> amount
    }
}
