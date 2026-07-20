package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import bc.d;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.TrustDeviceBean;
import com.transsion.widgetslistitemlayout.OSListItemView;
import qd.k;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class ItemTrustDeviceBindingImpl extends ItemTrustDeviceBinding implements a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ViewDataBinding.IncludedLayouts f2619k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OsListItemLayoutItemShortDivideLineBinding f2620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f2621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2622j;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f2619k = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"os_list_item_layout_item_short_divide_line"}, new int[]{2}, new int[]{R$layout.os_list_item_layout_item_short_divide_line});
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ItemTrustDeviceBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f2619k, (SparseIntArray) null);
        super(dataBindingComponent, view, (OSListItemView) objArrMapBindings[1]);
        this.f2622j = -1L;
        ((LinearLayout) objArrMapBindings[0]).setTag(null);
        OsListItemLayoutItemShortDivideLineBinding osListItemLayoutItemShortDivideLineBinding = (OsListItemLayoutItemShortDivideLineBinding) objArrMapBindings[2];
        this.f2620h = osListItemLayoutItemShortDivideLineBinding;
        setContainedBinding(osListItemLayoutItemShortDivideLineBinding);
        this.f2615a.setTag(null);
        setRootTag(view);
        this.f2621i = new k(1, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        d dVar = this.f2617c;
        TrustDeviceBean trustDeviceBean = this.f2616b;
        if (dVar != null) {
            dVar.a(trustDeviceBean);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemTrustDeviceBinding
    public final void d(d dVar) {
        this.f2617c = dVar;
        synchronized (this) {
            this.f2622j |= 8;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemTrustDeviceBinding
    public final void e(TrustDeviceBean trustDeviceBean) {
        this.f2616b = trustDeviceBean;
        synchronized (this) {
            this.f2622j |= 4;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002e A[PHI: r0
      0x002e: PHI (r0v2 long) = (r0v1 long), (r0v7 long) binds: [B:6:0x0015, B:16:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        int i8;
        String cornersAngleType;
        String str;
        synchronized (this) {
            j8 = this.f2622j;
            this.f2622j = 0L;
        }
        int i9 = this.f2618d;
        int i10 = this.e;
        TrustDeviceBean trustDeviceBean = this.f2616b;
        long j10 = j8 & 19;
        int i11 = 0;
        if (j10 != 0) {
            boolean z2 = i9 < i10 - 1;
            if (j10 != 0) {
                j8 |= z2 ? 64L : 32L;
            }
            if (z2) {
                i8 = 0;
            } else {
                i8 = 8;
            }
        } else {
            i8 = 0;
        }
        long j11 = 20 & j8;
        if (j11 == 0 || trustDeviceBean == null) {
            cornersAngleType = null;
            str = null;
        } else {
            String deviceName = trustDeviceBean.getDeviceName();
            int deviceIconResource = trustDeviceBean.getDeviceIconResource();
            cornersAngleType = trustDeviceBean.getCornersAngleType();
            str = deviceName;
            i11 = deviceIconResource;
        }
        if ((19 & j8) != 0) {
            this.f2620h.getRoot().setVisibility(i8);
        }
        if (j11 != 0) {
            sa.d.l(this.f2615a, i11);
            sa.d.c(this.f2615a, cornersAngleType);
            sa.d.f(this.f2615a, str, null);
        }
        if ((j8 & 16) != 0) {
            this.f2615a.setOnClickListener(this.f2621i);
        }
        ViewDataBinding.executeBindingsOn(this.f2620h);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemTrustDeviceBinding
    public final void f(int i8) {
        this.f2618d = i8;
        synchronized (this) {
            this.f2622j |= 1;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ItemTrustDeviceBinding
    public final void g(int i8) {
        this.e = i8;
        synchronized (this) {
            this.f2622j |= 2;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f2622j != 0) {
                    return true;
                }
                return this.f2620h.hasPendingBindings();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2622j = 16L;
        }
        this.f2620h.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f2620h.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (17 == i8) {
            f(((Integer) obj).intValue());
        } else if (23 == i8) {
            g(((Integer) obj).intValue());
        } else if (7 == i8) {
            e((TrustDeviceBean) obj);
        } else {
            if (3 != i8) {
                return false;
            }
            d((d) obj);
        }
        return true;
    }
}
