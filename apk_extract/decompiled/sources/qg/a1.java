package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 extends SuspendLambda implements Function3 {
    final /* synthetic */ g1 $plugin;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(g1 g1Var, Continuation<? super a1> continuation) {
        super(3, continuation);
        this.$plugin = g1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            mg.r rVar = (mg.r) this.L$0;
            if (Intrinsics.areEqual(m3.k.a(rVar.g()), this.$plugin.f9072a)) {
                g1 g1Var = this.$plugin;
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

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(mg.q qVar, mg.r rVar, Continuation<? super Unit> continuation) {
        a1 a1Var = new a1(this.$plugin, continuation);
        a1Var.L$0 = rVar;
        return a1Var.invokeSuspend(Unit.INSTANCE);
    }
}
