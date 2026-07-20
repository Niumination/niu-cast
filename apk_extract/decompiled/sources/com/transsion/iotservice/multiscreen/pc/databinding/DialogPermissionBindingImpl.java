package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import com.transsion.iotservice.multiscreen.pc.R$id;

/* JADX INFO: loaded from: classes2.dex */
public class DialogPermissionBindingImpl extends DialogPermissionBinding {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f2535b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2536a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2535b = sparseIntArray;
        sparseIntArray.put(R$id.tv_title, 1);
        sparseIntArray.put(R$id.tv_tips, 2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        synchronized (this) {
            this.f2536a = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2536a != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2536a = 1L;
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
