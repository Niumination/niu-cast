package af;

import k3.t8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g1 implements j0 {
    @Override // af.r3
    public void a(ze.q2 q2Var) {
        b().a(q2Var);
    }

    public abstract j0 b();

    @Override // af.r3
    public void c(ze.q2 q2Var) {
        b().c(q2Var);
    }

    @Override // ze.q0
    public final ze.r0 d() {
        return b().d();
    }

    @Override // af.r3
    public final Runnable g(q3 q3Var) {
        return b().g(q3Var);
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(b(), "delegate");
        return aVarA.toString();
    }
}
