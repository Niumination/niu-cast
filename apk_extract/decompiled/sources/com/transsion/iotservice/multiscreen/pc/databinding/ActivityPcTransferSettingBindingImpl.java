package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsLottieAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.LottieItem;
import com.transsion.iotservice.multiscreen.pc.bean.SettingItem;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcTransferSettingViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.view.SettingItemView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetslib.view.indicator.SpringPageIndicator;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qd.k;
import td.e;
import ya.a;
import za.b;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityPcTransferSettingBindingImpl extends ActivityPcTransferSettingBinding implements a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f2492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f2493i;

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityPcTransferSettingBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
        super(dataBindingComponent, view, (SettingItemView) objArrMapBindings[1], (OverBoundNestedScrollView) objArrMapBindings[0]);
        this.f2493i = -1L;
        this.f2488a.setTag(null);
        this.f2489b.setTag(null);
        setRootTag(view);
        this.f2492h = new k(1, 2, this);
        invalidateAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ya.a
    public final void b(int i8) {
        pb.a aVar = this.e;
        if (aVar != null) {
            PcTransferSettingViewModel pcTransferSettingViewModel = aVar.f8711a.f2677b;
            if (pcTransferSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingViewModel");
                pcTransferSettingViewModel = null;
            }
            Boolean bool = (Boolean) pcTransferSettingViewModel.f2881c.getValue();
            boolean z2 = false;
            if (bool != null && !bool.booleanValue()) {
                z2 = true;
            }
            b.b(z2);
            ob.b.f8417b.q(z2);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcTransferSettingBinding
    public final void d(SettingsLottieAdapter settingsLottieAdapter) {
        this.f2491d = settingsLottieAdapter;
        synchronized (this) {
            this.f2493i |= 16;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcTransferSettingBinding
    public final void e(pb.a aVar) {
        this.e = aVar;
        synchronized (this) {
            this.f2493i |= 8;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0047 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0066 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        boolean zSafeUnbox;
        int i8;
        ArrayList<LottieItem> data;
        SettingItem settingItem;
        SettingItem settingItem2;
        int iSafeUnbox;
        MutableLiveData mutableLiveData;
        Boolean bool;
        MutableLiveData mutableLiveData2;
        Integer num;
        synchronized (this) {
            j8 = this.f2493i;
            this.f2493i = 0L;
        }
        SettingsLottieAdapter settingsLottieAdapter = this.f2491d;
        PcTransferSettingViewModel pcTransferSettingViewModel = this.f2490c;
        long j10 = 113 & j8;
        if ((119 & j8) != 0) {
            if (j10 != 0) {
                MutableLiveData mutableLiveData3 = pcTransferSettingViewModel != null ? pcTransferSettingViewModel.f2880b : null;
                updateLiveDataRegistration(0, mutableLiveData3);
                settingItem2 = mutableLiveData3 != null ? (SettingItem) mutableLiveData3.getValue() : null;
                data = settingItem2 != null ? settingItem2.getData() : null;
                if ((j8 & 98) != 0) {
                    if (pcTransferSettingViewModel != null) {
                        mutableLiveData2 = pcTransferSettingViewModel.e;
                    } else {
                        mutableLiveData2 = null;
                    }
                    updateLiveDataRegistration(1, mutableLiveData2);
                    if (mutableLiveData2 != null) {
                        num = (Integer) mutableLiveData2.getValue();
                    } else {
                        num = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(num);
                } else {
                    iSafeUnbox = 0;
                }
                if ((j8 & 100) != 0) {
                    if (pcTransferSettingViewModel != null) {
                        mutableLiveData = pcTransferSettingViewModel.f2881c;
                    } else {
                        mutableLiveData = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveData);
                    if (mutableLiveData != null) {
                        bool = (Boolean) mutableLiveData.getValue();
                    } else {
                        bool = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool);
                } else {
                    zSafeUnbox = false;
                }
                int i9 = iSafeUnbox;
                settingItem = settingItem2;
                i8 = i9;
            } else {
                settingItem2 = null;
            }
            if ((j8 & 98) != 0) {
                if (pcTransferSettingViewModel != null) {
                    mutableLiveData2 = pcTransferSettingViewModel.e;
                } else {
                    mutableLiveData2 = null;
                }
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    num = (Integer) mutableLiveData2.getValue();
                } else {
                    num = null;
                }
                iSafeUnbox = ViewDataBinding.safeUnbox(num);
            } else {
                iSafeUnbox = 0;
            }
            if ((j8 & 100) != 0) {
                if (pcTransferSettingViewModel != null) {
                    mutableLiveData = pcTransferSettingViewModel.f2881c;
                } else {
                    mutableLiveData = null;
                }
                updateLiveDataRegistration(2, mutableLiveData);
                if (mutableLiveData != null) {
                    bool = (Boolean) mutableLiveData.getValue();
                } else {
                    bool = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            } else {
                zSafeUnbox = false;
            }
            int i10 = iSafeUnbox;
            settingItem = settingItem2;
            i8 = i10;
        } else {
            zSafeUnbox = false;
            i8 = 0;
            data = null;
            settingItem = null;
        }
        if ((j8 & 64) != 0) {
            this.f2488a.setItemClickEvent(this.f2492h);
        }
        if ((97 & j8) != 0) {
            this.f2488a.setItemContent(settingItem);
        }
        if ((100 & j8) != 0) {
            this.f2488a.setSwitchState(zSafeUnbox);
        }
        if ((j8 & 98) != 0) {
            this.f2488a.setViewPagerIndex(i8);
        }
        if (j10 != 0) {
            SettingItemView vp = this.f2488a;
            Intrinsics.checkNotNullParameter(vp, "vp");
            if (vp.getF2906b() == null) {
                if (data != null && data.size() > 1) {
                    PageIndicatorWrapper pageIndicatorWrapper = vp.f2905a.f2632b;
                    int size = data.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        SpringPageIndicator springPageIndicator = pageIndicatorWrapper.f3272a;
                        springPageIndicator.A.add(new e());
                        if (springPageIndicator.f3291x == null || springPageIndicator.f3289v == null) {
                            springPageIndicator.B = 0;
                            springPageIndicator.C = 0;
                            e eVar = (e) springPageIndicator.A.get(0);
                            springPageIndicator.f3289v = eVar;
                            springPageIndicator.f3291x = eVar;
                        }
                        springPageIndicator.d();
                        springPageIndicator.a();
                        springPageIndicator.requestLayout();
                    }
                    pageIndicatorWrapper.getClass();
                }
                if (settingsLottieAdapter != null) {
                    vp.setViewPagerAdapter(settingsLottieAdapter);
                    settingsLottieAdapter.submitList(data);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcTransferSettingBinding
    public final void f(PcTransferSettingViewModel pcTransferSettingViewModel) {
        this.f2490c = pcTransferSettingViewModel;
        synchronized (this) {
            this.f2493i |= 32;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2493i != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2493i = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        if (i8 == 0) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2493i |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2493i |= 2;
            }
            return true;
        }
        if (i8 != 2) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2493i |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (4 == i8) {
            e((pb.a) obj);
            return true;
        }
        if (1 == i8) {
            d((SettingsLottieAdapter) obj);
            return true;
        }
        if (26 != i8) {
            return false;
        }
        f((PcTransferSettingViewModel) obj);
        return true;
    }
}
