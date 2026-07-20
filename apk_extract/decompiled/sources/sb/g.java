package sb;

import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import oi.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ CastControlDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(CastControlDialog castControlDialog, Continuation<? super g> continuation) {
        super(2, continuation);
        this.this$0 = castControlDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            g0 g0Var = eb.y.f4806j;
            f fVar = new f(this.this$0, null);
            this.label = 1;
            if (oi.j.e(g0Var, fVar, this) == coroutine_suspended) {
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
        return ((g) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
