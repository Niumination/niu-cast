package mi;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import li.b0;
import li.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AbstractCoroutineContextElement implements c0 {
    private volatile Object _preHandler;

    public a() {
        super(b0.f7433a);
        this._preHandler = this;
    }

    @Override // li.c0
    public void L(CoroutineContext coroutineContext, Throwable th2) {
    }
}
