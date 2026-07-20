package eb;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpSwitchSdkInitPortBean;
import k3.gc;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 extends SuspendLambda implements Function2 {
    final /* synthetic */ TccpSwitchSdkInitPortBean $payload;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(TccpSwitchSdkInitPortBean tccpSwitchSdkInitPortBean, Continuation<? super u1> continuation) {
        super(2, continuation);
        this.$payload = tccpSwitchSdkInitPortBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new u1(this.$payload, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
            this.label = 1;
            obj = x7.f.e(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!((Boolean) obj).booleanValue()) {
            Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
            Intrinsics.checkNotNullParameter("Connect source-server fail", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("SocketClientManager"), "Connect source-server fail");
            }
            return Unit.INSTANCE;
        }
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient = y1.f4826a;
        x7.f.g(new q5.a());
        x7.i iVar = x7.i.f10886a;
        x7.i.d(y1.f4832i);
        x7.i.c(y1.f4833j);
        String packageName = pb.a().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        x7.i.e(packageName, new se.d());
        String ip = k1.f4767c;
        int port = this.$payload.getPort();
        Intrinsics.checkNotNullParameter(ip, "ip");
        String log = "setTCCPInfo:" + ip + ":" + port;
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), log);
        }
        x7.f.f10882a.connectTccpServer(ip, port);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((u1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
