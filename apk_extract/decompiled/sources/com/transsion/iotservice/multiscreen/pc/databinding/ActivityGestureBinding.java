package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.gesture.GestureViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.view.RoundedCardView;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import tb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityGestureBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundedCardView f2437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OsListItemLayoutItemLongDivideLineBinding f2438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSListItemView f2439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OSListItemView f2440d;
    public final OSLiquidToolBar e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RoundedCardView f2441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OsListItemLayoutItemLongDivideLineBinding f2442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GestureViewModel f2443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f2444k;

    public ActivityGestureBinding(DataBindingComponent dataBindingComponent, View view, RoundedCardView roundedCardView, OsListItemLayoutItemLongDivideLineBinding osListItemLayoutItemLongDivideLineBinding, OSListItemView oSListItemView, OSListItemView oSListItemView2, OSLiquidToolBar oSLiquidToolBar, RoundedCardView roundedCardView2, OsListItemLayoutItemLongDivideLineBinding osListItemLayoutItemLongDivideLineBinding2) {
        super((Object) dataBindingComponent, view, 6);
        this.f2437a = roundedCardView;
        this.f2438b = osListItemLayoutItemLongDivideLineBinding;
        this.f2439c = oSListItemView;
        this.f2440d = oSListItemView2;
        this.e = oSLiquidToolBar;
        this.f2441h = roundedCardView2;
        this.f2442i = osListItemLayoutItemLongDivideLineBinding2;
    }

    public abstract void d(b bVar);

    public abstract void e(GestureViewModel gestureViewModel);
}
