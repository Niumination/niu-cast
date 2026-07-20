package se;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class j3 extends SuspendLambda implements Function2 {
    final /* synthetic */ yg.a $session;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3(yg.a aVar, Continuation<? super j3> continuation) {
        super(2, continuation);
        this.$session = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j3(this.$session, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            yg.a aVar = this.$session;
            oh.c cVar = new oh.c(oh.b.NORMAL, "Server stopped");
            this.label = 1;
            if (oh.u0.b(aVar, cVar, this) == coroutine_suspended) {
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
        return ((j3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
