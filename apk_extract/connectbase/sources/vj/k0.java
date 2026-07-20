package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k0<ReqT, RespT> extends c2<ReqT, RespT> {

    public static abstract class a<ReqT, RespT> extends k0<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k2<ReqT, RespT> f17165a;

        public a(k2<ReqT, RespT> k2Var) {
            this.f17165a = k2Var;
        }

        @Override // vj.k0, vj.c2, vj.k2
        public /* bridge */ /* synthetic */ void a(y2 y2Var, v1 v1Var) {
            super.a(y2Var, v1Var);
        }

        @Override // vj.k0, vj.c2, vj.k2
        @e0("https://github.com/grpc/grpc-java/issues/1779")
        public /* bridge */ /* synthetic */ vj.a b() {
            return super.b();
        }

        @Override // vj.k0, vj.c2, vj.k2
        public /* bridge */ /* synthetic */ String c() {
            return super.c();
        }

        @Override // vj.k0, vj.c2, vj.k2
        @e0("https://github.com/grpc/grpc-java/issues/4692")
        public /* bridge */ /* synthetic */ h2 e() {
            return super.e();
        }

        @Override // vj.k0, vj.c2, vj.k2
        public /* bridge */ /* synthetic */ boolean f() {
            return super.f();
        }

        @Override // vj.k0, vj.c2, vj.k2
        public /* bridge */ /* synthetic */ boolean g() {
            return super.g();
        }

        @Override // vj.k0, vj.c2, vj.k2
        public /* bridge */ /* synthetic */ void h(int i10) {
            super.h(i10);
        }

        @Override // vj.k0, vj.c2, vj.k2
        public /* bridge */ /* synthetic */ void i(v1 v1Var) {
            super.i(v1Var);
        }

        @Override // vj.k0, vj.c2, vj.k2
        @e0("https://github.com/grpc/grpc-java/issues/1704")
        public /* bridge */ /* synthetic */ void k(String str) {
            super.k(str);
        }

        @Override // vj.k0, vj.c2, vj.k2
        public /* bridge */ /* synthetic */ void l(boolean z10) {
            super.l(z10);
        }

        @Override // vj.k0, vj.c2, vj.k2
        @e0("https://github.com/grpc/grpc-java/issues/11021")
        public /* bridge */ /* synthetic */ void m(int i10) {
            super.m(i10);
        }

        @Override // vj.k0, vj.c2
        public k2<ReqT, RespT> n() {
            return this.f17165a;
        }

        @Override // vj.k0, vj.c2
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // vj.c2, vj.k2
    public /* bridge */ /* synthetic */ void a(y2 y2Var, v1 v1Var) {
        super.a(y2Var, v1Var);
    }

    @Override // vj.c2, vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/1779")
    public /* bridge */ /* synthetic */ vj.a b() {
        return super.b();
    }

    @Override // vj.c2, vj.k2
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    @Override // vj.k2
    public w1<ReqT, RespT> d() {
        return n().d();
    }

    @Override // vj.c2, vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/4692")
    public /* bridge */ /* synthetic */ h2 e() {
        return super.e();
    }

    @Override // vj.c2, vj.k2
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // vj.c2, vj.k2
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // vj.c2, vj.k2
    public /* bridge */ /* synthetic */ void h(int i10) {
        super.h(i10);
    }

    @Override // vj.c2, vj.k2
    public /* bridge */ /* synthetic */ void i(v1 v1Var) {
        super.i(v1Var);
    }

    @Override // vj.k2
    public void j(RespT respt) {
        n().j(respt);
    }

    @Override // vj.c2, vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/1704")
    public /* bridge */ /* synthetic */ void k(String str) {
        super.k(str);
    }

    @Override // vj.c2, vj.k2
    public /* bridge */ /* synthetic */ void l(boolean z10) {
        super.l(z10);
    }

    @Override // vj.c2, vj.k2
    @e0("https://github.com/grpc/grpc-java/issues/11021")
    public /* bridge */ /* synthetic */ void m(int i10) {
        super.m(i10);
    }

    @Override // vj.c2
    public abstract k2<ReqT, RespT> n();

    @Override // vj.c2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
