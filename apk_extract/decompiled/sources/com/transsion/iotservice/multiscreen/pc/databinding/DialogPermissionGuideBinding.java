package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionViewModel;
import vb.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogPermissionGuideBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f2537k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f2538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f2539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f2541d;
    public final TextView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f2542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PermissionViewModel f2543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f2544j;

    public DialogPermissionGuideBinding(DataBindingComponent dataBindingComponent, View view, Button button, Button button2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super((Object) dataBindingComponent, view, 0);
        this.f2538a = button;
        this.f2539b = button2;
        this.f2540c = textView;
        this.f2541d = textView2;
        this.e = textView3;
        this.f2542h = textView4;
    }

    public abstract void d(c cVar);

    public abstract void e(PermissionViewModel permissionViewModel);
}
