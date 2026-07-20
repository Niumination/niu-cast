package cr;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f3457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3460f;

    public r(e eVar) {
        this.f3455a = eVar;
        c cVarBuffer = eVar.buffer();
        this.f3456b = cVarBuffer;
        w wVar = cVarBuffer.f3403a;
        this.f3457c = wVar;
        this.f3458d = wVar != null ? wVar.f3487b : -1;
    }

    @Override // cr.a0
    public long Y0(c cVar, long j10) throws IOException {
        w wVar;
        w wVar2;
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        if (this.f3459e) {
            throw new IllegalStateException("closed");
        }
        w wVar3 = this.f3457c;
        if (wVar3 != null && (wVar3 != (wVar2 = this.f3456b.f3403a) || this.f3458d != wVar2.f3487b)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j10 == 0) {
            return 0L;
        }
        if (!this.f3455a.d0(this.f3460f + 1)) {
            return -1L;
        }
        if (this.f3457c == null && (wVar = this.f3456b.f3403a) != null) {
            this.f3457c = wVar;
            this.f3458d = wVar.f3487b;
        }
        long jMin = Math.min(j10, this.f3456b.f3404b - this.f3460f);
        this.f3456b.k(cVar, this.f3460f, jMin);
        this.f3460f += jMin;
        return jMin;
    }

    @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3459e = true;
    }

    @Override // cr.a0
    public b0 f() {
        return this.f3455a.f();
    }
}
