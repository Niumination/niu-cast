package mh;

import java.io.EOFException;
import jh.r0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ int $min;
    int label;
    final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, int i8, Continuation<? super d> continuation) {
        super(2, continuation);
        this.this$0 = eVar;
        this.$min = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.this$0, this.$min, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        long jD0 = 0;
        while (lh.a.e(this.this$0.e) < this.$min && jD0 >= 0) {
            try {
                e eVar = this.this$0;
                jD0 = eVar.f8087b.d0(eVar.e, Long.MAX_VALUE);
            } catch (EOFException unused) {
                jD0 = -1;
            }
        }
        if (jD0 == -1) {
            this.this$0.f8087b.close();
            this.this$0.f.r0();
            this.this$0.f8089d = new r0(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
