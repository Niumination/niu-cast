package androidx.core.util;

import kn.l0;
import lm.l2;
import os.l;
import um.d;

/* JADX INFO: loaded from: classes.dex */
public final class RunnableKt {
    @l
    public static final Runnable asRunnable(@l d<? super l2> dVar) {
        l0.p(dVar, "<this>");
        return new ContinuationRunnable(dVar);
    }
}
