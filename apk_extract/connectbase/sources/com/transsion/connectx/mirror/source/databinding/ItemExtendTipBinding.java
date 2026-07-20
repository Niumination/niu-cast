package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import com.transsion.connectx.mirror.source.pad.view.TriangleView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemExtendTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f1984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TriangleView f1985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f1986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f1987d;

    public ItemExtendTipBinding(Object obj, View view, int i10, ConstraintLayout constraintLayout, TriangleView triangleView, LinearLayout linearLayout) {
        super(obj, view, i10);
        this.f1984a = constraintLayout;
        this.f1985b = triangleView;
        this.f1986c = linearLayout;
    }

    public static ItemExtendTipBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExtendTipBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemExtendTipBinding) ViewDataBinding.bind(obj, view, R.layout.item_extend_tip);
    }

    @NonNull
    public static ItemExtendTipBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExtendTipBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExtendTipBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ItemExtendTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_extend_tip, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExtendTipBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExtendTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_extend_tip, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f1987d;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
