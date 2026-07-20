package hp;

import eo.d1;
import eo.e0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f7475a = new a();

    public static final void b(eo.e eVar, LinkedHashSet<eo.e> linkedHashSet, op.h hVar, boolean z10) {
        for (eo.m mVar : op.k.a.a(hVar, op.d.f12385t, null, 2, null)) {
            if (mVar instanceof eo.e) {
                eo.e eVarV = (eo.e) mVar;
                if (eVarV.i0()) {
                    dp.f name = eVarV.getName();
                    l0.o(name, "descriptor.name");
                    eo.h hVarF = hVar.f(name, mo.d.WHEN_GET_ALL_DESCRIPTORS);
                    eVarV = hVarF instanceof eo.e ? (eo.e) hVarF : hVarF instanceof d1 ? ((d1) hVarF).v() : null;
                }
                if (eVarV != null) {
                    if (d.z(eVarV, eVar)) {
                        linkedHashSet.add(eVarV);
                    }
                    if (z10) {
                        op.h hVarV = eVarV.V();
                        l0.o(hVarV, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        b(eVar, linkedHashSet, hVarV, z10);
                    }
                }
            }
        }
    }

    @os.l
    public Collection<eo.e> a(@os.l eo.e eVar, boolean z10) {
        eo.m next;
        eo.m mVarB;
        l0.p(eVar, "sealedClass");
        if (eVar.s() != e0.SEALED) {
            return k0.INSTANCE;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z10) {
            Iterator<eo.m> it = lp.a.m(eVar).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof eo.k0));
            mVarB = next;
        } else {
            mVarB = eVar.b();
        }
        if (mVarB instanceof eo.k0) {
            b(eVar, linkedHashSet, ((eo.k0) mVarB).o(), z10);
        }
        op.h hVarV = eVar.V();
        l0.o(hVarV, "sealedClass.unsubstitutedInnerClassesScope");
        b(eVar, linkedHashSet, hVarV, true);
        return linkedHashSet;
    }
}
