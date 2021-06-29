package com.solalva.expensetracker.data.core.exceptions.handlers

import android.util.Log
import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler

class LogExceptionHandler(private val tag: String = "LogExceptionHandler") : ExceptionHandler {
    override fun handleException(exception: Throwable) {
        Log.e(tag, exception.message, exception)
    }
}
