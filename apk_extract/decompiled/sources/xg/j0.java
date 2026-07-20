package xg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends SuspendLambda implements Function3 {
    final /* synthetic */ n0 $routingRoot;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(n0 n0Var, Continuation<? super j0> continuation) {
        super(3, continuation);
        this.$routingRoot = n0Var;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Unit unit, Continuation<? super Unit> continuation) {
        j0 j0Var = new j0(this.$routingRoot, continuation);
        j0Var.L$0 = fVar;
        return j0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            n0 n0Var = this.$routingRoot;
            this.label = 1;
            if (n0Var.x(fVar, this) == coroutine_suspended) {
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
}
