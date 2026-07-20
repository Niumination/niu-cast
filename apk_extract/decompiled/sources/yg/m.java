package yg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.h0;
import li.l0;
import oh.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends SuspendLambda implements Function2 {
    final /* synthetic */ s0 $webSocket;
    int label;
    final /* synthetic */ n this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, s0 s0Var, Continuation<? super m> continuation) {
        super(2, continuation);
        this.this$0 = nVar;
        this.$webSocket = s0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new m(this.this$0, this.$webSocket, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
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
            h hVar = this.this$0.f11209a;
            s0 s0Var = this.$webSocket;
            this.label = 1;
            if (hVar.invoke(s0Var, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            s0 s0Var2 = this.$webSocket;
            this.label = 2;
            if (s0Var2.l(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (Throwable th2) {
            try {
                h0.b(this.$webSocket, l0.a("WebSocket is cancelled", th2));
            } finally {
                h0.b(this.$webSocket, null);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((m) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
