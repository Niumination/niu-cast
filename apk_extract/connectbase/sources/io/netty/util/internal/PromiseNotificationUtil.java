package io.netty.util.internal;

import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;

/* JADX INFO: loaded from: classes3.dex */
public final class PromiseNotificationUtil {
    private PromiseNotificationUtil() {
    }

    public static void tryCancel(Promise<?> promise, InternalLogger internalLogger) {
        if (promise.cancel(false) || internalLogger == null) {
            return;
        }
        Throwable thCause = promise.cause();
        if (thCause == null) {
            internalLogger.warn("Failed to cancel promise because it has succeeded already: {}", promise);
        } else {
            internalLogger.warn("Failed to cancel promise because it has failed already: {}, unnotified cause:", promise, thCause);
        }
    }

    public static void tryFailure(Promise<?> promise, Throwable th2, InternalLogger internalLogger) {
        if (promise.tryFailure(th2) || internalLogger == null) {
            return;
        }
        Throwable thCause = promise.cause();
        if (thCause == null) {
            internalLogger.warn("Failed to mark a promise as failure because it has succeeded already: {}", promise, th2);
        } else if (internalLogger.isWarnEnabled()) {
            internalLogger.warn("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", promise, ThrowableUtil.stackTraceToString(thCause), th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> void trySuccess(Promise<? super V> promise, V v10, InternalLogger internalLogger) {
        if (promise.trySuccess(v10) || internalLogger == null) {
            return;
        }
        Throwable thCause = promise.cause();
        if (thCause == null) {
            internalLogger.warn("Failed to mark a promise as success because it has succeeded already: {}", promise);
        } else {
            internalLogger.warn("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", promise, thCause);
        }
    }
}
