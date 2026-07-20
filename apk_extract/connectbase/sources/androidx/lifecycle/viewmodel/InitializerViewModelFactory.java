package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,115:1\n13579#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n*L\n105#1:116,2\n*E\n"})
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {

    @l
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(@l ViewModelInitializer<?>... viewModelInitializerArr) {
        l0.p(viewModelInitializerArr, "initializers");
        this.initializers = viewModelInitializerArr;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @l
    public <T extends ViewModel> T create(@l Class<T> cls, @l CreationExtras creationExtras) {
        l0.p(cls, "modelClass");
        l0.p(creationExtras, "extras");
        T t10 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (l0.g(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), cls)) {
                T tInvoke = viewModelInitializer.getInitializer$lifecycle_viewmodel_release().invoke(creationExtras);
                t10 = tInvoke instanceof ViewModel ? tInvoke : null;
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
