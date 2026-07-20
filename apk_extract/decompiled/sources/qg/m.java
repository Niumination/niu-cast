package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public m(Continuation<? super m> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        m mVar = new m(continuation);
        mVar.L$0 = fVar;
        mVar.L$1 = obj;
        return mVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            Object obj2 = this.L$1;
            mg.r rVar = (mg.r) fVar.f5401a;
            zg.a aVar = mg.s.f8076a;
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            if (rVar.k().b()) {
                return Unit.INSTANCE;
            }
            if (!(obj2 instanceof cg.j)) {
                throw new IllegalArgumentException("Response pipeline couldn't transform '" + Reflection.getOrCreateKotlinClass(obj2.getClass()) + "' to the OutgoingContent");
            }
            mg.r rVar2 = (mg.r) fVar.f5401a;
            wg.c cVarK = rVar2.k();
            s sVar = cVarK instanceof s ? (s) cVarK : null;
            if (sVar == null) {
                sVar = (s) rVar2.i().b(s.f9107h);
            }
            this.L$0 = null;
            this.label = 1;
            if (sVar.k((cg.j) obj2, this) == coroutine_suspended) {
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
