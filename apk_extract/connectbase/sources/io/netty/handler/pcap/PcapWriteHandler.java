package io.netty.handler.pcap;

import g0.e;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicReference;
import rs.f;

/* JADX INFO: loaded from: classes3.dex */
public final class PcapWriteHandler extends ChannelDuplexHandler implements Closeable {
    private final boolean captureZeroByte;
    private ChannelType channelType;
    private InetSocketAddress handlerAddr;
    private InetSocketAddress initiatorAddr;
    private boolean isServerPipeline;
    private final InternalLogger logger;
    private final OutputStream outputStream;
    private PcapWriter pCapWriter;
    private int receiveSegmentNumber;
    private int sendSegmentNumber;
    private final boolean sharedOutputStream;
    private final AtomicReference<State> state;
    private final boolean writePcapGlobalHeader;

    public static final class Builder {
        private boolean captureZeroByte;
        private ChannelType channelType;
        private InetSocketAddress handlerAddr;
        private InetSocketAddress initiatorAddr;
        private boolean isServerPipeline;
        private boolean sharedOutputStream;
        private boolean writePcapGlobalHeader;

        public PcapWriteHandler build(OutputStream outputStream) {
            ObjectUtil.checkNotNull(outputStream, "outputStream");
            return new PcapWriteHandler(this, outputStream);
        }

        public Builder captureZeroByte(boolean z10) {
            this.captureZeroByte = z10;
            return this;
        }

        public Builder forceTcpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z10) {
            this.channelType = ChannelType.TCP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "serverAddress");
            this.initiatorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "clientAddress");
            this.isServerPipeline = z10;
            return this;
        }

        public Builder forceUdpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            this.channelType = ChannelType.UDP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "remoteAddress");
            this.initiatorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "localAddress");
            return this;
        }

        public Builder sharedOutputStream(boolean z10) {
            this.sharedOutputStream = z10;
            return this;
        }

        public Builder writePcapGlobalHeader(boolean z10) {
            this.writePcapGlobalHeader = z10;
            return this;
        }

        private Builder() {
            this.writePcapGlobalHeader = true;
        }
    }

    public enum ChannelType {
        TCP,
        UDP
    }

    public static final class WildcardAddressHolder {
        static final InetAddress wildcard4;
        static final InetAddress wildcard6;

        static {
            try {
                wildcard4 = InetAddress.getByAddress(new byte[4]);
                wildcard6 = InetAddress.getByAddress(new byte[16]);
            } catch (UnknownHostException e10) {
                throw new AssertionError(e10);
            }
        }

        private WildcardAddressHolder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private void completeTCPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer2 = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer3 = byteBufAllocator.buffer();
        try {
            try {
                if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                    IPPacket.writeTCPv4(byteBufBuffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                    EthernetPacket.writeIPv4(byteBufBuffer2, byteBufBuffer);
                } else if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                    return;
                } else {
                    IPPacket.writeTCPv6(byteBufBuffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                    EthernetPacket.writeIPv6(byteBufBuffer2, byteBufBuffer);
                }
                this.pCapWriter.writePacket(byteBufBuffer3, byteBufBuffer2);
            } catch (IOException e10) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e10);
                channelHandlerContext.fireExceptionCaught((Throwable) e10);
            }
        } finally {
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
        }
    }

    private void completeUDPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer2 = byteBufAllocator.buffer();
        ByteBuf byteBufBuffer3 = byteBufAllocator.buffer();
        try {
            try {
                if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                    IPPacket.writeUDPv4(byteBufBuffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                    EthernetPacket.writeIPv4(byteBufBuffer2, byteBufBuffer);
                } else if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                    return;
                } else {
                    IPPacket.writeUDPv6(byteBufBuffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                    EthernetPacket.writeIPv6(byteBufBuffer2, byteBufBuffer);
                }
                this.pCapWriter.writePacket(byteBufBuffer3, byteBufBuffer2);
            } catch (IOException e10) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e10);
                channelHandlerContext.fireExceptionCaught((Throwable) e10);
            }
        } finally {
            byteBufBuffer.release();
            byteBufBuffer2.release();
            byteBufBuffer3.release();
        }
    }

    private static InetSocketAddress getLocalAddress(Channel channel, InetSocketAddress inetSocketAddress) {
        InetSocketAddress inetSocketAddress2 = (InetSocketAddress) channel.localAddress();
        if (inetSocketAddress != null && inetSocketAddress2.getAddress().isAnyLocalAddress()) {
            if ((inetSocketAddress2.getAddress() instanceof Inet4Address) && (inetSocketAddress.getAddress() instanceof Inet6Address)) {
                return new InetSocketAddress(WildcardAddressHolder.wildcard6, inetSocketAddress2.getPort());
            }
            if ((inetSocketAddress2.getAddress() instanceof Inet6Address) && (inetSocketAddress.getAddress() instanceof Inet4Address)) {
                return new InetSocketAddress(WildcardAddressHolder.wildcard4, inetSocketAddress2.getPort());
            }
        }
        return inetSocketAddress2;
    }

    private void handleTCP(ChannelHandlerContext channelHandlerContext, Object obj, boolean z10) {
        InetSocketAddress inetSocketAddress;
        InetSocketAddress inetSocketAddress2;
        InetSocketAddress inetSocketAddress3;
        InetSocketAddress inetSocketAddress4;
        if (!(obj instanceof ByteBuf)) {
            this.logger.debug("Discarding Pcap Write for TCP Object: {}", obj);
            return;
        }
        ByteBuf byteBuf = (ByteBuf) obj;
        if (byteBuf.readableBytes() == 0 && !this.captureZeroByte) {
            this.logger.debug("Discarding Zero Byte TCP Packet. isWriteOperation {}", Boolean.valueOf(z10));
            return;
        }
        ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
        ByteBuf byteBufDuplicate = byteBuf.duplicate();
        ByteBuf byteBufBuffer = byteBufAllocatorAlloc.buffer();
        int i10 = byteBufDuplicate.readableBytes();
        try {
            if (z10) {
                if (this.isServerPipeline) {
                    inetSocketAddress3 = this.handlerAddr;
                    inetSocketAddress4 = this.initiatorAddr;
                } else {
                    inetSocketAddress3 = this.initiatorAddr;
                    inetSocketAddress4 = this.handlerAddr;
                }
                InetSocketAddress inetSocketAddress5 = inetSocketAddress3;
                InetSocketAddress inetSocketAddress6 = inetSocketAddress4;
                int i11 = this.sendSegmentNumber;
                int i12 = this.receiveSegmentNumber;
                int port = inetSocketAddress5.getPort();
                int port2 = inetSocketAddress6.getPort();
                TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.ACK;
                TCPPacket.writePacket(byteBufBuffer, byteBufDuplicate, i11, i12, port, port2, tCPFlag);
                completeTCPWrite(inetSocketAddress5, inetSocketAddress6, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                logTCP(true, i10, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress5, inetSocketAddress6, false);
                int i13 = this.sendSegmentNumber + i10;
                this.sendSegmentNumber = i13;
                TCPPacket.writePacket(byteBufBuffer, null, this.receiveSegmentNumber, i13, inetSocketAddress6.getPort(), inetSocketAddress5.getPort(), tCPFlag);
                completeTCPWrite(inetSocketAddress6, inetSocketAddress5, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                logTCP(true, i10, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress6, inetSocketAddress5, true);
            } else {
                if (this.isServerPipeline) {
                    inetSocketAddress = this.initiatorAddr;
                    inetSocketAddress2 = this.handlerAddr;
                } else {
                    inetSocketAddress = this.handlerAddr;
                    inetSocketAddress2 = this.initiatorAddr;
                }
                InetSocketAddress inetSocketAddress7 = inetSocketAddress;
                InetSocketAddress inetSocketAddress8 = inetSocketAddress2;
                int i14 = this.receiveSegmentNumber;
                int i15 = this.sendSegmentNumber;
                int port3 = inetSocketAddress7.getPort();
                int port4 = inetSocketAddress8.getPort();
                TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                TCPPacket.writePacket(byteBufBuffer, byteBufDuplicate, i14, i15, port3, port4, tCPFlag2);
                completeTCPWrite(inetSocketAddress7, inetSocketAddress8, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                logTCP(false, i10, this.receiveSegmentNumber, this.sendSegmentNumber, inetSocketAddress7, inetSocketAddress8, false);
                int i16 = this.receiveSegmentNumber + i10;
                this.receiveSegmentNumber = i16;
                TCPPacket.writePacket(byteBufBuffer, null, this.sendSegmentNumber, i16, inetSocketAddress8.getPort(), inetSocketAddress7.getPort(), tCPFlag2);
                completeTCPWrite(inetSocketAddress8, inetSocketAddress7, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                logTCP(false, i10, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress8, inetSocketAddress7, true);
            }
            byteBufBuffer.release();
        } catch (Throwable th2) {
            byteBufBuffer.release();
            throw th2;
        }
    }

    private void handleUDP(ChannelHandlerContext channelHandlerContext, Object obj) {
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
        try {
            if (obj instanceof DatagramPacket) {
                if (((DatagramPacket) obj).content().readableBytes() == 0 && !this.captureZeroByte) {
                    this.logger.debug("Discarding Zero Byte UDP Packet");
                    return;
                }
                DatagramPacket datagramPacketDuplicate = ((DatagramPacket) obj).duplicate();
                InetSocketAddress inetSocketAddressSender = datagramPacketDuplicate.sender();
                InetSocketAddress inetSocketAddressRecipient = datagramPacketDuplicate.recipient();
                if (inetSocketAddressSender == null) {
                    inetSocketAddressSender = getLocalAddress(channelHandlerContext.channel(), inetSocketAddressRecipient);
                }
                InetSocketAddress inetSocketAddress = inetSocketAddressSender;
                this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(datagramPacketDuplicate.content().readableBytes()), inetSocketAddress, inetSocketAddressRecipient);
                UDPPacket.writePacket(byteBufBuffer, datagramPacketDuplicate.content(), inetSocketAddress.getPort(), inetSocketAddressRecipient.getPort());
                completeUDPWrite(inetSocketAddress, inetSocketAddressRecipient, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
            } else if (!(obj instanceof ByteBuf) || ((channelHandlerContext.channel() instanceof DatagramChannel) && !((DatagramChannel) channelHandlerContext.channel()).isConnected())) {
                this.logger.debug("Discarding Pcap Write for UDP Object: {}", obj);
            } else {
                if (((ByteBuf) obj).readableBytes() == 0 && !this.captureZeroByte) {
                    this.logger.debug("Discarding Zero Byte UDP Packet");
                    return;
                }
                ByteBuf byteBufDuplicate = ((ByteBuf) obj).duplicate();
                this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(byteBufDuplicate.readableBytes()), this.initiatorAddr, this.handlerAddr);
                UDPPacket.writePacket(byteBufBuffer, byteBufDuplicate, this.initiatorAddr.getPort(), this.handlerAddr.getPort());
                completeUDPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
            }
        } finally {
            byteBufBuffer.release();
        }
    }

    private void initializeIfNecessary(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.state.get() != State.INIT) {
            return;
        }
        this.pCapWriter = new PcapWriter(this);
        if (this.channelType == null) {
            if (channelHandlerContext.channel() instanceof SocketChannel) {
                this.channelType = ChannelType.TCP;
                if (channelHandlerContext.channel().parent() instanceof ServerSocketChannel) {
                    this.isServerPipeline = true;
                    this.initiatorAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                    this.handlerAddr = getLocalAddress(channelHandlerContext.channel(), this.initiatorAddr);
                } else {
                    this.isServerPipeline = false;
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                    this.initiatorAddr = getLocalAddress(channelHandlerContext.channel(), this.handlerAddr);
                }
            } else if (channelHandlerContext.channel() instanceof DatagramChannel) {
                this.channelType = ChannelType.UDP;
                if (((DatagramChannel) channelHandlerContext.channel()).isConnected()) {
                    this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                    this.initiatorAddr = getLocalAddress(channelHandlerContext.channel(), this.handlerAddr);
                }
            }
        }
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Initiating Fake TCP 3-Way Handshake");
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
            try {
                int port = this.initiatorAddr.getPort();
                int port2 = this.handlerAddr.getPort();
                TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.SYN;
                TCPPacket.writePacket(byteBufBuffer, null, 0, 0, port, port2, tCPFlag);
                completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
                int port3 = this.handlerAddr.getPort();
                int port4 = this.initiatorAddr.getPort();
                TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                TCPPacket.writePacket(byteBufBuffer, null, 0, 1, port3, port4, tCPFlag, tCPFlag2);
                completeTCPWrite(this.handlerAddr, this.initiatorAddr, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
                TCPPacket.writePacket(byteBufBuffer, null, 1, 1, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), tCPFlag2);
                completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
                byteBufBuffer.release();
                this.logger.debug("Finished Fake TCP 3-Way Handshake");
            } catch (Throwable th2) {
                byteBufBuffer.release();
                throw th2;
            }
        }
        this.state.set(State.WRITING);
    }

    private void logDiscard() {
        this.logger.warn("Discarding pcap write because channel type is unknown. The channel this handler is registered on is not a SocketChannel or DatagramChannel, so the inference does not work. Please call forceTcpChannel or forceUdpChannel before registering the handler.");
    }

    private void logTCP(boolean z10, int i10, int i11, int i12, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z11) {
        if (this.logger.isDebugEnabled()) {
            if (z11) {
                this.logger.debug("Writing TCP ACK, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Boolean.valueOf(z10), Integer.valueOf(i11), Integer.valueOf(i12), inetSocketAddress2, inetSocketAddress);
            } else {
                this.logger.debug("Writing TCP Data of {} Bytes, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Integer.valueOf(i10), Boolean.valueOf(z10), Integer.valueOf(i11), Integer.valueOf(i12), inetSocketAddress, inetSocketAddress2);
            }
        }
    }

    public static void writeGlobalHeader(OutputStream outputStream) throws IOException {
        PcapHeaders.writeGlobalHeader(outputStream);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        initializeIfNecessary(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.state.get() == State.INIT) {
            initializeIfNecessary(channelHandlerContext);
        }
        if (this.state.get() == State.WRITING) {
            ChannelType channelType = this.channelType;
            if (channelType == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, false);
            } else if (channelType == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.state.get() == State.CLOSED) {
            this.logger.debug("PcapWriterHandler is already closed");
            return;
        }
        this.pCapWriter.close();
        markClosed();
        this.logger.debug("PcapWriterHandler is now closed");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        if (this.channelType == ChannelType.TCP) {
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
            try {
                TCPPacket.writePacket(byteBufBuffer, null, this.sendSegmentNumber, this.receiveSegmentNumber, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.RST, TCPPacket.TCPFlag.ACK);
                completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, channelHandlerContext.alloc(), channelHandlerContext);
                byteBufBuffer.release();
                this.logger.debug("Sent Fake TCP RST to close connection");
            } catch (Throwable th3) {
                byteBufBuffer.release();
                throw th3;
            }
        }
        close();
        channelHandlerContext.fireExceptionCaught(th2);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Starting Fake TCP FIN+ACK Flow to close connection");
            ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
            ByteBuf byteBufBuffer = byteBufAllocatorAlloc.buffer();
            try {
                int i10 = this.sendSegmentNumber;
                int i11 = this.receiveSegmentNumber;
                int port = this.initiatorAddr.getPort();
                int port2 = this.handlerAddr.getPort();
                TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.FIN;
                TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                TCPPacket.writePacket(byteBufBuffer, null, i10, i11, port, port2, tCPFlag, tCPFlag2);
                completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                TCPPacket.writePacket(byteBufBuffer, null, this.receiveSegmentNumber, this.sendSegmentNumber, this.handlerAddr.getPort(), this.initiatorAddr.getPort(), tCPFlag, tCPFlag2);
                completeTCPWrite(this.handlerAddr, this.initiatorAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                TCPPacket.writePacket(byteBufBuffer, null, this.sendSegmentNumber + 1, this.receiveSegmentNumber + 1, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), tCPFlag2);
                completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBufBuffer, byteBufAllocatorAlloc, channelHandlerContext);
                byteBufBuffer.release();
                this.logger.debug("Finished Fake TCP FIN+ACK Flow to close connection");
            } catch (Throwable th2) {
                byteBufBuffer.release();
                throw th2;
            }
        }
        close();
        super.handlerRemoved(channelHandlerContext);
    }

    public boolean isWriting() {
        return this.state.get() == State.WRITING;
    }

    public void markClosed() {
        State state = this.state.get();
        State state2 = State.CLOSED;
        if (state != state2) {
            this.state.set(state2);
        }
    }

    public OutputStream outputStream() {
        return this.outputStream;
    }

    public PcapWriter pCapWriter() {
        return this.pCapWriter;
    }

    public void pause() {
        if (e.a(this.state, State.WRITING, State.PAUSED)) {
            return;
        }
        throw new IllegalStateException("State must be 'STARTED' to pause but current state is: " + this.state);
    }

    public void resume() {
        if (e.a(this.state, State.PAUSED, State.WRITING)) {
            return;
        }
        throw new IllegalStateException("State must be 'PAUSED' to resume but current state is: " + this.state);
    }

    public boolean sharedOutputStream() {
        return this.sharedOutputStream;
    }

    public State state() {
        return this.state.get();
    }

    public String toString() {
        return "PcapWriteHandler{captureZeroByte=" + this.captureZeroByte + ", writePcapGlobalHeader=" + this.writePcapGlobalHeader + ", sharedOutputStream=" + this.sharedOutputStream + ", sendSegmentNumber=" + this.sendSegmentNumber + ", receiveSegmentNumber=" + this.receiveSegmentNumber + ", channelType=" + this.channelType + ", initiatorAddr=" + this.initiatorAddr + ", handlerAddr=" + this.handlerAddr + ", isServerPipeline=" + this.isServerPipeline + ", state=" + this.state + f.f14860b;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.state.get() == State.INIT) {
            initializeIfNecessary(channelHandlerContext);
        }
        if (this.state.get() == State.WRITING) {
            ChannelType channelType = this.channelType;
            if (channelType == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, true);
            } else if (channelType == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream) {
        this(outputStream, false, true);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream, boolean z10, boolean z11) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.state = new AtomicReference<>(State.INIT);
        this.outputStream = (OutputStream) ObjectUtil.checkNotNull(outputStream, "OutputStream");
        this.captureZeroByte = z10;
        this.writePcapGlobalHeader = z11;
        this.sharedOutputStream = false;
    }

    private PcapWriteHandler(Builder builder, OutputStream outputStream) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.state = new AtomicReference<>(State.INIT);
        this.outputStream = outputStream;
        this.captureZeroByte = builder.captureZeroByte;
        this.sharedOutputStream = builder.sharedOutputStream;
        this.writePcapGlobalHeader = builder.writePcapGlobalHeader;
        this.channelType = builder.channelType;
        this.handlerAddr = builder.handlerAddr;
        this.initiatorAddr = builder.initiatorAddr;
        this.isServerPipeline = builder.isServerPipeline;
    }
}
