package eb;

import com.transsion.iotservice.scan.bean.ScannedDevice;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 extends SuspendLambda implements Function2 {
    final /* synthetic */ li.j $it;
    final /* synthetic */ Function1<ScannedDevice, Unit> $scanCallback;
    final /* synthetic */ li.p1 $timeoutJob;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d1(Function1<? super ScannedDevice, Unit> function1, li.j jVar, li.p1 p1Var, Continuation<? super d1> continuation) {
        super(2, continuation);
        this.$scanCallback = function1;
        this.$it = jVar;
        this.$timeoutJob = p1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d1(this.$scanCallback, this.$it, this.$timeoutJob, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            y yVar = y.f4799a;
            Function1<ScannedDevice, Unit> function1 = this.$scanCallback;
            this.label = 1;
            obj = yVar.p(function1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        na.a.b(this.$it, null);
        this.$timeoutJob.h(null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
