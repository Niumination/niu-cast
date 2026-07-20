package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @l
    SavedStateRegistry getSavedStateRegistry();
}
