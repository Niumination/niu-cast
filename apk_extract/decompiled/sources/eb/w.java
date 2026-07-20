package eb;

import android.util.Log;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $isExtend;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(boolean z2, Continuation<? super w> continuation) {
        super(2, continuation);
        this.$isExtend = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new w(this.$isExtend, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            long j8 = y.e;
            this.label = 1;
            if (li.r0.a(j8, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String strO = o.d.o("updateExtendState:", this.$isExtend, "ConnectionManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectionManager"), strO);
        }
        y.f4809m.postValue(Boxing.boxBoolean(this.$isExtend));
        cb.b.b(this.$isExtend);
        boolean zAreEqual = Intrinsics.areEqual(y.f4807k.getValue(), Boxing.boxBoolean(true));
        if (!this.$isExtend && !zAreEqual) {
            ob.b.f8417b.l("tcircle_turn_off");
        }
        if (!this.$isExtend && zAreEqual) {
            ob.b.f8417b.l("tcircle_enable_mirror");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((w) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
