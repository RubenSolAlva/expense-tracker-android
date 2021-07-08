package com.solalva.expensetracker.data.features.financialAccounts

import com.solalva.expensetracker.data.features.financialAccounts.dao.FinancialAccountDao
import com.solalva.expensetracker.data.features.financialAccounts.entities.AccountEntity
import com.solalva.expensetracker.data.features.financialAccounts.entities.FinancialAccountEntity
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.FinancialAccount
import io.mockk.every
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class FinancialAccountsRepositoryTest {

    private val financialAccountMocked = mockk<FinancialAccount>()
    private val financialAccountEntityMocked = mockk<FinancialAccountEntity> {
        every { transform() } returns financialAccountMocked
    }

    private val accountMocked = mockk<Account>()
    private val accountEntityMocked = mockk<AccountEntity> {
        every { transform() } returns accountMocked
    }

    private val financialAccountDao = mockkClass(FinancialAccountDao::class) {
        coEvery { getAccounts() } returns listOf(accountEntityMocked)
        coEvery { getFinancialAccounts() } returns listOf(financialAccountEntityMocked)
    }
    private val financialAccountsRepository = FinancialAccountsRepository(financialAccountDao)

    @Test
    fun `On invoke getAccounts from FinancialAccountsRepository should return a list of Account`() {
        val result = runBlocking { financialAccountsRepository.getAccounts() }

        coVerify { financialAccountDao.getAccounts() }
        Assert.assertEquals(accountMocked, result[0])
    }

    @Test
    fun `On invoke getFinancialAccounts from FinancialAccountsRepository should return a list of FinancialAccount`() {
        val result = runBlocking { financialAccountsRepository.getFinancialAccounts() }

        coVerify { financialAccountDao.getFinancialAccounts() }
        Assert.assertEquals(financialAccountMocked, result[0])
    }
}
