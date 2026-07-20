package nm;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "MapAccessorsKt")
public final class x0 {
    @an.f
    public static final <V, V1 extends V> V1 a(Map<? super String, ? extends V> map, Object obj, un.o<?> oVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(oVar, "property");
        return (V1) b1.a(map, oVar.getName());
    }

    @an.f
    @in.i(name = "getVar")
    public static final <V, V1 extends V> V1 b(Map<? super String, ? extends V> map, Object obj, un.o<?> oVar) {
        kn.l0.p(map, "<this>");
        kn.l0.p(oVar, "property");
        return (V1) b1.a(map, oVar.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <V> void c(Map<? super String, ? super V> map, Object obj, un.o<?> oVar, V v10) {
        kn.l0.p(map, "<this>");
        kn.l0.p(oVar, "property");
        map.put(oVar.getName(), v10);
    }
}
