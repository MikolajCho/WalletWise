package com.example.walletwise.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletwise.R
import com.example.walletwise.data.model.Category
import com.example.walletwise.databinding.FragmentExpenseListBinding
import com.example.walletwise.utils.CurrencyFormatter
import com.example.walletwise.utils.DateUtils
import com.google.android.material.chip.Chip

class ExpenseListFragment : Fragment() {

    private var _binding: FragmentExpenseListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExpenseListViewModel by viewModels()
    private lateinit var adapter: ExpenseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpenseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupCategoryChips()
        
        // Przyciski od miesięcy
        binding.btnPrevMonth.setOnClickListener { viewModel.poprzedniMiesiac() }
        binding.btnNextMonth.setOnClickListener { viewModel.nastepnyMiesiac() }
        
        // Przycisk dodawania
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_add)
        }

        // Obserwujemy zmiany w LiveData (kiedy viewModel skończy pobierać dane)
        viewModel.wydatki.observe(viewLifecycleOwner) { lista ->
            adapter.submitList(lista)
            binding.textEmpty.visibility = if (lista.isEmpty()) View.VISIBLE else View.GONE
            
            // Przy okazji aktualizujemy tekst z miesiącem i rokiem
            binding.textCurrentMonth.text = DateUtils.formatMonth(viewModel.rok, viewModel.miesiac)
        }

        viewModel.sumaMiesiaca.observe(viewLifecycleOwner) { suma ->
            binding.textMonthTotal.text = "Suma: ${CurrencyFormatter.formatShort(suma)}"
        }

        // Na starcie prosimy o wczytanie danych
        viewModel.odswiezDane()
    }

    private fun setupRecyclerView() {
        adapter = ExpenseAdapter(
            onClick = { exp ->
                findNavController().navigate(R.id.action_list_to_detail, bundleOf("expenseId" to exp.id))
            },
            onLongClick = { exp ->
                AlertDialog.Builder(requireContext())
                    .setTitle("Usuń?")
                    .setMessage("Czy usunąć wydatek?")
                    .setPositiveButton("Tak") { _, _ -> viewModel.usunWydatek(exp) }
                    .setNegativeButton("Nie", null)
                    .show()
                true
            }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun setupCategoryChips() {
        binding.chipAll.setOnClickListener {
            viewModel.wybranaKategoria = null
            viewModel.odswiezDane()
        }

        Category.entries.forEach { cat ->
            val chip = Chip(requireContext()).apply {
                text = "${cat.emoji} ${cat.displayName}"
                isCheckable = true
                // Powiększenie chipa, żeby pasował do przycisku "Wszystkie"
                textSize = 18f
                minHeight = (56 * resources.displayMetrics.density).toInt()

                setOnClickListener {
                    viewModel.wybranaKategoria = cat
                    viewModel.odswiezDane()
                }
            }
            binding.chipGroupCategories.addView(chip)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
