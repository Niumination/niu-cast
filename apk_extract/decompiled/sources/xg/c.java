package xg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;

    public c(Continuation<? super c> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        mg.r rVar = (mg.r) this.L$0;
        zg.a aVar = d.f10934a;
        zg.h hVarI = rVar.i();
        Unit unit = Unit.INSTANCE;
        hVarI.e(aVar, unit);
        return unit;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(mg.q qVar, mg.r rVar, Continuation<? super Unit> continuation) {
        c cVar = new c(continuation);
        cVar.L$0 = rVar;
        return cVar.invokeSuspend(Unit.INSTANCE);
    }
}
