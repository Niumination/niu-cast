package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kn.l0;
import lm.c1;
import os.l;
import um.d;
import w.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    @l
    private final d<R> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(@l d<? super R> dVar) {
        super(false);
        l0.p(dVar, "continuation");
        this.continuation = dVar;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@l E e10) {
        l0.p(e10, "error");
        if (compareAndSet(false, true)) {
            d<R> dVar = this.continuation;
            c1.a aVar = c1.Companion;
            a.a(e10, dVar);
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(@l R r10) {
        l0.p(r10, "result");
        if (compareAndSet(false, true)) {
            d<R> dVar = this.continuation;
            c1.a aVar = c1.Companion;
            dVar.resumeWith(c1.m59constructorimpl(r10));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @l
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
