package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h0<ReqT, RespT> extends a2<ReqT, RespT> {

    public static abstract class a<ReqT, RespT> extends h0<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k<ReqT, RespT> f17158a;

        public a(k<ReqT, RespT> kVar) {
            this.f17158a = kVar;
        }

        @Override // vj.h0, vj.a2, vj.k
        public /* bridge */ /* synthetic */ void a(@gm.j String str, @gm.j Throwable th2) {
            super.a(str, th2);
        }

        @Override // vj.h0, vj.a2, vj.k
        public /* bridge */ /* synthetic */ vj.a b() {
            return super.b();
        }

        @Override // vj.h0, vj.a2, vj.k
        public /* bridge */ /* synthetic */ void c() {
            super.c();
        }

        @Override // vj.h0, vj.a2, vj.k
        public /* bridge */ /* synthetic */ boolean d() {
            return super.d();
        }

        @Override // vj.h0, vj.a2, vj.k
        public /* bridge */ /* synthetic */ void e(int i10) {
            super.e(i10);
        }

        @Override // vj.h0, vj.a2, vj.k
        public /* bridge */ /* synthetic */ void g(boolean z10) {
            super.g(z10);
        }

        @Override // vj.h0, vj.a2
        public k<ReqT, RespT> i() {
            return this.f17158a;
        }

        @Override // vj.h0, vj.a2
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // vj.a2, vj.k
    public /* bridge */ /* synthetic */ void a(@gm.j String str, @gm.j Throwable th2) {
        super.a(str, th2);
    }

    @Override // vj.a2, vj.k
    public /* bridge */ /* synthetic */ vj.a b() {
        return super.b();
    }

    @Override // vj.a2, vj.k
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // vj.a2, vj.k
    public /* bridge */ /* synthetic */ boolean d() {
        return super.d();
    }

    @Override // vj.a2, vj.k
    public /* bridge */ /* synthetic */ void e(int i10) {
        super.e(i10);
    }

    @Override // vj.k
    public void f(ReqT reqt) {
        i().f(reqt);
    }

    @Override // vj.a2, vj.k
    public /* bridge */ /* synthetic */ void g(boolean z10) {
        super.g(z10);
    }

    @Override // vj.k
    public void h(k.a<RespT> aVar, v1 v1Var) {
        i().h(aVar, v1Var);
    }

    @Override // vj.a2
    public abstract k<ReqT, RespT> i();

    @Override // vj.a2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
