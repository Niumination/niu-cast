package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final up.n f17708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.a<f0> f17709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.i<f0> f17710d;

    public static final class a extends kn.n0 implements jn.a<f0> {
        final /* synthetic */ wp.g $kotlinTypeRefiner;
        final /* synthetic */ i0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wp.g gVar, i0 i0Var) {
            super(0);
            this.$kotlinTypeRefiner = gVar;
            this.this$0 = i0Var;
        }

        @Override // jn.a
        @os.l
        public final f0 invoke() {
            return this.$kotlinTypeRefiner.a(this.this$0.f17709c.invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i0(@os.l up.n nVar, @os.l jn.a<? extends f0> aVar) {
        kn.l0.p(nVar, "storageManager");
        kn.l0.p(aVar, "computation");
        this.f17708b = nVar;
        this.f17709c = aVar;
        this.f17710d = nVar.h(aVar);
    }

    @Override // vp.p1
    @os.l
    public f0 K0() {
        return this.f17710d.invoke();
    }

    @Override // vp.p1
    public boolean L0() {
        return this.f17710d.m();
    }

    @Override // vp.f0
    @os.l
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public i0 Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return new i0(this.f17708b, new a(gVar, this));
    }
}
