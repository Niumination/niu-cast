package li;

import java.util.concurrent.CancellationException;
import k3.bd;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h0 {
    public static final qi.c a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(o1.f7483a) == null) {
            coroutineContext = coroutineContext.plus(l0.c());
        }
        return new qi.c(coroutineContext);
    }

    public static final void b(g0 g0Var, CancellationException cancellationException) {
        p1 p1Var = (p1) g0Var.getCoroutineContext().get(o1.f7483a);
        if (p1Var != null) {
            p1Var.h(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + g0Var).toString());
        }
    }

    public static final Object c(Function2 function2, Continuation continuation) {
        qi.v vVar = new qi.v(continuation, continuation.get$context());
        Object objA = bd.a(vVar, vVar, function2);
        if (objA == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objA;
    }

    public static final boolean d(g0 g0Var) {
        p1 p1Var = (p1) g0Var.getCoroutineContext().get(o1.f7483a);
        if (p1Var != null) {
            return p1Var.a();
        }
        return true;
    }
}
