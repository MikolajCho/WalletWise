package com.example.walletwise.utils;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/walletwise/utils/DateUtils;", "", "<init>", "()V", "displayFormat", "Ljava/text/SimpleDateFormat;", "monthFormat", "formatDate", "", "timestamp", "", "formatMonth", "year", "", "month", "getMonthRange", "Lkotlin/Pair;", "currentYear", "currentMonth", "msUntil20h", "app_debug"})
public final class DateUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat displayFormat = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat monthFormat = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.walletwise.utils.DateUtils INSTANCE = null;
    
    private DateUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDate(long timestamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatMonth(int year, int month) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Long, java.lang.Long> getMonthRange(int year, int month) {
        return null;
    }
    
    public final int currentYear() {
        return 0;
    }
    
    public final int currentMonth() {
        return 0;
    }
    
    /**
     * Returns ms until 20:00 today (or tomorrow if already past)
     */
    public final long msUntil20h() {
        return 0L;
    }
}