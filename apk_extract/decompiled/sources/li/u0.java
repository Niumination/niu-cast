package li;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 {
    public static final boolean a(int i8) {
        return i8 == 1 || i8 == 2;
    }

    public static final void b(l lVar, Continuation continuation, boolean z2) {
        Object objH;
        Object obj = l.f7465i.get(lVar);
        Throwable thG = lVar.g(obj);
        if (thG != null) {
            Result.Companion companion = Result.INSTANCE;
            objH = ResultKt.createFailure(thG);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objH = lVar.h(obj);
        }
        Object objM159constructorimpl = Result.m159constructorimpl(objH);
        if (!z2) {
            continuation.resumeWith(objM159constructorimpl);
            return;
        }
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        qi.f fVar = (qi.f) continuation;
        Continuation continuation2 = fVar.e;
        CoroutineContext coroutineContext = continuation2.get$context();
        Object objC = qi.z.c(coroutineContext, fVar.f9143i);
        q2 q2VarC = objC != qi.z.f9173a ? y.c(continuation2, coroutineContext, objC) : null;
        try {
            fVar.e.resumeWith(objM159constructorimpl);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (q2VarC == null || q2VarC.t0()) {
                qi.z.a(coroutineContext, objC);
            }
        }
    }
}
