package mg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends SuspendLambda implements Function4 {
    final /* synthetic */ Function3<q, r, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public v(Function3<? super q, ? super r, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super v> continuation) {
        super(4, continuation);
        this.$block = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            q qVar = (q) this.L$0;
            r rVar = (r) this.L$1;
            Function3<q, r, Continuation<? super Unit>, Object> function3 = this.$block;
            this.L$0 = null;
            this.label = 1;
            if (function3.invoke(qVar, rVar, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(q qVar, r rVar, Unit unit, Continuation<? super Unit> continuation) {
        v vVar = new v(this.$block, continuation);
        vVar.L$0 = qVar;
        vVar.L$1 = rVar;
        return vVar.invokeSuspend(Unit.INSTANCE);
    }
}
