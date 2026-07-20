package com.transsion.iotservice.multiscreen.pc.databinding;

import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.bean.CarouselItem;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAsset;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import sa.d;

/* JADX INFO: loaded from: classes2.dex */
public class ItemSettingCarouselLottieBindingImpl extends ItemSettingCarouselLottieBinding {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2609d;

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemSettingCarouselLottieBinding
    public final void d(CarouselItem carouselItem) {
        this.f2607b = carouselItem;
        synchronized (this) {
            this.f2609d |= 4;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemSettingCarouselLottieBinding
    public final void e(SharedViewModel sharedViewModel) {
        this.f2608c = sharedViewModel;
        synchronized (this) {
            this.f2609d |= 2;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        Boolean bool;
        synchronized (this) {
            j8 = this.f2609d;
            this.f2609d = 0L;
        }
        SharedViewModel sharedViewModel = this.f2608c;
        CarouselItem carouselItem = this.f2607b;
        long j10 = j8 & 15;
        LottieAsset lottieAsset = null;
        if (j10 != 0) {
            MutableLiveData mutableLiveData = sharedViewModel != null ? sharedViewModel.f2701b : null;
            updateLiveDataRegistration(0, mutableLiveData);
            LottieAsset lottie = carouselItem != null ? carouselItem.getLottie() : null;
            bool = mutableLiveData != null ? (Boolean) mutableLiveData.getValue() : null;
            lottieAsset = lottie;
        } else {
            bool = null;
        }
        if (j10 != 0) {
            d.a(this.f2606a, lottieAsset, bool);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2609d != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2609d = 8L;
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
            this.f2609d |= 1;
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
            d((CarouselItem) obj);
        }
        return true;
    }
}
