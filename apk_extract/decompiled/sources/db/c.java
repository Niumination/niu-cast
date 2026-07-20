package db;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.CapabilitySocketConnected;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;

    public c(Continuation<? super c> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        c cVar = new c(continuation);
        cVar.L$0 = obj;
        return cVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BaseState baseState, Continuation<? super Unit> continuation) {
        return ((c) create(baseState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual((BaseState) this.L$0, new CapabilitySocketConnected())) {
            Intrinsics.checkNotNullParameter("PCIotCardManager", "tag");
            Intrinsics.checkNotNullParameter("<initListener> CapabilitySocketConnected", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCIotCardManager"), "<initListener> CapabilitySocketConnected");
            }
            f.b();
        } else {
            Intrinsics.checkNotNullParameter("PCIotCardManager", "tag");
            Intrinsics.checkNotNullParameter("<initListener> unregister", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCIotCardManager"), "<initListener> unregister");
            }
            f.c();
        }
        return Unit.INSTANCE;
    }
}
