package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import bc.d;
import com.transsion.iotservice.multiscreen.pc.bean.TrustDeviceBean;
import com.transsion.widgetslistitemlayout.OSListItemView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemTrustDeviceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSListItemView f2615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TrustDeviceBean f2616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f2617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2618d;
    public int e;

    public ItemTrustDeviceBinding(DataBindingComponent dataBindingComponent, View view, OSListItemView oSListItemView) {
        super((Object) dataBindingComponent, view, 0);
        this.f2615a = oSListItemView;
    }

    public abstract void d(d dVar);

    public abstract void e(TrustDeviceBean trustDeviceBean);

    public abstract void f(int i8);

    public abstract void g(int i8);
}
