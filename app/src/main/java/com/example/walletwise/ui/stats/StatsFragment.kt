package com.example.walletwise.ui.stats

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.walletwise.data.model.Category
import com.example.walletwise.databinding.FragmentStatsBinding
import com.example.walletwise.utils.CurrencyFormatter
import com.example.walletwise.utils.DateUtils
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class StatsFragment : Fragment() {

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: StatsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupChart()

        binding.btnPrevMonth.setOnClickListener { viewModel.poprzedniMiesiac() }
        binding.btnNextMonth.setOnClickListener { viewModel.nastepnyMiesiac() }
        
        // Obserwujemy zmiany w stanie
        viewModel.stanUi.observe(viewLifecycleOwner) { state ->
            updateUI(state)
        }

        // Start
        viewModel.wczytajStatystyki()
    }

    private fun setupChart() {
        binding.pieChart.apply {
            description.isEnabled = false
            setUsePercentValues(true)
            setEntryLabelColor(Color.BLACK)
            legend.isEnabled = false
        }
    }

    private fun updateUI(state: StatsUiState) {
        binding.textCurrentMonth.text = DateUtils.formatMonth(state.rok, state.miesiac)
        binding.textMonthTotal.text = "Razem: ${CurrencyFormatter.formatShort(state.suma)}"

        if (state.kategorie.isEmpty()) {
            binding.pieChart.visibility = View.GONE
            binding.textNoData.visibility = View.VISIBLE
        } else {
            binding.pieChart.visibility = View.VISIBLE
            binding.textNoData.visibility = View.GONE
            updateChartData(state)
        }
    }

    private fun updateChartData(state: StatsUiState) {
        val entries = state.kategorie.map { total ->
            val cat = Category.valueOf(total.category)
            PieEntry(total.total.toFloat(), cat.displayName)
        }

        val dataSet = PieDataSet(entries, "").apply {
            colors = state.kategorie.map { 
                Color.parseColor(Category.valueOf(it.category).colorHex) 
            }
            valueTextSize = 14f
            valueTextColor = Color.BLACK
        }

        binding.pieChart.data = PieData(dataSet).apply {
            setValueFormatter(PercentFormatter(binding.pieChart))
        }
        binding.pieChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
