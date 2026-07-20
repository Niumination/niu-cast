package yb;

import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.WaitAcceptFragment;
import eb.y;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import oi.g0;
import oi.j;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ WaitAcceptFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(WaitAcceptFragment waitAcceptFragment, Continuation<? super i> continuation) {
        super(2, continuation);
        this.this$0 = waitAcceptFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            g0 g0Var = y.f4806j;
            h hVar = new h(this.this$0, booleanRef, null);
            this.label = 1;
            if (j.e(g0Var, hVar, this) == coroutine_suspended) {
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
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((i) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
