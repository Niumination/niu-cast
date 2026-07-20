package nf;

import jh.j0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends SuspendLambda implements Function2 {
    final /* synthetic */ CoroutineContext $callContext;
    final /* synthetic */ boolean $closeChannel;
    final /* synthetic */ j0 $output;
    final /* synthetic */ boolean $overProxy;
    final /* synthetic */ vf.d $request;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(vf.d dVar, j0 j0Var, boolean z2, boolean z3, CoroutineContext coroutineContext, Continuation<? super a0> continuation) {
        super(2, continuation);
        this.$request = dVar;
        this.$output = j0Var;
        this.$overProxy = z2;
        this.$closeChannel = z3;
        this.$callContext = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a0(this.$request, this.$output, this.$overProxy, this.$closeChannel, this.$callContext, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
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
        vf.d dVar = this.$request;
        j0 j0Var = this.$output;
        boolean z2 = this.$overProxy;
        boolean z3 = this.$closeChannel;
        this.label = 1;
        if (b0.f(dVar, j0Var, z2, z3, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        vf.d dVar2 = this.$request;
        j0 j0Var2 = this.$output;
        CoroutineContext coroutineContext = this.$callContext;
        this.label = 2;
        if (b0.e(dVar2, j0Var2, coroutineContext) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
