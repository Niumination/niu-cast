package ni;

import eb.t0;
import k3.bc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import li.j0;
import li.o1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(d0 d0Var, Function0 function0, ContinuationImpl continuationImpl) {
        a0 a0Var;
        if (continuationImpl instanceof a0) {
            a0Var = (a0) continuationImpl;
            int i8 = a0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                a0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                a0Var = new a0(continuationImpl);
            }
        } else {
            a0Var = new a0(continuationImpl);
        }
        Object obj = a0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = a0Var.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj);
                if (a0Var.get$context().get(o1.f7483a) != d0Var) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                a0Var.L$0 = d0Var;
                a0Var.L$1 = function0;
                a0Var.label = 1;
                li.l lVar = new li.l(1, IntrinsicsKt.intercepted(a0Var));
                lVar.s();
                ((r) d0Var).t0(new t0(lVar, 6));
                Object objR = lVar.r();
                if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(a0Var);
                }
                if (objR == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0 = (Function0) a0Var.L$1;
                ResultKt.throwOnFailure(obj);
            }
            function0.invoke();
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            function0.invoke();
            throw th2;
        }
    }

    public static c0 b(li.g0 g0Var, li.f0 f0Var, Function2 function2, int i8) {
        CoroutineContext coroutineContext = f0Var;
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        c cVar = c.SUSPEND;
        j0 j0Var = j0.DEFAULT;
        c0 c0Var = new c0(li.y.b(g0Var, coroutineContext), bc.a(0, 4, cVar), true, true);
        j0Var.invoke(function2, c0Var, c0Var);
        return c0Var;
    }
}
