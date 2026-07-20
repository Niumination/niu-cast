package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogUsbConnectFailBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld.k;
import ld.n;
import sb.z;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/UsbConnectFailDialog;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "k3/gd", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UsbConnectFailDialog extends BaseActivityDialog {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UsbConnectFailViewModel f2761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogUsbConnectFailBinding f2762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f2763d = new z(this);

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2761b = (UsbConnectFailViewModel) this.f2695a.A(this, UsbConnectFailViewModel.class);
        DialogUsbConnectFailBinding dialogUsbConnectFailBinding = null;
        DialogUsbConnectFailBinding dialogUsbConnectFailBinding2 = (DialogUsbConnectFailBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R$layout.dialog_usb_connect_fail, null, false);
        UsbConnectFailViewModel usbConnectFailViewModel = this.f2761b;
        if (usbConnectFailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUsbConnectFailVM");
            usbConnectFailViewModel = null;
        }
        dialogUsbConnectFailBinding2.e(usbConnectFailViewModel);
        dialogUsbConnectFailBinding2.d(this.f2763d);
        dialogUsbConnectFailBinding2.setLifecycleOwner(this);
        this.f2762c = dialogUsbConnectFailBinding2;
        k kVar = new k(this);
        DialogUsbConnectFailBinding dialogUsbConnectFailBinding3 = this.f2762c;
        if (dialogUsbConnectFailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogUsbConnectFailBinding = dialogUsbConnectFailBinding3;
        }
        View root = dialogUsbConnectFailBinding.getRoot();
        n nVar = kVar.f7400b;
        nVar.f7413n = root;
        nVar.f7410k = false;
        nVar.f7403b = getString(R$string.module_pc_connect_time_out);
        kVar.e();
        if (this.f2762c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
    }
}
