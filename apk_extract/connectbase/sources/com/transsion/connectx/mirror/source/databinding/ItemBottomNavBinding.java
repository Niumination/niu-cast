package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemBottomNavBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f1973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f1974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f1975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f1976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f1977e;

    public ItemBottomNavBinding(Object obj, View view, int i10, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i10);
        this.f1973a = linearLayout;
        this.f1974b = imageView;
        this.f1975c = imageView2;
        this.f1976d = imageView3;
    }

    public static ItemBottomNavBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBottomNavBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemBottomNavBinding) ViewDataBinding.bind(obj, view, R.layout.item_bottom_nav);
    }

    @NonNull
    public static ItemBottomNavBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemBottomNavBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemBottomNavBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ItemBottomNavBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bottom_nav, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ItemBottomNavBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemBottomNavBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bottom_nav, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f1977e;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
