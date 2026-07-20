package io.netty.handler.traffic;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class GlobalChannelTrafficCounter extends TrafficCounter {

    public static class MixedTrafficMonitoringTask implements Runnable {
        private final TrafficCounter counter;
        private final GlobalChannelTrafficShapingHandler trafficShapingHandler1;

        public MixedTrafficMonitoringTask(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler, TrafficCounter trafficCounter) {
            this.trafficShapingHandler1 = globalChannelTrafficShapingHandler;
            this.counter = trafficCounter;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.counter.monitorActive) {
                long jMilliSecondFromNano = TrafficCounter.milliSecondFromNano();
                this.counter.resetAccounting(jMilliSecondFromNano);
                Iterator<GlobalChannelTrafficShapingHandler.PerChannel> it = this.trafficShapingHandler1.channelQueues.values().iterator();
                while (it.hasNext()) {
                    it.next().channelTrafficCounter.resetAccounting(jMilliSecondFromNano);
                }
                this.trafficShapingHandler1.doAccounting(this.counter);
            }
        }
    }

    public GlobalChannelTrafficCounter(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler, ScheduledExecutorService scheduledExecutorService, String str, long j10) {
        super(globalChannelTrafficShapingHandler, scheduledExecutorService, str, j10);
        ObjectUtil.checkNotNullWithIAE(scheduledExecutorService, "executor");
    }

    @Override // io.netty.handler.traffic.TrafficCounter
    public void resetCumulativeTime() {
        Iterator<GlobalChannelTrafficShapingHandler.PerChannel> it = ((GlobalChannelTrafficShapingHandler) this.trafficShapingHandler).channelQueues.values().iterator();
        while (it.hasNext()) {
            it.next().channelTrafficCounter.resetCumulativeTime();
        }
        super.resetCumulativeTime();
    }

    @Override // io.netty.handler.traffic.TrafficCounter
    public synchronized void start() {
        if (this.monitorActive) {
            return;
        }
        this.lastTime.set(TrafficCounter.milliSecondFromNano());
        long j10 = this.checkInterval.get();
        if (j10 > 0) {
            this.monitorActive = true;
            MixedTrafficMonitoringTask mixedTrafficMonitoringTask = new MixedTrafficMonitoringTask((GlobalChannelTrafficShapingHandler) this.trafficShapingHandler, this);
            this.monitor = mixedTrafficMonitoringTask;
            this.scheduledFuture = this.executor.scheduleAtFixedRate(mixedTrafficMonitoringTask, 0L, j10, TimeUnit.MILLISECONDS);
        }
    }

    @Override // io.netty.handler.traffic.TrafficCounter
    public synchronized void stop() {
        if (this.monitorActive) {
            this.monitorActive = false;
            resetAccounting(TrafficCounter.milliSecondFromNano());
            this.trafficShapingHandler.doAccounting(this);
            if (this.scheduledFuture != null) {
                this.scheduledFuture.cancel(true);
            }
        }
    }
}
