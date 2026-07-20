package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f17739e = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final f1 f17740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final f1 f17741d;

    public static final class a {
        public a() {
        }

        @in.n
        @os.l
        public final f1 a(@os.l f1 f1Var, @os.l f1 f1Var2) {
            kn.l0.p(f1Var, "first");
            kn.l0.p(f1Var2, y1.o.r.f20674f);
            if (f1Var.f()) {
                return f1Var2;
            }
            return f1Var2.f() ? f1Var : new t(f1Var, f1Var2);
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ t(f1 f1Var, f1 f1Var2, kn.w wVar) {
        this(f1Var, f1Var2);
    }

    @in.n
    @os.l
    public static final f1 i(@os.l f1 f1Var, @os.l f1 f1Var2) {
        return f17739e.a(f1Var, f1Var2);
    }

    @Override // vp.f1
    public boolean a() {
        return this.f17740c.a() || this.f17741d.a();
    }

    @Override // vp.f1
    public boolean b() {
        return this.f17740c.b() || this.f17741d.b();
    }

    @Override // vp.f1
    @os.l
    public fo.g d(@os.l fo.g gVar) {
        kn.l0.p(gVar, "annotations");
        return this.f17741d.d(this.f17740c.d(gVar));
    }

    @Override // vp.f1
    @os.m
    public c1 e(@os.l f0 f0Var) {
        kn.l0.p(f0Var, cb.b.c.f1408o);
        c1 c1VarE = this.f17740c.e(f0Var);
        return c1VarE == null ? this.f17741d.e(f0Var) : c1VarE;
    }

    @Override // vp.f1
    public boolean f() {
        return false;
    }

    @Override // vp.f1
    @os.l
    public f0 g(@os.l f0 f0Var, @os.l o1 o1Var) {
        kn.l0.p(f0Var, "topLevelType");
        kn.l0.p(o1Var, "position");
        return this.f17741d.g(this.f17740c.g(f0Var, o1Var), o1Var);
    }

    public t(f1 f1Var, f1 f1Var2) {
        this.f17740c = f1Var;
        this.f17741d = f1Var2;
    }
}
