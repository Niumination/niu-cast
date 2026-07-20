package xg;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends SuspendLambda implements Function3 {
    final /* synthetic */ List<Function2<s, Continuation<? super Unit>, Object>> $handlers;
    final /* synthetic */ int $index;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(List<Function2<s, Continuation<? super Unit>, Object>> list, int i8, Continuation<? super t> continuation) {
        super(3, continuation);
        this.$handlers = list;
        this.$index = i8;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Unit unit, Continuation<? super Unit> continuation) {
        t tVar = new t(this.$handlers, this.$index, continuation);
        tVar.L$0 = fVar;
        return tVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            mg.r rVar = (mg.r) ((hh.f) this.L$0).f5401a;
            Intrinsics.checkNotNull(rVar, "null cannot be cast to non-null type io.ktor.server.routing.RoutingPipelineCall");
            y yVar = (y) rVar;
            s sVar = new s(new r(yVar));
            zg.a aVar = mg.s.f8076a;
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            if (yVar.k().b()) {
                return Unit.INSTANCE;
            }
            Function2<s, Continuation<? super Unit>, Object> function2 = this.$handlers.get(this.$index);
            this.label = 1;
            if (function2.invoke(sVar, this) == coroutine_suspended) {
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
