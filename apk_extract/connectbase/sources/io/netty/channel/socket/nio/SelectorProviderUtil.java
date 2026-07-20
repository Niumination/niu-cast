package io.netty.channel.socket.nio;

import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ProtocolFamily;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;

/* JADX INFO: loaded from: classes2.dex */
final class SelectorProviderUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelectorProviderUtil.class);

    private SelectorProviderUtil() {
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static Method findOpenMethod(String str) {
        if (PlatformDependent.javaVersion() < 15) {
            return null;
        }
        try {
            return SelectorProvider.class.getMethod(str, ProtocolFamily.class);
        } catch (Throwable th2) {
            logger.debug("SelectorProvider.{}(ProtocolFamily) not available, will use default", str, th2);
            return null;
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <C extends Channel> C newChannel(Method method, SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) throws IOException {
        if (internetProtocolFamily == null || method == null) {
            return null;
        }
        try {
            return (C) method.invoke(selectorProvider, ProtocolFamilyConverter.convert(internetProtocolFamily));
        } catch (IllegalAccessException e10) {
            throw new IOException(e10);
        } catch (InvocationTargetException e11) {
            throw new IOException(e11);
        }
    }
}
