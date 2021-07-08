package com.solalva.expensetracker.domain.features.transactionCategories.useCases

import com.solalva.expensetracker.domain.features.transactionCategories.ITransactionCategoriesRepository
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType

class GetTransactionCategoriesByTransactionTypeUseCase(
    private val transactionCategoriesRepository: ITransactionCategoriesRepository
) {
    suspend operator fun invoke(transactionType: TransactionType): List<TransactionCategory> =
        transactionCategoriesRepository.getTransactionCategoriesByTransactionType(transactionType)
}
