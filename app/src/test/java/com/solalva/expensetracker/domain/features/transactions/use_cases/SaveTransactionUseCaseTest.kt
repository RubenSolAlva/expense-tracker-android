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
        internal const val amountMocked = 0F
        internal const val accountIdMocked = 0
        internal const val transactionCategoryIdMocked = 0
    }

    private val transactionTypeMocked = TransactionType.EXPENSE
    private val accountMocked = mockk<Account> {
        every { id } returns accountIdMocked
    }
    private val transactionCategoryMocked = mockk<TransactionCategory> {
        every { id } returns transactionCategoryIdMocked
        every { transactionType } returns transactionTypeMocked
    }
    private val transactionsRepository = mockkClass(ITransactionsRepository::class){
        coEvery { saveTransaction(any(), any(), any()) } returns Unit
    }
    private val saveTransactionUseCase = SaveTransactionUseCase(transactionsRepository)

    @Test
    fun `On invoke SaveTransactionUseCase should call repository to save transaction`() {
        runBlocking { saveTransactionUseCase(accountMocked, transactionCategoryMocked, amountMocked) }

        coVerify { transactionsRepository.saveTransaction(any(), any(), any()) }
    }
}
