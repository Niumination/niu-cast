package mg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends SuspendLambda implements Function3 {
    final /* synthetic */ Function4<g, r, Object, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function2<Object, hh.f, g> $contextInit;
    final /* synthetic */ String $handlerName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ z this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public y(z zVar, String str, Function4<g, ? super r, Object, ? super Continuation<? super Unit>, ? extends Object> function4, Function2<Object, ? super hh.f, g> function2, Continuation<? super y> continuation) {
        super(3, continuation);
        this.this$0 = zVar;
        this.$handlerName = str;
        this.$block = function4;
        this.$contextInit = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        y yVar = new y(this.this$0, this.$handlerName, this.$block, this.$contextInit, continuation);
        yVar.L$0 = fVar;
        return yVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            z zVar = this.this$0;
            zg.a aVar = zVar.f8081a;
            String str = aVar.f11583a;
            x xVar = new x(aVar, this.$handlerName, this.$block, this.$contextInit, ((k) zVar).f8070h, fVar, null);
            this.label = 1;
            if ((!((Boolean) dh.d.f4469a.getValue()).booleanValue() ? xVar.invoke(this) : l0.u(get$context().plus(new eh.b(str)), new dh.a(xVar, null), this)) == coroutine_suspended) {
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
}
