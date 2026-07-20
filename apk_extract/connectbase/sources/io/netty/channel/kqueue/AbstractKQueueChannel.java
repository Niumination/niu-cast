package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.UnixChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractKQueueChannel extends AbstractChannel implements UnixChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    protected volatile boolean active;
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    boolean inputClosedSeenErrorOnRead;
    private volatile SocketAddress local;
    private boolean readFilterEnabled;
    boolean readReadyRunnablePending;
    private volatile SocketAddress remote;
    private SocketAddress requestedRemoteAddress;
    final BsdSocket socket;
    private boolean writeFilterEnabled;

    public abstract class AbstractKQueueUnsafe extends AbstractChannel.AbstractUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private KQueueRecvByteAllocatorHandle allocHandle;
        boolean maybeMoreDataToRead;
        boolean readPending;
        private final Runnable readReadyRunnable;

        public AbstractKQueueUnsafe() {
            super();
            this.readReadyRunnable = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractKQueueUnsafe abstractKQueueUnsafe = AbstractKQueueUnsafe.this;
                    AbstractKQueueChannel.this.readReadyRunnablePending = false;
                    abstractKQueueUnsafe.readReady(abstractKQueueUnsafe.recvBufAllocHandle());
                }
            };
        }

        private boolean doFinishConnect() throws Exception {
            if (!AbstractKQueueChannel.this.socket.finishConnect()) {
                AbstractKQueueChannel.this.writeFilter(true);
                return false;
            }
            AbstractKQueueChannel.this.writeFilter(false);
            if (AbstractKQueueChannel.this.requestedRemoteAddress instanceof InetSocketAddress) {
                AbstractKQueueChannel abstractKQueueChannel = AbstractKQueueChannel.this;
                abstractKQueueChannel.remote = UnixChannelUtil.computeRemoteAddr((InetSocketAddress) abstractKQueueChannel.requestedRemoteAddress, AbstractKQueueChannel.this.socket.remoteAddress());
            }
            AbstractKQueueChannel.this.requestedRemoteAddress = null;
            return true;
        }

        private void finishConnect() {
            try {
                boolean zIsActive = AbstractKQueueChannel.this.isActive();
                if (doFinishConnect()) {
                    fulfillConnectPromise(AbstractKQueueChannel.this.connectPromise, zIsActive);
                    if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                    }
                }
            } catch (Throwable th2) {
                try {
                    fulfillConnectPromise(AbstractKQueueChannel.this.connectPromise, annotateConnectException(th2, AbstractKQueueChannel.this.requestedRemoteAddress));
                } finally {
                    if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                        AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
                    }
                    AbstractKQueueChannel.this.connectPromise = null;
                }
            }
        }

        private void fireEventAndClose(Object obj) {
            AbstractKQueueChannel.this.pipeline().fireUserEventTriggered(obj);
            close(voidPromise());
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z10) {
            if (channelPromise == null) {
                return;
            }
            AbstractKQueueChannel.this.active = true;
            boolean zIsActive = AbstractKQueueChannel.this.isActive();
            boolean zTrySuccess = channelPromise.trySuccess();
            if (!z10 && zIsActive) {
                AbstractKQueueChannel.this.pipeline().fireChannelActive();
            }
            if (zTrySuccess) {
                return;
            }
            close(voidPromise());
        }

        public final void clearReadFilter0() {
            try {
                this.readPending = false;
                AbstractKQueueChannel.this.readFilter(false);
            } catch (IOException e10) {
                AbstractKQueueChannel.this.pipeline().fireExceptionCaught((Throwable) e10);
                AbstractKQueueChannel.this.unsafe().close(AbstractKQueueChannel.this.unsafe().voidPromise());
            }
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe, io.netty.channel.Channel.Unsafe
        public /* bridge */ /* synthetic */ void close(ChannelPromise channelPromise) {
            super.close(channelPromise);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractKQueueChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean zIsActive = AbstractKQueueChannel.this.isActive();
                    if (AbstractKQueueChannel.this.doConnect(socketAddress, socketAddress2)) {
                        fulfillConnectPromise(channelPromise, zIsActive);
                        return;
                    }
                    AbstractKQueueChannel.this.connectPromise = channelPromise;
                    AbstractKQueueChannel.this.requestedRemoteAddress = socketAddress;
                    int connectTimeoutMillis = AbstractKQueueChannel.this.config().getConnectTimeoutMillis();
                    if (connectTimeoutMillis > 0) {
                        AbstractKQueueChannel abstractKQueueChannel = AbstractKQueueChannel.this;
                        abstractKQueueChannel.connectTimeoutFuture = abstractKQueueChannel.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChannelPromise channelPromise2 = AbstractKQueueChannel.this.connectPromise;
                                if (channelPromise2 == null || channelPromise2.isDone()) {
                                    return;
                                }
                                if (channelPromise2.tryFailure(new ConnectTimeoutException("connection timed out: " + socketAddress))) {
                                    AbstractKQueueUnsafe abstractKQueueUnsafe = AbstractKQueueUnsafe.this;
                                    abstractKQueueUnsafe.close(abstractKQueueUnsafe.voidPromise());
                                }
                            }
                        }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
                    }
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.3
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            if (channelFuture.isCancelled()) {
                                if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                                    AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
                                }
                                AbstractKQueueChannel.this.connectPromise = null;
                                AbstractKQueueUnsafe abstractKQueueUnsafe = AbstractKQueueUnsafe.this;
                                abstractKQueueUnsafe.close(abstractKQueueUnsafe.voidPromise());
                            }
                        }
                    });
                } catch (Throwable th2) {
                    closeIfClosed();
                    channelPromise.tryFailure(annotateConnectException(th2, socketAddress));
                }
            }
        }

        public final void executeReadReadyRunnable(ChannelConfig channelConfig) {
            AbstractKQueueChannel abstractKQueueChannel = AbstractKQueueChannel.this;
            if (abstractKQueueChannel.readReadyRunnablePending || !abstractKQueueChannel.isActive() || AbstractKQueueChannel.this.shouldBreakReadReady(channelConfig)) {
                return;
            }
            AbstractKQueueChannel abstractKQueueChannel2 = AbstractKQueueChannel.this;
            abstractKQueueChannel2.readReadyRunnablePending = true;
            abstractKQueueChannel2.eventLoop().execute(this.readReadyRunnable);
        }

        public final boolean failConnectPromise(Throwable th2) {
            if (AbstractKQueueChannel.this.connectPromise == null) {
                return false;
            }
            ChannelPromise channelPromise = AbstractKQueueChannel.this.connectPromise;
            AbstractKQueueChannel.this.connectPromise = null;
            if (!(th2 instanceof ConnectException)) {
                th2 = new ConnectException("failed to connect").initCause(th2);
            }
            if (!channelPromise.tryFailure(th2)) {
                return false;
            }
            closeIfClosed();
            return true;
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public final void flush0() {
            if (AbstractKQueueChannel.this.writeFilterEnabled) {
                return;
            }
            super.flush0();
        }

        public final void readEOF() {
            KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandleRecvBufAllocHandle = recvBufAllocHandle();
            kQueueRecvByteAllocatorHandleRecvBufAllocHandle.readEOF();
            if (AbstractKQueueChannel.this.isActive()) {
                readReady(kQueueRecvByteAllocatorHandleRecvBufAllocHandle);
            } else {
                shutdownInput(true);
            }
        }

        public final void readReady(long j10) {
            KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandleRecvBufAllocHandle = recvBufAllocHandle();
            kQueueRecvByteAllocatorHandleRecvBufAllocHandle.numberBytesPending(j10);
            readReady(kQueueRecvByteAllocatorHandleRecvBufAllocHandle);
        }

        public abstract void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle);

        public final void readReadyBefore() {
            this.maybeMoreDataToRead = false;
        }

        public final void readReadyFinally(ChannelConfig channelConfig) {
            boolean z10;
            this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
            if (this.allocHandle.isReadEOF() || ((z10 = this.readPending) && this.maybeMoreDataToRead)) {
                executeReadReadyRunnable(channelConfig);
            } else {
                if (z10 || channelConfig.isAutoRead()) {
                    return;
                }
                clearReadFilter0();
            }
        }

        public void shutdownInput(boolean z10) {
            if (z10 && AbstractKQueueChannel.this.connectPromise != null) {
                finishConnect();
            }
            if (AbstractKQueueChannel.this.socket.isInputShutdown()) {
                if (z10) {
                    return;
                }
                AbstractKQueueChannel abstractKQueueChannel = AbstractKQueueChannel.this;
                abstractKQueueChannel.inputClosedSeenErrorOnRead = true;
                abstractKQueueChannel.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
                return;
            }
            if (!AbstractKQueueChannel.isAllowHalfClosure(AbstractKQueueChannel.this.config())) {
                close(voidPromise());
                return;
            }
            try {
                AbstractKQueueChannel.this.socket.shutdown(true, false);
            } catch (IOException unused) {
                fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                return;
            } catch (NotYetConnectedException unused2) {
            }
            AbstractKQueueChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
        }

        public final void writeReady() {
            if (AbstractKQueueChannel.this.connectPromise != null) {
                finishConnect();
            } else {
                if (AbstractKQueueChannel.this.socket.isOutputShutdown()) {
                    return;
                }
                super.flush0();
            }
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe, io.netty.channel.Channel.Unsafe
        public KQueueRecvByteAllocatorHandle recvBufAllocHandle() {
            if (this.allocHandle == null) {
                this.allocHandle = new KQueueRecvByteAllocatorHandle((RecvByteBufAllocator.ExtendedHandle) super.recvBufAllocHandle());
            }
            return this.allocHandle;
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th2) {
            if (channelPromise == null) {
                return;
            }
            channelPromise.tryFailure(th2);
            closeIfClosed();
        }
    }

    public AbstractKQueueChannel(Channel channel, BsdSocket bsdSocket, boolean z10) {
        super(channel);
        this.socket = (BsdSocket) ObjectUtil.checkNotNull(bsdSocket, "fd");
        this.active = z10;
        if (z10) {
            this.local = bsdSocket.localAddress();
            this.remote = bsdSocket.remoteAddress();
        }
    }

    public static void checkResolvable(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    private void evSet(short s10, short s11) {
        if (isRegistered()) {
            evSet0(s10, s11);
        }
    }

    private void evSet0(short s10, short s11) {
        evSet0(s10, s11, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        if (channelConfig instanceof KQueueDomainSocketChannelConfig) {
            return ((KQueueDomainSocketChannelConfig) channelConfig).isAllowHalfClosure();
        }
        return (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    public static boolean isSoErrorZero(BsdSocket bsdSocket) {
        try {
            return bsdSocket.getSoError() == 0;
        } catch (IOException e10) {
            throw new ChannelException(e10);
        }
    }

    private static ByteBuf newDirectBuffer0(Object obj, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, int i10) {
        ByteBuf byteBufDirectBuffer = byteBufAllocator.directBuffer(i10);
        byteBufDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
        ReferenceCountUtil.safeRelease(obj);
        return byteBufDirectBuffer;
    }

    public final void clearReadFilter() {
        if (!isRegistered()) {
            this.readFilterEnabled = false;
            return;
        }
        EventLoop eventLoop = eventLoop();
        final AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueUnsafe) unsafe();
        if (eventLoop.inEventLoop()) {
            abstractKQueueUnsafe.clearReadFilter0();
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    if (abstractKQueueUnsafe.readPending || AbstractKQueueChannel.this.config().isAutoRead()) {
                        return;
                    }
                    abstractKQueueUnsafe.clearReadFilter0();
                }
            });
        }
    }

    @Override // io.netty.channel.Channel
    public abstract KQueueChannelConfig config();

    @Override // io.netty.channel.AbstractChannel
    public final void doBeginRead() throws Exception {
        AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueUnsafe) unsafe();
        abstractKQueueUnsafe.readPending = true;
        readFilter(true);
        if (abstractKQueueUnsafe.maybeMoreDataToRead) {
            abstractKQueueUnsafe.executeReadReadyRunnable(config());
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress);
        }
        this.socket.bind(socketAddress);
        this.local = this.socket.localAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        this.active = false;
        this.inputClosedSeenErrorOnRead = true;
        this.socket.close();
    }

    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress2);
        }
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress != null) {
            checkResolvable(inetSocketAddress);
        }
        if (this.remote != null) {
            throw new AlreadyConnectedException();
        }
        if (socketAddress2 != null) {
            this.socket.bind(socketAddress2);
        }
        boolean zDoConnect0 = doConnect0(socketAddress, socketAddress2);
        if (zDoConnect0) {
            if (inetSocketAddress != null) {
                socketAddress = UnixChannelUtil.computeRemoteAddr(inetSocketAddress, this.socket.remoteAddress());
            }
            this.remote = socketAddress;
        }
        this.local = this.socket.localAddress();
        return zDoConnect0;
    }

    public boolean doConnect0(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        try {
            boolean zConnect = this.socket.connect(socketAddress);
            if (!zConnect) {
                writeFilter(true);
            }
            return zConnect;
        } catch (Throwable th2) {
            doClose();
            throw th2;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doDeregister() throws Exception {
        ((KQueueEventLoop) eventLoop()).remove(this);
        this.readFilterEnabled = false;
        this.writeFilterEnabled = false;
    }

    @Override // io.netty.channel.AbstractChannel
    public void doDisconnect() throws Exception {
        doClose();
    }

    public final int doReadBytes(ByteBuf byteBuf) throws Exception {
        int address;
        int iWriterIndex = byteBuf.writerIndex();
        unsafe().recvBufAllocHandle().attemptedBytesRead(byteBuf.writableBytes());
        if (byteBuf.hasMemoryAddress()) {
            address = this.socket.readAddress(byteBuf.memoryAddress(), iWriterIndex, byteBuf.capacity());
        } else {
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(iWriterIndex, byteBuf.writableBytes());
            address = this.socket.read(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit());
        }
        if (address > 0) {
            byteBuf.writerIndex(iWriterIndex + address);
        }
        return address;
    }

    @Override // io.netty.channel.AbstractChannel
    public void doRegister() throws Exception {
        this.readReadyRunnablePending = false;
        ((KQueueEventLoop) eventLoop()).add(this);
        if (this.writeFilterEnabled) {
            evSet0(Native.EVFILT_WRITE, Native.EV_ADD_CLEAR_ENABLE);
        }
        if (this.readFilterEnabled) {
            evSet0(Native.EVFILT_READ, Native.EV_ADD_CLEAR_ENABLE);
        }
        evSet0(Native.EVFILT_SOCK, Native.EV_ADD, Native.NOTE_RDHUP);
    }

    public final int doWriteBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        if (byteBuf.hasMemoryAddress()) {
            int iWriteAddress = this.socket.writeAddress(byteBuf.memoryAddress(), byteBuf.readerIndex(), byteBuf.writerIndex());
            if (iWriteAddress <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.removeBytes(iWriteAddress);
            return 1;
        }
        ByteBuffer byteBufferInternalNioBuffer = byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes()) : byteBuf.nioBuffer();
        int iWrite = this.socket.write(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit());
        if (iWrite <= 0) {
            return Integer.MAX_VALUE;
        }
        byteBufferInternalNioBuffer.position(byteBufferInternalNioBuffer.position() + iWrite);
        channelOutboundBuffer.removeBytes(iWrite);
        return 1;
    }

    @Override // io.netty.channel.unix.UnixChannel
    public final FileDescriptor fd() {
        return this.socket;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.active;
    }

    @Override // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof KQueueEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.socket.isOpen();
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        return newDirectBuffer(byteBuf, byteBuf);
    }

    @Override // io.netty.channel.AbstractChannel
    public abstract AbstractKQueueUnsafe newUnsafe();

    public void readFilter(boolean z10) throws IOException {
        if (this.readFilterEnabled != z10) {
            this.readFilterEnabled = z10;
            evSet(Native.EVFILT_READ, z10 ? Native.EV_ADD_CLEAR_ENABLE : Native.EV_DELETE_DISABLE);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return this.remote;
    }

    public void resetCachedAddresses() {
        this.local = this.socket.localAddress();
        this.remote = this.socket.remoteAddress();
    }

    public final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        return this.socket.isInputShutdown() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig));
    }

    public void unregisterFilters() throws Exception {
        readFilter(false);
        writeFilter(false);
        evSet0(Native.EVFILT_SOCK, Native.EV_DELETE, 0);
    }

    public void writeFilter(boolean z10) throws IOException {
        if (this.writeFilterEnabled != z10) {
            this.writeFilterEnabled = z10;
            evSet(Native.EVFILT_WRITE, z10 ? Native.EV_ADD_CLEAR_ENABLE : Native.EV_DELETE_DISABLE);
        }
    }

    private void evSet0(short s10, short s11, int i10) {
        if (isOpen()) {
            ((KQueueEventLoop) eventLoop()).evSet(this, s10, s11, i10);
        }
    }

    public final ByteBuf newDirectBuffer(Object obj, ByteBuf byteBuf) {
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            ReferenceCountUtil.release(obj);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
            return newDirectBuffer0(obj, byteBuf, byteBufAllocatorAlloc, i10);
        }
        ByteBuf byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBufThreadLocalDirectBuffer == null) {
            return newDirectBuffer0(obj, byteBuf, byteBufAllocatorAlloc, i10);
        }
        byteBufThreadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
        ReferenceCountUtil.safeRelease(obj);
        return byteBufThreadLocalDirectBuffer;
    }

    public AbstractKQueueChannel(Channel channel, BsdSocket bsdSocket, SocketAddress socketAddress) {
        super(channel);
        this.socket = (BsdSocket) ObjectUtil.checkNotNull(bsdSocket, "fd");
        this.active = true;
        this.remote = socketAddress;
        this.local = bsdSocket.localAddress();
    }
}
