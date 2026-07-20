package nf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends SuspendLambda implements Function2 {
    final /* synthetic */ gg.n $address;
    final /* synthetic */ long $socketTimeout;
    int label;
    final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(p pVar, gg.n nVar, long j8, Continuation<? super j> continuation) {
        super(2, continuation);
        this.this$0 = pVar;
        this.$address = nVar;
        this.$socketTimeout = j8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j(this.this$0, this.$address, this.$socketTimeout, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            h hVar = this.this$0.e;
            gg.n nVar = this.$address;
            ig.d dVar = new ig.d(1, this.$socketTimeout);
            this.label = 1;
            obj = hVar.a(nVar, dVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.f8230l = this.$address;
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super gg.s> continuation) {
        return ((j) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
