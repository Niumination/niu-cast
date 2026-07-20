package mf;

import eb.t0;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import li.f0;
import li.i2;
import li.l0;
import li.o1;
import li.p0;
import li.p1;
import li.r1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(f fVar, vf.d dVar, ContinuationImpl continuationImpl) throws Throwable {
        c cVar;
        if (continuationImpl instanceof c) {
            cVar = (c) continuationImpl;
            int i8 = cVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                cVar.label = i8 - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuationImpl);
            }
        } else {
            cVar = new c(continuationImpl);
        }
        Object objPlus = cVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = cVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                dVar = (vf.d) cVar.L$1;
                fVar = (f) cVar.L$0;
                ResultKt.throwOnFailure(objPlus);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objPlus);
            }
            return objPlus;
        }
        ResultKt.throwOnFailure(objPlus);
        i2 i2Var = dVar.e;
        cVar.L$0 = fVar;
        cVar.L$1 = dVar;
        cVar.label = 1;
        f0 f0Var = l.f8038a;
        r1 r1Var = new r1(i2Var);
        objPlus = fVar.getCoroutineContext().plus(r1Var).plus(l.f8038a);
        p1 p1Var = (p1) cVar.get$context().get(o1.f7483a);
        if (p1Var != null) {
            r1Var.A(new t0(p1Var.s(true, true, new t0(r1Var, 5)), 4));
        }
        if (objPlus == coroutine_suspended) {
            return coroutine_suspended;
        }
        CoroutineContext coroutineContext = (CoroutineContext) objPlus;
        p0 p0VarE = l0.e(fVar, coroutineContext.plus(new n(coroutineContext)), new d(fVar, dVar, null), 2);
        cVar.L$0 = null;
        cVar.L$1 = null;
        cVar.label = 2;
        objPlus = p0VarE.y(cVar);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (objPlus == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objPlus;
    }
}
