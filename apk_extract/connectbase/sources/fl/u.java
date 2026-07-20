package fl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ConcurrentHashMap<b<?>, Object> f6103a = new ConcurrentHashMap<>();

    @Override // fl.c
    @os.l
    public <T> T a(@os.l b<T> bVar, @os.l jn.a<? extends T> aVar) {
        kn.l0.p(bVar, cb.b.c.f1408o);
        kn.l0.p(aVar, "block");
        T t10 = (T) this.f6103a.get(bVar);
        if (t10 != null) {
            return t10;
        }
        T tInvoke = aVar.invoke();
        T t11 = (T) this.f6103a.putIfAbsent(bVar, tInvoke);
        return t11 == null ? tInvoke : t11;
    }

    @Override // fl.d
    public Map j() {
        return this.f6103a;
    }

    @os.l
    public ConcurrentHashMap<b<?>, Object> k() {
        return this.f6103a;
    }
}
