package nm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nGroupingJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n+ 2 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n143#2:53\n80#2,4:54\n85#2:59\n1#3:58\n1855#4,2:60\n*S KotlinDebug\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n*L\n22#1:53\n22#1:54,4\n22#1:59\n48#1:60,2\n*E\n"})
public class q0 {
    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K> Map<K, Integer> a(@os.l o0<T, ? extends K> o0Var) {
        kn.l0.p(o0Var, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = o0Var.b();
        while (itB.hasNext()) {
            K kA = o0Var.a(itB.next());
            Object fVar = linkedHashMap.get(kA);
            if (fVar == null && !linkedHashMap.containsKey(kA)) {
                fVar = new kn.k1.f();
            }
            kn.k1.f fVar2 = (kn.k1.f) fVar;
            fVar2.element++;
            linkedHashMap.put(kA, fVar2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kn.l0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            kn.u1.m(entry).setValue(Integer.valueOf(((kn.k1.f) entry.getValue()).element));
        }
        return kn.u1.k(linkedHashMap);
    }

    @an.f
    @lm.z0
    public static final <K, V, R> Map<K, R> b(Map<K, V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "f");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kn.l0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            kn.u1.m(entry).setValue(lVar.invoke(entry));
        }
        return kn.u1.k(map);
    }
}
