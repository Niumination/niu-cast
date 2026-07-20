package ag;

import jh.u0;
import jh.z0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends SuspendLambda implements Function2 {
    final /* synthetic */ u0 $countedInput;
    final /* synthetic */ xi.a $firstBoundary;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(xi.a aVar, u0 u0Var, Continuation<? super h0> continuation) {
        super(2, continuation);
        this.$firstBoundary = aVar;
        this.$countedInput = u0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h0 h0Var = new h0(this.$firstBoundary, this.$countedInput, continuation);
        h0Var.L$0 = obj;
        return h0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        z0 z0Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                z0Var = (z0) this.L$0;
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
        z0Var = (z0) this.L$0;
        xi.a aVar = this.$firstBoundary;
        u0 u0Var = this.$countedInput;
        jh.j0 j0Var = z0Var.f6313a;
        this.L$0 = z0Var;
        this.label = 1;
        xi.a aVar2 = m0.f773a;
        if (jh.g0.n(u0Var, aVar, j0Var, 8192L, true, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        jh.j0 j0Var2 = z0Var.f6313a;
        this.L$0 = null;
        this.label = 2;
        if (((jh.k) j0Var2).i(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(z0 z0Var, Continuation<? super Unit> continuation) {
        return ((h0) create(z0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
