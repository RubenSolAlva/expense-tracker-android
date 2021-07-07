package com.solalva.expensetracker.domain.features.transactions.use_cases

import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType
import com.solalva.expensetracker.domain.features.transactions.ITransactionsRepository
import com.solalva.expensetracker.domain.features.transactions.useCases.SaveTransactionUseCase
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.every
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SaveTransactionUseCaseTest {

    companion object{
        internal const val AMOUNT_MOCKED = 0F
        internal const val ACCOUNT_ID_MOCKED = 0
        internal const val TRANSACTION_CATEGORY_ID_MOCKED = 0
    }

    private val transactionTypeMocked = TransactionType.EXPENSE
    private val accountMocked = mockk<Account> {
        every { id } returns ACCOUNT_ID_MOCKED
    }
    private val transactionCategoryMocked = mockk<TransactionCategory> {
        every { id } returns TRANSACTION_CATEGORY_ID_MOCKED
        every { transactionType } returns transactionTypeMocked
    }
    private val transactionsRepository = mockkClass(ITransactionsRepository::class){
        coEvery { saveTransaction(any(), any(), any()) } returns Unit
    }
    private val saveTransactionUseCase = SaveTransactionUseCase(transactionsRepository)

    @Test
    fun `On invoke SaveTransactionUseCase should call repository to save transaction`() {
        runBlocking { saveTransactionUseCase(accountMocked, transactionCategoryMocked, AMOUNT_MOCKED) }

        coVerify { transactionsRepository.saveTransaction(any(), any(), any()) }
    }
}
