package wb;

import android.os.VibrationEffect;
import android.os.VibratorManager;
import android.widget.Toast;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanViewModel;
import k3.pb;
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
public final class e extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QrScanViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(QrScanViewModel qrScanViewModel, Continuation<? super e> continuation) {
        super(2, continuation);
        this.this$0 = qrScanViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        e eVar = new e(this.this$0, continuation);
        eVar.L$0 = obj;
        return eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        l0.i(((g0) this.L$0).getCoroutineContext());
        Toast.makeText(pb.a(), pb.a().getResources().getString(R$string.qr_scan_not_support), 0).show();
        this.this$0.getClass();
        Object systemService = pb.a().getSystemService("vibrator_manager");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
        ((VibratorManager) systemService).getDefaultVibrator().vibrate(VibrationEffect.createOneShot(50L, -1));
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        ob.b.f8423j = "qr_code_connect";
        bVar.o();
        ag.a aVar = this.this$0.f2811h;
        if (aVar != null) {
            aVar.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((e) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
