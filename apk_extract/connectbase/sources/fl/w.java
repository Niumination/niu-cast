package fl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class w<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6106a = AtomicReferenceFieldUpdater.newUpdater(w.class, Object.class, "current");

    @os.l
    private volatile /* synthetic */ Object current = nm.d1.z();

    @os.l
    public final V a(@os.l K k10, @os.l jn.l<? super K, ? extends V> lVar) {
        Map map;
        HashMap map2;
        V vInvoke;
        kn.l0.p(k10, cb.b.c.f1408o);
        kn.l0.p(lVar, "producer");
        do {
            map = (Map) this.current;
            V v10 = (V) map.get(k10);
            if (v10 != null) {
                return v10;
            }
            map2 = new HashMap(map);
            vInvoke = lVar.invoke(k10);
            map2.put(k10, vInvoke);
        } while (!j.d.a(f6106a, this, map, map2));
        return vInvoke;
    }

    @os.m
    public final V b(@os.l K k10) {
        kn.l0.p(k10, cb.b.c.f1408o);
        return (V) ((Map) this.current).get(k10);
    }

    @os.m
    public final V c(@os.l K k10, @os.l V v10) {
        Map map;
        HashMap map2;
        V v11;
        kn.l0.p(k10, cb.b.c.f1408o);
        kn.l0.p(v10, "value");
        do {
            map = (Map) this.current;
            if (map.get(k10) == v10) {
                return v10;
            }
            map2 = new HashMap(map);
            v11 = (V) map2.put(k10, v10);
        } while (!j.d.a(f6106a, this, map, map2));
        return v11;
    }

    @os.m
    public final V d(@os.l K k10) {
        Map map;
        HashMap map2;
        V v10;
        kn.l0.p(k10, cb.b.c.f1408o);
        do {
            map = (Map) this.current;
            if (map.get(k10) == null) {
                return null;
            }
            map2 = new HashMap(map);
            v10 = (V) map2.remove(k10);
        } while (!j.d.a(f6106a, this, map, map2));
        return v10;
    }

    public final void e(@os.l K k10, @os.l V v10) {
        kn.l0.p(k10, cb.b.c.f1408o);
        kn.l0.p(v10, "value");
        c(k10, v10);
    }
}
