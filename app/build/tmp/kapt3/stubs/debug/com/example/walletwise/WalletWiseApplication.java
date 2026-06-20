package com.example.walletwise;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/example/walletwise/WalletWiseApplication;", "Landroid/app/Application;", "<init>", "()V", "database", "Lcom/example/walletwise/data/db/AppDatabase;", "getDatabase", "()Lcom/example/walletwise/data/db/AppDatabase;", "database$delegate", "Lkotlin/Lazy;", "repository", "Lcom/example/walletwise/data/repository/ExpenseRepository;", "getRepository", "()Lcom/example/walletwise/data/repository/ExpenseRepository;", "repository$delegate", "onCreate", "", "app_debug"})
public final class WalletWiseApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    
    public WalletWiseApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.walletwise.data.db.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.walletwise.data.repository.ExpenseRepository getRepository() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
}