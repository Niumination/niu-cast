package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends SuspendLambda implements Function2 {
    final /* synthetic */ li.p1 $executionContext;
    final /* synthetic */ vf.c $request;
    final /* synthetic */ Long $requestTimeout;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(Long l4, vf.c cVar, li.p1 p1Var, Continuation<? super c1> continuation) {
        super(2, continuation);
        this.$requestTimeout = l4;
        this.$request = cVar;
        this.$executionContext = p1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c1(this.$requestTimeout, this.$request, this.$executionContext, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            long jLongValue = this.$requestTimeout.longValue();
            this.label = 1;
            if (li.r0.a(jLongValue, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        t0 t0Var = new t0(this.$request);
        e1.f8838a.trace("Request timeout: " + this.$request.f10557a);
        li.p1 p1Var = this.$executionContext;
        String message = t0Var.getMessage();
        Intrinsics.checkNotNull(message);
        li.l0.g(message, t0Var, p1Var);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
