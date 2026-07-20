package wo;

import java.util.Collection;
import java.util.Set;
import kn.l0;
import kn.n0;
import lm.t0;
import nm.k0;
import nm.n1;
import nm.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f19781b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final Set<xo.a.EnumC0527a> f19782c = n1.f(xo.a.EnumC0527a.CLASS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Set<xo.a.EnumC0527a> f19783d = o1.u(xo.a.EnumC0527a.FILE_FACADE, xo.a.EnumC0527a.MULTIFILE_CLASS_PART);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final cp.e f19784e = new cp.e(1, 1, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final cp.e f19785f = new cp.e(1, 1, 11);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final cp.e f19786g = new cp.e(1, 1, 13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rp.j f19787a;

    public static final class a {
        public a() {
        }

        @os.l
        public final cp.e a() {
            return f.f19786g;
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends n0 implements jn.a<Collection<? extends dp.f>> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Collection<? extends dp.f> invoke() {
            return k0.INSTANCE;
        }
    }

    @os.m
    public final op.h c(@os.l eo.k0 k0Var, @os.l p pVar) {
        t0<cp.f, yo.a.l> t0VarM;
        l0.p(k0Var, "descriptor");
        l0.p(pVar, "kotlinClass");
        String[] strArrK = k(pVar, f19783d);
        if (strArrK == null) {
            return null;
        }
        String[] strArr = pVar.b().f20442e;
        try {
            if (strArr == null) {
                return null;
            }
            try {
                t0VarM = cp.g.m(strArrK, strArr);
            } catch (fp.k e10) {
                throw new IllegalStateException(l0.C("Could not read data from ", pVar.getLocation()), e10);
            }
        } catch (Throwable th2) {
            if (g() || pVar.b().f20439b.h()) {
                throw th2;
            }
            t0VarM = null;
        }
        if (t0VarM == null) {
            return null;
        }
        cp.f fVarComponent1 = t0VarM.component1();
        yo.a.l lVarComponent2 = t0VarM.component2();
        j jVar = new j(pVar, lVarComponent2, fVarComponent1, f(pVar), i(pVar), d(pVar));
        return new tp.j(k0Var, lVarComponent2, fVarComponent1, pVar.b().f20439b, jVar, e(), "scope for " + jVar + " in " + k0Var, b.INSTANCE);
    }

    public final tp.f d(p pVar) {
        if (e().f14729c.d()) {
            return tp.f.STABLE;
        }
        if (pVar.b().j()) {
            return tp.f.FIR_UNSTABLE;
        }
        return pVar.b().k() ? tp.f.IR_UNSTABLE : tp.f.STABLE;
    }

    @os.l
    public final rp.j e() {
        rp.j jVar = this.f19787a;
        if (jVar != null) {
            return jVar;
        }
        l0.S("components");
        return null;
    }

    public final rp.s<cp.e> f(p pVar) {
        if (g() || pVar.b().f20439b.h()) {
            return null;
        }
        return new rp.s<>(pVar.b().f20439b, cp.e.f3370i, pVar.getLocation(), pVar.f());
    }

    public final boolean g() {
        return e().f14729c.e();
    }

    public final boolean h(p pVar) {
        return !e().f14729c.b() && pVar.b().i() && l0.g(pVar.b().f20439b, f19785f);
    }

    public final boolean i(p pVar) {
        return (e().f14729c.f() && (pVar.b().i() || l0.g(pVar.b().f20439b, f19784e))) || h(pVar);
    }

    @os.m
    public final rp.f j(@os.l p pVar) {
        String[] strArr;
        t0<cp.f, yo.a.c> t0VarI;
        l0.p(pVar, "kotlinClass");
        String[] strArrK = k(pVar, f19782c);
        if (strArrK == null || (strArr = pVar.b().f20442e) == null) {
            return null;
        }
        try {
            try {
                t0VarI = cp.g.i(strArrK, strArr);
            } catch (fp.k e10) {
                throw new IllegalStateException(l0.C("Could not read data from ", pVar.getLocation()), e10);
            }
        } catch (Throwable th2) {
            if (g() || pVar.b().f20439b.h()) {
                throw th2;
            }
            t0VarI = null;
        }
        if (t0VarI == null) {
            return null;
        }
        return new rp.f(t0VarI.component1(), t0VarI.component2(), pVar.b().f20439b, new r(pVar, f(pVar), i(pVar), d(pVar)));
    }

    public final String[] k(p pVar, Set<? extends xo.a.EnumC0527a> set) {
        xo.a aVarB = pVar.b();
        String[] strArr = aVarB.f20440c;
        if (strArr == null) {
            strArr = aVarB.f20441d;
        }
        if (strArr != null && set.contains(aVarB.f20438a)) {
            return strArr;
        }
        return null;
    }

    @os.m
    public final eo.e l(@os.l p pVar) {
        l0.p(pVar, "kotlinClass");
        rp.f fVarJ = j(pVar);
        if (fVarJ == null) {
            return null;
        }
        return e().f14746t.d(pVar.f(), fVarJ);
    }

    public final void m(@os.l rp.j jVar) {
        l0.p(jVar, "<set-?>");
        this.f19787a = jVar;
    }

    public final void n(@os.l d dVar) {
        l0.p(dVar, "components");
        m(dVar.f19778a);
    }
}
