package pi;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import li.a2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Continuation[] f8894a = new Continuation[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a8.a f8895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a8.a f8896c;

    static {
        int i8 = 15;
        f8895b = new a8.a("NULL", i8);
        f8896c = new a8.a("DONE", i8);
    }

    public static /* synthetic */ oi.h a(s sVar, a2 a2Var, int i8, ni.c cVar, int i9) {
        CoroutineContext coroutineContext = a2Var;
        if ((i9 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i9 & 2) != 0) {
            i8 = -3;
        }
        if ((i9 & 4) != 0) {
            cVar = ni.c.SUSPEND;
        }
        return sVar.b(coroutineContext, i8, cVar);
    }

    public static final Object b(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation) {
        Object objC = qi.z.c(coroutineContext, obj2);
        try {
            z zVar = new z(continuation, coroutineContext);
            Object objWrapWithContinuationImpl = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, obj, zVar) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(obj, zVar);
            qi.z.a(coroutineContext, objC);
            if (objWrapWithContinuationImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return objWrapWithContinuationImpl;
        } catch (Throwable th2) {
            qi.z.a(coroutineContext, objC);
            throw th2;
        }
    }
}
