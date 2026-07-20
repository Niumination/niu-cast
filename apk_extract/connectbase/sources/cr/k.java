package cr;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deflater f3422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f3423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f3425e = new CRC32();

    public k(z zVar) {
        if (zVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.f3422b = deflater;
        d dVarC = p.c(zVar);
        this.f3421a = dVarC;
        this.f3423c = new g(dVarC, deflater);
        h();
    }

    @Override // cr.z
    public void Z0(c cVar, long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        if (j10 == 0) {
            return;
        }
        c(cVar, j10);
        this.f3423c.Z0(cVar, j10);
    }

    public final Deflater b() {
        return this.f3422b;
    }

    public final void c(c cVar, long j10) {
        w wVar = cVar.f3403a;
        while (j10 > 0) {
            int iMin = (int) Math.min(j10, wVar.f3488c - wVar.f3487b);
            this.f3425e.update(wVar.f3486a, wVar.f3487b, iMin);
            j10 -= (long) iMin;
            wVar = wVar.f3491f;
        }
    }

    @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f3424d) {
            return;
        }
        this.f3423c.c();
        d();
        th = null;
        try {
            this.f3422b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f3421a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f3424d = true;
        if (th != null) {
            d0.f(th);
        }
    }

    public final void d() throws IOException {
        this.f3421a.a1((int) this.f3425e.getValue());
        this.f3421a.a1((int) this.f3422b.getBytesRead());
    }

    @Override // cr.z
    public b0 f() {
        return this.f3421a.f();
    }

    @Override // cr.z, java.io.Flushable
    public void flush() throws IOException {
        this.f3423c.flush();
    }

    public final void h() {
        c cVarBuffer = this.f3421a.buffer();
        cVarBuffer.writeShort(8075);
        cVarBuffer.writeByte(8);
        cVarBuffer.writeByte(0);
        cVarBuffer.writeInt(0);
        cVarBuffer.writeByte(0);
        cVarBuffer.writeByte(0);
    }
}
