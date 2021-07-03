package com.solalva.expensetracker.data.core.exceptions.handlers

import  com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler

// LogExceptionHandler implemented but you can implement others:
//  - Firebase
//  - AppDynamics
//  - MixPanel ...

class ExceptionHandlerManager(private val exceptionHandlers: List<ExceptionHandler>) :
    ExceptionHandler {
    override fun handleException(exception: Throwable) =
        exceptionHandlers.forEach { it.handleException(exception) }
}
