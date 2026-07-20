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
import nm.o1;
import nm.p1;

/* JADX INFO: loaded from: classes3.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f11742a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final List<a.C0302a> f11743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final List<String> f11744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final List<String> f11745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final Map<a.C0302a, c> f11746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final Map<String, c> f11747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final Set<dp.f> f11748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final Set<String> f11749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final a.C0302a f11750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final Map<a.C0302a, dp.f> f11751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final Map<String, dp.f> f11752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public static final List<dp.f> f11753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public static final Map<dp.f, List<dp.f>> f11754m;

    public static final class a {

        /* JADX INFO: renamed from: no.g0$a$a, reason: collision with other inner class name */
        public static final class C0302a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final dp.f f11755a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @os.l
            public final String f11756b;

            public C0302a(@os.l dp.f fVar, @os.l String str) {
                l0.p(fVar, "name");
                l0.p(str, "signature");
                this.f11755a = fVar;
                this.f11756b = str;
            }

            @os.l
            public final dp.f a() {
                return this.f11755a;
            }

            @os.l
            public final String b() {
                return this.f11756b;
            }

            public boolean equals(@os.m Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0302a)) {
                    return false;
                }
                C0302a c0302a = (C0302a) obj;
                return l0.g(this.f11755a, c0302a.f11755a) && l0.g(this.f11756b, c0302a.f11756b);
            }

            public int hashCode() {
                return this.f11756b.hashCode() + (this.f11755a.hashCode() * 31);
            }

            @os.l
            public String toString() {
                StringBuilder sb2 = new StringBuilder("NameAndSignature(name=");
                sb2.append(this.f11755a);
                sb2.append(", signature=");
                return l.a.a(sb2, this.f11756b, ')');
            }
        }

        public a() {
        }

        @os.l
        public final List<dp.f> b(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            List<dp.f> list = (List) g0.f11754m.get(fVar);
            return list == null ? k0.INSTANCE : list;
        }

        @os.l
        public final List<String> c() {
            return g0.f11744c;
        }

        @os.l
        public final Set<dp.f> d() {
            return g0.f11748g;
        }

        @os.l
        public final Set<String> e() {
            return g0.f11749h;
        }

        @os.l
        public final Map<dp.f, List<dp.f>> f() {
            return g0.f11754m;
        }

        @os.l
        public final List<dp.f> g() {
            return g0.f11753l;
        }

        @os.l
        public final C0302a h() {
            return g0.f11750i;
        }

        @os.l
        public final Map<String, c> i() {
            return g0.f11747f;
        }

        @os.l
        public final Map<String, dp.f> j() {
            return g0.f11752k;
        }

        public final boolean k(@os.l dp.f fVar) {
            l0.p(fVar, "<this>");
            return g0.f11753l.contains(fVar);
        }

        @os.l
        public final b l(@os.l String str) {
            l0.p(str, "builtinSignature");
            if (g0.f11744c.contains(str)) {
                return b.ONE_COLLECTION_PARAMETER;
            }
            return ((c) d1.K(g0.f11747f, str)) == c.NULL ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
        }

        public final C0302a m(String str, String str2, String str3, String str4) {
            dp.f fVarK = dp.f.k(str2);
            l0.o(fVarK, "identifier(name)");
            return new C0302a(fVarK, wo.w.f19826a.k(str, str2 + '(' + str3 + ')' + str4));
        }

        public a(kn.w wVar) {
        }
    }

    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final boolean isObjectReplacedWithTypeParameter;

        @os.m
        private final String valueParametersSignature;

        b(String str, boolean z10) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z10;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {

        @os.m
        private final Object defaultValue;
        public static final c NULL = new c("NULL", 0, null);
        public static final c INDEX = new c("INDEX", 1, -1);
        public static final c FALSE = new c("FALSE", 2, Boolean.FALSE);
        public static final c MAP_GET_OR_DEFAULT = new a("MAP_GET_OR_DEFAULT", 3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ c[] f11758a = a();

        public static final class a extends c {
            /* JADX WARN: Illegal instructions before constructor call */
            public a(String str, int i10) {
                kn.w wVar = null;
                super(str, i10, wVar, wVar);
            }
        }

        public /* synthetic */ c(String str, int i10, Object obj, kn.w wVar) {
            this(str, i10, obj);
        }

        public static final /* synthetic */ c[] a() {
            return new c[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f11758a.clone();
        }

        public c(String str, int i10, Object obj) {
            super(str, i10);
            this.defaultValue = obj;
        }
    }

    static {
        Set<String> setU = o1.u("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(nm.z.b0(setU, 10));
        for (String str : setU) {
            a aVar = f11742a;
            String desc = mp.e.BOOLEAN.getDesc();
            l0.o(desc, "BOOLEAN.desc");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f11743b = arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(nm.z.b0(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((a.C0302a) it.next()).f11756b);
        }
        f11744c = arrayList3;
        List<a.C0302a> list = f11743b;
        ArrayList arrayList4 = new ArrayList(nm.z.b0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((a.C0302a) it2.next()).f11755a.b());
        }
        f11745d = arrayList4;
        wo.w wVar = wo.w.f19826a;
        a aVar2 = f11742a;
        String strI = wVar.i("Collection");
        mp.e eVar = mp.e.BOOLEAN;
        String desc2 = eVar.getDesc();
        l0.o(desc2, "BOOLEAN.desc");
        a.C0302a c0302aM = aVar2.m(strI, "contains", "Ljava/lang/Object;", desc2);
        c cVar = c.FALSE;
        t0 t0Var = new t0(c0302aM, cVar);
        String strI2 = wVar.i("Collection");
        String desc3 = eVar.getDesc();
        l0.o(desc3, "BOOLEAN.desc");
        t0 t0Var2 = new t0(aVar2.m(strI2, "remove", "Ljava/lang/Object;", desc3), cVar);
        String strI3 = wVar.i("Map");
        String desc4 = eVar.getDesc();
        l0.o(desc4, "BOOLEAN.desc");
        t0 t0Var3 = new t0(aVar2.m(strI3, "containsKey", "Ljava/lang/Object;", desc4), cVar);
        String strI4 = wVar.i("Map");
        String desc5 = eVar.getDesc();
        l0.o(desc5, "BOOLEAN.desc");
        t0 t0Var4 = new t0(aVar2.m(strI4, "containsValue", "Ljava/lang/Object;", desc5), cVar);
        String strI5 = wVar.i("Map");
        String desc6 = eVar.getDesc();
        l0.o(desc6, "BOOLEAN.desc");
        t0 t0Var5 = new t0(aVar2.m(strI5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), cVar);
        t0 t0Var6 = new t0(aVar2.m(wVar.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.MAP_GET_OR_DEFAULT);
        a.C0302a c0302aM2 = aVar2.m(wVar.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.NULL;
        t0 t0Var7 = new t0(c0302aM2, cVar2);
        t0 t0Var8 = new t0(aVar2.m(wVar.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2);
        String strI6 = wVar.i("List");
        mp.e eVar2 = mp.e.INT;
        String desc7 = eVar2.getDesc();
        l0.o(desc7, "INT.desc");
        a.C0302a c0302aM3 = aVar2.m(strI6, "indexOf", "Ljava/lang/Object;", desc7);
        c cVar3 = c.INDEX;
        t0 t0Var9 = new t0(c0302aM3, cVar3);
        String strI7 = wVar.i("List");
        String desc8 = eVar2.getDesc();
        l0.o(desc8, "INT.desc");
        Map<a.C0302a, c> mapW = d1.W(t0Var, t0Var2, t0Var3, t0Var4, t0Var5, t0Var6, t0Var7, t0Var8, t0Var9, new t0(aVar2.m(strI7, "lastIndexOf", "Ljava/lang/Object;", desc8), cVar3));
        f11746e = mapW;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c1.j(mapW.size()));
        Iterator<T> it3 = mapW.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0302a) entry.getKey()).f11756b, entry.getValue());
        }
        f11747f = linkedHashMap;
        Set setD = p1.D(f11746e.keySet(), f11743b);
        ArrayList arrayList5 = new ArrayList(nm.z.b0(setD, 10));
        Iterator it4 = setD.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((a.C0302a) it4.next()).f11755a);
        }
        f11748g = nm.h0.a6(arrayList5);
        ArrayList arrayList6 = new ArrayList(nm.z.b0(setD, 10));
        Iterator it5 = setD.iterator();
        while (it5.hasNext()) {
            arrayList6.add(((a.C0302a) it5.next()).f11756b);
        }
        f11749h = nm.h0.a6(arrayList6);
        a aVar3 = f11742a;
        mp.e eVar3 = mp.e.INT;
        String desc9 = eVar3.getDesc();
        l0.o(desc9, "INT.desc");
        a.C0302a c0302aM4 = aVar3.m("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        f11750i = c0302aM4;
        wo.w wVar2 = wo.w.f19826a;
        String strH = wVar2.h("Number");
        String desc10 = mp.e.BYTE.getDesc();
        l0.o(desc10, "BYTE.desc");
        t0 t0Var10 = new t0(aVar3.m(strH, "toByte", "", desc10), dp.f.k("byteValue"));
        String strH2 = wVar2.h("Number");
        String desc11 = mp.e.SHORT.getDesc();
        l0.o(desc11, "SHORT.desc");
        t0 t0Var11 = new t0(aVar3.m(strH2, "toShort", "", desc11), dp.f.k("shortValue"));
        String strH3 = wVar2.h("Number");
        String desc12 = eVar3.getDesc();
        l0.o(desc12, "INT.desc");
        t0 t0Var12 = new t0(aVar3.m(strH3, "toInt", "", desc12), dp.f.k("intValue"));
        String strH4 = wVar2.h("Number");
        String desc13 = mp.e.LONG.getDesc();
        l0.o(desc13, "LONG.desc");
        t0 t0Var13 = new t0(aVar3.m(strH4, "toLong", "", desc13), dp.f.k("longValue"));
        String strH5 = wVar2.h("Number");
        String desc14 = mp.e.FLOAT.getDesc();
        l0.o(desc14, "FLOAT.desc");
        t0 t0Var14 = new t0(aVar3.m(strH5, "toFloat", "", desc14), dp.f.k("floatValue"));
        String strH6 = wVar2.h("Number");
        String desc15 = mp.e.DOUBLE.getDesc();
        l0.o(desc15, "DOUBLE.desc");
        t0 t0Var15 = new t0(aVar3.m(strH6, "toDouble", "", desc15), dp.f.k("doubleValue"));
        t0 t0Var16 = new t0(c0302aM4, dp.f.k("remove"));
        String strH7 = wVar2.h("CharSequence");
        String desc16 = eVar3.getDesc();
        l0.o(desc16, "INT.desc");
        String desc17 = mp.e.CHAR.getDesc();
        l0.o(desc17, "CHAR.desc");
        Map<a.C0302a, dp.f> mapW2 = d1.W(t0Var10, t0Var11, t0Var12, t0Var13, t0Var14, t0Var15, t0Var16, new t0(aVar3.m(strH7, "get", desc16, desc17), dp.f.k("charAt")));
        f11751j = mapW2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(c1.j(mapW2.size()));
        Iterator<T> it6 = mapW2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0302a) entry2.getKey()).f11756b, entry2.getValue());
        }
        f11752k = linkedHashMap2;
        Set<a.C0302a> setKeySet = f11751j.keySet();
        ArrayList arrayList7 = new ArrayList(nm.z.b0(setKeySet, 10));
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            arrayList7.add(((a.C0302a) it7.next()).f11755a);
        }
        f11753l = arrayList7;
        Set<Map.Entry<a.C0302a, dp.f>> setEntrySet = f11751j.entrySet();
        ArrayList<t0> arrayList8 = new ArrayList(nm.z.b0(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList8.add(new t0(((a.C0302a) entry3.getKey()).f11755a, entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (t0 t0Var17 : arrayList8) {
            dp.f fVar = (dp.f) t0Var17.getSecond();
            Object arrayList9 = linkedHashMap3.get(fVar);
            if (arrayList9 == null) {
                arrayList9 = new ArrayList();
                linkedHashMap3.put(fVar, arrayList9);
            }
            ((List) arrayList9).add((dp.f) t0Var17.getFirst());
        }
        f11754m = linkedHashMap3;
    }
}
