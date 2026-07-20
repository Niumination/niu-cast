package eb;

import android.util.Log;
import androidx.work.WorkRequest;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 extends SuspendLambda implements Function2 {
    final /* synthetic */ li.j $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(li.j jVar, Continuation<? super f1> continuation) {
        super(2, continuation);
        this.$it = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f1(this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter("findTargetNfcDevice timeout", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PhysicalConnectManager"), "findTargetNfcDevice timeout");
            }
            this.label = 1;
            if (li.r0.a(WorkRequest.MIN_BACKOFF_MILLIS, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        na.a.b(this.$it, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
