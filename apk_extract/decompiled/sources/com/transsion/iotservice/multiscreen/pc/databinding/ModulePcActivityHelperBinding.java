package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ue.HelperItemView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import pb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ModulePcActivityHelperBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HelperItemView f2636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HelperItemView f2637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HelperItemView f2639d;
    public final HelperItemView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OverBoundNestedScrollView f2640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HelperItemView f2641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f2642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f2643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f2644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f2645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f2646n;

    public ModulePcActivityHelperBinding(DataBindingComponent dataBindingComponent, View view, HelperItemView helperItemView, HelperItemView helperItemView2, TextView textView, HelperItemView helperItemView3, HelperItemView helperItemView4, OverBoundNestedScrollView overBoundNestedScrollView, HelperItemView helperItemView5) {
        super((Object) dataBindingComponent, view, 0);
        this.f2636a = helperItemView;
        this.f2637b = helperItemView2;
        this.f2638c = textView;
        this.f2639d = helperItemView3;
        this.e = helperItemView4;
        this.f2640h = overBoundNestedScrollView;
        this.f2641i = helperItemView5;
    }

    public abstract void d(b bVar);

    public abstract void e(b bVar);

    public abstract void f(b bVar);

    public abstract void g(b bVar);

    public abstract void h(b bVar);
}
