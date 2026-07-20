package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final eo.e1 f17737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final lm.d0 f17738b;

    public static final class a extends kn.n0 implements jn.a<f0> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final f0 invoke() {
            return t0.b(s0.this.f17737a);
        }
    }

    public s0(@os.l eo.e1 e1Var) {
        kn.l0.p(e1Var, "typeParameter");
        this.f17737a = e1Var;
        this.f17738b = lm.f0.c(lm.h0.PUBLICATION, new a());
    }

    @Override // vp.c1
    public boolean a() {
        return true;
    }

    @Override // vp.c1
    @os.l
    public c1 b(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.c1
    @os.l
    public o1 c() {
        return o1.OUT_VARIANCE;
    }

    public final f0 e() {
        return (f0) this.f17738b.getValue();
    }

    @Override // vp.c1
    @os.l
    public f0 getType() {
        return e();
    }
}
