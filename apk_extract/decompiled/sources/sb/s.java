package sb;

import androidx.work.WorkRequest;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ PcRequestConnectViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PcRequestConnectViewModel pcRequestConnectViewModel, Continuation<? super s> continuation) {
        super(2, continuation);
        this.this$0 = pcRequestConnectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new s(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (r0.a(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.c();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((s) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
