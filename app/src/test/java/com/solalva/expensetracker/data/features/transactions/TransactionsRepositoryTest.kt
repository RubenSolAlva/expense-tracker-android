package com.solalva.expensetracker.data.features.transactions

import com.solalva.expensetracker.data.features.transactions.dao.TransactionDao
import com.solalva.expensetracker.data.features.transactions.entities.TransactionEntity
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TransactionsRepositoryTest {

    companion object {
        private const val FINANCIAL_ACCOUNT_ID_MOCKED = 0
        private const val TRANSACTION_CATEGORY_ID_MOCKED = 0
        private const val AMOUNT_MOCKED = 0F
        private const val TIME_MOCKED = 0L
    }

    private val transactionEntityMock = mockk<TransactionEntity>{
       every { financialAccountId } returns FINANCIAL_ACCOUNT_ID_MOCKED
       every { transactionCategoryId } returns TRANSACTION_CATEGORY_ID_MOCKED
       every { amount } returns AMOUNT_MOCKED
       every { time } returns TIME_MOCKED
    }
    private val transactionDao = mockkClass(TransactionDao::class){
        every { insert(any()) } returns Unit
    }
    private val transactionsRepository = TransactionsRepository(transactionDao)

    @Test
    fun `On invoke saveTransaction from TransactionsRepository should call TransactionDao insert`() {
        runBlocking {
            transactionsRepository.saveTransaction(
                FINANCIAL_ACCOUNT_ID_MOCKED,
                TRANSACTION_CATEGORY_ID_MOCKED,
                AMOUNT_MOCKED,
                TIME_MOCKED
            )
        }
        coVerify { transactionDao.insert(eq(transactionEntityMock)) }
    }
}
