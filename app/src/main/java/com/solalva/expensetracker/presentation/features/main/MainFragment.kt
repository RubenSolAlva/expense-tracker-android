package com.solalva.expensetracker.presentation.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.solalva.expensetracker.databinding.MainFragmentBinding
import com.solalva.expensetracker.presentation.core.lifecycle.observeEvent
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
    }

    private fun observers() {
        observeEvent(viewModel.navigateToTransaction) { navigateToTransaction() }
    }

    private fun navigateToTransaction() =
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToTransactionFragment()
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
