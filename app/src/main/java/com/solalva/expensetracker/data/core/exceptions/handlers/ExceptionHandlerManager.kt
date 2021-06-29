package com.solalva.expensetracker.data.core.exceptions.handlers

import  com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler

// LogExceptionHandler Implemented but you can implement others:
//  - Firebase
//  - AppDynamics
//  - MixPannel ...

class ExceptionHandlerManager(private val exceptionHandlers: List<ExceptionHandler>) :
    ExceptionHandler {
    override fun handleException(exception: Throwable) =
        exceptionHandlers.forEach { it.handleException(exception) }
}
