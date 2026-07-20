package ro;

import gq.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.n0;
import nm.c1;
import nm.h0;
import nm.k0;
import nm.z;
import uo.n;
import uo.p;
import uo.q;
import uo.r;
import uo.w;

/* JADX INFO: loaded from: classes3.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final uo.g f14598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<q, Boolean> f14599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<r, Boolean> f14600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Map<dp.f, List<r>> f14601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final Map<dp.f, n> f14602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final Map<dp.f, w> f14603f;

    /* JADX INFO: renamed from: ro.a$a, reason: collision with other inner class name */
    public static final class C0359a extends n0 implements jn.l<r, Boolean> {
        public C0359a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l r rVar) {
            l0.p(rVar, p6.m.f13003a);
            return Boolean.valueOf(a.this.f14599b.invoke(rVar).booleanValue() && !p.c(rVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@os.l uo.g gVar, @os.l jn.l<? super q, Boolean> lVar) {
        l0.p(gVar, "jClass");
        l0.p(lVar, "memberFilter");
        this.f14598a = gVar;
        this.f14599b = lVar;
        C0359a c0359a = new C0359a();
        this.f14600c = c0359a;
        gq.m mVarP0 = v.p0(h0.A1(gVar.A()), c0359a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : mVarP0) {
            dp.f name = ((r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f14601d = linkedHashMap;
        gq.m mVarP1 = v.p0(h0.A1(this.f14598a.getFields()), this.f14599b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : mVarP1) {
            linkedHashMap2.put(((n) obj2).getName(), obj2);
        }
        this.f14602e = linkedHashMap2;
        Collection<w> collectionM = this.f14598a.m();
        jn.l<q, Boolean> lVar2 = this.f14599b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : collectionM) {
            if (lVar2.invoke((q) obj3).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        int iJ = c1.j(z.b0(arrayList2, 10));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iJ < 16 ? 16 : iJ);
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((w) obj4).getName(), obj4);
        }
        this.f14603f = linkedHashMap3;
    }

    @Override // ro.b
    @os.l
    public Collection<r> a(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        List<r> list = this.f14601d.get(fVar);
        return list == null ? k0.INSTANCE : list;
    }

    @Override // ro.b
    @os.m
    public n b(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return this.f14602e.get(fVar);
    }

    @Override // ro.b
    @os.l
    public Set<dp.f> c() {
        gq.m mVarP0 = v.p0(h0.A1(this.f14598a.A()), this.f14600c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = mVarP0.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // ro.b
    @os.l
    public Set<dp.f> d() {
        return this.f14603f.keySet();
    }

    @Override // ro.b
    @os.l
    public Set<dp.f> e() {
        gq.m mVarP0 = v.p0(h0.A1(this.f14598a.getFields()), this.f14599b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = mVarP0.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((n) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // ro.b
    @os.m
    public w f(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return this.f14603f.get(fVar);
    }
}
