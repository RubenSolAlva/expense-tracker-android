package com.solalva.expensetracker.data.features.transaction_categories

import com.solalva.expensetracker.data.features.transaction_categories.dao.TransactionCategoryDao
import com.solalva.expensetracker.data.features.transaction_categories.entities.TransactionCategoryEntity
import com.solalva.expensetracker.data.features.transaction_categories.entities.transform
import com.solalva.expensetracker.domain.features.transaction_categories.ITransactionCategoriesRepository
import com.solalva.expensetracker.domain.features.transaction_categories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transaction_categories.enums.TransactionType

class TransactionCategoriesRepository(
    private val transactionCategoryDao: TransactionCategoryDao
) : ITransactionCategoriesRepository {

    override suspend fun getTransactionCategoriesByTransactionType(
        transactionType: TransactionType
    ): List<TransactionCategory> =
        transactionCategoryDao.getByTransactionType(transactionType.transform())
            .map(TransactionCategoryEntity::transform)
}
