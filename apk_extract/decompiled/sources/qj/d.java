package qj;

import java.io.IOException;
import java.io.InputStream;
import k3.sc;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9185a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9187c;

    public d(InputStream input, b0 timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f9186b = input;
        this.f9187c = timeout;
    }

    @Override // qj.z
    public final long W(f sink, long j8) throws IOException {
        switch (this.f9185a) {
            case 0:
                Intrinsics.checkNotNullParameter(sink, "sink");
                d dVar = (d) this.f9187c;
                y yVar = (y) this.f9186b;
                yVar.h();
                try {
                    try {
                        long jW = dVar.W(sink, j8);
                        if (yVar.i()) {
                            throw yVar.k(null);
                        }
                        return jW;
                    } catch (IOException e) {
                        if (yVar.i()) {
                            throw yVar.k(e);
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    yVar.i();
                    throw th2;
                }
            default:
                Intrinsics.checkNotNullParameter(sink, "sink");
                if (j8 == 0) {
                    return 0L;
                }
                if (j8 < 0) {
                    throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
                }
                try {
                    ((b0) this.f9187c).f();
                    u uVarH = sink.H(1);
                    int i8 = ((InputStream) this.f9186b).read(uVarH.f9224a, uVarH.f9226c, (int) Math.min(j8, 8192 - uVarH.f9226c));
                    if (i8 == -1) {
                        if (uVarH.f9225b == uVarH.f9226c) {
                            sink.f9194a = uVarH.a();
                            v.a(uVarH);
                        }
                        return -1L;
                    }
                    uVarH.f9226c += i8;
                    long j10 = i8;
                    sink.f9195b += j10;
                    return j10;
                } catch (AssertionError e4) {
                    if (sc.c(e4)) {
                        throw new IOException(e4);
                    }
                    throw e4;
                }
        }
    }

    @Override // qj.z
    public final b0 b() {
        switch (this.f9185a) {
            case 0:
                return (y) this.f9186b;
            default:
                return (b0) this.f9187c;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Object obj = this.f9186b;
        switch (this.f9185a) {
            case 0:
                d dVar = (d) this.f9187c;
                y yVar = (y) obj;
                yVar.h();
                try {
                    try {
                        dVar.close();
                        Unit unit = Unit.INSTANCE;
                        if (yVar.i()) {
                            throw yVar.k(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!yVar.i()) {
                            throw e;
                        }
                        throw yVar.k(e);
                    }
                } catch (Throwable th2) {
                    yVar.i();
                    throw th2;
                }
            default:
                ((InputStream) obj).close();
                return;
        }
    }

    public final String toString() {
        switch (this.f9185a) {
            case 0:
                return "AsyncTimeout.source(" + ((d) this.f9187c) + ')';
            default:
                return "source(" + ((InputStream) this.f9186b) + ')';
        }
    }

    public d(y yVar, d dVar) {
        this.f9186b = yVar;
        this.f9187c = dVar;
    }
}
