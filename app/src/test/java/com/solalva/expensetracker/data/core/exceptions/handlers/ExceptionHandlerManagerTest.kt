package com.solalva.expensetracker.data.core.exceptions.handlers

import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class ExceptionHandlerManagerTest {

    private val exception = mockk<Exception>()
    private val firstHandlerMocked = mockk<ExceptionHandler>(relaxed = true)
    private val secondHandlerMocked = mockk<ExceptionHandler>(relaxed = true)

    private val exceptionHandlers = listOf(firstHandlerMocked, secondHandlerMocked)
    private val exceptionHandlerManager = ExceptionHandlerManager(exceptionHandlers)

    @Test
    fun `On invoke handleException from ExceptionHandlerManager should call each handlers`() {
        exceptionHandlerManager.handleException(exception)

        verify { firstHandlerMocked.handleException(exception) }
        verify { secondHandlerMocked.handleException(exception) }
    }
}
