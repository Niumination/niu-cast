package ng;

import jh.j0;
import jh.l0;
import jh.o0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends SuspendLambda implements Function2 {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ j0 $channel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(j0 j0Var, byte[] bArr, Continuation<? super u> continuation) {
        super(2, continuation);
        this.$channel = j0Var;
        this.$bytes = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new u(this.$channel, this.$bytes, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
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
        j0 j0Var = this.$channel;
        byte[] bArr = this.$bytes;
        this.label = 1;
        l0 l0Var = o0.f6300a;
        if (o0.d(j0Var, bArr, 0, bArr.length, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        j0 j0Var2 = this.$channel;
        this.label = 2;
        if (((jh.k) j0Var2).i(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((u) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
