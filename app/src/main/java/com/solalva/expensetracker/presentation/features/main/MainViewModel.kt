package com.solalva.expensetracker.presentation.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import com.solalva.expensetracker.domain.features.financial_accounts.dataClass.FinancialAccount
import com.solalva.expensetracker.domain.features.financial_accounts.useCases.GetFinancialAccountsUseCase
import com.solalva.expensetracker.presentation.core.base.BaseViewModel
import com.solalva.expensetracker.presentation.core.lifecycle.Event
import com.solalva.expensetracker.presentation.core.models.FinancialAccountModel
import com.solalva.expensetracker.presentation.core.models.transform
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getFinancialAccountsUseCase: GetFinancialAccountsUseCase,
    exceptionHandler: ExceptionHandler
) : BaseViewModel(exceptionHandler) {

    private val _navigateToTransaction: MutableLiveData<Event<Unit>> = MutableLiveData()
    val navigateToTransaction: LiveData<Event<Unit>> = _navigateToTransaction

    private val _financialAccounts: MutableLiveData<List<FinancialAccount>> =
        MutableLiveData(emptyList())
    val financialAccounts: LiveData<List<FinancialAccountModel>> =
        Transformations.map(_financialAccounts) {
            it.map(FinancialAccount::transform)
        }

    // USE CASE CALLS
    fun getFinancialAccounts() = launch(Dispatchers.Main) {
        _financialAccounts.value = withContext(Dispatchers.IO) { getFinancialAccountsUseCase() }
    }

    // LISTENERS
    fun onTransactionClickEvent() {
        _navigateToTransaction.value = Event(Unit)
    }
}
