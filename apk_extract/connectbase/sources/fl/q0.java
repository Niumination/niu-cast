package fl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<b<?>, Object> f6092a = new HashMap();

    @Override // fl.c
    @os.l
    public <T> T a(@os.l b<T> bVar, @os.l jn.a<? extends T> aVar) {
        kn.l0.p(bVar, cb.b.c.f1408o);
        kn.l0.p(aVar, "block");
        T t10 = (T) this.f6092a.get(bVar);
        if (t10 != null) {
            return t10;
        }
        T tInvoke = aVar.invoke();
        T t11 = (T) this.f6092a.put(bVar, tInvoke);
        return t11 == null ? tInvoke : t11;
    }

    @Override // fl.d
    @os.l
    public Map<b<?>, Object> j() {
        return this.f6092a;
    }
}
