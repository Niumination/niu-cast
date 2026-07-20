package eb;

import android.util.Log;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function1<ScannedDevice, Unit> $scanResultCallback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public n1(Function1<? super ScannedDevice, Unit> function1, Continuation<? super n1> continuation) {
        super(2, continuation);
        this.$scanResultCallback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new n1(this.$scanResultCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter("ScanManager", "tag");
            Intrinsics.checkNotNullParameter("startScan", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("ScanManager"), "startScan");
            }
            kc.b bVar = o1.f4783b;
            Function1<ScannedDevice, Unit> function1 = this.$scanResultCallback;
            this.label = 1;
            if (bVar.a(1, function1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        o1.e = true;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((n1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
