package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 extends b4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ze.q2 f227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f228d;
    public final ze.n[] e;

    public e1(ze.q2 q2Var, c0 c0Var, ze.n[] nVarArr) {
        v8.c("error must not be OK", !q2Var.e());
        this.f227c = q2Var;
        this.f228d = c0Var;
        this.e = nVarArr;
    }

    @Override // af.b4, af.b0
    public final void c(d0 d0Var) {
        v8.n(!this.f226b, "already started");
        this.f226b = true;
        ze.n[] nVarArr = this.e;
        int length = nVarArr.length;
        int i8 = 0;
        while (true) {
            ze.q2 q2Var = this.f227c;
            if (i8 >= length) {
                d0Var.l(q2Var, this.f228d, new ze.p1());
                return;
            } else {
                nVarArr[i8].m(q2Var);
                i8++;
            }
        }
    }

    @Override // af.b4, af.b0
    public final void j(t1 t1Var) {
        t1Var.a(this.f227c, "error");
        t1Var.a(this.f228d, "progress");
    }

    public e1(ze.q2 q2Var, ze.n[] nVarArr) {
        this(q2Var, c0.PROCESSED, nVarArr);
    }
}
