package vj;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@e0("https://github.com/grpc/grpc-java/issues/2861")
public abstract class u2 extends b3 {

    public static abstract class a {
        public abstract u2 a(String str, v1 v1Var);
    }

    @Deprecated
    public static final class b<ReqT, RespT> extends k0<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c<ReqT, RespT> f17278a;

        public b(c<ReqT, RespT> cVar) {
            this.f17278a = cVar;
        }

        public static b o(c cVar) {
            return new b(cVar);
        }

        public static <ReqT, RespT> b<ReqT, RespT> p(c<ReqT, RespT> cVar) {
            return new b<>(cVar);
        }

        @Override // vj.k0, vj.c2, vj.k2
        public vj.a b() {
            return this.f17278a.a();
        }

        @Override // vj.k0, vj.c2, vj.k2
        public String c() {
            return this.f17278a.b();
        }

        @Override // vj.k0, vj.k2
        public w1<ReqT, RespT> d() {
            return this.f17278a.c();
        }

        @Override // vj.k0, vj.c2, vj.k2
        public boolean f() {
            return false;
        }

        @Override // vj.k0, vj.c2, vj.k2
        public boolean g() {
            return false;
        }

        @Override // vj.k0, vj.c2
        public k2<ReqT, RespT> n() {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class c<ReqT, RespT> {
        public abstract vj.a a();

        @gm.j
        public abstract String b();

        public abstract w1<ReqT, RespT> c();
    }

    public w j(w wVar) {
        return wVar;
    }

    @Deprecated
    public void k(k2<?, ?> k2Var) {
    }

    public void l(c<?, ?> cVar) {
        k(new b(cVar));
    }
}
