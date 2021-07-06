package com.solalva.expensetracker.domain.features.transactionCategories.useCases

import com.solalva.expensetracker.domain.features.transactionCategories.ITransactionCategoriesRepository
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetTransactionCategoriesByTransactionTypeUseCaseTest {

    private val transactionTypeMocked = TransactionType.EXPENSE
    private val transactionCategoryListMocked = listOf<TransactionCategory>()
    private val transactionCategoriesRepository =
        mockkClass(ITransactionCategoriesRepository::class) {
            coEvery { getTransactionCategoriesByTransactionType(any()) } returns transactionCategoryListMocked
        }
    private val getTransactionCategoriesByTransactionTypeUseCase =
        GetTransactionCategoriesByTransactionTypeUseCase(transactionCategoriesRepository)

    @Test
    fun `On invoke GetTransactionCategoriesByTransactionTypeUseCase should return a list of TransactionCategory`() {
        val result =
            runBlocking { getTransactionCategoriesByTransactionTypeUseCase(transactionTypeMocked) }

        coVerify { transactionCategoriesRepository.getTransactionCategoriesByTransactionType(any()) }
        assertEquals(transactionCategoryListMocked, result)
    }
}
