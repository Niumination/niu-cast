package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a2<ReqT, RespT> extends k<ReqT, RespT> {
    @Override // vj.k
    public void a(@gm.j String str, @gm.j Throwable th2) {
        i().a(str, th2);
    }

    @Override // vj.k
    public a b() {
        return i().b();
    }

    @Override // vj.k
    public void c() {
        i().c();
    }

    @Override // vj.k
    public boolean d() {
        return i().d();
    }

    @Override // vj.k
    public void e(int i10) {
        i().e(i10);
    }

    @Override // vj.k
    public void g(boolean z10) {
        i().g(z10);
    }

    public abstract k<?, ?> i();

    public String toString() {
        return c1.z.c(this).j("delegate", i()).toString();
    }
}
