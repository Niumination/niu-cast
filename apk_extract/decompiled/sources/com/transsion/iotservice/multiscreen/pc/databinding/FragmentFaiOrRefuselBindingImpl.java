package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.d;
import qd.k;
import ya.a;
import yb.b;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentFaiOrRefuselBindingImpl extends FragmentFaiOrRefuselBinding implements a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final SparseIntArray f2579o;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k f2580l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f2581m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2582n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2579o = sparseIntArray;
        sparseIntArray.put(R$id.iv_connect_fail, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FragmentFaiOrRefuselBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding.IncludedLayouts) null, f2579o);
        super(dataBindingComponent, view, (Button) objArrMapBindings[2], (ImageView) objArrMapBindings[4], (ConstraintLayout) objArrMapBindings[0], (TextView) objArrMapBindings[1], (Button) objArrMapBindings[3]);
        this.f2582n = -1L;
        this.f2572a.setTag(null);
        this.f2574c.setTag(null);
        this.f2575d.setTag(null);
        this.e.setTag(null);
        setRootTag(view);
        this.f2580l = new k(2, 2, this);
        this.f2581m = new k(1, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        b bVar;
        if (i8 != 1) {
            if (i8 == 2 && (bVar = this.f2578j) != null) {
                bVar.a();
                return;
            }
            return;
        }
        b bVar2 = this.f2578j;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentFaiOrRefuselBinding
    public final void d(b bVar) {
        this.f2578j = bVar;
        synchronized (this) {
            this.f2582n |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentFaiOrRefuselBinding
    public final void e(DeviceViewModel deviceViewModel) {
        this.f2577i = deviceViewModel;
        synchronized (this) {
            this.f2582n |= 4;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        boolean zSafeUnbox;
        String strQ;
        synchronized (this) {
            j8 = this.f2582n;
            this.f2582n = 0L;
        }
        DeviceViewModel deviceViewModel = this.f2577i;
        SearchActivityViewModel searchActivityViewModel = this.f2576h;
        long j10 = 21 & j8;
        int i8 = 0;
        if (j10 != 0) {
            MutableLiveData mutableLiveData = deviceViewModel != null ? deviceViewModel.f2842i : null;
            updateLiveDataRegistration(0, mutableLiveData);
            zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? (Boolean) mutableLiveData.getValue() : null);
        } else {
            zSafeUnbox = false;
        }
        long j11 = 24 & j8;
        if (j11 != 0 && searchActivityViewModel != null) {
            i8 = searchActivityViewModel.f2853h;
        }
        if ((j8 & 16) != 0) {
            this.f2572a.setOnClickListener(this.f2581m);
            this.e.setOnClickListener(this.f2580l);
        }
        if (j10 != 0) {
            TextView view = this.f2575d;
            Intrinsics.checkNotNullParameter(view, "view");
            if (zSafeUnbox) {
                strQ = pb.a().getString(R$string.pc_module_application_rejected);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = pb.a().getString(R$string.connect_fail_desc);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                strQ = d.q(new Object[]{pb.a().getString(R$string.pc_module_qrscan_connect)}, 1, string, "format(...)");
            }
            view.setText(strQ);
        }
        if (j11 != 0) {
            sa.d.b(i8, this.e);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentFaiOrRefuselBinding
    public final void f(SearchActivityViewModel searchActivityViewModel) {
        this.f2576h = searchActivityViewModel;
        synchronized (this) {
            this.f2582n |= 8;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2582n != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2582n = 16L;
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
            this.f2582n |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (4 == i8) {
            d((b) obj);
        } else if (8 == i8) {
            e((DeviceViewModel) obj);
        } else {
            if (20 != i8) {
                return false;
            }
            f((SearchActivityViewModel) obj);
        }
        return true;
    }
}
