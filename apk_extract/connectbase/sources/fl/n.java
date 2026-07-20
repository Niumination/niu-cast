package fl;

import java.util.Collections;
import java.util.Map;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6067a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f6068b = 0.75f;

    @t0
    @os.l
    public static final <K, V> Map<K, V> a(@os.l jn.l<? super K, ? extends V> lVar, @os.l jn.l<? super V, l2> lVar2, int i10) {
        kn.l0.p(lVar, "supplier");
        kn.l0.p(lVar2, "close");
        Map<K, V> mapSynchronizedMap = Collections.synchronizedMap(new w0(lVar, lVar2, i10));
        kn.l0.o(mapSynchronizedMap, "synchronizedMap(LRUCache…upplier, close, maxSize))");
        return mapSynchronizedMap;
    }
}
