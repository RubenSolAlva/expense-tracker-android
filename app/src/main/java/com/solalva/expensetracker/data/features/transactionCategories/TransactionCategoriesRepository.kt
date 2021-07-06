package com.solalva.expensetracker.data.features.transactionCategories

import com.solalva.expensetracker.data.features.transactionCategories.dao.TransactionCategoryDao
import com.solalva.expensetracker.data.features.transactionCategories.entities.TransactionCategoryEntity
import com.solalva.expensetracker.data.features.transactionCategories.entities.transform
import com.solalva.expensetracker.domain.features.transactionCategories.ITransactionCategoriesRepository
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType

class TransactionCategoriesRepository(
    private val transactionCategoryDao: TransactionCategoryDao
) : ITransactionCategoriesRepository {

    override suspend fun getTransactionCategoriesByTransactionType(
        transactionType: TransactionType
    ): List<TransactionCategory> =
        transactionCategoryDao.getByTransactionType(transactionType.transform())
            .map(TransactionCategoryEntity::transform)
}
