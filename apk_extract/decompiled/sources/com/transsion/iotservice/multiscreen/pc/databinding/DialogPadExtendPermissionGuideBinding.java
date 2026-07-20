package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionViewModel;
import com.transsion.widgetPerGuide.perguide.PerGuideAdapter;
import vb.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogPadExtendPermissionGuideBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f2516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f2517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f2519d;
    public PermissionViewModel e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f2520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PerGuideAdapter f2521i;

    public DialogPadExtendPermissionGuideBinding(DataBindingComponent dataBindingComponent, View view, Button button, Button button2, TextView textView, RecyclerView recyclerView) {
        super((Object) dataBindingComponent, view, 0);
        this.f2516a = button;
        this.f2517b = button2;
        this.f2518c = textView;
        this.f2519d = recyclerView;
    }
}
