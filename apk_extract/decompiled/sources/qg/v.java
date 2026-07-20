package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends SuspendLambda implements Function1 {
    final /* synthetic */ hh.f $$this$intercept;
    final /* synthetic */ ah.b $error;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(hh.f fVar, ah.b bVar, Continuation<? super v> continuation) {
        super(1, continuation);
        this.$$this$intercept = fVar;
        this.$error = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new v(this.$$this$intercept, this.$error, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        h.a(((mg.r) this.$$this$intercept.f5401a).getApplication().f8055i, (mg.r) this.$$this$intercept.f5401a, this.$error);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((v) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
