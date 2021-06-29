package com.solalva.expensetracker.presentation.features.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import com.solalva.expensetracker.presentation.core.base.BaseViewModel
import com.solalva.expensetracker.presentation.core.lifecycle.Event

class TransactionViewModel(
    exceptionHandler: ExceptionHandler
) : BaseViewModel(exceptionHandler) {

    private val _navigateToBack: MutableLiveData<Event<Unit>> = MutableLiveData()
    val navigateToBack: LiveData<Event<Unit>> = _navigateToBack
}
