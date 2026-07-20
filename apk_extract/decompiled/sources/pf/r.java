package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends SuspendLambda implements Function3 {
    final /* synthetic */ boolean $disabled;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(boolean z2, Continuation<? super r> continuation) {
        super(3, continuation);
        this.$disabled = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, wf.b bVar, Continuation<? super Unit> continuation) {
        r rVar = new r(this.$disabled, continuation);
        rVar.L$0 = fVar;
        rVar.L$1 = bVar;
        return rVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            wf.b bVar = (wf.b) this.L$1;
            if (this.$disabled) {
                return Unit.INSTANCE;
            }
            zg.h hVarI = bVar.b().i();
            zg.a key = s.f8865a;
            hVarI.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            if (hVarI.c().containsKey(key)) {
                return Unit.INSTANCE;
            }
            rf.d dVar = new rf.d(bVar.d());
            kf.c cVarB = bVar.b();
            ag.a block = new ag.a(dVar, 8);
            Intrinsics.checkNotNullParameter(cVarB, "<this>");
            Intrinsics.checkNotNullParameter(block, "block");
            sf.d dVar2 = new sf.d(cVarB.f6855a, block, cVarB, cVarB.e().a());
            dVar2.i().e(s.f8866b, Unit.INSTANCE);
            wf.b bVarE = dVar2.e();
            this.L$0 = null;
            this.label = 1;
            if (fVar.f(bVarE, this) == coroutine_suspended) {
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
}
