package vp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f17746c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final v0 f17747d = new v0(x0.a.f17772a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final x0 f17748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17749b;

    public static final class a {
        public a() {
        }

        public final void b(int i10, eo.d1 d1Var) {
            if (i10 > 100) {
                throw new AssertionError(kn.l0.C("Too deep recursion while expanding type alias ", d1Var.getName()));
            }
        }

        public a(kn.w wVar) {
        }
    }

    public v0(@os.l x0 x0Var, boolean z10) {
        kn.l0.p(x0Var, "reportStrategy");
        this.f17748a = x0Var;
        this.f17749b = z10;
    }

    public final void a(fo.g gVar, fo.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<fo.c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().e());
        }
        for (fo.c cVar : gVar2) {
            if (hashSet.contains(cVar.e())) {
                this.f17748a.b(cVar);
            }
        }
    }

    public final void b(f0 f0Var, f0 f0Var2) {
        h1 h1VarF = h1.f(f0Var2);
        kn.l0.o(h1VarF, "create(substitutedType)");
        int i10 = 0;
        for (Object obj : f0Var2.F0()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            c1 c1Var = (c1) obj;
            if (!c1Var.a()) {
                f0 type = c1Var.getType();
                kn.l0.o(type, "substitutedArgument.type");
                if (!zp.a.d(type)) {
                    c1 c1Var2 = f0Var.F0().get(i10);
                    eo.e1 e1Var = f0Var.G0().getParameters().get(i10);
                    if (this.f17749b) {
                        x0 x0Var = this.f17748a;
                        f0 type2 = c1Var2.getType();
                        kn.l0.o(type2, "unsubstitutedArgument.type");
                        f0 type3 = c1Var.getType();
                        kn.l0.o(type3, "substitutedArgument.type");
                        kn.l0.o(e1Var, "typeParameter");
                        x0Var.c(h1VarF, type2, type3, e1Var);
                    }
                }
            }
            i10 = i11;
        }
    }

    public final u c(u uVar, fo.g gVar) {
        return uVar.O0(h(uVar, gVar));
    }

    public final n0 d(n0 n0Var, fo.g gVar) {
        return h0.a(n0Var) ? n0Var : g1.f(n0Var, null, h(n0Var, gVar), 1, null);
    }

    public final n0 e(n0 n0Var, f0 f0Var) {
        n0 n0VarS = j1.s(n0Var, f0Var.H0());
        kn.l0.o(n0VarS, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return n0VarS;
    }

    public final n0 f(n0 n0Var, f0 f0Var) {
        return d(e(n0Var, f0Var), f0Var.getAnnotations());
    }

    public final n0 g(w0 w0Var, fo.g gVar, boolean z10) {
        a1 a1VarI = w0Var.f17757b.i();
        kn.l0.o(a1VarI, "descriptor.typeConstructor");
        return g0.l(gVar, a1VarI, w0Var.f17758c, z10, op.h.c.f12406b);
    }

    public final fo.g h(f0 f0Var, fo.g gVar) {
        return h0.a(f0Var) ? f0Var.getAnnotations() : fo.i.a(gVar, f0Var.getAnnotations());
    }

    @os.l
    public final n0 i(@os.l w0 w0Var, @os.l fo.g gVar) {
        kn.l0.p(w0Var, "typeAliasExpansion");
        kn.l0.p(gVar, "annotations");
        return k(w0Var, gVar, false, 0, true);
    }

    public final c1 j(c1 c1Var, w0 w0Var, int i10) {
        e1 e1Var;
        n1 n1VarJ0 = c1Var.getType().J0();
        if (v.a(n1VarJ0)) {
            return c1Var;
        }
        n0 n0VarA = g1.a(n1VarJ0);
        if (h0.a(n0VarA) || !zp.a.u(n0VarA)) {
            return c1Var;
        }
        a1 a1VarG0 = n0VarA.G0();
        eo.h hVarD = a1VarG0.d();
        a1VarG0.getParameters().size();
        n0VarA.F0().size();
        if (hVarD instanceof eo.e1) {
            return c1Var;
        }
        if (hVarD instanceof eo.d1) {
            eo.d1 d1Var = (eo.d1) hVarD;
            if (w0Var.d(d1Var)) {
                this.f17748a.d(d1Var);
                return new e1(o1.INVARIANT, x.j(kn.l0.C("Recursive type alias: ", d1Var.getName())));
            }
            List<c1> listF0 = n0VarA.F0();
            ArrayList arrayList = new ArrayList(nm.z.b0(listF0, 10));
            int i11 = 0;
            for (Object obj : listF0) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    nm.y.Z();
                }
                arrayList.add(l((c1) obj, w0Var, a1VarG0.getParameters().get(i11), i10 + 1));
                i11 = i12;
            }
            n0 n0VarK = k(w0.f17755e.a(w0Var, d1Var, arrayList), n0VarA.getAnnotations(), n0VarA.H0(), i10 + 1, false);
            n0 n0VarM = m(n0VarA, w0Var, i10);
            if (!v.a(n0VarK)) {
                n0VarK = q0.j(n0VarK, n0VarM);
            }
            e1Var = new e1(c1Var.c(), n0VarK);
        } else {
            n0 n0VarM2 = m(n0VarA, w0Var, i10);
            b(n0VarA, n0VarM2);
            e1Var = new e1(c1Var.c(), n0VarM2);
        }
        return e1Var;
    }

    public final n0 k(w0 w0Var, fo.g gVar, boolean z10, int i10, boolean z11) {
        c1 c1VarL = l(new e1(o1.INVARIANT, w0Var.f17757b.r0()), w0Var, null, i10);
        f0 type = c1VarL.getType();
        kn.l0.o(type, "expandedProjection.type");
        n0 n0VarA = g1.a(type);
        if (h0.a(n0VarA)) {
            return n0VarA;
        }
        c1VarL.c();
        a(n0VarA.getAnnotations(), gVar);
        n0 n0VarS = j1.s(d(n0VarA, gVar), z10);
        kn.l0.o(n0VarS, "expandedType.combineAnno…fNeeded(it, isNullable) }");
        return z11 ? q0.j(n0VarS, g(w0Var, gVar, z10)) : n0VarS;
    }

    public final c1 l(c1 c1Var, w0 w0Var, eo.e1 e1Var, int i10) {
        o1 o1Var;
        o1 o1Var2;
        f17746c.b(i10, w0Var.f17757b);
        if (c1Var.a()) {
            kn.l0.m(e1Var);
            c1 c1VarT = j1.t(e1Var);
            kn.l0.o(c1VarT, "makeStarProjection(typeParameterDescriptor!!)");
            return c1VarT;
        }
        f0 type = c1Var.getType();
        kn.l0.o(type, "underlyingProjection.type");
        c1 c1VarC = w0Var.c(type.G0());
        if (c1VarC == null) {
            return j(c1Var, w0Var, i10);
        }
        if (c1VarC.a()) {
            kn.l0.m(e1Var);
            c1 c1VarT2 = j1.t(e1Var);
            kn.l0.o(c1VarT2, "makeStarProjection(typeParameterDescriptor!!)");
            return c1VarT2;
        }
        n1 n1VarJ0 = c1VarC.getType().J0();
        o1 o1VarC = c1VarC.c();
        kn.l0.o(o1VarC, "argument.projectionKind");
        o1 o1VarC2 = c1Var.c();
        kn.l0.o(o1VarC2, "underlyingProjection.projectionKind");
        if (o1VarC2 != o1VarC && o1VarC2 != (o1Var2 = o1.INVARIANT)) {
            if (o1VarC == o1Var2) {
                o1VarC = o1VarC2;
            } else {
                this.f17748a.a(w0Var.f17757b, e1Var, n1VarJ0);
            }
        }
        o1 o1VarM = e1Var == null ? o1.INVARIANT : e1Var.m();
        kn.l0.o(o1VarM, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (o1VarM != o1VarC && o1VarM != (o1Var = o1.INVARIANT)) {
            if (o1VarC == o1Var) {
                o1VarC = o1Var;
            } else {
                this.f17748a.a(w0Var.f17757b, e1Var, n1VarJ0);
            }
        }
        a(type.getAnnotations(), n1VarJ0.getAnnotations());
        return new e1(o1VarC, n1VarJ0 instanceof u ? c((u) n1VarJ0, type.getAnnotations()) : f(g1.a(n1VarJ0), type));
    }

    public final n0 m(n0 n0Var, w0 w0Var, int i10) {
        a1 a1VarG0 = n0Var.G0();
        List<c1> listF0 = n0Var.F0();
        ArrayList arrayList = new ArrayList(nm.z.b0(listF0, 10));
        int i11 = 0;
        for (Object obj : listF0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                nm.y.Z();
            }
            c1 c1Var = (c1) obj;
            c1 c1VarL = l(c1Var, w0Var, a1VarG0.getParameters().get(i11), i10 + 1);
            if (!c1VarL.a()) {
                c1VarL = new e1(c1VarL.c(), j1.r(c1VarL.getType(), c1Var.getType().H0()));
            }
            arrayList.add(c1VarL);
            i11 = i12;
        }
        return g1.f(n0Var, arrayList, null, 2, null);
    }
}
