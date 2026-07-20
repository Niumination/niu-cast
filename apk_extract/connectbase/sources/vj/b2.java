package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b2<RespT> extends k.a<RespT> {
    @Override // vj.k.a
    public void a(y2 y2Var, v1 v1Var) {
        e().a(y2Var, v1Var);
    }

    @Override // vj.k.a
    public void b(v1 v1Var) {
        e().b(v1Var);
    }

    @Override // vj.k.a
    public void d() {
        e().d();
    }

    public abstract k.a<?> e();

    public String toString() {
        return c1.z.c(this).j("delegate", e()).toString();
    }
}
