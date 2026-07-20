package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends SuspendLambda implements Function1 {
    final /* synthetic */ mg.b $call;
    final /* synthetic */ Throwable $error;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(mg.b bVar, Throwable th2, Continuation<? super z> continuation) {
        super(1, continuation);
        this.$call = bVar;
        this.$error = th2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new z(this.$call, this.$error, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        h.a(this.$call.getApplication().f8055i, this.$call, this.$error);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((z) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
