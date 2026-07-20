package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import com.transsion.widgetslib.view.OSCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogPcRequestConnectBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSCheckBox f2526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f2527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PcRequestConnectViewModel f2529d;

    public DialogPcRequestConnectBinding(DataBindingComponent dataBindingComponent, View view, OSCheckBox oSCheckBox, RelativeLayout relativeLayout, TextView textView) {
        super((Object) dataBindingComponent, view, 3);
        this.f2526a = oSCheckBox;
        this.f2527b = relativeLayout;
        this.f2528c = textView;
    }

    public abstract void d(PcRequestConnectViewModel pcRequestConnectViewModel);
}
