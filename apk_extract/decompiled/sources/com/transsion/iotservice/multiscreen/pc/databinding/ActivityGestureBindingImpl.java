package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.RoundedCardData;
import com.transsion.iotservice.multiscreen.pc.ui.gesture.GestureViewModel;
import sa.d;
import tb.b;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityGestureBindingImpl extends ActivityGestureBinding {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ViewDataBinding.IncludedLayouts f2445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f2446n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2447l;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f2445m = includedLayouts;
        int i8 = R$layout.os_list_item_layout_item_long_divide_line;
        includedLayouts.setIncludes(1, new String[]{"os_list_item_layout_item_long_divide_line", "os_list_item_layout_item_long_divide_line"}, new int[]{6, 7}, new int[]{i8, i8});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2446n = sparseIntArray;
        sparseIntArray.put(R$id.damping_layout, 8);
        sparseIntArray.put(R$id.os_mask_status_bar, 9);
        sparseIntArray.put(R$id.liquidBar, 10);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityGestureBinding
    public final void d(b bVar) {
        this.f2444k = bVar;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityGestureBinding
    public final void e(GestureViewModel gestureViewModel) {
        this.f2443j = gestureViewModel;
        synchronized (this) {
            this.f2447l |= 128;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c4  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        RoundedCardData roundedCardData;
        RoundedCardData roundedCardData2;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        synchronized (this) {
            j8 = this.f2447l;
            this.f2447l = 0L;
        }
        GestureViewModel gestureViewModel = this.f2443j;
        if ((411 & j8) != 0) {
            if ((j8 & 385) == 0) {
                roundedCardData = null;
            } else {
                MutableLiveData mutableLiveData = gestureViewModel != null ? gestureViewModel.f2772d : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    roundedCardData = (RoundedCardData) mutableLiveData.getValue();
                } else {
                    roundedCardData = null;
                }
            }
            if ((j8 & 386) != 0) {
                MutableLiveData mutableLiveData2 = gestureViewModel != null ? gestureViewModel.f2770b : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? (Boolean) mutableLiveData2.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j8 & 392) == 0) {
                roundedCardData2 = null;
            } else {
                MutableLiveData mutableLiveData3 = gestureViewModel != null ? gestureViewModel.f : null;
                updateLiveDataRegistration(3, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    roundedCardData2 = (RoundedCardData) mutableLiveData3.getValue();
                } else {
                    roundedCardData2 = null;
                }
            }
            if ((j8 & 400) != 0) {
                MutableLiveData mutableLiveData4 = gestureViewModel != null ? gestureViewModel.f2769a : null;
                updateLiveDataRegistration(4, mutableLiveData4);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveData4 != null ? (Boolean) mutableLiveData4.getValue() : null);
            }
            if ((392 & j8) != 0) {
                d.k(this.f2437a, roundedCardData2);
            }
            if ((400 & j8) != 0) {
                d.e(this.f2439c, zSafeUnbox2);
            }
            if ((j8 & 386) != 0) {
                d.e(this.f2440d, zSafeUnbox);
            }
            if ((j8 & 385) != 0) {
                d.k(this.f2441h, roundedCardData);
            }
            ViewDataBinding.executeBindingsOn(this.f2442i);
            ViewDataBinding.executeBindingsOn(this.f2438b);
        }
        roundedCardData = null;
        roundedCardData2 = null;
        zSafeUnbox = false;
        zSafeUnbox2 = false;
        if ((392 & j8) != 0) {
            d.k(this.f2437a, roundedCardData2);
        }
        if ((400 & j8) != 0) {
            d.e(this.f2439c, zSafeUnbox2);
        }
        if ((j8 & 386) != 0) {
            d.e(this.f2440d, zSafeUnbox);
        }
        if ((j8 & 385) != 0) {
            d.k(this.f2441h, roundedCardData);
        }
        ViewDataBinding.executeBindingsOn(this.f2442i);
        ViewDataBinding.executeBindingsOn(this.f2438b);
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f2447l != 0) {
                    return true;
                }
                return this.f2442i.hasPendingBindings() || this.f2438b.hasPendingBindings();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2447l = 256L;
        }
        this.f2442i.invalidateAll();
        this.f2438b.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        if (i8 == 0) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2447l |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2447l |= 2;
            }
            return true;
        }
        if (i8 == 2) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2447l |= 4;
            }
            return true;
        }
        if (i8 == 3) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2447l |= 8;
            }
            return true;
        }
        if (i8 == 4) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2447l |= 16;
            }
            return true;
        }
        if (i8 != 5) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2447l |= 32;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f2442i.setLifecycleOwner(lifecycleOwner);
        this.f2438b.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (3 == i8) {
            this.f2444k = (b) obj;
        } else {
            if (26 != i8) {
                return false;
            }
            e((GestureViewModel) obj);
        }
        return true;
    }
}
