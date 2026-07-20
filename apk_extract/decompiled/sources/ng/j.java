package ng;

import ag.o0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(p pVar, Continuation<? super j> continuation) {
        super(3, continuation);
        this.this$0 = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            og.k kVar = (og.k) this.L$0;
            o0 o0Var = (o0) this.L$1;
            p pVar = this.this$0;
            this.L$0 = null;
            this.label = 1;
            Object objU = l0.u(pVar.f8265h, new f(pVar, o0Var, kVar, null), this);
            if (objU != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objU = Unit.INSTANCE;
            }
            if (objU == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(og.k kVar, o0 o0Var, Continuation<? super Unit> continuation) {
        j jVar = new j(this.this$0, continuation);
        jVar.L$0 = kVar;
        jVar.L$1 = o0Var;
        return jVar.invokeSuspend(Unit.INSTANCE);
    }
}
