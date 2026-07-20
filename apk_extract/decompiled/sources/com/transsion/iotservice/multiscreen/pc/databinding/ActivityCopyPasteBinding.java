package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.ui.copy.CopyPastViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.view.RoundedCardView;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import rb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityCopyPasteBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OsListItemLayoutItemLongDivideLineBinding f2418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSListItemView f2419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSListItemView f2420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OSLiquidToolBar f2421d;
    public final RoundedCardView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CopyPastViewModel f2422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f2423i;

    public ActivityCopyPasteBinding(DataBindingComponent dataBindingComponent, View view, OsListItemLayoutItemLongDivideLineBinding osListItemLayoutItemLongDivideLineBinding, OSListItemView oSListItemView, OSListItemView oSListItemView2, OSLiquidToolBar oSLiquidToolBar, RoundedCardView roundedCardView) {
        super((Object) dataBindingComponent, view, 4);
        this.f2418a = osListItemLayoutItemLongDivideLineBinding;
        this.f2419b = oSListItemView;
        this.f2420c = oSListItemView2;
        this.f2421d = oSLiquidToolBar;
        this.e = roundedCardView;
    }

    public abstract void d(b bVar);

    public abstract void e(CopyPastViewModel copyPastViewModel);
}
