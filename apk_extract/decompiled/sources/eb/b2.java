package eb;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.provider.Settings;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpResponseConnectBean;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $accept;
    final /* synthetic */ boolean $isRemember;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(boolean z2, boolean z3, Continuation<? super b2> continuation) {
        super(2, continuation);
        this.$accept = z2;
        this.$isRemember = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b2(this.$accept, this.$isRemember, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
            if (tCCPHandshakeSocketServer != null) {
                byte[] scan_confirm_flag = TccpConfig.INSTANCE.getSCAN_CONFIRM_FLAG();
                boolean z2 = this.$accept;
                boolean z3 = this.$isRemember;
                String BRAND = Build.BRAND;
                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                String string = Settings.Global.getString(pb.a().getContentResolver(), "device_name");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                tCCPHandshakeSocketServer.sendResponse(scan_confirm_flag, new TccpResponseConnectBean(z2 ? 1 : 0, z3, 0, BRAND, string, BluetoothAdapter.getDefaultAdapter().getAddress()));
            }
            if (!this.$accept) {
                this.label = 1;
                if (li.r0.a(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i8 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = l2.f4772a;
        l2.i(false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
