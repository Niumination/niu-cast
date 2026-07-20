package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemActionbarBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f1962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f1963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f1964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f1965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f1966e;

    public ItemActionbarBinding(Object obj, View view, int i10, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i10);
        this.f1962a = constraintLayout;
        this.f1963b = imageView;
        this.f1964c = imageView2;
        this.f1965d = imageView3;
    }

    public static ItemActionbarBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemActionbarBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemActionbarBinding) ViewDataBinding.bind(obj, view, R.layout.item_actionbar);
    }

    @NonNull
    public static ItemActionbarBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemActionbarBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemActionbarBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ItemActionbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_actionbar, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ItemActionbarBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemActionbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_actionbar, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f1966e;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
