package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class ZlibCodecFactory {
    private static final int DEFAULT_JDK_MEM_LEVEL = 8;
    private static final int DEFAULT_JDK_WINDOW_SIZE = 15;
    private static final InternalLogger logger;
    private static final boolean noJdkZlibDecoder;
    private static final boolean noJdkZlibEncoder;
    private static final boolean supportsWindowSizeAndMemLevel;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ZlibCodecFactory.class);
        logger = internalLoggerFactory;
        boolean z10 = true;
        boolean z11 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibDecoder", PlatformDependent.javaVersion() < 7);
        noJdkZlibDecoder = z11;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibDecoder: {}", Boolean.valueOf(z11));
        boolean z12 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibEncoder", false);
        noJdkZlibEncoder = z12;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibEncoder: {}", Boolean.valueOf(z12));
        if (!z11 && PlatformDependent.javaVersion() < 7) {
            z10 = false;
        }
        supportsWindowSizeAndMemLevel = z10;
    }

    private ZlibCodecFactory() {
    }

    public static boolean isSupportingWindowSizeAndMemLevel() {
        return supportsWindowSizeAndMemLevel;
    }

    public static ZlibDecoder newZlibDecoder() {
        return (PlatformDependent.javaVersion() < 7 || noJdkZlibDecoder) ? new JZlibDecoder() : new JdkZlibDecoder(true);
    }

    public static ZlibEncoder newZlibEncoder(int i10) {
        return (PlatformDependent.javaVersion() < 7 || noJdkZlibEncoder) ? new JZlibEncoder(i10) : new JdkZlibEncoder(i10);
    }

    public static ZlibDecoder newZlibDecoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(zlibWrapper, true);
        }
        return new JZlibDecoder(zlibWrapper);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper);
        }
        return new JZlibEncoder(zlibWrapper);
    }

    public static ZlibDecoder newZlibDecoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(bArr);
        }
        return new JZlibDecoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i10) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper, i10);
        }
        return new JZlibEncoder(zlibWrapper, i10);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i10, int i11, int i12) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i11 == 15 && i12 == 8) {
            return new JdkZlibEncoder(zlibWrapper, i10);
        }
        return new JZlibEncoder(zlibWrapper, i10, i11, i12);
    }

    public static ZlibEncoder newZlibEncoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(bArr);
        }
        return new JZlibEncoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i10, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(i10, bArr);
        }
        return new JZlibEncoder(i10, bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i10, int i11, int i12, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i11 == 15 && i12 == 8) {
            return new JdkZlibEncoder(i10, bArr);
        }
        return new JZlibEncoder(i10, i11, i12, bArr);
    }
}
