package com.solalva.expensetracker.presentation.features.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.solalva.expensetracker.R
import com.solalva.expensetracker.databinding.TransactionFragmentBinding
import com.solalva.expensetracker.presentation.core.extensions.closeKeyboard
import com.solalva.expensetracker.presentation.core.lifecycle.observe
import com.solalva.expensetracker.presentation.core.lifecycle.observeEvent
import com.solalva.expensetracker.presentation.core.models.AccountModel
import com.solalva.expensetracker.presentation.core.models.TransactionCategoryModel
import com.solalva.expensetracker.presentation.core.models.TransactionTypeModel
import org.koin.android.viewmodel.ext.android.viewModel

class TransactionFragment : Fragment() {

    private var _binding: TransactionFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TransactionViewModel by viewModel()

    companion object {
        internal const val EMPTY_STRING = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TransactionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()
        listeners()
    }

    private fun observers() {
        observe(viewModel.transactionCategoryType) { updateTransactionCategoryType(it) }
        observe(viewModel.accounts) { updateAccounts(it) }
        observe(viewModel.transactionCategories) { updateTransactionCategories(it) }
        observe(viewModel.accountError) { updateAccountError(it) }
        observe(viewModel.transactionCategoryError) { updateTransactionCategoryError(it) }
        observe(viewModel.amountError) { updateAmountError(it) }
        observeEvent(viewModel.navigateToBack) { navigateToBack() }
    }

    private fun listeners() {
        binding.transactionExpenseRadioButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked.not()) return@setOnCheckedChangeListener
            viewModel.onExpenseClickEvent()
        }
        binding.transactionIncomeRadioButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked.not()) return@setOnCheckedChangeListener
            viewModel.onIncomeClickEvent()
        }
        binding.transactionAmountEditText.doOnTextChanged { text, _, _, _ ->
            viewModel.onAmountChangeEvent(text.toString())
        }
        binding.transactionSaveButton.setOnClickListener { viewModel.onSaveClickEvent() }
    }

    private fun updateTransactionCategoryType(transactionCategoryType: TransactionTypeModel) =
        when (transactionCategoryType) {
            TransactionTypeModel.EXPENSE -> binding.transactionExpenseRadioButton.isChecked = true
            TransactionTypeModel.INCOME -> binding.transactionIncomeRadioButton.isChecked = true
        }.also {
            binding.transactionCategoriesAutocompleteTextView.setText(EMPTY_STRING)
        }

    private fun updateAccounts(accountList: List<AccountModel>) {
        val adapter = ArrayAdapter(requireContext(), R.layout.transaction_adapter_item, accountList)
        binding.transactionAccountsAutocompleteTextView.setAdapter(adapter)
        binding.transactionAccountsAutocompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val account = adapter.getItem(position)
            account?.let { viewModel.onAccountSelectedEvent(account.id) }
        }
    }

    private fun updateTransactionCategories(transactionCategoryList: List<TransactionCategoryModel>) {
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.transaction_adapter_item,
            transactionCategoryList
        )
        binding.transactionCategoriesAutocompleteTextView.setAdapter(adapter)
        binding.transactionCategoriesAutocompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val transactionCategory = adapter.getItem(position)
            transactionCategory?.let {
                viewModel.onTransactionCategorySelectedEvent(
                    transactionCategory.id
                )
            }
        }
    }

    private fun updateAccountError(accountError: Boolean) {
        if (accountError)
            binding.transactionAccountsAutocompleteTextView.error =
                getString(R.string.text_field_error)
        else binding.transactionAccountsAutocompleteTextView.error = null
    }
    
    private fun updateTransactionCategoryError(transactionCategoryError: Boolean) {
        if (transactionCategoryError)
            binding.transactionCategoriesAutocompleteTextView.error =
                getString(R.string.text_field_error)
        else binding.transactionCategoriesAutocompleteTextView.error = null
    }

    private fun updateAmountError(amountError: Boolean) {
        if (amountError)
            binding.transactionAmountEditText.error = getString(R.string.text_field_error)
        else binding.transactionAmountEditText.error = null
    }

    private fun navigateToBack() {
        closeKeyboard()
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
