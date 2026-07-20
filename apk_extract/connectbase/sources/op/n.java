package op;

import eo.t0;
import eo.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.w;
import nm.h0;
import nm.z;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends op.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f12414d = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f12415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final h f12416c;

    public static final class a {
        public a() {
        }

        @in.n
        @os.l
        public final h a(@os.l String str, @os.l Collection<? extends f0> collection) {
            l0.p(str, "message");
            l0.p(collection, "types");
            Collection<? extends f0> collection2 = collection;
            ArrayList arrayList = new ArrayList(z.b0(collection2, 10));
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                arrayList.add(((f0) it.next()).o());
            }
            eq.e<h> eVarB = dq.a.b(arrayList);
            h hVarB = op.b.f12362d.b(str, eVarB);
            return eVarB.size() <= 1 ? hVarB : new n(str, hVarB);
        }

        public a(w wVar) {
        }
    }

    public static final class b extends n0 implements jn.l<eo.a, eo.a> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final eo.a invoke(@os.l eo.a aVar) {
            l0.p(aVar, "$this$selectMostSpecificInEachOverridableGroup");
            return aVar;
        }
    }

    public static final class c extends n0 implements jn.l<y0, eo.a> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final eo.a invoke(@os.l y0 y0Var) {
            l0.p(y0Var, "$this$selectMostSpecificInEachOverridableGroup");
            return y0Var;
        }
    }

    public static final class d extends n0 implements jn.l<t0, eo.a> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final eo.a invoke(@os.l t0 t0Var) {
            l0.p(t0Var, "$this$selectMostSpecificInEachOverridableGroup");
            return t0Var;
        }
    }

    public /* synthetic */ n(String str, h hVar, w wVar) {
        this(str, hVar);
    }

    @in.n
    @os.l
    public static final h k(@os.l String str, @os.l Collection<? extends f0> collection) {
        return f12414d.a(str, collection);
    }

    @Override // op.a, op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return hp.l.a(super.a(fVar, bVar), c.INSTANCE);
    }

    @Override // op.a, op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return hp.l.a(super.c(fVar, bVar), d.INSTANCE);
    }

    @Override // op.a, op.k
    @os.l
    public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        Collection<eo.m> collectionE = super.e(dVar, lVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionE) {
            if (((eo.m) obj) instanceof eo.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        lm.t0 t0Var = new lm.t0(arrayList, arrayList2);
        List list = (List) t0Var.component1();
        return h0.E4(hp.l.a(list, b.INSTANCE), (List) t0Var.component2());
    }

    @Override // op.a
    @os.l
    public h j() {
        return this.f12416c;
    }

    public n(String str, h hVar) {
        this.f12415b = str;
        this.f12416c = hVar;
    }
}
