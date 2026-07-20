package yb;

import androidx.lifecycle.ViewModelKt;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SuspendLambda implements Function2 {
    final /* synthetic */ Function0<Unit> $researchEvent;
    int label;
    final /* synthetic */ BaseSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BaseSearchFragment baseSearchFragment, Function0<Unit> function0, Continuation<? super a> continuation) {
        super(2, continuation);
        this.this$0 = baseSearchFragment;
        this.$researchEvent = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(this.this$0, this.$researchEvent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        DeviceViewModel deviceViewModelE = this.this$0.e();
        deviceViewModelE.getClass();
        l0.p(ViewModelKt.getViewModelScope(deviceViewModelE), null, null, new zb.h(deviceViewModelE, null), 3);
        Function0<Unit> function0 = this.$researchEvent;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
