package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class b3 extends ze.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a3 f182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j5 f183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j3 f184c;

    public b3(j3 j3Var, a3 a3Var, j5 j5Var) {
        this.f184c = j3Var;
        this.f182a = a3Var;
        v8.i(j5Var, "resolver");
        this.f183b = j5Var;
    }

    @Override // ze.f0
    public final void g(ze.q2 q2Var) {
        v8.c("the error status must not be OK", !q2Var.e());
        this.f184c.f357m.execute(new e(17, this, q2Var));
    }

    @Override // ze.f0
    public final void k(ze.t1 t1Var) {
        this.f184c.f357m.execute(new e(18, this, t1Var));
    }
}
