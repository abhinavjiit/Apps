package com.example.mycartutils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006J\u0014\u0010\u001b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0018\u00010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000eR(\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/example/mycartutils/CartViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "availableDataModel", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/mycartutils/AvailableDataModel;", "getAvailableDataModel", "()Landroidx/lifecycle/LiveData;", "setAvailableDataModel", "(Landroidx/lifecycle/LiveData;)V", "loanedData", "Lcom/example/mycartutils/LoanedDataModel;", "getLoanedData", "setLoanedData", "mutableAvailableDataModel", "Landroidx/lifecycle/MutableLiveData;", "getMutableAvailableDataModel", "()Landroidx/lifecycle/MutableLiveData;", "setMutableAvailableDataModel", "(Landroidx/lifecycle/MutableLiveData;)V", "mutableLoanedData", "getMutableLoanedData", "setMutableLoanedData", "getAvailData", "getLoanData", "setAvailData", "", "setLoanData", "loanedDataModel", "app_debug"})
public final class CartViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.LoanedDataModel>> loanedData;
    @org.jetbrains.annotations.Nullable()
    private androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.AvailableDataModel>> availableDataModel;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.mycartutils.LoanedDataModel>> mutableLoanedData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.mycartutils.AvailableDataModel>> mutableAvailableDataModel;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.LoanedDataModel>> getLoanedData() {
        return null;
    }
    
    public final void setLoanedData(@org.jetbrains.annotations.Nullable()
    androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.LoanedDataModel>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.AvailableDataModel>> getAvailableDataModel() {
        return null;
    }
    
    public final void setAvailableDataModel(@org.jetbrains.annotations.Nullable()
    androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.AvailableDataModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.mycartutils.LoanedDataModel>> getMutableLoanedData() {
        return null;
    }
    
    public final void setMutableLoanedData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.example.mycartutils.LoanedDataModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.mycartutils.AvailableDataModel>> getMutableAvailableDataModel() {
        return null;
    }
    
    public final void setMutableAvailableDataModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.example.mycartutils.AvailableDataModel>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.LoanedDataModel>> getLoanData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.mycartutils.AvailableDataModel>> getAvailData() {
        return null;
    }
    
    public final void setLoanData(@org.jetbrains.annotations.NotNull()
    com.example.mycartutils.LoanedDataModel loanedDataModel) {
    }
    
    public final void setAvailData(@org.jetbrains.annotations.NotNull()
    com.example.mycartutils.AvailableDataModel availableDataModel) {
    }
    
    public CartViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}