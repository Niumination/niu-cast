package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d2<ReqT> extends k2.a<ReqT> {
    @Override // vj.k2.a
    public void a() {
        f().a();
    }

    @Override // vj.k2.a
    public void b() {
        f().b();
    }

    @Override // vj.k2.a
    public void c() {
        f().c();
    }

    @Override // vj.k2.a
    public void e() {
        f().e();
    }

    public abstract k2.a<?> f();

    public String toString() {
        return c1.z.c(this).j("delegate", f()).toString();
    }
}
