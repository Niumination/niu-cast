package sb;

import android.app.NotificationManager;
import android.util.Log;
import com.transsion.pcconnect.invoke.bridge.Device;
import eb.g0;
import eb.l2;
import eb.y1;
import k3.gc;
import k3.sb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {
    int label;

    public d(Continuation<? super d> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Intrinsics.checkNotNullParameter("InvokeBridgeProvider", "tag");
        Intrinsics.checkNotNullParameter("onDisconnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("InvokeBridgeProvider"), "onDisconnect");
        }
        Device device = g0.f;
        if (device != null) {
            cb.b.c(device, "CONNECT", false, "");
        }
        eb.y yVar = eb.y.f4799a;
        if (sb.b()) {
            l2.j();
        } else {
            y1.e();
        }
        NotificationManager notificationManager = bb.v.f1256a;
        bb.v.a();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
