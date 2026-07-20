package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.util.NetUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import kn.p1;
import lm.g2;

/* JADX INFO: loaded from: classes3.dex */
final class SslUtils {
    static final String[] DEFAULT_CIPHER_SUITES;
    static final String[] DEFAULT_TLSV13_CIPHER_SUITES;
    static final int GMSSL_PROTOCOL_VERSION = 257;
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    static final int NOT_ENCRYPTED = -2;
    static final int NOT_ENOUGH_DATA = -1;
    static final int SSL_CONTENT_TYPE_ALERT = 21;
    static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
    static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;
    static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
    static final int SSL_RECORD_HEADER_LENGTH = 5;
    static final String[] TLSV13_CIPHER_SUITES;
    private static final boolean TLSV1_3_JDK_DEFAULT_ENABLED;
    private static final boolean TLSV1_3_JDK_SUPPORTED;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SslUtils.class);
    static final Set<String> TLSV13_CIPHERS = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256, Ciphers.TLS_AES_128_GCM_SHA256, "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256")));

    static {
        String[] strArr = {Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384};
        TLSV13_CIPHER_SUITES = strArr;
        boolean zIsTLSv13SupportedByJDK0 = isTLSv13SupportedByJDK0(null);
        TLSV1_3_JDK_SUPPORTED = zIsTLSv13SupportedByJDK0;
        TLSV1_3_JDK_DEFAULT_ENABLED = isTLSv13EnabledByJDK0(null);
        if (zIsTLSv13SupportedByJDK0) {
            DEFAULT_TLSV13_CIPHER_SUITES = strArr;
        } else {
            DEFAULT_TLSV13_CIPHER_SUITES = EmptyArrays.EMPTY_STRINGS;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        linkedHashSet.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA);
        Collections.addAll(linkedHashSet, DEFAULT_TLSV13_CIPHER_SUITES);
        DEFAULT_CIPHER_SUITES = (String[]) linkedHashSet.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    private SslUtils() {
    }

    public static void addIfSupported(Set<String> set, List<String> list, String... strArr) {
        for (String str : strArr) {
            if (set.contains(str)) {
                list.add(str);
            }
        }
    }

    public static boolean arrayContains(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Code duplicated, block: B:31:0x004f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0058  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062 A[RETURN] */
    public static int getEncryptedPacketLength(ByteBuf byteBuf, int i10) {
        boolean z10;
        int iUnsignedShortBE;
        int i11;
        short unsignedByte;
        int iShortBE;
        boolean z11 = false;
        switch (byteBuf.getUnsignedByte(i10)) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                z10 = true;
                break;
            default:
                z10 = false;
                break;
        }
        if (z10) {
            int i12 = i10 + 1;
            if (byteBuf.getUnsignedByte(i12) == 3 || byteBuf.getShort(i12) == 257) {
                iUnsignedShortBE = unsignedShortBE(byteBuf, i10 + 3) + 5;
                if (iUnsignedShortBE > 5) {
                }
            } else {
                iUnsignedShortBE = 0;
            }
            if (!z11) {
                if ((byteBuf.getUnsignedByte(i10) & 128) != 0) {
                    i11 = 2;
                } else {
                    i11 = 3;
                }
                unsignedByte = byteBuf.getUnsignedByte(i10 + i11 + 1);
                if (unsignedByte == 2 && unsignedByte != 3) {
                    return -2;
                }
                if (i11 == 2) {
                    iShortBE = (shortBE(byteBuf, i10) & p1.f9333c) + 2;
                } else {
                    iShortBE = (shortBE(byteBuf, i10) & 16383) + 3;
                }
                iUnsignedShortBE = iShortBE;
                if (iUnsignedShortBE <= i11) {
                    return -1;
                }
            }
            return iUnsignedShortBE;
        }
        iUnsignedShortBE = 0;
        z11 = z10;
        if (!z11) {
            if ((byteBuf.getUnsignedByte(i10) & 128) != 0) {
                i11 = 2;
            } else {
                i11 = 3;
            }
            unsignedByte = byteBuf.getUnsignedByte(i10 + i11 + 1);
            if (unsignedByte == 2) {
            }
            if (i11 == 2) {
                iShortBE = (shortBE(byteBuf, i10) & p1.f9333c) + 2;
            } else {
                iShortBE = (shortBE(byteBuf, i10) & 16383) + 3;
            }
            iUnsignedShortBE = iShortBE;
            if (iUnsignedShortBE <= i11) {
                return -1;
            }
        }
        return iUnsignedShortBE;
    }

    public static SSLContext getSSLContext(String str) throws NoSuchAlgorithmException, KeyManagementException, NoSuchProviderException {
        SSLContext sSLContext = StringUtil.isNullOrEmpty(str) ? SSLContext.getInstance(getTlsVersion()) : SSLContext.getInstance(getTlsVersion(), str);
        sSLContext.init(null, new TrustManager[0], null);
        return sSLContext;
    }

    private static String getTlsVersion() {
        return TLSV1_3_JDK_SUPPORTED ? SslProtocols.TLS_v1_3 : SslProtocols.TLS_v1_2;
    }

    public static void handleHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th2, boolean z10) {
        channelHandlerContext.flush();
        if (z10) {
            channelHandlerContext.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(th2));
        }
        channelHandlerContext.close();
    }

    public static boolean isTLSv13Cipher(String str) {
        return TLSV13_CIPHERS.contains(str);
    }

    public static boolean isTLSv13EnabledByJDK(Provider provider) {
        return provider == null ? TLSV1_3_JDK_DEFAULT_ENABLED : isTLSv13EnabledByJDK0(provider);
    }

    private static boolean isTLSv13EnabledByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getDefaultSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable th2) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} enables TLSv1.3 by default, assuming no", provider, th2);
            return false;
        }
    }

    public static boolean isTLSv13SupportedByJDK(Provider provider) {
        return provider == null ? TLSV1_3_JDK_SUPPORTED : isTLSv13SupportedByJDK0(provider);
    }

    private static boolean isTLSv13SupportedByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getSupportedSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable th2) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} supports TLSv1.3, assuming no", provider, th2);
            return false;
        }
    }

    public static boolean isValidHostNameForSNI(String str) {
        return (str == null || str.indexOf(46) <= 0 || str.endsWith(".") || str.startsWith("/") || NetUtil.isValidIpV4Address(str) || NetUtil.isValidIpV6Address(str)) ? false : true;
    }

    private static SSLContext newInitContext(Provider provider) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = provider == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider);
        sSLContext.init(null, new TrustManager[0], null);
        return sSLContext;
    }

    private static short shortBE(ByteBuf byteBuf, int i10) {
        short s10 = byteBuf.getShort(i10);
        return byteBuf.order() == ByteOrder.LITTLE_ENDIAN ? Short.reverseBytes(s10) : s10;
    }

    public static ByteBuf toBase64(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        ByteBuf byteBufEncode = Base64.encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), true, Base64Dialect.STANDARD, byteBufAllocator);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return byteBufEncode;
    }

    public static SSLHandshakeException toSSLHandshakeException(Throwable th2) {
        return th2 instanceof SSLHandshakeException ? (SSLHandshakeException) th2 : (SSLHandshakeException) new SSLHandshakeException(th2.getMessage()).initCause(th2);
    }

    private static short unsignedByte(byte b10) {
        return (short) (b10 & 255);
    }

    private static int unsignedShortBE(ByteBuf byteBuf, int i10) {
        int unsignedShort = byteBuf.getUnsignedShort(i10);
        return byteBuf.order() == ByteOrder.LITTLE_ENDIAN ? Integer.reverseBytes(unsignedShort) >>> 16 : unsignedShort;
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, Iterable<String> iterable) {
        if (list.isEmpty()) {
            for (String str : iterable) {
                if (!str.startsWith("SSL_") && !str.contains("_RC4_")) {
                    list.add(str);
                }
            }
        }
    }

    public static void zeroout(ByteBuf byteBuf) {
        if (byteBuf.isReadOnly()) {
            return;
        }
        byteBuf.setZero(0, byteBuf.capacity());
    }

    public static void zerooutAndRelease(ByteBuf byteBuf) {
        zeroout(byteBuf);
        byteBuf.release();
    }

    private static short shortBE(ByteBuffer byteBuffer, int i10) {
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? byteBuffer.getShort(i10) : ByteBufUtil.swapShort(byteBuffer.getShort(i10));
    }

    private static int unsignedShortBE(ByteBuffer byteBuffer, int i10) {
        return shortBE(byteBuffer, i10) & g2.f10190d;
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, String... strArr) {
        useFallbackCiphersIfDefaultIsEmpty(list, Arrays.asList(strArr));
    }

    public static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i10) {
        ByteBuffer byteBuffer = byteBufferArr[i10];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        while (true) {
            int i11 = i10 + 1;
            ByteBuffer byteBufferDuplicate = byteBufferArr[i10].duplicate();
            if (byteBufferDuplicate.remaining() > byteBufferAllocate.remaining()) {
                byteBufferDuplicate.limit(byteBufferAllocate.remaining() + byteBufferDuplicate.position());
            }
            byteBufferAllocate.put(byteBufferDuplicate);
            if (!byteBufferAllocate.hasRemaining()) {
                byteBufferAllocate.flip();
                return getEncryptedPacketLength(byteBufferAllocate);
            }
            i10 = i11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0076 A[RETURN] */
    private static int getEncryptedPacketLength(ByteBuffer byteBuffer) {
        boolean z10;
        int iUnsignedShortBE;
        int i10;
        short sUnsignedByte;
        int iShortBE;
        int iPosition = byteBuffer.position();
        boolean z11 = false;
        switch (unsignedByte(byteBuffer.get(iPosition))) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                z10 = true;
                break;
            default:
                z10 = false;
                break;
        }
        if (z10) {
            int i11 = iPosition + 1;
            if (unsignedByte(byteBuffer.get(i11)) == 3 || byteBuffer.getShort(i11) == 257) {
                iUnsignedShortBE = unsignedShortBE(byteBuffer, iPosition + 3) + 5;
                if (iUnsignedShortBE > 5) {
                }
            } else {
                iUnsignedShortBE = 0;
            }
            if (!z11) {
                if ((unsignedByte(byteBuffer.get(iPosition)) & 128) != 0) {
                    i10 = 2;
                } else {
                    i10 = 3;
                }
                sUnsignedByte = unsignedByte(byteBuffer.get(iPosition + i10 + 1));
                if (sUnsignedByte == 2 && sUnsignedByte != 3) {
                    return -2;
                }
                if (i10 == 2) {
                    iShortBE = (shortBE(byteBuffer, iPosition) & p1.f9333c) + 2;
                } else {
                    iShortBE = (shortBE(byteBuffer, iPosition) & 16383) + 3;
                }
                iUnsignedShortBE = iShortBE;
                if (iUnsignedShortBE <= i10) {
                    return -1;
                }
            }
            return iUnsignedShortBE;
        }
        iUnsignedShortBE = 0;
        z11 = z10;
        if (!z11) {
            if ((unsignedByte(byteBuffer.get(iPosition)) & 128) != 0) {
                i10 = 2;
            } else {
                i10 = 3;
            }
            sUnsignedByte = unsignedByte(byteBuffer.get(iPosition + i10 + 1));
            if (sUnsignedByte == 2) {
            }
            if (i10 == 2) {
                iShortBE = (shortBE(byteBuffer, iPosition) & p1.f9333c) + 2;
            } else {
                iShortBE = (shortBE(byteBuffer, iPosition) & 16383) + 3;
            }
            iUnsignedShortBE = iShortBE;
            if (iUnsignedShortBE <= i10) {
                return -1;
            }
        }
        return iUnsignedShortBE;
    }
}
