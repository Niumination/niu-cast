package se;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class v2 extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;

    public v2(Continuation<? super v2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        v2 v2Var = new v2(continuation);
        v2Var.L$0 = obj;
        return v2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        h0.a.C(((wf.b) this.L$0).h().f11581a, "HTTP status:", "NearLanTcpClient");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(wf.b bVar, Continuation<? super Unit> continuation) {
        return ((v2) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
