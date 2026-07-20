package jj;

import hj.m;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6324d;
    public final /* synthetic */ g e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar, long j8) {
        super(gVar);
        this.e = gVar;
        this.f6324d = j8;
        if (j8 == 0) {
            a();
        }
    }

    @Override // jj.a, qj.z
    public final long W(qj.f sink, long j8) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        if (this.f6316b) {
            throw new IllegalStateException("closed");
        }
        long j10 = this.f6324d;
        if (j10 == 0) {
            return -1L;
        }
        long jW = super.W(sink, Math.min(j10, j8));
        if (jW == -1) {
            ((m) this.e.f).k();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
        long j11 = this.f6324d - jW;
        this.f6324d = j11;
        if (j11 == 0) {
            a();
        }
        return jW;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6316b) {
            return;
        }
        if (this.f6324d != 0 && !ej.b.h(this, TimeUnit.MILLISECONDS)) {
            ((m) this.e.f).k();
            a();
        }
        this.f6316b = true;
    }
}
