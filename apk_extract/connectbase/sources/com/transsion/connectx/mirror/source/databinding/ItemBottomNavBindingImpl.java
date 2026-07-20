package com.transsion.connectx.mirror.source.databinding;

import a6.e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import n5.a;

/* JADX INFO: loaded from: classes2.dex */
public class ItemBottomNavBindingImpl extends ItemBottomNavBinding implements a.InterfaceC0290a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f1978p = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f1979v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f1980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f1981g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f1982i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1983n;

    public ItemBottomNavBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f1978p, f1979v));
    }

    private boolean j(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1983n |= 2;
        }
        return true;
    }

    @Override // n5.a.InterfaceC0290a
    public final void a(int i10, View view) {
        FloatingWindowViewModel.a aVar;
        FloatingWindowViewModel.a aVar2;
        FloatingWindowViewModel floatingWindowViewModel;
        FloatingWindowViewModel.a aVar3;
        if (i10 == 1) {
            FloatingWindowViewModel floatingWindowViewModel2 = this.f1977e;
            if (floatingWindowViewModel2 == null || (aVar = floatingWindowViewModel2.f2111p) == null) {
                return;
            }
            aVar.b();
            return;
        }
        if (i10 != 2) {
            if (i10 != 3 || (floatingWindowViewModel = this.f1977e) == null || (aVar3 = floatingWindowViewModel.f2111p) == null) {
                return;
            }
            aVar3.d();
            return;
        }
        FloatingWindowViewModel floatingWindowViewModel3 = this.f1977e;
        if (floatingWindowViewModel3 == null || (aVar2 = floatingWindowViewModel3.f2111p) == null) {
            return;
        }
        aVar2.e();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048 A[PHI: r2
      0x0048: PHI (r2v3 long) = (r2v0 long), (r2v7 long) binds: [B:9:0x001f, B:23:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        int i10;
        synchronized (this) {
            j10 = this.f1983n;
            this.f1983n = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f1977e;
        int i11 = 0;
        if ((15 & j10) != 0) {
            long j11 = j10 & 13;
            if (j11 == 0) {
                i10 = 0;
            } else {
                LiveData<Boolean> liveData = floatingWindowViewModel != null ? floatingWindowViewModel.f2110o : null;
                updateLiveDataRegistration(0, liveData);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(liveData != null ? liveData.getValue() : null);
                if (j11 != 0) {
                    j10 |= zSafeUnbox ? 32L : 16L;
                }
                if (zSafeUnbox) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
            }
            long j12 = j10 & 14;
            if (j12 != 0) {
                LiveData<Boolean> liveData2 = floatingWindowViewModel != null ? floatingWindowViewModel.f2105j : null;
                updateLiveDataRegistration(1, liveData2);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(liveData2 != null ? liveData2.getValue() : null);
                if (j12 != 0) {
                    j10 |= zSafeUnbox2 ? 128L : 64L;
                }
                if (!zSafeUnbox2) {
                    i11 = 8;
                }
            }
        } else {
            i10 = 0;
        }
        if ((14 & j10) != 0) {
            this.f1973a.setVisibility(i11);
        }
        if ((8 & j10) != 0) {
            e.c(this.f1974b, Float.valueOf(0.2f));
            this.f1974b.setOnClickListener(this.f1980f);
            e.c(this.f1975c, Float.valueOf(0.2f));
            this.f1975c.setOnClickListener(this.f1982i);
            e.c(this.f1976d, Float.valueOf(0.2f));
            this.f1976d.setOnClickListener(this.f1981g);
        }
        if ((j10 & 13) != 0) {
            this.f1974b.setVisibility(i10);
            this.f1975c.setVisibility(i10);
            this.f1976d.setVisibility(i10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f1983n != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ItemBottomNavBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f1977e = floatingWindowViewModel;
        synchronized (this) {
            this.f1983n |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1983n = 8L;
        }
        requestRebind();
    }

    public final boolean k(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1983n |= 1;
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

    public ItemBottomNavBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[0], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[1]);
        this.f1983n = -1L;
        this.f1973a.setTag(null);
        this.f1974b.setTag(null);
        this.f1975c.setTag(null);
        this.f1976d.setTag(null);
        setRootTag(view);
        this.f1980f = new a(this, 3);
        this.f1981g = new a(this, 1);
        this.f1982i = new a(this, 2);
        invalidateAll();
    }
}
