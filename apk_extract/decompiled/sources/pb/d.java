package pb;

import android.content.Context;
import com.transsion.iotservice.multiscreen.pc.ue.NFCTouchSelectorActivity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ Function1<Context, Unit> $action;
    int label;
    final /* synthetic */ NFCTouchSelectorActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(NFCTouchSelectorActivity nFCTouchSelectorActivity, Function1<? super Context, Unit> function1, Continuation<? super d> continuation) {
        super(2, continuation);
        this.this$0 = nFCTouchSelectorActivity;
        this.$action = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.this$0, this.$action, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.finish();
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        dc.g gVar = dc.g.f4406a;
        NFCTouchSelectorActivity nFCTouchSelectorActivity = this.this$0;
        Function1<Context, Unit> function1 = this.$action;
        this.label = 1;
        if (gVar.a(0, nFCTouchSelectorActivity, function1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.label = 2;
        if (r0.a(200L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.finish();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
