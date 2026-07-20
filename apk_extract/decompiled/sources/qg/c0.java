package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends SuspendLambda implements Function2 {
    final /* synthetic */ zf.e0 $this_build;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(zf.e0 e0Var, Continuation<? super c0> continuation) {
        super(2, continuation);
        this.$this_build = e0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        c0 c0Var = new c0(this.$this_build, continuation);
        c0Var.L$0 = obj;
        return c0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(cg.n nVar, Continuation<? super Unit> continuation) {
        return ((c0) create(nVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        cg.n nVar = (cg.n) this.L$0;
        if (nVar instanceof cg.m) {
            zf.e eVar = (zf.e) nVar.f1680c.getValue();
            String strH = eVar != null ? eVar.h("name") : null;
            if (strH != null) {
                this.$this_build.d(strH, ((cg.m) nVar).e);
            }
        }
        nVar.f1678a.invoke();
        return Unit.INSTANCE;
    }
}
