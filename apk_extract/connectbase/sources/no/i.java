package no;

import java.util.Collection;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final i f11759a = new i();

    public static final class a extends n0 implements jn.l<eo.b, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            return Boolean.valueOf(i.f11759a.b(bVar));
        }
    }

    @os.m
    public final String a(@os.l eo.b bVar) {
        l0.p(bVar, "<this>");
        ao.h.e0(bVar);
        eo.b bVarD = lp.a.d(lp.a.o(bVar), false, a.INSTANCE, 1, null);
        if (bVarD == null) {
            return null;
        }
        g.f11737a.getClass();
        dp.f fVar = g.f11738b.get(lp.a.i(bVarD));
        if (fVar == null) {
            return null;
        }
        return fVar.b();
    }

    public final boolean b(@os.l eo.b bVar) {
        l0.p(bVar, "callableMemberDescriptor");
        g.f11737a.getClass();
        if (g.f11741e.contains(bVar.getName())) {
            return c(bVar);
        }
        return false;
    }

    public final boolean c(eo.b bVar) {
        g.f11737a.getClass();
        if (nm.h0.W1(g.f11740d, lp.a.e(bVar)) && bVar.h().isEmpty()) {
            return true;
        }
        if (!ao.h.e0(bVar)) {
            return false;
        }
        Collection<? extends eo.b> collectionD = bVar.d();
        l0.o(collectionD, "overriddenDescriptors");
        Collection<? extends eo.b> collection = collectionD;
        if (!collection.isEmpty()) {
            for (eo.b bVar2 : collection) {
                i iVar = f11759a;
                l0.o(bVar2, "it");
                if (iVar.b(bVar2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
