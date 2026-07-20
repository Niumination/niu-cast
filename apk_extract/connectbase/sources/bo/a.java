package bo;

import ao.f;
import eo.h0;
import eo.k0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jq.e0;
import kn.l0;
import nm.m0;
import os.l;
import os.m;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements go.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final n f986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final h0 f987b;

    public a(@l n nVar, @l h0 h0Var) {
        l0.p(nVar, "storageManager");
        l0.p(h0Var, "module");
        this.f986a = nVar;
        this.f987b = h0Var;
    }

    @Override // go.b
    @l
    public Collection<eo.e> a(@l dp.c cVar) {
        l0.p(cVar, "packageFqName");
        return m0.INSTANCE;
    }

    @Override // go.b
    @m
    public eo.e b(@l dp.b bVar) {
        l0.p(bVar, "classId");
        if (bVar.f3808c || bVar.l()) {
            return null;
        }
        String strB = bVar.i().b();
        l0.o(strB, "classId.relativeClassName.asString()");
        if (!jq.h0.T2(strB, "Function", false, 2, null)) {
            return null;
        }
        dp.c cVarH = bVar.h();
        l0.o(cVarH, "classId.packageFqName");
        c.a.C0035a c0035aC = c.Companion.c(strB, cVarH);
        if (c0035aC == null) {
            return null;
        }
        c cVar = c0035aC.f1000a;
        int i10 = c0035aC.f1001b;
        List<k0> listG0 = this.f987b.o0(cVarH).g0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listG0) {
            if (obj instanceof ao.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof f) {
                arrayList2.add(obj2);
            }
        }
        k0 k0Var = (f) nm.h0.G2(arrayList2);
        if (k0Var == null) {
            k0Var = (ao.b) nm.h0.B2(arrayList);
        }
        return new b(this.f986a, k0Var, cVar, i10);
    }

    @Override // go.b
    public boolean c(@l dp.c cVar, @l dp.f fVar) {
        l0.p(cVar, "packageFqName");
        l0.p(fVar, "name");
        String strB = fVar.b();
        l0.o(strB, "name.asString()");
        return (e0.s2(strB, "Function", false, 2, null) || e0.s2(strB, "KFunction", false, 2, null) || e0.s2(strB, "SuspendFunction", false, 2, null) || e0.s2(strB, "KSuspendFunction", false, 2, null)) && c.Companion.c(strB, cVar) != null;
    }
}
