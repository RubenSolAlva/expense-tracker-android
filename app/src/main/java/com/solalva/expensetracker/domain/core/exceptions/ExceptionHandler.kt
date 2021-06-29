package com.solalva.expensetracker.domain.core.exceptions

interface ExceptionHandler {
    fun handleException(exception: Throwable)
}
