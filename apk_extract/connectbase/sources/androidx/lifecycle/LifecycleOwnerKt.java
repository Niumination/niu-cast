package androidx.lifecycle;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleOwnerKt {
    @l
    public static final LifecycleCoroutineScope getLifecycleScope(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "<this>");
        return LifecycleKt.getCoroutineScope(lifecycleOwner.getLifecycle());
    }
}
