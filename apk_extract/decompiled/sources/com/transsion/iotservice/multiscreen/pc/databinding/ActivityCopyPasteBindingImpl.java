package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.RoundedCardData;
import com.transsion.iotservice.multiscreen.pc.ui.copy.CopyPastViewModel;
import rb.b;
import sa.d;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityCopyPasteBindingImpl extends ActivityCopyPasteBinding {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ViewDataBinding.IncludedLayouts f2424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final SparseIntArray f2425l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2426j;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f2424k = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"os_list_item_layout_item_long_divide_line"}, new int[]{5}, new int[]{R$layout.os_list_item_layout_item_long_divide_line});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2425l = sparseIntArray;
        sparseIntArray.put(R$id.damping_layout, 6);
        sparseIntArray.put(R$id.os_mask_status_bar, 7);
        sparseIntArray.put(R$id.liquidBar, 8);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityCopyPasteBinding
    public final void d(b bVar) {
        this.f2423i = bVar;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityCopyPasteBinding
    public final void e(CopyPastViewModel copyPastViewModel) {
        this.f2422h = copyPastViewModel;
        synchronized (this) {
            this.f2426j |= 32;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c6  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        boolean z2;
        boolean zSafeUnbox;
        int i8;
        RoundedCardData roundedCardData;
        boolean z3;
        synchronized (this) {
            j8 = this.f2426j;
            this.f2426j = 0L;
        }
        CopyPastViewModel copyPastViewModel = this.f2422h;
        if ((110 & j8) != 0) {
            if ((j8 & 98) != 0) {
                MutableLiveData mutableLiveData = copyPastViewModel != null ? copyPastViewModel.f2709d : null;
                updateLiveDataRegistration(1, mutableLiveData);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? (Boolean) mutableLiveData.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            long j10 = j8 & 100;
            if (j10 != 0) {
                MutableLiveData mutableLiveData2 = copyPastViewModel != null ? copyPastViewModel.f2706a : null;
                updateLiveDataRegistration(2, mutableLiveData2);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? (Boolean) mutableLiveData2.getValue() : null);
                if (j10 != 0) {
                    j8 |= zSafeUnbox2 ? 256L : 128L;
                }
                z3 = zSafeUnbox2;
                i8 = zSafeUnbox2 ? 0 : 8;
            } else {
                i8 = 0;
                z3 = false;
            }
            if ((j8 & 104) != 0) {
                MutableLiveData mutableLiveData3 = copyPastViewModel != null ? copyPastViewModel.f2708c : null;
                updateLiveDataRegistration(3, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    roundedCardData = (RoundedCardData) mutableLiveData3.getValue();
                    z2 = z3;
                }
                if ((100 & j8) != 0) {
                    this.f2418a.getRoot().setVisibility(i8);
                    d.e(this.f2419b, z2);
                    this.f2420c.setVisibility(i8);
                    this.e.setVisibility(i8);
                }
                if ((j8 & 98) != 0) {
                    d.e(this.f2420c, zSafeUnbox);
                }
                if ((j8 & 104) != 0) {
                    d.k(this.e, roundedCardData);
                }
                ViewDataBinding.executeBindingsOn(this.f2418a);
            }
            z2 = z3;
        } else {
            z2 = false;
            zSafeUnbox = false;
            i8 = 0;
        }
        roundedCardData = null;
        if ((100 & j8) != 0) {
            this.f2418a.getRoot().setVisibility(i8);
            d.e(this.f2419b, z2);
            this.f2420c.setVisibility(i8);
            this.e.setVisibility(i8);
        }
        if ((j8 & 98) != 0) {
            d.e(this.f2420c, zSafeUnbox);
        }
        if ((j8 & 104) != 0) {
            d.k(this.e, roundedCardData);
        }
        ViewDataBinding.executeBindingsOn(this.f2418a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f2426j != 0) {
                    return true;
                }
                return this.f2418a.hasPendingBindings();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2426j = 64L;
        }
        this.f2418a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        if (i8 == 0) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2426j |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2426j |= 2;
            }
            return true;
        }
        if (i8 == 2) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2426j |= 4;
            }
            return true;
        }
        if (i8 != 3) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2426j |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f2418a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (3 == i8) {
            this.f2423i = (b) obj;
        } else {
            if (26 != i8) {
                return false;
            }
            e((CopyPastViewModel) obj);
        }
        return true;
    }
}
