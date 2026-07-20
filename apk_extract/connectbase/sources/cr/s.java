package cr;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3461a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3464d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.j
    public z f3467g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3462b = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f3465e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0 f3466f = new b();

    public final class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f3468a = new t();

        public a() {
        }

        @Override // cr.z
        public void Z0(c cVar, long j10) throws IOException {
            z zVar;
            synchronized (s.this.f3462b) {
                try {
                    if (!s.this.f3463c) {
                        while (true) {
                            if (j10 <= 0) {
                                zVar = null;
                                break;
                            }
                            s sVar = s.this;
                            zVar = sVar.f3467g;
                            if (zVar != null) {
                                break;
                            }
                            if (sVar.f3464d) {
                                throw new IOException("source is closed");
                            }
                            long j11 = sVar.f3461a;
                            c cVar2 = sVar.f3462b;
                            long j12 = j11 - cVar2.f3404b;
                            if (j12 == 0) {
                                this.f3468a.k(cVar2);
                            } else {
                                long jMin = Math.min(j12, j10);
                                s.this.f3462b.Z0(cVar, jMin);
                                j10 -= jMin;
                                s.this.f3462b.notifyAll();
                            }
                        }
                    } else {
                        throw new IllegalStateException("closed");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (zVar != null) {
                this.f3468a.m(zVar.f());
                try {
                    zVar.Z0(cVar, j10);
                } finally {
                    this.f3468a.l();
                }
            }
        }

        @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (s.this.f3462b) {
                try {
                    s sVar = s.this;
                    if (sVar.f3463c) {
                        return;
                    }
                    z zVar = sVar.f3467g;
                    if (zVar == null) {
                        if (sVar.f3464d && sVar.f3462b.f3404b > 0) {
                            throw new IOException("source is closed");
                        }
                        sVar.f3463c = true;
                        sVar.f3462b.notifyAll();
                        zVar = null;
                    }
                    if (zVar != null) {
                        this.f3468a.m(zVar.f());
                        try {
                            zVar.close();
                        } finally {
                            this.f3468a.l();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // cr.z
        public b0 f() {
            return this.f3468a;
        }

        @Override // cr.z, java.io.Flushable
        public void flush() throws IOException {
            z zVar;
            synchronized (s.this.f3462b) {
                try {
                    s sVar = s.this;
                    if (sVar.f3463c) {
                        throw new IllegalStateException("closed");
                    }
                    zVar = sVar.f3467g;
                    if (zVar == null) {
                        if (sVar.f3464d && sVar.f3462b.f3404b > 0) {
                            throw new IOException("source is closed");
                        }
                        zVar = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (zVar != null) {
                this.f3468a.m(zVar.f());
                try {
                    zVar.flush();
                } finally {
                    this.f3468a.l();
                }
            }
        }
    }

    public final class b implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f3470a = new b0();

        public b() {
        }

        @Override // cr.a0
        public long Y0(c cVar, long j10) throws IOException {
            synchronized (s.this.f3462b) {
                try {
                    if (s.this.f3464d) {
                        throw new IllegalStateException("closed");
                    }
                    while (true) {
                        s sVar = s.this;
                        c cVar2 = sVar.f3462b;
                        if (cVar2.f3404b != 0) {
                            long jY0 = cVar2.Y0(cVar, j10);
                            s.this.f3462b.notifyAll();
                            return jY0;
                        }
                        if (sVar.f3463c) {
                            return -1L;
                        }
                        this.f3470a.k(cVar2);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (s.this.f3462b) {
                s sVar = s.this;
                sVar.f3464d = true;
                sVar.f3462b.notifyAll();
            }
        }

        @Override // cr.a0
        public b0 f() {
            return this.f3470a;
        }
    }

    public s(long j10) {
        if (j10 < 1) {
            throw new IllegalArgumentException(h0.b.a("maxBufferSize < 1: ", j10));
        }
        this.f3461a = j10;
    }

    public void b(z zVar) throws IOException {
        boolean z10;
        c cVar;
        while (true) {
            synchronized (this.f3462b) {
                try {
                    if (this.f3467g != null) {
                        throw new IllegalStateException("sink already folded");
                    }
                    if (this.f3462b.b1()) {
                        this.f3464d = true;
                        this.f3467g = zVar;
                        return;
                    } else {
                        z10 = this.f3463c;
                        cVar = new c();
                        c cVar2 = this.f3462b;
                        cVar.Z0(cVar2, cVar2.f3404b);
                        this.f3462b.notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            try {
                zVar.Z0(cVar, cVar.f3404b);
                if (z10) {
                    zVar.close();
                } else {
                    zVar.flush();
                }
            } catch (Throwable th3) {
                synchronized (this.f3462b) {
                    this.f3464d = true;
                    this.f3462b.notifyAll();
                    throw th3;
                }
            }
        }
    }

    public final z c() {
        return this.f3465e;
    }

    public final a0 d() {
        return this.f3466f;
    }
}
