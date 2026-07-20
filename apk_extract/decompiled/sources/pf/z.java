package pf;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends SuspendLambda implements Function3 {
    final /* synthetic */ List<Object> $callExceptionHandlers;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(List<Object> list, Continuation<? super z> continuation) {
        super(3, continuation);
        this.$callExceptionHandlers = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Throwable th2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(obj);
            return th2;
        }
        ResultKt.throwOnFailure(obj);
        vf.b bVar = (vf.b) this.L$0;
        Throwable thA = xf.a.a((Throwable) this.L$1);
        List<Object> list = this.$callExceptionHandlers;
        this.L$0 = thA;
        this.label = 1;
        return d0.a(list, thA, bVar, this) == coroutine_suspended ? coroutine_suspended : thA;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(vf.b bVar, Throwable th2, Continuation<? super Throwable> continuation) {
        z zVar = new z(this.$callExceptionHandlers, continuation);
        zVar.L$0 = bVar;
        zVar.L$1 = th2;
        return zVar.invokeSuspend(Unit.INSTANCE);
    }
}
