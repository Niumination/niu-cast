package bf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ze.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends SuspendLambda implements Function2 {
    final /* synthetic */ r1 $descriptor;
    final /* synthetic */ Function1<Object, oi.h> $implementation;
    final /* synthetic */ oi.h $requests;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c0(oi.h hVar, r1 r1Var, Function1<Object, ? extends oi.h> function1, Continuation<? super c0> continuation) {
        super(2, continuation);
        this.$requests = hVar;
        this.$descriptor = r1Var;
        this.$implementation = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        c0 c0Var = new c0(this.$requests, this.$descriptor, this.$implementation, continuation);
        c0Var.L$0 = obj;
        return c0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            oi.i iVar = (oi.i) this.L$0;
            oi.b0 b0VarA = j3.x.a(this.$requests, this.$descriptor);
            d dVar = new d(1, this.$implementation, iVar);
            this.label = 1;
            if (b0VarA.a(dVar, this) == coroutine_suspended) {
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
    public final Object invoke(oi.i iVar, Continuation<? super Unit> continuation) {
        return ((c0) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
