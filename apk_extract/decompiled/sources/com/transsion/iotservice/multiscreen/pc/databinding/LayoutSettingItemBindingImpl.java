package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import com.transsion.iotservice.multiscreen.pc.R$id;

/* JADX INFO: loaded from: classes2.dex */
public class LayoutSettingItemBindingImpl extends LayoutSettingItemBinding {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SparseIntArray f2635h;
    public long e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2635h = sparseIntArray;
        sparseIntArray.put(R$id.list_item_layout, 1);
        sparseIntArray.put(R$id.vp_lottie, 2);
        sparseIntArray.put(R$id.indicator, 3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        synchronized (this) {
            this.e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.e != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.e = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        return true;
    }
}
