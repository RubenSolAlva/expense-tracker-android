package com.solalva.expensetracker.domain.features.financialAccounts.useCases

import com.solalva.expensetracker.domain.features.financialAccounts.IFinancialAccountsRepository
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.FinancialAccount
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetFinancialAccountsUseCaseTest {

    private val financialAccountListMocked = listOf<FinancialAccount>()
    private val financialAccountsRepository = mockkClass(IFinancialAccountsRepository::class){
        coEvery { getFinancialAccounts() } returns financialAccountListMocked
    }
    private val getFinancialAccountsUseCase = GetFinancialAccountsUseCase(financialAccountsRepository)

    @Test
    fun `On invoke GetFinancialAccountsUseCase should return a list of FinancialAccount`() {
        val result = runBlocking { getFinancialAccountsUseCase() }

        coVerify { financialAccountsRepository.getFinancialAccounts() }
        assertEquals(financialAccountListMocked, result)
    }
}
