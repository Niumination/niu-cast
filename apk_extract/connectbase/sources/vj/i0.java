package vj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i0<RespT> extends b2<RespT> {

    public static abstract class a<RespT> extends i0<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k.a<RespT> f17162a;

        public a(k.a<RespT> aVar) {
            this.f17162a = aVar;
        }

        @Override // vj.i0, vj.b2, vj.k.a
        public /* bridge */ /* synthetic */ void a(y2 y2Var, v1 v1Var) {
            super.a(y2Var, v1Var);
        }

        @Override // vj.i0, vj.b2, vj.k.a
        public /* bridge */ /* synthetic */ void b(v1 v1Var) {
            super.b(v1Var);
        }

        @Override // vj.i0, vj.b2, vj.k.a
        public /* bridge */ /* synthetic */ void d() {
            super.d();
        }

        @Override // vj.i0, vj.b2
        public k.a<RespT> e() {
            return this.f17162a;
        }

        @Override // vj.i0, vj.b2
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // vj.b2, vj.k.a
    public /* bridge */ /* synthetic */ void a(y2 y2Var, v1 v1Var) {
        super.a(y2Var, v1Var);
    }

    @Override // vj.b2, vj.k.a
    public /* bridge */ /* synthetic */ void b(v1 v1Var) {
        super.b(v1Var);
    }

    @Override // vj.k.a
    public void c(RespT respt) {
        e().c(respt);
    }

    @Override // vj.b2, vj.k.a
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // vj.b2
    public abstract k.a<RespT> e();

    @Override // vj.b2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
