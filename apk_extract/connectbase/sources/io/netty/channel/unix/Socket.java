package io.netty.channel.unix;

import io.netty.channel.ChannelException;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import rs.f;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
public class Socket extends FileDescriptor {

    @Deprecated
    public static final int UDS_SUN_PATH_SIZE = 100;
    private static volatile boolean isIpv6Preferred;
    protected final boolean ipv6;

    public Socket(int i10) {
        super(i10);
        this.ipv6 = isIPv6(i10);
    }

    private static native int accept(int i10, byte[] bArr);

    private static native int bind(int i10, boolean z10, byte[] bArr, int i11, int i12);

    private static native int bindDomainSocket(int i10, byte[] bArr);

    private static native int connect(int i10, boolean z10, byte[] bArr, int i11, int i12);

    private static native int connectDomainSocket(int i10, byte[] bArr);

    private static native int disconnect(int i10, boolean z10);

    private static native int finishConnect(int i10);

    private static native int getIntOpt(int i10, int i11, int i12) throws IOException;

    private static native void getRawOptAddress(int i10, int i11, int i12, long j10, int i13) throws IOException;

    private static native void getRawOptArray(int i10, int i11, int i12, byte[] bArr, int i13, int i14) throws IOException;

    private static native int getReceiveBufferSize(int i10) throws IOException;

    private static native int getSendBufferSize(int i10) throws IOException;

    private static native int getSoError(int i10) throws IOException;

    private static native int getSoLinger(int i10) throws IOException;

    private static native int getTrafficClass(int i10, boolean z10) throws IOException;

    public static void initialize() {
        isIpv6Preferred = isIPv6Preferred0(NetUtil.isIpV4StackPreferred());
    }

    private static native int isBroadcast(int i10) throws IOException;

    private static native boolean isIPv6(int i10);

    public static boolean isIPv6Preferred() {
        return isIpv6Preferred;
    }

    private static native boolean isIPv6Preferred0(boolean z10);

    private static native int isKeepAlive(int i10) throws IOException;

    private static native int isReuseAddress(int i10) throws IOException;

    private static native int isReusePort(int i10) throws IOException;

    private static native int isTcpNoDelay(int i10) throws IOException;

    private static native int listen(int i10, int i11);

    private static native byte[] localAddress(int i10);

    private static native byte[] localDomainSocketAddress(int i10);

    private static native int msgFastopen();

    public static Socket newSocketDgram() {
        return new Socket(newSocketDgram0());
    }

    public static int newSocketDgram0() {
        return newSocketDgram0(isIPv6Preferred());
    }

    private static native int newSocketDgramFd(boolean z10);

    public static Socket newSocketDomain() {
        return new Socket(newSocketDomain0());
    }

    public static int newSocketDomain0() {
        int iNewSocketDomainFd = newSocketDomainFd();
        if (iNewSocketDomainFd >= 0) {
            return iNewSocketDomainFd;
        }
        throw new ChannelException(Errors.newIOException("newSocketDomain", iNewSocketDomainFd));
    }

    public static Socket newSocketDomainDgram() {
        return new Socket(newSocketDomainDgram0());
    }

    public static int newSocketDomainDgram0() {
        int iNewSocketDomainDgramFd = newSocketDomainDgramFd();
        if (iNewSocketDomainDgramFd >= 0) {
            return iNewSocketDomainDgramFd;
        }
        throw new ChannelException(Errors.newIOException("newSocketDomainDgram", iNewSocketDomainDgramFd));
    }

    private static native int newSocketDomainDgramFd();

    private static native int newSocketDomainFd();

    public static Socket newSocketStream() {
        return new Socket(newSocketStream0());
    }

    public static int newSocketStream0() {
        return newSocketStream0(isIPv6Preferred());
    }

    private static native int newSocketStreamFd(boolean z10);

    private static native int recv(int i10, ByteBuffer byteBuffer, int i11, int i12);

    private static native int recvAddress(int i10, long j10, int i11, int i12);

    private static native int recvFd(int i10);

    private static native DatagramSocketAddress recvFrom(int i10, ByteBuffer byteBuffer, int i11, int i12) throws IOException;

    private static native DatagramSocketAddress recvFromAddress(int i10, long j10, int i11, int i12) throws IOException;

    private static native DomainDatagramSocketAddress recvFromAddressDomainSocket(int i10, long j10, int i11, int i12) throws IOException;

    private static native DomainDatagramSocketAddress recvFromDomainSocket(int i10, ByteBuffer byteBuffer, int i11, int i12) throws IOException;

    private static native byte[] remoteAddress(int i10);

    private static native byte[] remoteDomainSocketAddress(int i10);

    private static native int send(int i10, ByteBuffer byteBuffer, int i11, int i12);

    private static native int sendAddress(int i10, long j10, int i11, int i12);

    private static native int sendFd(int i10, int i11);

    private static native int sendTo(int i10, boolean z10, ByteBuffer byteBuffer, int i11, int i12, byte[] bArr, int i13, int i14, int i15);

    private static native int sendToAddress(int i10, boolean z10, long j10, int i11, int i12, byte[] bArr, int i13, int i14, int i15);

    private static native int sendToAddressDomainSocket(int i10, long j10, int i11, int i12, byte[] bArr);

    private static native int sendToAddresses(int i10, boolean z10, long j10, int i11, byte[] bArr, int i12, int i13, int i14);

    private static native int sendToAddressesDomainSocket(int i10, long j10, int i11, byte[] bArr);

    private static native int sendToDomainSocket(int i10, ByteBuffer byteBuffer, int i11, int i12, byte[] bArr);

    private static native void setBroadcast(int i10, int i11) throws IOException;

    private static native void setIntOpt(int i10, int i11, int i12, int i13) throws IOException;

    private static native void setKeepAlive(int i10, int i11) throws IOException;

    private static native void setRawOptAddress(int i10, int i11, int i12, long j10, int i13) throws IOException;

    private static native void setRawOptArray(int i10, int i11, int i12, byte[] bArr, int i13, int i14) throws IOException;

    private static native void setReceiveBufferSize(int i10, int i11) throws IOException;

    private static native void setReuseAddress(int i10, int i11) throws IOException;

    private static native void setReusePort(int i10, int i11) throws IOException;

    private static native void setSendBufferSize(int i10, int i11) throws IOException;

    private static native void setSoLinger(int i10, int i11) throws IOException;

    private static native void setTcpNoDelay(int i10, int i11) throws IOException;

    private static native void setTrafficClass(int i10, boolean z10, int i11) throws IOException;

    public static boolean shouldUseIpv6(InternetProtocolFamily internetProtocolFamily) {
        if (internetProtocolFamily == null) {
            return isIPv6Preferred();
        }
        return internetProtocolFamily == InternetProtocolFamily.IPv6;
    }

    private static native int shutdown(int i10, boolean z10, boolean z11);

    private boolean useIpv6(InetAddress inetAddress) {
        return useIpv6(this, inetAddress);
    }

    public final int accept(byte[] bArr) throws IOException {
        int iAccept = accept(this.f8302fd, bArr);
        if (iAccept >= 0) {
            return iAccept;
        }
        if (iAccept == Errors.ERRNO_EAGAIN_NEGATIVE || iAccept == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("accept", iAccept);
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            NativeInetAddress nativeInetAddressNewInstance = NativeInetAddress.newInstance(address);
            int iBind = bind(this.f8302fd, useIpv6(address), nativeInetAddressNewInstance.address, nativeInetAddressNewInstance.scopeId, inetSocketAddress.getPort());
            if (iBind < 0) {
                throw Errors.newIOException("bind", iBind);
            }
            return;
        }
        if (!(socketAddress instanceof DomainSocketAddress)) {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
        int iBindDomainSocket = bindDomainSocket(this.f8302fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
        if (iBindDomainSocket < 0) {
            throw Errors.newIOException("bind", iBindDomainSocket);
        }
    }

    public final boolean connect(SocketAddress socketAddress) throws IOException {
        int iConnectDomainSocket;
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            NativeInetAddress nativeInetAddressNewInstance = NativeInetAddress.newInstance(address);
            iConnectDomainSocket = connect(this.f8302fd, useIpv6(address), nativeInetAddressNewInstance.address, nativeInetAddressNewInstance.scopeId, inetSocketAddress.getPort());
        } else {
            if (!(socketAddress instanceof DomainSocketAddress)) {
                throw new Error("Unexpected SocketAddress implementation " + socketAddress);
            }
            iConnectDomainSocket = connectDomainSocket(this.f8302fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
        }
        if (iConnectDomainSocket < 0) {
            return Errors.handleConnectErrno("connect", iConnectDomainSocket);
        }
        return true;
    }

    public final void disconnect() throws IOException {
        int iDisconnect = disconnect(this.f8302fd, this.ipv6);
        if (iDisconnect < 0) {
            Errors.handleConnectErrno("disconnect", iDisconnect);
        }
    }

    public final boolean finishConnect() throws IOException {
        int iFinishConnect = finishConnect(this.f8302fd);
        if (iFinishConnect < 0) {
            return Errors.handleConnectErrno("finishConnect", iFinishConnect);
        }
        return true;
    }

    public int getIntOpt(int i10, int i11) throws IOException {
        return getIntOpt(this.f8302fd, i10, i11);
    }

    public void getRawOpt(int i10, int i11, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.isDirect()) {
            getRawOptAddress(this.f8302fd, i10, i11, ((long) byteBuffer.position()) + Buffer.memoryAddress(byteBuffer), byteBuffer.remaining());
        } else if (byteBuffer.hasArray()) {
            getRawOptArray(this.f8302fd, i10, i11, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            getRawOptArray(this.f8302fd, i10, i11, bArr, 0, iRemaining);
            byteBuffer.put(bArr);
        }
        byteBuffer.position(byteBuffer.limit());
    }

    public final int getReceiveBufferSize() throws IOException {
        return getReceiveBufferSize(this.f8302fd);
    }

    public final int getSendBufferSize() throws IOException {
        return getSendBufferSize(this.f8302fd);
    }

    public final int getSoError() throws IOException {
        return getSoError(this.f8302fd);
    }

    public final int getSoLinger() throws IOException {
        return getSoLinger(this.f8302fd);
    }

    public final int getTrafficClass() throws IOException {
        return getTrafficClass(this.f8302fd, this.ipv6);
    }

    public final boolean isBroadcast() throws IOException {
        return isBroadcast(this.f8302fd) != 0;
    }

    public final boolean isInputShutdown() {
        return FileDescriptor.isInputShutdown(this.state);
    }

    public final boolean isKeepAlive() throws IOException {
        return isKeepAlive(this.f8302fd) != 0;
    }

    public final boolean isOutputShutdown() {
        return FileDescriptor.isOutputShutdown(this.state);
    }

    public final boolean isReuseAddress() throws IOException {
        return isReuseAddress(this.f8302fd) != 0;
    }

    public final boolean isReusePort() throws IOException {
        return isReusePort(this.f8302fd) != 0;
    }

    public final boolean isShutdown() {
        int i10 = this.state;
        return FileDescriptor.isInputShutdown(i10) && FileDescriptor.isOutputShutdown(i10);
    }

    public final boolean isTcpNoDelay() throws IOException {
        return isTcpNoDelay(this.f8302fd) != 0;
    }

    public final void listen(int i10) throws IOException {
        int iListen = listen(this.f8302fd, i10);
        if (iListen < 0) {
            throw Errors.newIOException("listen", iListen);
        }
    }

    public final InetSocketAddress localAddress() {
        byte[] bArrLocalAddress = localAddress(this.f8302fd);
        if (bArrLocalAddress == null) {
            return null;
        }
        return NativeInetAddress.address(bArrLocalAddress, 0, bArrLocalAddress.length);
    }

    public final DomainSocketAddress localDomainSocketAddress() {
        byte[] bArrLocalDomainSocketAddress = localDomainSocketAddress(this.f8302fd);
        if (bArrLocalDomainSocketAddress == null) {
            return null;
        }
        return new DomainSocketAddress(new String(bArrLocalDomainSocketAddress));
    }

    public int recv(ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        int iRecv = recv(intValue(), byteBuffer, i10, i11);
        if (iRecv > 0) {
            return iRecv;
        }
        if (iRecv == 0) {
            return -1;
        }
        return Errors.ioResult("recv", iRecv);
    }

    public int recvAddress(long j10, int i10, int i11) throws IOException {
        int iRecvAddress = recvAddress(intValue(), j10, i10, i11);
        if (iRecvAddress > 0) {
            return iRecvAddress;
        }
        if (iRecvAddress == 0) {
            return -1;
        }
        return Errors.ioResult("recvAddress", iRecvAddress);
    }

    public final int recvFd() throws IOException {
        int iRecvFd = recvFd(this.f8302fd);
        if (iRecvFd > 0) {
            return iRecvFd;
        }
        if (iRecvFd == 0) {
            return -1;
        }
        if (iRecvFd == Errors.ERRNO_EAGAIN_NEGATIVE || iRecvFd == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        throw Errors.newIOException("recvFd", iRecvFd);
    }

    public final DatagramSocketAddress recvFrom(ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        return recvFrom(this.f8302fd, byteBuffer, i10, i11);
    }

    public final DatagramSocketAddress recvFromAddress(long j10, int i10, int i11) throws IOException {
        return recvFromAddress(this.f8302fd, j10, i10, i11);
    }

    public final DomainDatagramSocketAddress recvFromAddressDomainSocket(long j10, int i10, int i11) throws IOException {
        return recvFromAddressDomainSocket(this.f8302fd, j10, i10, i11);
    }

    public final DomainDatagramSocketAddress recvFromDomainSocket(ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        return recvFromDomainSocket(this.f8302fd, byteBuffer, i10, i11);
    }

    public final InetSocketAddress remoteAddress() {
        byte[] bArrRemoteAddress = remoteAddress(this.f8302fd);
        if (bArrRemoteAddress == null) {
            return null;
        }
        return NativeInetAddress.address(bArrRemoteAddress, 0, bArrRemoteAddress.length);
    }

    public final DomainSocketAddress remoteDomainSocketAddress() {
        byte[] bArrRemoteDomainSocketAddress = remoteDomainSocketAddress(this.f8302fd);
        if (bArrRemoteDomainSocketAddress == null) {
            return null;
        }
        return new DomainSocketAddress(new String(bArrRemoteDomainSocketAddress));
    }

    public int send(ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        int iSend = send(intValue(), byteBuffer, i10, i11);
        return iSend >= 0 ? iSend : Errors.ioResult("send", iSend);
    }

    public int sendAddress(long j10, int i10, int i11) throws IOException {
        int iSendAddress = sendAddress(intValue(), j10, i10, i11);
        return iSendAddress >= 0 ? iSendAddress : Errors.ioResult("sendAddress", iSendAddress);
    }

    public final int sendFd(int i10) throws IOException {
        int iSendFd = sendFd(this.f8302fd, i10);
        if (iSendFd >= 0) {
            return iSendFd;
        }
        if (iSendFd == Errors.ERRNO_EAGAIN_NEGATIVE || iSendFd == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("sendFd", iSendFd);
    }

    public final int sendTo(ByteBuffer byteBuffer, int i10, int i11, InetAddress inetAddress, int i12) throws IOException {
        return sendTo(byteBuffer, i10, i11, inetAddress, i12, false);
    }

    public final int sendToAddress(long j10, int i10, int i11, InetAddress inetAddress, int i12) throws IOException {
        return sendToAddress(j10, i10, i11, inetAddress, i12, false);
    }

    public final int sendToAddressDomainSocket(long j10, int i10, int i11, byte[] bArr) throws IOException {
        int iSendToAddressDomainSocket = sendToAddressDomainSocket(this.f8302fd, j10, i10, i11, bArr);
        return iSendToAddressDomainSocket >= 0 ? iSendToAddressDomainSocket : Errors.ioResult("sendToAddressDomainSocket", iSendToAddressDomainSocket);
    }

    public final int sendToAddresses(long j10, int i10, InetAddress inetAddress, int i11) throws IOException {
        return sendToAddresses(j10, i10, inetAddress, i11, false);
    }

    public final int sendToAddressesDomainSocket(long j10, int i10, byte[] bArr) throws IOException {
        int iSendToAddressesDomainSocket = sendToAddressesDomainSocket(this.f8302fd, j10, i10, bArr);
        return iSendToAddressesDomainSocket >= 0 ? iSendToAddressesDomainSocket : Errors.ioResult("sendToAddressesDomainSocket", iSendToAddressesDomainSocket);
    }

    public final int sendToDomainSocket(ByteBuffer byteBuffer, int i10, int i11, byte[] bArr) throws IOException {
        int iSendToDomainSocket = sendToDomainSocket(this.f8302fd, byteBuffer, i10, i11, bArr);
        return iSendToDomainSocket >= 0 ? iSendToDomainSocket : Errors.ioResult("sendToDomainSocket", iSendToDomainSocket);
    }

    public final void setBroadcast(boolean z10) throws IOException {
        setBroadcast(this.f8302fd, z10 ? 1 : 0);
    }

    public void setIntOpt(int i10, int i11, int i12) throws IOException {
        setIntOpt(this.f8302fd, i10, i11, i12);
    }

    public final void setKeepAlive(boolean z10) throws IOException {
        setKeepAlive(this.f8302fd, z10 ? 1 : 0);
    }

    public void setRawOpt(int i10, int i11, ByteBuffer byteBuffer) throws IOException {
        int iLimit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            setRawOptAddress(this.f8302fd, i10, i11, ((long) byteBuffer.position()) + Buffer.memoryAddress(byteBuffer), byteBuffer.remaining());
        } else if (byteBuffer.hasArray()) {
            setRawOptArray(this.f8302fd, i10, i11, byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            setRawOptArray(this.f8302fd, i10, i11, bArr, 0, iRemaining);
        }
        byteBuffer.position(iLimit);
    }

    public final void setReceiveBufferSize(int i10) throws IOException {
        setReceiveBufferSize(this.f8302fd, i10);
    }

    public final void setReuseAddress(boolean z10) throws IOException {
        setReuseAddress(this.f8302fd, z10 ? 1 : 0);
    }

    public final void setReusePort(boolean z10) throws IOException {
        setReusePort(this.f8302fd, z10 ? 1 : 0);
    }

    public final void setSendBufferSize(int i10) throws IOException {
        setSendBufferSize(this.f8302fd, i10);
    }

    public final void setSoLinger(int i10) throws IOException {
        setSoLinger(this.f8302fd, i10);
    }

    public final void setTcpNoDelay(boolean z10) throws IOException {
        setTcpNoDelay(this.f8302fd, z10 ? 1 : 0);
    }

    public final void setTrafficClass(int i10) throws IOException {
        setTrafficClass(this.f8302fd, this.ipv6, i10);
    }

    public final void shutdown() throws IOException {
        shutdown(true, true);
    }

    @Override // io.netty.channel.unix.FileDescriptor
    public String toString() {
        return a.a(new StringBuilder("Socket{fd="), this.f8302fd, f.f14860b);
    }

    public static int newSocketDgram0(InternetProtocolFamily internetProtocolFamily) {
        return newSocketDgram0(shouldUseIpv6(internetProtocolFamily));
    }

    public static int newSocketStream0(InternetProtocolFamily internetProtocolFamily) {
        return newSocketStream0(shouldUseIpv6(internetProtocolFamily));
    }

    public static boolean useIpv6(Socket socket, InetAddress inetAddress) {
        return socket.ipv6 || (inetAddress instanceof Inet6Address);
    }

    public final int sendTo(ByteBuffer byteBuffer, int i10, int i11, InetAddress inetAddress, int i12, boolean z10) throws IOException {
        byte[] bArrIpv4MappedIpv6Address;
        int scopeId;
        if (inetAddress instanceof Inet6Address) {
            bArrIpv4MappedIpv6Address = inetAddress.getAddress();
            scopeId = ((Inet6Address) inetAddress).getScopeId();
        } else {
            bArrIpv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            scopeId = 0;
        }
        int iSendTo = sendTo(this.f8302fd, useIpv6(inetAddress), byteBuffer, i10, i11, bArrIpv4MappedIpv6Address, scopeId, i12, z10 ? msgFastopen() : 0);
        if (iSendTo >= 0) {
            return iSendTo;
        }
        if (iSendTo == Errors.ERRNO_EINPROGRESS_NEGATIVE && z10) {
            return 0;
        }
        if (iSendTo != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendTo", iSendTo);
        }
        throw new PortUnreachableException("sendTo failed");
    }

    public final int sendToAddress(long j10, int i10, int i11, InetAddress inetAddress, int i12, boolean z10) throws IOException {
        byte[] bArrIpv4MappedIpv6Address;
        int scopeId;
        if (inetAddress instanceof Inet6Address) {
            bArrIpv4MappedIpv6Address = inetAddress.getAddress();
            scopeId = ((Inet6Address) inetAddress).getScopeId();
        } else {
            bArrIpv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            scopeId = 0;
        }
        int iSendToAddress = sendToAddress(this.f8302fd, useIpv6(inetAddress), j10, i10, i11, bArrIpv4MappedIpv6Address, scopeId, i12, z10 ? msgFastopen() : 0);
        if (iSendToAddress >= 0) {
            return iSendToAddress;
        }
        if (iSendToAddress == Errors.ERRNO_EINPROGRESS_NEGATIVE && z10) {
            return 0;
        }
        if (iSendToAddress != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddress", iSendToAddress);
        }
        throw new PortUnreachableException("sendToAddress failed");
    }

    public final int sendToAddresses(long j10, int i10, InetAddress inetAddress, int i11, boolean z10) throws IOException {
        byte[] bArrIpv4MappedIpv6Address;
        int scopeId;
        if (inetAddress instanceof Inet6Address) {
            bArrIpv4MappedIpv6Address = inetAddress.getAddress();
            scopeId = ((Inet6Address) inetAddress).getScopeId();
        } else {
            bArrIpv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            scopeId = 0;
        }
        int iSendToAddresses = sendToAddresses(this.f8302fd, useIpv6(inetAddress), j10, i10, bArrIpv4MappedIpv6Address, scopeId, i11, z10 ? msgFastopen() : 0);
        if (iSendToAddresses >= 0) {
            return iSendToAddresses;
        }
        if (iSendToAddresses == Errors.ERRNO_EINPROGRESS_NEGATIVE && z10) {
            return 0;
        }
        if (iSendToAddresses != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddresses", iSendToAddresses);
        }
        throw new PortUnreachableException("sendToAddresses failed");
    }

    public final void shutdown(boolean z10, boolean z11) throws IOException {
        int i10;
        int iInputShutdown;
        do {
            i10 = this.state;
            if (FileDescriptor.isClosed(i10)) {
                throw new ClosedChannelException();
            }
            iInputShutdown = (!z10 || FileDescriptor.isInputShutdown(i10)) ? i10 : FileDescriptor.inputShutdown(i10);
            if (z11 && !FileDescriptor.isOutputShutdown(iInputShutdown)) {
                iInputShutdown = FileDescriptor.outputShutdown(iInputShutdown);
            }
            if (iInputShutdown == i10) {
                return;
            }
        } while (!casState(i10, iInputShutdown));
        int iShutdown = shutdown(this.f8302fd, z10, z11);
        if (iShutdown < 0) {
            Errors.ioResult("shutdown", iShutdown);
        }
    }

    public static int newSocketDgram0(boolean z10) {
        int iNewSocketDgramFd = newSocketDgramFd(z10);
        if (iNewSocketDgramFd >= 0) {
            return iNewSocketDgramFd;
        }
        throw new ChannelException(Errors.newIOException("newSocketDgram", iNewSocketDgramFd));
    }

    public static int newSocketStream0(boolean z10) {
        int iNewSocketStreamFd = newSocketStreamFd(z10);
        if (iNewSocketStreamFd >= 0) {
            return iNewSocketStreamFd;
        }
        throw new ChannelException(Errors.newIOException("newSocketStream", iNewSocketStreamFd));
    }
}
