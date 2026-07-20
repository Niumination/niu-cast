package no;

import eo.s0;
import eo.t0;
import eo.y0;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "SpecialBuiltinMembers")
public final class f0 {

    public static final class a extends n0 implements jn.l<eo.b, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            return Boolean.valueOf(i.f11759a.b(lp.a.o(bVar)));
        }
    }

    public static final class b extends n0 implements jn.l<eo.b, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            return Boolean.valueOf(e.f11734n.j((y0) bVar));
        }
    }

    public static final class c extends n0 implements jn.l<eo.b, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            return Boolean.valueOf(ao.h.e0(bVar) && f.m(bVar) != null);
        }
    }

    public static final boolean a(@os.l eo.b bVar) {
        l0.p(bVar, "<this>");
        return d(bVar) != null;
    }

    @os.m
    public static final String b(@os.l eo.b bVar) {
        dp.f fVarI;
        l0.p(bVar, "callableMemberDescriptor");
        eo.b bVarC = c(bVar);
        if (bVarC == null) {
            return null;
        }
        eo.b bVarO = lp.a.o(bVarC);
        if (bVarO instanceof t0) {
            return i.f11759a.a(bVarO);
        }
        if (!(bVarO instanceof y0) || (fVarI = e.f11734n.i((y0) bVarO)) == null) {
            return null;
        }
        return fVarI.b();
    }

    public static final eo.b c(eo.b bVar) {
        if (ao.h.e0(bVar)) {
            return d(bVar);
        }
        return null;
    }

    @os.m
    public static final <T extends eo.b> T d(@os.l T t10) {
        l0.p(t10, "<this>");
        g0.f11742a.getClass();
        if (!g0.f11753l.contains(t10.getName())) {
            g.f11737a.getClass();
            if (!g.f11741e.contains(lp.a.o(t10).getName())) {
                return null;
            }
        }
        if (t10 instanceof t0 ? true : t10 instanceof s0) {
            return (T) lp.a.d(t10, false, a.INSTANCE, 1, null);
        }
        if (t10 instanceof y0) {
            return (T) lp.a.d(t10, false, b.INSTANCE, 1, null);
        }
        return null;
    }

    @os.m
    public static final <T extends eo.b> T e(@os.l T t10) {
        l0.p(t10, "<this>");
        T t11 = (T) d(t10);
        if (t11 != null) {
            return t11;
        }
        f fVar = f.f11736n;
        dp.f name = t10.getName();
        l0.o(name, "name");
        if (fVar.l(name)) {
            return (T) lp.a.d(t10, false, c.INSTANCE, 1, null);
        }
        return null;
    }

    public static final boolean f(@os.l eo.e eVar, @os.l eo.a aVar) {
        l0.p(eVar, "<this>");
        l0.p(aVar, "specialCallableDescriptor");
        vp.n0 n0VarQ = ((eo.e) aVar.b()).q();
        l0.o(n0VarQ, "specialCallableDescripto…ssDescriptor).defaultType");
        for (eo.e eVarS = hp.d.s(eVar); eVarS != null; eVarS = hp.d.s(eVarS)) {
            if (!(eVarS instanceof po.c) && wp.u.b(eVarS.q(), n0VarQ) != null) {
                return !ao.h.e0(eVarS);
            }
        }
        return false;
    }

    public static final boolean g(@os.l eo.b bVar) {
        l0.p(bVar, "<this>");
        return lp.a.o(bVar).b() instanceof po.c;
    }

    public static final boolean h(@os.l eo.b bVar) {
        l0.p(bVar, "<this>");
        return g(bVar) || ao.h.e0(bVar);
    }
}
