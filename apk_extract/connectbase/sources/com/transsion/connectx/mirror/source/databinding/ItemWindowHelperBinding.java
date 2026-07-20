package com.transsion.connectx.mirror.source.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public abstract class ItemWindowHelperBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f2005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TriangleView f2006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TriangleView f2007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f2008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f2010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Bindable
    public FloatingWindowViewModel f2011g;

    public ItemWindowHelperBinding(Object obj, View view, int i10, ImageView imageView, TriangleView triangleView, TriangleView triangleView2, ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2) {
        super(obj, view, i10);
        this.f2005a = imageView;
        this.f2006b = triangleView;
        this.f2007c = triangleView2;
        this.f2008d = constraintLayout;
        this.f2009e = linearLayout;
        this.f2010f = constraintLayout2;
    }

    public static ItemWindowHelperBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWindowHelperBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemWindowHelperBinding) ViewDataBinding.bind(obj, view, R.layout.item_window_helper);
    }

    @NonNull
    public static ItemWindowHelperBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemWindowHelperBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return g(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemWindowHelperBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ItemWindowHelperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_window_helper, viewGroup, z10, obj);
    }

    @NonNull
    @Deprecated
    public static ItemWindowHelperBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemWindowHelperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_window_helper, null, false, obj);
    }

    @Nullable
    public FloatingWindowViewModel d() {
        return this.f2011g;
    }

    public abstract void i(@Nullable FloatingWindowViewModel floatingWindowViewModel);
}
