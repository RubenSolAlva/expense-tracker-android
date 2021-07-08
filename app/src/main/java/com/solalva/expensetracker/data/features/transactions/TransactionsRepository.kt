package com.solalva.expensetracker.data.features.transactions

import com.solalva.expensetracker.data.features.transactions.dao.TransactionDao
import com.solalva.expensetracker.data.features.transactions.entities.TransactionEntity
import com.solalva.expensetracker.domain.features.transactions.ITransactionsRepository

class TransactionsRepository (
    private val transactionDao: TransactionDao
) : ITransactionsRepository {

    override suspend fun saveTransaction(
        financialAccountId: Int,
        transactionCategoryId: Int,
        amount: Float,
        time: Long
    ) {
        val transaction = TransactionEntity(
            financialAccountId = financialAccountId,
            transactionCategoryId = transactionCategoryId,
            amount = amount,
            time = time
        )
        transactionDao.insert(transaction)
    }
}
