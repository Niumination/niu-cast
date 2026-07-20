package kj;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements qj.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6965d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final qj.t f6966h;

    public v(qj.t source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f6966h = source;
    }

    @Override // qj.z
    public final long W(qj.f sink, long j8) throws IOException {
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            int i10 = this.f6965d;
            qj.t tVar = this.f6966h;
            if (i10 != 0) {
                long jW = tVar.W(sink, Math.min(j8, i10));
                if (jW == -1) {
                    return -1L;
                }
                this.f6965d -= (int) jW;
                return jW;
            }
            tVar.m(this.e);
            this.e = 0;
            if ((this.f6963b & 4) != 0) {
                return -1L;
            }
            i8 = this.f6964c;
            int iS = ej.b.s(tVar);
            this.f6965d = iS;
            this.f6962a = iS;
            int i11 = tVar.readByte() & UByte.MAX_VALUE;
            this.f6963b = tVar.readByte() & UByte.MAX_VALUE;
            Logger logger = w.f6967d;
            if (logger.isLoggable(Level.FINE)) {
                qj.j jVar = h.f6919a;
                logger.fine(h.a(true, this.f6964c, this.f6962a, i11, this.f6963b));
            }
            i9 = tVar.readInt() & Integer.MAX_VALUE;
            this.f6964c = i9;
            if (i11 != 9) {
                throw new IOException(h0.a.g(i11, " != TYPE_CONTINUATION"));
            }
        } while (i9 == i8);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // qj.z
    public final qj.b0 b() {
        return this.f6966h.f9221a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
