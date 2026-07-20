package lg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.l0;
import li.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, Continuation<? super b> continuation) {
        super(2, continuation);
        this.this$0 = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[RETURN] */
    /* JADX WARN: Type inference failed for: r10v15, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long jLongValue;
        ?? r10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0 || i8 == 1) {
                ResultKt.throwOnFailure(obj);
                do {
                    if (this.this$0.isStarted == 0) {
                        c cVar = this.this$0;
                        cVar.lastActivityTime = ((Number) cVar.f7425b.invoke()).longValue();
                    }
                    long j8 = this.this$0.lastActivityTime;
                    c cVar2 = this.this$0;
                    jLongValue = (j8 + cVar2.f7424a) - ((Number) cVar2.f7425b.invoke()).longValue();
                    if (jLongValue > 0 || this.this$0.isStarted == 0) {
                        this.label = 1;
                    } else {
                        this.label = 2;
                        if (l0.v(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r10 = this.this$0.f7426c;
                        this.label = 3;
                        if (r10.invoke(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } while (r0.a(jLongValue, this) != coroutine_suspended);
                return coroutine_suspended;
            }
            if (i8 == 2) {
                ResultKt.throwOnFailure(obj);
                r10 = this.this$0.f7426c;
                this.label = 3;
                if (r10.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable unused) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
