package com.example.walletwise.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/walletwise/data/repository/ExpenseRepository;", "", "db", "Lcom/example/walletwise/data/db/AppDatabase;", "<init>", "(Lcom/example/walletwise/data/db/AppDatabase;)V", "dao", "Lcom/example/walletwise/data/db/ExpenseDao;", "getAllExpenses", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/walletwise/data/model/Expense;", "getExpensesByMonth", "start", "", "end", "getExpensesByCategory", "category", "", "getExpenseById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalForMonth", "", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategoryTotalsForMonth", "Lcom/example/walletwise/data/db/CategoryTotal;", "insert", "expense", "(Lcom/example/walletwise/data/model/Expense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "", "delete", "app_debug"})
public final class ExpenseRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.walletwise.data.db.ExpenseDao dao = null;
    
    public ExpenseRepository(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.db.AppDatabase db) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.walletwise.data.model.Expense>> getAllExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.walletwise.data.model.Expense>> getExpensesByMonth(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.walletwise.data.model.Expense>> getExpensesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getExpenseById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.walletwise.data.model.Expense> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTotalForMonth(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCategoryTotalsForMonth(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.walletwise.data.db.CategoryTotal>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.model.Expense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.model.Expense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.model.Expense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}