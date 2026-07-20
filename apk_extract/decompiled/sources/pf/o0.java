package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends SuspendLambda implements Function3 {
    final /* synthetic */ boolean $allowHttpsDowngrade;
    final /* synthetic */ boolean $checkHttpMethod;
    final /* synthetic */ qf.b $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(boolean z2, boolean z3, qf.b bVar, Continuation<? super o0> continuation) {
        super(3, continuation);
        this.$checkHttpMethod = z2;
        this.$allowHttpsDowngrade = z3;
        this.$this_createClientPlugin = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        vf.c cVar;
        qf.f fVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                vf.c cVar2 = (vf.c) this.L$1;
                fVar = (qf.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = cVar2;
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        ResultKt.throwOnFailure(obj);
        qf.f fVar2 = (qf.f) this.L$0;
        vf.c cVar3 = (vf.c) this.L$1;
        this.L$0 = fVar2;
        this.L$1 = cVar3;
        this.label = 1;
        Object objA = fVar2.f9056a.a(cVar3, this);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        cVar = cVar3;
        fVar = fVar2;
        obj = objA;
        kf.c cVar4 = (kf.c) obj;
        if (this.$checkHttpMethod && !q0.f8861a.contains(cVar4.d().X())) {
            return cVar4;
        }
        boolean z2 = this.$allowHttpsDowngrade;
        jf.d dVar = this.$this_createClientPlugin.f9042a;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        obj = q0.a(fVar, cVar, cVar4, z2, dVar, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(qf.f fVar, vf.c cVar, Continuation<? super kf.c> continuation) {
        o0 o0Var = new o0(this.$checkHttpMethod, this.$allowHttpsDowngrade, this.$this_createClientPlugin, continuation);
        o0Var.L$0 = fVar;
        o0Var.L$1 = cVar;
        return o0Var.invokeSuspend(Unit.INSTANCE);
    }
}
