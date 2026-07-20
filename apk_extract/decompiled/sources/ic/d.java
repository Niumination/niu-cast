package ic;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import li.g0;
import li.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ li.j $it;
    final /* synthetic */ Ref.ObjectRef<hc.b> $result;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Ref.ObjectRef<hc.b> objectRef, li.j jVar, Continuation<? super d> continuation) {
        super(2, continuation);
        this.$result = objectRef;
        this.$it = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.$result, this.$it, continuation);
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [T, hc.b] */
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
        Intrinsics.checkNotNullParameter("BLEConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("connect timeout", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BLEConnectHelper"), "connect timeout");
        }
        this.$result.element = new hc.b(false, "timeout", null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_CURVE_FIT);
        na.a.b(this.$it, this.$result.element);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
