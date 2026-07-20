package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import com.transsion.iotservice.multiscreen.pc.bean.ViewLayoutParams;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ModulePcItemPcNewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f2648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f2649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f2650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f2651d;
    public PcBleScanedDeviceBean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f2652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewLayoutParams f2653i;

    public ModulePcItemPcNewBinding(DataBindingComponent dataBindingComponent, View view, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView) {
        super((Object) dataBindingComponent, view, 0);
        this.f2648a = imageView;
        this.f2649b = imageView2;
        this.f2650c = relativeLayout;
        this.f2651d = textView;
    }

    public abstract void d(PcBleScanedDeviceBean pcBleScanedDeviceBean);

    public abstract void e(Integer num);

    public abstract void f(ViewLayoutParams viewLayoutParams);
}
