package oi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements h {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // oi.h
    public final Object a(i iVar, Continuation continuation) throws Throwable {
        a aVar;
        pi.v vVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i8 = aVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                aVar.label = i8 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuation);
            }
        } else {
            aVar = new a(this, continuation);
        }
        Object obj = aVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = aVar.label;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            vVar = (pi.v) aVar.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                vVar.releaseIntercepted();
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                vVar.releaseIntercepted();
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        pi.v vVar2 = new pi.v(iVar, aVar.get$context());
        try {
            aVar.L$0 = vVar2;
            aVar.label = 1;
            try {
                Object objInvoke = ((b0) this).f8535a.invoke(vVar2, aVar);
                if (objInvoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objInvoke = Unit.INSTANCE;
                }
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                vVar = vVar2;
                vVar.releaseIntercepted();
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
                vVar = vVar2;
                vVar.releaseIntercepted();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
