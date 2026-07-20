package mg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends SuspendLambda implements Function4 {
    final /* synthetic */ Function4<g, r, Object, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public w(Function4<g, ? super r, Object, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super w> continuation) {
        super(4, continuation);
        this.$block = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            g gVar = (g) this.L$0;
            r rVar = (r) this.L$1;
            Object obj2 = this.L$2;
            Function4<g, r, Object, Continuation<? super Unit>, Object> function4 = this.$block;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (function4.invoke(gVar, rVar, obj2, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(g gVar, r rVar, Object obj, Continuation<? super Unit> continuation) {
        w wVar = new w(this.$block, continuation);
        wVar.L$0 = gVar;
        wVar.L$1 = rVar;
        wVar.L$2 = obj;
        return wVar.invokeSuspend(Unit.INSTANCE);
    }
}
