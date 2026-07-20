package ic;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends SuspendLambda implements Function2 {
    final /* synthetic */ li.j $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(li.j jVar, Continuation<? super o> continuation) {
        super(2, continuation);
        this.$it = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new o(this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (r0.a(20000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        na.a.b(this.$it, new hc.b(false, "timeout", null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_CURVE_FIT));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((o) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
