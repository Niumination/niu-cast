package nq;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nThreadPoolDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadPoolDispatcher.kt\nkotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
public final /* synthetic */ class t3 {
    @f1
    @os.l
    public static final x1 b(final int i10, @os.l final String str) {
        if (i10 < 1) {
            throw new IllegalArgumentException(k.b.a("Expected at least one thread, but ", i10, " specified").toString());
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        return new y1(Executors.newScheduledThreadPool(i10, new ThreadFactory() { // from class: nq.s3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return t3.c(i10, str, atomicInteger, runnable);
            }
        }));
    }

    public static final Thread c(int i10, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i10 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
