package op;

import eo.t0;
import eo.y0;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements h {
    @Override // op.h, op.k
    @os.l
    public Collection<? extends y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return k0.INSTANCE;
    }

    @Override // op.h
    @os.l
    public Set<dp.f> b() {
        Collection<eo.m> collectionE = e(d.f12387v, eq.d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionE) {
            if (obj instanceof y0) {
                dp.f name = ((y0) obj).getName();
                l0.o(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // op.h
    @os.l
    public Collection<? extends t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return k0.INSTANCE;
    }

    @Override // op.h
    @os.l
    public Set<dp.f> d() {
        Collection<eo.m> collectionE = e(d.f12388w, eq.d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionE) {
            if (obj instanceof y0) {
                dp.f name = ((y0) obj).getName();
                l0.o(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // op.k
    @os.l
    public Collection<eo.m> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        return k0.INSTANCE;
    }

    @Override // op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return null;
    }

    @Override // op.k
    public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
        h.b.a(this, fVar, bVar);
    }

    @Override // op.h
    @os.m
    public Set<dp.f> h() {
        return null;
    }
}
