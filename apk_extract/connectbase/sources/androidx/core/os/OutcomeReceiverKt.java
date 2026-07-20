package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import kn.l0;
import os.l;
import um.d;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    @l
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(@l d<? super R> dVar) {
        l0.p(dVar, "<this>");
        return new ContinuationOutcomeReceiver(dVar);
    }
}
