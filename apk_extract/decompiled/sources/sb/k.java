package sb;

import androidx.lifecycle.FlowLiveDataConversions;
import bf.b0;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import k3.bd;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.h2;
import oi.i0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ CastControlViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(CastControlViewModel castControlViewModel, Continuation<? super k> continuation) {
        super(2, continuation);
        this.this$0 = castControlViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new k(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            oi.h hVarAsFlow = FlowLiveDataConversions.asFlow(eb.y.f4808l);
            if (!(hVarAsFlow instanceof i0)) {
                if (hVarAsFlow instanceof oi.g) {
                    ((oi.g) hVarAsFlow).getClass();
                } else {
                    hVarAsFlow = new oi.g(hVarAsFlow);
                }
            }
            oi.r rVar = new oi.r(new ag.b(20), hVarAsFlow, null);
            b0 b0Var = new b0(this.this$0, 2);
            this.label = 1;
            pi.r rVar2 = new pi.r(rVar, b0Var, null);
            h2 h2Var = new h2(get$context(), this, 1);
            Object objA = bd.a(h2Var, h2Var, rVar2);
            if (objA == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (objA != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objA = Unit.INSTANCE;
            }
            if (objA == coroutine_suspended) {
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
        return ((k) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
