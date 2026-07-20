package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kn.l0;
import lm.c1;
import lm.l2;
import os.l;
import um.d;

/* JADX INFO: loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {

    @l
    private final d<l2> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(@l d<? super l2> dVar) {
        super(false);
        l0.p(dVar, "continuation");
        this.continuation = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            d<l2> dVar = this.continuation;
            c1.a aVar = c1.Companion;
            dVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @l
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
