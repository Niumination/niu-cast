package q1;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    public String f13755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public Boolean f13756b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.a
    public Integer f13757c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @gm.a
    public Thread.UncaughtExceptionHandler f13758d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    public ThreadFactory f13759e = null;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f13760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f13762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f13763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f13764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f13765f;

        public a(final ThreadFactory val$backingThreadFactory, final String val$nameFormat, final AtomicLong val$count, final Boolean val$daemon, final Integer val$priority, final Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler) {
            this.f13760a = val$backingThreadFactory;
            this.f13761b = val$nameFormat;
            this.f13762c = val$count;
            this.f13763d = val$daemon;
            this.f13764e = val$priority;
            this.f13765f = val$uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f13760a.newThread(runnable);
            Objects.requireNonNull(threadNewThread);
            String str = this.f13761b;
            if (str != null) {
                AtomicLong atomicLong = this.f13762c;
                Objects.requireNonNull(atomicLong);
                threadNewThread.setName(String.format(Locale.ROOT, str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f13763d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f13764e;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f13765f;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static String a(String str, Object[] objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public static ThreadFactory c(x2 builder) {
        String str = builder.f13755a;
        Boolean bool = builder.f13756b;
        Integer num = builder.f13757c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.f13758d;
        ThreadFactory threadFactoryDefaultThreadFactory = builder.f13759e;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }

    public ThreadFactory b() {
        return c(this);
    }

    @t1.a
    public x2 e(boolean daemon) {
        this.f13756b = Boolean.valueOf(daemon);
        return this;
    }

    @t1.a
    public x2 f(String nameFormat) {
        d(nameFormat, 0);
        this.f13755a = nameFormat;
        return this;
    }

    @t1.a
    public x2 g(int priority) {
        c1.h0.m(priority >= 1, "Thread priority (%s) must be >= %s", priority, 1);
        c1.h0.m(priority <= 10, "Thread priority (%s) must be <= %s", priority, 10);
        this.f13757c = Integer.valueOf(priority);
        return this;
    }

    @t1.a
    public x2 h(ThreadFactory backingThreadFactory) {
        backingThreadFactory.getClass();
        this.f13759e = backingThreadFactory;
        return this;
    }

    @t1.a
    public x2 i(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        uncaughtExceptionHandler.getClass();
        this.f13758d = uncaughtExceptionHandler;
        return this;
    }
}
