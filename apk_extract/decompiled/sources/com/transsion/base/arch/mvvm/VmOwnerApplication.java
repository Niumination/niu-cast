package com.transsion.base.arch.mvvm;

import android.app.Application;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/base/arch/mvvm/VmOwnerApplication;", "Landroid/app/Application;", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "()V", "mvvm_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class VmOwnerApplication extends Application implements ViewModelStoreOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewModelStore f2331a;

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        ViewModelStore viewModelStore = this.f2331a;
        if (viewModelStore != null) {
            return viewModelStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelStoreOwner");
        return null;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.f2331a = new ViewModelStore();
    }
}
