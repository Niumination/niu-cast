package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PhoneFloatingWindowsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ItemBottomNavBinding f2026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f2027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ItemExtendTipBinding f2028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ItemWindowHelperBinding f2029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final LoadingLayoutBinding f2030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final SurfaceView f2032g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f2033i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final StartLayoutBinding f2034n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final ItemActionbarBinding f2035p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f2036v;

    public PhoneFloatingWindowsBinding(Object obj, View view, int i10, ItemBottomNavBinding itemBottomNavBinding, EditText editText, ItemExtendTipBinding itemExtendTipBinding, ItemWindowHelperBinding itemWindowHelperBinding, LoadingLayoutBinding loadingLayoutBinding, FrameLayout frameLayout, SurfaceView surfaceView, ConstraintLayout constraintLayout, StartLayoutBinding startLayoutBinding, ItemActionbarBinding itemActionbarBinding) {
        super(obj, view, i10);
        this.f2026a = itemBottomNavBinding;
        this.f2027b = editText;
        this.f2028c = itemExtendTipBinding;
        this.f2029d = itemWindowHelperBinding;
        this.f2030e = loadingLayoutBinding;
        this.f2031f = frameLayout;
        this.f2032g = surfaceView;
        this.f2033i = constraintLayout;
        this.f2034n = startLayoutBinding;
        this.f2035p = itemActionbarBinding;
    }

    public static PhoneFloatingWindowsBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneFloatingWindowsBinding c(@NonNull View view, @Nullable Object obj) {
        return (PhoneFloatingWindowsBinding) ViewDataBinding.bind(obj, view, R.layout.phone_floating_windows);
    }

    @NonNull
    public static PhoneFloatingWindowsBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static PhoneFloatingWindowsBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static PhoneFloatingWindowsBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (PhoneFloatingWindowsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.phone_floating_windows, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static PhoneFloatingWindowsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (PhoneFloatingWindowsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.phone_floating_windows, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f2036v;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
