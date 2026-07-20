package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemScreenLockBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f1992a;

    public ItemScreenLockBinding(Object obj, View view, int i10) {
        super(obj, view, i10);
    }

    public static ItemScreenLockBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemScreenLockBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemScreenLockBinding) ViewDataBinding.bind(obj, view, R.layout.item_screen_lock);
    }

    @NonNull
    public static ItemScreenLockBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemScreenLockBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemScreenLockBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ItemScreenLockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_screen_lock, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ItemScreenLockBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemScreenLockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_screen_lock, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f1992a;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
