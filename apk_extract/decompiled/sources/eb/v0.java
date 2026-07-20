package eb;

import androidx.lifecycle.Observer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends SuspendLambda implements Function2 {
    final /* synthetic */ Observer<Boolean> $wifiStateObserver;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(Observer<Boolean> observer, Continuation<? super v0> continuation) {
        super(2, continuation);
        this.$wifiStateObserver = observer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v0(this.$wifiStateObserver, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        y0.f4819i.observeForever(this.$wifiStateObserver);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((v0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
