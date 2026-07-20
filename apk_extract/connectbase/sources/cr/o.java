package cr;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f3444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3446d;

    public o(a0 a0Var, Inflater inflater) {
        this(p.d(a0Var), inflater);
    }

    @Override // cr.a0
    public long Y0(c cVar, long j10) throws IOException {
        boolean zB;
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        if (this.f3446d) {
            throw new IllegalStateException("closed");
        }
        if (j10 == 0) {
            return 0L;
        }
        do {
            zB = b();
            try {
                w wVarS0 = cVar.S0(1);
                int iInflate = this.f3444b.inflate(wVarS0.f3486a, wVarS0.f3488c, (int) Math.min(j10, 8192 - wVarS0.f3488c));
                if (iInflate > 0) {
                    wVarS0.f3488c += iInflate;
                    long j11 = iInflate;
                    cVar.f3404b += j11;
                    return j11;
                }
                if (!this.f3444b.finished() && !this.f3444b.needsDictionary()) {
                }
                c();
                if (wVarS0.f3487b != wVarS0.f3488c) {
                    return -1L;
                }
                cVar.f3403a = wVarS0.b();
                x.a(wVarS0);
                return -1L;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        } while (!zB);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean b() throws IOException {
        if (!this.f3444b.needsInput()) {
            return false;
        }
        c();
        if (this.f3444b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f3443a.b1()) {
            return true;
        }
        w wVar = this.f3443a.buffer().f3403a;
        int i10 = wVar.f3488c;
        int i11 = wVar.f3487b;
        int i12 = i10 - i11;
        this.f3445c = i12;
        this.f3444b.setInput(wVar.f3486a, i11, i12);
        return false;
    }

    public final void c() throws IOException {
        int i10 = this.f3445c;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f3444b.getRemaining();
        this.f3445c -= remaining;
        this.f3443a.skip(remaining);
    }

    @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3446d) {
            return;
        }
        this.f3444b.end();
        this.f3446d = true;
        this.f3443a.close();
    }

    @Override // cr.a0
    public b0 f() {
        return this.f3443a.f();
    }

    public o(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f3443a = eVar;
        this.f3444b = inflater;
    }
}
