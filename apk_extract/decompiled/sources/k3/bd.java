package k3;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class bd {
    public static final Object a(qi.v vVar, qi.v vVar2, Function2 function2) {
        Object uVar;
        Object objE0;
        try {
            uVar = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, vVar2, vVar) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(vVar2, vVar);
        } catch (Throwable th2) {
            uVar = new li.u(false, th2);
        }
        if (uVar != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (objE0 = vVar.e0(uVar)) != li.l0.e) {
            if (objE0 instanceof li.u) {
                throw ((li.u) objE0).f7494a;
            }
            return li.l0.t(objE0);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
