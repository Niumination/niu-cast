package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

/* JADX INFO: loaded from: classes3.dex */
final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE;

    static {
        Method method;
        if ((PlatformDependent.javaVersion() < 8 || PlatformDependent.javaVersion() >= 15) && !PlatformDependent.isAndroid()) {
            method = null;
        } else {
            try {
                Class.forName("org.conscrypt.OpenSSLProvider", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).newInstance();
                method = Class.forName("org.conscrypt.Conscrypt", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).getMethod("isConscrypt", SSLEngine.class);
            } catch (Throwable unused) {
                method = null;
            }
        }
        IS_CONSCRYPT_SSLENGINE = method;
    }

    private Conscrypt() {
    }

    public static boolean isAvailable() {
        return IS_CONSCRYPT_SSLENGINE != null;
    }

    public static boolean isEngineSupported(SSLEngine sSLEngine) {
        try {
            Method method = IS_CONSCRYPT_SSLENGINE;
            return method != null && ((Boolean) method.invoke(null, sSLEngine)).booleanValue();
        } catch (IllegalAccessException unused) {
            return false;
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }
}
