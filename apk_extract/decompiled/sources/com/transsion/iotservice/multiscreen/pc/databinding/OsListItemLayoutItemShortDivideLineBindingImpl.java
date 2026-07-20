package com.transsion.iotservice.multiscreen.pc.databinding;

/* JADX INFO: loaded from: classes2.dex */
public class OsListItemLayoutItemShortDivideLineBindingImpl extends OsListItemLayoutItemShortDivideLineBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2657a;

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        synchronized (this) {
            this.f2657a = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2657a != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2657a = 1L;
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
