package li;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class q2 extends qi.v {
    public final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public q2(Continuation continuation, CoroutineContext coroutineContext) {
        r2 r2Var = r2.f7486a;
        super(continuation, coroutineContext.get(r2Var) == null ? coroutineContext.plus(r2Var) : coroutineContext);
        this.e = new ThreadLocal();
        if (continuation.get$context().get(ContinuationInterceptor.INSTANCE) instanceof a0) {
            return;
        }
        Object objC = qi.z.c(coroutineContext, null);
        qi.z.a(coroutineContext, objC);
        u0(coroutineContext, objC);
    }

    public final boolean t0() {
        boolean z2 = this.threadLocalIsSet && this.e.get() == null;
        this.e.remove();
        return !z2;
    }

    public final void u0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(TuplesKt.to(coroutineContext, obj));
    }

    @Override // qi.v, li.x1
    public final void x(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.e.get();
            if (pair != null) {
                qi.z.a((CoroutineContext) pair.component1(), pair.component2());
            }
            this.e.remove();
        }
        Object objA = w.a(obj);
        Continuation continuation = this.f9168d;
        CoroutineContext coroutineContext = continuation.get$context();
        Object objC = qi.z.c(coroutineContext, null);
        q2 q2VarC = objC != qi.z.f9173a ? y.c(continuation, coroutineContext, objC) : null;
        try {
            this.f9168d.resumeWith(objA);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (q2VarC == null || q2VarC.t0()) {
                qi.z.a(coroutineContext, objC);
            }
        }
    }
}
