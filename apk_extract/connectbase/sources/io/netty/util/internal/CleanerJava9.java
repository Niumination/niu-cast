package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class CleanerJava9 implements Cleaner {
    private static final Method INVOKE_CLEANER;
    private static final InternalLogger logger;

    /* JADX WARN: Code duplicated, block: B:11:0x0033  */
    /* JADX WARN: Code duplicated, block: B:12:0x0039  */
    static {
        Throwable unsupportedOperationException;
        Method method;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) CleanerJava9.class);
        logger = internalLoggerFactory;
        Throwable th2 = null;
        if (PlatformDependent0.hasUnsafe()) {
            final ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava9.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Unsafe unsafe = PlatformDependent0.UNSAFE;
                        Method declaredMethod = unsafe.getClass().getDeclaredMethod("invokeCleaner", ByteBuffer.class);
                        declaredMethod.invoke(unsafe, byteBufferAllocateDirect);
                        return declaredMethod;
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                        return e10;
                    }
                }
            });
            if (objDoPrivileged instanceof Throwable) {
                unsupportedOperationException = (Throwable) objDoPrivileged;
            } else {
                method = (Method) objDoPrivileged;
            }
            if (th2 == null) {
                internalLoggerFactory.debug("java.nio.ByteBuffer.cleaner(): available");
            } else {
                internalLoggerFactory.debug("java.nio.ByteBuffer.cleaner(): unavailable", th2);
            }
            INVOKE_CLEANER = method;
        }
        unsupportedOperationException = new UnsupportedOperationException("sun.misc.Unsafe unavailable");
        th2 = unsupportedOperationException;
        method = null;
        if (th2 == null) {
            internalLoggerFactory.debug("java.nio.ByteBuffer.cleaner(): available");
        } else {
            internalLoggerFactory.debug("java.nio.ByteBuffer.cleaner(): unavailable", th2);
        }
        INVOKE_CLEANER = method;
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Exception exc = (Exception) AccessController.doPrivileged(new PrivilegedAction<Exception>() { // from class: io.netty.util.internal.CleanerJava9.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Exception run() {
                try {
                    CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer);
                    return null;
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    return e10;
                }
            }
        });
        if (exc != null) {
            PlatformDependent0.throwException(exc);
        }
    }

    public static boolean isSupported() {
        return INVOKE_CLEANER != null;
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (System.getSecurityManager() != null) {
            freeDirectBufferPrivileged(byteBuffer);
            return;
        }
        try {
            INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer);
        } catch (Throwable th2) {
            PlatformDependent0.throwException(th2);
        }
    }
}
