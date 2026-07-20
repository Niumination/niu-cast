package androidx.core.os;

import jn.a;
import kn.l0;
import lm.a1;
import lm.k;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    @k(message = "Use androidx.tracing.Trace instead", replaceWith = @a1(expression = "trace(sectionName)", imports = {"androidx.tracing.trace"}))
    public static final <T> T trace(@l String str, @l a<? extends T> aVar) {
        l0.p(str, "sectionName");
        l0.p(aVar, "block");
        TraceCompat.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            TraceCompat.endSection();
        }
    }
}
