package qi;

import kotlin.coroutines.CoroutineContext;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f9137a;

    public c(CoroutineContext coroutineContext) {
        this.f9137a = coroutineContext;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f9137a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f9137a + ')';
    }
}
