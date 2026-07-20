package cr;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deflater f3416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3417c;

    public g(z zVar, Deflater deflater) {
        this(p.c(zVar), deflater);
    }

    @Override // cr.z
    public void Z0(c cVar, long j10) throws IOException {
        d0.b(cVar.f3404b, 0L, j10);
        while (j10 > 0) {
            w wVar = cVar.f3403a;
            int iMin = (int) Math.min(j10, wVar.f3488c - wVar.f3487b);
            this.f3416b.setInput(wVar.f3486a, wVar.f3487b, iMin);
            b(false);
            long j11 = iMin;
            cVar.f3404b -= j11;
            int i10 = wVar.f3487b + iMin;
            wVar.f3487b = i10;
            if (i10 == wVar.f3488c) {
                cVar.f3403a = wVar.b();
                x.a(wVar);
            }
            j10 -= j11;
        }
    }

    @is.a
    public final void b(boolean z10) throws IOException {
        w wVarS0;
        int iDeflate;
        c cVarBuffer = this.f3415a.buffer();
        while (true) {
            wVarS0 = cVarBuffer.S0(1);
            if (z10) {
                Deflater deflater = this.f3416b;
                byte[] bArr = wVarS0.f3486a;
                int i10 = wVarS0.f3488c;
                iDeflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
            } else {
                Deflater deflater2 = this.f3416b;
                byte[] bArr2 = wVarS0.f3486a;
                int i11 = wVarS0.f3488c;
                iDeflate = deflater2.deflate(bArr2, i11, 8192 - i11);
            }
            if (iDeflate > 0) {
                wVarS0.f3488c += iDeflate;
                cVarBuffer.f3404b += (long) iDeflate;
                this.f3415a.N();
            } else if (this.f3416b.needsInput()) {
                break;
            }
        }
        if (wVarS0.f3487b == wVarS0.f3488c) {
            cVarBuffer.f3403a = wVarS0.b();
            x.a(wVarS0);
        }
    }

    public void c() throws IOException {
        this.f3416b.finish();
        b(false);
    }

    @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f3417c) {
            return;
        }
        c();
        th = null;
        try {
            this.f3416b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f3415a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f3417c = true;
        if (th != null) {
            d0.f(th);
        }
    }

    @Override // cr.z
    public b0 f() {
        return this.f3415a.f();
    }

    @Override // cr.z, java.io.Flushable
    public void flush() throws IOException {
        b(true);
        this.f3415a.flush();
    }

    public String toString() {
        return "DeflaterSink(" + this.f3415a + ")";
    }

    public g(d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f3415a = dVar;
        this.f3416b = deflater;
    }
}
