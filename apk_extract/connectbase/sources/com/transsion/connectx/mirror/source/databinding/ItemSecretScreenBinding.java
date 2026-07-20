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
public abstract class ItemSecretScreenBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f1998a;

    public ItemSecretScreenBinding(Object obj, View view, int i10) {
        super(obj, view, i10);
    }

    public static ItemSecretScreenBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecretScreenBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemSecretScreenBinding) ViewDataBinding.bind(obj, view, R.layout.item_secret_screen);
    }

    @NonNull
    public static ItemSecretScreenBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemSecretScreenBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemSecretScreenBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ItemSecretScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_secret_screen, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ItemSecretScreenBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemSecretScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_secret_screen, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f1998a;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
