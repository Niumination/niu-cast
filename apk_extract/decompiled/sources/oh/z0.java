package oh;

import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 extends SuspendLambda implements Function2 {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ a1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(a1 a1Var, Continuation<? super z0> continuation) {
        super(2, continuation);
        this.this$0 = a1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new z0(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        nh.d dVar;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            a1 a1Var = this.this$0;
            nh.d dVar2 = a1Var.f8478d;
            Object objR = dVar2.R();
            try {
                this.L$0 = dVar2;
                this.L$1 = objR;
                this.label = 1;
                if (a1.a(a1Var, (ByteBuffer) objR, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dVar = dVar2;
                obj2 = objR;
            } catch (Throwable th2) {
                th = th2;
                dVar = dVar2;
                obj2 = objR;
                dVar.h0(obj2);
                throw th;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = this.L$1;
            dVar = (nh.d) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                dVar.h0(obj2);
                throw th;
            }
        }
        Unit unit = Unit.INSTANCE;
        dVar.h0(obj2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((z0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
