package com.solalva.expensetracker.presentation.features.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.solalva.expensetracker.databinding.TransactionFragmentBinding
import com.solalva.expensetracker.presentation.core.extensions.closeKeyboard
import com.solalva.expensetracker.presentation.core.lifecycle.observeEvent
import org.koin.android.viewmodel.ext.android.viewModel

class TransactionFragment : Fragment() {

    private var _binding: TransactionFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TransactionViewModel by viewModel()

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
    }

    private fun observers() {
        observeEvent(viewModel.navigateToBack) { navigateToBack() }
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
