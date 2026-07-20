package qf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import pf.m1;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends SuspendLambda implements Function3 {
    final /* synthetic */ jf.d $client;
    final /* synthetic */ Function3<f, vf.c, Continuation<? super kf.c>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(Function3<? super f, ? super vf.c, ? super Continuation<? super kf.c>, ? extends Object> function3, jf.d dVar, Continuation<? super g> continuation) {
        super(3, continuation);
        this.$handler = function3;
        this.$client = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            m1 m1Var = (m1) this.L$0;
            vf.c cVar = (vf.c) this.L$1;
            Function3<f, vf.c, Continuation<? super kf.c>, Object> function3 = this.$handler;
            f fVar = new f(m1Var, this.$client.f6258d);
            this.L$0 = null;
            this.label = 1;
            obj = function3.invoke(fVar, cVar, this);
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

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(m1 m1Var, vf.c cVar, Continuation<? super kf.c> continuation) {
        g gVar = new g(this.$handler, this.$client, continuation);
        gVar.L$0 = m1Var;
        gVar.L$1 = cVar;
        return gVar.invokeSuspend(Unit.INSTANCE);
    }
}
