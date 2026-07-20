package io.netty.handler.traffic;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import k.d;
import n1.e;
import nq.v1;

/* JADX INFO: loaded from: classes3.dex */
public class TrafficCounter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) TrafficCounter.class);
    final AtomicLong checkInterval;
    private final AtomicLong cumulativeReadBytes;
    private final AtomicLong cumulativeWrittenBytes;
    private final AtomicLong currentReadBytes;
    private final AtomicLong currentWrittenBytes;
    final ScheduledExecutorService executor;
    private long lastCumulativeTime;
    private volatile long lastReadBytes;
    private long lastReadThroughput;
    private volatile long lastReadingTime;
    final AtomicLong lastTime;
    private long lastWriteThroughput;
    private volatile long lastWritingTime;
    private volatile long lastWrittenBytes;
    Runnable monitor;
    volatile boolean monitorActive;
    final String name;
    private long readingTime;
    private long realWriteThroughput;
    private final AtomicLong realWrittenBytes;
    volatile ScheduledFuture<?> scheduledFuture;
    final AbstractTrafficShapingHandler trafficShapingHandler;
    private long writingTime;

    public final class TrafficMonitoringTask implements Runnable {
        private TrafficMonitoringTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TrafficCounter.this.monitorActive) {
                TrafficCounter.this.resetAccounting(TrafficCounter.milliSecondFromNano());
                TrafficCounter trafficCounter = TrafficCounter.this;
                AbstractTrafficShapingHandler abstractTrafficShapingHandler = trafficCounter.trafficShapingHandler;
                if (abstractTrafficShapingHandler != null) {
                    abstractTrafficShapingHandler.doAccounting(trafficCounter);
                }
            }
        }
    }

    public TrafficCounter(ScheduledExecutorService scheduledExecutorService, String str, long j10) {
        this.currentWrittenBytes = new AtomicLong();
        this.currentReadBytes = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.lastTime = new AtomicLong();
        this.realWrittenBytes = new AtomicLong();
        this.checkInterval = new AtomicLong(1000L);
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.trafficShapingHandler = null;
        this.executor = scheduledExecutorService;
        init(j10);
    }

    private void init(long j10) {
        this.lastCumulativeTime = System.currentTimeMillis();
        long jMilliSecondFromNano = milliSecondFromNano();
        this.writingTime = jMilliSecondFromNano;
        this.readingTime = jMilliSecondFromNano;
        this.lastWritingTime = jMilliSecondFromNano;
        this.lastReadingTime = this.writingTime;
        configure(j10);
    }

    public static long milliSecondFromNano() {
        return System.nanoTime() / v1.f11967e;
    }

    public void bytesRealWriteFlowControl(long j10) {
        this.realWrittenBytes.addAndGet(j10);
    }

    public void bytesRecvFlowControl(long j10) {
        this.currentReadBytes.addAndGet(j10);
        this.cumulativeReadBytes.addAndGet(j10);
    }

    public void bytesWriteFlowControl(long j10) {
        this.currentWrittenBytes.addAndGet(j10);
        this.cumulativeWrittenBytes.addAndGet(j10);
    }

    public long checkInterval() {
        return this.checkInterval.get();
    }

    public void configure(long j10) {
        long j11 = (j10 / 10) * 10;
        if (this.checkInterval.getAndSet(j11) != j11) {
            if (j11 <= 0) {
                stop();
                this.lastTime.set(milliSecondFromNano());
            } else {
                stop();
                start();
            }
        }
    }

    public long cumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public long cumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long currentReadBytes() {
        return this.currentReadBytes.get();
    }

    public long currentWrittenBytes() {
        return this.currentWrittenBytes.get();
    }

    public long getRealWriteThroughput() {
        return this.realWriteThroughput;
    }

    public AtomicLong getRealWrittenBytes() {
        return this.realWrittenBytes;
    }

    public long lastCumulativeTime() {
        return this.lastCumulativeTime;
    }

    public long lastReadBytes() {
        return this.lastReadBytes;
    }

    public long lastReadThroughput() {
        return this.lastReadThroughput;
    }

    public long lastTime() {
        return this.lastTime.get();
    }

    public long lastWriteThroughput() {
        return this.lastWriteThroughput;
    }

    public long lastWrittenBytes() {
        return this.lastWrittenBytes;
    }

    public String name() {
        return this.name;
    }

    @Deprecated
    public long readTimeToWait(long j10, long j11, long j12) {
        return readTimeToWait(j10, j11, j12, milliSecondFromNano());
    }

    public synchronized void resetAccounting(long j10) {
        try {
            long andSet = j10 - this.lastTime.getAndSet(j10);
            if (andSet == 0) {
                return;
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled() && andSet > (checkInterval() << 1)) {
                internalLogger.debug("Acct schedule not ok: " + andSet + " > 2*" + checkInterval() + " from " + this.name);
            }
            this.lastReadBytes = this.currentReadBytes.getAndSet(0L);
            this.lastWrittenBytes = this.currentWrittenBytes.getAndSet(0L);
            this.lastReadThroughput = (this.lastReadBytes * 1000) / andSet;
            this.lastWriteThroughput = (this.lastWrittenBytes * 1000) / andSet;
            this.realWriteThroughput = (this.realWrittenBytes.getAndSet(0L) * 1000) / andSet;
            this.lastWritingTime = Math.max(this.lastWritingTime, this.writingTime);
            this.lastReadingTime = Math.max(this.lastReadingTime, this.readingTime);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void resetCumulativeTime() {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.cumulativeReadBytes.set(0L);
        this.cumulativeWrittenBytes.set(0L);
    }

    public synchronized void start() {
        if (this.monitorActive) {
            return;
        }
        this.lastTime.set(milliSecondFromNano());
        long j10 = this.checkInterval.get();
        if (j10 > 0 && this.executor != null) {
            this.monitorActive = true;
            TrafficMonitoringTask trafficMonitoringTask = new TrafficMonitoringTask();
            this.monitor = trafficMonitoringTask;
            this.scheduledFuture = this.executor.scheduleAtFixedRate(trafficMonitoringTask, 0L, j10, TimeUnit.MILLISECONDS);
        }
    }

    public synchronized void stop() {
        try {
            if (this.monitorActive) {
                this.monitorActive = false;
                resetAccounting(milliSecondFromNano());
                AbstractTrafficShapingHandler abstractTrafficShapingHandler = this.trafficShapingHandler;
                if (abstractTrafficShapingHandler != null) {
                    abstractTrafficShapingHandler.doAccounting(this);
                }
                if (this.scheduledFuture != null) {
                    this.scheduledFuture.cancel(true);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(165);
        sb2.append("Monitor ");
        sb2.append(this.name);
        sb2.append(" Current Speed Read: ");
        sb2.append(this.lastReadThroughput >> 10);
        sb2.append(" KB/s, Asked Write: ");
        sb2.append(this.lastWriteThroughput >> 10);
        sb2.append(" KB/s, Real Write: ");
        sb2.append(this.realWriteThroughput >> 10);
        sb2.append(" KB/s, Current Read: ");
        sb2.append(this.currentReadBytes.get() >> 10);
        sb2.append(" KB, Current asked Write: ");
        sb2.append(this.currentWrittenBytes.get() >> 10);
        sb2.append(" KB, Current real Write: ");
        return d.a(sb2, this.realWrittenBytes.get() >> 10, " KB");
    }

    @Deprecated
    public long writeTimeToWait(long j10, long j11, long j12) {
        return writeTimeToWait(j10, j11, j12, milliSecondFromNano());
    }

    public long readTimeToWait(long j10, long j11, long j12, long j13) {
        long j14;
        long j15;
        bytesRecvFlowControl(j10);
        if (j10 == 0 || j11 == 0) {
            return 0L;
        }
        long j16 = this.lastTime.get();
        long j17 = this.currentReadBytes.get();
        long j18 = this.readingTime;
        long j19 = this.lastReadBytes;
        long j20 = j13 - j16;
        long jMax = Math.max(this.lastReadingTime - j16, 0L);
        if (j20 > 10) {
            long j21 = (((1000 * j17) / j11) - j20) + jMax;
            if (j21 <= 10) {
                this.readingTime = Math.max(j18, j13);
                return 0L;
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Time: " + j21 + e.f11184d + j17 + e.f11184d + j20 + e.f11184d + jMax);
            }
            if (j21 > j12) {
                j15 = j18;
                if ((j13 + j21) - j15 > j12) {
                    j21 = j12;
                }
            } else {
                j15 = j18;
            }
            this.readingTime = Math.max(j15, j13 + j21);
            return j21;
        }
        long j22 = j17 + j19;
        long j23 = this.checkInterval.get() + j20;
        long j24 = (((1000 * j22) / j11) - j23) + jMax;
        if (j24 <= 10) {
            this.readingTime = Math.max(j18, j13);
            return 0L;
        }
        InternalLogger internalLogger2 = logger;
        if (internalLogger2.isDebugEnabled()) {
            internalLogger2.debug("Time: " + j24 + e.f11184d + j22 + e.f11184d + j23 + e.f11184d + jMax);
        }
        if (j24 > j12) {
            j14 = j18;
            if ((j13 + j24) - j14 > j12) {
                j24 = j12;
            }
        } else {
            j14 = j18;
        }
        this.readingTime = Math.max(j14, j13 + j24);
        return j24;
    }

    public long writeTimeToWait(long j10, long j11, long j12, long j13) {
        bytesWriteFlowControl(j10);
        if (j10 == 0 || j11 == 0) {
            return 0L;
        }
        long j14 = this.lastTime.get();
        long j15 = this.currentWrittenBytes.get();
        long j16 = this.lastWrittenBytes;
        long j17 = this.writingTime;
        long jMax = Math.max(this.lastWritingTime - j14, 0L);
        long j18 = j13 - j14;
        if (j18 > 10) {
            long j19 = (((1000 * j15) / j11) - j18) + jMax;
            if (j19 <= 10) {
                this.writingTime = Math.max(j17, j13);
                return 0L;
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Time: " + j19 + e.f11184d + j15 + e.f11184d + j18 + e.f11184d + jMax);
            }
            if (j19 > j12 && (j13 + j19) - j17 > j12) {
                j19 = j12;
            }
            this.writingTime = Math.max(j17, j13 + j19);
            return j19;
        }
        long j20 = j15 + j16;
        long j21 = this.checkInterval.get() + j18;
        long j22 = (((1000 * j20) / j11) - j21) + jMax;
        if (j22 <= 10) {
            this.writingTime = Math.max(j17, j13);
            return 0L;
        }
        InternalLogger internalLogger2 = logger;
        if (internalLogger2.isDebugEnabled()) {
            internalLogger2.debug("Time: " + j22 + e.f11184d + j20 + e.f11184d + j21 + e.f11184d + jMax);
        }
        if (j22 > j12 && (j13 + j22) - j17 > j12) {
            j22 = j12;
        }
        this.writingTime = Math.max(j17, j13 + j22);
        return j22;
    }

    public TrafficCounter(AbstractTrafficShapingHandler abstractTrafficShapingHandler, ScheduledExecutorService scheduledExecutorService, String str, long j10) {
        this.currentWrittenBytes = new AtomicLong();
        this.currentReadBytes = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.lastTime = new AtomicLong();
        this.realWrittenBytes = new AtomicLong();
        this.checkInterval = new AtomicLong(1000L);
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.trafficShapingHandler = (AbstractTrafficShapingHandler) ObjectUtil.checkNotNullWithIAE(abstractTrafficShapingHandler, "trafficShapingHandler");
        this.executor = scheduledExecutorService;
        init(j10);
    }
}
