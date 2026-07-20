package li;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2 f7484a = new p2();

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        u2 u2Var = (u2) coroutineContext.get(u2.f7496b);
        if (u2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        u2Var.f7497a = true;
    }

    @Override // li.a0
    public final a0 limitedParallelism(int i8, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // li.a0
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
