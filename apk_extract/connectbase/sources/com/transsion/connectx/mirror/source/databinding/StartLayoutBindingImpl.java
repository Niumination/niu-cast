package com.transsion.connectx.mirror.source.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class StartLayoutBindingImpl extends StartLayoutBinding {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f2044e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f2045f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2046d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2045f = sparseIntArray;
        sparseIntArray.put(R.id.mirror_loading, 1);
    }

    public StartLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f2044e, f2045f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f2046d = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2046d != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.StartLayoutBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f2043c = floatingWindowViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f2046d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public StartLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (AnimView) objArr[1]);
        this.f2046d = -1L;
        this.f2041a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
