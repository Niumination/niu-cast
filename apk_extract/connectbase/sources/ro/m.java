package ro;

import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.x;
import nm.z;
import uo.y;
import vp.f0;
import vp.g0;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends ho.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final qo.h f14678v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final y f14679w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@os.l qo.h hVar, @os.l y yVar, int i10, @os.l eo.m mVar) {
        super(hVar.f14088a.f14055a, mVar, new qo.e(hVar, yVar, false, 4, null), yVar.getName(), o1.INVARIANT, false, i10, z0.f4654a, hVar.f14088a.f14067m);
        l0.p(hVar, "c");
        l0.p(yVar, "javaTypeParameter");
        l0.p(mVar, "containingDeclaration");
        this.f14678v = hVar;
        this.f14679w = yVar;
    }

    @Override // ho.e
    @os.l
    public List<f0> B0(@os.l List<? extends f0> list) {
        l0.p(list, "bounds");
        qo.h hVar = this.f14678v;
        return hVar.f14088a.f14072r.g(this, list, hVar);
    }

    @Override // ho.e
    public void E0(@os.l f0 f0Var) {
        l0.p(f0Var, y0.a.f8215h);
    }

    @Override // ho.e
    @os.l
    public List<f0> F0() {
        return G0();
    }

    public final List<f0> G0() {
        Collection<uo.j> upperBounds = this.f14679w.getUpperBounds();
        if (upperBounds.isEmpty()) {
            n0 n0VarI = this.f14678v.f14088a.f14069o.n().i();
            l0.o(n0VarI, "c.module.builtIns.anyType");
            n0 n0VarI2 = this.f14678v.f14088a.f14069o.n().I();
            l0.o(n0VarI2, "c.module.builtIns.nullableAnyType");
            return x.k(g0.d(n0VarI, n0VarI2));
        }
        Collection<uo.j> collection = upperBounds;
        ArrayList arrayList = new ArrayList(z.b0(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14678v.f14092e.o((uo.j) it.next(), so.d.d(oo.k.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }
}
