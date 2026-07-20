package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import com.transsion.iotservice.multiscreen.pc.R$id;
import pb.b;

/* JADX INFO: loaded from: classes2.dex */
public class ModulePcActivityHelperBindingImpl extends ModulePcActivityHelperBinding {
    public static final SparseIntArray p;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2647o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R$id.pc_client_helper_des, 6);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcActivityHelperBinding
    public final void d(b bVar) {
        this.f2644l = bVar;
        synchronized (this) {
            this.f2647o |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcActivityHelperBinding
    public final void e(b bVar) {
        this.f2642j = bVar;
        synchronized (this) {
            this.f2647o |= 16;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        synchronized (this) {
            j8 = this.f2647o;
            this.f2647o = 0L;
        }
        b bVar = this.f2644l;
        b bVar2 = this.f2643k;
        b bVar3 = this.f2645m;
        b bVar4 = this.f2646n;
        b bVar5 = this.f2642j;
        long j10 = 33 & j8;
        long j11 = 34 & j8;
        long j12 = 36 & j8;
        long j13 = 40 & j8;
        long j14 = j8 & 48;
        if (j10 != 0) {
            this.f2636a.setContentItem(bVar);
        }
        if (j14 != 0) {
            this.f2637b.setContentItem(bVar5);
        }
        if (j13 != 0) {
            this.f2639d.setContentItem(bVar4);
        }
        if (j11 != 0) {
            this.e.setContentItem(bVar2);
        }
        if (j12 != 0) {
            this.f2641i.setContentItem(bVar3);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcActivityHelperBinding
    public final void f(b bVar) {
        this.f2646n = bVar;
        synchronized (this) {
            this.f2647o |= 8;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcActivityHelperBinding
    public final void g(b bVar) {
        this.f2643k = bVar;
        synchronized (this) {
            this.f2647o |= 2;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ModulePcActivityHelperBinding
    public final void h(b bVar) {
        this.f2645m = bVar;
        synchronized (this) {
            this.f2647o |= 4;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2647o != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2647o = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (13 == i8) {
            d((b) obj);
        } else if (19 == i8) {
            g((b) obj);
        } else if (25 == i8) {
            h((b) obj);
        } else if (18 == i8) {
            f((b) obj);
        } else {
            if (14 != i8) {
                return false;
            }
            e((b) obj);
        }
        return true;
    }
}
