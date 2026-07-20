package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetslistitemlayout.OSListItemView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LayoutSettingItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f2631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PageIndicatorWrapper f2632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSListItemView f2633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewPager2 f2634d;

    public LayoutSettingItemBinding(DataBindingComponent dataBindingComponent, View view, ConstraintLayout constraintLayout, PageIndicatorWrapper pageIndicatorWrapper, OSListItemView oSListItemView, ViewPager2 viewPager2) {
        super((Object) dataBindingComponent, view, 0);
        this.f2631a = constraintLayout;
        this.f2632b = pageIndicatorWrapper;
        this.f2633c = oSListItemView;
        this.f2634d = viewPager2;
    }
}
