package yb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.state.MainSocketConnected;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnected;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.WaitAcceptFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends SuspendLambda implements Function2 {
    final /* synthetic */ Ref.BooleanRef $connected;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WaitAcceptFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(WaitAcceptFragment waitAcceptFragment, Ref.BooleanRef booleanRef, Continuation<? super h> continuation) {
        super(2, continuation);
        this.this$0 = waitAcceptFragment;
        this.$connected = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h hVar = new h(this.this$0, this.$connected, continuation);
        hVar.L$0 = obj;
        return hVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BaseState baseState, Continuation<? super Unit> continuation) {
        return ((h) create(baseState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BaseState baseState = (BaseState) this.L$0;
        if (Intrinsics.areEqual(baseState, new MainSocketConnected())) {
            DeviceViewModel deviceViewModelE = this.this$0.e();
            deviceViewModelE.getClass();
            Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
            Intrinsics.checkNotNullParameter("setConnectingState", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("DeviceViewModel"), "setConnectingState");
            }
            deviceViewModelE.f.postValue(2);
        } else if (Intrinsics.areEqual(baseState, new Initial()) && this.$connected.element) {
            this.this$0.e().f();
        } else if (Intrinsics.areEqual(baseState, new PhysicalConnected())) {
            this.$connected.element = true;
        }
        return Unit.INSTANCE;
    }
}
