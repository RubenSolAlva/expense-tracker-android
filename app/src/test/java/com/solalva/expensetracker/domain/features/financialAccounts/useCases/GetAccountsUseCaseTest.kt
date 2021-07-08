package com.solalva.expensetracker.domain.features.financialAccounts.useCases

import com.solalva.expensetracker.domain.features.financialAccounts.IFinancialAccountsRepository
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAccountsUseCaseTest {

    private val accountListMocked = listOf<Account>()
    private val financialAccountsRepository = mockkClass(IFinancialAccountsRepository::class){
        coEvery { getAccounts() } returns accountListMocked
    }

    private val getAccountsUseCase = GetAccountsUseCase(financialAccountsRepository)

    @Test
    fun `On invoke GetAccountsUseCase should return a list of Account`() {
        val result = runBlocking { getAccountsUseCase() }

        coVerify { financialAccountsRepository.getAccounts() }
        assertEquals(accountListMocked, result)
    }
}
