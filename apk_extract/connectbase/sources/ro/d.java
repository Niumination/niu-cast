package ro;

import eo.t0;
import eo.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.d0;
import nm.m0;
import nm.r;
import un.o;
import uo.u;
import wo.p;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements op.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f14605f = {l1.f9319a.n(new g1(l1.d(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final qo.h f14606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final h f14607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final i f14608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final up.i f14609e;

    public static final class a extends n0 implements jn.a<op.h[]> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final op.h[] invoke() {
            Collection<p> collectionValues = d.this.f14607c.G0().values();
            d dVar = d.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                op.h hVarC = dVar.f14606b.f14088a.f14058d.c(dVar.f14607c, (p) it.next());
                if (hVarC != null) {
                    arrayList.add(hVarC);
                }
            }
            Object[] array = dq.a.b(arrayList).toArray(new op.h[0]);
            if (array != null) {
                return (op.h[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public d(@os.l qo.h hVar, @os.l u uVar, @os.l h hVar2) {
        l0.p(hVar, "c");
        l0.p(uVar, "jPackage");
        l0.p(hVar2, "packageFragment");
        this.f14606b = hVar;
        this.f14607c = hVar2;
        this.f14608d = new i(hVar, uVar, hVar2);
        this.f14609e = hVar.f14088a.f14055a.h(new a());
    }

    @Override // op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        g(fVar, bVar);
        i iVar = this.f14608d;
        op.h[] hVarArrL = l();
        Collection<? extends y0> collectionA = iVar.a(fVar, bVar);
        int length = hVarArrL.length;
        int i10 = 0;
        Collection collectionA2 = collectionA;
        while (i10 < length) {
            op.h hVar = hVarArrL[i10];
            i10++;
            collectionA2 = dq.a.a(collectionA2, hVar.a(fVar, bVar));
        }
        return collectionA2 == null ? m0.INSTANCE : collectionA2;
    }

    @Override // op.h
    @os.l
    public Set<dp.f> b() {
        op.h[] hVarArrL = l();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = hVarArrL.length;
        int i10 = 0;
        while (i10 < length) {
            op.h hVar = hVarArrL[i10];
            i10++;
            d0.r0(linkedHashSet, hVar.b());
        }
        linkedHashSet.addAll(this.f14608d.B());
        return linkedHashSet;
    }

    @Override // op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        g(fVar, bVar);
        i iVar = this.f14608d;
        op.h[] hVarArrL = l();
        Collection<? extends t0> collectionC = iVar.c(fVar, bVar);
        int length = hVarArrL.length;
        int i10 = 0;
        Collection collectionA = collectionC;
        while (i10 < length) {
            op.h hVar = hVarArrL[i10];
            i10++;
            collectionA = dq.a.a(collectionA, hVar.c(fVar, bVar));
        }
        return collectionA == null ? m0.INSTANCE : collectionA;
    }

    @Override // op.h
    @os.l
    public Set<dp.f> d() {
        op.h[] hVarArrL = l();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = hVarArrL.length;
        int i10 = 0;
        while (i10 < length) {
            op.h hVar = hVarArrL[i10];
            i10++;
            d0.r0(linkedHashSet, hVar.d());
        }
        linkedHashSet.addAll(this.f14608d.E());
        return linkedHashSet;
    }

    @Override // op.k
    @os.l
    public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        i iVar = this.f14608d;
        op.h[] hVarArrL = l();
        Collection<eo.m> collectionE = iVar.e(dVar, lVar);
        int length = hVarArrL.length;
        int i10 = 0;
        while (i10 < length) {
            op.h hVar = hVarArrL[i10];
            i10++;
            collectionE = dq.a.a(collectionE, hVar.e(dVar, lVar));
        }
        return collectionE == null ? m0.INSTANCE : collectionE;
    }

    @Override // op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        g(fVar, bVar);
        eo.e eVarQ = this.f14608d.f(fVar, bVar);
        if (eVarQ != null) {
            return eVarQ;
        }
        op.h[] hVarArrL = l();
        int length = hVarArrL.length;
        eo.h hVar = null;
        int i10 = 0;
        while (i10 < length) {
            op.h hVar2 = hVarArrL[i10];
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
        lo.a.b(this.f14606b.f14088a.f14068n, bVar, this.f14607c, fVar);
    }

    @Override // op.h
    @os.m
    public Set<dp.f> h() {
        Set<dp.f> setA = op.j.a(r.B5(l()));
        if (setA == null) {
            return null;
        }
        setA.addAll(this.f14608d.y());
        return setA;
    }

    @os.l
    public final i k() {
        return this.f14608d;
    }

    public final op.h[] l() {
        return (op.h[]) up.m.a(this.f14609e, this, f14605f[0]);
    }

    @os.l
    public String toString() {
        return l0.C("scope for ", this.f14607c);
    }
}
