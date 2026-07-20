package qj;

import java.io.IOException;
import java.io.OutputStream;
import k3.qc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f9211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f9212b;

    public q(OutputStream out, y timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f9211a = out;
        this.f9212b = timeout;
    }

    @Override // qj.x
    public final b0 b() {
        return this.f9212b;
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9211a.close();
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() throws IOException {
        this.f9211a.flush();
    }

    @Override // qj.x
    public final void k0(f source, long j8) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        qc.b(source.f9195b, 0L, j8);
        while (j8 > 0) {
            this.f9212b.f();
            u uVar = source.f9194a;
            Intrinsics.checkNotNull(uVar);
            int iMin = (int) Math.min(j8, uVar.f9226c - uVar.f9225b);
            this.f9211a.write(uVar.f9224a, uVar.f9225b, iMin);
            int i8 = uVar.f9225b + iMin;
            uVar.f9225b = i8;
            long j10 = iMin;
            j8 -= j10;
            source.f9195b -= j10;
            if (i8 == uVar.f9226c) {
                source.f9194a = uVar.a();
                v.a(uVar);
            }
        }
    }

    public final String toString() {
        return "sink(" + this.f9211a + ')';
    }
}
