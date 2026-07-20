package bb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.helper.PadBaseIconService;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PadBaseIconService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(PadBaseIconService padBaseIconService, Continuation<? super x> continuation) {
        super(2, continuation);
        this.this$0 = padBaseIconService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        x xVar = new x(this.this$0, continuation);
        xVar.L$0 = obj;
        return xVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BaseState baseState, Continuation<? super Unit> continuation) {
        return ((x) create(baseState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String log = "PadConnectManager isConnected changed: " + ((BaseState) this.L$0);
        Intrinsics.checkNotNullParameter("PadBaseIconService", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PadBaseIconService"), log);
        }
        this.this$0.a();
        return Unit.INSTANCE;
    }
}
