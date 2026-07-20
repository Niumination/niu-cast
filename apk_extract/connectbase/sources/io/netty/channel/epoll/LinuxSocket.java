package io.netty.channel.epoll;

import io.netty.channel.ChannelException;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public final class LinuxSocket extends Socket {
    static final InetAddress INET6_ANY = unsafeInetAddrByName("::");
    private static final InetAddress INET_ANY = unsafeInetAddrByName("0.0.0.0");
    private static final long MAX_UINT32_T = 4294967295L;

    public LinuxSocket(int i10) {
        super(i10);
    }

    private static InetAddress deriveInetAddress(NetworkInterface networkInterface, boolean z10) {
        InetAddress inetAddress = z10 ? INET6_ANY : INET_ANY;
        if (networkInterface != null) {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if ((inetAddressNextElement instanceof Inet6Address) == z10) {
                    return inetAddressNextElement;
                }
            }
        }
        return inetAddress;
    }

    private static native int getInterface(int i10, boolean z10);

    private static native int getIpMulticastLoop(int i10, boolean z10) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i10) throws IOException;

    private static native int getSoBusyPoll(int i10) throws IOException;

    private static native int getTcpDeferAccept(int i10) throws IOException;

    private static native void getTcpInfo(int i10, long[] jArr) throws IOException;

    private static native int getTcpKeepCnt(int i10) throws IOException;

    private static native int getTcpKeepIdle(int i10) throws IOException;

    private static native int getTcpKeepIntvl(int i10) throws IOException;

    private static native int getTcpNotSentLowAt(int i10) throws IOException;

    private static native int getTcpUserTimeout(int i10) throws IOException;

    private static native int getTimeToLive(int i10) throws IOException;

    private static InetAddress inetAddress(int i10) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i10 >>> 24) & 255), (byte) ((i10 >>> 16) & 255), (byte) ((i10 >>> 8) & 255), (byte) (i10 & 255)});
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    private static int interfaceIndex(NetworkInterface networkInterface) {
        if (PlatformDependent.javaVersion() >= 7) {
            return networkInterface.getIndex();
        }
        return -1;
    }

    private static native int isIpFreeBind(int i10) throws IOException;

    private static native int isIpRecvOrigDestAddr(int i10) throws IOException;

    private static native int isIpTransparent(int i10) throws IOException;

    private static native int isTcpCork(int i10) throws IOException;

    private static native int isTcpQuickAck(int i10) throws IOException;

    private static native int isUdpGro(int i10) throws IOException;

    private static native void joinGroup(int i10, boolean z10, byte[] bArr, byte[] bArr2, int i11, int i12) throws IOException;

    private static native void joinSsmGroup(int i10, boolean z10, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3) throws IOException;

    private static native void leaveGroup(int i10, boolean z10, byte[] bArr, byte[] bArr2, int i11, int i12) throws IOException;

    private static native void leaveSsmGroup(int i10, boolean z10, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3) throws IOException;

    public static LinuxSocket newSocketDgram(boolean z10) {
        return new LinuxSocket(Socket.newSocketDgram0(z10));
    }

    public static LinuxSocket newSocketDomain() {
        return new LinuxSocket(Socket.newSocketDomain0());
    }

    public static LinuxSocket newSocketDomainDgram() {
        return new LinuxSocket(Socket.newSocketDomainDgram0());
    }

    public static LinuxSocket newSocketStream(boolean z10) {
        return new LinuxSocket(Socket.newSocketStream0(z10));
    }

    private static native long sendFile(int i10, DefaultFileRegion defaultFileRegion, long j10, long j11, long j12) throws IOException;

    private static native void setInterface(int i10, boolean z10, byte[] bArr, int i11, int i12) throws IOException;

    private static native void setIpFreeBind(int i10, int i11) throws IOException;

    private static native void setIpMulticastLoop(int i10, boolean z10, int i11) throws IOException;

    private static native void setIpRecvOrigDestAddr(int i10, int i11) throws IOException;

    private static native void setIpTransparent(int i10, int i11) throws IOException;

    private static native void setSoBusyPoll(int i10, int i11) throws IOException;

    private static native void setTcpCork(int i10, int i11) throws IOException;

    private static native void setTcpDeferAccept(int i10, int i11) throws IOException;

    private static native void setTcpFastOpen(int i10, int i11) throws IOException;

    private static native void setTcpKeepCnt(int i10, int i11) throws IOException;

    private static native void setTcpKeepIdle(int i10, int i11) throws IOException;

    private static native void setTcpKeepIntvl(int i10, int i11) throws IOException;

    private static native void setTcpMd5Sig(int i10, boolean z10, byte[] bArr, int i11, byte[] bArr2) throws IOException;

    private static native void setTcpNotSentLowAt(int i10, int i11) throws IOException;

    private static native void setTcpQuickAck(int i10, int i11) throws IOException;

    private static native void setTcpUserTimeout(int i10, int i11) throws IOException;

    private static native void setTimeToLive(int i10, int i11) throws IOException;

    private static native void setUdpGro(int i10, int i11) throws IOException;

    private static InetAddress unsafeInetAddrByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e10) {
            throw new ChannelException(e10);
        }
    }

    public InternetProtocolFamily family() {
        return this.ipv6 ? InternetProtocolFamily.IPv6 : InternetProtocolFamily.IPv4;
    }

    public InetAddress getInterface() throws IOException {
        NetworkInterface networkInterface = getNetworkInterface();
        if (networkInterface == null) {
            return null;
        }
        Enumeration<InetAddress> enumerationAddressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
        if (enumerationAddressesFromNetworkInterface.hasMoreElements()) {
            return enumerationAddressesFromNetworkInterface.nextElement();
        }
        return null;
    }

    public NetworkInterface getNetworkInterface() throws IOException {
        int i10 = getInterface(intValue(), this.ipv6);
        if (this.ipv6) {
            if (PlatformDependent.javaVersion() >= 7) {
                return NetworkInterface.getByIndex(i10);
            }
            return null;
        }
        InetAddress inetAddress = inetAddress(i10);
        if (inetAddress != null) {
            return NetworkInterface.getByInetAddress(inetAddress);
        }
        return null;
    }

    public PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    public int getSoBusyPoll() throws IOException {
        return getSoBusyPoll(intValue());
    }

    public int getTcpDeferAccept() throws IOException {
        return getTcpDeferAccept(intValue());
    }

    public void getTcpInfo(EpollTcpInfo epollTcpInfo) throws IOException {
        getTcpInfo(intValue(), epollTcpInfo.info);
    }

    public int getTcpKeepCnt() throws IOException {
        return getTcpKeepCnt(intValue());
    }

    public int getTcpKeepIdle() throws IOException {
        return getTcpKeepIdle(intValue());
    }

    public int getTcpKeepIntvl() throws IOException {
        return getTcpKeepIntvl(intValue());
    }

    public long getTcpNotSentLowAt() throws IOException {
        return ((long) getTcpNotSentLowAt(intValue())) & 4294967295L;
    }

    public int getTcpUserTimeout() throws IOException {
        return getTcpUserTimeout(intValue());
    }

    public int getTimeToLive() throws IOException {
        return getTimeToLive(intValue());
    }

    public boolean isIpFreeBind() throws IOException {
        return isIpFreeBind(intValue()) != 0;
    }

    public boolean isIpRecvOrigDestAddr() throws IOException {
        return isIpRecvOrigDestAddr(intValue()) != 0;
    }

    public boolean isIpTransparent() throws IOException {
        return isIpTransparent(intValue()) != 0;
    }

    public boolean isLoopbackModeDisabled() throws IOException {
        return getIpMulticastLoop(intValue(), this.ipv6) == 0;
    }

    public boolean isTcpCork() throws IOException {
        return isTcpCork(intValue()) != 0;
    }

    public boolean isTcpQuickAck() throws IOException {
        return isTcpQuickAck(intValue()) != 0;
    }

    public boolean isUdpGro() throws IOException {
        return isUdpGro(intValue()) != 0;
    }

    public void joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) throws IOException {
        NativeInetAddress nativeInetAddressNewInstance = NativeInetAddress.newInstance(inetAddress);
        boolean z10 = inetAddress instanceof Inet6Address;
        NativeInetAddress nativeInetAddressNewInstance2 = NativeInetAddress.newInstance(deriveInetAddress(networkInterface, z10));
        if (inetAddress2 == null) {
            joinGroup(intValue(), this.ipv6 && z10, nativeInetAddressNewInstance.address(), nativeInetAddressNewInstance2.address(), nativeInetAddressNewInstance.scopeId(), interfaceIndex(networkInterface));
        } else {
            if (inetAddress2.getClass() != inetAddress.getClass()) {
                throw new IllegalArgumentException("Source address is different type to group");
            }
            joinSsmGroup(intValue(), this.ipv6 && z10, nativeInetAddressNewInstance.address(), nativeInetAddressNewInstance2.address(), nativeInetAddressNewInstance.scopeId(), interfaceIndex(networkInterface), NativeInetAddress.newInstance(inetAddress2).address());
        }
    }

    public void leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) throws IOException {
        NativeInetAddress nativeInetAddressNewInstance = NativeInetAddress.newInstance(inetAddress);
        boolean z10 = inetAddress instanceof Inet6Address;
        NativeInetAddress nativeInetAddressNewInstance2 = NativeInetAddress.newInstance(deriveInetAddress(networkInterface, z10));
        if (inetAddress2 == null) {
            leaveGroup(intValue(), this.ipv6 && z10, nativeInetAddressNewInstance.address(), nativeInetAddressNewInstance2.address(), nativeInetAddressNewInstance.scopeId(), interfaceIndex(networkInterface));
        } else {
            if (inetAddress2.getClass() != inetAddress.getClass()) {
                throw new IllegalArgumentException("Source address is different type to group");
            }
            leaveSsmGroup(intValue(), this.ipv6 && z10, nativeInetAddressNewInstance.address(), nativeInetAddressNewInstance2.address(), nativeInetAddressNewInstance.scopeId(), interfaceIndex(networkInterface), NativeInetAddress.newInstance(inetAddress2).address());
        }
    }

    public int recvmmsg(NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i10, int i11) throws IOException {
        return Native.recvmmsg(intValue(), this.ipv6, nativeDatagramPacketArr, i10, i11);
    }

    public int recvmsg(NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket) throws IOException {
        return Native.recvmsg(intValue(), this.ipv6, nativeDatagramPacket);
    }

    public long sendFile(DefaultFileRegion defaultFileRegion, long j10, long j11, long j12) throws IOException {
        defaultFileRegion.open();
        long jSendFile = sendFile(intValue(), defaultFileRegion, j10, j11, j12);
        return jSendFile >= 0 ? jSendFile : Errors.ioResult("sendfile", (int) jSendFile);
    }

    public int sendmmsg(NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i10, int i11) throws IOException {
        return Native.sendmmsg(intValue(), this.ipv6, nativeDatagramPacketArr, i10, i11);
    }

    public void setInterface(InetAddress inetAddress) throws IOException {
        NativeInetAddress nativeInetAddressNewInstance = NativeInetAddress.newInstance(inetAddress);
        setInterface(intValue(), this.ipv6, nativeInetAddressNewInstance.address(), nativeInetAddressNewInstance.scopeId(), interfaceIndex(inetAddress));
    }

    public void setIpFreeBind(boolean z10) throws IOException {
        setIpFreeBind(intValue(), z10 ? 1 : 0);
    }

    public void setIpRecvOrigDestAddr(boolean z10) throws IOException {
        setIpRecvOrigDestAddr(intValue(), z10 ? 1 : 0);
    }

    public void setIpTransparent(boolean z10) throws IOException {
        setIpTransparent(intValue(), z10 ? 1 : 0);
    }

    public void setLoopbackModeDisabled(boolean z10) throws IOException {
        setIpMulticastLoop(intValue(), this.ipv6, !z10 ? 1 : 0);
    }

    public void setNetworkInterface(NetworkInterface networkInterface) throws IOException {
        InetAddress inetAddressDeriveInetAddress = deriveInetAddress(networkInterface, family() == InternetProtocolFamily.IPv6);
        if (inetAddressDeriveInetAddress.equals(family() == InternetProtocolFamily.IPv4 ? INET_ANY : INET6_ANY)) {
            throw new IOException("NetworkInterface does not support " + family());
        }
        NativeInetAddress nativeInetAddressNewInstance = NativeInetAddress.newInstance(inetAddressDeriveInetAddress);
        setInterface(intValue(), this.ipv6, nativeInetAddressNewInstance.address(), nativeInetAddressNewInstance.scopeId(), interfaceIndex(networkInterface));
    }

    public void setSoBusyPoll(int i10) throws IOException {
        setSoBusyPoll(intValue(), i10);
    }

    public void setTcpCork(boolean z10) throws IOException {
        setTcpCork(intValue(), z10 ? 1 : 0);
    }

    public void setTcpDeferAccept(int i10) throws IOException {
        setTcpDeferAccept(intValue(), i10);
    }

    public void setTcpFastOpen(int i10) throws IOException {
        setTcpFastOpen(intValue(), i10);
    }

    public void setTcpKeepCnt(int i10) throws IOException {
        setTcpKeepCnt(intValue(), i10);
    }

    public void setTcpKeepIdle(int i10) throws IOException {
        setTcpKeepIdle(intValue(), i10);
    }

    public void setTcpKeepIntvl(int i10) throws IOException {
        setTcpKeepIntvl(intValue(), i10);
    }

    public void setTcpMd5Sig(InetAddress inetAddress, byte[] bArr) throws IOException {
        NativeInetAddress nativeInetAddressNewInstance = NativeInetAddress.newInstance(inetAddress);
        setTcpMd5Sig(intValue(), this.ipv6, nativeInetAddressNewInstance.address(), nativeInetAddressNewInstance.scopeId(), bArr);
    }

    public void setTcpNotSentLowAt(long j10) throws IOException {
        if (j10 < 0 || j10 > 4294967295L) {
            throw new IllegalArgumentException("tcpNotSentLowAt must be a uint32_t");
        }
        setTcpNotSentLowAt(intValue(), (int) j10);
    }

    public void setTcpQuickAck(boolean z10) throws IOException {
        setTcpQuickAck(intValue(), z10 ? 1 : 0);
    }

    public void setTcpUserTimeout(int i10) throws IOException {
        setTcpUserTimeout(intValue(), i10);
    }

    public void setTimeToLive(int i10) throws IOException {
        setTimeToLive(intValue(), i10);
    }

    public void setUdpGro(boolean z10) throws IOException {
        setUdpGro(intValue(), z10 ? 1 : 0);
    }

    private static int interfaceIndex(InetAddress inetAddress) throws IOException {
        NetworkInterface byInetAddress;
        if (PlatformDependent.javaVersion() < 7 || (byInetAddress = NetworkInterface.getByInetAddress(inetAddress)) == null) {
            return -1;
        }
        return byInetAddress.getIndex();
    }

    public static LinuxSocket newSocketDgram() {
        return newSocketDgram(Socket.isIPv6Preferred());
    }

    public static LinuxSocket newSocketStream() {
        return newSocketStream(Socket.isIPv6Preferred());
    }
}
