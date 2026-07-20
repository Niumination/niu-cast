package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends SuspendLambda implements Function2 {
    final /* synthetic */ Long $length;
    final /* synthetic */ jh.o $readChannel;
    final /* synthetic */ jh.j0 $this_use;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(jh.o oVar, jh.j0 j0Var, Long l4, Continuation<? super q> continuation) {
        super(2, continuation);
        this.$readChannel = oVar;
        this.$this_use = j0Var;
        this.$length = l4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new q(this.$readChannel, this.$this_use, this.$length, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            jh.o oVar = this.$readChannel;
            jh.j0 j0Var = this.$this_use;
            Long l4 = this.$length;
            long jLongValue = l4 != null ? l4.longValue() : Long.MAX_VALUE;
            this.label = 1;
            obj = jh.g0.c(oVar, j0Var, jLongValue, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Long> continuation) {
        return ((q) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
