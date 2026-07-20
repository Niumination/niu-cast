package dc;

import android.content.Context;
import eb.y;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import oi.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends SuspendLambda implements Function2 {
    final /* synthetic */ Function1<Context, Unit> $action;
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Context, Unit> function1, Context context, Continuation<? super f> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f(this.$action, this.$context, continuation);
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
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        y yVar = y.f4799a;
        this.label = 1;
        if (y.f4799a.j("close PadConnect for PCConnect", true, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        g0 g0Var = y.f4806j;
        bf.d dVar = new bf.d(2, this.$action, this.$context);
        this.label = 2;
        g0Var.getClass();
        if (g0.i(g0Var, dVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
