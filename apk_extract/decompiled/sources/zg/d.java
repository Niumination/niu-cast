package zg;

import jh.o0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ byte[] $buffer;
    final /* synthetic */ int $read;
    final /* synthetic */ jh.k $second;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(jh.k kVar, byte[] bArr, int i8, Continuation<? super d> continuation) {
        super(2, continuation);
        this.$second = kVar;
        this.$buffer = bArr;
        this.$read = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.$second, this.$buffer, this.$read, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            jh.k kVar = this.$second;
            byte[] bArr = this.$buffer;
            int i9 = this.$read;
            this.label = 1;
            if (o0.d(kVar, bArr, 0, i9, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
