package wb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrConnectActivity;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrConnectViewModel;
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
public final class b extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ QrConnectActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(QrConnectActivity qrConnectActivity, Continuation<? super b> continuation) {
        super(2, continuation);
        this.this$0 = qrConnectActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter("QrConnectActivity", "tag");
            Intrinsics.checkNotNullParameter("connectWithPermissionCheck: requestConnectivityPermission", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("QrConnectActivity"), "connectWithPermissionCheck: requestConnectivityPermission");
            }
            QrConnectViewModel qrConnectViewModel = this.this$0.f2798b;
            if (qrConnectViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQrConnectVM");
                qrConnectViewModel = null;
            }
            this.label = 1;
            if (qrConnectViewModel.b(this) == coroutine_suspended) {
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
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
