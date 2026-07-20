package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class Zstd {
    private static final Throwable cause;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Zstd.class);

    static {
        try {
            Class.forName("com.github.luben.zstd.Zstd", false, PlatformDependent.getClassLoader(Zstd.class));
            e = null;
        } catch (ClassNotFoundException e10) {
            e = e10;
            logger.debug("zstd-jni not in the classpath; Zstd support will be unavailable.");
        } catch (Throwable th2) {
            e = th2;
            logger.debug("Failed to load zstd-jni; Zstd support will be unavailable.", (Throwable) e);
        }
        cause = e;
    }

    private Zstd() {
    }

    public static Throwable cause() {
        return cause;
    }

    public static void ensureAvailability() throws Throwable {
        Throwable th2 = cause;
        if (th2 != null) {
            throw th2;
        }
    }

    public static boolean isAvailable() {
        return cause == null;
    }
}
