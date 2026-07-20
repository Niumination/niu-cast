package eb;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.DialogUtilActivity;
import k3.gc;
import k3.pb;
import k3.sb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $isVideo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(boolean z2, Continuation<? super x> continuation) {
        super(2, continuation);
        this.$isVideo = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new x(this.$isVideo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            long j8 = y.e;
            this.label = 1;
            if (li.r0.a(j8, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String strO = o.d.o("updateVideoState:", this.$isVideo, "ConnectionManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), strO);
        }
        y.f4807k.postValue(Boxing.boxBoolean(this.$isVideo));
        cb.b.a(this.$isVideo);
        if (sb.b() && this.$isVideo && y.f == 6) {
            boolean z2 = DialogUtilActivity.f2733j;
            Application context = pb.a();
            Intrinsics.checkNotNullParameter(context, "context");
            String log = "goToWifiTipDialog : sIsAnotherDeviceWifi24GHz: " + DialogUtilActivity.f2734k + ", PhoneUtil.isWifi24GHz(context): " + sb.c(context) + ", sIsDialogShow: " + DialogUtilActivity.f2733j;
            Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("DialogUtilActivity"), log);
            }
            if ((DialogUtilActivity.f2734k || sb.c(context)) && !DialogUtilActivity.f2733j) {
                DialogUtilActivity.f2733j = true;
                Intent intent = new Intent(context, (Class<?>) DialogUtilActivity.class);
                intent.putExtra("DialogType", 2);
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((x) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
