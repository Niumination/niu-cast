package li;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 {
    public static final Object a(long j8, Continuation continuation) {
        if (j8 <= 0) {
            return Unit.INSTANCE;
        }
        l lVar = new l(1, IntrinsicsKt.intercepted(continuation));
        lVar.s();
        if (j8 < Long.MAX_VALUE) {
            b(lVar.e).c(j8, lVar);
        }
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    public static final q0 b(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.INSTANCE);
        q0 q0Var = element instanceof q0 ? (q0) element : null;
        return q0Var == null ? n0.f7481a : q0Var;
    }
}
