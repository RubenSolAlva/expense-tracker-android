package com.solalva.expensetracker.data.features.transactionCategories

import com.solalva.expensetracker.data.features.transactionCategories.dao.TransactionCategoryDao
import com.solalva.expensetracker.data.features.transactionCategories.entities.TransactionCategoryEntity
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.every
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TransactionCategoriesRepositoryTest {

    private val transactionTypeMocked = TransactionType.EXPENSE
    private val transactionCategoryMocked = mockk<TransactionCategory>()
    private val transactionCategoryEntityMocked = mockk<TransactionCategoryEntity> {
        every { transform() } returns transactionCategoryMocked
    }
    private val transactionCategoryDao = mockkClass(TransactionCategoryDao::class) {
        coEvery { getByTransactionType(any()) } returns listOf(transactionCategoryEntityMocked)
    }
    private val transactionCategoriesRepository =
        TransactionCategoriesRepository(transactionCategoryDao)

    @Test
    fun `On invoke getTransactionCategoriesByTransactionType from TransactionCategoriesRepository should return a list of TransactionCategory`() {
        val result = runBlocking {
            transactionCategoriesRepository.getTransactionCategoriesByTransactionType(
                transactionTypeMocked
            )
        }

        coVerify { transactionCategoryDao.getByTransactionType(any()) }
        Assert.assertEquals(transactionCategoryMocked, result[0])
    }
}
