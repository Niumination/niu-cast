package vp;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f17685a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public static final f1 f17686b = new a();

    public static final class a extends f1 {
        @Override // vp.f1
        public /* bridge */ /* synthetic */ c1 e(f0 f0Var) {
            return (c1) i(f0Var);
        }

        @Override // vp.f1
        public boolean f() {
            return true;
        }

        @os.m
        public Void i(@os.l f0 f0Var) {
            kn.l0.p(f0Var, cb.b.c.f1408o);
            return null;
        }

        @os.l
        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    public static final class b {
        public b() {
        }

        public b(kn.w wVar) {
        }
    }

    public static final class c extends f1 {
        public c() {
        }

        @Override // vp.f1
        public boolean a() {
            return false;
        }

        @Override // vp.f1
        public boolean b() {
            return false;
        }

        @Override // vp.f1
        @os.l
        public fo.g d(@os.l fo.g gVar) {
            kn.l0.p(gVar, "annotations");
            return f1.this.d(gVar);
        }

        @Override // vp.f1
        @os.m
        public c1 e(@os.l f0 f0Var) {
            kn.l0.p(f0Var, cb.b.c.f1408o);
            return f1.this.e(f0Var);
        }

        @Override // vp.f1
        public boolean f() {
            return f1.this.f();
        }

        @Override // vp.f1
        @os.l
        public f0 g(@os.l f0 f0Var, @os.l o1 o1Var) {
            kn.l0.p(f0Var, "topLevelType");
            kn.l0.p(o1Var, "position");
            return f1.this.g(f0Var, o1Var);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    @os.l
    public final h1 c() {
        h1 h1VarG = h1.g(this);
        kn.l0.o(h1VarG, "create(this)");
        return h1VarG;
    }

    @os.l
    public fo.g d(@os.l fo.g gVar) {
        kn.l0.p(gVar, "annotations");
        return gVar;
    }

    @os.m
    public abstract c1 e(@os.l f0 f0Var);

    public boolean f() {
        return false;
    }

    @os.l
    public f0 g(@os.l f0 f0Var, @os.l o1 o1Var) {
        kn.l0.p(f0Var, "topLevelType");
        kn.l0.p(o1Var, "position");
        return f0Var;
    }

    @os.l
    public final f1 h() {
        return new c();
    }
}
