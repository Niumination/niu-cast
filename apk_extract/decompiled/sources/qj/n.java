package qj;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f9203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f9204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9206d;

    public n(t source, Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.f9203a = source;
        this.f9204b = inflater;
    }

    @Override // qj.z
    public final long W(f sink, long j8) throws IOException {
        t tVar;
        long j10;
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j8 < 0) {
                throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
            }
            if (this.f9206d) {
                throw new IllegalStateException("closed");
            }
            tVar = this.f9203a;
            Inflater inflater = this.f9204b;
            if (j8 == 0) {
                j10 = 0;
            } else {
                try {
                    u uVarH = sink.H(1);
                    int iMin = (int) Math.min(j8, 8192 - uVarH.f9226c);
                    if (inflater.needsInput() && !tVar.T()) {
                        u uVar = tVar.f9222b.f9194a;
                        Intrinsics.checkNotNull(uVar);
                        int i8 = uVar.f9226c;
                        int i9 = uVar.f9225b;
                        int i10 = i8 - i9;
                        this.f9205c = i10;
                        inflater.setInput(uVar.f9224a, i9, i10);
                    }
                    int iInflate = inflater.inflate(uVarH.f9224a, uVarH.f9226c, iMin);
                    int i11 = this.f9205c;
                    if (i11 != 0) {
                        int remaining = i11 - inflater.getRemaining();
                        this.f9205c -= remaining;
                        tVar.m(remaining);
                    }
                    if (iInflate > 0) {
                        uVarH.f9226c += iInflate;
                        j10 = iInflate;
                        sink.f9195b += j10;
                    } else {
                        if (uVarH.f9225b == uVarH.f9226c) {
                            sink.f9194a = uVarH.a();
                            v.a(uVarH);
                        }
                        j10 = 0;
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            if (j10 > 0) {
                return j10;
            }
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!tVar.T());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // qj.z
    public final b0 b() {
        return this.f9203a.f9221a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f9206d) {
            return;
        }
        this.f9204b.end();
        this.f9206d = true;
        this.f9203a.close();
    }
}
