package com.transsion.connectx.mirror.source.databinding;

import a6.e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class LoadingLayoutBindingImpl extends LoadingLayoutBinding {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f2023e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f2024f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2025d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2024f = sparseIntArray;
        sparseIntArray.put(R.id.mirror_loading, 1);
    }

    public LoadingLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f2023e, f2024f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f2025d;
            this.f2025d = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f2022c;
        long j11 = j10 & 7;
        Boolean value = null;
        if (j11 != 0) {
            LiveData<Boolean> liveData = floatingWindowViewModel != null ? floatingWindowViewModel.f2113r : null;
            updateLiveDataRegistration(0, liveData);
            if (liveData != null) {
                value = liveData.getValue();
            }
        }
        if (j11 != 0) {
            e.e(this.f2020a, value);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2025d != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.LoadingLayoutBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f2022c = floatingWindowViewModel;
        synchronized (this) {
            this.f2025d |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f2025d = 4L;
        }
        requestRebind();
    }

    public final boolean j(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2025d |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
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

    public LoadingLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[0], (AnimView) objArr[1]);
        this.f2025d = -1L;
        this.f2020a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
