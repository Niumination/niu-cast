package nm;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nMapsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"})
public class c1 extends b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11619a = 1073741824;

    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <K, V> Map<K, V> d(@os.l Map<K, V> map) {
        kn.l0.p(map, "builder");
        return ((om.d) map).build();
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final <K, V> Map<K, V> e(int i10, jn.l<? super Map<K, V>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.d dVar = new om.d(i10);
        lVar.invoke(dVar);
        return d(dVar);
    }

    @lm.f1(version = "1.3")
    @an.f
    @lm.z0
    public static final <K, V> Map<K, V> f(jn.l<? super Map<K, V>, l2> lVar) {
        kn.l0.p(lVar, "builderAction");
        om.d dVar = new om.d();
        lVar.invoke(dVar);
        return d(dVar);
    }

    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <K, V> Map<K, V> g() {
        return new om.d();
    }

    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static <K, V> Map<K, V> h(int i10) {
        return new om.d(i10);
    }

    public static final <K, V> V i(@os.l ConcurrentMap<K, V> concurrentMap, K k10, @os.l jn.a<? extends V> aVar) {
        kn.l0.p(concurrentMap, "<this>");
        kn.l0.p(aVar, "defaultValue");
        V v10 = concurrentMap.get(k10);
        if (v10 != null) {
            return v10;
        }
        V vInvoke = aVar.invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k10, vInvoke);
        return vPutIfAbsent == null ? vInvoke : vPutIfAbsent;
    }

    @lm.z0
    public static int j(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @os.l
    public static <K, V> Map<K, V> k(@os.l lm.t0<? extends K, ? extends V> t0Var) {
        kn.l0.p(t0Var, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(t0Var.getFirst(), t0Var.getSecond());
        kn.l0.o(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <K, V> SortedMap<K, V> l(@os.l Comparator<? super K> comparator, @os.l lm.t0<? extends K, ? extends V>... t0VarArr) {
        kn.l0.p(comparator, "comparator");
        kn.l0.p(t0VarArr, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        d1.y0(treeMap, t0VarArr);
        return treeMap;
    }

    @os.l
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m(@os.l lm.t0<? extends K, ? extends V>... t0VarArr) {
        kn.l0.p(t0VarArr, "pairs");
        TreeMap treeMap = new TreeMap();
        d1.y0(treeMap, t0VarArr);
        return treeMap;
    }

    @an.f
    public static final Properties n(Map<String, String> map) {
        kn.l0.p(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @os.l
    public static final <K, V> Map<K, V> o(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kn.l0.o(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    @an.f
    public static final <K, V> Map<K, V> p(Map<K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return o(map);
    }

    @os.l
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> q(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, "<this>");
        return new TreeMap(map);
    }

    @os.l
    public static <K, V> SortedMap<K, V> r(@os.l Map<? extends K, ? extends V> map, @os.l Comparator<? super K> comparator) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
