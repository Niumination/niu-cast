package nf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.l0;
import li.r0;
import pf.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends SuspendLambda implements Function2 {
    final /* synthetic */ CoroutineContext $callContext;
    final /* synthetic */ vf.d $request;
    final /* synthetic */ long $timeout;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(long j8, CoroutineContext coroutineContext, vf.d dVar, Continuation<? super r> continuation) {
        super(2, continuation);
        this.$timeout = j8;
        this.$callContext = coroutineContext;
        this.$request = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new r(this.$timeout, this.$callContext, this.$request, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            long j8 = this.$timeout;
            this.label = 1;
            if (r0.a(j8, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        l0.g("Request is timed out", new t0(this.$request), l0.k(this.$callContext));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((r) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
