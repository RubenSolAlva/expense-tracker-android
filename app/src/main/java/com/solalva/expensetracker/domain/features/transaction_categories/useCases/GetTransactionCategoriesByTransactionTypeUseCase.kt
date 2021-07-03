package com.solalva.expensetracker.domain.features.transaction_categories.useCases

import com.solalva.expensetracker.domain.features.transaction_categories.ITransactionCategoriesRepository
import com.solalva.expensetracker.domain.features.transaction_categories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transaction_categories.enums.TransactionType

class GetTransactionCategoriesByTransactionTypeUseCase(
    private val transactionCategoriesRepository: ITransactionCategoriesRepository
) {
    suspend operator fun invoke(transactionType: TransactionType): List<TransactionCategory> =
        transactionCategoriesRepository.getTransactionCategoriesByTransactionType(transactionType)
}
