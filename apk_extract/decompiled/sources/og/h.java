package og;

import ag.o0;
import jh.o;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import li.g0;
import li.q;
import li.r;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends SuspendLambda implements Function2 {
    final /* synthetic */ c $connection;
    final /* synthetic */ Function3<k, o0, Continuation<? super Unit>, Object> $handler;
    final /* synthetic */ o0 $request;
    final /* synthetic */ o $requestBody;
    final /* synthetic */ jh.k $response;
    final /* synthetic */ q $upgraded;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(o oVar, jh.k kVar, c cVar, q qVar, Function3<? super k, ? super o0, ? super Continuation<? super Unit>, ? extends Object> function3, o0 o0Var, Continuation<? super h> continuation) {
        super(2, continuation);
        this.$requestBody = oVar;
        this.$response = kVar;
        this.$connection = cVar;
        this.$upgraded = qVar;
        this.$handler = function3;
        this.$request = o0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h hVar = new h(this.$requestBody, this.$response, this.$connection, this.$upgraded, this.$handler, this.$request, continuation);
        hVar.L$0 = obj;
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [li.q] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Boolean boolBoxBoolean;
        r rVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = ((g0) this.L$0).getCoroutineContext();
                o oVar = this.$requestBody;
                jh.k kVar = this.$response;
                c cVar = this.$connection;
                k kVar2 = new k(coroutineContext, oVar, kVar, cVar.f8467c, cVar.f8468d, this.$upgraded);
                Function3<k, o0, Continuation<? super Unit>, Object> function3 = this.$handler;
                o0 o0Var = this.$request;
                this.label = 1;
                if (function3.invoke(kVar2, o0Var, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$response.a();
            this = this.$upgraded;
            if (this != 0) {
                boolBoxBoolean = Boxing.boxBoolean(false);
                rVar = (r) this;
                boolean zD0 = rVar.d0(boolBoxBoolean);
            }
        } catch (Throwable th2) {
            try {
                jh.o0.a(this.$response, th2);
                q qVar = this.$upgraded;
                if (qVar != null) {
                    Boxing.boxBoolean(((r) qVar).s0(th2));
                }
                this.$response.a();
                q qVar2 = this.$upgraded;
                if (qVar2 != null) {
                    boolBoxBoolean = Boxing.boxBoolean(false);
                    rVar = (r) qVar2;
                }
            } finally {
                this.$response.a();
                q qVar3 = this.$upgraded;
                if (qVar3 != null) {
                    Boxing.boxBoolean(((r) qVar3).d0(Boxing.boxBoolean(false)));
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((h) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
