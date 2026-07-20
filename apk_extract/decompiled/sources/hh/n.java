package hh;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Continuation, CoroutineStackFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5408a = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f5409b;

    public n(o oVar) {
        this.f5409b = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = m.f5407a;
        int i8 = this.f5408a;
        o oVar = this.f5409b;
        if (i8 == Integer.MIN_VALUE) {
            this.f5408a = oVar.f5413h;
        }
        int i9 = this.f5408a;
        if (i9 < 0) {
            this.f5408a = Integer.MIN_VALUE;
            continuation = null;
        } else {
            try {
                Continuation continuation2 = oVar.e[i9];
                if (continuation2 != null) {
                    this.f5408a = i9 - 1;
                    continuation = continuation2;
                }
            } catch (Throwable unused) {
            }
        }
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext */
    public final CoroutineContext get$context() {
        o oVar = this.f5409b;
        Continuation[] continuationArr = oVar.e;
        int i8 = oVar.f5413h;
        Continuation continuation = continuationArr[i8];
        if (continuation != this && continuation != null) {
            return continuation.get$context();
        }
        int i9 = i8 - 1;
        while (i9 >= 0) {
            int i10 = i9 - 1;
            Continuation continuation2 = oVar.e[i9];
            if (continuation2 != this && continuation2 != null) {
                return continuation2.get$context();
            }
            i9 = i10;
        }
        throw new IllegalStateException("Not started");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        boolean zM165isFailureimpl = Result.m165isFailureimpl(obj);
        o oVar = this.f5409b;
        if (!zM165isFailureimpl) {
            oVar.h(false);
            return;
        }
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(obj);
        Intrinsics.checkNotNull(thM162exceptionOrNullimpl);
        oVar.j(Result.m159constructorimpl(ResultKt.createFailure(thM162exceptionOrNullimpl)));
    }
}
