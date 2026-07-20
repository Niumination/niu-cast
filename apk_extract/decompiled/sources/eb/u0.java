package eb;

import android.util.Log;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends SuspendLambda implements Function2 {
    final /* synthetic */ li.j $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(li.j jVar, Continuation<? super u0> continuation) {
        super(2, continuation);
        this.$it = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new u0(this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (li.r0.a(3000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
        Intrinsics.checkNotNullParameter("openBluetooth fail, listener timeout", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "openBluetooth fail, listener timeout");
        }
        na.a.b(this.$it, Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((u0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
