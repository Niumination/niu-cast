package vq;

import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/DiagnosticCoroutineContextException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,50:1\n26#2:51\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/DiagnosticCoroutineContextException\n*L\n46#1:51\n*E\n"})
public final class l extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final transient um.g f17861a;

    public l(@os.l um.g gVar) {
        this.f17861a = gVar;
    }

    @Override // java.lang.Throwable
    @os.l
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    @os.l
    public String getLocalizedMessage() {
        return this.f17861a.toString();
    }
}
