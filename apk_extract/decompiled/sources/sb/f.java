package sb;

import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.CapabilitySocketConnected;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CastControlDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(CastControlDialog castControlDialog, Continuation<? super f> continuation) {
        super(2, continuation);
        this.this$0 = castControlDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        f fVar = new f(this.this$0, continuation);
        fVar.L$0 = obj;
        return fVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BaseState baseState, Continuation<? super Unit> continuation) {
        return ((f) create(baseState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (((BaseState) this.L$0).compareTo((BaseState) new CapabilitySocketConnected()) < 0) {
            this.this$0.finish();
        }
        return Unit.INSTANCE;
    }
}
