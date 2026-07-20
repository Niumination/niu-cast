package yg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;

    public o(Continuation<? super o> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        o oVar = new o(continuation);
        oVar.L$0 = obj;
        return oVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return !(this.L$0 instanceof n) ? Unit.INSTANCE : Unit.INSTANCE;
    }
}
