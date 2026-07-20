package com.transsion.connectx.mirror.source.databinding;

import android.util.SparseIntArray;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityPhoneExtendScreenBindingImpl extends ActivityPhoneExtendScreenBinding {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f1957p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f1958v;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final ItemSecretScreenBinding f1959g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final ItemScreenLockBinding f1960i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1961n;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f1957p = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"loading_layout", "item_secret_screen", "item_screen_lock"}, new int[]{2, 3, 4}, new int[]{R.layout.loading_layout, R.layout.item_secret_screen, R.layout.item_screen_lock});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1958v = sparseIntArray;
        sparseIntArray.put(R.id.input, 5);
        sparseIntArray.put(R.id.phone_screen, 6);
    }

    public ActivityPhoneExtendScreenBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f1957p, f1958v));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f1961n;
            this.f1961n = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f1956f;
        if ((j10 & 6) != 0) {
            this.f1953c.i(floatingWindowViewModel);
            this.f1959g.i(floatingWindowViewModel);
            this.f1960i.i(floatingWindowViewModel);
        }
        ViewDataBinding.executeBindingsOn(this.f1953c);
        ViewDataBinding.executeBindingsOn(this.f1959g);
        ViewDataBinding.executeBindingsOn(this.f1960i);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f1961n != 0) {
                    return true;
                }
                return this.f1953c.hasPendingBindings() || this.f1959g.hasPendingBindings() || this.f1960i.hasPendingBindings();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ActivityPhoneExtendScreenBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f1956f = floatingWindowViewModel;
        synchronized (this) {
            this.f1961n |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1961n = 4L;
        }
        this.f1953c.invalidateAll();
        this.f1959g.invalidateAll();
        this.f1960i.invalidateAll();
        requestRebind();
    }

    public final boolean j(LoadingLayoutBinding loadingLayoutBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1961n |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return j((LoadingLayoutBinding) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f1953c.setLifecycleOwner(lifecycleOwner);
        this.f1959g.setLifecycleOwner(lifecycleOwner);
        this.f1960i.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public ActivityPhoneExtendScreenBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[1], (EditText) objArr[5], (LoadingLayoutBinding) objArr[2], (SurfaceView) objArr[6], (ConstraintLayout) objArr[0]);
        this.f1961n = -1L;
        this.f1951a.setTag(null);
        setContainedBinding(this.f1953c);
        ItemSecretScreenBinding itemSecretScreenBinding = (ItemSecretScreenBinding) objArr[3];
        this.f1959g = itemSecretScreenBinding;
        setContainedBinding(itemSecretScreenBinding);
        ItemScreenLockBinding itemScreenLockBinding = (ItemScreenLockBinding) objArr[4];
        this.f1960i = itemScreenLockBinding;
        setContainedBinding(itemScreenLockBinding);
        this.f1955e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
