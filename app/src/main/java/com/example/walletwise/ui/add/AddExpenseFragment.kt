package com.example.walletwise.ui.add

import android.app.DatePickerDialog
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.walletwise.R
import com.example.walletwise.data.model.Category
import com.example.walletwise.databinding.FragmentAddExpenseBinding
import com.google.android.material.chip.Chip
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class AddExpenseFragment : Fragment() {

    private var _binding: FragmentAddExpenseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddExpenseViewModel by viewModels()

    private var expenseId: Long = -1L
    private var tempImageUri: Uri? = null
    private var currentPhotoPath: String? = null
    private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale("pl", "PL"))

    private val cameraLauncher = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            currentPhotoPath?.let { path ->
                viewModel.receiptImagePath = path
                loadReceiptPreview(path)
            }
        }
    }

    private val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            val path = copyUriToFile(uri)
            viewModel.receiptImagePath = path
            if (path != null) loadReceiptPreview(path)
        }
    }

    private val cameraPermLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) launchCamera()
        else Toast.makeText(requireContext(), "Brak uprawnień do kamery", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expenseId = arguments?.getLong("expenseId", -1L) ?: -1L

        setupCategoryChips()
        setupDatePicker()
        setupButtons()
        observeViewModel()

        if (expenseId != -1L) {
            viewModel.loadExpense(expenseId)
            binding.textTitle.text = "Edytuj wydatek"
        }
        updateDateDisplay()
    }

    private fun setupCategoryChips() {
        Category.entries.forEach { cat ->
            val chip = Chip(requireContext()).apply {
                text = "${cat.emoji} ${cat.displayName}"
                isCheckable = true
                textSize = 18f
                minHeight = (56 * resources.displayMetrics.density).toInt()
                tag = cat
                setOnClickListener { viewModel.selectedCategory = cat }
            }
            binding.chipGroupCategories.addView(chip)
        }
    }

    private fun setupDatePicker() {
        binding.btnPickDate.setOnClickListener {
            val cal = Calendar.getInstance().apply { timeInMillis = viewModel.date }
            DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    val newCal = Calendar.getInstance().apply { set(year, month, day) }
                    viewModel.date = newCal.timeInMillis
                    updateDateDisplay()
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateDateDisplay() {
        binding.textSelectedDate.text = dateFormat.format(Date(viewModel.date))
    }

    private fun setupButtons() {
        binding.btnCamera.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                launchCamera()
            } else {
                cameraPermLauncher.launch(android.Manifest.permission.CAMERA)
            }
        }

        binding.btnGallery.setOnClickListener { galleryLauncher.launch("image/*") }

        binding.btnSave.setOnClickListener {
            viewModel.amount = binding.editAmount.text.toString()
            viewModel.description = binding.editDescription.text.toString()
            viewModel.save()
        }

        binding.btnCancel.setOnClickListener { findNavController().navigateUp() }
    }

    private fun launchCamera() {
        val photoFile = createImageFile()
        currentPhotoPath = photoFile.absolutePath
        tempImageUri = FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.fileprovider",
            photoFile
        )
        cameraLauncher.launch(tempImageUri)
    }

    private fun createImageFile(): File {
        val ts = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val dir = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("RECEIPT_${ts}_", ".jpg", dir)
    }

    private fun copyUriToFile(uri: Uri): String? {
        return try {
            val ts = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
            val dir = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val dest = File(dir, "RECEIPT_${ts}.jpg")
            requireContext().contentResolver.openInputStream(uri)?.use { input ->
                dest.outputStream().use { out -> input.copyTo(out) }
            }
            dest.absolutePath
        } catch (e: Exception) { null }
    }

    private fun loadReceiptPreview(path: String?) {
        if (path.isNullOrBlank()) {
            binding.cardReceiptPreview.visibility = View.GONE
            binding.textNoImageAdd.visibility = View.VISIBLE
            return
        }
        val file = File(path)
        if (file.exists()) {
            val bmp = android.graphics.BitmapFactory.decodeFile(path)
            if (bmp != null) {
                binding.imageReceipt.setImageBitmap(bmp)
                binding.cardReceiptPreview.visibility = View.VISIBLE
                binding.textNoImageAdd.visibility = View.GONE
            } else {
                binding.cardReceiptPreview.visibility = View.GONE
                binding.textNoImageAdd.visibility = View.VISIBLE
            }
        } else {
            binding.cardReceiptPreview.visibility = View.GONE
            binding.textNoImageAdd.visibility = View.VISIBLE
        }
    }

    private fun observeViewModel() {
        // Obserwowanie wyniku zapisu/ładowania
        viewModel.saveResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is SaveResult.Success -> {
                    Toast.makeText(requireContext(), "Wydatek zapisany!", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                    viewModel.resetResult()
                }
                is SaveResult.Error -> {
                    Toast.makeText(requireContext(), result.message, Toast.LENGTH_SHORT).show()
                    viewModel.resetResult()
                }
                is SaveResult.Loaded -> {
                    val e = result.expense
                    binding.editAmount.setText(e.amount.toString())
                    binding.editDescription.setText(e.description)
                    updateDateDisplay()
                    loadReceiptPreview(e.receiptImagePath)
                    
                    // Zaznaczenie odpowiedniego chipa kategorii
                    for (i in 0 until binding.chipGroupCategories.childCount) {
                        val chip = binding.chipGroupCategories.getChildAt(i) as? Chip
                        if (chip?.tag == Category.fromName(e.category)) {
                            chip.isChecked = true
                        }
                    }
                    viewModel.resetResult()
                }
                null -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
