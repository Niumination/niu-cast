package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideBean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LayoutFunctionGuideItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimView f2623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f2624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FunctionGuideBean f2626d;

    public LayoutFunctionGuideItemBinding(DataBindingComponent dataBindingComponent, View view, AnimView animView, TextView textView, TextView textView2) {
        super((Object) dataBindingComponent, view, 0);
        this.f2623a = animView;
        this.f2624b = textView;
        this.f2625c = textView2;
    }

    public abstract void d(FunctionGuideBean functionGuideBean);
}
