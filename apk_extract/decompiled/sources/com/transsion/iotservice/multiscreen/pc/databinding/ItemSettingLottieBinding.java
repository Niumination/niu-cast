package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.iotservice.multiscreen.pc.bean.LottieItem;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemSettingLottieBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieAnimationView f2610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f2611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LottieItem f2613d;
    public SharedViewModel e;

    public ItemSettingLottieBinding(DataBindingComponent dataBindingComponent, View view, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        super((Object) dataBindingComponent, view, 1);
        this.f2610a = lottieAnimationView;
        this.f2611b = textView;
        this.f2612c = textView2;
    }

    public abstract void d(LottieItem lottieItem);

    public abstract void e(SharedViewModel sharedViewModel);
}
