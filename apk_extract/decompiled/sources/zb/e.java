package zb;

import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends SuspendLambda implements Function2 {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DeviceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(DeviceViewModel deviceViewModel, Continuation<? super e> continuation) {
        super(2, continuation);
        this.this$0 = deviceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        e eVar = new e(this.this$0, continuation);
        eVar.Z$0 = ((Boolean) obj).booleanValue();
        return eVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) obj2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.Z$0) {
                ob.b bVar = ob.b.f8417b;
                bVar.getClass();
                Intrinsics.checkNotNullParameter("accept", "conStatus");
                String triggerScene = ob.b.f8418c;
                Intrinsics.checkNotNullParameter("accept", "requestConnectStatus");
                Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
                bVar.f8437a.q("accept", triggerScene);
                return Unit.INSTANCE;
            }
            DeviceViewModel deviceViewModel = this.this$0;
            this.label = 1;
            if (deviceViewModel.d("socketReject", this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(boolean z2, Continuation<? super Unit> continuation) {
        return ((e) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
