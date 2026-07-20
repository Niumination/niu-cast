package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import in.i;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@i(name = "ViewModelProviderGetKt")
public final class ViewModelProviderGetKt {
    @l
    public static final CreationExtras defaultCreationExtras(@l ViewModelStoreOwner viewModelStoreOwner) {
        l0.p(viewModelStoreOwner, "owner");
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
    }

    @MainThread
    public static final <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        l0.p(viewModelProvider, "<this>");
        l0.P();
        return (VM) viewModelProvider.get(ViewModel.class);
    }
}
