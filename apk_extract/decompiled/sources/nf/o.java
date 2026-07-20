package nf;

import java.util.TimeZone;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, Continuation<? super o> continuation) {
        super(2, continuation);
        this.this$0 = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new o(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        p pVar;
        long jCurrentTimeMillis;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable unused) {
                this.this$0.f8228j.q(null);
                pVar = this.this$0;
            }
        }
        do {
            long j8 = this.this$0.lastActivity + this.this$0.f8229k;
            TimeZone timeZone = ch.a.f1686a;
            jCurrentTimeMillis = j8 - System.currentTimeMillis();
            if (jCurrentTimeMillis <= 0) {
                this.this$0.f8228j.q(null);
                pVar = this.this$0;
                pVar.f8227i.invoke();
                return Unit.INSTANCE;
            }
            this.label = 1;
        } while (r0.a(jCurrentTimeMillis, this) != coroutine_suspended);
        return coroutine_suspended;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((o) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
