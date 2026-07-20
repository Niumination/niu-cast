package nm;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nMaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,804:1\n403#1:814\n414#1:819\n511#1,6:824\n536#1,6:830\n1#2:805\n1238#3,4:806\n1238#3,4:810\n1238#3,4:815\n1238#3,4:820\n*S KotlinDebug\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n453#1:814\n468#1:819\n526#1:824,6\n551#1:830,6\n403#1:806,4\n414#1:810,4\n453#1:815,4\n468#1:820,4\n*E\n"})
public class d1 extends c1 {
    @os.l
    public static final <K, V> Map<K, V> A(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @an.f
    public static final <K, V> void A0(Map<K, V> map, K k10, V v10) {
        kn.l0.p(map, "<this>");
        map.put(k10, v10);
    }

    @os.l
    public static final <K, V> Map<K, V> B(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super K, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @os.l
    public static <K, V> Map<K, V> B0(@os.l gq.m<? extends lm.t0<? extends K, ? extends V>> mVar) {
        kn.l0.p(mVar, "<this>");
        return k0(C0(mVar, new LinkedHashMap()));
    }

    @os.l
    public static final <K, V> Map<K, V> C(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M C0(@os.l gq.m<? extends lm.t0<? extends K, ? extends V>> mVar, @os.l M m10) {
        kn.l0.p(mVar, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        w0(m10, mVar);
        return m10;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M D(@os.l Map<? extends K, ? extends V> map, @os.l M m10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                m10.put(entry.getKey(), entry.getValue());
            }
        }
        return m10;
    }

    @os.l
    public static <K, V> Map<K, V> D0(@os.l Iterable<? extends lm.t0<? extends K, ? extends V>> iterable) {
        kn.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k0(E0(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z();
        }
        if (size != 1) {
            return E0(iterable, new LinkedHashMap(c1.j(collection.size())));
        }
        return c1.k(iterable instanceof List ? (lm.t0<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M E(@os.l Map<? extends K, ? extends V> map, @os.l M m10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                m10.put(entry.getKey(), entry.getValue());
            }
        }
        return m10;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M E0(@os.l Iterable<? extends lm.t0<? extends K, ? extends V>> iterable, @os.l M m10) {
        kn.l0.p(iterable, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        x0(m10, iterable);
        return m10;
    }

    @os.l
    public static final <K, V> Map<K, V> F(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super V, Boolean> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.1")
    @os.l
    public static <K, V> Map<K, V> F0(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? J0(map) : c1.o(map);
        }
        return z();
    }

    @an.f
    public static final <K, V> V G(Map<? extends K, ? extends V> map, K k10) {
        kn.l0.p(map, "<this>");
        return map.get(k10);
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M G0(@os.l Map<? extends K, ? extends V> map, @os.l M m10) {
        kn.l0.p(map, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        m10.putAll(map);
        return m10;
    }

    @an.f
    public static final <K, V> V H(Map<K, ? extends V> map, K k10, jn.a<? extends V> aVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(aVar, "defaultValue");
        V v10 = map.get(k10);
        return v10 == null ? aVar.invoke() : v10;
    }

    @os.l
    public static final <K, V> Map<K, V> H0(@os.l lm.t0<? extends K, ? extends V>[] t0VarArr) {
        kn.l0.p(t0VarArr, "<this>");
        int length = t0VarArr.length;
        if (length != 0) {
            return length != 1 ? I0(t0VarArr, new LinkedHashMap(c1.j(t0VarArr.length))) : c1.k(t0VarArr[0]);
        }
        return z();
    }

    public static final <K, V> V I(@os.l Map<K, ? extends V> map, K k10, @os.l jn.a<? extends V> aVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(aVar, "defaultValue");
        V v10 = map.get(k10);
        return (v10 != null || map.containsKey(k10)) ? v10 : aVar.invoke();
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M I0(@os.l lm.t0<? extends K, ? extends V>[] t0VarArr, @os.l M m10) {
        kn.l0.p(t0VarArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        y0(m10, t0VarArr);
        return m10;
    }

    public static final <K, V> V J(@os.l Map<K, V> map, K k10, @os.l jn.a<? extends V> aVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(aVar, "defaultValue");
        V v10 = map.get(k10);
        if (v10 != null) {
            return v10;
        }
        V vInvoke = aVar.invoke();
        map.put(k10, vInvoke);
        return vInvoke;
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <K, V> Map<K, V> J0(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return new LinkedHashMap(map);
    }

    @lm.f1(version = "1.1")
    public static <K, V> V K(@os.l Map<K, ? extends V> map, K k10) {
        kn.l0.p(map, "<this>");
        return (V) b1.a(map, k10);
    }

    @an.f
    public static final <K, V> lm.t0<K, V> K0(Map.Entry<? extends K, ? extends V> entry) {
        kn.l0.p(entry, "<this>");
        return new lm.t0<>(entry.getKey(), entry.getValue());
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <K, V> HashMap<K, V> L() {
        return new HashMap<>();
    }

    @os.l
    public static <K, V> HashMap<K, V> M(@os.l lm.t0<? extends K, ? extends V>... t0VarArr) {
        kn.l0.p(t0VarArr, "pairs");
        HashMap<K, V> map = new HashMap<>(c1.j(t0VarArr.length));
        y0(map, t0VarArr);
        return map;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Ljn/a<+TR;>;)TR; */
    @lm.f1(version = "1.3")
    @an.f
    public static final Object N(Map map, jn.a aVar) {
        kn.l0.p(aVar, "defaultValue");
        return map.isEmpty() ? aVar.invoke() : map;
    }

    @an.f
    public static final <K, V> boolean O(Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return !map.isEmpty();
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final <K, V> boolean P(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @an.f
    public static final <K, V> Iterator<Map.Entry<K, V>> Q(Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <K, V> LinkedHashMap<K, V> R() {
        return new LinkedHashMap<>();
    }

    @os.l
    public static final <K, V> LinkedHashMap<K, V> S(@os.l lm.t0<? extends K, ? extends V>... t0VarArr) {
        kn.l0.p(t0VarArr, "pairs");
        return (LinkedHashMap) I0(t0VarArr, new LinkedHashMap(c1.j(t0VarArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <K, V, R> Map<R, V> T(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(c1.j(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(lVar.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <K, V, R, M extends Map<? super R, ? super V>> M U(@os.l Map<? extends K, ? extends V> map, @os.l M m10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m10.put(lVar.invoke(entry), entry.getValue());
        }
        return m10;
    }

    @an.f
    public static final <K, V> Map<K, V> V() {
        return z();
    }

    @os.l
    public static <K, V> Map<K, V> W(@os.l lm.t0<? extends K, ? extends V>... t0VarArr) {
        kn.l0.p(t0VarArr, "pairs");
        return t0VarArr.length > 0 ? I0(t0VarArr, new LinkedHashMap(c1.j(t0VarArr.length))) : z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <K, V, R> Map<K, R> X(@os.l Map<? extends K, ? extends V> map, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(c1.j(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), lVar.invoke(entry));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <K, V, R, M extends Map<? super K, ? super R>> M Y(@os.l Map<? extends K, ? extends V> map, @os.l M m10, @os.l jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m10.put(entry.getKey(), lVar.invoke(entry));
        }
        return m10;
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <K, V> Map<K, V> Z(@os.l Map<? extends K, ? extends V> map, @os.l gq.m<? extends K> mVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(mVar, "keys");
        Map mapJ0 = J0(map);
        d0.H0(mapJ0.keySet(), mVar);
        return k0(mapJ0);
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <K, V> Map<K, V> a0(@os.l Map<? extends K, ? extends V> map, @os.l Iterable<? extends K> iterable) {
        kn.l0.p(map, "<this>");
        kn.l0.p(iterable, "keys");
        Map mapJ0 = J0(map);
        d0.I0(mapJ0.keySet(), iterable);
        return k0(mapJ0);
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <K, V> Map<K, V> b0(@os.l Map<? extends K, ? extends V> map, K k10) {
        kn.l0.p(map, "<this>");
        Map mapJ0 = J0(map);
        mapJ0.remove(k10);
        return k0(mapJ0);
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <K, V> Map<K, V> c0(@os.l Map<? extends K, ? extends V> map, @os.l K[] kArr) {
        kn.l0.p(map, "<this>");
        kn.l0.p(kArr, "keys");
        Map mapJ0 = J0(map);
        d0.K0(mapJ0.keySet(), kArr);
        return k0(mapJ0);
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <K, V> void d0(Map<K, V> map, gq.m<? extends K> mVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(mVar, "keys");
        d0.H0(map.keySet(), mVar);
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <K, V> void e0(Map<K, V> map, Iterable<? extends K> iterable) {
        kn.l0.p(map, "<this>");
        kn.l0.p(iterable, "keys");
        d0.I0(map.keySet(), iterable);
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <K, V> void f0(Map<K, V> map, K k10) {
        kn.l0.p(map, "<this>");
        map.remove(k10);
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <K, V> void g0(Map<K, V> map, K[] kArr) {
        kn.l0.p(map, "<this>");
        kn.l0.p(kArr, "keys");
        d0.K0(map.keySet(), kArr);
    }

    @an.f
    @in.i(name = "mutableIterator")
    public static final <K, V> Iterator<Map.Entry<K, V>> h0(Map<K, V> map) {
        kn.l0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @lm.f1(version = "1.1")
    @an.f
    public static final <K, V> Map<K, V> i0() {
        return new LinkedHashMap();
    }

    @os.l
    public static <K, V> Map<K, V> j0(@os.l lm.t0<? extends K, ? extends V>... t0VarArr) {
        kn.l0.p(t0VarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(c1.j(t0VarArr.length));
        y0(linkedHashMap, t0VarArr);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <K, V> Map<K, V> k0(@os.l Map<K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : c1.o(map);
        }
        return z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <K, V> Map<K, V> l0(Map<K, ? extends V> map) {
        return map == 0 ? z() : map;
    }

    @os.l
    public static final <K, V> Map<K, V> m0(@os.l Map<? extends K, ? extends V> map, @os.l gq.m<? extends lm.t0<? extends K, ? extends V>> mVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(mVar, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        w0(linkedHashMap, mVar);
        return k0(linkedHashMap);
    }

    @os.l
    public static final <K, V> Map<K, V> n0(@os.l Map<? extends K, ? extends V> map, @os.l Iterable<? extends lm.t0<? extends K, ? extends V>> iterable) {
        kn.l0.p(map, "<this>");
        kn.l0.p(iterable, "pairs");
        if (map.isEmpty()) {
            return D0(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        x0(linkedHashMap, iterable);
        return linkedHashMap;
    }

    @os.l
    public static <K, V> Map<K, V> o0(@os.l Map<? extends K, ? extends V> map, @os.l Map<? extends K, ? extends V> map2) {
        kn.l0.p(map, "<this>");
        kn.l0.p(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @os.l
    public static final <K, V> Map<K, V> p0(@os.l Map<? extends K, ? extends V> map, @os.l lm.t0<? extends K, ? extends V> t0Var) {
        kn.l0.p(map, "<this>");
        kn.l0.p(t0Var, "pair");
        if (map.isEmpty()) {
            return c1.k(t0Var);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(t0Var.getFirst(), t0Var.getSecond());
        return linkedHashMap;
    }

    @os.l
    public static final <K, V> Map<K, V> q0(@os.l Map<? extends K, ? extends V> map, @os.l lm.t0<? extends K, ? extends V>[] t0VarArr) {
        kn.l0.p(map, "<this>");
        kn.l0.p(t0VarArr, "pairs");
        if (map.isEmpty()) {
            return H0(t0VarArr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        y0(linkedHashMap, t0VarArr);
        return linkedHashMap;
    }

    @an.f
    public static final <K, V> void r0(Map<? super K, ? super V> map, gq.m<? extends lm.t0<? extends K, ? extends V>> mVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(mVar, "pairs");
        w0(map, mVar);
    }

    @lm.f1(version = "1.6")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <K, V> Map<K, V> s(int i10, @lm.b jn.l<? super Map<K, V>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.d dVar = new om.d(i10);
        lVar.invoke(dVar);
        return c1.d(dVar);
    }

    @an.f
    public static final <K, V> void s0(Map<? super K, ? super V> map, Iterable<? extends lm.t0<? extends K, ? extends V>> iterable) {
        kn.l0.p(map, "<this>");
        kn.l0.p(iterable, "pairs");
        x0(map, iterable);
    }

    @lm.f1(version = "1.6")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <K, V> Map<K, V> t(@lm.b jn.l<? super Map<K, V>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.d dVar = new om.d();
        lVar.invoke(dVar);
        return c1.d(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <K, V> void t0(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        kn.l0.p(map, "<this>");
        kn.l0.p(map2, "map");
        map.putAll(map2);
    }

    @an.f
    public static final <K, V> K u(Map.Entry<? extends K, ? extends V> entry) {
        kn.l0.p(entry, "<this>");
        return entry.getKey();
    }

    @an.f
    public static final <K, V> void u0(Map<? super K, ? super V> map, lm.t0<? extends K, ? extends V> t0Var) {
        kn.l0.p(map, "<this>");
        kn.l0.p(t0Var, "pair");
        map.put(t0Var.getFirst(), t0Var.getSecond());
    }

    @an.f
    public static final <K, V> V v(Map.Entry<? extends K, ? extends V> entry) {
        kn.l0.p(entry, "<this>");
        return entry.getValue();
    }

    @an.f
    public static final <K, V> void v0(Map<? super K, ? super V> map, lm.t0<? extends K, ? extends V>[] t0VarArr) {
        kn.l0.p(map, "<this>");
        kn.l0.p(t0VarArr, "pairs");
        y0(map, t0VarArr);
    }

    @an.f
    public static final <K, V> boolean w(Map<? extends K, ? extends V> map, K k10) {
        kn.l0.p(map, "<this>");
        return map.containsKey(k10);
    }

    public static final <K, V> void w0(@os.l Map<? super K, ? super V> map, @os.l gq.m<? extends lm.t0<? extends K, ? extends V>> mVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(mVar, "pairs");
        for (lm.t0<? extends K, ? extends V> t0Var : mVar) {
            map.put(t0Var.component1(), t0Var.component2());
        }
    }

    @an.f
    public static final <K> boolean x(Map<? extends K, ?> map, K k10) {
        kn.l0.p(map, "<this>");
        return map.containsKey(k10);
    }

    public static final <K, V> void x0(@os.l Map<? super K, ? super V> map, @os.l Iterable<? extends lm.t0<? extends K, ? extends V>> iterable) {
        kn.l0.p(map, "<this>");
        kn.l0.p(iterable, "pairs");
        for (lm.t0<? extends K, ? extends V> t0Var : iterable) {
            map.put(t0Var.component1(), t0Var.component2());
        }
    }

    @an.f
    public static final <K, V> boolean y(Map<K, ? extends V> map, V v10) {
        kn.l0.p(map, "<this>");
        return map.containsValue(v10);
    }

    public static final <K, V> void y0(@os.l Map<? super K, ? super V> map, @os.l lm.t0<? extends K, ? extends V>[] t0VarArr) {
        kn.l0.p(map, "<this>");
        kn.l0.p(t0VarArr, "pairs");
        for (lm.t0<? extends K, ? extends V> t0Var : t0VarArr) {
            map.put(t0Var.component1(), t0Var.component2());
        }
    }

    @os.l
    public static <K, V> Map<K, V> z() {
        l0 l0Var = l0.INSTANCE;
        kn.l0.n(l0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return l0Var;
    }

    @an.f
    public static final <K, V> V z0(Map<? extends K, V> map, K k10) {
        kn.l0.p(map, "<this>");
        return (V) kn.u1.k(map).remove(k10);
    }
}
