package pb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ue.P2PConnectService;
import eb.y0;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ P2PConnectService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(P2PConnectService p2PConnectService, Continuation<? super e> continuation) {
        super(2, continuation);
        this.this$0 = p2PConnectService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new e(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int i8 = this.this$0.e;
        if (i8 == 0) {
            y0 y0Var = y0.f4813a;
            y0.d("P2PConnectService");
            y0.f4816d.observeForever(this.this$0.f2687h);
        } else if (i8 != 8) {
            Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
            Intrinsics.checkNotNullParameter("connect:unknown serviceType", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("P2PConnectService"), "connect:unknown serviceType");
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((e) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
