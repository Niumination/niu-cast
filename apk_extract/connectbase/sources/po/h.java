package po;

import eo.h1;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import lm.t0;
import nm.h0;
import nm.z;
import os.l;
import os.m;
import ro.k;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    @l
    public static final List<h1> a(@l Collection<i> collection, @l Collection<? extends h1> collection2, @l eo.a aVar) {
        l0.p(collection, "newValueParametersTypes");
        l0.p(collection2, "oldValueParameters");
        l0.p(aVar, "newOwner");
        collection.size();
        collection2.size();
        List listI6 = h0.i6(collection, collection2);
        ArrayList arrayList = new ArrayList(z.b0(listI6, 10));
        for (Iterator it = listI6.iterator(); it.hasNext(); it = it) {
            t0 t0Var = (t0) it.next();
            i iVar = (i) t0Var.component1();
            h1 h1Var = (h1) t0Var.component2();
            int iF = h1Var.f();
            fo.g annotations = h1Var.getAnnotations();
            dp.f name = h1Var.getName();
            l0.o(name, "oldParameter.name");
            f0 f0Var = iVar.f13228a;
            boolean z10 = iVar.f13229b;
            boolean zP0 = h1Var.p0();
            boolean zN0 = h1Var.n0();
            f0 f0VarK = h1Var.s0() != null ? lp.a.l(aVar).n().k(iVar.f13228a) : null;
            z0 source = h1Var.getSource();
            l0.o(source, "oldParameter.source");
            arrayList.add(new ho.l0(aVar, null, iF, annotations, name, f0Var, z10, zP0, zN0, f0VarK, source));
        }
        return arrayList;
    }

    @m
    public static final k b(@l eo.e eVar) {
        l0.p(eVar, "<this>");
        eo.e eVarP = lp.a.p(eVar);
        if (eVarP == null) {
            return null;
        }
        op.h hVarK0 = eVarP.k0();
        k kVar = hVarK0 instanceof k ? (k) hVarK0 : null;
        return kVar == null ? b(eVarP) : kVar;
    }
}
