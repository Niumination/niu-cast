package pf;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends SuspendLambda implements Function3 {
    final /* synthetic */ List<Function2<wf.b, Continuation<? super Unit>, Object>> $responseValidators;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public x(List<? extends Function2<? super wf.b, ? super Continuation<? super Unit>, ? extends Object>> list, Continuation<? super x> continuation) {
        super(3, continuation);
        this.$responseValidators = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            qf.f fVar = (qf.f) this.L$0;
            vf.c cVar = (vf.c) this.L$1;
            this.L$0 = null;
            this.label = 1;
            obj = fVar.f9056a.a(cVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kf.c cVar2 = (kf.c) this.L$0;
                ResultKt.throwOnFailure(obj);
                return cVar2;
            }
            ResultKt.throwOnFailure(obj);
        }
        kf.c cVar3 = (kf.c) obj;
        List<Function2<wf.b, Continuation<? super Unit>, Object>> list = this.$responseValidators;
        wf.b bVarE = cVar3.e();
        this.L$0 = cVar3;
        this.label = 2;
        return d0.b(list, bVarE, this) == coroutine_suspended ? coroutine_suspended : cVar3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(qf.f fVar, vf.c cVar, Continuation<? super kf.c> continuation) {
        x xVar = new x(this.$responseValidators, continuation);
        xVar.L$0 = fVar;
        xVar.L$1 = cVar;
        return xVar.invokeSuspend(Unit.INSTANCE);
    }
}
