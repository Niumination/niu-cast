package db;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.iotcard.PCConnectionProviderService;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.CapabilitySocketConnected;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalDisconnecting;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PCConnectionProviderService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PCConnectionProviderService pCConnectionProviderService, Continuation<? super a> continuation) {
        super(2, continuation);
        this.this$0 = pCConnectionProviderService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        a aVar = new a(this.this$0, continuation);
        aVar.L$0 = obj;
        return aVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BaseState baseState, Continuation<? super Unit> continuation) {
        return ((a) create(baseState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BaseState baseState = (BaseState) this.L$0;
        if (Intrinsics.areEqual(baseState, new CapabilitySocketConnected())) {
            Intrinsics.checkNotNullParameter("PCConnectionProviderService", "tag");
            Intrinsics.checkNotNullParameter("<initListener> CapabilitySocketConnected", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCConnectionProviderService"), "<initListener> CapabilitySocketConnected");
            }
            PCConnectionProviderService pCConnectionProviderService = this.this$0;
            int i8 = PCConnectionProviderService.f2670b;
            pCConnectionProviderService.getClass();
            PCConnectionProviderService.b();
        } else if (Intrinsics.areEqual(baseState, new PhysicalDisconnecting())) {
            Intrinsics.checkNotNullParameter("PCConnectionProviderService", "tag");
            Intrinsics.checkNotNullParameter("<initListener> PhysicalDisconnecting", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCConnectionProviderService"), "<initListener> PhysicalDisconnecting");
            }
            PCConnectionProviderService pCConnectionProviderService2 = this.this$0;
            int i9 = PCConnectionProviderService.f2670b;
            pCConnectionProviderService2.getClass();
            PCConnectionProviderService.c();
        }
        return Unit.INSTANCE;
    }
}
