package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class e4 extends ze.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f243a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f244b;

    public e4(ze.x0 x0Var) {
        v8.i(x0Var, "result");
        this.f244b = x0Var;
    }

    @Override // ze.z0
    public final ze.x0 a(i4 i4Var) {
        switch (this.f243a) {
            case 0:
                return (ze.x0) this.f244b;
            default:
                ze.x0 x0VarA = ((ze.z0) this.f244b).a(i4Var);
                ze.i iVar = x0VarA.f11466a;
                if (iVar == null) {
                    return x0VarA;
                }
                ze.b bVarB = iVar.b();
                return ze.x0.b(iVar, new p001if.p((p001if.i) bVarB.f11322a.get(p001if.r.f5841l), x0VarA.f11467b));
        }
    }

    public String toString() {
        switch (this.f243a) {
            case 0:
                o6.a aVar = new o6.a(e4.class.getSimpleName());
                aVar.d((ze.x0) this.f244b, "result");
                return aVar.toString();
            default:
                return super.toString();
        }
    }

    public e4(ze.z0 z0Var) {
        this.f244b = z0Var;
    }
}
