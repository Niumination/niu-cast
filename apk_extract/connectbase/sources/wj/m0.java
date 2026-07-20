package wj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 implements t {
    @Override // wj.k3
    public void a(k3.a aVar) {
        g().a(aVar);
    }

    @Override // wj.t
    public void b(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
        g().b(y2Var, aVar, v1Var);
    }

    @Override // wj.k3
    public void d() {
        g().d();
    }

    @Override // wj.t
    public void f(vj.v1 v1Var) {
        g().f(v1Var);
    }

    public abstract t g();

    public String toString() {
        return c1.z.c(this).j("delegate", g()).toString();
    }
}
