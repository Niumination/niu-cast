package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StartLayoutBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AnimView f2042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f2043c;

    public StartLayoutBinding(Object obj, View view, int i10, LinearLayout linearLayout, AnimView animView) {
        super(obj, view, i10);
        this.f2041a = linearLayout;
        this.f2042b = animView;
    }

    public static StartLayoutBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StartLayoutBinding c(@NonNull View view, @Nullable Object obj) {
        return (StartLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.start_layout);
    }

    @NonNull
    public static StartLayoutBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static StartLayoutBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static StartLayoutBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (StartLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.start_layout, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static StartLayoutBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (StartLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.start_layout, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f2043c;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
