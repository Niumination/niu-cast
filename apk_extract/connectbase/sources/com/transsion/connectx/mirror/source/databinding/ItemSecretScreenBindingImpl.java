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
public class ItemSecretScreenBindingImpl extends ItemSecretScreenBinding {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f1999f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f2000g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f2002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f2003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2004e;

    public ItemSecretScreenBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f2004e = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f2001b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f2002c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f2003d = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean k(LiveData<List<String>> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2004e |= 2;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0045 A[PHI: r0
      0x0045: PHI (r0v7 long) = (r0v1 long), (r0v9 long) binds: [B:8:0x001b, B:22:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        String str;
        int i10;
        synchronized (this) {
            j10 = this.f2004e;
            this.f2004e = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f1998a;
        int i11 = 0;
        String str2 = null;
        if ((15 & j10) != 0) {
            long j11 = j10 & 13;
            if (j11 == 0) {
                i10 = 0;
            } else {
                LiveData<Boolean> liveData = floatingWindowViewModel != null ? floatingWindowViewModel.f2109n : null;
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
            if ((j10 & 14) != 0) {
                LiveData<List<String>> liveData2 = floatingWindowViewModel != null ? floatingWindowViewModel.f2099d : null;
                updateLiveDataRegistration(1, liveData2);
                List<String> value = liveData2 != null ? liveData2.getValue() : null;
                if (value != null) {
                    str2 = value.get(0);
                    str = value.get(1);
                    i11 = i10;
                }
            }
            i11 = i10;
            str = null;
        } else {
            str = null;
        }
        if ((13 & j10) != 0) {
            this.f2001b.setVisibility(i11);
        }
        if ((j10 & 14) != 0) {
            TextViewBindingAdapter.setText(this.f2002c, str2);
            TextViewBindingAdapter.setText(this.f2003d, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2004e != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ItemSecretScreenBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f1998a = floatingWindowViewModel;
        synchronized (this) {
            this.f2004e |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f2004e = 8L;
        }
        requestRebind();
    }

    public final boolean j(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2004e |= 1;
        }
        return true;
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

    public ItemSecretScreenBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f1999f, f2000g));
    }
}
