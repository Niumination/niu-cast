package mh;

import java.io.IOException;
import java.io.InputStream;
import jh.g0;
import jh.o;
import k3.ga;
import k3.qc;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import qj.f;
import qj.t;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8086b;

    public /* synthetic */ b(Object obj, int i8) {
        this.f8085a = i8;
        this.f8086b = obj;
    }

    private final void a() {
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        switch (this.f8085a) {
            case 1:
                return ((b) this.f8086b).available();
            case 2:
                return (int) Math.min(((f) this.f8086b).f9195b, Integer.MAX_VALUE);
            case 3:
                t tVar = (t) this.f8086b;
                if (tVar.f9223c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(tVar.f9222b.f9195b, Integer.MAX_VALUE);
            default:
                return super.available();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f8085a) {
            case 0:
                ga.a((o) this.f8086b);
                break;
            case 1:
                super.close();
                ((b) this.f8086b).close();
                break;
            case 2:
                break;
            default:
                ((t) this.f8086b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws Throwable {
        switch (this.f8085a) {
            case 0:
                o oVar = (o) this.f8086b;
                if (oVar.f()) {
                    return -1;
                }
                if (oVar.d().T()) {
                    l0.q(new a(oVar, null));
                }
                if (oVar.f()) {
                    return -1;
                }
                return oVar.d().readByte() & UByte.MAX_VALUE;
            case 1:
                return ((b) this.f8086b).read();
            case 2:
                f fVar = (f) this.f8086b;
                if (fVar.f9195b > 0) {
                    return fVar.readByte() & UByte.MAX_VALUE;
                }
                return -1;
            default:
                t tVar = (t) this.f8086b;
                if (tVar.f9223c) {
                    throw new IOException("closed");
                }
                f fVar2 = tVar.f9222b;
                if (fVar2.f9195b == 0 && tVar.f9221a.W(fVar2, 8192L) == -1) {
                    return -1;
                }
                return fVar2.readByte() & UByte.MAX_VALUE;
        }
    }

    public String toString() {
        switch (this.f8085a) {
            case 2:
                return ((f) this.f8086b) + ".inputStream()";
            case 3:
                return ((t) this.f8086b) + ".inputStream()";
            default:
                return super.toString();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] b9, int i8, int i9) throws Throwable {
        switch (this.f8085a) {
            case 0:
                Intrinsics.checkNotNullParameter(b9, "b");
                o oVar = (o) this.f8086b;
                if (oVar.f()) {
                    return -1;
                }
                if (oVar.d().T()) {
                    l0.q(new a(oVar, null));
                }
                int iU = oVar.d().U(b9, i8, Math.min(g0.e(oVar), i9) + i8);
                if (iU >= 0) {
                    return iU;
                }
                return oVar.f() ? -1 : 0;
            case 1:
                Intrinsics.checkNotNullParameter(b9, "b");
                return ((b) this.f8086b).read(b9, i8, i9);
            case 2:
                Intrinsics.checkNotNullParameter(b9, "sink");
                return ((f) this.f8086b).read(b9, i8, i9);
            default:
                Intrinsics.checkNotNullParameter(b9, "data");
                t tVar = (t) this.f8086b;
                if (!tVar.f9223c) {
                    qc.b(b9.length, i8, i9);
                    f fVar = tVar.f9222b;
                    if (fVar.f9195b == 0 && tVar.f9221a.W(fVar, 8192L) == -1) {
                        return -1;
                    }
                    return fVar.read(b9, i8, i9);
                }
                throw new IOException("closed");
        }
    }
}
