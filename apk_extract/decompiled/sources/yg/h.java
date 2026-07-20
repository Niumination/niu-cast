package yg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import oh.s0;
import xg.s;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends SuspendLambda implements Function2 {
    final /* synthetic */ s $$this$handle;
    final /* synthetic */ Function2<l, Continuation<? super Unit>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(Function2<? super l, ? super Continuation<? super Unit>, ? extends Object> function2, s sVar, Continuation<? super h> continuation) {
        super(2, continuation);
        this.$handler = function2;
        this.$$this$handle = sVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h hVar = new h(this.$handler, this.$$this$handle, continuation);
        hVar.L$0 = obj;
        return hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            s0 s0Var = (s0) this.L$0;
            Function2<l, Continuation<? super Unit>, Object> function2 = this.$handler;
            xg.r call = this.$$this$handle.f10988a;
            Intrinsics.checkNotNullParameter(s0Var, "<this>");
            Intrinsics.checkNotNullParameter(call, "call");
            c cVar = new c(call, s0Var);
            this.label = 1;
            if (function2.invoke(cVar, this) == coroutine_suspended) {
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
    public final Object invoke(s0 s0Var, Continuation<? super Unit> continuation) {
        return ((h) create(s0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
