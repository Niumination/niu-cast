package si;

import kotlin.coroutines.CoroutineContext;
import li.h1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f10122a;

    public i(int i8, int i9, long j8, String str) {
        this.f10122a = new d(i8, i9, j8, str);
    }

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        d.g(this.f10122a, runnable, false, 6);
    }

    @Override // li.a0
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        d.g(this.f10122a, runnable, true, 2);
    }
}
