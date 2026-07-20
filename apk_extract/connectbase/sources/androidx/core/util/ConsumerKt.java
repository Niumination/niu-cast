package androidx.core.util;

import androidx.annotation.RequiresApi;
import kn.l0;
import os.l;
import um.d;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    @l
    public static final <T> java.util.function.Consumer<T> asConsumer(@l d<? super T> dVar) {
        l0.p(dVar, "<this>");
        return new ContinuationConsumer(dVar);
    }
}
