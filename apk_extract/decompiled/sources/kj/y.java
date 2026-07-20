package kj;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements qj.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj.f f6975a = new qj.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qj.f f6976b = new qj.f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6978d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a0 f6979h;

    public y(a0 a0Var, long j8, boolean z2) {
        this.f6979h = a0Var;
        this.f6978d = j8;
        this.e = z2;
    }

    @Override // qj.z
    public final long W(qj.f sink, long j8) throws Throwable {
        Throwable f0Var;
        long jW;
        boolean z2;
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j10 = 0;
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        while (true) {
            synchronized (this.f6979h) {
                this.f6979h.f6881i.h();
                try {
                    if (this.f6979h.f() != null) {
                        f0Var = this.f6979h.f6884l;
                        if (f0Var == null) {
                            c cVarF = this.f6979h.f();
                            Intrinsics.checkNotNull(cVarF);
                            f0Var = new f0(cVarF);
                        }
                    } else {
                        f0Var = null;
                    }
                    if (this.f6977c) {
                        throw new IOException("stream closed");
                    }
                    qj.f fVar = this.f6976b;
                    long j11 = fVar.f9195b;
                    if (j11 > j10) {
                        jW = fVar.W(sink, Math.min(j8, j11));
                        a0 a0Var = this.f6979h;
                        long j12 = a0Var.f6875a + jW;
                        a0Var.f6875a = j12;
                        long j13 = j12 - a0Var.f6876b;
                        if (f0Var == null && j13 >= a0Var.f6886n.f6948r.a() / 2) {
                            a0 a0Var2 = this.f6979h;
                            a0Var2.f6886n.o(a0Var2.f6885m, j13);
                            a0 a0Var3 = this.f6979h;
                            a0Var3.f6876b = a0Var3.f6875a;
                        }
                    } else {
                        if (this.e || f0Var != null) {
                            jW = -1;
                        } else {
                            this.f6979h.l();
                            z2 = true;
                            jW = -1;
                        }
                        this.f6979h.f6881i.k();
                        Unit unit = Unit.INSTANCE;
                    }
                    z2 = false;
                    this.f6979h.f6881i.k();
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th2) {
                    this.f6979h.f6881i.k();
                    throw th2;
                }
                throw th;
            }
            if (!z2) {
                if (jW != -1) {
                    a(jW);
                    return jW;
                }
                if (f0Var == null) {
                    return -1L;
                }
                Intrinsics.checkNotNull(f0Var);
                throw f0Var;
            }
            j10 = 0;
        }
    }

    public final void a(long j8) {
        byte[] bArr = ej.b.f4964a;
        this.f6979h.f6886n.k(j8);
    }

    @Override // qj.z
    public final qj.b0 b() {
        return this.f6979h.f6881i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j8;
        synchronized (this.f6979h) {
            this.f6977c = true;
            qj.f fVar = this.f6976b;
            j8 = fVar.f9195b;
            fVar.a();
            a0 a0Var = this.f6979h;
            if (a0Var == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
            a0Var.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        if (j8 > 0) {
            a(j8);
        }
        this.f6979h.a();
    }
}
