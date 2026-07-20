package nm;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class e1 extends d1 {
    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @an.f
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @lm.a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> L0(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry3);
                    if (rInvoke.compareTo(rInvoke2) < 0) {
                        entry2 = entry3;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @an.f
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @lm.a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ <K, V> Map.Entry<K, V> M0(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        return (Map.Entry) h0.V3(map.entrySet(), comparator);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @lm.a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> N0(Map<? extends K, ? extends V> map, jn.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Map.Entry<K, V> entry;
        kn.l0.p(map, "<this>");
        kn.l0.p(lVar, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rInvoke = lVar.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rInvoke2 = lVar.invoke(entry3);
                    if (rInvoke.compareTo(rInvoke2) > 0) {
                        entry2 = entry3;
                        rInvoke = rInvoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @lm.a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Map.Entry O0(Map map, Comparator comparator) {
        kn.l0.p(map, "<this>");
        kn.l0.p(comparator, "comparator");
        return (Map.Entry) h0.n4(map.entrySet(), comparator);
    }
}
