package sf;

import jh.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2<wf.b, Continuation<? super Unit>, Object> $responseHandler;
    final /* synthetic */ wf.b $sideResponse;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(wf.b bVar, Function2<? super wf.b, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super i> continuation) {
        super(2, continuation);
        this.$sideResponse = bVar;
        this.$responseHandler = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        i iVar = new i(this.$sideResponse, this.$responseHandler, continuation);
        iVar.L$0 = obj;
        return iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            try {
                if (i8 != 0) {
                    if (i8 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Result.m159constructorimpl(Boxing.boxLong(((Number) obj).longValue()));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                g0 g0Var = (g0) this.L$0;
                Function2<wf.b, Continuation<? super Unit>, Object> function2 = this.$responseHandler;
                wf.b bVar = this.$sideResponse;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = g0Var;
                this.label = 1;
                if (function2.invoke(bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Result.m159constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m159constructorimpl(ResultKt.createFailure(th2));
            }
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m159constructorimpl(ResultKt.createFailure(th3));
        }
        o oVarD = this.$sideResponse.d();
        if (!oVarD.f()) {
            this.L$0 = null;
            this.label = 2;
            obj = jh.g0.d(oVarD, Long.MAX_VALUE, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            Result.m159constructorimpl(Boxing.boxLong(((Number) obj).longValue()));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((i) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
