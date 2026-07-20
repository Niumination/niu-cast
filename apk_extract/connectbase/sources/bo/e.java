package bo;

import bq.j;
import dp.f;
import eo.e0;
import eo.e1;
import eo.h1;
import eo.m;
import eo.t;
import eo.w0;
import eo.y;
import eo.z0;
import fo.g;
import ho.g0;
import ho.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kn.l0;
import kn.w;
import nm.h0;
import nm.k0;
import nm.s0;
import nm.z;
import os.l;
import vp.f0;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends g0 {

    @l
    public static final a V = new a();

    public static final class a {
        public a() {
        }

        @l
        public final e a(@l b bVar, boolean z10) {
            l0.p(bVar, "functionClass");
            List<e1> list = bVar.f996x;
            e eVar = new e(bVar, null, eo.b.a.DECLARATION, z10);
            w0 w0VarD0 = bVar.D0();
            k0 k0Var = k0.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((e1) obj).m() != o1.IN_VARIANCE) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<s0> iterableH6 = h0.h6(arrayList);
            ArrayList arrayList2 = new ArrayList(z.b0(iterableH6, 10));
            for (s0 s0Var : iterableH6) {
                arrayList2.add(e.V.b(eVar, s0Var.f11691a, (e1) s0Var.f11692b));
            }
            eVar.L0(null, w0VarD0, k0Var, arrayList2, ((e1) h0.p3(list)).q(), e0.ABSTRACT, t.f4633e);
            eVar.O = true;
            return eVar;
        }

        public final h1 b(e eVar, int i10, e1 e1Var) {
            String lowerCase;
            String strB = e1Var.getName().b();
            l0.o(strB, "typeParameter.name.asString()");
            if (l0.g(strB, "T")) {
                lowerCase = "instance";
            } else if (l0.g(strB, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = strB.toLowerCase(Locale.ROOT);
                l0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            g.f6167h.getClass();
            g gVar = g.a.f6169b;
            f fVarK = f.k(lowerCase);
            l0.o(fVarK, "identifier(name)");
            n0 n0VarQ = e1Var.q();
            l0.o(n0VarQ, "typeParameter.defaultType");
            z0 z0Var = z0.f4654a;
            l0.o(z0Var, "NO_SOURCE");
            return new ho.l0(eVar, null, i10, gVar, fVarK, n0VarQ, false, false, false, null, z0Var);
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ e(m mVar, e eVar, eo.b.a aVar, boolean z10, w wVar) {
        this(mVar, eVar, aVar, z10);
    }

    @Override // ho.p, eo.y
    public boolean D() {
        return false;
    }

    @Override // ho.g0, ho.p
    @l
    public p F0(@l m mVar, @os.m y yVar, @l eo.b.a aVar, @os.m f fVar, @l g gVar, @l z0 z0Var) {
        l0.p(mVar, "newOwner");
        l0.p(aVar, "kind");
        l0.p(gVar, "annotations");
        l0.p(z0Var, "source");
        return new e(mVar, (e) yVar, aVar, this.M);
    }

    @Override // ho.p
    @os.m
    public y G0(@l p.c cVar) {
        l0.p(cVar, "configuration");
        e eVar = (e) super.G0(cVar);
        if (eVar == null) {
            return null;
        }
        List<h1> listH = eVar.h();
        l0.o(listH, "substituted.valueParameters");
        List<h1> list = listH;
        if ((list instanceof Collection) && list.isEmpty()) {
            return eVar;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f0 type = ((h1) it.next()).getType();
            l0.o(type, "it.type");
            if (ao.g.c(type) != null) {
                List<h1> listH2 = eVar.h();
                l0.o(listH2, "substituted.valueParameters");
                List<h1> list2 = listH2;
                ArrayList arrayList = new ArrayList(z.b0(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    f0 type2 = ((h1) it2.next()).getType();
                    l0.o(type2, "it.type");
                    arrayList.add(ao.g.c(type2));
                }
                return eVar.j1(arrayList);
            }
        }
        return eVar;
    }

    @Override // ho.p, eo.d0
    public boolean isExternal() {
        return false;
    }

    @Override // ho.p, eo.y
    public boolean isInline() {
        return false;
    }

    public final y j1(List<f> list) {
        f fVar;
        int size = h().size() - list.size();
        boolean z10 = true;
        List<h1> listH = h();
        l0.o(listH, "valueParameters");
        List<h1> list2 = listH;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        for (h1 h1Var : list2) {
            f name = h1Var.getName();
            l0.o(name, "it.name");
            int iF = h1Var.f();
            int i10 = iF - size;
            if (i10 >= 0 && (fVar = list.get(i10)) != null) {
                name = fVar;
            }
            arrayList.add(h1Var.F(this, name, iF));
        }
        p.c cVarM0 = M0(vp.h1.f17703b);
        List<f> list3 = list;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            z10 = false;
        } else {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((f) it.next()) == null) {
                }
            }
            z10 = false;
        }
        p.c cVarE = cVarM0.G(z10).c(arrayList).e(a());
        l0.o(cVarE, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        y yVarG0 = super.G0(cVarE);
        l0.m(yVarG0);
        l0.o(yVarG0, "super.doSubstitute(copyConfiguration)!!");
        return yVarG0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(m mVar, e eVar, eo.b.a aVar, boolean z10) {
        super(mVar, eVar, g.a.f6169b, j.f1072h, aVar, z0.f4654a);
        g.f6167h.getClass();
        this.f7405w = true;
        this.M = z10;
        this.N = false;
    }
}
