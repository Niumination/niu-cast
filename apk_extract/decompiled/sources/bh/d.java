package bh;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import qg.y0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1331a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "current");
    private volatile /* synthetic */ Object current = MapsKt.emptyMap();

    public final Object a(yf.a key, y0 producer) {
        Map map;
        HashMap map2;
        Object objInvoke;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(producer, "producer");
        do {
            map = (Map) this.current;
            Object obj = map.get(key);
            if (obj != null) {
                return obj;
            }
            map2 = new HashMap(map);
            objInvoke = producer.invoke(key);
            map2.put(key, objInvoke);
        } while (!f1331a.compareAndSet(this, map, map2));
        return objInvoke;
    }

    public final Object b(yf.a key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((Map) this.current).get(key);
    }
}
