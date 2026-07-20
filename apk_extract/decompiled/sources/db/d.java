package db;

import android.util.Log;
import eb.y;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import oi.g0;
import oi.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {
    int label;

    public d(Continuation<? super d> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter("PCIotCardManager", "tag");
            Intrinsics.checkNotNullParameter("<initListener> launch", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCIotCardManager"), "<initListener> launch");
            }
            g0 g0Var = y.f4806j;
            c cVar = new c(null);
            this.label = 1;
            if (j.e(g0Var, cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
