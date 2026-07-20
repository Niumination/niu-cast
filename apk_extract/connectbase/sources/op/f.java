package op;

import eo.d1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h f12401b;

    public f(@os.l h hVar) {
        l0.p(hVar, "workerScope");
        this.f12401b = hVar;
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> b() {
        return this.f12401b.b();
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> d() {
        return this.f12401b.d();
    }

    @Override // op.i, op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        eo.h hVarF = this.f12401b.f(fVar, bVar);
        if (hVarF == null) {
            return null;
        }
        eo.e eVar = hVarF instanceof eo.e ? (eo.e) hVarF : null;
        if (eVar != null) {
            return eVar;
        }
        if (hVarF instanceof d1) {
            return (d1) hVarF;
        }
        return null;
    }

    @Override // op.i, op.k
    public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        this.f12401b.g(fVar, bVar);
    }

    @Override // op.i, op.h
    @os.m
    public Set<dp.f> h() {
        return this.f12401b.h();
    }

    @Override // op.i, op.k
    @os.l
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public List<eo.h> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        d.f12368c.getClass();
        d dVarN = dVar.n(d.f12377l);
        if (dVarN == null) {
            return k0.INSTANCE;
        }
        Collection<eo.m> collectionE = this.f12401b.e(dVarN, lVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionE) {
            if (obj instanceof eo.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @os.l
    public String toString() {
        return l0.C("Classes from ", this.f12401b);
    }
}
