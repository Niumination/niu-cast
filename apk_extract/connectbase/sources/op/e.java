package op;

import eo.t0;
import eo.y;
import eo.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.d0;
import nm.h0;
import nm.k0;
import un.o;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f12396d = {l1.f9319a.n(new g1(l1.d(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final eo.e f12397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final up.i f12398c;

    public static final class a extends n0 implements jn.a<List<? extends eo.m>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<? extends eo.m> invoke() {
            List<y> listJ = e.this.j();
            return h0.E4(listJ, e.this.k(listJ));
        }
    }

    public static final class b extends hp.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList<eo.m> f12399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f12400b;

        public b(ArrayList<eo.m> arrayList, e eVar) {
            this.f12399a = arrayList;
            this.f12400b = eVar;
        }

        @Override // hp.i
        public void a(@os.l eo.b bVar) {
            l0.p(bVar, "fakeOverride");
            hp.j.L(bVar, null);
            this.f12399a.add(bVar);
        }

        @Override // hp.h
        public void e(@os.l eo.b bVar, @os.l eo.b bVar2) {
            l0.p(bVar, "fromSuper");
            l0.p(bVar2, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f12400b.f12397b + ": " + bVar + " vs " + bVar2).toString());
        }
    }

    public e(@os.l up.n nVar, @os.l eo.e eVar) {
        l0.p(nVar, "storageManager");
        l0.p(eVar, "containingClass");
        this.f12397b = eVar;
        this.f12398c = nVar.h(new a());
    }

    @Override // op.i, op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        List<eo.m> listL = l();
        eq.e eVar = new eq.e();
        for (Object obj : listL) {
            if ((obj instanceof y0) && l0.g(((y0) obj).getName(), fVar)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }

    @Override // op.i, op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        List<eo.m> listL = l();
        eq.e eVar = new eq.e();
        for (Object obj : listL) {
            if ((obj instanceof t0) && l0.g(((t0) obj).getName(), fVar)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }

    @Override // op.i, op.k
    @os.l
    public Collection<eo.m> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        return !dVar.a(d.f12381p.f12393b) ? k0.INSTANCE : l();
    }

    @os.l
    public abstract List<y> j();

    /* JADX WARN: Multi-variable type inference failed */
    public final List<eo.m> k(List<? extends y> list) {
        Collection<? extends eo.b> arrayList;
        ArrayList arrayList2 = new ArrayList(3);
        Collection<f0> collectionA = this.f12397b.i().a();
        l0.o(collectionA, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            d0.r0(arrayList3, k.a.a(((f0) it.next()).o(), null, null, 3, null));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            if (obj instanceof eo.b) {
                arrayList4.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList4) {
            dp.f name = ((eo.b) obj2).getName();
            Object arrayList5 = linkedHashMap.get(name);
            if (arrayList5 == null) {
                arrayList5 = new ArrayList();
                linkedHashMap.put(name, arrayList5);
            }
            ((List) arrayList5).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            dp.f fVar = (dp.f) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((eo.b) obj3) instanceof y);
                Object arrayList6 = linkedHashMap2.get(boolValueOf);
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList6);
                }
                ((List) arrayList6).add(obj3);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                hp.j jVar = hp.j.f7490d;
                List list4 = list3;
                if (zBooleanValue) {
                    arrayList = new ArrayList<>();
                    for (Object obj4 : list) {
                        if (l0.g(((y) obj4).getName(), fVar)) {
                            arrayList.add(obj4);
                        }
                    }
                } else {
                    arrayList = k0.INSTANCE;
                }
                jVar.w(fVar, list4, arrayList, this.f12397b, new b(arrayList2, this));
            }
        }
        return eq.a.c(arrayList2);
    }

    public final List<eo.m> l() {
        return (List) up.m.a(this.f12398c, this, f12396d[0]);
    }

    @os.l
    public final eo.e m() {
        return this.f12397b;
    }
}
