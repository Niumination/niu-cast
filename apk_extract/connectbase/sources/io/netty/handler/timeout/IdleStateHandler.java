package io.netty.handler.timeout;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class IdleStateHandler extends ChannelDuplexHandler {
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private final long allIdleTimeNanos;
    private Future<?> allIdleTimeout;
    private boolean firstAllIdleEvent;
    private boolean firstReaderIdleEvent;
    private boolean firstWriterIdleEvent;
    private long lastChangeCheckTimeStamp;
    private long lastFlushProgress;
    private int lastMessageHashCode;
    private long lastPendingWriteBytes;
    private long lastReadTime;
    private long lastWriteTime;
    private final boolean observeOutput;
    private final long readerIdleTimeNanos;
    private Future<?> readerIdleTimeout;
    private boolean reading;
    private byte state;
    private final ChannelFutureListener writeListener;
    private final long writerIdleTimeNanos;
    private Future<?> writerIdleTimeout;

    /* JADX INFO: renamed from: io.netty.handler.timeout.IdleStateHandler$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$timeout$IdleState;

        static {
            int[] iArr = new int[IdleState.values().length];
            $SwitchMap$io$netty$handler$timeout$IdleState = iArr;
            try {
                iArr[IdleState.ALL_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$timeout$IdleState[IdleState.READER_IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$timeout$IdleState[IdleState.WRITER_IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static abstract class AbstractIdleTask implements Runnable {
        private final ChannelHandlerContext ctx;

        public AbstractIdleTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ctx.channel().isOpen()) {
                run(this.ctx);
            }
        }

        public abstract void run(ChannelHandlerContext channelHandlerContext);
    }

    public final class AllIdleTimeoutTask extends AbstractIdleTask {
        public AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        public void run(ChannelHandlerContext channelHandlerContext) {
            long jTicksInNanos = IdleStateHandler.this.allIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                jTicksInNanos -= IdleStateHandler.this.ticksInNanos() - Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime);
            }
            long j10 = jTicksInNanos;
            if (j10 > 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.allIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, j10, TimeUnit.NANOSECONDS);
                return;
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.allIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, idleStateHandler2.allIdleTimeNanos, TimeUnit.NANOSECONDS);
            boolean z10 = IdleStateHandler.this.firstAllIdleEvent;
            IdleStateHandler.this.firstAllIdleEvent = false;
            try {
                if (IdleStateHandler.this.hasOutputChanged(channelHandlerContext, z10)) {
                    return;
                }
                IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.ALL_IDLE, z10));
            } catch (Throwable th2) {
                channelHandlerContext.fireExceptionCaught(th2);
            }
        }
    }

    public final class ReaderIdleTimeoutTask extends AbstractIdleTask {
        public ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        public void run(ChannelHandlerContext channelHandlerContext) {
            long jTicksInNanos = IdleStateHandler.this.readerIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                jTicksInNanos -= IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastReadTime;
            }
            long j10 = jTicksInNanos;
            if (j10 > 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.readerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, j10, TimeUnit.NANOSECONDS);
                return;
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.readerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, idleStateHandler2.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
            boolean z10 = IdleStateHandler.this.firstReaderIdleEvent;
            IdleStateHandler.this.firstReaderIdleEvent = false;
            try {
                IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.READER_IDLE, z10));
            } catch (Throwable th2) {
                channelHandlerContext.fireExceptionCaught(th2);
            }
        }
    }

    public final class WriterIdleTimeoutTask extends AbstractIdleTask {
        public WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        public void run(ChannelHandlerContext channelHandlerContext) {
            long jTicksInNanos = IdleStateHandler.this.writerIdleTimeNanos - (IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastWriteTime);
            if (jTicksInNanos > 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.writerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, jTicksInNanos, TimeUnit.NANOSECONDS);
                return;
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.writerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, idleStateHandler2.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
            boolean z10 = IdleStateHandler.this.firstWriterIdleEvent;
            IdleStateHandler.this.firstWriterIdleEvent = false;
            try {
                if (IdleStateHandler.this.hasOutputChanged(channelHandlerContext, z10)) {
                    return;
                }
                IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.WRITER_IDLE, z10));
            } catch (Throwable th2) {
                channelHandlerContext.fireExceptionCaught(th2);
            }
        }
    }

    public IdleStateHandler(int i10, int i11, int i12) {
        this(i10, i11, i12, TimeUnit.SECONDS);
    }

    private void destroy() {
        this.state = (byte) 2;
        Future<?> future = this.readerIdleTimeout;
        if (future != null) {
            future.cancel(false);
            this.readerIdleTimeout = null;
        }
        Future<?> future2 = this.writerIdleTimeout;
        if (future2 != null) {
            future2.cancel(false);
            this.writerIdleTimeout = null;
        }
        Future<?> future3 = this.allIdleTimeout;
        if (future3 != null) {
            future3.cancel(false);
            this.allIdleTimeout = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasOutputChanged(ChannelHandlerContext channelHandlerContext, boolean z10) {
        if (!this.observeOutput) {
            return false;
        }
        long j10 = this.lastChangeCheckTimeStamp;
        long j11 = this.lastWriteTime;
        if (j10 != j11) {
            this.lastChangeCheckTimeStamp = j11;
            if (!z10) {
                return true;
            }
        }
        ChannelOutboundBuffer channelOutboundBufferOutboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        if (channelOutboundBufferOutboundBuffer == null) {
            return false;
        }
        int iIdentityHashCode = System.identityHashCode(channelOutboundBufferOutboundBuffer.current());
        long j12 = channelOutboundBufferOutboundBuffer.totalPendingWriteBytes();
        if (iIdentityHashCode != this.lastMessageHashCode || j12 != this.lastPendingWriteBytes) {
            this.lastMessageHashCode = iIdentityHashCode;
            this.lastPendingWriteBytes = j12;
            if (!z10) {
                return true;
            }
        }
        long jCurrentProgress = channelOutboundBufferOutboundBuffer.currentProgress();
        if (jCurrentProgress == this.lastFlushProgress) {
            return false;
        }
        this.lastFlushProgress = jCurrentProgress;
        return !z10;
    }

    private void initOutputChanged(ChannelHandlerContext channelHandlerContext) {
        ChannelOutboundBuffer channelOutboundBufferOutboundBuffer;
        if (!this.observeOutput || (channelOutboundBufferOutboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer()) == null) {
            return;
        }
        this.lastMessageHashCode = System.identityHashCode(channelOutboundBufferOutboundBuffer.current());
        this.lastPendingWriteBytes = channelOutboundBufferOutboundBuffer.totalPendingWriteBytes();
        this.lastFlushProgress = channelOutboundBufferOutboundBuffer.currentProgress();
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        byte b10 = this.state;
        if (b10 == 1 || b10 == 2) {
            return;
        }
        this.state = (byte) 1;
        initOutputChanged(channelHandlerContext);
        long jTicksInNanos = ticksInNanos();
        this.lastWriteTime = jTicksInNanos;
        this.lastReadTime = jTicksInNanos;
        if (this.readerIdleTimeNanos > 0) {
            this.readerIdleTimeout = schedule(channelHandlerContext, new ReaderIdleTimeoutTask(channelHandlerContext), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
        if (this.writerIdleTimeNanos > 0) {
            this.writerIdleTimeout = schedule(channelHandlerContext, new WriterIdleTimeoutTask(channelHandlerContext), this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
        if (this.allIdleTimeNanos > 0) {
            this.allIdleTimeout = schedule(channelHandlerContext, new AllIdleTimeoutTask(channelHandlerContext), this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        initialize(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    public void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) throws Exception {
        channelHandlerContext.fireUserEventTriggered((Object) idleStateEvent);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            this.reading = true;
            this.firstAllIdleEvent = true;
            this.firstReaderIdleEvent = true;
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if ((this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) && this.reading) {
            this.lastReadTime = ticksInNanos();
            this.reading = false;
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive()) {
            initialize(channelHandlerContext);
        }
        super.channelRegistered(channelHandlerContext);
    }

    public long getAllIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.allIdleTimeNanos);
    }

    public long getReaderIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.readerIdleTimeNanos);
    }

    public long getWriterIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.writerIdleTimeNanos);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive() && channelHandlerContext.channel().isRegistered()) {
            initialize(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
    }

    public IdleStateEvent newIdleStateEvent(IdleState idleState, boolean z10) {
        int i10 = AnonymousClass2.$SwitchMap$io$netty$handler$timeout$IdleState[idleState.ordinal()];
        if (i10 == 1) {
            return z10 ? IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT : IdleStateEvent.ALL_IDLE_STATE_EVENT;
        }
        if (i10 == 2) {
            return z10 ? IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT : IdleStateEvent.READER_IDLE_STATE_EVENT;
        }
        if (i10 == 3) {
            return z10 ? IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT : IdleStateEvent.WRITER_IDLE_STATE_EVENT;
        }
        throw new IllegalArgumentException("Unhandled: state=" + idleState + ", first=" + z10);
    }

    public Future<?> schedule(ChannelHandlerContext channelHandlerContext, Runnable runnable, long j10, TimeUnit timeUnit) {
        return channelHandlerContext.executor().schedule(runnable, j10, timeUnit);
    }

    public long ticksInNanos() {
        return System.nanoTime();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.writerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            channelHandlerContext.write(obj, channelPromise.unvoid()).addListener((GenericFutureListener<? extends Future<? super Void>>) this.writeListener);
        } else {
            channelHandlerContext.write(obj, channelPromise);
        }
    }

    public IdleStateHandler(long j10, long j11, long j12, TimeUnit timeUnit) {
        this(false, j10, j11, j12, timeUnit);
    }

    public IdleStateHandler(boolean z10, long j10, long j11, long j12, TimeUnit timeUnit) {
        this.writeListener = new ChannelFutureListener() { // from class: io.netty.handler.timeout.IdleStateHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.lastWriteTime = idleStateHandler.ticksInNanos();
                IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
                idleStateHandler2.firstWriterIdleEvent = idleStateHandler2.firstAllIdleEvent = true;
            }
        };
        this.firstReaderIdleEvent = true;
        this.firstWriterIdleEvent = true;
        this.firstAllIdleEvent = true;
        ObjectUtil.checkNotNull(timeUnit, "unit");
        this.observeOutput = z10;
        if (j10 <= 0) {
            this.readerIdleTimeNanos = 0L;
        } else {
            this.readerIdleTimeNanos = Math.max(timeUnit.toNanos(j10), MIN_TIMEOUT_NANOS);
        }
        if (j11 <= 0) {
            this.writerIdleTimeNanos = 0L;
        } else {
            this.writerIdleTimeNanos = Math.max(timeUnit.toNanos(j11), MIN_TIMEOUT_NANOS);
        }
        if (j12 <= 0) {
            this.allIdleTimeNanos = 0L;
        } else {
            this.allIdleTimeNanos = Math.max(timeUnit.toNanos(j12), MIN_TIMEOUT_NANOS);
        }
    }
}
