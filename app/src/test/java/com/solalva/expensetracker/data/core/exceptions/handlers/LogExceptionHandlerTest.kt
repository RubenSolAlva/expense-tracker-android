package com.solalva.expensetracker.data.core.exceptions.handlers

import android.util.Log
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import org.junit.Test

class LogExceptionHandlerTest {

    companion object{
        internal const val tag = "Tag"
    }

    private val exception = mockk<Exception>(relaxed = true)

    @Test
    fun `On invoke handleException from LogExceptionHandler should handle exception by Log`() {
        val logExceptionHandler = LogExceptionHandler(tag)
        mockkStatic(Log::class)
        every { Log.e(any(), any(), any()) } returns 0

        logExceptionHandler.handleException(exception)

        verify { Log.e(tag, exception.message, exception) }
        unmockkStatic(Log::class)
    }
}
