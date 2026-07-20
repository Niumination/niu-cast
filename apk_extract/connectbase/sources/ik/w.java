package ik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final lm.d0 f8198a = lm.f0.b(a.INSTANCE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final lm.d0 f8199b = lm.f0.b(b.INSTANCE);

    public static final class a extends kn.n0 implements jn.a<Map<String, List<? extends i>>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Map<String, List<? extends i>> invoke() {
            fl.o oVar = new fl.o();
            oVar.putAll(w.j(nm.h0.A1(a1.a())));
            return oVar;
        }
    }

    public static final class b extends kn.n0 implements jn.a<Map<i, ? extends List<? extends String>>> {
        public static final b INSTANCE = new b();

        public static final class a extends kn.n0 implements jn.l<lm.t0<? extends String, ? extends i>, lm.t0<? extends i, ? extends String>> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ lm.t0<? extends i, ? extends String> invoke(lm.t0<? extends String, ? extends i> t0Var) {
                return invoke2((lm.t0<String, i>) t0Var);
            }

            @os.l
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final lm.t0<i, String> invoke2(@os.l lm.t0<String, i> t0Var) {
                kn.l0.p(t0Var, "$dstr$first$second");
                return new lm.t0<>(t0Var.component2(), t0Var.component1());
            }
        }

        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Map<i, ? extends List<? extends String>> invoke() {
            return w.j(gq.v.k1(nm.h0.A1(a1.a()), a.INSTANCE));
        }
    }

    @os.l
    public static final i a(@os.l i.c cVar, @os.l String str) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(str, "extension");
        return k(d(i.f7981f, str));
    }

    @os.l
    public static final i b(@os.l i.c cVar, @os.l String str) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(str, "path");
        return k(e(i.f7981f, str));
    }

    @os.l
    public static final List<String> c(@os.l i iVar) {
        kn.l0.p(iVar, "<this>");
        List<String> list = h().get(iVar);
        if (list != null) {
            return list;
        }
        List<String> list2 = h().get(iVar.k());
        return list2 == null ? nm.k0.INSTANCE : list2;
    }

    @os.l
    public static final List<i> d(@os.l i.c cVar, @os.l String str) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(str, "ext");
        for (String strE = fl.t1.e(jq.h0.a4(str, ".")); strE.length() > 0; strE = jq.h0.l5(strE, ".", "")) {
            List<i> list = f().get(strE);
            if (list != null) {
                return list;
            }
        }
        return nm.k0.INSTANCE;
    }

    @os.l
    public static final List<i> e(@os.l i.c cVar, @os.l String str) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(str, "path");
        int iO3 = jq.h0.o3(str, n1.e.f11183c, jq.h0.H3(str, fl.r.b("/\\"), 0, false, 6, null) + 1, false, 4, null);
        if (iO3 == -1) {
            return nm.k0.INSTANCE;
        }
        String strSubstring = str.substring(iO3 + 1);
        kn.l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return d(cVar, strSubstring);
    }

    public static final Map<String, List<i>> f() {
        return (Map) f8198a.getValue();
    }

    public static /* synthetic */ void g() {
    }

    public static final Map<i, List<String>> h() {
        return (Map) f8199b.getValue();
    }

    public static /* synthetic */ void i() {
    }

    @os.l
    public static final <A, B> Map<A, List<B>> j(@os.l gq.m<? extends lm.t0<? extends A, ? extends B>> mVar) {
        kn.l0.p(mVar, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (lm.t0<? extends A, ? extends B> t0Var : mVar) {
            A first = t0Var.getFirst();
            Object objA = linkedHashMap.get(first);
            if (objA == null) {
                objA = v.a(linkedHashMap, first);
            }
            ((List) objA).add(t0Var);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(nm.c1.j(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(nm.z.b0(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(((lm.t0) it.next()).getSecond());
            }
            linkedHashMap2.put(key, arrayList);
        }
        return linkedHashMap2;
    }

    @os.l
    public static final i k(@os.l List<i> list) {
        kn.l0.p(list, "<this>");
        i iVar = (i) nm.h0.G2(list);
        if (iVar == null) {
            i.a.f7985a.getClass();
            iVar = i.a.f7992h;
        }
        return (kn.l0.g(iVar.f7983d, "text") && k.a(iVar) == null) ? k.b(iVar, jq.f.f8800b) : iVar;
    }

    @os.l
    public static final i l(@os.l String str) {
        kn.l0.p(str, "<this>");
        try {
            return i.f7981f.b(str);
        } catch (Throwable th2) {
            throw new IllegalArgumentException(kn.l0.C("Failed to parse ", str), th2);
        }
    }
}
