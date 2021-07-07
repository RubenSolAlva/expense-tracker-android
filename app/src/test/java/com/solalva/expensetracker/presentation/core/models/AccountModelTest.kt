package com.solalva.expensetracker.presentation.core.models

import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class AccountModelTest {

    companion object {
        internal const val ACCOUNT_ID_MOCKED = 0
        internal const val ACCOUNT_NAME_MOCKED = "Account name mocked"
    }

    private val accountMocked = mockk<Account>{
        every { id } returns ACCOUNT_ID_MOCKED
        every { name } returns ACCOUNT_NAME_MOCKED
    }

    // Model test example
    @Test
    fun `On invoke Account transform from AccountModel should return AccountModel`() {
        val result = accountMocked.transform()

        Assert.assertEquals(ACCOUNT_ID_MOCKED, result.id)
        Assert.assertEquals(ACCOUNT_NAME_MOCKED, result.name)
    }
}
