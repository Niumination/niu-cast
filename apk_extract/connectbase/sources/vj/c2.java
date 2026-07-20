package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c2<ReqT, RespT> extends k2<ReqT, RespT> {
    @Override // vj.k2
    public void a(y2 y2Var, v1 v1Var) {
        n().a(y2Var, v1Var);
    }

    @Override // vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/1779")
    public a b() {
        return n().b();
    }

    @Override // vj.k2
    public String c() {
        return n().c();
    }

    @Override // vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/4692")
    public h2 e() {
        return n().e();
    }

    @Override // vj.k2
    public boolean f() {
        return n().f();
    }

    @Override // vj.k2
    public boolean g() {
        return n().g();
    }

    @Override // vj.k2
    public void h(int i10) {
        n().h(i10);
    }

    @Override // vj.k2
    public void i(v1 v1Var) {
        n().i(v1Var);
    }

    @Override // vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/1704")
    public void k(String str) {
        n().k(str);
    }

    @Override // vj.k2
    public void l(boolean z10) {
        n().l(z10);
    }

    @Override // vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/11021")
    public void m(int i10) {
        n().m(i10);
    }

    public abstract k2<?, ?> n();

    public String toString() {
        return c1.z.c(this).j("delegate", n()).toString();
    }
}
