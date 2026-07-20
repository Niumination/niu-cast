package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import com.transsion.widgetslib.view.OSCheckBox;
import kotlin.jvm.internal.Intrinsics;
import qd.k;
import tj.x;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class DialogPcRequestConnectBindingImpl extends DialogPcRequestConnectBinding implements a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final SparseIntArray f2530l;
    public final TextView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RelativeLayout f2531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f2532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x f2533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f2534k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2530l = sparseIntArray;
        sparseIntArray.put(R$id.ll_title, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DialogPcRequestConnectBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding.IncludedLayouts) null, f2530l);
        OSCheckBox oSCheckBox = (OSCheckBox) objArrMapBindings[4];
        super(dataBindingComponent, view, oSCheckBox, (RelativeLayout) objArrMapBindings[0], (TextView) objArrMapBindings[2]);
        this.f2533j = new x(this);
        this.f2534k = -1L;
        this.f2526a.setTag(null);
        TextView textView = (TextView) objArrMapBindings[1];
        this.e = textView;
        textView.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArrMapBindings[3];
        this.f2531h = relativeLayout;
        relativeLayout.setTag(null);
        this.f2527b.setTag(null);
        this.f2528c.setTag(null);
        setRootTag(view);
        this.f2532i = new k(1, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        PcRequestConnectViewModel pcRequestConnectViewModel = this.f2529d;
        if (pcRequestConnectViewModel != null) {
            MutableLiveData mutableLiveData = pcRequestConnectViewModel.e;
            mutableLiveData.setValue(Boolean.valueOf(Intrinsics.areEqual(mutableLiveData.getValue(), Boolean.FALSE)));
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.DialogPcRequestConnectBinding
    public final void d(PcRequestConnectViewModel pcRequestConnectViewModel) {
        this.f2529d = pcRequestConnectViewModel;
        synchronized (this) {
            this.f2534k |= 8;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        String str;
        String str2;
        synchronized (this) {
            j8 = this.f2534k;
            this.f2534k = 0L;
        }
        PcRequestConnectViewModel pcRequestConnectViewModel = this.f2529d;
        boolean zSafeUnbox = false;
        if ((31 & j8) != 0) {
            if ((j8 & 25) == 0) {
                str2 = null;
            } else {
                MutableLiveData mutableLiveData = pcRequestConnectViewModel != null ? pcRequestConnectViewModel.f2749c : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    str2 = (String) mutableLiveData.getValue();
                } else {
                    str2 = null;
                }
            }
            if ((j8 & 26) != 0) {
                MutableLiveData mutableLiveData2 = pcRequestConnectViewModel != null ? pcRequestConnectViewModel.e : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? (Boolean) mutableLiveData2.getValue() : null);
            }
            if ((j8 & 28) == 0) {
                str = null;
            } else {
                MutableLiveData mutableLiveData3 = pcRequestConnectViewModel != null ? pcRequestConnectViewModel.f2748b : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    str = (String) mutableLiveData3.getValue();
                } else {
                    str = null;
                }
            }
        } else {
            str = null;
            str2 = null;
        }
        if ((26 & j8) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f2526a, zSafeUnbox);
        }
        if ((16 & j8) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.f2526a, null, this.f2533j);
            this.f2531h.setOnClickListener(this.f2532i);
        }
        if ((28 & j8) != 0) {
            TextViewBindingAdapter.setText(this.e, str);
        }
        if ((j8 & 25) != 0) {
            TextViewBindingAdapter.setText(this.f2528c, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2534k != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2534k = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        if (i8 == 0) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2534k |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2534k |= 2;
            }
            return true;
        }
        if (i8 != 2) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2534k |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (29 != i8) {
            return false;
        }
        d((PcRequestConnectViewModel) obj);
        return true;
    }
}
