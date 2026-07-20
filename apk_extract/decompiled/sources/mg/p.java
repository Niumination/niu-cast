package mg;

import k3.c2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends IllegalStateException implements li.x {
    private final zg.a key;

    public p(zg.a key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    public final zg.a getKey() {
        return this.key;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return h0.a.n(new StringBuilder("Application plugin "), this.key.f11583a, " is not installed");
    }

    @Override // li.x
    public p createCopy() {
        p pVar = new p(this.key);
        c2.a(pVar, this);
        return pVar;
    }
}
