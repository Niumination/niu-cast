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
public abstract class ActivityPcConnectSettingPadBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSListItemView f2468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSListItemView f2469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSListItemView f2470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OSListItemView f2471d;
    public final OSListItemView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OSListItemView f2472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OSListItemView f2473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f2474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewPager2 f2475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PcConnectSettingViewModel f2476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PageIndicatorWrapper f2477m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SettingsCarouselAdapter f2478n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l f2479o;

    public ActivityPcConnectSettingPadBinding(DataBindingComponent dataBindingComponent, View view, OSListItemView oSListItemView, OSListItemView oSListItemView2, OSListItemView oSListItemView3, OSListItemView oSListItemView4, OSListItemView oSListItemView5, OSListItemView oSListItemView6, OSListItemView oSListItemView7, TextView textView, ViewPager2 viewPager2) {
        super((Object) dataBindingComponent, view, 9);
        this.f2468a = oSListItemView;
        this.f2469b = oSListItemView2;
        this.f2470c = oSListItemView3;
        this.f2471d = oSListItemView4;
        this.e = oSListItemView5;
        this.f2472h = oSListItemView6;
        this.f2473i = oSListItemView7;
        this.f2474j = textView;
        this.f2475k = viewPager2;
    }
}
