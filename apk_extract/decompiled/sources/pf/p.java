package pf;

import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public p(Continuation<? super p> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, wf.c cVar, Continuation<? super Unit> continuation) {
        p pVar = new p(continuation);
        pVar.L$0 = fVar;
        pVar.L$1 = cVar;
        return pVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            wf.c cVar = (wf.c) this.L$1;
            ih.a aVar = cVar.f10742a;
            Object obj2 = cVar.f10743b;
            if (!(obj2 instanceof jh.o)) {
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(aVar.f5872a, Reflection.getOrCreateKotlinClass(InputStream.class))) {
                jh.o oVar = (jh.o) obj2;
                Intrinsics.checkNotNullParameter(oVar, "<this>");
                wf.c cVar2 = new wf.c(aVar, new mh.b(new mh.b(oVar, 0), 1));
                this.L$0 = null;
                this.label = 1;
                if (fVar.f(cVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
