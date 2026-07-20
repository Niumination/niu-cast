package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
@ChannelHandler.Sharable
public class GlobalTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ConcurrentMap<Integer, PerChannel> channelQueues;
    long maxGlobalWriteSize;
    private final AtomicLong queuesSize;

    public static final class PerChannel {
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;

        private PerChannel() {
        }
    }

    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final long size;
        final Object toSend;

        private ToSend(long j10, Object obj, long j11, ChannelPromise channelPromise) {
            this.relativeTimeAction = j10;
            this.toSend = obj;
            this.size = j11;
            this.promise = channelPromise;
        }
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j10, long j11, long j12, long j13) {
        super(j10, j11, j12, j13);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext) {
        Integer numValueOf = Integer.valueOf(channelHandlerContext.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(numValueOf);
        if (perChannel != null) {
            return perChannel;
        }
        PerChannel perChannel2 = new PerChannel();
        perChannel2.messagesQueue = new ArrayDeque<>();
        perChannel2.queueSize = 0L;
        long jMilliSecondFromNano = TrafficCounter.milliSecondFromNano();
        perChannel2.lastReadTimestamp = jMilliSecondFromNano;
        perChannel2.lastWriteTimestamp = jMilliSecondFromNano;
        this.channelQueues.put(numValueOf, perChannel2);
        return perChannel2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, PerChannel perChannel, long j10) {
        synchronized (perChannel) {
            try {
                ToSend toSendPollFirst = perChannel.messagesQueue.pollFirst();
                while (toSendPollFirst != null) {
                    if (toSendPollFirst.relativeTimeAction > j10) {
                        perChannel.messagesQueue.addFirst(toSendPollFirst);
                        break;
                    }
                    long j11 = toSendPollFirst.size;
                    this.trafficCounter.bytesRealWriteFlowControl(j11);
                    perChannel.queueSize -= j11;
                    this.queuesSize.addAndGet(-j11);
                    channelHandlerContext.write(toSendPollFirst.toSend, toSendPollFirst.promise);
                    perChannel.lastWriteTimestamp = j10;
                    toSendPollFirst = perChannel.messagesQueue.pollFirst();
                }
                if (perChannel.messagesQueue.isEmpty()) {
                    releaseWriteSuspended(channelHandlerContext);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j10, long j11) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        return (perChannel == null || j10 <= this.maxTime || (j11 + j10) - perChannel.lastReadTimestamp <= this.maxTime) ? j10 : this.maxTime;
    }

    public void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService) {
        TrafficCounter trafficCounter = new TrafficCounter(this, (ScheduledExecutorService) ObjectUtil.checkNotNull(scheduledExecutorService, "executor"), "GlobalTC", this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        getOrSetPerChannel(channelHandlerContext);
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        Channel channel = channelHandlerContext.channel();
        PerChannel perChannelRemove = this.channelQueues.remove(Integer.valueOf(channel.hashCode()));
        if (perChannelRemove != null) {
            synchronized (perChannelRemove) {
                try {
                    if (channel.isActive()) {
                        for (ToSend toSend : perChannelRemove.messagesQueue) {
                            long jCalculateSize = calculateSize(toSend.toSend);
                            this.trafficCounter.bytesRealWriteFlowControl(jCalculateSize);
                            perChannelRemove.queueSize -= jCalculateSize;
                            this.queuesSize.addAndGet(-jCalculateSize);
                            channelHandlerContext.write(toSend.toSend, toSend.promise);
                        }
                    } else {
                        this.queuesSize.addAndGet(-perChannelRemove.queueSize);
                        Iterator<ToSend> it = perChannelRemove.messagesQueue.iterator();
                        while (it.hasNext()) {
                            Object obj = it.next().toSend;
                            if (obj instanceof ByteBuf) {
                                ((ByteBuf) obj).release();
                            }
                        }
                    }
                    perChannelRemove.messagesQueue.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void informReadOperation(ChannelHandlerContext channelHandlerContext, long j10) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = j10;
        }
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    public void setMaxGlobalWriteSize(long j10) {
        this.maxGlobalWriteSize = j10;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j10, long j11, long j12, ChannelPromise channelPromise) {
        PerChannel orSetPerChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (orSetPerChannel == null) {
            orSetPerChannel = getOrSetPerChannel(channelHandlerContext);
        }
        final PerChannel perChannel = orSetPerChannel;
        synchronized (perChannel) {
            if (j11 == 0) {
                try {
                    if (perChannel.messagesQueue.isEmpty()) {
                        this.trafficCounter.bytesRealWriteFlowControl(j10);
                        channelHandlerContext.write(obj, channelPromise);
                        perChannel.lastWriteTimestamp = j12;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            long j13 = (j11 <= this.maxTime || (j12 + j11) - perChannel.lastWriteTimestamp <= this.maxTime) ? j11 : this.maxTime;
            ToSend toSend = new ToSend(j13 + j12, obj, j10, channelPromise);
            perChannel.messagesQueue.addLast(toSend);
            perChannel.queueSize += j10;
            this.queuesSize.addAndGet(j10);
            checkWriteSuspend(channelHandlerContext, j13, perChannel.queueSize);
            boolean z10 = this.queuesSize.get() > this.maxGlobalWriteSize;
            if (z10) {
                setUserDefinedWritability(channelHandlerContext, false);
            }
            final long j14 = toSend.relativeTimeAction;
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.GlobalTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalTrafficShapingHandler.this.sendAllValid(channelHandlerContext, perChannel, j14);
                }
            }, j13, TimeUnit.MILLISECONDS);
        }
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public int userDefinedWritabilityIndex() {
        return 2;
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j10, long j11, long j12) {
        super(j10, j11, j12);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j10, long j11) {
        super(j10, j11);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j10) {
        super(j10);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(EventExecutor eventExecutor) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(eventExecutor);
    }
}
