package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException runtimeException) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(runtimeException.getClass().getName())) {
            return runtimeException;
        }
        throw runtimeException;
    }

    public static Throwable trySetAccessible(AccessibleObject accessibleObject, boolean z10) {
        if (z10 && !PlatformDependent0.isExplicitTryReflectionSetAccessible()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            accessibleObject.setAccessible(true);
            return null;
        } catch (SecurityException e10) {
            return e10;
        } catch (RuntimeException e11) {
            return handleInaccessibleObjectException(e11);
        }
    }
}
