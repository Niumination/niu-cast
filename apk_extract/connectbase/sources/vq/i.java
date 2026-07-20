package vq;

import java.util.Collection;
import java.util.ServiceLoader;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/CoroutineExceptionHandlerImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final Collection<nq.o0> f17851a = gq.v.c3(gq.s.e(ServiceLoader.load(nq.o0.class, nq.o0.class.getClassLoader()).iterator()));

    public static final void a(@os.l nq.o0 o0Var) {
        if (!f17851a.contains(o0Var)) {
            throw new IllegalStateException("Exception handler was not found via a ServiceLoader");
        }
    }

    @os.l
    public static final Collection<nq.o0> b() {
        return f17851a;
    }

    public static final void c(@os.l Throwable th2) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
    }
}
