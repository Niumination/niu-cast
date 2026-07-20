package ng;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends SuspendLambda implements Function2 {
    final /* synthetic */ long $gracePeriodMillis;
    final /* synthetic */ long $timeoutMillis;
    int label;
    final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(p pVar, long j8, long j10, Continuation<? super l> continuation) {
        super(2, continuation);
        this.this$0 = pVar;
        this.$gracePeriodMillis = j8;
        this.$timeoutMillis = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new l(this.this$0, this.$gracePeriodMillis, this.$timeoutMillis, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            p pVar = this.this$0;
            long j8 = this.$gracePeriodMillis;
            long j10 = this.$timeoutMillis;
            this.label = 1;
            if (pVar.e(j8, j10, this) == coroutine_suspended) {
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
        return ((l) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
