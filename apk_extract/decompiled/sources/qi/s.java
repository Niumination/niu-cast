package qi;

import kotlin.coroutines.CoroutineContext;
import li.n0;
import li.q0;
import li.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends li.a0 implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f9164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final li.a0 f9165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9166c;

    /* JADX WARN: Multi-variable type inference failed */
    public s(li.a0 a0Var, String str) {
        q0 q0Var = a0Var instanceof q0 ? (q0) a0Var : null;
        this.f9164a = q0Var == null ? n0.f7481a : q0Var;
        this.f9165b = a0Var;
        this.f9166c = str;
    }

    @Override // li.q0
    public final void c(long j8, li.l lVar) {
        this.f9164a.c(j8, lVar);
    }

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.f9165b.dispatch(coroutineContext, runnable);
    }

    @Override // li.a0
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        this.f9165b.dispatchYield(coroutineContext, runnable);
    }

    @Override // li.q0
    public final x0 g(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f9164a.g(j8, runnable, coroutineContext);
    }

    @Override // li.a0
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return this.f9165b.isDispatchNeeded(coroutineContext);
    }

    @Override // li.a0
    public final String toString() {
        return this.f9166c;
    }
}
