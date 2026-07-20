package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends SuspendLambda implements Function3 {
    final /* synthetic */ g1 $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(g1 g1Var, Continuation<? super c1> continuation) {
        super(3, continuation);
        this.$plugin = g1Var;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Unit unit, Continuation<? super Unit> continuation) {
        c1 c1Var = new c1(this.$plugin, continuation);
        c1Var.L$0 = fVar;
        return c1Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            if (Intrinsics.areEqual(m3.k.a(((mg.r) fVar.f5401a).g()), this.$plugin.f9072a)) {
                g1 g1Var = this.$plugin;
                mg.r rVar = (mg.r) fVar.f5401a;
                this.label = 1;
                if (g1Var.a(rVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
