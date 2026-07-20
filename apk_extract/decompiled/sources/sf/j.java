package sf;

import jh.o;
import k3.kd;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends SuspendLambda implements Function3 {
    final /* synthetic */ Function1<kf.c, Boolean> $filter;
    final /* synthetic */ Function2<wf.b, Continuation<? super Unit>, Object> $responseHandler;
    final /* synthetic */ qf.b $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super kf.c, Boolean> function1, qf.b bVar, Function2<? super wf.b, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super j> continuation) {
        super(3, continuation);
        this.$filter = function1;
        this.$this_createClientPlugin = bVar;
        this.$responseHandler = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar;
        wf.b bVar;
        wf.b bVar2;
        g0 g0Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                g0Var = (g0) this.L$3;
                bVar = (wf.b) this.L$2;
                bVar2 = (wf.b) this.L$1;
                aVar = (a) this.L$0;
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
        aVar = (a) this.L$0;
        wf.b coroutineScope = (wf.b) this.L$1;
        Function1<kf.c, Boolean> function1 = this.$filter;
        if (function1 != null && !function1.invoke(coroutineScope.b()).booleanValue()) {
            return Unit.INSTANCE;
        }
        o oVarD = coroutineScope.d();
        Intrinsics.checkNotNullParameter(oVarD, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        jh.k kVar = new jh.k(true);
        jh.k kVar2 = new jh.k(true);
        l0.p(coroutineScope, null, null, new zg.e(oVarD, kVar, kVar2, null), 3).A(new gi.a(14, kVar, kVar2));
        Pair pair = TuplesKt.to(kVar, kVar2);
        o oVar = (o) pair.component1();
        wf.b bVarE = kd.a(coroutineScope.b(), (o) pair.component2()).e();
        wf.b bVarE2 = kd.a(coroutineScope.b(), oVar).e();
        jf.d dVar = this.$this_createClientPlugin.f9042a;
        this.L$0 = aVar;
        this.L$1 = bVarE;
        this.L$2 = bVarE2;
        this.L$3 = dVar;
        this.label = 1;
        if (get$context().get(ui.b.f10442a) != null) {
            throw new ClassCastException();
        }
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (emptyCoroutineContext == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar = bVarE2;
        obj = emptyCoroutineContext;
        bVar2 = bVarE;
        g0Var = dVar;
        l0.p(g0Var, (CoroutineContext) obj, null, new i(bVar, this.$responseHandler, null), 2);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (aVar.f10089a.f(bVar2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(a aVar, wf.b bVar, Continuation<? super Unit> continuation) {
        j jVar = new j(this.$filter, this.$this_createClientPlugin, this.$responseHandler, continuation);
        jVar.L$0 = aVar;
        jVar.L$1 = bVar;
        return jVar.invokeSuspend(Unit.INSTANCE);
    }
}
