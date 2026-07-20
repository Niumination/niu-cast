package si;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import li.a0;
import li.h1;
import qi.y;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends h1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10118a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f10119b = a0.limitedParallelism$default(m.f10130a, qi.g.j("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(64, y.f9172a), 0, 0, 12), null, 2, null);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f10119b.dispatch(coroutineContext, runnable);
    }

    @Override // li.a0
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f10119b.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // li.a0
    public final a0 limitedParallelism(int i8, String str) {
        return m.f10130a.limitedParallelism(i8, str);
    }

    @Override // li.a0
    public final String toString() {
        return "Dispatchers.IO";
    }
}
