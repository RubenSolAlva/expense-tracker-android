package com.solalva.expensetracker.presentation.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import com.solalva.expensetracker.presentation.core.base.BaseViewModel
import com.solalva.expensetracker.presentation.core.lifecycle.Event

class MainViewModel(
    exceptionHandler: ExceptionHandler
) : BaseViewModel(exceptionHandler) {

    private val _navigateToTransaction: MutableLiveData<Event<Unit>> = MutableLiveData()
    val navigateToTransaction: LiveData<Event<Unit>> = _navigateToTransaction

    fun onTransactionClickEvent() {
        _navigateToTransaction.value = Event(Unit)
    }
}
