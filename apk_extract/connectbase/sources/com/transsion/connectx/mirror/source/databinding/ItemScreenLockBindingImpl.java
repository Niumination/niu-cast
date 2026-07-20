package com.transsion.connectx.mirror.source.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ItemScreenLockBindingImpl extends ItemScreenLockBinding {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f1993e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f1994f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f1995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f1996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1997d;

    public ItemScreenLockBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f1997d = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f1995b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f1996c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean j(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1997d |= 1;
        }
        return true;
    }

    private boolean k(LiveData<List<String>> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1997d |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f1997d;
            this.f1997d = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f1992a;
        int i10 = 0;
        String str = null;
        if ((15 & j10) != 0) {
            long j11 = j10 & 13;
            if (j11 != 0) {
                LiveData<Boolean> liveData = floatingWindowViewModel != null ? floatingWindowViewModel.f2108m : null;
                updateLiveDataRegistration(0, liveData);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(liveData != null ? liveData.getValue() : null);
                if (j11 != 0) {
                    j10 |= zSafeUnbox ? 32L : 16L;
                }
                if (!zSafeUnbox) {
                    i10 = 8;
                }
            }
            if ((j10 & 14) != 0) {
                LiveData<List<String>> liveData2 = floatingWindowViewModel != null ? floatingWindowViewModel.f2099d : null;
                updateLiveDataRegistration(1, liveData2);
                List<String> value = liveData2 != null ? liveData2.getValue() : null;
                if (value != null) {
                    str = value.get(2);
                }
            }
        }
        if ((j10 & 13) != 0) {
            this.f1995b.setVisibility(i10);
        }
        if ((j10 & 14) != 0) {
            TextViewBindingAdapter.setText(this.f1996c, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f1997d != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ItemScreenLockBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f1992a = floatingWindowViewModel;
        synchronized (this) {
            this.f1997d |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1997d = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return j((LiveData) obj, i11);
        }
        if (i10 != 1) {
            return false;
        }
        return k((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public ItemScreenLockBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f1993e, f1994f));
    }
}
