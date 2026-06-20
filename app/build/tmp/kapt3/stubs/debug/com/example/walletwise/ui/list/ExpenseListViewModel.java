package com.example.walletwise.ui.list;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\nJ\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\f\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000e\u00a8\u0006\'"}, d2 = {"Lcom/example/walletwise/ui/list/ExpenseListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/example/walletwise/data/repository/ExpenseRepository;", "_selectedCategory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/walletwise/data/model/Category;", "selectedCategory", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedCategory", "()Lkotlinx/coroutines/flow/StateFlow;", "_selectedYear", "", "_selectedMonth", "selectedYear", "getSelectedYear", "selectedMonth", "getSelectedMonth", "expenses", "", "Lcom/example/walletwise/data/model/Expense;", "getExpenses$annotations", "()V", "getExpenses", "monthTotal", "", "getMonthTotal", "selectCategory", "", "cat", "previousMonth", "nextMonth", "deleteExpense", "Lkotlinx/coroutines/Job;", "expense", "app_debug"})
public final class ExpenseListViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.walletwise.data.repository.ExpenseRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.walletwise.data.model.Category> _selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.walletwise.data.model.Category> selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _selectedYear = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _selectedMonth = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> selectedYear = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> selectedMonth = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.walletwise.data.model.Expense>> expenses = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Double> monthTotal = null;
    
    public ExpenseListViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.walletwise.data.model.Category> getSelectedCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSelectedYear() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSelectedMonth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.walletwise.data.model.Expense>> getExpenses() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @java.lang.Deprecated()
    public static void getExpenses$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Double> getMonthTotal() {
        return null;
    }
    
    public final void selectCategory(@org.jetbrains.annotations.Nullable()
    com.example.walletwise.data.model.Category cat) {
    }
    
    public final void previousMonth() {
    }
    
    public final void nextMonth() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteExpense(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.model.Expense expense) {
        return null;
    }
}