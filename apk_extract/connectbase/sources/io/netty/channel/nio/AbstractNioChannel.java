package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractNioChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractNioChannel.class);

    /* JADX INFO: renamed from: ch, reason: collision with root package name */
    private final SelectableChannel f8299ch;
    private final Runnable clearReadPendingRunnable;
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    protected final int readInterestOp;
    boolean readPending;
    private SocketAddress requestedRemoteAddress;
    volatile SelectionKey selectionKey;

    public interface NioUnsafe extends Channel.Unsafe {
        SelectableChannel ch();

        void finishConnect();

        void forceFlush();

        void read();
    }

    public AbstractNioChannel(Channel channel, SelectableChannel selectableChannel, int i10) {
        super(channel);
        this.clearReadPendingRunnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractNioChannel.this.clearReadPending0();
            }
        };
        this.f8299ch = selectableChannel;
        this.readInterestOp = i10;
        try {
            selectableChannel.configureBlocking(false);
        } catch (IOException e10) {
            try {
                selectableChannel.close();
            } catch (IOException e11) {
                logger.warn("Failed to close a partially initialized socket.", (Throwable) e11);
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadPending0() {
        this.readPending = false;
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadPending0(boolean z10) {
        this.readPending = z10;
        if (z10) {
            return;
        }
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    public final void clearReadPending() {
        if (!isRegistered()) {
            this.readPending = false;
            return;
        }
        NioEventLoop nioEventLoopEventLoop = eventLoop();
        if (nioEventLoopEventLoop.inEventLoop()) {
            clearReadPending0();
        } else {
            nioEventLoopEventLoop.execute(this.clearReadPendingRunnable);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBeginRead() throws Exception {
        SelectionKey selectionKey = this.selectionKey;
        if (selectionKey.isValid()) {
            this.readPending = true;
            int iInterestOps = selectionKey.interestOps();
            int i10 = this.readInterestOp;
            if ((iInterestOps & i10) == 0) {
                selectionKey.interestOps(i10 | iInterestOps);
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        ChannelPromise channelPromise = this.connectPromise;
        if (channelPromise != null) {
            channelPromise.tryFailure(new ClosedChannelException());
            this.connectPromise = null;
        }
        Future<?> future = this.connectTimeoutFuture;
        if (future != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    public abstract boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    public void doDeregister() throws Exception {
        eventLoop().cancel(selectionKey());
    }

    public abstract void doFinishConnect() throws Exception;

    @Override // io.netty.channel.AbstractChannel
    public void doRegister() throws Exception {
        boolean z10 = false;
        while (true) {
            try {
                this.selectionKey = javaChannel().register(eventLoop().unwrappedSelector(), 0, this);
                return;
            } catch (CancelledKeyException e10) {
                if (z10) {
                    throw e10;
                }
                eventLoop().selectNow();
                z10 = true;
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof NioEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.f8299ch.isOpen();
    }

    @Deprecated
    public boolean isReadPending() {
        return this.readPending;
    }

    public SelectableChannel javaChannel() {
        return this.f8299ch;
    }

    public final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            ReferenceCountUtil.safeRelease(byteBuf);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
            ByteBuf byteBufDirectBuffer = byteBufAllocatorAlloc.directBuffer(i10);
            byteBufDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
            ReferenceCountUtil.safeRelease(byteBuf);
            return byteBufDirectBuffer;
        }
        ByteBuf byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBufThreadLocalDirectBuffer == null) {
            return byteBuf;
        }
        byteBufThreadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
        ReferenceCountUtil.safeRelease(byteBuf);
        return byteBufThreadLocalDirectBuffer;
    }

    public SelectionKey selectionKey() {
        return this.selectionKey;
    }

    @Deprecated
    public void setReadPending(final boolean z10) {
        if (!isRegistered()) {
            this.readPending = z10;
            return;
        }
        NioEventLoop nioEventLoopEventLoop = eventLoop();
        if (nioEventLoopEventLoop.inEventLoop()) {
            setReadPending0(z10);
        } else {
            nioEventLoopEventLoop.execute(new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractNioChannel.this.setReadPending0(z10);
                }
            });
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioEventLoop eventLoop() {
        return (NioEventLoop) super.eventLoop();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioUnsafe unsafe() {
        return (NioUnsafe) super.unsafe();
    }

    public abstract class AbstractNioUnsafe extends AbstractChannel.AbstractUnsafe implements NioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public AbstractNioUnsafe() {
            super();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z10) {
            if (channelPromise == null) {
                return;
            }
            boolean zIsActive = AbstractNioChannel.this.isActive();
            boolean zTrySuccess = channelPromise.trySuccess();
            if (!z10 && zIsActive) {
                AbstractNioChannel.this.pipeline().fireChannelActive();
            }
            if (zTrySuccess) {
                return;
            }
            close(voidPromise());
        }

        private boolean isFlushPending() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            return selectionKey.isValid() && (selectionKey.interestOps() & 4) != 0;
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final SelectableChannel ch() {
            return AbstractNioChannel.this.javaChannel();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractNioChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean zIsActive = AbstractNioChannel.this.isActive();
                    if (AbstractNioChannel.this.doConnect(socketAddress, socketAddress2)) {
                        fulfillConnectPromise(channelPromise, zIsActive);
                        return;
                    }
                    AbstractNioChannel.this.connectPromise = channelPromise;
                    AbstractNioChannel.this.requestedRemoteAddress = socketAddress;
                    int connectTimeoutMillis = AbstractNioChannel.this.config().getConnectTimeoutMillis();
                    if (connectTimeoutMillis > 0) {
                        AbstractNioChannel abstractNioChannel = AbstractNioChannel.this;
                        abstractNioChannel.connectTimeoutFuture = abstractNioChannel.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChannelPromise channelPromise2 = AbstractNioChannel.this.connectPromise;
                                if (channelPromise2 == null || channelPromise2.isDone()) {
                                    return;
                                }
                                if (channelPromise2.tryFailure(new ConnectTimeoutException("connection timed out: " + socketAddress))) {
                                    AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                    abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                                }
                            }
                        }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
                    }
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            if (channelFuture.isCancelled()) {
                                if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                                    AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                                }
                                AbstractNioChannel.this.connectPromise = null;
                                AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                            }
                        }
                    });
                } catch (Throwable th2) {
                    channelPromise.tryFailure(annotateConnectException(th2, socketAddress));
                    closeIfClosed();
                }
            }
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void finishConnect() {
            try {
                boolean zIsActive = AbstractNioChannel.this.isActive();
                AbstractNioChannel.this.doFinishConnect();
                fulfillConnectPromise(AbstractNioChannel.this.connectPromise, zIsActive);
                if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                }
            } catch (Throwable th2) {
                try {
                    fulfillConnectPromise(AbstractNioChannel.this.connectPromise, annotateConnectException(th2, AbstractNioChannel.this.requestedRemoteAddress));
                } finally {
                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                    }
                    AbstractNioChannel.this.connectPromise = null;
                }
            }
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public final void flush0() {
            if (isFlushPending()) {
                return;
            }
            super.flush0();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void forceFlush() {
            super.flush0();
        }

        public final void removeReadOp() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            if (selectionKey.isValid()) {
                int iInterestOps = selectionKey.interestOps();
                int i10 = AbstractNioChannel.this.readInterestOp;
                if ((iInterestOps & i10) != 0) {
                    selectionKey.interestOps((~i10) & iInterestOps);
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th2) {
            if (channelPromise == null) {
                return;
            }
            channelPromise.tryFailure(th2);
            closeIfClosed();
        }
    }

    public final ByteBuf newDirectBuffer(ReferenceCounted referenceCounted, ByteBuf byteBuf) {
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
            ByteBuf byteBufDirectBuffer = byteBufAllocatorAlloc.directBuffer(i10);
            byteBufDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return byteBufDirectBuffer;
        }
        ByteBuf byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBufThreadLocalDirectBuffer != null) {
            byteBufThreadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return byteBufThreadLocalDirectBuffer;
        }
        if (referenceCounted != byteBuf) {
            byteBuf.retain();
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
        return byteBuf;
    }
}
