package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import in.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kn.l0;
import kn.r1;
import os.l;
import un.d;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,115:1\n37#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder\n*L\n54#1:116,2\n*E\n"})
@ViewModelFactoryDsl
public final class InitializerViewModelFactoryBuilder {

    @l
    private final List<ViewModelInitializer<?>> initializers = new ArrayList();

    public final <T extends ViewModel> void addInitializer(@l d<T> dVar, @l jn.l<? super CreationExtras, ? extends T> lVar) {
        l0.p(dVar, "clazz");
        l0.p(lVar, "initializer");
        this.initializers.add(new ViewModelInitializer<>(b.e(dVar), lVar));
    }

    @l
    public final ViewModelProvider.Factory build() {
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) this.initializers.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
