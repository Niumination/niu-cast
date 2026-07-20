package eo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 {

    public static final class a extends kn.n0 implements jn.l<m, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l m mVar) {
            kn.l0.p(mVar, "it");
            return Boolean.valueOf(mVar instanceof eo.a);
        }
    }

    public static final class b extends kn.n0 implements jn.l<m, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l m mVar) {
            kn.l0.p(mVar, "it");
            return Boolean.valueOf(!(mVar instanceof l));
        }
    }

    public static final class c extends kn.n0 implements jn.l<m, gq.m<? extends e1>> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final gq.m<e1> invoke(@os.l m mVar) {
            kn.l0.p(mVar, "it");
            List<e1> typeParameters = ((eo.a) mVar).getTypeParameters();
            kn.l0.o(typeParameters, "it as CallableDescriptor).typeParameters");
            return nm.h0.A1(typeParameters);
        }
    }

    @os.m
    public static final r0 a(@os.l vp.f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        h hVarD = f0Var.G0().d();
        return b(f0Var, hVarD instanceof i ? (i) hVarD : null, 0);
    }

    public static final r0 b(vp.f0 f0Var, i iVar, int i10) {
        if (iVar == null || vp.x.r(iVar)) {
            return null;
        }
        int size = iVar.r().size() + i10;
        if (iVar.l()) {
            List<vp.c1> listSubList = f0Var.F0().subList(i10, size);
            m mVarB = iVar.b();
            return new r0(iVar, listSubList, b(f0Var, mVarB instanceof i ? (i) mVarB : null, size));
        }
        if (size != f0Var.F0().size()) {
            hp.d.E(iVar);
        }
        return new r0(iVar, f0Var.F0().subList(i10, f0Var.F0().size()), null);
    }

    public static final eo.c c(e1 e1Var, m mVar, int i10) {
        return new eo.c(e1Var, mVar, i10);
    }

    @os.l
    public static final List<e1> d(@os.l i iVar) {
        m next;
        kn.l0.p(iVar, "<this>");
        List<e1> listR = iVar.r();
        kn.l0.o(listR, "declaredTypeParameters");
        if (!iVar.l() && !(iVar.b() instanceof eo.a)) {
            return listR;
        }
        List listC3 = gq.v.c3(gq.v.H0(gq.v.p0(gq.v.Z2(lp.a.m(iVar), a.INSTANCE), b.INSTANCE), c.INSTANCE));
        Iterator<m> it = lp.a.m(iVar).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof e));
        e eVar = (e) next;
        List<e1> parameters = eVar != null ? eVar.i().getParameters() : null;
        if (parameters == null) {
            parameters = nm.k0.INSTANCE;
        }
        if (listC3.isEmpty() && parameters.isEmpty()) {
            List<e1> listR2 = iVar.r();
            kn.l0.o(listR2, "declaredTypeParameters");
            return listR2;
        }
        List<e1> listE4 = nm.h0.E4(listC3, parameters);
        ArrayList arrayList = new ArrayList(nm.z.b0(listE4, 10));
        for (e1 e1Var : listE4) {
            kn.l0.o(e1Var, "it");
            arrayList.add(new eo.c(e1Var, iVar, listR.size()));
        }
        return nm.h0.E4(listR, arrayList);
    }
}
