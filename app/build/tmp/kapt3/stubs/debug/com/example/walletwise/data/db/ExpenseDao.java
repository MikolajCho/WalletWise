package com.example.walletwise.data.db;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J$\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u000b\u001a\u00020\fH\'J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0017\u00a8\u0006\u001b\u00c0\u0006\u0003"}, d2 = {"Lcom/example/walletwise/data/db/ExpenseDao;", "", "getAllExpenses", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/walletwise/data/model/Expense;", "getExpensesByMonth", "start", "", "end", "getExpensesByCategory", "category", "", "getExpenseById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalForMonth", "", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategoryTotalsForMonth", "Lcom/example/walletwise/data/db/CategoryTotal;", "insert", "expense", "(Lcom/example/walletwise/data/model/Expense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "", "delete", "app_debug"})
@androidx.room.Dao()
public abstract interface ExpenseDao {
    
    @androidx.room.Query(value = "SELECT * FROM expenses ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.walletwise.data.model.Expense>> getAllExpenses();
    
    @androidx.room.Query(value = "SELECT * FROM expenses WHERE date BETWEEN :start AND :end ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.walletwise.data.model.Expense>> getExpensesByMonth(long start, long end);
    
    @androidx.room.Query(value = "SELECT * FROM expenses WHERE category = :category ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.walletwise.data.model.Expense>> getExpensesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM expenses WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getExpenseById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.walletwise.data.model.Expense> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM expenses WHERE date BETWEEN :start AND :end")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalForMonth(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "\n        SELECT category, SUM(amount) as total\n        FROM expenses\n        WHERE date BETWEEN :start AND :end\n        GROUP BY category\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategoryTotalsForMonth(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.walletwise.data.db.CategoryTotal>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.model.Expense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.model.Expense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.walletwise.data.model.Expense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}