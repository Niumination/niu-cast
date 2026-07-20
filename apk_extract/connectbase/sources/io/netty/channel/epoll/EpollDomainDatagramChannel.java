package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.unix.DomainDatagramChannel;
import io.netty.channel.unix.DomainDatagramPacket;
import io.netty.channel.unix.DomainDatagramSocketAddress;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.CharsetUtil;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import jq.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class EpollDomainDatagramChannel extends AbstractEpollChannel implements DomainDatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final EpollDomainDatagramChannelConfig config;
    private volatile boolean connected;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DomainDatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + m0.f8867e + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DomainSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';

    public final class EpollDomainDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public EpollDomainDatagramChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public void epollInReady() {
            ByteBuf byteBufAllocate;
            DomainDatagramSocketAddress domainDatagramSocketAddressRecvFromDomainSocket;
            DomainDatagramPacket domainDatagramPacket;
            EpollDomainDatagramChannelConfig epollDomainDatagramChannelConfigConfig = EpollDomainDatagramChannel.this.config();
            if (EpollDomainDatagramChannel.this.shouldBreakEpollInReady(epollDomainDatagramChannelConfigConfig)) {
                clearEpollIn0();
                return;
            }
            EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandleRecvBufAllocHandle = recvBufAllocHandle();
            epollRecvByteAllocatorHandleRecvBufAllocHandle.edgeTriggered(EpollDomainDatagramChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline channelPipelinePipeline = EpollDomainDatagramChannel.this.pipeline();
            ByteBufAllocator allocator = epollDomainDatagramChannelConfigConfig.getAllocator();
            epollRecvByteAllocatorHandleRecvBufAllocHandle.reset(epollDomainDatagramChannelConfigConfig);
            epollInBefore();
            Throwable th2 = null;
            try {
                boolean zIsConnected = EpollDomainDatagramChannel.this.isConnected();
                do {
                    byteBufAllocate = epollRecvByteAllocatorHandleRecvBufAllocHandle.allocate(allocator);
                    try {
                        epollRecvByteAllocatorHandleRecvBufAllocHandle.attemptedBytesRead(byteBufAllocate.writableBytes());
                        if (zIsConnected) {
                            epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(EpollDomainDatagramChannel.this.doReadBytes(byteBufAllocate));
                            if (epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead() <= 0) {
                                byteBufAllocate.release();
                                break;
                            }
                            domainDatagramPacket = new DomainDatagramPacket(byteBufAllocate, (DomainSocketAddress) localAddress(), (DomainSocketAddress) remoteAddress());
                            epollRecvByteAllocatorHandleRecvBufAllocHandle.incMessagesRead(1);
                            this.readPending = false;
                            channelPipelinePipeline.fireChannelRead((Object) domainDatagramPacket);
                        } else {
                            if (byteBufAllocate.hasMemoryAddress()) {
                                domainDatagramSocketAddressRecvFromDomainSocket = EpollDomainDatagramChannel.this.socket.recvFromAddressDomainSocket(byteBufAllocate.memoryAddress(), byteBufAllocate.writerIndex(), byteBufAllocate.capacity());
                            } else {
                                ByteBuffer byteBufferInternalNioBuffer = byteBufAllocate.internalNioBuffer(byteBufAllocate.writerIndex(), byteBufAllocate.writableBytes());
                                domainDatagramSocketAddressRecvFromDomainSocket = EpollDomainDatagramChannel.this.socket.recvFromDomainSocket(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit());
                            }
                            if (domainDatagramSocketAddressRecvFromDomainSocket == null) {
                                epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(-1);
                                byteBufAllocate.release();
                                break;
                            }
                            DomainSocketAddress domainSocketAddressLocalAddress = domainDatagramSocketAddressRecvFromDomainSocket.localAddress();
                            if (domainSocketAddressLocalAddress == null) {
                                domainSocketAddressLocalAddress = (DomainSocketAddress) localAddress();
                            }
                            epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(domainDatagramSocketAddressRecvFromDomainSocket.receivedAmount());
                            byteBufAllocate.writerIndex(byteBufAllocate.writerIndex() + epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead());
                            domainDatagramPacket = new DomainDatagramPacket(byteBufAllocate, domainSocketAddressLocalAddress, domainDatagramSocketAddressRecvFromDomainSocket);
                            epollRecvByteAllocatorHandleRecvBufAllocHandle.incMessagesRead(1);
                            this.readPending = false;
                            channelPipelinePipeline.fireChannelRead((Object) domainDatagramPacket);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        if (byteBufAllocate != null) {
                            try {
                                byteBufAllocate.release();
                            } finally {
                                epollInFinally(epollDomainDatagramChannelConfigConfig);
                            }
                        }
                    }
                } while (epollRecvByteAllocatorHandleRecvBufAllocHandle.continueReading(UncheckedBooleanSupplier.TRUE_SUPPLIER));
            } catch (Throwable th4) {
                th = th4;
                byteBufAllocate = null;
            }
            epollRecvByteAllocatorHandleRecvBufAllocHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (th2 != null) {
                channelPipelinePipeline.fireExceptionCaught(th2);
            }
        }
    }

    public EpollDomainDatagramChannel() {
        this(LinuxSocket.newSocketDomainDgram(), false);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private boolean doWriteMessage(Object obj) throws Exception {
        ByteBuf byteBuf;
        DomainSocketAddress domainSocketAddress;
        int iWrite;
        long jWritevAddresses;
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            byteBuf = (ByteBuf) addressedEnvelope.content();
            domainSocketAddress = (DomainSocketAddress) addressedEnvelope.recipient();
        } else {
            byteBuf = (ByteBuf) obj;
            domainSocketAddress = null;
        }
        if (byteBuf.readableBytes() == 0) {
            return true;
        }
        if (byteBuf.hasMemoryAddress()) {
            long jMemoryAddress = byteBuf.memoryAddress();
            iWrite = domainSocketAddress == null ? this.socket.writeAddress(jMemoryAddress, byteBuf.readerIndex(), byteBuf.writerIndex()) : this.socket.sendToAddressDomainSocket(jMemoryAddress, byteBuf.readerIndex(), byteBuf.writerIndex(), domainSocketAddress.path().getBytes(CharsetUtil.UTF_8));
        } else {
            if (byteBuf.nioBufferCount() > 1) {
                IovArray iovArrayCleanIovArray = ((EpollEventLoop) eventLoop()).cleanIovArray();
                iovArrayCleanIovArray.add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
                int iCount = iovArrayCleanIovArray.count();
                if (domainSocketAddress == null) {
                    jWritevAddresses = this.socket.writevAddresses(iovArrayCleanIovArray.memoryAddress(0), iCount);
                } else {
                    iWrite = this.socket.sendToAddressesDomainSocket(iovArrayCleanIovArray.memoryAddress(0), iCount, domainSocketAddress.path().getBytes(CharsetUtil.UTF_8));
                }
                if (jWritevAddresses > 0) {
                    return true;
                }
                return false;
            }
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
            iWrite = domainSocketAddress == null ? this.socket.write(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit()) : this.socket.sendToDomainSocket(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit(), domainSocketAddress.path().getBytes(CharsetUtil.UTF_8));
        }
        jWritevAddresses = iWrite;
        if (jWritevAddresses > 0) {
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.local = (DomainSocketAddress) socketAddress;
        this.active = true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        super.doClose();
        this.active = false;
        this.connected = false;
        this.local = null;
        this.remote = null;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        if (socketAddress2 != null) {
            this.local = (DomainSocketAddress) socketAddress2;
        }
        this.remote = (DomainSocketAddress) socketAddress;
        this.connected = true;
        return true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doDisconnect() throws Exception {
        doClose();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int iMaxMessagesPerWrite = maxMessagesPerWrite();
        loop0: while (iMaxMessagesPerWrite > 0) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                break;
            }
            try {
                int writeSpinCount = config().getWriteSpinCount();
                while (true) {
                    if (writeSpinCount <= 0) {
                        break loop0;
                    }
                    if (doWriteMessage(objCurrent)) {
                        channelOutboundBuffer.remove();
                        iMaxMessagesPerWrite--;
                        break;
                    }
                    writeSpinCount--;
                }
            } catch (IOException e10) {
                iMaxMessagesPerWrite--;
                channelOutboundBuffer.remove(e10);
            }
        }
        if (channelOutboundBuffer.isEmpty()) {
            clearFlag(Native.EPOLLOUT);
        } else {
            setFlag(Native.EPOLLOUT);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof DomainDatagramPacket) {
            DomainDatagramPacket domainDatagramPacket = (DomainDatagramPacket) obj;
            ByteBuf byteBufContent = domainDatagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBufContent) ? new DomainDatagramPacket(newDirectBuffer(domainDatagramPacket, byteBufContent), domainDatagramPacket.recipient()) : obj;
        }
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        }
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof DomainSocketAddress))) {
                ByteBuf byteBuf2 = (ByteBuf) addressedEnvelope.content();
                return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf2) ? new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf2), (DomainSocketAddress) addressedEnvelope.recipient()) : addressedEnvelope;
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // io.netty.channel.unix.DomainDatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    public EpollDomainDatagramChannel(int i10) {
        this(new LinuxSocket(i10), true);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDomainDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    private EpollDomainDatagramChannel(LinuxSocket linuxSocket, boolean z10) {
        super((Channel) null, linuxSocket, z10);
        this.config = new EpollDomainDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollDomainDatagramChannelConfig config() {
        return this.config;
    }
}
