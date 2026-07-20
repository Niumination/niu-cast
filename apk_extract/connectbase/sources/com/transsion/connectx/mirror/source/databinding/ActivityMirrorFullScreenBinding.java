package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityMirrorFullScreenBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ItemWindowHelperBinding f1942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SurfaceView f1943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f1944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f1945d;

    public ActivityMirrorFullScreenBinding(Object obj, View view, int i10, ItemWindowHelperBinding itemWindowHelperBinding, SurfaceView surfaceView, FrameLayout frameLayout) {
        super(obj, view, i10);
        this.f1942a = itemWindowHelperBinding;
        this.f1943b = surfaceView;
        this.f1944c = frameLayout;
    }

    public static ActivityMirrorFullScreenBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMirrorFullScreenBinding c(@NonNull View view, @Nullable Object obj) {
        return (ActivityMirrorFullScreenBinding) ViewDataBinding.bind(obj, view, R.layout.activity_mirror_full_screen);
    }

    @NonNull
    public static ActivityMirrorFullScreenBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityMirrorFullScreenBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityMirrorFullScreenBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ActivityMirrorFullScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mirror_full_screen, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityMirrorFullScreenBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityMirrorFullScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mirror_full_screen, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f1945d;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
