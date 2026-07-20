package op;

import eo.t0;
import eo.y0;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kn.l0;
import kn.w;
import nm.d0;
import nm.k0;
import nm.m0;
import nm.r;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f12362d = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f12363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final h[] f12364c;

    public static final class a {
        public a() {
        }

        @os.l
        public final h a(@os.l String str, @os.l Iterable<? extends h> iterable) {
            l0.p(str, "debugName");
            l0.p(iterable, "scopes");
            eq.e eVar = new eq.e();
            for (h hVar : iterable) {
                if (hVar != h.c.f12406b) {
                    if (hVar instanceof b) {
                        d0.s0(eVar, ((b) hVar).f12364c);
                    } else {
                        eVar.add(hVar);
                    }
                }
            }
            return b(str, eVar);
        }

        @os.l
        public final h b(@os.l String str, @os.l List<? extends h> list) {
            l0.p(str, "debugName");
            l0.p(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return h.c.f12406b;
            }
            if (size == 1) {
                return list.get(0);
            }
            Object[] array = list.toArray(new h[0]);
            if (array != null) {
                return new b(str, (h[]) array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ b(String str, h[] hVarArr, w wVar) {
        this(str, hVarArr);
    }

    @Override // op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        h[] hVarArr = this.f12364c;
        int length = hVarArr.length;
        if (length == 0) {
            return k0.INSTANCE;
        }
        int i10 = 0;
        if (length == 1) {
            return hVarArr[0].a(fVar, bVar);
        }
        int length2 = hVarArr.length;
        Collection<y0> collectionA = null;
        while (i10 < length2) {
            h hVar = hVarArr[i10];
            i10++;
            collectionA = dq.a.a(collectionA, hVar.a(fVar, bVar));
        }
        return collectionA == null ? m0.INSTANCE : collectionA;
    }

    @Override // op.h
    @os.l
    public Set<dp.f> b() {
        h[] hVarArr = this.f12364c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = hVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            h hVar = hVarArr[i10];
            i10++;
            d0.r0(linkedHashSet, hVar.b());
        }
        return linkedHashSet;
    }

    @Override // op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        h[] hVarArr = this.f12364c;
        int length = hVarArr.length;
        if (length == 0) {
            return k0.INSTANCE;
        }
        int i10 = 0;
        if (length == 1) {
            return hVarArr[0].c(fVar, bVar);
        }
        int length2 = hVarArr.length;
        Collection<t0> collectionA = null;
        while (i10 < length2) {
            h hVar = hVarArr[i10];
            i10++;
            collectionA = dq.a.a(collectionA, hVar.c(fVar, bVar));
        }
        return collectionA == null ? m0.INSTANCE : collectionA;
    }

    @Override // op.h
    @os.l
    public Set<dp.f> d() {
        h[] hVarArr = this.f12364c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = hVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            h hVar = hVarArr[i10];
            i10++;
            d0.r0(linkedHashSet, hVar.d());
        }
        return linkedHashSet;
    }

    @Override // op.k
    @os.l
    public Collection<eo.m> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        h[] hVarArr = this.f12364c;
        int length = hVarArr.length;
        if (length == 0) {
            return k0.INSTANCE;
        }
        int i10 = 0;
        if (length == 1) {
            return hVarArr[0].e(dVar, lVar);
        }
        int length2 = hVarArr.length;
        Collection<eo.m> collectionA = null;
        while (i10 < length2) {
            h hVar = hVarArr[i10];
            i10++;
            collectionA = dq.a.a(collectionA, hVar.e(dVar, lVar));
        }
        return collectionA == null ? m0.INSTANCE : collectionA;
    }

    @Override // op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        h[] hVarArr = this.f12364c;
        int length = hVarArr.length;
        eo.h hVar = null;
        int i10 = 0;
        while (i10 < length) {
            h hVar2 = hVarArr[i10];
            i10++;
            eo.h hVarF = hVar2.f(fVar, bVar);
            if (hVarF != null) {
                if (!(hVarF instanceof eo.i) || !((eo.i) hVarF).i0()) {
                    return hVarF;
                }
                if (hVar == null) {
                    hVar = hVarF;
                }
            }
        }
        return hVar;
    }

    @Override // op.k
    public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        h[] hVarArr = this.f12364c;
        int length = hVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            h hVar = hVarArr[i10];
            i10++;
            hVar.g(fVar, bVar);
        }
    }

    @Override // op.h
    @os.m
    public Set<dp.f> h() {
        return j.a(r.B5(this.f12364c));
    }

    @os.l
    public String toString() {
        return this.f12363b;
    }

    public b(String str, h[] hVarArr) {
        this.f12363b = str;
        this.f12364c = hVarArr;
    }
}
