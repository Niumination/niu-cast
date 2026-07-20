package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes3.dex */
final class CleanerJava6 implements Cleaner {
    private static final Field CLEANER_FIELD;
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CleanerJava6.class);

    static {
        Field field;
        Method declaredMethod;
        Object object;
        long jObjectFieldOffset;
        final ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
        long j10 = -1;
        Throwable th2 = null;
        try {
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava6.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = byteBufferAllocateDirect.getClass().getDeclaredField("cleaner");
                        if (PlatformDependent.hasUnsafe()) {
                            return declaredField;
                        }
                        declaredField.setAccessible(true);
                        return declaredField;
                    } catch (Throwable th3) {
                        return th3;
                    }
                }
            });
            if (objDoPrivileged instanceof Throwable) {
                throw ((Throwable) objDoPrivileged);
            }
            field = (Field) objDoPrivileged;
            if (PlatformDependent.hasUnsafe()) {
                jObjectFieldOffset = PlatformDependent0.objectFieldOffset(field);
                object = PlatformDependent0.getObject(byteBufferAllocateDirect, jObjectFieldOffset);
            } else {
                object = field.get(byteBufferAllocateDirect);
                jObjectFieldOffset = -1;
            }
            declaredMethod = object.getClass().getDeclaredMethod("clean", null);
            declaredMethod.invoke(object, null);
            j10 = jObjectFieldOffset;
            if (th2 == null) {
                logger.debug("java.nio.ByteBuffer.cleaner(): available");
            } else {
                logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", th2);
            }
            CLEANER_FIELD = field;
            CLEANER_FIELD_OFFSET = j10;
            CLEAN_METHOD = declaredMethod;
        } catch (Throwable th3) {
            field = null;
            declaredMethod = null;
            th2 = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void freeDirectBuffer0(ByteBuffer byteBuffer) throws Exception {
        long j10 = CLEANER_FIELD_OFFSET;
        Object object = j10 == -1 ? CLEANER_FIELD.get(byteBuffer) : PlatformDependent0.getObject(byteBuffer, j10);
        if (object != null) {
            CLEAN_METHOD.invoke(object, null);
        }
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Throwable th2 = (Throwable) AccessController.doPrivileged(new PrivilegedAction<Throwable>() { // from class: io.netty.util.internal.CleanerJava6.2
            @Override // java.security.PrivilegedAction
            public Throwable run() {
                try {
                    CleanerJava6.freeDirectBuffer0(byteBuffer);
                    return null;
                } catch (Throwable th3) {
                    return th3;
                }
            }
        });
        if (th2 != null) {
            PlatformDependent0.throwException(th2);
        }
    }

    public static boolean isSupported() {
        return (CLEANER_FIELD_OFFSET == -1 && CLEANER_FIELD == null) ? false : true;
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            if (System.getSecurityManager() != null) {
                freeDirectBufferPrivileged(byteBuffer);
                return;
            }
            try {
                freeDirectBuffer0(byteBuffer);
            } catch (Throwable th2) {
                PlatformDependent0.throwException(th2);
            }
        }
    }
}
