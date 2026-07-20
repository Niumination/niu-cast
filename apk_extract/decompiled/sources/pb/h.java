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
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends SuspendLambda implements Function2 {
    final /* synthetic */ hc.d $p2PConnectDevice;
    int label;
    final /* synthetic */ P2PConnectService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(P2PConnectService p2PConnectService, hc.d dVar, Continuation<? super h> continuation) {
        super(2, continuation);
        this.this$0 = p2PConnectService;
        this.$p2PConnectDevice = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new h(this.this$0, this.$p2PConnectDevice, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            y0 y0Var = y0.f4813a;
            P2PConnectService p2PConnectService = this.this$0;
            this.label = 1;
            obj = y0.e(p2PConnectService, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            P2PConnectService p2PConnectService2 = this.this$0;
            hc.d dVar = this.$p2PConnectDevice;
            int i9 = P2PConnectService.f2682i;
            p2PConnectService2.getClass();
            p2PConnectService2.f2684b = l0.p(p2PConnectService2.f2683a, null, null, new f(p2PConnectService2, dVar, null), 3);
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
        Intrinsics.checkNotNullParameter("wifi open fail, to fail page", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("P2PConnectService"), "wifi open fail, to fail page");
        }
        P2PConnectService p2PConnectService3 = this.this$0;
        int i10 = P2PConnectService.f2682i;
        p2PConnectService3.getClass();
        y0.b("P2PConnectService connect failed");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((h) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
