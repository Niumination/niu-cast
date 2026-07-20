package pi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends SuspendLambda implements Function2 {
    final /* synthetic */ Function3<g0, oi.i, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ oi.i $this_flow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public r(Function3<? super g0, ? super oi.i, ? super Continuation<? super Unit>, ? extends Object> function3, oi.i iVar, Continuation<? super r> continuation) {
        super(2, continuation);
        this.$block = function3;
        this.$this_flow = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        r rVar = new r(this.$block, this.$this_flow, continuation);
        rVar.L$0 = obj;
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            g0 g0Var = (g0) this.L$0;
            Function3<g0, oi.i, Continuation<? super Unit>, Object> function3 = this.$block;
            oi.i iVar = this.$this_flow;
            this.label = 1;
            if (function3.invoke(g0Var, iVar, this) == coroutine_suspended) {
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
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((r) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
