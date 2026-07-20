package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutListItemGroupBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f2627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f2628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f2630d;

    public LayoutListItemGroupBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f2627a = constraintLayout;
        this.f2628b = imageView;
        this.f2629c = textView;
        this.f2630d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f2627a;
    }
}
