package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.DatagramSocketAddress;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import jq.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class KQueueDatagramChannel extends AbstractKQueueDatagramChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + m0.f8867e + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';
    private final KQueueDatagramChannelConfig config;
    private volatile boolean connected;

    public final class KQueueDatagramChannelUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public KQueueDatagramChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        public void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            ByteBuf byteBufAllocate;
            DatagramPacket datagramPacket;
            DatagramSocketAddress datagramSocketAddressRecvFrom;
            KQueueDatagramChannelConfig kQueueDatagramChannelConfigConfig = KQueueDatagramChannel.this.config();
            if (KQueueDatagramChannel.this.shouldBreakReadReady(kQueueDatagramChannelConfigConfig)) {
                clearReadFilter0();
                return;
            }
            ChannelPipeline channelPipelinePipeline = KQueueDatagramChannel.this.pipeline();
            ByteBufAllocator allocator = kQueueDatagramChannelConfigConfig.getAllocator();
            kQueueRecvByteAllocatorHandle.reset(kQueueDatagramChannelConfigConfig);
            readReadyBefore();
            Throwable th2 = null;
            try {
                boolean zIsConnected = KQueueDatagramChannel.this.isConnected();
                do {
                    byteBufAllocate = kQueueRecvByteAllocatorHandle.allocate(allocator);
                    try {
                        kQueueRecvByteAllocatorHandle.attemptedBytesRead(byteBufAllocate.writableBytes());
                        if (zIsConnected) {
                            try {
                                kQueueRecvByteAllocatorHandle.lastBytesRead(KQueueDatagramChannel.this.doReadBytes(byteBufAllocate));
                                if (kQueueRecvByteAllocatorHandle.lastBytesRead() <= 0) {
                                    byteBufAllocate.release();
                                    break;
                                }
                                datagramPacket = new DatagramPacket(byteBufAllocate, (InetSocketAddress) localAddress(), (InetSocketAddress) remoteAddress());
                                kQueueRecvByteAllocatorHandle.incMessagesRead(1);
                                this.readPending = false;
                                channelPipelinePipeline.fireChannelRead((Object) datagramPacket);
                            } catch (Errors.NativeIoException e10) {
                                if (e10.expectedErr() != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
                                    throw e10;
                                }
                                PortUnreachableException portUnreachableException = new PortUnreachableException(e10.getMessage());
                                portUnreachableException.initCause(e10);
                                throw portUnreachableException;
                            }
                        } else {
                            if (byteBufAllocate.hasMemoryAddress()) {
                                datagramSocketAddressRecvFrom = KQueueDatagramChannel.this.socket.recvFromAddress(byteBufAllocate.memoryAddress(), byteBufAllocate.writerIndex(), byteBufAllocate.capacity());
                            } else {
                                ByteBuffer byteBufferInternalNioBuffer = byteBufAllocate.internalNioBuffer(byteBufAllocate.writerIndex(), byteBufAllocate.writableBytes());
                                datagramSocketAddressRecvFrom = KQueueDatagramChannel.this.socket.recvFrom(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit());
                            }
                            if (datagramSocketAddressRecvFrom == null) {
                                kQueueRecvByteAllocatorHandle.lastBytesRead(-1);
                                byteBufAllocate.release();
                                break;
                            }
                            InetSocketAddress inetSocketAddressLocalAddress = datagramSocketAddressRecvFrom.localAddress();
                            if (inetSocketAddressLocalAddress == null) {
                                inetSocketAddressLocalAddress = (InetSocketAddress) localAddress();
                            }
                            kQueueRecvByteAllocatorHandle.lastBytesRead(datagramSocketAddressRecvFrom.receivedAmount());
                            byteBufAllocate.writerIndex(byteBufAllocate.writerIndex() + kQueueRecvByteAllocatorHandle.lastBytesRead());
                            datagramPacket = new DatagramPacket(byteBufAllocate, inetSocketAddressLocalAddress, datagramSocketAddressRecvFrom);
                            kQueueRecvByteAllocatorHandle.incMessagesRead(1);
                            this.readPending = false;
                            channelPipelinePipeline.fireChannelRead((Object) datagramPacket);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        if (byteBufAllocate != null) {
                            try {
                                byteBufAllocate.release();
                            } finally {
                                readReadyFinally(kQueueDatagramChannelConfigConfig);
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

    public KQueueDatagramChannel() {
        super(null, BsdSocket.newSocketDgram(), false);
        this.config = new KQueueDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.active = true;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        super.doClose();
        this.connected = false;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.connected = true;
        return true;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
        resetCachedAddresses();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.channel.kqueue.AbstractKQueueDatagramChannel
    public boolean doWriteMessage(Object obj) throws Exception {
        ByteBuf byteBuf;
        InetSocketAddress inetSocketAddress;
        int iWrite;
        long jWritevAddresses;
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            byteBuf = (ByteBuf) addressedEnvelope.content();
            inetSocketAddress = (InetSocketAddress) addressedEnvelope.recipient();
        } else {
            byteBuf = (ByteBuf) obj;
            inetSocketAddress = null;
        }
        if (byteBuf.readableBytes() == 0) {
            return true;
        }
        if (byteBuf.hasMemoryAddress()) {
            long jMemoryAddress = byteBuf.memoryAddress();
            iWrite = inetSocketAddress == null ? this.socket.writeAddress(jMemoryAddress, byteBuf.readerIndex(), byteBuf.writerIndex()) : this.socket.sendToAddress(jMemoryAddress, byteBuf.readerIndex(), byteBuf.writerIndex(), inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        } else {
            if (byteBuf.nioBufferCount() > 1) {
                IovArray iovArrayCleanArray = ((KQueueEventLoop) eventLoop()).cleanArray();
                iovArrayCleanArray.add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
                int iCount = iovArrayCleanArray.count();
                if (inetSocketAddress == null) {
                    jWritevAddresses = this.socket.writevAddresses(iovArrayCleanArray.memoryAddress(0), iCount);
                } else {
                    iWrite = this.socket.sendToAddresses(iovArrayCleanArray.memoryAddress(0), iCount, inetSocketAddress.getAddress(), inetSocketAddress.getPort());
                }
                if (jWritevAddresses > 0) {
                    return true;
                }
                return false;
            }
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
            iWrite = inetSocketAddress == null ? this.socket.write(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit()) : this.socket.sendTo(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit(), inetSocketAddress.getAddress(), inetSocketAddress.getPort());
        }
        jWritevAddresses = iWrite;
        if (jWritevAddresses > 0) {
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf byteBufContent = datagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBufContent) ? new DatagramPacket(newDirectBuffer(datagramPacket, byteBufContent), datagramPacket.recipient()) : obj;
        }
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        }
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof InetSocketAddress))) {
                ByteBuf byteBuf2 = (ByteBuf) addressedEnvelope.content();
                return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf2) ? new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf2), (InetSocketAddress) addressedEnvelope.recipient()) : addressedEnvelope;
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueDatagramChannel, io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ ChannelMetadata metadata() {
        return super.metadata();
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(inetAddress2, "sourceToBlock");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            NetworkInterface networkInterface = config().getNetworkInterface();
            if (networkInterface == null) {
                networkInterface = NetworkInterface.getByInetAddress(localAddress().getAddress());
            }
            return joinGroup(inetAddress, networkInterface, null, channelPromise);
        } catch (SocketException e10) {
            channelPromise.setFailure((Throwable) e10);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return leaveGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (SocketException e10) {
            channelPromise.setFailure((Throwable) e10);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public KQueueDatagramChannel(int i10) {
        this(new BsdSocket(i10), true);
    }

    public KQueueDatagramChannel(BsdSocket bsdSocket, boolean z10) {
        super(null, bsdSocket, z10);
        this.config = new KQueueDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueDatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return block(inetAddress, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return leaveGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            return block(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), inetAddress2, channelPromise);
        } catch (Throwable th2) {
            channelPromise.setFailure(th2);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return joinGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return leaveGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return joinGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }
}
