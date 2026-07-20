package no;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import lm.t0;
import nm.c1;
import nm.d1;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g f11737a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Map<dp.c, dp.f> f11738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final Map<dp.f, List<dp.f>> f11739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Set<dp.c> f11740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final Set<dp.f> f11741e;

    static {
        dp.d dVar = ao.k.a.f607s;
        t0 t0Var = new t0(h.d(dVar, "name"), dp.f.k("name"));
        t0 t0Var2 = new t0(h.d(dVar, "ordinal"), dp.f.k("ordinal"));
        t0 t0Var3 = new t0(h.c(ao.k.a.P, ik.f.b.f7973h), dp.f.k(ik.f.b.f7973h));
        dp.c cVar = ao.k.a.T;
        Map<dp.c, dp.f> mapW = d1.W(t0Var, t0Var2, t0Var3, new t0(h.c(cVar, ik.f.b.f7973h), dp.f.k(ik.f.b.f7973h)), new t0(h.d(ao.k.a.f583g, "length"), dp.f.k("length")), new t0(h.c(cVar, "keys"), dp.f.k("keySet")), new t0(h.c(cVar, "values"), dp.f.k("values")), new t0(h.c(cVar, cb.b.c.f1405l), dp.f.k("entrySet")));
        f11738b = mapW;
        Set<Map.Entry<dp.c, dp.f>> setEntrySet = mapW.entrySet();
        ArrayList<t0> arrayList = new ArrayList(nm.z.b0(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new t0(((dp.c) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (t0 t0Var4 : arrayList) {
            dp.f fVar = (dp.f) t0Var4.getSecond();
            Object arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            ((List) arrayList2).add((dp.f) t0Var4.getFirst());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(c1.j(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), nm.h0.a2((Iterable) entry2.getValue()));
        }
        f11739c = linkedHashMap2;
        Set<dp.c> setKeySet = f11738b.keySet();
        f11740d = setKeySet;
        ArrayList arrayList3 = new ArrayList(nm.z.b0(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((dp.c) it2.next()).g());
        }
        f11741e = nm.h0.a6(arrayList3);
    }

    @os.l
    public final Map<dp.c, dp.f> a() {
        return f11738b;
    }

    @os.l
    public final List<dp.f> b(@os.l dp.f fVar) {
        l0.p(fVar, "name1");
        List<dp.f> list = f11739c.get(fVar);
        return list == null ? k0.INSTANCE : list;
    }

    @os.l
    public final Set<dp.c> c() {
        return f11740d;
    }

    @os.l
    public final Set<dp.f> d() {
        return f11741e;
    }
}
