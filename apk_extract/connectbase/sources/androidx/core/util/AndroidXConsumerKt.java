package androidx.core.util;

import kn.l0;
import os.l;
import um.d;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidXConsumerKt {
    @l
    public static final <T> Consumer<T> asAndroidXConsumer(@l d<? super T> dVar) {
        l0.p(dVar, "<this>");
        return new AndroidXContinuationConsumer(dVar);
    }
}
