package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k2<ReqT, RespT> {

    public static abstract class a<ReqT> {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(ReqT reqt) {
        }

        public void e() {
        }
    }

    public abstract void a(y2 y2Var, v1 v1Var);

    @e0("https://github.com/grpc/grpc-java/issues/1779")
    public vj.a b() {
        return vj.a.f17046c;
    }

    @gm.j
    public String c() {
        return null;
    }

    public abstract w1<ReqT, RespT> d();

    @e0("https://github.com/grpc/grpc-java/issues/4692")
    public h2 e() {
        return h2.NONE;
    }

    public abstract boolean f();

    public boolean g() {
        return true;
    }

    public abstract void h(int i10);

    public abstract void i(v1 v1Var);

    public abstract void j(RespT respt);

    public void k(String str) {
    }

    public void l(boolean z10) {
    }

    @e0("https://github.com/grpc/grpc-java/issues/11021")
    public void m(int i10) {
        c1.h0.k(i10 > 0, "numBytes must be positive: %s", i10);
    }
}
