package nf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends SuspendLambda implements Function2 {
    final /* synthetic */ jh.o $input;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(jh.o oVar, Continuation<? super m> continuation) {
        super(2, continuation);
        this.$input = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new m(this.$input, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            jh.o oVar = this.$input;
            this.label = 1;
            obj = oVar.e(1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Boolean> continuation) {
        return ((m) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
