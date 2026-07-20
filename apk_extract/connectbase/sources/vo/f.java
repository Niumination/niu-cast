package vo;

import kn.l0;
import vp.f0;
import vp.g0;
import vp.j1;
import vp.k0;
import vp.l1;
import vp.n0;
import vp.n1;
import vp.z;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends vp.q implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final n0 f17618b;

    public f(@os.l n0 n0Var) {
        l0.p(n0Var, "delegate");
        this.f17618b = n0Var;
    }

    @Override // vp.n
    public boolean B() {
        return true;
    }

    @Override // vp.q, vp.f0
    public boolean H0() {
        return false;
    }

    @Override // vp.n1
    @os.l
    public n0 N0(boolean z10) {
        return z10 ? this.f17618b.N0(true) : this;
    }

    @Override // vp.q
    @os.l
    public n0 P0() {
        return this.f17618b;
    }

    public final n0 S0(n0 n0Var) {
        n0 n0VarN0 = n0Var.N0(false);
        return !zp.a.o(n0Var) ? n0VarN0 : new f(n0VarN0);
    }

    @Override // vp.n0
    @os.l
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public f O0(@os.l fo.g gVar) {
        l0.p(gVar, "newAnnotations");
        return new f(this.f17618b.O0(gVar));
    }

    @Override // vp.q
    @os.l
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public f R0(@os.l n0 n0Var) {
        l0.p(n0Var, "delegate");
        return new f(n0Var);
    }

    @Override // vp.n
    @os.l
    public f0 Z(@os.l f0 f0Var) {
        l0.p(f0Var, "replacement");
        n1 n1VarJ0 = f0Var.J0();
        if (!zp.a.o(n1VarJ0) && !j1.m(n1VarJ0)) {
            return n1VarJ0;
        }
        if (n1VarJ0 instanceof n0) {
            return S0((n0) n1VarJ0);
        }
        if (!(n1VarJ0 instanceof z)) {
            throw new IllegalStateException(l0.C("Incorrect type: ", n1VarJ0).toString());
        }
        z zVar = (z) n1VarJ0;
        return l1.e(g0.d(S0(zVar.f17773b), S0(zVar.f17774c)), l1.a(n1VarJ0));
    }
}
