package sb;

import bf.b0;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import oi.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ CastControlDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(CastControlDialog castControlDialog, Continuation<? super i> continuation) {
        super(2, continuation);
        this.this$0 = castControlDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            CastControlViewModel castControlViewModel = this.this$0.f2712k;
            if (castControlViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                castControlViewModel = null;
            }
            oi.z zVar = castControlViewModel.f2720d;
            b0 b0Var = new b0(this.this$0, 1);
            this.label = 1;
            if (g0.i(zVar.f8564a, b0Var, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((i) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
