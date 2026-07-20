package zb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import eb.k1;
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
public final class c extends SuspendLambda implements Function2 {
    final /* synthetic */ ScannedDevice $device;
    int label;
    final /* synthetic */ DeviceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(DeviceViewModel deviceViewModel, ScannedDevice scannedDevice, Continuation<? super c> continuation) {
        super(2, continuation);
        this.this$0 = deviceViewModel;
        this.$device = scannedDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(this.this$0, this.$device, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        k1 k1Var = k1.f4765a;
        hc.a aVar = new hc.a();
        ScannedDevice scannedDevice = this.$device;
        aVar.a(scannedDevice.getDeviceMac());
        String devicePID = scannedDevice.getDevicePID();
        Intrinsics.checkNotNullParameter(devicePID, "<set-?>");
        aVar.f5286a = devicePID;
        String deviceName = scannedDevice.getDeviceName();
        Intrinsics.checkNotNullParameter(deviceName, "<set-?>");
        aVar.f5287b = deviceName;
        aVar.f5289d = scannedDevice.getDeviceBrand();
        scannedDevice.getDeviceRssi();
        this.label = 1;
        obj = k1Var.a(aVar, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        hc.b bVar = (hc.b) obj;
        String log = "connect result:" + bVar + " ";
        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DeviceViewModel"), log);
        }
        DeviceViewModel deviceViewModel = this.this$0;
        ScannedDevice scannedDevice2 = this.$device;
        this.label = 2;
        if (DeviceViewModel.a(deviceViewModel, bVar, scannedDevice2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
