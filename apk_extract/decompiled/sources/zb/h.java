package zb;

import android.util.Log;
import bb.r;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import eb.y;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ DeviceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(DeviceViewModel deviceViewModel, Continuation<? super h> continuation) {
        super(2, continuation);
        this.this$0 = deviceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new h(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
            Intrinsics.checkNotNullParameter("research", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("DeviceViewModel"), "research");
            }
            r rVar = this.this$0.e;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBleScanDataFilterHelper");
                rVar = null;
            }
            ScannedDevice scannedDevice = rVar.f1248j;
            if (scannedDevice != null) {
            }
            DeviceViewModel deviceViewModel = this.this$0;
            deviceViewModel.f2836a = true;
            deviceViewModel.f.postValue(Boxing.boxInt(0));
            y yVar = y.f4799a;
            this.label = 1;
            if (y.f4799a.j("DeviceViewModel research", true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        g2 g2Var = this.this$0.f2847n;
        if (g2Var != null) {
            g2Var.h(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((h) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
