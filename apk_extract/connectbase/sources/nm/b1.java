package nm;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n*L\n24#1:105,6\n*E\n"})
public class b1 {
    @in.i(name = "getOrImplicitDefaultNullable")
    @lm.z0
    public static final <K, V> V a(@os.l Map<K, ? extends V> map, K k10) {
        kn.l0.p(map, "<this>");
        if (map instanceof y0) {
            return (V) ((y0) map).k(k10);
        }
        V v10 = map.get(k10);
        if (v10 != null || map.containsKey(k10)) {
            return v10;
        }
        throw new NoSuchElementException("Key " + k10 + " is missing in the map.");
    }

    @os.l
    public static final <K, V> Map<K, V> b(@os.l Map<K, ? extends V> map, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return map instanceof y0 ? b(((y0) map).b(), lVar) : new z0(map, lVar);
    }

    @in.i(name = "withDefaultMutable")
    @os.l
    public static final <K, V> Map<K, V> c(@os.l Map<K, V> map, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return map instanceof h1 ? c(((h1) map).b(), lVar) : new i1(map, lVar);
    }
}
