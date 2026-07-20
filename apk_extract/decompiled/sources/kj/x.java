package kj;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements qj.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj.f f6971a = new qj.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f6974d;

    public x(a0 a0Var, boolean z2) {
        this.f6974d = a0Var;
        this.f6973c = z2;
    }

    public final void a(boolean z2) {
        long jMin;
        boolean z3;
        synchronized (this.f6974d) {
            try {
                this.f6974d.f6882j.h();
                while (true) {
                    try {
                        a0 a0Var = this.f6974d;
                        if (a0Var.f6877c < a0Var.f6878d || this.f6973c || this.f6972b || a0Var.f() != null) {
                            break;
                        } else {
                            this.f6974d.l();
                        }
                    } catch (Throwable th2) {
                        this.f6974d.f6882j.k();
                        throw th2;
                    }
                }
                this.f6974d.f6882j.k();
                this.f6974d.b();
                a0 a0Var2 = this.f6974d;
                jMin = Math.min(a0Var2.f6878d - a0Var2.f6877c, this.f6971a.f9195b);
                a0 a0Var3 = this.f6974d;
                a0Var3.f6877c += jMin;
                z3 = z2 && jMin == this.f6971a.f9195b && a0Var3.f() == null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        this.f6974d.f6882j.h();
        try {
            a0 a0Var4 = this.f6974d;
            a0Var4.f6886n.l(a0Var4.f6885m, z3, this.f6971a, jMin);
        } finally {
            this.f6974d.f6882j.k();
        }
    }

    @Override // qj.x
    public final qj.b0 b() {
        return this.f6974d.f6882j;
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a0 a0Var = this.f6974d;
        byte[] bArr = ej.b.f4964a;
        synchronized (a0Var) {
            if (this.f6972b) {
                return;
            }
            boolean z2 = this.f6974d.f() == null;
            Unit unit = Unit.INSTANCE;
            a0 a0Var2 = this.f6974d;
            if (!a0Var2.f6880h.f6973c) {
                if (this.f6971a.f9195b > 0) {
                    while (this.f6971a.f9195b > 0) {
                        a(true);
                    }
                } else if (z2) {
                    a0Var2.f6886n.l(a0Var2.f6885m, true, null, 0L);
                }
            }
            synchronized (this.f6974d) {
                this.f6972b = true;
                Unit unit2 = Unit.INSTANCE;
            }
            this.f6974d.f6886n.flush();
            this.f6974d.a();
        }
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() {
        a0 a0Var = this.f6974d;
        byte[] bArr = ej.b.f4964a;
        synchronized (a0Var) {
            this.f6974d.b();
            Unit unit = Unit.INSTANCE;
        }
        while (this.f6971a.f9195b > 0) {
            a(false);
            this.f6974d.f6886n.flush();
        }
    }

    @Override // qj.x
    public final void k0(qj.f source, long j8) {
        Intrinsics.checkNotNullParameter(source, "source");
        byte[] bArr = ej.b.f4964a;
        qj.f fVar = this.f6971a;
        fVar.k0(source, j8);
        while (fVar.f9195b >= 16384) {
            a(false);
        }
    }
}
