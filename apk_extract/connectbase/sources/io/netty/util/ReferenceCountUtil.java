package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class ReferenceCountUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountUtil.class);

    public static final class ReleasingTask implements Runnable {
        private final int decrement;
        private final ReferenceCounted obj;

        public ReleasingTask(ReferenceCounted referenceCounted, int i10) {
            this.obj = referenceCounted;
            this.decrement = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.obj.release(this.decrement)) {
                    ReferenceCountUtil.logger.debug("Released: {}", this);
                } else {
                    ReferenceCountUtil.logger.warn("Non-zero refCnt: {}", this);
                }
            } catch (Exception e10) {
                ReferenceCountUtil.logger.warn("Failed to release an object: {}", this.obj, e10);
            }
        }

        public String toString() {
            return StringUtil.simpleClassName(this.obj) + ".release(" + this.decrement + ") refCnt: " + this.obj.refCnt();
        }
    }

    static {
        ResourceLeakDetector.addExclusions(ReferenceCountUtil.class, "touch");
    }

    private ReferenceCountUtil() {
    }

    public static int refCnt(Object obj) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).refCnt();
        }
        return -1;
    }

    public static boolean release(Object obj) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).release();
        }
        return false;
    }

    @Deprecated
    public static <T> T releaseLater(T t10) {
        return (T) releaseLater(t10, 1);
    }

    public static <T> T retain(T t10) {
        return t10 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t10).retain() : t10;
    }

    public static void safeRelease(Object obj) {
        try {
            release(obj);
        } catch (Throwable th2) {
            logger.warn("Failed to release a message: {}", obj, th2);
        }
    }

    public static <T> T touch(T t10) {
        return t10 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t10).touch() : t10;
    }

    @Deprecated
    public static <T> T releaseLater(T t10, int i10) {
        ObjectUtil.checkPositive(i10, "decrement");
        if (t10 instanceof ReferenceCounted) {
            ThreadDeathWatcher.watch(Thread.currentThread(), new ReleasingTask((ReferenceCounted) t10, i10));
        }
        return t10;
    }

    public static boolean release(Object obj, int i10) {
        ObjectUtil.checkPositive(i10, "decrement");
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).release(i10);
        }
        return false;
    }

    public static <T> T retain(T t10, int i10) {
        ObjectUtil.checkPositive(i10, "increment");
        return t10 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t10).retain(i10) : t10;
    }

    public static void safeRelease(Object obj, int i10) {
        try {
            ObjectUtil.checkPositive(i10, "decrement");
            release(obj, i10);
        } catch (Throwable th2) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to release a message: {} (decrement: {})", obj, Integer.valueOf(i10), th2);
            }
        }
    }

    public static <T> T touch(T t10, Object obj) {
        return t10 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t10).touch(obj) : t10;
    }
}
