package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public final class NativeInetAddress {
    private static final byte[] IPV4_MAPPED_IPV6_PREFIX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1};
    final byte[] address;
    final int scopeId;

    public NativeInetAddress(byte[] bArr, int i10) {
        this.address = bArr;
        this.scopeId = i10;
    }

    public static void copyIpv4MappedIpv6Address(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = IPV4_MAPPED_IPV6_PREFIX;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
    }

    public static int decodeInt(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public static byte[] ipv4MappedIpv6Address(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        copyIpv4MappedIpv6Address(bArr, bArr2);
        return bArr2;
    }

    public static NativeInetAddress newInstance(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        return inetAddress instanceof Inet6Address ? new NativeInetAddress(address, ((Inet6Address) inetAddress).getScopeId()) : new NativeInetAddress(ipv4MappedIpv6Address(address));
    }

    public byte[] address() {
        return this.address;
    }

    public int scopeId() {
        return this.scopeId;
    }

    public static InetSocketAddress address(byte[] bArr, int i10, int i11) {
        InetAddress byAddress;
        int i12 = i10 + i11;
        int iDecodeInt = decodeInt(bArr, i12 - 4);
        try {
            if (i11 == 8) {
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i10, bArr2, 0, 4);
                byAddress = InetAddress.getByAddress(bArr2);
            } else {
                if (i11 != 24) {
                    throw new Error();
                }
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr, i10, bArr3, 0, 16);
                byAddress = Inet6Address.getByAddress((String) null, bArr3, decodeInt(bArr, i12 - 8));
            }
            return new InetSocketAddress(byAddress, iDecodeInt);
        } catch (UnknownHostException e10) {
            throw new Error("Should never happen", e10);
        }
    }

    public NativeInetAddress(byte[] bArr) {
        this(bArr, 0);
    }
}
