package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $expectSuccess;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(boolean z2, Continuation<? super w> continuation) {
        super(2, continuation);
        this.$expectSuccess = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        w wVar = new w(this.$expectSuccess, continuation);
        wVar.L$0 = obj;
        return wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        zg.h hVar = ((vf.c) this.L$0).f;
        zg.a aVar = d0.f8837c;
        final boolean z2 = this.$expectSuccess;
        hVar.a(aVar, new Function0() { // from class: pf.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(z2);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(vf.c cVar, Continuation<? super Unit> continuation) {
        return ((w) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
