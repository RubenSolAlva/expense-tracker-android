package com.solalva.expensetracker.presentation.features.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.solalva.expensetracker.domain.core.exceptions.ExceptionHandler
import com.solalva.expensetracker.domain.features.financialAccounts.dataClass.Account
import com.solalva.expensetracker.domain.features.financialAccounts.useCases.GetAccountsUseCase
import com.solalva.expensetracker.domain.features.transactionCategories.dataClass.TransactionCategory
import com.solalva.expensetracker.domain.features.transactionCategories.enums.TransactionType
import com.solalva.expensetracker.domain.features.transactionCategories.useCases.GetTransactionCategoriesByTransactionTypeUseCase
import com.solalva.expensetracker.domain.features.transactions.useCases.SaveTransactionUseCase
import com.solalva.expensetracker.presentation.core.base.BaseViewModel
import com.solalva.expensetracker.presentation.core.lifecycle.Event
import com.solalva.expensetracker.presentation.core.models.AccountModel
import com.solalva.expensetracker.presentation.core.models.TransactionCategoryModel
import com.solalva.expensetracker.presentation.core.models.TransactionTypeModel
import com.solalva.expensetracker.presentation.core.models.transform
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionViewModel(
    private val getAccountsUseCase: GetAccountsUseCase,
    private val getTransactionCategoriesByTransactionTypeUseCase: GetTransactionCategoriesByTransactionTypeUseCase,
    private val saveTransactionUseCase: SaveTransactionUseCase,
    exceptionHandler: ExceptionHandler
) : BaseViewModel(exceptionHandler) {

    private val _navigateToBack: MutableLiveData<Event<Unit>> = MutableLiveData()
    val navigateToBack: LiveData<Event<Unit>> = _navigateToBack

    private val _accounts: MutableLiveData<List<Account>> = MutableLiveData(emptyList())
    val accounts: LiveData<List<AccountModel>> = Transformations.map(_accounts) {
        it.map(Account::transform)
    }

    private val _transactionCategoryType: MutableLiveData<TransactionType> =
        MutableLiveData(TransactionType.EXPENSE)
    val transactionCategoryType: LiveData<TransactionTypeModel> =
        Transformations.map(_transactionCategoryType) { transform(it) }

    private val _transactionCategories: MutableLiveData<List<TransactionCategory>> =
        MutableLiveData(emptyList())
    val transactionCategories: LiveData<List<TransactionCategoryModel>> =
        Transformations.map(_transactionCategories) {
            it.map(TransactionCategory::transform)
        }

    private val _accountError: MutableLiveData<Boolean> = MutableLiveData(false)
    val accountError: LiveData<Boolean> = _accountError

    private val _transactionCategoryError: MutableLiveData<Boolean> = MutableLiveData(false)
    val transactionCategoryError: LiveData<Boolean> = _transactionCategoryError

    private val _amountError: MutableLiveData<Boolean> = MutableLiveData(false)
    val amountError: LiveData<Boolean> = _amountError

    private var accountSelected: Account? = null
    private var transactionCategorySelected: TransactionCategory? = null
    private var amountSet: Float? = null

    init {
        getAccounts()
        getTransactionCategories()
    }

    // LISTENERS
    fun onSaveClickEvent() {
        val account = checkAccount()
        val transactionCategory = checkTransactionCategory()
        val amount = checkAmount()
        if (account == null || transactionCategory == null || amount == null) return
        saveTransaction(account, transactionCategory, amount)
        _navigateToBack.value = Event(Unit)
    }

    fun onExpenseClickEvent() = updateTransactionCategoryType(TransactionType.EXPENSE)

    fun onIncomeClickEvent() = updateTransactionCategoryType(TransactionType.INCOME)

    fun onAccountSelectedEvent(accountId: Int) {
        accountSelected = _accounts.value?.find { account -> account.id == accountId }
        checkAccount()
    }

    fun onTransactionCategorySelectedEvent(transactionCategoryId: Int) {
        transactionCategorySelected = _transactionCategories.value?.find { transactionCategory ->
            transactionCategory.id == transactionCategoryId
        }
        checkTransactionCategory()
    }

    fun onAmountChangeEvent(amountText: String) {
        amountSet = amountText.toFloatOrNull()
        checkAmount()
    }

    //CHECKERS
    private fun checkAccount(): Account? {
        if (accountSelected?.id == null) {
            _accountError.value = true
            return null
        }
        _accountError.value = false
        return accountSelected
    }

    private fun checkTransactionCategory(): TransactionCategory? {
        if (transactionCategorySelected?.id == null) {
            _transactionCategoryError.value = true
            return null
        }
        _transactionCategoryError.value = false
        return transactionCategorySelected
    }

    private fun checkAmount(): Float? {
        _amountError.value = amountSet == null || amountSet == 0F
        return amountSet
    }

    private fun updateTransactionCategoryType(transactionCategoryType: TransactionType) {
        if (_transactionCategoryType.value == transactionCategoryType) return
        _transactionCategoryType.value = transactionCategoryType
        transactionCategorySelected = null
        getTransactionCategories()
    }

    // USE CASE CALLS
    private fun saveTransaction(
        account: Account,
        transactionCategory: TransactionCategory,
        amount: Float
    ) =
        launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                saveTransactionUseCase(
                    account,
                    transactionCategory,
                    amount
                )
            }
        }

    private fun getAccounts() = launch(Dispatchers.Main) {
        _accounts.value = withContext(Dispatchers.IO) { getAccountsUseCase() }
    }

    private fun getTransactionCategories() = launch(Dispatchers.Main) {
        val transactionCategoryType = _transactionCategoryType.value ?: TransactionType.EXPENSE
        _transactionCategories.value = withContext(Dispatchers.IO) {
            getTransactionCategoriesByTransactionTypeUseCase(transactionCategoryType)
        }
    }
}
