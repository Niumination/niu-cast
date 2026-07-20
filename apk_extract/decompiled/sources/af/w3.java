package af;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class w3 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h6 f648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l6 f649d;
    public ze.o e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v3 f652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i0 f655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i0 f656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f657o;
    public boolean p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f658r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f659s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f660t;

    public w3(h hVar, int i8, h6 h6Var, l6 l6Var) {
        ze.o oVar = ze.o.f11387b;
        this.f652j = v3.HEADER;
        this.f653k = 5;
        this.f656n = new i0();
        this.p = false;
        this.q = -1;
        this.f659s = false;
        this.f660t = false;
        this.f646a = hVar;
        this.e = oVar;
        this.f647b = i8;
        v8.i(h6Var, "statsTraceCtx");
        this.f648c = h6Var;
        v8.i(l6Var, "transportTracer");
        this.f649d = l6Var;
    }

    public final void a(cf.v vVar) throws Throwable {
        boolean z2 = true;
        try {
            if (!isClosed() && !this.f659s) {
                this.f656n.w(vVar);
                try {
                    c();
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    z2 = false;
                    if (z2) {
                        vVar.close();
                    }
                    throw th;
                }
            }
            vVar.close();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void c() {
        if (this.p) {
            return;
        }
        boolean z2 = true;
        this.p = true;
        while (!this.f660t && this.f657o > 0 && i()) {
            try {
                int i8 = t3.f595a[this.f652j.ordinal()];
                if (i8 == 1) {
                    h();
                } else {
                    if (i8 != 2) {
                        throw new AssertionError("Invalid state: " + this.f652j);
                    }
                    g();
                    this.f657o--;
                }
            } catch (Throwable th2) {
                this.p = false;
                throw th2;
            }
        }
        if (this.f660t) {
            close();
            this.p = false;
            return;
        }
        if (this.f659s) {
            if (this.f656n.f322c != 0) {
                z2 = false;
            }
            if (z2) {
                close();
            }
        }
        this.p = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (isClosed()) {
            return;
        }
        i0 i0Var = this.f655m;
        boolean z2 = false;
        if (i0Var != null && i0Var.f322c > 0) {
            z2 = true;
        }
        try {
            i0 i0Var2 = this.f656n;
            if (i0Var2 != null) {
                i0Var2.close();
            }
            i0 i0Var3 = this.f655m;
            if (i0Var3 != null) {
                i0Var3.close();
            }
            this.f656n = null;
            this.f655m = null;
            this.f646a.k(z2);
        } catch (Throwable th2) {
            this.f656n = null;
            this.f655m = null;
            throw th2;
        }
    }

    public final void g() {
        Object u3Var;
        boolean z2 = false;
        int i8 = this.q;
        long j8 = this.f658r;
        h6 h6Var = this.f648c;
        for (ze.n nVar : h6Var.f312a) {
            nVar.d(i8, j8);
        }
        this.f658r = 0;
        if (this.f654l) {
            ze.o oVar = this.e;
            if (oVar == ze.o.f11387b) {
                throw new ze.s2(ze.q2.f11410m.h("Can't decode compressed gRPC message as compression not configured"));
            }
            try {
                i0 i0Var = this.f655m;
                l4 l4Var = m4.f457a;
                k4 k4Var = new k4();
                v8.i(i0Var, "buffer");
                k4Var.f400a = i0Var;
                InputStream gZIPInputStream = k4Var;
                switch (oVar.f11388a) {
                    case 0:
                        break;
                    default:
                        gZIPInputStream = new GZIPInputStream(k4Var);
                        break;
                }
                u3Var = new u3(gZIPInputStream, this.f647b, h6Var);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            long j10 = this.f655m.f322c;
            ze.n[] nVarArr = h6Var.f312a;
            for (ze.n nVar2 : nVarArr) {
                nVar2.f(j10);
            }
            i0 i0Var2 = this.f655m;
            l4 l4Var2 = m4.f457a;
            k4 k4Var2 = new k4();
            v8.i(i0Var2, "buffer");
            k4Var2.f400a = i0Var2;
            u3Var = k4Var2;
        }
        this.f655m.getClass();
        this.f655m = null;
        h hVar = this.f646a;
        a8.a aVar = new a8.a(2, z2);
        aVar.f44b = u3Var;
        hVar.m().j(aVar);
        this.f652j = v3.HEADER;
        this.f653k = 5;
    }

    public final void h() {
        int iM = this.f655m.m();
        if ((iM & 254) != 0) {
            throw new ze.s2(ze.q2.f11410m.h("gRPC frame header malformed: reserved bits not zero"));
        }
        this.f654l = (iM & 1) != 0;
        i0 i0Var = this.f655m;
        i0Var.a(4);
        int iM2 = i0Var.m() | (i0Var.m() << 24) | (i0Var.m() << 16) | (i0Var.m() << 8);
        this.f653k = iM2;
        if (iM2 < 0 || iM2 > this.f647b) {
            ze.q2 q2Var = ze.q2.f11408k;
            Locale locale = Locale.US;
            throw new ze.s2(q2Var.h("gRPC message exceeds maximum size " + this.f647b + ": " + iM2));
        }
        int i8 = this.q + 1;
        this.q = i8;
        for (ze.n nVar : this.f648c.f312a) {
            nVar.c(i8);
        }
        l6 l6Var = this.f649d;
        ((s2) l6Var.f447c).e();
        ((k2) l6Var.f446b).g();
        this.f652j = v3.BODY;
    }

    public final boolean i() throws Throwable {
        h6 h6Var = this.f648c;
        int i8 = 0;
        try {
            if (this.f655m == null) {
                this.f655m = new i0();
            }
            int i9 = 0;
            while (true) {
                try {
                    int i10 = this.f653k - this.f655m.f322c;
                    if (i10 <= 0) {
                        if (i9 <= 0) {
                            return true;
                        }
                        this.f646a.h(i9);
                        if (this.f652j != v3.BODY) {
                            return true;
                        }
                        h6Var.a(i9);
                        this.f658r += i9;
                        return true;
                    }
                    int i11 = this.f656n.f322c;
                    if (i11 == 0) {
                        if (i9 > 0) {
                            this.f646a.h(i9);
                            if (this.f652j == v3.BODY) {
                                h6Var.a(i9);
                                this.f658r += i9;
                            }
                        }
                        return false;
                    }
                    int iMin = Math.min(i10, i11);
                    i9 += iMin;
                    this.f655m.w(this.f656n.h(iMin));
                } catch (Throwable th2) {
                    int i12 = i9;
                    th = th2;
                    i8 = i12;
                    if (i8 > 0) {
                        this.f646a.h(i8);
                        if (this.f652j == v3.BODY) {
                            h6Var.a(i8);
                            this.f658r += i8;
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean isClosed() {
        return this.f656n == null;
    }

    public final void k(ze.o oVar) {
        v8.n(true, "Already set full stream decompressor");
        this.e = oVar;
    }
}
