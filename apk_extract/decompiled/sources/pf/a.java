package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends SuspendLambda implements Function3 {
    final /* synthetic */ Function2<wf.b, Continuation<? super wf.b>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(Function2<? super wf.b, ? super Continuation<? super wf.b>, ? extends Object> function2, Continuation<? super a> continuation) {
        super(3, continuation);
        this.$handler = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, wf.b bVar, Continuation<? super Unit> continuation) {
        a aVar = new a(this.$handler, continuation);
        aVar.L$0 = fVar;
        aVar.L$1 = bVar;
        return aVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        hh.f fVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                fVar = (hh.f) this.L$0;
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
        fVar = (hh.f) this.L$0;
        wf.b bVar = (wf.b) this.L$1;
        Function2<wf.b, Continuation<? super wf.b>, Object> function2 = this.$handler;
        this.L$0 = fVar;
        this.label = 1;
        obj = function2.invoke(bVar, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        wf.b bVar2 = (wf.b) obj;
        if (bVar2 != null) {
            this.L$0 = null;
            this.label = 2;
            if (fVar.f(bVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
