package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import bb.l;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsCarouselAdapter;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcConnectSettingViewModel;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetslistitemlayout.OSListItemView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityPcConnectSettingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSListItemView f2448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSListItemView f2449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSListItemView f2450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OSListItemView f2451d;
    public final OSListItemView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OSListItemView f2452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OSListItemView f2453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OSListItemView f2454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OSListItemView f2455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OSListItemView f2456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f2457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewPager2 f2458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PcConnectSettingViewModel f2459o;
    public PageIndicatorWrapper p;
    public SettingsCarouselAdapter q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public l f2460r;

    public ActivityPcConnectSettingBinding(DataBindingComponent dataBindingComponent, View view, OSListItemView oSListItemView, OSListItemView oSListItemView2, OSListItemView oSListItemView3, OSListItemView oSListItemView4, OSListItemView oSListItemView5, OSListItemView oSListItemView6, OSListItemView oSListItemView7, OSListItemView oSListItemView8, OSListItemView oSListItemView9, OSListItemView oSListItemView10, TextView textView, ViewPager2 viewPager2) {
        super((Object) dataBindingComponent, view, 10);
        this.f2448a = oSListItemView;
        this.f2449b = oSListItemView2;
        this.f2450c = oSListItemView3;
        this.f2451d = oSListItemView4;
        this.e = oSListItemView5;
        this.f2452h = oSListItemView6;
        this.f2453i = oSListItemView7;
        this.f2454j = oSListItemView8;
        this.f2455k = oSListItemView9;
        this.f2456l = oSListItemView10;
        this.f2457m = textView;
        this.f2458n = viewPager2;
    }
}
