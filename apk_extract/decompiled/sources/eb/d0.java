package eb;

import com.transsion.pcconnect.invoke.bridge.Device;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends SuspendLambda implements Function2 {
    final /* synthetic */ Device $device;
    final /* synthetic */ boolean $enable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(Device device, boolean z2, Continuation<? super d0> continuation) {
        super(2, continuation);
        this.$device = device;
        this.$enable = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d0(this.$device, this.$enable, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (li.r0.a(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        dc.i.f4411a.a(new b0(this.$device, this.$enable, 1));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
