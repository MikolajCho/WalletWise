package com.example.walletwise.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walletwise.data.model.Category
import com.example.walletwise.data.model.Expense
import com.example.walletwise.databinding.ItemExpenseBinding
import com.example.walletwise.utils.CurrencyFormatter
import com.example.walletwise.utils.DateUtils
import java.io.File
import android.graphics.BitmapFactory

class ExpenseAdapter(
    private val onClick: (Expense) -> Unit,
    private val onLongClick: (Expense) -> Boolean
) : RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {

    private var expenses: List<Expense> = emptyList()

    // Metoda do ustawiania danych
    fun submitList(newList: List<Expense>) {
        expenses = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemExpenseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = expenses[position]
        holder.bind(expense)
    }

    override fun getItemCount(): Int = expenses.size

    inner class ViewHolder(private val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(expense: Expense) {
            val cat = Category.fromName(expense.category)

            // binding.textEmoji.text = cat.emoji  <-- USUNIĘTE EMOTKI Z LISTY
            binding.textEmoji.visibility = View.GONE
            binding.textCategory.text = cat.displayName
            binding.textAmount.text = CurrencyFormatter.formatShort(expense.amount)
            binding.textDate.text = DateUtils.formatDate(expense.date)
            binding.textDescription.text = expense.description.ifBlank { "—" }

            // Wyświetlanie miniatury zdjęcia (paragonu)
            if (!expense.receiptImagePath.isNullOrBlank()) {
                val imgFile = File(expense.receiptImagePath)
                if (imgFile.exists()) {
                    binding.imageReceiptThumbnail.visibility = View.VISIBLE
                    
                    // Ładowanie pomniejszonego zdjęcia (thumbnail)
                    val options = BitmapFactory.Options().apply {
                        inSampleSize = 8 // Zmniejszenie rozmiaru 8-krotnie
                    }
                    val bitmap = BitmapFactory.decodeFile(expense.receiptImagePath, options)
                    if (bitmap != null) {
                        binding.imageReceiptThumbnail.setImageBitmap(bitmap)
                    } else {
                        binding.imageReceiptThumbnail.visibility = View.GONE
                    }
                } else {
                    binding.imageReceiptThumbnail.visibility = View.GONE
                }
            } else {
                binding.imageReceiptThumbnail.visibility = View.GONE
            }

            // Obsługa kliknięć
            binding.root.setOnClickListener { onClick(expense) }
            binding.root.setOnLongClickListener { onLongClick(expense) }
        }
    }
}
