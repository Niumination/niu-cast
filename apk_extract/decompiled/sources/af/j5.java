package af;

import k3.t8;

/* JADX INFO: loaded from: classes3.dex */
public final class j5 extends ze.i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ze.a f372g = new ze.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ze.i f373d;
    public final o e;
    public final ze.v2 f;

    public j5(b1 b1Var, o oVar, ze.v2 v2Var) {
        this.f373d = b1Var;
        this.e = oVar;
        this.f = v2Var;
    }

    @Override // ze.i
    public String e() {
        return this.f373d.e();
    }

    @Override // ze.i
    public final void n() {
        this.f373d.n();
    }

    @Override // ze.i
    public final void p() {
        this.f373d.p();
        o oVar = this.e;
        ze.v2 v2Var = oVar.f476b;
        v2Var.d();
        v2Var.execute(new a4.c(oVar, 2));
    }

    @Override // ze.i
    public final void q(ze.f0 f0Var) {
        this.f373d.q(new i5(this, f0Var));
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f373d, "delegate");
        return aVarA.toString();
    }
}
