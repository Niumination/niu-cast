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
public abstract class ActivityPhoneExtendScreenBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f1951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f1952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LoadingLayoutBinding f1953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final SurfaceView f1954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f1955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f1956f;

    public ActivityPhoneExtendScreenBinding(Object obj, View view, int i10, FrameLayout frameLayout, EditText editText, LoadingLayoutBinding loadingLayoutBinding, SurfaceView surfaceView, ConstraintLayout constraintLayout) {
        super(obj, view, i10);
        this.f1951a = frameLayout;
        this.f1952b = editText;
        this.f1953c = loadingLayoutBinding;
        this.f1954d = surfaceView;
        this.f1955e = constraintLayout;
    }

    public static ActivityPhoneExtendScreenBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPhoneExtendScreenBinding c(@NonNull View view, @Nullable Object obj) {
        return (ActivityPhoneExtendScreenBinding) ViewDataBinding.bind(obj, view, R.layout.activity_phone_extend_screen);
    }

    @NonNull
    public static ActivityPhoneExtendScreenBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityPhoneExtendScreenBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPhoneExtendScreenBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ActivityPhoneExtendScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_phone_extend_screen, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityPhoneExtendScreenBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPhoneExtendScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_phone_extend_screen, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f1956f;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
