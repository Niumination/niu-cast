package vj;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@e0("https://github.com/grpc/grpc-java/issues/1704")
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f17263b = new t(new p.a(), p.b.f17223a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, s> f17264a = new ConcurrentHashMap();

    @b1.e
    public t(s... sVarArr) {
        for (s sVar : sVarArr) {
            this.f17264a.put(sVar.a(), sVar);
        }
    }

    public static t a() {
        return f17263b;
    }

    public static t c() {
        return new t(new s[0]);
    }

    @gm.j
    public s b(String str) {
        return this.f17264a.get(str);
    }

    public void d(s sVar) {
        String strA = sVar.a();
        c1.h0.e(!strA.contains(ks.g.f9491d), "Comma is currently not allowed in message encoding");
        this.f17264a.put(strA, sVar);
    }
}
