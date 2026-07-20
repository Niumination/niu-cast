package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends z implements n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f17661e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @in.f
    public static boolean f17662f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17663d;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(@os.l n0 n0Var, @os.l n0 n0Var2) {
        super(n0Var, n0Var2);
        kn.l0.p(n0Var, "lowerBound");
        kn.l0.p(n0Var2, "upperBound");
    }

    @Override // vp.n
    public boolean B() {
        return (this.f17773b.G0().d() instanceof eo.e1) && kn.l0.g(this.f17773b.G0(), this.f17774c.G0());
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: K0 */
    public n1 N0(boolean z10) {
        return g0.d(this.f17773b.N0(z10), this.f17774c.N0(z10));
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: M0 */
    public n1 O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return g0.d(this.f17773b.O0(gVar), this.f17774c.O0(gVar));
    }

    @Override // vp.z
    @os.l
    public n0 N0() {
        S0();
        return this.f17773b;
    }

    @Override // vp.z
    @os.l
    public String Q0(@os.l gp.c cVar, @os.l gp.f fVar) {
        kn.l0.p(cVar, "renderer");
        kn.l0.p(fVar, "options");
        if (!fVar.h()) {
            return cVar.v(cVar.y(this.f17773b), cVar.y(this.f17774c), zp.a.h(this));
        }
        return "(" + cVar.y(this.f17773b) + ".." + cVar.y(this.f17774c) + ')';
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public z Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return new a0((n0) gVar.a(this.f17773b), (n0) gVar.a(this.f17774c));
    }

    public final void S0() {
        if (!f17662f || this.f17663d) {
            return;
        }
        this.f17663d = true;
        c0.b(this.f17773b);
        c0.b(this.f17774c);
        kn.l0.g(this.f17773b, this.f17774c);
        wp.e.f19851a.c(this.f17773b, this.f17774c);
    }

    @Override // vp.n
    @os.l
    public f0 Z(@os.l f0 f0Var) {
        n1 n1VarD;
        kn.l0.p(f0Var, "replacement");
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof z) {
            n1VarD = n1VarJ0;
        } else {
            if (!(n1VarJ0 instanceof n0)) {
                throw new lm.i0();
            }
            n0 n0Var = (n0) n1VarJ0;
            n1VarD = g0.d(n0Var, n0Var.N0(true));
        }
        return l1.b(n1VarD, n1VarJ0);
    }

    @Override // vp.z
    @os.l
    public String toString() {
        return "(" + this.f17773b + ".." + this.f17774c + ')';
    }
}
