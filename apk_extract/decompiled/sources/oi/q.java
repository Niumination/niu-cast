package oi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends SuspendLambda implements Function2 {
    final /* synthetic */ h $this_debounceInternal;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(h hVar, Continuation<? super q> continuation) {
        super(2, continuation);
        this.$this_debounceInternal = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        q qVar = new q(this.$this_debounceInternal, continuation);
        qVar.L$0 = obj;
        return qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            ni.d0 d0Var = (ni.d0) this.L$0;
            h hVar = this.$this_debounceInternal;
            p pVar = new p(d0Var);
            this.label = 1;
            if (hVar.a(pVar, this) == coroutine_suspended) {
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
    public final Object invoke(ni.d0 d0Var, Continuation<? super Unit> continuation) {
        return ((q) create(d0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
