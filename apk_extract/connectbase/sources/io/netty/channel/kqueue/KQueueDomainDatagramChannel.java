package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelMetadata;
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
public final class KQueueDomainDatagramChannel extends AbstractKQueueDatagramChannel implements DomainDatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DomainDatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + m0.f8867e + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DomainSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';
    private final KQueueDomainDatagramChannelConfig config;
    private volatile boolean connected;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    public final class KQueueDomainDatagramChannelUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public KQueueDomainDatagramChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        public void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            ByteBuf byteBufAllocate;
            DomainDatagramSocketAddress domainDatagramSocketAddressRecvFromDomainSocket;
            DomainDatagramPacket domainDatagramPacket;
            KQueueDomainDatagramChannelConfig kQueueDomainDatagramChannelConfigConfig = KQueueDomainDatagramChannel.this.config();
            if (KQueueDomainDatagramChannel.this.shouldBreakReadReady(kQueueDomainDatagramChannelConfigConfig)) {
                clearReadFilter0();
                return;
            }
            ChannelPipeline channelPipelinePipeline = KQueueDomainDatagramChannel.this.pipeline();
            ByteBufAllocator allocator = kQueueDomainDatagramChannelConfigConfig.getAllocator();
            kQueueRecvByteAllocatorHandle.reset(kQueueDomainDatagramChannelConfigConfig);
            readReadyBefore();
            Throwable th2 = null;
            try {
                boolean zIsConnected = KQueueDomainDatagramChannel.this.isConnected();
                do {
                    byteBufAllocate = kQueueRecvByteAllocatorHandle.allocate(allocator);
                    try {
                        kQueueRecvByteAllocatorHandle.attemptedBytesRead(byteBufAllocate.writableBytes());
                        if (zIsConnected) {
                            kQueueRecvByteAllocatorHandle.lastBytesRead(KQueueDomainDatagramChannel.this.doReadBytes(byteBufAllocate));
                            if (kQueueRecvByteAllocatorHandle.lastBytesRead() <= 0) {
                                byteBufAllocate.release();
                                break;
                            }
                            domainDatagramPacket = new DomainDatagramPacket(byteBufAllocate, (DomainSocketAddress) localAddress(), (DomainSocketAddress) remoteAddress());
                            kQueueRecvByteAllocatorHandle.incMessagesRead(1);
                            this.readPending = false;
                            channelPipelinePipeline.fireChannelRead((Object) domainDatagramPacket);
                        } else {
                            if (byteBufAllocate.hasMemoryAddress()) {
                                domainDatagramSocketAddressRecvFromDomainSocket = KQueueDomainDatagramChannel.this.socket.recvFromAddressDomainSocket(byteBufAllocate.memoryAddress(), byteBufAllocate.writerIndex(), byteBufAllocate.capacity());
                            } else {
                                ByteBuffer byteBufferInternalNioBuffer = byteBufAllocate.internalNioBuffer(byteBufAllocate.writerIndex(), byteBufAllocate.writableBytes());
                                domainDatagramSocketAddressRecvFromDomainSocket = KQueueDomainDatagramChannel.this.socket.recvFromDomainSocket(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit());
                            }
                            if (domainDatagramSocketAddressRecvFromDomainSocket == null) {
                                kQueueRecvByteAllocatorHandle.lastBytesRead(-1);
                                byteBufAllocate.release();
                                break;
                            }
                            DomainSocketAddress domainSocketAddressLocalAddress = domainDatagramSocketAddressRecvFromDomainSocket.localAddress();
                            if (domainSocketAddressLocalAddress == null) {
                                domainSocketAddressLocalAddress = (DomainSocketAddress) localAddress();
                            }
                            kQueueRecvByteAllocatorHandle.lastBytesRead(domainDatagramSocketAddressRecvFromDomainSocket.receivedAmount());
                            byteBufAllocate.writerIndex(byteBufAllocate.writerIndex() + kQueueRecvByteAllocatorHandle.lastBytesRead());
                            domainDatagramPacket = new DomainDatagramPacket(byteBufAllocate, domainSocketAddressLocalAddress, domainDatagramSocketAddressRecvFromDomainSocket);
                            kQueueRecvByteAllocatorHandle.incMessagesRead(1);
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
                                readReadyFinally(kQueueDomainDatagramChannelConfigConfig);
                            }
                        }
                    }
                } while (kQueueRecvByteAllocatorHandle.continueReading(UncheckedBooleanSupplier.TRUE_SUPPLIER));
            } catch (Throwable th4) {
                th = th4;
                byteBufAllocate = null;
            }
            kQueueRecvByteAllocatorHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (th2 != null) {
                channelPipelinePipeline.fireExceptionCaught(th2);
            }
        }
    }

    public KQueueDomainDatagramChannel() {
        this(BsdSocket.newSocketDomainDgram(), false);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.local = (DomainSocketAddress) socketAddress;
        this.active = true;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        super.doClose();
        this.active = false;
        this.connected = false;
        this.local = null;
        this.remote = null;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public void doDisconnect() throws Exception {
        doClose();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.channel.kqueue.AbstractKQueueDatagramChannel
    public boolean doWriteMessage(Object obj) throws Exception {
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
                IovArray iovArrayCleanArray = ((KQueueEventLoop) eventLoop()).cleanArray();
                iovArrayCleanArray.add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
                int iCount = iovArrayCleanArray.count();
                if (domainSocketAddress == null) {
                    jWritevAddresses = this.socket.writevAddresses(iovArrayCleanArray.memoryAddress(0), iCount);
                } else {
                    iWrite = this.socket.sendToAddressesDomainSocket(iovArrayCleanArray.memoryAddress(0), iCount, domainSocketAddress.path().getBytes(CharsetUtil.UTF_8));
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // io.netty.channel.unix.DomainDatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueDatagramChannel, io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ ChannelMetadata metadata() {
        return super.metadata();
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    public KQueueDomainDatagramChannel(int i10) {
        this(new BsdSocket(i10), true);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDomainDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    private KQueueDomainDatagramChannel(BsdSocket bsdSocket, boolean z10) {
        super(null, bsdSocket, z10);
        this.config = new KQueueDomainDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueDomainDatagramChannelConfig config() {
        return this.config;
    }
}
