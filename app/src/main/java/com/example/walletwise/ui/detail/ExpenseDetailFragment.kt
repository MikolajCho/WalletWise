package com.example.walletwise.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.walletwise.R
import com.example.walletwise.data.model.Category
import com.example.walletwise.databinding.FragmentExpenseDetailBinding
import com.example.walletwise.utils.CurrencyFormatter
import com.example.walletwise.utils.DateUtils
import kotlinx.coroutines.launch
import java.io.File
import android.graphics.BitmapFactory

class ExpenseDetailFragment : Fragment() {

    private var _binding: FragmentExpenseDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExpenseDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpenseDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val expenseId = arguments?.getLong("expenseId") ?: -1L
        viewModel.loadExpense(expenseId)

        binding.btnEdit.setOnClickListener {
            findNavController().navigate(
                R.id.action_detail_to_add,
                bundleOf("expenseId" to expenseId)
            )
        }

        binding.btnDelete.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Usuń wydatek")
                .setMessage("Czy na pewno chcesz usunąć ten wydatek?")
                .setPositiveButton("Usuń") { _, _ -> viewModel.delete() }
                .setNegativeButton("Anuluj", null)
                .show()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        // Obserwowanie danych wydatku
        viewModel.expense.observe(viewLifecycleOwner) { expense ->
            expense?.let { e ->
                val cat = Category.fromName(e.category)
                binding.textDetailAmount.text = CurrencyFormatter.formatShort(e.amount)
                binding.textDetailCategory.text = cat.displayName
                binding.textDetailDate.text = DateUtils.formatDate(e.date)
                binding.textDetailDescription.text = e.description.ifBlank { "—" }

                // Ładowanie zdjęcia z pliku
                if (!e.receiptImagePath.isNullOrBlank()) {
                    val file = File(e.receiptImagePath)
                    if (file.exists()) {
                        val bitmap = BitmapFactory.decodeFile(e.receiptImagePath)
                        if (bitmap != null) {
                            binding.imageDetailReceipt.setImageBitmap(bitmap)
                            binding.cardImageDetail.visibility = View.VISIBLE
                            binding.textReceiptStatus.visibility = View.GONE
                        } else {
                            showNoImage()
                        }
                    } else {
                        showNoImage()
                    }
                } else {
                    showNoImage()
                }
            }
        }

        // Obserwowanie flagi usunięcia
        viewModel.deleted.observe(viewLifecycleOwner) { isDeleted ->
            if (isDeleted) {
                findNavController().navigateUp()
            }
        }
    }

    private fun showNoImage() {
        binding.cardImageDetail.visibility = View.GONE
        binding.textReceiptStatus.visibility = View.VISIBLE
        binding.textReceiptStatus.text = "Brak zdjęcia"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
