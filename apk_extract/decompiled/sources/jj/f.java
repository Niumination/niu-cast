package jj;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6328d;

    @Override // jj.a, qj.z
    public final long W(qj.f sink, long j8) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        if (this.f6316b) {
            throw new IllegalStateException("closed");
        }
        if (this.f6328d) {
            return -1L;
        }
        long jW = super.W(sink, j8);
        if (jW != -1) {
            return jW;
        }
        this.f6328d = true;
        a();
        return -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6316b) {
            return;
        }
        if (!this.f6328d) {
            a();
        }
        this.f6316b = true;
    }
}
