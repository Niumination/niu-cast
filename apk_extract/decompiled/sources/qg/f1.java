package qg;

import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.p1;
import li.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends SuspendLambda implements Function2 {
    final /* synthetic */ mg.a $application;
    final /* synthetic */ mg.d $environment;
    final /* synthetic */ int $exitCode;
    final /* synthetic */ li.q $latch;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(li.q qVar, mg.a aVar, mg.d dVar, int i8, Continuation<? super f1> continuation) {
        super(2, continuation);
        this.$latch = qVar;
        this.$application = aVar;
        this.$environment = dVar;
        this.$exitCode = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f1(this.$latch, this.$application, this.$environment, this.$exitCode, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            p1 p1Var = this.$latch;
            this.label = 1;
            if (((x1) p1Var).S(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$application.f8043r.a(mg.l.f8074d, this.$environment);
        this.$application.s();
        System.exit(this.$exitCode);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
