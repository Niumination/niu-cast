package bf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends SuspendLambda implements Function2 {
    final /* synthetic */ ze.j $clientCall;
    final /* synthetic */ t $readiness;
    final /* synthetic */ g $request;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(g gVar, ze.j jVar, t tVar, Continuation<? super k> continuation) {
        super(2, continuation);
        this.$request = gVar;
        this.$clientCall = jVar;
        this.$readiness = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new k(this.$request, this.$clientCall, this.$readiness, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                g gVar = this.$request;
                ze.j jVar = this.$clientCall;
                t tVar = this.$readiness;
                this.label = 1;
                if (gVar.a(jVar, tVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$clientCall.b();
            return Unit.INSTANCE;
        } catch (Exception e) {
            this.$clientCall.a("Collection of requests completed exceptionally", e);
            throw e;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((k) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
