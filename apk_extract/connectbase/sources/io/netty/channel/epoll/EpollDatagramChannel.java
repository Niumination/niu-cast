package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import jq.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class EpollDatagramChannel extends AbstractEpollChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final EpollDatagramChannelConfig config;
    private volatile boolean connected;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + m0.f8867e + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';

    public final class EpollDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public EpollDatagramChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public void epollInReady() {
            int iWritableBytes;
            boolean zScatteringRead;
            EpollDatagramChannelConfig epollDatagramChannelConfigConfig = EpollDatagramChannel.this.config();
            if (EpollDatagramChannel.this.shouldBreakEpollInReady(epollDatagramChannelConfigConfig)) {
                clearEpollIn0();
                return;
            }
            EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandleRecvBufAllocHandle = recvBufAllocHandle();
            epollRecvByteAllocatorHandleRecvBufAllocHandle.edgeTriggered(EpollDatagramChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline channelPipelinePipeline = EpollDatagramChannel.this.pipeline();
            ByteBufAllocator allocator = epollDatagramChannelConfigConfig.getAllocator();
            epollRecvByteAllocatorHandleRecvBufAllocHandle.reset(epollDatagramChannelConfigConfig);
            epollInBefore();
            boolean zIsConnected = EpollDatagramChannel.this.isConnected();
            do {
                int maxDatagramPayloadSize = EpollDatagramChannel.this.config().getMaxDatagramPayloadSize();
                ByteBuf byteBufAllocate = epollRecvByteAllocatorHandleRecvBufAllocHandle.allocate(allocator);
                if (Native.IS_SUPPORTING_RECVMMSG) {
                    iWritableBytes = maxDatagramPayloadSize == 0 ? 1 : byteBufAllocate.writableBytes() / maxDatagramPayloadSize;
                } else {
                    iWritableBytes = 0;
                }
                if (iWritableBytes > 1) {
                    EpollDatagramChannel epollDatagramChannel = EpollDatagramChannel.this;
                    zScatteringRead = epollDatagramChannel.scatteringRead(epollRecvByteAllocatorHandleRecvBufAllocHandle, epollDatagramChannel.cleanDatagramPacketArray(), byteBufAllocate, maxDatagramPayloadSize, iWritableBytes);
                } else if (zIsConnected) {
                    try {
                        if (epollDatagramChannelConfigConfig.isUdpGro()) {
                            EpollDatagramChannel epollDatagramChannel2 = EpollDatagramChannel.this;
                            zScatteringRead = epollDatagramChannel2.recvmsg(epollRecvByteAllocatorHandleRecvBufAllocHandle, epollDatagramChannel2.cleanDatagramPacketArray(), byteBufAllocate);
                        } else {
                            zScatteringRead = EpollDatagramChannel.this.connectedRead(epollRecvByteAllocatorHandleRecvBufAllocHandle, byteBufAllocate, maxDatagramPayloadSize);
                        }
                    } catch (Errors.NativeIoException e10) {
                        if (!zIsConnected) {
                            throw e10;
                        }
                        throw EpollDatagramChannel.this.translateForConnected(e10);
                    }
                } else {
                    EpollDatagramChannel epollDatagramChannel3 = EpollDatagramChannel.this;
                    zScatteringRead = epollDatagramChannel3.recvmsg(epollRecvByteAllocatorHandleRecvBufAllocHandle, epollDatagramChannel3.cleanDatagramPacketArray(), byteBufAllocate);
                }
                if (!zScatteringRead) {
                    break;
                } else {
                    this.readPending = false;
                }
            } while (epollRecvByteAllocatorHandleRecvBufAllocHandle.continueReading(UncheckedBooleanSupplier.TRUE_SUPPLIER));
            th = null;
            try {
                epollRecvByteAllocatorHandleRecvBufAllocHandle.readComplete();
                channelPipelinePipeline.fireChannelReadComplete();
                if (th != null) {
                    channelPipelinePipeline.fireExceptionCaught(th);
                }
            } finally {
                epollInFinally(epollDatagramChannelConfigConfig);
            }
        }
    }

    public EpollDatagramChannel() {
        this((InternetProtocolFamily) null);
    }

    private static void addDatagramPacketToOut(DatagramPacket datagramPacket, RecyclableArrayList recyclableArrayList) {
        if (!(datagramPacket instanceof io.netty.channel.unix.SegmentedDatagramPacket)) {
            recyclableArrayList.add(datagramPacket);
            return;
        }
        io.netty.channel.unix.SegmentedDatagramPacket segmentedDatagramPacket = (io.netty.channel.unix.SegmentedDatagramPacket) datagramPacket;
        ByteBuf byteBufContent = segmentedDatagramPacket.content();
        InetSocketAddress inetSocketAddressRecipient = segmentedDatagramPacket.recipient();
        InetSocketAddress inetSocketAddressSender = segmentedDatagramPacket.sender();
        int iSegmentSize = segmentedDatagramPacket.segmentSize();
        do {
            recyclableArrayList.add(new DatagramPacket(byteBufContent.readRetainedSlice(Math.min(byteBufContent.readableBytes(), iSegmentSize)), inetSocketAddressRecipient, inetSocketAddressSender));
        } while (byteBufContent.isReadable());
        segmentedDatagramPacket.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeDatagramPacketArray cleanDatagramPacketArray() {
        return ((EpollEventLoop) eventLoop()).cleanDatagramPacketArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean connectedRead(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, ByteBuf byteBuf, int i10) throws Exception {
        int address;
        try {
            int iMin = i10 != 0 ? Math.min(byteBuf.writableBytes(), i10) : byteBuf.writableBytes();
            epollRecvByteAllocatorHandle.attemptedBytesRead(iMin);
            int iWriterIndex = byteBuf.writerIndex();
            if (byteBuf.hasMemoryAddress()) {
                address = this.socket.readAddress(byteBuf.memoryAddress(), iWriterIndex, iWriterIndex + iMin);
            } else {
                ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(iWriterIndex, iMin);
                address = this.socket.read(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit());
            }
            if (address <= 0) {
                epollRecvByteAllocatorHandle.lastBytesRead(address);
                byteBuf.release();
                return false;
            }
            byteBuf.writerIndex(iWriterIndex + address);
            if (i10 <= 0) {
                iMin = address;
            }
            epollRecvByteAllocatorHandle.lastBytesRead(iMin);
            DatagramPacket datagramPacket = new DatagramPacket(byteBuf, localAddress(), remoteAddress());
            epollRecvByteAllocatorHandle.incMessagesRead(1);
            pipeline().fireChannelRead((Object) datagramPacket);
            return true;
        } catch (Throwable th2) {
            if (byteBuf != null) {
                byteBuf.release();
            }
            throw th2;
        }
    }

    private boolean doWriteMessage(Object obj) throws Exception {
        ByteBuf byteBuf;
        InetSocketAddress inetSocketAddress;
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            byteBuf = (ByteBuf) addressedEnvelope.content();
            inetSocketAddress = (InetSocketAddress) addressedEnvelope.recipient();
        } else {
            byteBuf = (ByteBuf) obj;
            inetSocketAddress = null;
        }
        return byteBuf.readableBytes() == 0 || doWriteOrSendBytes(byteBuf, inetSocketAddress, false) > 0;
    }

    public static boolean isSegmentedDatagramPacketSupported() {
        return Epoll.isAvailable() && Native.IS_SUPPORTING_SENDMMSG && Native.IS_SUPPORTING_UDP_SEGMENT;
    }

    private static void processPacket(ChannelPipeline channelPipeline, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, int i10, DatagramPacket datagramPacket) {
        epollRecvByteAllocatorHandle.lastBytesRead(i10);
        epollRecvByteAllocatorHandle.incMessagesRead(1);
        channelPipeline.fireChannelRead((Object) datagramPacket);
    }

    private static void processPacketList(ChannelPipeline channelPipeline, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, int i10, RecyclableArrayList recyclableArrayList) {
        int size = recyclableArrayList.size();
        epollRecvByteAllocatorHandle.lastBytesRead(i10);
        epollRecvByteAllocatorHandle.incMessagesRead(size);
        for (int i11 = 0; i11 < size; i11++) {
            channelPipeline.fireChannelRead(recyclableArrayList.set(i11, Unpooled.EMPTY_BUFFER));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean recvmsg(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, NativeDatagramPacketArray nativeDatagramPacketArray, ByteBuf byteBuf) throws Throwable {
        RecyclableArrayList recyclableArrayList = null;
        try {
            int iWritableBytes = byteBuf.writableBytes();
            nativeDatagramPacketArray.addWritable(byteBuf, byteBuf.writerIndex(), iWritableBytes);
            epollRecvByteAllocatorHandle.attemptedBytesRead(iWritableBytes);
            NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket = nativeDatagramPacketArray.packets()[0];
            int iRecvmsg = this.socket.recvmsg(nativeDatagramPacket);
            if (iRecvmsg == 0) {
                epollRecvByteAllocatorHandle.lastBytesRead(-1);
                releaseAndRecycle(byteBuf, null);
                return false;
            }
            byteBuf.writerIndex(iRecvmsg);
            DatagramPacket datagramPacketNewDatagramPacket = nativeDatagramPacket.newDatagramPacket(byteBuf, localAddress());
            if (datagramPacketNewDatagramPacket instanceof io.netty.channel.unix.SegmentedDatagramPacket) {
                RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance();
                try {
                    addDatagramPacketToOut(datagramPacketNewDatagramPacket, recyclableArrayListNewInstance);
                    try {
                        processPacketList(pipeline(), epollRecvByteAllocatorHandle, iRecvmsg, recyclableArrayListNewInstance);
                        recyclableArrayListNewInstance.recycle();
                    } catch (Throwable th2) {
                        th = th2;
                        byteBuf = null;
                        recyclableArrayList = recyclableArrayListNewInstance;
                        releaseAndRecycle(byteBuf, recyclableArrayList);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                processPacket(pipeline(), epollRecvByteAllocatorHandle, iRecvmsg, datagramPacketNewDatagramPacket);
            }
            releaseAndRecycle(null, null);
            return true;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static void releaseAndRecycle(ByteBuf byteBuf, RecyclableArrayList recyclableArrayList) {
        if (byteBuf != null) {
            byteBuf.release();
        }
        if (recyclableArrayList != null) {
            for (int i10 = 0; i10 < recyclableArrayList.size(); i10++) {
                ReferenceCountUtil.release(recyclableArrayList.get(i10));
            }
            recyclableArrayList.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean scatteringRead(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, NativeDatagramPacketArray nativeDatagramPacketArray, ByteBuf byteBuf, int i10, int i11) throws Throwable {
        RecyclableArrayList recyclableArrayList = null;
        try {
            int iWriterIndex = byteBuf.writerIndex();
            int i12 = 0;
            while (i12 < i11 && nativeDatagramPacketArray.addWritable(byteBuf, iWriterIndex, i10)) {
                i12++;
                iWriterIndex += i10;
            }
            epollRecvByteAllocatorHandle.attemptedBytesRead(iWriterIndex - byteBuf.writerIndex());
            NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArrPackets = nativeDatagramPacketArray.packets();
            int iRecvmmsg = this.socket.recvmmsg(nativeDatagramPacketArrPackets, 0, nativeDatagramPacketArray.count());
            if (iRecvmmsg == 0) {
                epollRecvByteAllocatorHandle.lastBytesRead(-1);
                releaseAndRecycle(byteBuf, null);
                return false;
            }
            int i13 = iRecvmmsg * i10;
            byteBuf.writerIndex(i13);
            InetSocketAddress inetSocketAddressLocalAddress = localAddress();
            if (iRecvmmsg == 1) {
                DatagramPacket datagramPacketNewDatagramPacket = nativeDatagramPacketArrPackets[0].newDatagramPacket(byteBuf, inetSocketAddressLocalAddress);
                if (!(datagramPacketNewDatagramPacket instanceof io.netty.channel.unix.SegmentedDatagramPacket)) {
                    processPacket(pipeline(), epollRecvByteAllocatorHandle, i10, datagramPacketNewDatagramPacket);
                    releaseAndRecycle(null, null);
                    return true;
                }
            }
            RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance();
            for (int i14 = 0; i14 < iRecvmmsg; i14++) {
                try {
                    addDatagramPacketToOut(nativeDatagramPacketArrPackets[i14].newDatagramPacket(byteBuf.readRetainedSlice(i10), inetSocketAddressLocalAddress), recyclableArrayListNewInstance);
                } catch (Throwable th2) {
                    th = th2;
                    recyclableArrayList = recyclableArrayListNewInstance;
                    releaseAndRecycle(byteBuf, recyclableArrayList);
                    throw th;
                }
            }
            byteBuf.release();
            try {
                processPacketList(pipeline(), epollRecvByteAllocatorHandle, i13, recyclableArrayListNewInstance);
                recyclableArrayListNewInstance.recycle();
                releaseAndRecycle(null, null);
                return true;
            } catch (Throwable th3) {
                th = th3;
                byteBuf = null;
                recyclableArrayList = recyclableArrayListNewInstance;
                releaseAndRecycle(byteBuf, recyclableArrayList);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IOException translateForConnected(Errors.NativeIoException nativeIoException) {
        if (nativeIoException.expectedErr() != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return nativeIoException;
        }
        PortUnreachableException portUnreachableException = new PortUnreachableException(nativeIoException.getMessage());
        portUnreachableException.initCause(nativeIoException);
        return portUnreachableException;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            if (inetSocketAddress.getAddress().isAnyLocalAddress() && (inetSocketAddress.getAddress() instanceof Inet4Address) && this.socket.family() == InternetProtocolFamily.IPv6) {
                socketAddress = new InetSocketAddress(LinuxSocket.INET6_ANY, inetSocketAddress.getPort());
            }
        }
        super.doBind(socketAddress);
        this.active = true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        super.doClose();
        this.connected = false;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.connected = true;
        return true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
        resetCachedAddresses();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0042 A[ADDED_TO_REGION, LOOP:2: B:21:0x0042->B:22:0x0044, LOOP_START, PHI: r3
      0x0042: PHI (r3v3 int) = (r3v2 int), (r3v4 int) binds: [B:19:0x003f, B:22:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0044 A[Catch: IOException -> 0x0019, LOOP:2: B:21:0x0042->B:22:0x0044, LOOP_END, TryCatch #0 {IOException -> 0x0019, blocks: (B:7:0x000d, B:9:0x0012, B:16:0x0023, B:18:0x0034, B:22:0x0044, B:23:0x004a, B:24:0x004c, B:26:0x0056, B:28:0x005c, B:14:0x001b), top: B:37:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:41:0x004c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x004c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0034 A[SYNTHETIC] */
    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        NativeDatagramPacketArray nativeDatagramPacketArrayCleanDatagramPacketArray;
        int iCount;
        int i10;
        int iSendmmsg;
        int iMaxMessagesPerWrite = maxMessagesPerWrite();
        loop0: while (iMaxMessagesPerWrite > 0) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                break;
            }
            try {
                if (Native.IS_SUPPORTING_SENDMMSG) {
                    if (channelOutboundBuffer.size() <= 1) {
                        if (channelOutboundBuffer.current() instanceof io.netty.channel.unix.SegmentedDatagramPacket) {
                        }
                    }
                    nativeDatagramPacketArrayCleanDatagramPacketArray = cleanDatagramPacketArray();
                    nativeDatagramPacketArrayCleanDatagramPacketArray.add(channelOutboundBuffer, isConnected(), iMaxMessagesPerWrite);
                    iCount = nativeDatagramPacketArrayCleanDatagramPacketArray.count();
                    if (iCount >= 1) {
                        iSendmmsg = this.socket.sendmmsg(nativeDatagramPacketArrayCleanDatagramPacketArray.packets(), 0, iCount);
                        if (iSendmmsg == 0) {
                            break;
                            break;
                        }
                        for (i10 = 0; i10 < iSendmmsg; i10++) {
                            channelOutboundBuffer.remove();
                        }
                        iMaxMessagesPerWrite -= iSendmmsg;
                    }
                } else if (channelOutboundBuffer.current() instanceof io.netty.channel.unix.SegmentedDatagramPacket) {
                    nativeDatagramPacketArrayCleanDatagramPacketArray = cleanDatagramPacketArray();
                    nativeDatagramPacketArrayCleanDatagramPacketArray.add(channelOutboundBuffer, isConnected(), iMaxMessagesPerWrite);
                    iCount = nativeDatagramPacketArrayCleanDatagramPacketArray.count();
                    if (iCount >= 1) {
                        iSendmmsg = this.socket.sendmmsg(nativeDatagramPacketArrayCleanDatagramPacketArray.packets(), 0, iCount);
                        if (iSendmmsg == 0) {
                            break;
                        }
                        while (i10 < iSendmmsg) {
                            channelOutboundBuffer.remove();
                        }
                        iMaxMessagesPerWrite -= iSendmmsg;
                    }
                }
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
        if (obj instanceof io.netty.channel.unix.SegmentedDatagramPacket) {
            if (Native.IS_SUPPORTING_UDP_SEGMENT) {
                io.netty.channel.unix.SegmentedDatagramPacket segmentedDatagramPacket = (io.netty.channel.unix.SegmentedDatagramPacket) obj;
                ByteBuf byteBufContent = segmentedDatagramPacket.content();
                return UnixChannelUtil.isBufferCopyNeededForWrite(byteBufContent) ? segmentedDatagramPacket.replace(newDirectBuffer(segmentedDatagramPacket, byteBufContent)) : obj;
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf byteBufContent2 = datagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBufContent2) ? new DatagramPacket(newDirectBuffer(datagramPacket, byteBufContent2), datagramPacket.recipient()) : obj;
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

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
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

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public EpollDatagramChannel(InternetProtocolFamily internetProtocolFamily) {
        this(LinuxSocket.newSocketDgram(internetProtocolFamily == null ? Socket.isIPv6Preferred() : internetProtocolFamily == InternetProtocolFamily.IPv6), false);
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
        } catch (IOException e10) {
            channelPromise.setFailure((Throwable) e10);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return leaveGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (IOException e10) {
            channelPromise.setFailure((Throwable) e10);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public EpollDatagramChannel(int i10) {
        this(new LinuxSocket(i10), true);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollDatagramChannelConfig config() {
        return this.config;
    }

    private EpollDatagramChannel(LinuxSocket linuxSocket, boolean z10) {
        super((Channel) null, linuxSocket, z10);
        this.config = new EpollDatagramChannelConfig(this);
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
        try {
            this.socket.leaveGroup(inetAddress, networkInterface, inetAddress2);
            channelPromise.setSuccess();
        } catch (IOException e10) {
            channelPromise.setFailure((Throwable) e10);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        try {
            this.socket.joinGroup(inetAddress, networkInterface, inetAddress2);
            channelPromise.setSuccess();
        } catch (IOException e10) {
            channelPromise.setFailure((Throwable) e10);
        }
        return channelPromise;
    }
}
