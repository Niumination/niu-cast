package com.transsion.connectx.mirror.source.databinding;

import android.util.SparseIntArray;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityMirrorFullScreenBindingImpl extends ActivityMirrorFullScreenBinding {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f1946i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f1947n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final ItemSecretScreenBinding f1948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final ItemScreenLockBinding f1949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1950g;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f1946i = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_secret_screen", "item_window_helper", "item_screen_lock"}, new int[]{1, 2, 3}, new int[]{R.layout.item_secret_screen, R.layout.item_window_helper, R.layout.item_screen_lock});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1947n = sparseIntArray;
        sparseIntArray.put(R.id.phone_screen, 4);
    }

    public ActivityMirrorFullScreenBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f1946i, f1947n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f1950g;
            this.f1950g = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f1945d;
        if ((j10 & 6) != 0) {
            this.f1942a.i(floatingWindowViewModel);
            this.f1948e.i(floatingWindowViewModel);
            this.f1949f.i(floatingWindowViewModel);
        }
        ViewDataBinding.executeBindingsOn(this.f1948e);
        ViewDataBinding.executeBindingsOn(this.f1942a);
        ViewDataBinding.executeBindingsOn(this.f1949f);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f1950g != 0) {
                    return true;
                }
                return this.f1948e.hasPendingBindings() || this.f1942a.hasPendingBindings() || this.f1949f.hasPendingBindings();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ActivityMirrorFullScreenBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f1945d = floatingWindowViewModel;
        synchronized (this) {
            this.f1950g |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1950g = 4L;
        }
        this.f1948e.invalidateAll();
        this.f1942a.invalidateAll();
        this.f1949f.invalidateAll();
        requestRebind();
    }

    public final boolean j(ItemWindowHelperBinding itemWindowHelperBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1950g |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return j((ItemWindowHelperBinding) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f1948e.setLifecycleOwner(lifecycleOwner);
        this.f1942a.setLifecycleOwner(lifecycleOwner);
        this.f1949f.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public ActivityMirrorFullScreenBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ItemWindowHelperBinding) objArr[2], (SurfaceView) objArr[4], (FrameLayout) objArr[0]);
        this.f1950g = -1L;
        setContainedBinding(this.f1942a);
        ItemSecretScreenBinding itemSecretScreenBinding = (ItemSecretScreenBinding) objArr[1];
        this.f1948e = itemSecretScreenBinding;
        setContainedBinding(itemSecretScreenBinding);
        ItemScreenLockBinding itemScreenLockBinding = (ItemScreenLockBinding) objArr[3];
        this.f1949f = itemScreenLockBinding;
        setContainedBinding(itemScreenLockBinding);
        this.f1944c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
