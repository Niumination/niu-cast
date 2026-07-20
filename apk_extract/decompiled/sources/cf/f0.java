package cf;

import java.io.IOException;
import ze.q2;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements g0, k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0 f1531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1532d;
    public boolean e;

    public f0(int i8, Object obj, o0 o0Var, int i9) {
        this.f1529a = i8;
        this.f1530b = obj;
        this.f1531c = new l0(o0Var, i8, o0Var.f1603a, this);
        this.f1532d = i9;
    }

    @Override // cf.k0
    public final void a(int i8) {
    }

    @Override // cf.g0
    public final void b(boolean z2, int i8, qj.f fVar, int i9) {
        synchronized (this.f1530b) {
            if (z2) {
                try {
                    this.e = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f1532d -= i8 + i9;
            try {
                fVar.A(fVar.f9195b);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    @Override // cf.g0
    public final int c() {
        int i8;
        synchronized (this.f1530b) {
            i8 = this.f1532d;
        }
        return i8;
    }

    @Override // cf.g0
    public final void d(q2 q2Var) {
    }

    @Override // cf.g0
    public final boolean e() {
        boolean z2;
        synchronized (this.f1530b) {
            z2 = this.e;
        }
        return z2;
    }

    @Override // cf.g0
    public final void f(q2 q2Var) {
    }

    @Override // cf.g0
    public final l0 g() {
        l0 l0Var;
        synchronized (this.f1530b) {
            l0Var = this.f1531c;
        }
        return l0Var;
    }
}
