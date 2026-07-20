package pf;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends SuspendLambda implements Function2 {
    final /* synthetic */ Object $body;
    final /* synthetic */ wf.b $response;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Object obj, wf.b bVar, Continuation<? super m> continuation) {
        super(2, continuation);
        this.$body = obj;
        this.$response = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m mVar = new m(this.$body, this.$response, continuation);
        mVar.L$0 = obj;
        return mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                jh.z0 z0Var = (jh.z0) this.L$0;
                jh.o oVar = (jh.o) this.$body;
                jh.j0 j0Var = z0Var.f6313a;
                this.label = 1;
                obj = jh.g0.c(oVar, j0Var, Long.MAX_VALUE, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ((Number) obj).longValue();
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            li.h0.b(this.$response, e);
            throw e;
        } catch (Throwable th2) {
            li.h0.b(this.$response, li.l0.a("Receive failed", th2));
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(jh.z0 z0Var, Continuation<? super Unit> continuation) {
        return ((m) create(z0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
