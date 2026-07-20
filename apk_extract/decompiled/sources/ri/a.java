package ri;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import qi.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final void a(Continuation continuation, li.a aVar) {
        try {
            Continuation continuationIntercepted = IntrinsicsKt.intercepted(continuation);
            Result.Companion companion = Result.INSTANCE;
            g.h(Result.m159constructorimpl(Unit.INSTANCE), continuationIntercepted);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            aVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(th2)));
            throw th2;
        }
    }

    public static final void b(Function2 function2, Object obj, Continuation continuation) {
        try {
            Continuation continuationIntercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, obj, continuation));
            Result.Companion companion = Result.INSTANCE;
            g.h(Result.m159constructorimpl(Unit.INSTANCE), continuationIntercepted);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(th2)));
            throw th2;
        }
    }
}
