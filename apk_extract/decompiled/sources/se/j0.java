package se;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ com.welink.protocol.nfbd.c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(com.welink.protocol.nfbd.c cVar, Continuation<? super j0> continuation) {
        super(2, continuation);
        this.this$0 = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j0(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CountDownLatch countDownLatch = this.this$0.f4079k;
        if (countDownLatch != null) {
            return Boxing.boxBoolean(countDownLatch.await(500L, TimeUnit.MILLISECONDS));
        }
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Boolean> continuation) {
        return ((j0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
