package pi;

import k3.bc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.j0;
import ni.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends SuspendLambda implements Function2 {
    final /* synthetic */ oi.i $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(oi.i iVar, g gVar, Continuation<? super e> continuation) {
        super(2, continuation);
        this.$collector = iVar;
        this.this$0 = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        e eVar = new e(this.$collector, this.this$0, continuation);
        eVar.L$0 = obj;
        return eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            g0 g0Var = (g0) this.L$0;
            oi.i iVar = this.$collector;
            g gVar = this.this$0;
            int i9 = gVar.f8898b;
            if (i9 == -3) {
                i9 = -2;
            }
            j0 j0Var = j0.ATOMIC;
            f fVar = new f(gVar, null);
            c0 c0Var = new c0(li.y.b(g0Var, gVar.f8897a), bc.a(i9, 4, gVar.f8899c), true, true);
            j0Var.invoke(fVar, c0Var, c0Var);
            this.label = 1;
            Object objF = oi.j.f(iVar, c0Var, true, this);
            if (objF != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objF = Unit.INSTANCE;
            }
            if (objF == coroutine_suspended) {
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
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((e) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
