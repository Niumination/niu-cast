package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.view.PreviewView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanViewModel;
import wb.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityQrScanBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f2495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f2496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f2497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PreviewView f2498d;
    public final TextView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f2499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public QrScanViewModel f2500i;

    public ActivityQrScanBinding(DataBindingComponent dataBindingComponent, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, PreviewView previewView, TextView textView) {
        super((Object) dataBindingComponent, view, 1);
        this.f2495a = imageView;
        this.f2496b = imageView2;
        this.f2497c = imageView3;
        this.f2498d = previewView;
        this.e = textView;
    }

    public abstract void d(d dVar);

    public abstract void e(QrScanViewModel qrScanViewModel);
}
