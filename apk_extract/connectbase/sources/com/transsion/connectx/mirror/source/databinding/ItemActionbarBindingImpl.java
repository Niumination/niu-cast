package com.transsion.connectx.mirror.source.databinding;

import a6.e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import n5.a;

/* JADX INFO: loaded from: classes2.dex */
public class ItemActionbarBindingImpl extends ItemActionbarBinding implements a.InterfaceC0290a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f1967p = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f1968v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f1969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f1970g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f1971i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1972n;

    public ItemActionbarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f1967p, f1968v));
    }

    @Override // n5.a.InterfaceC0290a
    public final void a(int i10, View view) {
        FloatingWindowViewModel floatingWindowViewModel;
        FloatingWindowViewModel.a aVar;
        if (i10 == 1) {
            FloatingWindowViewModel floatingWindowViewModel2 = this.f1966e;
            if (floatingWindowViewModel2 != null) {
                floatingWindowViewModel2.C();
                return;
            }
            return;
        }
        if (i10 == 2) {
            FloatingWindowViewModel floatingWindowViewModel3 = this.f1966e;
            if (floatingWindowViewModel3 != null) {
                floatingWindowViewModel3.i();
                return;
            }
            return;
        }
        if (i10 != 3 || (floatingWindowViewModel = this.f1966e) == null || (aVar = floatingWindowViewModel.f2111p) == null) {
            return;
        }
        aVar.c();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f1972n;
            this.f1972n = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f1966e;
        int i10 = 0;
        float f10 = 0.0f;
        if ((15 & j10) != 0) {
            long j11 = j10 & 13;
            if (j11 != 0) {
                LiveData<Boolean> liveData = floatingWindowViewModel != null ? floatingWindowViewModel.f2108m : null;
                updateLiveDataRegistration(0, liveData);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(liveData != null ? liveData.getValue() : null);
                if (j11 != 0) {
                    j10 |= zSafeUnbox ? 128L : 64L;
                }
                f10 = zSafeUnbox ? 1.0f : 0.2f;
            }
            long j12 = j10 & 14;
            if (j12 != 0) {
                LiveData<Boolean> liveData2 = floatingWindowViewModel != null ? floatingWindowViewModel.f2105j : null;
                updateLiveDataRegistration(1, liveData2);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(liveData2 != null ? liveData2.getValue() : null);
                if (j12 != 0) {
                    j10 |= zSafeUnbox2 ? 32L : 16L;
                }
                if (!zSafeUnbox2) {
                    i10 = 8;
                }
            }
        }
        if ((j10 & 14) != 0) {
            this.f1962a.setVisibility(i10);
        }
        if ((8 & j10) != 0) {
            e.c(this.f1963b, Float.valueOf(0.2f));
            this.f1963b.setOnClickListener(this.f1970g);
            e.c(this.f1964c, Float.valueOf(0.2f));
            this.f1964c.setOnClickListener(this.f1969f);
            this.f1965d.setOnClickListener(this.f1971i);
        }
        if ((j10 & 13) != 0) {
            e.c(this.f1965d, Float.valueOf(f10));
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f1972n != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ItemActionbarBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f1966e = floatingWindowViewModel;
        synchronized (this) {
            this.f1972n |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1972n = 8L;
        }
        requestRebind();
    }

    public final boolean j(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1972n |= 2;
        }
        return true;
    }

    public final boolean k(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1972n |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return k((LiveData) obj, i11);
        }
        if (i10 != 1) {
            return false;
        }
        return j((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public ItemActionbarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[0], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[1]);
        this.f1972n = -1L;
        this.f1962a.setTag(null);
        this.f1963b.setTag(null);
        this.f1964c.setTag(null);
        this.f1965d.setTag(null);
        setRootTag(view);
        this.f1969f = new a(this, 2);
        this.f1970g = new a(this, 3);
        this.f1971i = new a(this, 1);
        invalidateAll();
    }
}
