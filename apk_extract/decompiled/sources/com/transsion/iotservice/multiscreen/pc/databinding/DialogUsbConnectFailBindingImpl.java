package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.UsbConnectFailViewModel;
import k3.ed;
import ph.c;
import qd.k;
import sb.z;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class DialogUsbConnectFailBindingImpl extends DialogUsbConnectFailBinding implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatButton f2555d;
    public final k e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2556h;

    /* JADX WARN: Illegal instructions before constructor call */
    public DialogUsbConnectFailBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
        super(dataBindingComponent, view, (TextView) objArrMapBindings[1]);
        this.f2556h = -1L;
        ((LinearLayout) objArrMapBindings[0]).setTag(null);
        AppCompatButton appCompatButton = (AppCompatButton) objArrMapBindings[2];
        this.f2555d = appCompatButton;
        appCompatButton.setTag(null);
        this.f2552a.setTag(null);
        setRootTag(view);
        this.e = new k(1, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        z zVar = this.f2554c;
        if (zVar != null) {
            zVar.f9636a.finishAndRemoveTask();
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.DialogUsbConnectFailBinding
    public final void d(z zVar) {
        this.f2554c = zVar;
        synchronized (this) {
            this.f2556h |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.DialogUsbConnectFailBinding
    public final void e(UsbConnectFailViewModel usbConnectFailViewModel) {
        this.f2553b = usbConnectFailViewModel;
        synchronized (this) {
            this.f2556h |= 2;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        c cVar;
        SearchPageText searchPageText;
        synchronized (this) {
            j8 = this.f2556h;
            this.f2556h = 0L;
        }
        UsbConnectFailViewModel usbConnectFailViewModel = this.f2553b;
        long j10 = 6 & j8;
        if (j10 == 0 || usbConnectFailViewModel == null) {
            cVar = null;
            searchPageText = null;
        } else {
            cVar = usbConnectFailViewModel.f2765b;
            searchPageText = usbConnectFailViewModel.f2764a;
        }
        if ((j8 & 4) != 0) {
            this.f2555d.setOnClickListener(this.e);
        }
        if (j10 != 0) {
            ed.b(this.f2552a, searchPageText, cVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2556h != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2556h = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (3 == i8) {
            d((z) obj);
        } else {
            if (26 != i8) {
                return false;
            }
            e((UsbConnectFailViewModel) obj);
        }
        return true;
    }
}
