package com.example.walletwise.ui.add;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0002J\b\u0010\'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010\u00192\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00120\u00120\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00190\u00190\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00190\u00190\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/example/walletwise/ui/add/AddExpenseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/example/walletwise/databinding/FragmentAddExpenseBinding;", "binding", "getBinding", "()Lcom/example/walletwise/databinding/FragmentAddExpenseBinding;", "viewModel", "Lcom/example/walletwise/ui/add/AddExpenseViewModel;", "getViewModel", "()Lcom/example/walletwise/ui/add/AddExpenseViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "expenseId", "", "tempImageUri", "Landroid/net/Uri;", "dateFormat", "Ljava/text/SimpleDateFormat;", "cameraLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "galleryLauncher", "", "cameraPermLauncher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupCategoryChips", "setupDatePicker", "updateDateDisplay", "setupButtons", "launchCamera", "createImageFile", "Ljava/io/File;", "copyUriToFile", "uri", "loadReceiptPreview", "path", "observeViewModel", "onDestroyView", "app_debug"})
public final class AddExpenseFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.walletwise.databinding.FragmentAddExpenseBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private long expenseId = -1L;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri tempImageUri;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> cameraLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> galleryLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> cameraPermLauncher = null;
    
    public AddExpenseFragment() {
        super();
    }
    
    private final com.example.walletwise.databinding.FragmentAddExpenseBinding getBinding() {
        return null;
    }
    
    private final com.example.walletwise.ui.add.AddExpenseViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupCategoryChips() {
    }
    
    private final void setupDatePicker() {
    }
    
    private final void updateDateDisplay() {
    }
    
    private final void setupButtons() {
    }
    
    private final void launchCamera() {
    }
    
    private final java.io.File createImageFile() {
        return null;
    }
    
    private final java.lang.String copyUriToFile(android.net.Uri uri) {
        return null;
    }
    
    private final void loadReceiptPreview(java.lang.String path) {
    }
    
    private final void observeViewModel() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}