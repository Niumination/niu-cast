package mp;

import ao.k;
import eo.e1;
import eo.h;
import eo.h1;
import eo.m;
import eo.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import os.l;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final boolean a(eo.e eVar) {
        return l0.g(lp.a.i(eVar), k.f561i);
    }

    public static final boolean b(@l m mVar) {
        l0.p(mVar, "<this>");
        return hp.f.b(mVar) && !a((eo.e) mVar);
    }

    public static final boolean c(@l f0 f0Var) {
        l0.p(f0Var, "<this>");
        h hVarD = f0Var.G0().d();
        return hVarD != null && b(hVarD);
    }

    public static final boolean d(f0 f0Var) {
        h hVarD = f0Var.G0().d();
        e1 e1Var = hVarD instanceof e1 ? (e1) hVarD : null;
        if (e1Var == null) {
            return false;
        }
        return e(zp.a.i(e1Var));
    }

    public static final boolean e(f0 f0Var) {
        return c(f0Var) || d(f0Var);
    }

    public static final boolean f(@l eo.b bVar) {
        l0.p(bVar, "descriptor");
        eo.d dVar = bVar instanceof eo.d ? (eo.d) bVar : null;
        if (dVar == null || t.g(dVar.getVisibility())) {
            return false;
        }
        eo.e eVarC0 = dVar.c0();
        l0.o(eVarC0, "constructorDescriptor.constructedClass");
        if (hp.f.b(eVarC0) || hp.d.G(dVar.c0())) {
            return false;
        }
        List<h1> listH = dVar.h();
        l0.o(listH, "constructorDescriptor.valueParameters");
        List<h1> list = listH;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f0 type = ((h1) it.next()).getType();
            l0.o(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
