package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final boolean daemon;
    private final AtomicInteger nextId;
    private final String prefix;
    private final int priority;
    protected final ThreadGroup threadGroup;

    public DefaultThreadFactory(Class<?> cls) {
        this(cls, false, 5);
    }

    public static String toPoolName(Class<?> cls) {
        ObjectUtil.checkNotNull(cls, "poolType");
        String strSimpleClassName = StringUtil.simpleClassName(cls);
        int length = strSimpleClassName.length();
        if (length == 0) {
            return "unknown";
        }
        if (length == 1) {
            return strSimpleClassName.toLowerCase(Locale.US);
        }
        if (!Character.isUpperCase(strSimpleClassName.charAt(0)) || !Character.isLowerCase(strSimpleClassName.charAt(1))) {
            return strSimpleClassName;
        }
        return Character.toLowerCase(strSimpleClassName.charAt(0)) + strSimpleClassName.substring(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = newThread(FastThreadLocalRunnable.wrap(runnable), this.prefix + this.nextId.incrementAndGet());
        try {
            boolean zIsDaemon = threadNewThread.isDaemon();
            boolean z10 = this.daemon;
            if (zIsDaemon != z10) {
                threadNewThread.setDaemon(z10);
            }
            int priority = threadNewThread.getPriority();
            int i10 = this.priority;
            if (priority != i10) {
                threadNewThread.setPriority(i10);
            }
        } catch (Exception unused) {
        }
        return threadNewThread;
    }

    public DefaultThreadFactory(String str) {
        this(str, false, 5);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z10) {
        this(cls, z10, 5);
    }

    public DefaultThreadFactory(String str, boolean z10) {
        this(str, z10, 5);
    }

    public DefaultThreadFactory(Class<?> cls, int i10) {
        this(cls, false, i10);
    }

    public DefaultThreadFactory(String str, int i10) {
        this(str, false, i10);
    }

    public Thread newThread(Runnable runnable, String str) {
        return new FastThreadLocalThread(this.threadGroup, runnable, str);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z10, int i10) {
        this(toPoolName(cls), z10, i10);
    }

    public DefaultThreadFactory(String str, boolean z10, int i10, ThreadGroup threadGroup) {
        this.nextId = new AtomicInteger();
        ObjectUtil.checkNotNull(str, "poolName");
        if (i10 >= 1 && i10 <= 10) {
            this.prefix = str + '-' + poolId.incrementAndGet() + '-';
            this.daemon = z10;
            this.priority = i10;
            this.threadGroup = threadGroup;
            return;
        }
        throw new IllegalArgumentException(b.a("priority: ", i10, " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)"));
    }

    public DefaultThreadFactory(String str, boolean z10, int i10) {
        this(str, z10, i10, null);
    }
}
