package pb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ue.P2PConnectService;
import eb.k1;
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
public final class g extends SuspendLambda implements Function2 {
    final /* synthetic */ hc.a $bleConnectDevice;
    int label;
    final /* synthetic */ P2PConnectService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(P2PConnectService p2PConnectService, hc.a aVar, Continuation<? super g> continuation) {
        super(2, continuation);
        this.this$0 = p2PConnectService;
        this.$bleConnectDevice = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g(this.this$0, this.$bleConnectDevice, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!((hc.b) obj).f5279a) {
                P2PConnectService p2PConnectService = this.this$0;
                int i9 = P2PConnectService.f2682i;
                p2PConnectService.getClass();
                y0.b("P2PConnectService connect failed");
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        y0 y0Var = y0.f4813a;
        P2PConnectService p2PConnectService2 = this.this$0;
        this.label = 1;
        obj = y0.f4813a.a(p2PConnectService2, true, true, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj).booleanValue()) {
            Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
            Intrinsics.checkNotNullParameter("connectWithOldDataFormat:checkEnvironment fail", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("P2PConnectService"), "connectWithOldDataFormat:checkEnvironment fail");
            }
            y0.b("P2PConnectService");
            return Unit.INSTANCE;
        }
        k1 k1Var = k1.f4765a;
        hc.a aVar = this.$bleConnectDevice;
        this.label = 2;
        obj = k1Var.b(aVar, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((hc.b) obj).f5279a) {
            P2PConnectService p2PConnectService3 = this.this$0;
            int i10 = P2PConnectService.f2682i;
            p2PConnectService3.getClass();
            y0.b("P2PConnectService connect failed");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((g) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
