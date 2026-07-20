package androidx.lifecycle;

import g0.e;
import kn.l0;
import nq.k1;
import nq.m3;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleKt {
    @l
    public static final LifecycleCoroutineScope getCoroutineScope(@l Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        l0.p(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, m3.c(null, 1, null).plus(k1.e().f0()));
        } while (!e.a(lifecycle.getInternalScopeRef(), null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }
}
