package io.netty.channel.kqueue;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.ObjectUtil;
import j1.g;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes2.dex */
final class BsdSocket extends Socket {
    private static final int APPLE_SND_LOW_AT_MAX = 131072;
    static final int BSD_SND_LOW_AT_MAX = Math.min(131072, 32768);
    private static final int FREEBSD_SND_LOW_AT_MAX = 32768;
    private static final int UNSPECIFIED_SOURCE_INTERFACE = 0;

    public BsdSocket(int i10) {
        super(i10);
    }

    private static native int connectx(int i10, int i11, boolean z10, byte[] bArr, int i12, int i13, boolean z11, byte[] bArr2, int i14, int i15, int i16, long j10, int i17, int i18);

    private static native String[] getAcceptFilter(int i10) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i10) throws IOException;

    private static native int getSndLowAt(int i10) throws IOException;

    private static native int getTcpNoPush(int i10) throws IOException;

    private static native int isTcpFastOpen(int i10) throws IOException;

    public static BsdSocket newSocketDgram() {
        return new BsdSocket(Socket.newSocketDgram0());
    }

    public static BsdSocket newSocketDomain() {
        return new BsdSocket(Socket.newSocketDomain0());
    }

    public static BsdSocket newSocketDomainDgram() {
        return new BsdSocket(Socket.newSocketDomainDgram0());
    }

    public static BsdSocket newSocketStream() {
        return new BsdSocket(Socket.newSocketStream0());
    }

    private static native long sendFile(int i10, DefaultFileRegion defaultFileRegion, long j10, long j11, long j12) throws IOException;

    private static native void setAcceptFilter(int i10, String str, String str2) throws IOException;

    private static native void setSndLowAt(int i10, int i11) throws IOException;

    private static native void setTcpFastOpen(int i10, int i11) throws IOException;

    private static native void setTcpNoPush(int i10, int i11) throws IOException;

    public int connectx(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, IovArray iovArray, boolean z10) throws IOException {
        byte[] bArrIpv4MappedIpv6Address;
        int scopeId;
        int i10;
        byte[] bArr;
        int port;
        boolean z11;
        int scopeId2;
        byte[] bArrIpv4MappedIpv6Address2;
        int i11;
        long j10;
        ObjectUtil.checkNotNull(inetSocketAddress2, "Destination InetSocketAddress cannot be null.");
        int i12 = 0;
        int i13 = z10 ? Native.CONNECT_TCP_FASTOPEN : 0;
        if (inetSocketAddress == null) {
            z11 = false;
            i10 = 0;
            port = 0;
            bArr = null;
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            boolean zUseIpv6 = Socket.useIpv6(this, address);
            if (address instanceof Inet6Address) {
                bArrIpv4MappedIpv6Address = address.getAddress();
                scopeId = ((Inet6Address) address).getScopeId();
            } else {
                bArrIpv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(address.getAddress());
                scopeId = 0;
            }
            i10 = scopeId;
            bArr = bArrIpv4MappedIpv6Address;
            port = inetSocketAddress.getPort();
            z11 = zUseIpv6;
        }
        InetAddress address2 = inetSocketAddress2.getAddress();
        boolean zUseIpv7 = Socket.useIpv6(this, address2);
        if (address2 instanceof Inet6Address) {
            byte[] address3 = address2.getAddress();
            scopeId2 = ((Inet6Address) address2).getScopeId();
            bArrIpv4MappedIpv6Address2 = address3;
        } else {
            scopeId2 = 0;
            bArrIpv4MappedIpv6Address2 = NativeInetAddress.ipv4MappedIpv6Address(address2.getAddress());
        }
        int port2 = inetSocketAddress2.getPort();
        if (iovArray == null || iovArray.count() == 0) {
            i11 = 0;
            j10 = 0;
        } else {
            long jMemoryAddress = iovArray.memoryAddress(0);
            int iCount = iovArray.count();
            long size = iovArray.size();
            if (size > 2147483647L) {
                throw new IOException(g.a("IovArray.size() too big: ", size, " bytes."));
            }
            j10 = jMemoryAddress;
            i11 = iCount;
            i12 = (int) size;
        }
        int iConnectx = connectx(intValue(), 0, z11, bArr, i10, port, zUseIpv7, bArrIpv4MappedIpv6Address2, scopeId2, port2, i13, j10, i11, i12);
        if (iConnectx == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
            return -i12;
        }
        return iConnectx < 0 ? Errors.ioResult("connectx", iConnectx) : iConnectx;
    }

    public AcceptFilter getAcceptFilter() throws IOException {
        String[] acceptFilter = getAcceptFilter(intValue());
        return acceptFilter == null ? AcceptFilter.PLATFORM_UNSUPPORTED : new AcceptFilter(acceptFilter[0], acceptFilter[1]);
    }

    public PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    public int getSndLowAt() throws IOException {
        return getSndLowAt(intValue());
    }

    public boolean isTcpFastOpen() throws IOException {
        return isTcpFastOpen(intValue()) != 0;
    }

    public boolean isTcpNoPush() throws IOException {
        return getTcpNoPush(intValue()) != 0;
    }

    public long sendFile(DefaultFileRegion defaultFileRegion, long j10, long j11, long j12) throws IOException {
        defaultFileRegion.open();
        long jSendFile = sendFile(intValue(), defaultFileRegion, j10, j11, j12);
        return jSendFile >= 0 ? jSendFile : Errors.ioResult("sendfile", (int) jSendFile);
    }

    public void setAcceptFilter(AcceptFilter acceptFilter) throws IOException {
        setAcceptFilter(intValue(), acceptFilter.filterName(), acceptFilter.filterArgs());
    }

    public void setSndLowAt(int i10) throws IOException {
        setSndLowAt(intValue(), i10);
    }

    public void setTcpFastOpen(boolean z10) throws IOException {
        setTcpFastOpen(intValue(), z10 ? 1 : 0);
    }

    public void setTcpNoPush(boolean z10) throws IOException {
        setTcpNoPush(intValue(), z10 ? 1 : 0);
    }
}
