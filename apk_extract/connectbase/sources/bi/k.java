package bi;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class, q> f875a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<s, q> f876b = new HashMap();

    public final p a() {
        p pVar = new p();
        for (Class cls : this.f875a.keySet()) {
            pVar.b(cls, this.f875a.get(cls));
        }
        for (s sVar : this.f876b.keySet()) {
            pVar.a(sVar, this.f876b.get(sVar));
        }
        return pVar;
    }

    public T b(String str, Class cls) {
        return (T) a().k(new n(str).j(), cls);
    }
}
