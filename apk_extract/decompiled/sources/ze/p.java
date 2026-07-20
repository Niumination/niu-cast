package ze;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f11394b = new p(new o(1), o.f11387b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f11395a = new ConcurrentHashMap();

    public p(o... oVarArr) {
        for (o oVar : oVarArr) {
            this.f11395a.put(oVar.a(), oVar);
        }
    }
}
