package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public d(Continuation<? super d> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        vf.c cVar = (vf.c) this.L$0;
        o.d.y(cVar.f.d(f.f8840a));
        return null;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(vf.c cVar, cg.j jVar, Continuation<? super cg.j> continuation) {
        d dVar = new d(continuation);
        dVar.L$0 = cVar;
        dVar.L$1 = jVar;
        return dVar.invokeSuspend(Unit.INSTANCE);
    }
}
