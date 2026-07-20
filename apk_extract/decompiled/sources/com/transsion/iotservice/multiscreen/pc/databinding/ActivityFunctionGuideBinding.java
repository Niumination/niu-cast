package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.iotservice.multiscreen.pc.adapter.FunctionGuideAdapter;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideViewModel;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetsliquid.view.OSLiquidBigButton;
import ub.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityFunctionGuideBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f2428j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSLiquidBigButton f2429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f2430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PageIndicatorWrapper f2431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FunctionGuideViewModel f2432d;
    public FunctionGuideAdapter e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPager2.OnPageChangeCallback f2433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f2434i;

    public ActivityFunctionGuideBinding(DataBindingComponent dataBindingComponent, View view, OSLiquidBigButton oSLiquidBigButton, ViewPager2 viewPager2, PageIndicatorWrapper pageIndicatorWrapper) {
        super((Object) dataBindingComponent, view, 3);
        this.f2429a = oSLiquidBigButton;
        this.f2430b = viewPager2;
        this.f2431c = pageIndicatorWrapper;
    }

    public abstract void d(b bVar);

    public abstract void e(FunctionGuideViewModel functionGuideViewModel);

    public abstract void f(FunctionGuideAdapter functionGuideAdapter);

    public abstract void g(ViewPager2.OnPageChangeCallback onPageChangeCallback);
}
