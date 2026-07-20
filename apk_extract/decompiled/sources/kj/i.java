package kj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends j {
    @Override // kj.j
    public final void b(a0 stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.c(c.REFUSED_STREAM, null);
    }
}
