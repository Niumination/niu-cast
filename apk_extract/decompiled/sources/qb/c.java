package qb;

import eb.k1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends SuspendLambda implements Function2 {
    int label;

    public c(Continuation<? super c> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            ob.b.f8417b.getClass();
            Intrinsics.checkNotNullParameter("start_from_phone", "startFrom");
            ob.b.f8422i = "start_from_phone";
            k1 k1Var = k1.f4765a;
            this.label = 1;
            obj = k1Var.d(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        Intrinsics.checkNotNullParameter("connect_by_cable", "conType");
        ob.b.f8423j = "connect_by_cable";
        if (!((hc.b) obj).f5279a) {
            k1 k1Var2 = k1.f4765a;
            hc.c cVar = k1.e;
            String str = cVar != null ? cVar.f5288c : null;
            hc.c cVar2 = k1.e;
            bVar.n(str, cVar2 != null ? cVar2.f5286a : null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
