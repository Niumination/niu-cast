package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.UsbConnectFailViewModel;
import sb.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogUsbConnectFailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f2552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UsbConnectFailViewModel f2553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f2554c;

    public DialogUsbConnectFailBinding(DataBindingComponent dataBindingComponent, View view, TextView textView) {
        super((Object) dataBindingComponent, view, 0);
        this.f2552a = textView;
    }

    public abstract void d(z zVar);

    public abstract void e(UsbConnectFailViewModel usbConnectFailViewModel);
}
