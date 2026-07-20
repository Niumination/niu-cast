package mf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import li.o1;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ vf.d $requestData;
    int label;
    final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, vf.d dVar, Continuation<? super d> continuation) {
        super(2, continuation);
        this.this$0 = fVar;
        this.$requestData = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.this$0, this.$requestData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            p1 p1Var = (p1) this.this$0.getCoroutineContext().get(o1.f7483a);
            if (!(p1Var != null ? p1Var.a() : false)) {
                throw new a(null, 1, null);
            }
            f fVar = this.this$0;
            vf.d dVar = this.$requestData;
            this.label = 1;
            obj = ((nf.e) fVar).a(dVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super vf.g> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
