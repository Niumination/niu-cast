package og;

import jh.o0;
import k3.ha;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import ni.q;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends SuspendLambda implements Function2 {
    final /* synthetic */ q $actorChannel;
    final /* synthetic */ c $connection;
    final /* synthetic */ long $timeout;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(q qVar, long j8, c cVar, Continuation<? super g> continuation) {
        super(2, continuation);
        this.$actorChannel = qVar;
        this.$timeout = j8;
        this.$connection = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g(this.$actorChannel, this.$timeout, this.$connection, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [og.c] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        c cVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                q qVar = this.$actorChannel;
                long j8 = this.$timeout;
                c cVar2 = this.$connection;
                this.label = 1;
                if (j.a(qVar, j8, cVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this = this.$connection;
            cVar = this;
        } catch (Throwable th2) {
            try {
                o0.a(this.$connection.f8466b, th2);
                cVar = this.$connection;
            } finally {
                ha.a(this.$connection.f8466b);
            }
        }
        jh.k kVar = cVar.f8466b;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((g) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
