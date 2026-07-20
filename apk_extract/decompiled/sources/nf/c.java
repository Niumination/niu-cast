package nf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.o1;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends SuspendLambda implements Function2 {
    final /* synthetic */ p1 $requestJob;
    final /* synthetic */ fg.u $selector;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(p1 p1Var, fg.u uVar, Continuation<? super c> continuation) {
        super(2, continuation);
        this.$requestJob = p1Var;
        this.$selector = uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(this.$requestJob, this.$selector, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        o1 o1Var = o1.f7483a;
        try {
            if (i8 != 0) {
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th2 = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th2;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            p1 p1Var = this.$requestJob;
            this.label = 1;
            if (p1Var.S(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.$selector.close();
            CoroutineContext.Element element = ((fg.e) this.$selector).f5039i.get(o1Var);
            Intrinsics.checkNotNull(element);
            this.label = 2;
            this = ((p1) element).S(this);
            if (this == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            this.$selector.close();
            CoroutineContext.Element element2 = ((fg.e) this.$selector).f5039i.get(o1Var);
            Intrinsics.checkNotNull(element2);
            this.L$0 = th3;
            this.label = 3;
            if (((p1) element2).S(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
