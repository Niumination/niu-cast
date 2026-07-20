package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends q implements n, yp.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f17723d = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final n0 f17724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17725c;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ o c(a aVar, n1 n1Var, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.b(n1Var, z10);
        }

        public final boolean a(n1 n1Var) {
            return (n1Var.G0() instanceof wp.n) || (n1Var.G0().d() instanceof eo.e1) || (n1Var instanceof wp.i) || (n1Var instanceof u0);
        }

        @os.m
        public final o b(@os.l n1 n1Var, boolean z10) {
            kn.l0.p(n1Var, ik.y0.a.f8215h);
            if (n1Var instanceof o) {
                return (o) n1Var;
            }
            if (!d(n1Var, z10)) {
                return null;
            }
            if (n1Var instanceof z) {
                z zVar = (z) n1Var;
                kn.l0.g(zVar.f17773b.G0(), zVar.f17774c.G0());
            }
            return new o(c0.c(n1Var), z10);
        }

        public final boolean d(n1 n1Var, boolean z10) {
            if (!a(n1Var)) {
                return false;
            }
            if (n1Var instanceof u0) {
                return j1.m(n1Var);
            }
            eo.h hVarD = n1Var.G0().d();
            ho.k0 k0Var = hVarD instanceof ho.k0 ? (ho.k0) hVarD : null;
            if (k0Var == null || k0Var.N0()) {
                return (z10 && (n1Var.G0().d() instanceof eo.e1)) ? j1.m(n1Var) : !wp.o.f19872a.a(n1Var);
            }
            return true;
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ o(n0 n0Var, boolean z10, kn.w wVar) {
        this(n0Var, z10);
    }

    @Override // vp.n
    public boolean B() {
        return (this.f17724b.G0() instanceof wp.n) || (this.f17724b.G0().d() instanceof eo.e1);
    }

    @Override // vp.q, vp.f0
    public boolean H0() {
        return false;
    }

    @Override // vp.n1
    @os.l
    public n0 N0(boolean z10) {
        return z10 ? this.f17724b.N0(z10) : this;
    }

    @Override // vp.q
    @os.l
    public n0 P0() {
        return this.f17724b;
    }

    @os.l
    public final n0 S0() {
        return this.f17724b;
    }

    @Override // vp.n0
    @os.l
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public o O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return new o(this.f17724b.O0(gVar), this.f17725c);
    }

    @Override // vp.q
    @os.l
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public o R0(@os.l n0 n0Var) {
        kn.l0.p(n0Var, "delegate");
        return new o(n0Var, this.f17725c);
    }

    @Override // vp.n
    @os.l
    public f0 Z(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "replacement");
        return q0.e(f0Var.J0(), this.f17725c);
    }

    @Override // vp.n0
    @os.l
    public String toString() {
        return this.f17724b + " & Any";
    }

    public o(n0 n0Var, boolean z10) {
        this.f17724b = n0Var;
        this.f17725c = z10;
    }
}
