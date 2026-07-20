package wb;

import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.a2;
import li.g0;
import li.l0;
import li.r0;
import li.v0;
import qi.r;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ QrScanViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(QrScanViewModel qrScanViewModel, Continuation<? super f> continuation) {
        super(2, continuation);
        this.this$0 = qrScanViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f(this.this$0, continuation);
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
        this.label = 1;
        if (r0.a(100L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        v0 v0Var = v0.f7498a;
        a2 a2Var = r.f9163a;
        e eVar = new e(this.this$0, null);
        this.label = 2;
        if (l0.u(a2Var, eVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
