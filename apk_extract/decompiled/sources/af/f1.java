package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f257a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f259c;

    public f1(ze.q2 q2Var, c0 c0Var) {
        v8.c("error must not be OK", !q2Var.e());
        this.f258b = q2Var;
        this.f259c = c0Var;
    }

    @Override // ze.q0
    public final ze.r0 d() {
        switch (this.f257a) {
            case 0:
                throw new UnsupportedOperationException("Not a real transport");
            default:
                return ((r3) this.f259c).d();
        }
    }

    @Override // af.e0
    public final b0 f(ze.r1 r1Var, ze.p1 p1Var, ze.f fVar, ze.n[] nVarArr) {
        Object obj = this.f259c;
        Object obj2 = this.f258b;
        switch (this.f257a) {
            case 0:
                return new e1((ze.q2) obj2, (c0) obj, nVarArr);
            default:
                ze.f fVar2 = ze.f.f11346i;
                v8.i(fVar, "callOptions cannot be null");
                ze.n nVarA = ((p001if.p) obj2).a(new k3.b0(fVar, 0, false), p1Var);
                v8.n(nVarArr[nVarArr.length - 1] == l1.f424s, "lb tracer already assigned");
                nVarArr[nVarArr.length - 1] = nVarA;
                return ((r3) obj).f(r1Var, p1Var, fVar, nVarArr);
        }
    }

    public f1(p001if.p pVar, r3 r3Var) {
        this.f258b = pVar;
        this.f259c = r3Var;
    }
}
