package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import com.transsion.iotservice.multiscreen.pc.bean.ViewLayoutParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class ModulePcItemPcNewBindingImpl extends ModulePcItemPcNewBinding {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SparseIntArray f2654k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2655j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2654k = sparseIntArray;
        sparseIntArray.put(R$id.rl_item_pc_all, 4);
        sparseIntArray.put(R$id.fl_item_pc_icon, 5);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcItemPcNewBinding
    public final void d(PcBleScanedDeviceBean pcBleScanedDeviceBean) {
        this.e = pcBleScanedDeviceBean;
        synchronized (this) {
            this.f2655j |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcItemPcNewBinding
    public final void e(Integer num) {
        this.f2652h = num;
        synchronized (this) {
            this.f2655j |= 4;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        int i8;
        String mDeviceName;
        boolean mIsHistoryConnected;
        synchronized (this) {
            j8 = this.f2655j;
            this.f2655j = 0L;
        }
        ViewLayoutParams viewLayoutParams = this.f2653i;
        PcBleScanedDeviceBean pcBleScanedDeviceBean = this.e;
        Integer num = this.f2652h;
        long j10 = j8 & 10;
        String str = null;
        if (j10 != 0) {
            if (pcBleScanedDeviceBean != null) {
                mIsHistoryConnected = pcBleScanedDeviceBean.getMIsHistoryConnected();
                mDeviceName = pcBleScanedDeviceBean.getMDeviceName();
            } else {
                mDeviceName = null;
                mIsHistoryConnected = false;
            }
            if (j10 != 0) {
                j8 |= mIsHistoryConnected ? 32L : 16L;
            }
            i8 = mIsHistoryConnected ? 0 : 8;
            str = mDeviceName;
        } else {
            i8 = 0;
        }
        long j11 = 12 & j8;
        int iSafeUnbox = j11 != 0 ? ViewDataBinding.safeUnbox(num) : 0;
        if ((j8 & 10) != 0) {
            this.f2648a.setVisibility(i8);
            TextViewBindingAdapter.setText(this.f2651d, str);
        }
        if (j11 != 0) {
            ImageView view = this.f2649b;
            Intrinsics.checkNotNullParameter(view, "view");
            view.setBackgroundResource(iSafeUnbox);
        }
        if ((j8 & 9) != 0) {
            ImageView view2 = this.f2649b;
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(viewLayoutParams, "viewLayoutParams");
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = viewLayoutParams.getWidth();
            layoutParams.height = viewLayoutParams.getHeight();
            view2.setLayoutParams(layoutParams);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcItemPcNewBinding
    public final void f(ViewLayoutParams viewLayoutParams) {
        this.f2653i = viewLayoutParams;
        synchronized (this) {
            this.f2655j |= 1;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2655j != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2655j = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (16 == i8) {
            f((ViewLayoutParams) obj);
        } else if (7 == i8) {
            d((PcBleScanedDeviceBean) obj);
        } else {
            if (15 != i8) {
                return false;
            }
            e((Integer) obj);
        }
        return true;
    }
}
