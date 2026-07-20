package li;

import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o2 {
    public static final Object a(m2 m2Var, Function2 function2) throws Throwable {
        Object uVar;
        Object objE0;
        l0.m(m2Var, new y0(r0.b(m2Var.f9168d.get$context()).g(m2Var.e, m2Var, m2Var.f7429c), 0));
        try {
            uVar = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, m2Var, m2Var) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(m2Var, m2Var);
        } catch (Throwable th2) {
            uVar = new u(false, th2);
        }
        if (uVar != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (objE0 = m2Var.e0(uVar)) != l0.e) {
            if (objE0 instanceof u) {
                Throwable th3 = ((u) objE0).f7494a;
                if (!(th3 instanceof l2) || ((l2) th3).coroutine != m2Var) {
                    throw th3;
                }
                if (uVar instanceof u) {
                    throw ((u) uVar).f7494a;
                }
            } else {
                uVar = l0.t(objE0);
            }
            return uVar;
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, li.m2] */
    public static final Object b(long j8, Function2 function2, ContinuationImpl continuationImpl) throws Throwable {
        n2 n2Var;
        Ref.ObjectRef objectRef;
        if (continuationImpl instanceof n2) {
            n2Var = (n2) continuationImpl;
            int i8 = n2Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                n2Var.label = i8 - Integer.MIN_VALUE;
            } else {
                n2Var = new n2(continuationImpl);
            }
        } else {
            n2Var = new n2(continuationImpl);
        }
        Object obj = n2Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = n2Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            if (j8 <= 0) {
                return null;
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            try {
                n2Var.L$0 = function2;
                n2Var.L$1 = objectRef2;
                n2Var.J$0 = j8;
                n2Var.label = 1;
                ?? m2Var = new m2(j8, n2Var);
                objectRef2.element = m2Var;
                Object objA = a(m2Var, function2);
                if (objA == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(n2Var);
                }
                return objA == coroutine_suspended ? coroutine_suspended : objA;
            } catch (l2 e) {
                e = e;
                objectRef = objectRef2;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) n2Var.L$1;
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (l2 e4) {
                e = e4;
            }
        }
        if (e.coroutine == objectRef.element) {
            return null;
        }
        throw e;
    }
}
