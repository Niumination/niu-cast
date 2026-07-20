package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogTcircleConfirmBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f2549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TCircleConfirmViewModel f2550b;

    public DialogTcircleConfirmBinding(DataBindingComponent dataBindingComponent, View view, TextView textView) {
        super((Object) dataBindingComponent, view, 0);
        this.f2549a = textView;
    }

    public abstract void d(TCircleConfirmViewModel tCircleConfirmViewModel);
}
