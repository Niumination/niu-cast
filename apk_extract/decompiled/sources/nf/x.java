package nf;

import jh.g0;
import jh.j0;
import jh.w0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends SuspendLambda implements Function2 {
    final /* synthetic */ j0 $this_withoutClosePropagation;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(j0 j0Var, Continuation<? super x> continuation) {
        super(2, continuation);
        this.$this_withoutClosePropagation = j0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        x xVar = new x(this.$this_withoutClosePropagation, continuation);
        xVar.L$0 = obj;
        return xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        jh.o oVar = ((w0) this.L$0).f6308a;
        j0 j0Var = this.$this_withoutClosePropagation;
        this.label = 1;
        if (g0.c(oVar, j0Var, Long.MAX_VALUE, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        j0 j0Var2 = this.$this_withoutClosePropagation;
        this.label = 2;
        if (((jh.k) j0Var2).h(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(w0 w0Var, Continuation<? super Unit> continuation) {
        return ((x) create(w0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
