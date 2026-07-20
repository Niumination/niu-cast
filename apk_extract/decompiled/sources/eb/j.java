package eb;

import android.util.Log;
import androidx.work.WorkRequest;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends SuspendLambda implements Function2 {
    int label;

    public j(Continuation<? super j> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        if (li.r0.a(WorkRequest.MIN_BACKOFF_MILLIS, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
        Intrinsics.checkNotNullParameter("resetStateToInitial:timeout", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), "resetStateToInitial:timeout");
        }
        y yVar = y.f4799a;
        this.label = 2;
        if (y.a(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((j) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
