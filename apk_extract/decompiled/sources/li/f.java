package li;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f7448d;
    public final f1 e;

    public f(CoroutineContext coroutineContext, Thread thread, f1 f1Var) {
        super(coroutineContext, true, true);
        this.f7448d = thread;
        this.e = f1Var;
    }

    @Override // li.x1
    public final void v(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f7448d;
        if (Intrinsics.areEqual(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
