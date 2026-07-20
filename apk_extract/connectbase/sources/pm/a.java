package pm;

import an.f;
import in.i;
import java.util.Map;
import kn.l0;
import kn.u1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "CollectionsJDK8Kt")
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.2")
    @f
    public static final <K, V> V a(Map<? extends K, ? extends V> map, K k10, V v10) {
        l0.p(map, "<this>");
        return map.getOrDefault(k10, v10);
    }

    @f1(version = "1.2")
    @f
    public static final <K, V> boolean b(Map<? extends K, ? extends V> map, K k10, V v10) {
        l0.p(map, "<this>");
        return u1.k(map).remove(k10, v10);
    }
}
