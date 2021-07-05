package com.solalva.expensetracker.presentation.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.solalva.expensetracker.databinding.MainFragmentBinding
import com.solalva.expensetracker.presentation.core.lifecycle.observe
import com.solalva.expensetracker.presentation.core.lifecycle.observeEvent
import com.solalva.expensetracker.presentation.core.models.FinancialAccountModel
import com.solalva.expensetracker.presentation.features.main.models.accountHeader
import com.solalva.expensetracker.presentation.features.main.models.accountTransactionItem
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()
        listeners()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchAccountsDetails()
    }

    private fun observers() {
        observe(viewModel.financialAccounts) { updateFianancialAccontsUI(it) }
        observeEvent(viewModel.navigateToTransaction) { navigateToTransaction() }
    }

    private fun listeners() {
        binding.mainFloatingActionButton.setOnClickListener { viewModel.onTransactionClickEvent() }
    }

    private fun navigateToTransaction() =
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToTransactionFragment()
        )

    private fun updateFianancialAccontsUI(financialAccountModel: List<FinancialAccountModel>) {
        binding.mainRecyclerView.withModels {
            financialAccountModel.forEach { financialAccount ->
                accountHeader {
                    id("header-${financialAccount.account.id}")
                    name(financialAccount.account.name)
                    balance(financialAccount.balance)
                }

                financialAccount.transactions.sortedByDescending { it.time }.forEach { transaction ->
                    accountTransactionItem {
                        id("transaction-${transaction.id}")
                        transactionCategoryName(transaction.transactionCategory.name)
                        amount(transaction.amount)
                        time(transaction.time)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
