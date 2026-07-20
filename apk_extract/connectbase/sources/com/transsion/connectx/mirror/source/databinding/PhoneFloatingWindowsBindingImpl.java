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
public class PhoneFloatingWindowsBindingImpl extends PhoneFloatingWindowsBinding {

    @Nullable
    public static final SparseIntArray H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f2037z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final ItemSecretScreenBinding f2038w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final ItemScreenLockBinding f2039x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f2040y;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        f2037z = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_actionbar", "item_bottom_nav"}, new int[]{2, 9}, new int[]{R.layout.item_actionbar, R.layout.item_bottom_nav});
        includedLayouts.setIncludes(1, new String[]{"loading_layout", "item_extend_tip", "item_secret_screen", "item_window_helper", "item_screen_lock", "start_layout"}, new int[]{3, 4, 5, 6, 7, 8}, new int[]{R.layout.loading_layout, R.layout.item_extend_tip, R.layout.item_secret_screen, R.layout.item_window_helper, R.layout.item_screen_lock, R.layout.start_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R.id.input, 10);
        sparseIntArray.put(R.id.phone_screen, 11);
    }

    public PhoneFloatingWindowsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f2037z, H));
    }

    private boolean l(ItemWindowHelperBinding itemWindowHelperBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2040y |= 4;
        }
        return true;
    }

    private boolean m(LoadingLayoutBinding loadingLayoutBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2040y |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f2040y;
            this.f2040y = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f2036v;
        if ((j10 & 192) != 0) {
            this.f2026a.i(floatingWindowViewModel);
            this.f2028c.i(floatingWindowViewModel);
            this.f2029d.i(floatingWindowViewModel);
            this.f2030e.i(floatingWindowViewModel);
            this.f2038w.i(floatingWindowViewModel);
            this.f2039x.i(floatingWindowViewModel);
            this.f2034n.i(floatingWindowViewModel);
            this.f2035p.i(floatingWindowViewModel);
        }
        ViewDataBinding.executeBindingsOn(this.f2035p);
        ViewDataBinding.executeBindingsOn(this.f2030e);
        ViewDataBinding.executeBindingsOn(this.f2028c);
        ViewDataBinding.executeBindingsOn(this.f2038w);
        ViewDataBinding.executeBindingsOn(this.f2029d);
        ViewDataBinding.executeBindingsOn(this.f2039x);
        ViewDataBinding.executeBindingsOn(this.f2034n);
        ViewDataBinding.executeBindingsOn(this.f2026a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f2040y != 0) {
                    return true;
                }
                return this.f2035p.hasPendingBindings() || this.f2030e.hasPendingBindings() || this.f2028c.hasPendingBindings() || this.f2038w.hasPendingBindings() || this.f2029d.hasPendingBindings() || this.f2039x.hasPendingBindings() || this.f2034n.hasPendingBindings() || this.f2026a.hasPendingBindings();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.PhoneFloatingWindowsBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f2036v = floatingWindowViewModel;
        synchronized (this) {
            this.f2040y |= 64;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f2040y = 128L;
        }
        this.f2035p.invalidateAll();
        this.f2030e.invalidateAll();
        this.f2028c.invalidateAll();
        this.f2038w.invalidateAll();
        this.f2029d.invalidateAll();
        this.f2039x.invalidateAll();
        this.f2034n.invalidateAll();
        this.f2026a.invalidateAll();
        requestRebind();
    }

    public final boolean j(ItemBottomNavBinding itemBottomNavBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2040y |= 8;
        }
        return true;
    }

    public final boolean k(ItemExtendTipBinding itemExtendTipBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2040y |= 32;
        }
        return true;
    }

    public final boolean n(StartLayoutBinding startLayoutBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2040y |= 16;
        }
        return true;
    }

    public final boolean o(ItemActionbarBinding itemActionbarBinding, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2040y |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return m((LoadingLayoutBinding) obj, i11);
        }
        if (i10 == 1) {
            return o((ItemActionbarBinding) obj, i11);
        }
        if (i10 == 2) {
            return l((ItemWindowHelperBinding) obj, i11);
        }
        if (i10 == 3) {
            return j((ItemBottomNavBinding) obj, i11);
        }
        if (i10 == 4) {
            return n((StartLayoutBinding) obj, i11);
        }
        if (i10 != 5) {
            return false;
        }
        return k((ItemExtendTipBinding) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f2035p.setLifecycleOwner(lifecycleOwner);
        this.f2030e.setLifecycleOwner(lifecycleOwner);
        this.f2028c.setLifecycleOwner(lifecycleOwner);
        this.f2038w.setLifecycleOwner(lifecycleOwner);
        this.f2029d.setLifecycleOwner(lifecycleOwner);
        this.f2039x.setLifecycleOwner(lifecycleOwner);
        this.f2034n.setLifecycleOwner(lifecycleOwner);
        this.f2026a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public PhoneFloatingWindowsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ItemBottomNavBinding) objArr[9], (EditText) objArr[10], (ItemExtendTipBinding) objArr[4], (ItemWindowHelperBinding) objArr[6], (LoadingLayoutBinding) objArr[3], (FrameLayout) objArr[1], (SurfaceView) objArr[11], (ConstraintLayout) objArr[0], (StartLayoutBinding) objArr[8], (ItemActionbarBinding) objArr[2]);
        this.f2040y = -1L;
        setContainedBinding(this.f2026a);
        setContainedBinding(this.f2028c);
        setContainedBinding(this.f2029d);
        setContainedBinding(this.f2030e);
        ItemSecretScreenBinding itemSecretScreenBinding = (ItemSecretScreenBinding) objArr[5];
        this.f2038w = itemSecretScreenBinding;
        setContainedBinding(itemSecretScreenBinding);
        ItemScreenLockBinding itemScreenLockBinding = (ItemScreenLockBinding) objArr[7];
        this.f2039x = itemScreenLockBinding;
        setContainedBinding(itemScreenLockBinding);
        this.f2031f.setTag(null);
        this.f2033i.setTag(null);
        setContainedBinding(this.f2034n);
        setContainedBinding(this.f2035p);
        setRootTag(view);
        invalidateAll();
    }
}
