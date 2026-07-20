package kf;

import jh.g0;
import jh.o;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import wi.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(c cVar, ContinuationImpl continuationImpl) throws Throwable {
        e eVar;
        if (continuationImpl instanceof e) {
            eVar = (e) continuationImpl;
            int i8 = eVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                eVar.label = i8 - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuationImpl);
            }
        } else {
            eVar = new e(continuationImpl);
        }
        Object objL = eVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = eVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objL);
            o oVarD = cVar.e().d();
            eVar.L$0 = cVar;
            eVar.label = 1;
            objL = g0.l(oVarD, eVar);
            if (objL == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) eVar.L$0;
            ResultKt.throwOnFailure(objL);
        }
        return new g(cVar.f6855a, cVar.d(), cVar.e(), wi.o.b((k) objL));
    }
}
