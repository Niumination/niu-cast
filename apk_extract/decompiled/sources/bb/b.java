package bb;

import android.content.Context;
import com.transsion.iotservice.multiscreen.pc.helper.BaseIconService;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SuspendLambda implements Function2 {
    final /* synthetic */ Function1<Context, Unit> $action;
    int label;
    final /* synthetic */ BaseIconService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(BaseIconService baseIconService, Function1<? super Context, Unit> function1, Continuation<? super b> continuation) {
        super(2, continuation);
        this.this$0 = baseIconService;
        this.$action = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.this$0, this.$action, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            dc.g gVar = dc.g.f4406a;
            this.this$0.getClass();
            BaseIconService baseIconService = this.this$0;
            Function1<Context, Unit> function1 = this.$action;
            this.label = 1;
            if (gVar.a(0, baseIconService, function1, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
