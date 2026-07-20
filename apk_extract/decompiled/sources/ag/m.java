package ag;

import jh.w0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends SuspendLambda implements Function2 {
    final /* synthetic */ jh.j0 $output;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(jh.j0 j0Var, Continuation<? super m> continuation) {
        super(2, continuation);
        this.$output = j0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m mVar = new m(this.$output, continuation);
        mVar.L$0 = obj;
        return mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            w0 w0Var = (w0) this.L$0;
            jh.j0 j0Var = this.$output;
            jh.o oVar = w0Var.f6308a;
            this.label = 1;
            if (p.c(oVar, j0Var, this) == coroutine_suspended) {
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
    public final Object invoke(w0 w0Var, Continuation<? super Unit> continuation) {
        return ((m) create(w0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
