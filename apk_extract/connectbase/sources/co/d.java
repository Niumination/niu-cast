package co;

import ao.k;
import ik.y0;
import java.util.Collection;
import kn.l0;
import nm.m0;
import nm.n1;
import nm.y;
import os.l;
import os.m;
import vp.f0;
import vp.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final d f1703a = new d();

    public static /* synthetic */ eo.e h(d dVar, dp.c cVar, ao.h hVar, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        return dVar.g(cVar, hVar, num);
    }

    @l
    public final eo.e a(@l eo.e eVar) {
        l0.p(eVar, "mutable");
        dp.c cVarP = c.f1685a.p(hp.d.m(eVar));
        if (cVarP != null) {
            eo.e eVarO = lp.a.g(eVar).o(cVarP);
            l0.o(eVarO, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return eVarO;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a mutable collection");
    }

    @l
    public final eo.e b(@l eo.e eVar) {
        l0.p(eVar, "readOnly");
        dp.c cVarQ = c.f1685a.q(hp.d.m(eVar));
        if (cVarQ != null) {
            eo.e eVarO = lp.a.g(eVar).o(cVarQ);
            l0.o(eVarO, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return eVarO;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a read-only collection");
    }

    public final boolean c(@l eo.e eVar) {
        l0.p(eVar, "mutable");
        c cVar = c.f1685a;
        dp.d dVarM = hp.d.m(eVar);
        cVar.getClass();
        return c.f1697m.containsKey(dVarM);
    }

    public final boolean d(@l f0 f0Var) {
        l0.p(f0Var, y0.a.f8215h);
        eo.e eVarG = j1.g(f0Var);
        return eVarG != null && c(eVarG);
    }

    public final boolean e(@l eo.e eVar) {
        l0.p(eVar, "readOnly");
        c cVar = c.f1685a;
        dp.d dVarM = hp.d.m(eVar);
        cVar.getClass();
        return c.f1698n.containsKey(dVarM);
    }

    public final boolean f(@l f0 f0Var) {
        l0.p(f0Var, y0.a.f8215h);
        eo.e eVarG = j1.g(f0Var);
        return eVarG != null && e(eVarG);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    @m
    public final eo.e g(@l dp.c cVar, @l ao.h hVar, @m Integer num) {
        dp.b bVarN;
        l0.p(cVar, "fqName");
        l0.p(hVar, "builtIns");
        if (num != null) {
            c.f1685a.getClass();
            if (l0.g(cVar, c.f1691g)) {
                bVarN = k.a(num.intValue());
            } else {
                bVarN = c.f1685a.n(cVar);
            }
        } else {
            bVarN = c.f1685a.n(cVar);
        }
        if (bVarN != null) {
            return hVar.o(bVarN.b());
        }
        return null;
    }

    @l
    public final Collection<eo.e> i(@l dp.c cVar, @l ao.h hVar) {
        l0.p(cVar, "fqName");
        l0.p(hVar, "builtIns");
        eo.e eVarH = h(this, cVar, hVar, null, 4, null);
        if (eVarH == null) {
            return m0.INSTANCE;
        }
        dp.c cVarQ = c.f1685a.q(lp.a.j(eVarH));
        if (cVarQ == null) {
            return n1.f(eVarH);
        }
        eo.e eVarO = hVar.o(cVarQ);
        l0.o(eVarO, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return y.O(eVarH, eVarO);
    }
}
