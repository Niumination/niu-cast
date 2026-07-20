package bf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.l0;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends SuspendLambda implements Function2 {
    final /* synthetic */ ze.j $clientCall;
    final /* synthetic */ Exception $e;
    final /* synthetic */ p1 $sender;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(p1 p1Var, Exception exc, ze.j jVar, Continuation<? super i> continuation) {
        super(2, continuation);
        this.$sender = p1Var;
        this.$e = exc;
        this.$clientCall = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i(this.$sender, this.$e, this.$clientCall, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            p1 p1Var = this.$sender;
            Exception exc = this.$e;
            this.label = 1;
            l0.g("Collection of responses completed exceptionally", exc, p1Var);
            Object objS = p1Var.S(this);
            if (objS != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objS = Unit.INSTANCE;
            }
            if (objS == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$clientCall.a("Collection of responses completed exceptionally", this.$e);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((i) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
