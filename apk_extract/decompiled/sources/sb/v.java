package sb;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.QrConnectFailedDialog;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ QrConnectFailedDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(QrConnectFailedDialog qrConnectFailedDialog, Continuation<? super v> continuation) {
        super(2, continuation);
        this.this$0 = qrConnectFailedDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            eb.y yVar = eb.y.f4799a;
            this.label = 1;
            if (eb.y.f4799a.j("retry connect", true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        QrConnectFailedDialog qrConnectFailedDialog = this.this$0;
        Function1 function1 = QrConnectFailedDialog.f2754c;
        qrConnectFailedDialog.getClass();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.transsion.scanningrecharger", "com.transsion.scanningrecharger.view.activity.textrecognized.TextRecognizedActivity"));
        intent.setFlags(268435456);
        if (qrConnectFailedDialog.getIntent().resolveActivity(qrConnectFailedDialog.getPackageManager()) != null) {
            try {
                qrConnectFailedDialog.startActivity(intent);
            } catch (Exception unused) {
                Intrinsics.checkNotNullParameter("EnterSmartScan", "tag");
                Intrinsics.checkNotNullParameter("Failed to launch Smart Scan Activity", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("EnterSmartScan"), "Failed to launch Smart Scan Activity");
                }
            }
        } else {
            Intrinsics.checkNotNullParameter("EnterSmartScan", "tag");
            Intrinsics.checkNotNullParameter("Target Activity not found", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("EnterSmartScan"), "Target Activity not found");
            }
        }
        this.this$0.finishAndRemoveTask();
        Function1 function2 = QrConnectFailedDialog.f2754c;
        if (function2 != null) {
            function2.invoke(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((v) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
