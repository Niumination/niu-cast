package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

/* JADX INFO: loaded from: classes3.dex */
final class BouncyCastle {
    private static final boolean BOUNCY_CASTLE_ON_CLASSPATH;

    static {
        boolean z10;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider");
            z10 = true;
        } catch (Throwable unused) {
            z10 = false;
        }
        BOUNCY_CASTLE_ON_CLASSPATH = z10;
    }

    private BouncyCastle() {
    }

    public static boolean isAvailable() {
        return BOUNCY_CASTLE_ON_CLASSPATH;
    }

    public static boolean isInUse(SSLEngine sSLEngine) {
        return sSLEngine.getClass().getPackage().getName().startsWith("org.bouncycastle.jsse.provider");
    }
}
