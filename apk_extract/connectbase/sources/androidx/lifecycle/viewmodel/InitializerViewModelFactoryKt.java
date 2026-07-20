package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import jn.l;
import kn.l0;
import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
public final class InitializerViewModelFactoryKt {
    public static final <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, l<? super CreationExtras, ? extends VM> lVar) {
        l0.p(initializerViewModelFactoryBuilder, "<this>");
        l0.p(lVar, "initializer");
        l0.P();
        initializerViewModelFactoryBuilder.addInitializer(l1.d(ViewModel.class), lVar);
    }

    @os.l
    public static final ViewModelProvider.Factory viewModelFactory(@os.l l<? super InitializerViewModelFactoryBuilder, l2> lVar) {
        l0.p(lVar, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        lVar.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
