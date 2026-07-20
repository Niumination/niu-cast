package com.transsion.iotservice.multiscreen.pc.databinding;

import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAsset;
import com.transsion.iotservice.multiscreen.pc.bean.LottieItem;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import sa.d;

/* JADX INFO: loaded from: classes2.dex */
public class ItemSettingLottieBindingImpl extends ItemSettingLottieBinding {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2614h;

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemSettingLottieBinding
    public final void d(LottieItem lottieItem) {
        this.f2613d = lottieItem;
        synchronized (this) {
            this.f2614h |= 4;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemSettingLottieBinding
    public final void e(SharedViewModel sharedViewModel) {
        this.e = sharedViewModel;
        synchronized (this) {
            this.f2614h |= 2;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        int i8;
        Boolean bool;
        synchronized (this) {
            j8 = this.f2614h;
            this.f2614h = 0L;
        }
        SharedViewModel sharedViewModel = this.e;
        LottieItem lottieItem = this.f2613d;
        long j10 = 15 & j8;
        int i9 = 0;
        LottieAsset lottieAsset = null;
        if (j10 != 0) {
            MutableLiveData mutableLiveData = sharedViewModel != null ? sharedViewModel.f2701b : null;
            updateLiveDataRegistration(0, mutableLiveData);
            LottieAsset lottie = lottieItem != null ? lottieItem.getLottie() : null;
            Boolean bool2 = mutableLiveData != null ? (Boolean) mutableLiveData.getValue() : null;
            if ((j8 & 12) == 0 || lottieItem == null) {
                i8 = 0;
                bool = bool2;
                lottieAsset = lottie;
            } else {
                int title = lottieItem.getTitle();
                int desc = lottieItem.getDesc();
                bool = bool2;
                lottieAsset = lottie;
                i9 = desc;
                i8 = title;
            }
        } else {
            i8 = 0;
            bool = null;
        }
        if (j10 != 0) {
            d.a(this.f2610a, lottieAsset, bool);
        }
        if ((j8 & 12) != 0) {
            this.f2611b.setText(i9);
            this.f2612c.setText(i8);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2614h != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2614h = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        if (i8 != 0) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2614h |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (22 == i8) {
            e((SharedViewModel) obj);
        } else {
            if (6 != i8) {
                return false;
            }
            d((LottieItem) obj);
        }
        return true;
    }
}
