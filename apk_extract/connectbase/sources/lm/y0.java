package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {
    @f1(version = "1.4")
    @an.f
    public static final <V> V a(un.p<? extends V> pVar, Object obj, un.o<?> oVar) {
        kn.l0.p(pVar, "<this>");
        kn.l0.p(oVar, "property");
        return pVar.get();
    }

    @f1(version = "1.4")
    @an.f
    public static final <T, V> V b(un.q<T, ? extends V> qVar, T t10, un.o<?> oVar) {
        kn.l0.p(qVar, "<this>");
        kn.l0.p(oVar, "property");
        return qVar.get(t10);
    }

    @f1(version = "1.4")
    @an.f
    public static final <V> void c(un.k<V> kVar, Object obj, un.o<?> oVar, V v10) {
        kn.l0.p(kVar, "<this>");
        kn.l0.p(oVar, "property");
        kVar.set(v10);
    }

    @f1(version = "1.4")
    @an.f
    public static final <T, V> void d(un.l<T, V> lVar, T t10, un.o<?> oVar, V v10) {
        kn.l0.p(lVar, "<this>");
        kn.l0.p(oVar, "property");
        lVar.set(t10, v10);
    }
}
