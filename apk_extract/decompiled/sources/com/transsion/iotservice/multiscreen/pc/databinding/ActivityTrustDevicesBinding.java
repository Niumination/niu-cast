package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.view.CustomLottieView;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityTrustDevicesBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CustomLottieView f2508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSLiquidToolBar f2509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f2510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f2511d;
    public TrustDevicesViewModel e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SharedViewModel f2512h;

    public ActivityTrustDevicesBinding(DataBindingComponent dataBindingComponent, View view, CustomLottieView customLottieView, OSLiquidToolBar oSLiquidToolBar, LinearLayout linearLayout, RecyclerView recyclerView) {
        super((Object) dataBindingComponent, view, 3);
        this.f2508a = customLottieView;
        this.f2509b = oSLiquidToolBar;
        this.f2510c = linearLayout;
        this.f2511d = recyclerView;
    }

    public abstract void d(SharedViewModel sharedViewModel);

    public abstract void e(TrustDevicesViewModel trustDevicesViewModel);
}
