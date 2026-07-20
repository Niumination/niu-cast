package pi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends SuspendLambda implements Function2 {
    final /* synthetic */ oi.i $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ o this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, oi.i iVar, Continuation<? super n> continuation) {
        super(2, continuation);
        this.this$0 = oVar;
        this.$collector = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        n nVar = new n(this.this$0, this.$collector, continuation);
        nVar.L$0 = obj;
        return nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            g0 g0Var = (g0) this.L$0;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            o oVar = this.this$0;
            oi.h hVar = oVar.f8900d;
            m mVar = new m(objectRef, g0Var, oVar, this.$collector);
            this.label = 1;
            if (hVar.a(mVar, this) == coroutine_suspended) {
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
        return ((n) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
