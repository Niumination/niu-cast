package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAsset;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.view.CustomLottieView;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import sa.d;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityTrustDevicesBindingImpl extends ActivityTrustDevicesBinding {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SparseIntArray f2513k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f2514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2515j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2513k = sparseIntArray;
        sparseIntArray.put(R$id.damping_layout, 4);
        sparseIntArray.put(R$id.rv_trust_devices, 5);
        sparseIntArray.put(R$id.os_mask_status_bar, 6);
        sparseIntArray.put(R$id.liquidBar, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityTrustDevicesBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding.IncludedLayouts) null, f2513k);
        CustomLottieView customLottieView = (CustomLottieView) objArrMapBindings[3];
        OSLiquidToolBar oSLiquidToolBar = (OSLiquidToolBar) objArrMapBindings[7];
        LinearLayout linearLayout = (LinearLayout) objArrMapBindings[2];
        super(dataBindingComponent, view, customLottieView, oSLiquidToolBar, linearLayout, (RecyclerView) objArrMapBindings[5]);
        this.f2515j = -1L;
        this.f2508a.setTag(null);
        this.f2510c.setTag(null);
        ((FrameLayout) objArrMapBindings[0]).setTag(null);
        TextView textView = (TextView) objArrMapBindings[1];
        this.f2514i = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityTrustDevicesBinding
    public final void d(SharedViewModel sharedViewModel) {
        this.f2512h = sharedViewModel;
        synchronized (this) {
            this.f2515j |= 8;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityTrustDevicesBinding
    public final void e(TrustDevicesViewModel trustDevicesViewModel) {
        this.e = trustDevicesViewModel;
        synchronized (this) {
            this.f2515j |= 32;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        Boolean bool;
        int i8;
        synchronized (this) {
            j8 = this.f2515j;
            this.f2515j = 0L;
        }
        SharedViewModel sharedViewModel = this.f2512h;
        TrustDevicesViewModel trustDevicesViewModel = this.e;
        LottieAsset lottieAsset = null;
        if ((j8 & 110) == 0) {
            bool = null;
        } else {
            LiveData<?> liveData = sharedViewModel != null ? sharedViewModel.f2701b : null;
            updateLiveDataRegistration(1, liveData);
            if (liveData != null) {
                bool = (Boolean) liveData.getValue();
            } else {
                bool = null;
            }
        }
        int i9 = 0;
        if ((111 & j8) != 0) {
            long j10 = j8 & 97;
            if (j10 != 0) {
                ObservableInt observableInt = trustDevicesViewModel != null ? trustDevicesViewModel.e : null;
                updateRegistration(0, observableInt);
                int i10 = observableInt != null ? observableInt.get() : 0;
                boolean z2 = i10 == 0;
                if (j10 != 0) {
                    j8 |= z2 ? 256L : 128L;
                }
                i8 = z2 ? 8 : 0;
                i9 = i10;
            } else {
                i8 = 0;
            }
            if ((j8 & 110) != 0) {
                LiveData<?> liveData2 = trustDevicesViewModel != null ? trustDevicesViewModel.f2892d : null;
                updateLiveDataRegistration(2, liveData2);
                if (liveData2 != null) {
                    lottieAsset = (LottieAsset) liveData2.getValue();
                }
            }
        } else {
            i8 = 0;
        }
        if ((j8 & 110) != 0) {
            d.a(this.f2508a, lottieAsset, bool);
        }
        if ((j8 & 97) != 0) {
            this.f2510c.setVisibility(i9);
            this.f2514i.setVisibility(i8);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2515j != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2515j = 64L;
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
                this.f2515j |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2515j |= 2;
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
            this.f2515j |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (22 == i8) {
            d((SharedViewModel) obj);
        } else if (3 == i8) {
        } else {
            if (26 != i8) {
                return false;
            }
            e((TrustDevicesViewModel) obj);
        }
        return true;
    }
}
