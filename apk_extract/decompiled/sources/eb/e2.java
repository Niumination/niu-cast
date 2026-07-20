package eb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpRequestConnectBean;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 extends SuspendLambda implements Function2 {
    final /* synthetic */ TccpRequestConnectBean $tccpRequestConnectBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(TccpRequestConnectBean tccpRequestConnectBean, Continuation<? super e2> continuation) {
        super(2, continuation);
        this.$tccpRequestConnectBean = tccpRequestConnectBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new e2(this.$tccpRequestConnectBean, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
            l2.k(this.$tccpRequestConnectBean.getDeviceName(), this.$tccpRequestConnectBean.getMac());
            this.label = 1;
            String strO = o.d.o("gotoCastScreen send response accept:", true, "SocketServerManager", "tag", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), strO);
            }
            Object objU = li.l0.u(li.v0.f7499b, new b2(true, false, null), this);
            if (objU != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objU = Unit.INSTANCE;
            }
            if (objU == coroutine_suspended) {
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
        return ((e2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
