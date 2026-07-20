package li;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z2) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, new ag.q(8))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext2.fold(bool, new ag.q(8))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new ag.q(9));
        if (zBooleanValue2) {
            objectRef.element = ((CoroutineContext) objectRef.element).fold(emptyCoroutineContext, new ag.q(10));
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.element);
    }

    public static final CoroutineContext b(g0 g0Var, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(g0Var.getCoroutineContext(), coroutineContext, true);
        si.f fVar = v0.f7499b;
        return (coroutineContextA == fVar || coroutineContextA.get(ContinuationInterceptor.INSTANCE) != null) ? coroutineContextA : coroutineContextA.plus(fVar);
    }

    public static final q2 c(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        q2 q2Var = null;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (coroutineContext.get(r2.f7486a) != null) {
            CoroutineStackFrame callerFrame = (CoroutineStackFrame) continuation;
            while (!(callerFrame instanceof s0) && (callerFrame = callerFrame.getCallerFrame()) != null) {
                if (callerFrame instanceof q2) {
                    q2Var = (q2) callerFrame;
                    break;
                }
            }
            if (q2Var != null) {
                q2Var.u0(coroutineContext, obj);
            }
        }
        return q2Var;
    }
}
