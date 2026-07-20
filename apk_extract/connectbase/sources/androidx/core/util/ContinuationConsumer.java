package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kn.l0;
import lm.c1;
import os.l;
import um.d;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {

    @l
    private final d<T> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(@l d<? super T> dVar) {
        super(false);
        l0.p(dVar, "continuation");
        this.continuation = dVar;
    }

    @Override // java.util.function.Consumer
    public void accept(T t10) {
        if (compareAndSet(false, true)) {
            d<T> dVar = this.continuation;
            c1.a aVar = c1.Companion;
            dVar.resumeWith(c1.m59constructorimpl(t10));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @l
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
