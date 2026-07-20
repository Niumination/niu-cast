package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes3.dex */
final class SocksCommonUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SocksRequest UNKNOWN_SOCKS_REQUEST = new UnknownSocksRequest();
    public static final SocksResponse UNKNOWN_SOCKS_RESPONSE = new UnknownSocksResponse();
    private static final char ipv6hextetSeparator = ':';

    private SocksCommonUtils() {
    }

    private static void appendHextet(StringBuilder sb2, byte[] bArr, int i10) throws Throwable {
        StringUtil.toHexString(sb2, bArr, i10 << 1, 2);
    }

    public static String ipv6toStr(byte[] bArr) throws Throwable {
        StringBuilder sb2 = new StringBuilder(39);
        ipv6toStr(sb2, bArr, 0, 8);
        return sb2.toString();
    }

    public static String readUsAscii(ByteBuf byteBuf, int i10) {
        String string = byteBuf.toString(byteBuf.readerIndex(), i10, CharsetUtil.US_ASCII);
        byteBuf.skipBytes(i10);
        return string;
    }

    private static void ipv6toStr(StringBuilder sb2, byte[] bArr, int i10, int i11) throws Throwable {
        int i12 = i11 - 1;
        while (i10 < i12) {
            appendHextet(sb2, bArr, i10);
            sb2.append(':');
            i10++;
        }
        appendHextet(sb2, bArr, i10);
    }
}
