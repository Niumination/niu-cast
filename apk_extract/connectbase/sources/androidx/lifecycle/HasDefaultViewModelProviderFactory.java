package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface HasDefaultViewModelProviderFactory {
    @l
    default CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @l
    ViewModelProvider.Factory getDefaultViewModelProviderFactory();
}
