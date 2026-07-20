package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.iotservice.multiscreen.pc.bean.CarouselItem;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemSettingCarouselLottieBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieAnimationView f2606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CarouselItem f2607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedViewModel f2608c;

    public ItemSettingCarouselLottieBinding(DataBindingComponent dataBindingComponent, View view, LottieAnimationView lottieAnimationView) {
        super((Object) dataBindingComponent, view, 1);
        this.f2606a = lottieAnimationView;
    }

    public abstract void d(CarouselItem carouselItem);

    public abstract void e(SharedViewModel sharedViewModel);
}
