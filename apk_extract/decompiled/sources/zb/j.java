package zb;

import bb.r;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends SuspendLambda implements Function2 {
    final /* synthetic */ ScannedDevice $scannedDevice;
    int label;
    final /* synthetic */ DeviceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(DeviceViewModel deviceViewModel, ScannedDevice scannedDevice, Continuation<? super j> continuation) {
        super(2, continuation);
        this.this$0 = deviceViewModel;
        this.$scannedDevice = scannedDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j(this.this$0, this.$scannedDevice, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            r rVar = this.this$0.e;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBleScanDataFilterHelper");
                rVar = null;
            }
            ScannedDevice scannedDevice = this.$scannedDevice;
            this.label = 1;
            if (rVar.a(scannedDevice, this) == coroutine_suspended) {
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
        return ((j) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
