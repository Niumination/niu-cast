package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g0 f17692a = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final jn.l<wp.g, n0> f17693b = a.INSTANCE;

    public static final class a extends kn.n0 implements jn.l {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final Void invoke(@os.l wp.g gVar) {
            kn.l0.p(gVar, "$noName_0");
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final n0 f17694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final a1 f17695b;

        public b(@os.m n0 n0Var, @os.m a1 a1Var) {
            this.f17694a = n0Var;
            this.f17695b = a1Var;
        }

        @os.m
        public final n0 a() {
            return this.f17694a;
        }

        @os.m
        public final a1 b() {
            return this.f17695b;
        }
    }

    public static final class c extends kn.n0 implements jn.l<wp.g, n0> {
        final /* synthetic */ fo.g $annotations;
        final /* synthetic */ List<c1> $arguments;
        final /* synthetic */ a1 $constructor;
        final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(a1 a1Var, List<? extends c1> list, fo.g gVar, boolean z10) {
            super(1);
            this.$constructor = a1Var;
            this.$arguments = list;
            this.$annotations = gVar;
            this.$nullable = z10;
        }

        @Override // jn.l
        @os.m
        public final n0 invoke(@os.l wp.g gVar) {
            kn.l0.p(gVar, "refiner");
            b bVarF = g0.f17692a.f(this.$constructor, gVar, this.$arguments);
            if (bVarF == null) {
                return null;
            }
            n0 n0Var = bVarF.f17694a;
            if (n0Var != null) {
                return n0Var;
            }
            fo.g gVar2 = this.$annotations;
            a1 a1Var = bVarF.f17695b;
            kn.l0.m(a1Var);
            return g0.h(gVar2, a1Var, this.$arguments, this.$nullable, gVar);
        }
    }

    public static final class d extends kn.n0 implements jn.l<wp.g, n0> {
        final /* synthetic */ fo.g $annotations;
        final /* synthetic */ List<c1> $arguments;
        final /* synthetic */ a1 $constructor;
        final /* synthetic */ op.h $memberScope;
        final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(a1 a1Var, List<? extends c1> list, fo.g gVar, boolean z10, op.h hVar) {
            super(1);
            this.$constructor = a1Var;
            this.$arguments = list;
            this.$annotations = gVar;
            this.$nullable = z10;
            this.$memberScope = hVar;
        }

        @Override // jn.l
        @os.m
        public final n0 invoke(@os.l wp.g gVar) {
            kn.l0.p(gVar, "kotlinTypeRefiner");
            b bVarF = g0.f17692a.f(this.$constructor, gVar, this.$arguments);
            if (bVarF == null) {
                return null;
            }
            n0 n0Var = bVarF.f17694a;
            if (n0Var != null) {
                return n0Var;
            }
            fo.g gVar2 = this.$annotations;
            a1 a1Var = bVarF.f17695b;
            kn.l0.m(a1Var);
            return g0.l(gVar2, a1Var, this.$arguments, this.$nullable, this.$memberScope);
        }
    }

    @in.n
    @os.l
    public static final n0 b(@os.l eo.d1 d1Var, @os.l List<? extends c1> list) {
        kn.l0.p(d1Var, "<this>");
        kn.l0.p(list, "arguments");
        v0 v0Var = new v0(x0.a.f17772a, false);
        w0 w0VarA = w0.f17755e.a(null, d1Var, list);
        fo.g.f6167h.getClass();
        return v0Var.i(w0VarA, fo.g.a.f6169b);
    }

    @in.n
    @os.l
    public static final n1 d(@os.l n0 n0Var, @os.l n0 n0Var2) {
        kn.l0.p(n0Var, "lowerBound");
        kn.l0.p(n0Var2, "upperBound");
        return kn.l0.g(n0Var, n0Var2) ? n0Var : new a0(n0Var, n0Var2);
    }

    @in.n
    @os.l
    public static final n0 e(@os.l fo.g gVar, @os.l jp.n nVar, boolean z10) {
        kn.l0.p(gVar, "annotations");
        kn.l0.p(nVar, "constructor");
        nm.k0 k0Var = nm.k0.INSTANCE;
        op.h hVarI = x.i("Scope for integer literal type", true);
        kn.l0.o(hVarI, "createErrorScope(\"Scope …eger literal type\", true)");
        return l(gVar, nVar, k0Var, z10, hVarI);
    }

    @in.n
    @os.l
    public static final n0 g(@os.l fo.g gVar, @os.l eo.e eVar, @os.l List<? extends c1> list) {
        kn.l0.p(gVar, "annotations");
        kn.l0.p(eVar, "descriptor");
        kn.l0.p(list, "arguments");
        a1 a1VarI = eVar.i();
        kn.l0.o(a1VarI, "descriptor.typeConstructor");
        return j(gVar, a1VarI, list, false, null, 16, null);
    }

    @in.j
    @in.n
    @os.l
    public static final n0 h(@os.l fo.g gVar, @os.l a1 a1Var, @os.l List<? extends c1> list, boolean z10, @os.m wp.g gVar2) {
        kn.l0.p(gVar, "annotations");
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(list, "arguments");
        if (!gVar.isEmpty() || !list.isEmpty() || z10 || a1Var.d() == null) {
            return m(gVar, a1Var, list, z10, f17692a.c(a1Var, list, gVar2), new c(a1Var, list, gVar, z10));
        }
        eo.h hVarD = a1Var.d();
        kn.l0.m(hVarD);
        n0 n0VarQ = hVarD.q();
        kn.l0.o(n0VarQ, "constructor.declarationDescriptor!!.defaultType");
        return n0VarQ;
    }

    @in.n
    @os.l
    public static final n0 i(@os.l n0 n0Var, @os.l fo.g gVar, @os.l a1 a1Var, @os.l List<? extends c1> list, boolean z10) {
        kn.l0.p(n0Var, "baseType");
        kn.l0.p(gVar, "annotations");
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(list, "arguments");
        return j(gVar, a1Var, list, z10, null, 16, null);
    }

    public static /* synthetic */ n0 j(fo.g gVar, a1 a1Var, List list, boolean z10, wp.g gVar2, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            gVar2 = null;
        }
        return h(gVar, a1Var, list, z10, gVar2);
    }

    public static /* synthetic */ n0 k(n0 n0Var, fo.g gVar, a1 a1Var, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gVar = n0Var.getAnnotations();
        }
        if ((i10 & 4) != 0) {
            a1Var = n0Var.G0();
        }
        if ((i10 & 8) != 0) {
            list = n0Var.F0();
        }
        if ((i10 & 16) != 0) {
            z10 = n0Var.H0();
        }
        return i(n0Var, gVar, a1Var, list, z10);
    }

    @in.n
    @os.l
    public static final n0 l(@os.l fo.g gVar, @os.l a1 a1Var, @os.l List<? extends c1> list, boolean z10, @os.l op.h hVar) {
        kn.l0.p(gVar, "annotations");
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(list, "arguments");
        kn.l0.p(hVar, "memberScope");
        o0 o0Var = new o0(a1Var, list, z10, hVar, new d(a1Var, list, gVar, z10, hVar));
        return gVar.isEmpty() ? o0Var : new k(o0Var, gVar);
    }

    @in.n
    @os.l
    public static final n0 m(@os.l fo.g gVar, @os.l a1 a1Var, @os.l List<? extends c1> list, boolean z10, @os.l op.h hVar, @os.l jn.l<? super wp.g, ? extends n0> lVar) {
        kn.l0.p(gVar, "annotations");
        kn.l0.p(a1Var, "constructor");
        kn.l0.p(list, "arguments");
        kn.l0.p(hVar, "memberScope");
        kn.l0.p(lVar, "refinedTypeFactory");
        o0 o0Var = new o0(a1Var, list, z10, hVar, lVar);
        return gVar.isEmpty() ? o0Var : new k(o0Var, gVar);
    }

    public final op.h c(a1 a1Var, List<? extends c1> list, wp.g gVar) {
        eo.h hVarD = a1Var.d();
        if (hVarD instanceof eo.e1) {
            return ((eo.e1) hVarD).q().o();
        }
        if (hVarD instanceof eo.e) {
            if (gVar == null) {
                gVar = lp.a.k(lp.a.l(hVarD));
            }
            return list.isEmpty() ? ho.u.b((eo.e) hVarD, gVar) : ho.u.a((eo.e) hVarD, b1.f17666c.b(a1Var, list), gVar);
        }
        if (hVarD instanceof eo.d1) {
            op.h hVarI = x.i(kn.l0.C("Scope for abbreviation: ", ((eo.d1) hVarD).getName()), true);
            kn.l0.o(hVarI, "createErrorScope(\"Scope …{descriptor.name}\", true)");
            return hVarI;
        }
        if (a1Var instanceof e0) {
            return ((e0) a1Var).f();
        }
        throw new IllegalStateException("Unsupported classifier: " + hVarD + " for constructor: " + a1Var);
    }

    public final b f(a1 a1Var, wp.g gVar, List<? extends c1> list) {
        eo.h hVarD = a1Var.d();
        eo.h hVarF = hVarD == null ? null : gVar.f(hVarD);
        if (hVarF == null) {
            return null;
        }
        if (hVarF instanceof eo.d1) {
            return new b(b((eo.d1) hVarF, list), null);
        }
        a1 a1VarB = hVarF.i().b(gVar);
        kn.l0.o(a1VarB, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new b(null, a1VarB);
    }
}
