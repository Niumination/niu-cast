package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ArrayDeque<ToSend> messagesQueue;
    private long queueSize;

    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final Object toSend;

        private ToSend(long j10, Object obj, ChannelPromise channelPromise) {
            this.relativeTimeAction = j10;
            this.toSend = obj;
            this.promise = channelPromise;
        }
    }

    public ChannelTrafficShapingHandler(long j10, long j11, long j12, long j13) {
        super(j10, j11, j12, j13);
        this.messagesQueue = new ArrayDeque<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, long j10) {
        synchronized (this) {
            try {
                ToSend toSendPollFirst = this.messagesQueue.pollFirst();
                while (toSendPollFirst != null) {
                    if (toSendPollFirst.relativeTimeAction > j10) {
                        this.messagesQueue.addFirst(toSendPollFirst);
                        break;
                    }
                    long jCalculateSize = calculateSize(toSendPollFirst.toSend);
                    this.trafficCounter.bytesRealWriteFlowControl(jCalculateSize);
                    this.queueSize -= jCalculateSize;
                    channelHandlerContext.write(toSendPollFirst.toSend, toSendPollFirst.promise);
                    toSendPollFirst = this.messagesQueue.pollFirst();
                }
                if (this.messagesQueue.isEmpty()) {
                    releaseWriteSuspended(channelHandlerContext);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        TrafficCounter trafficCounter = new TrafficCounter(this, channelHandlerContext.executor(), "ChannelTC" + channelHandlerContext.channel().hashCode(), this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.trafficCounter.stop();
        synchronized (this) {
            try {
                if (channelHandlerContext.channel().isActive()) {
                    for (ToSend toSend : this.messagesQueue) {
                        long jCalculateSize = calculateSize(toSend.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(jCalculateSize);
                        this.queueSize -= jCalculateSize;
                        channelHandlerContext.write(toSend.toSend, toSend.promise);
                    }
                } else {
                    Iterator<ToSend> it = this.messagesQueue.iterator();
                    while (it.hasNext()) {
                        Object obj = it.next().toSend;
                        if (obj instanceof ByteBuf) {
                            ((ByteBuf) obj).release();
                        }
                    }
                }
                this.messagesQueue.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public long queueSize() {
        return this.queueSize;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j10, long j11, long j12, ChannelPromise channelPromise) {
        synchronized (this) {
            if (j11 == 0) {
                try {
                    if (this.messagesQueue.isEmpty()) {
                        this.trafficCounter.bytesRealWriteFlowControl(j10);
                        channelHandlerContext.write(obj, channelPromise);
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            ToSend toSend = new ToSend(j11 + j12, obj, channelPromise);
            this.messagesQueue.addLast(toSend);
            long j13 = this.queueSize + j10;
            this.queueSize = j13;
            checkWriteSuspend(channelHandlerContext, j11, j13);
            final long j14 = toSend.relativeTimeAction;
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.ChannelTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelTrafficShapingHandler.this.sendAllValid(channelHandlerContext, j14);
                }
            }, j11, TimeUnit.MILLISECONDS);
        }
    }

    public ChannelTrafficShapingHandler(long j10, long j11, long j12) {
        super(j10, j11, j12);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j10, long j11) {
        super(j10, j11);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j10) {
        super(j10);
        this.messagesQueue = new ArrayDeque<>();
    }
}
