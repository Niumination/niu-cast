package com.transsion.iotservice.multiscreen.pc.databinding;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsLottieAdapter;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcTransferSettingViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.view.SettingItemView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import pb.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityPcTransferSettingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SettingItemView f2488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OverBoundNestedScrollView f2489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PcTransferSettingViewModel f2490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SettingsLottieAdapter f2491d;
    public a e;

    public ActivityPcTransferSettingBinding(DataBindingComponent dataBindingComponent, View view, SettingItemView settingItemView, OverBoundNestedScrollView overBoundNestedScrollView) {
        super((Object) dataBindingComponent, view, 3);
        this.f2488a = settingItemView;
        this.f2489b = overBoundNestedScrollView;
    }

    public abstract void d(SettingsLottieAdapter settingsLottieAdapter);

    public abstract void e(a aVar);

    public abstract void f(PcTransferSettingViewModel pcTransferSettingViewModel);
}
