package com.example.walletwise.ui.add;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001fJ\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020.R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u0012\u0010\'\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010(\u00a8\u0006/"}, d2 = {"Lcom/example/walletwise/ui/add/AddExpenseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/example/walletwise/data/repository/ExpenseRepository;", "_saveResult", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/walletwise/ui/add/SaveResult;", "saveResult", "Lkotlinx/coroutines/flow/StateFlow;", "getSaveResult", "()Lkotlinx/coroutines/flow/StateFlow;", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "selectedCategory", "Lcom/example/walletwise/data/model/Category;", "getSelectedCategory", "()Lcom/example/walletwise/data/model/Category;", "setSelectedCategory", "(Lcom/example/walletwise/data/model/Category;)V", "description", "getDescription", "setDescription", "date", "", "getDate", "()J", "setDate", "(J)V", "receiptImagePath", "getReceiptImagePath", "setReceiptImagePath", "editingExpenseId", "Ljava/lang/Long;", "loadExpense", "Lkotlinx/coroutines/Job;", "id", "save", "resetResult", "", "app_debug"})
public final class AddExpenseViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.walletwise.data.repository.ExpenseRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.walletwise.ui.add.SaveResult> _saveResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.walletwise.ui.add.SaveResult> saveResult = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String amount = "";
    @org.jetbrains.annotations.Nullable()
    private com.example.walletwise.data.model.Category selectedCategory;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description = "";
    private long date;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiptImagePath;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long editingExpenseId;
    
    public AddExpenseViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.walletwise.ui.add.SaveResult> getSaveResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.walletwise.data.model.Category getSelectedCategory() {
        return null;
    }
    
    public final void setSelectedCategory(@org.jetbrains.annotations.Nullable()
    com.example.walletwise.data.model.Category p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long getDate() {
        return 0L;
    }
    
    public final void setDate(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiptImagePath() {
        return null;
    }
    
    public final void setReceiptImagePath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadExpense(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job save() {
        return null;
    }
    
    public final void resetResult() {
    }
}