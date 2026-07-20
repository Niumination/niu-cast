package io.netty.channel.kqueue;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import k.b;

/* JADX INFO: loaded from: classes2.dex */
final class KQueueEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int KQUEUE_WAKE_UP_IDENT = 0;
    private final boolean allowGrowing;
    private final KQueueEventArray changeList;
    private final IntObjectMap<AbstractKQueueChannel> channels;
    private final KQueueEventArray eventList;
    private volatile int ioRatio;
    private final IovArray iovArray;
    private final FileDescriptor kqueueFd;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private volatile int wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) KQueueEventLoop.class);
    private static final AtomicIntegerFieldUpdater<KQueueEventLoop> WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(KQueueEventLoop.class, "wakenUp");

    static {
        KQueue.ensureAvailability();
    }

    public KQueueEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i10, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory, EventLoopTaskQueueFactory eventLoopTaskQueueFactory2) {
        super(eventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory2), rejectedExecutionHandler);
        this.iovArray = new IovArray();
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.kqueue.KQueueEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return KQueueEventLoop.this.kqueueWaitNow();
            }
        };
        this.channels = new IntObjectHashMap(4096);
        this.ioRatio = 50;
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        FileDescriptor fileDescriptorNewKQueue = Native.newKQueue();
        this.kqueueFd = fileDescriptorNewKQueue;
        if (i10 == 0) {
            this.allowGrowing = true;
            i10 = 4096;
        } else {
            this.allowGrowing = false;
        }
        this.changeList = new KQueueEventArray(i10);
        this.eventList = new KQueueEventArray(i10);
        int iKeventAddUserEvent = Native.keventAddUserEvent(fileDescriptorNewKQueue.intValue(), 0);
        if (iKeventAddUserEvent >= 0) {
            return;
        }
        cleanup();
        throw new IllegalStateException("kevent failed to add user event with errno: " + (-iKeventAddUserEvent));
    }

    private void closeAll() {
        try {
            kqueueWaitNow();
        } catch (IOException unused) {
        }
        for (AbstractKQueueChannel abstractKQueueChannel : (AbstractKQueueChannel[]) this.channels.values().toArray(new AbstractKQueueChannel[0])) {
            abstractKQueueChannel.unsafe().close(abstractKQueueChannel.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable th2) {
        logger.warn("Unexpected exception in the selector loop.", th2);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private int kqueueWait(boolean z10) throws IOException {
        if (z10 && hasTasks()) {
            return kqueueWaitNow();
        }
        long jDelayNanos = delayNanos(System.nanoTime());
        int iMin = (int) Math.min(jDelayNanos / 1000000000, 2147483647L);
        return kqueueWait(iMin, (int) Math.min(jDelayNanos - (((long) iMin) * 1000000000), 2147483647L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kqueueWaitNow() throws IOException {
        return kqueueWait(0, 0);
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        return eventLoopTaskQueueFactory == null ? newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS) : eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private static Queue<Runnable> newTaskQueue0(int i10) {
        return i10 == Integer.MAX_VALUE ? PlatformDependent.newMpscQueue() : PlatformDependent.newMpscQueue(i10);
    }

    private void processReady(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            short sFilter = this.eventList.filter(i11);
            short sFlags = this.eventList.flags(i11);
            int iFd = this.eventList.fd(i11);
            if (sFilter != Native.EVFILT_USER && (Native.EV_ERROR & sFlags) == 0) {
                AbstractKQueueChannel abstractKQueueChannel = this.channels.get(iFd);
                if (abstractKQueueChannel == null) {
                    logger.warn("events[{}]=[{}, {}] had no channel!", Integer.valueOf(i11), Integer.valueOf(this.eventList.fd(i11)), Short.valueOf(sFilter));
                } else {
                    AbstractKQueueChannel.AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueChannel.AbstractKQueueUnsafe) abstractKQueueChannel.unsafe();
                    if (sFilter == Native.EVFILT_WRITE) {
                        abstractKQueueUnsafe.writeReady();
                    } else if (sFilter == Native.EVFILT_READ) {
                        abstractKQueueUnsafe.readReady(this.eventList.data(i11));
                    } else if (sFilter == Native.EVFILT_SOCK && (this.eventList.fflags(i11) & Native.NOTE_RDHUP) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                    if ((Native.EV_EOF & sFlags) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                }
            }
        }
    }

    public void add(AbstractKQueueChannel abstractKQueueChannel) {
        this.channels.put(abstractKQueueChannel.fd().intValue(), abstractKQueueChannel);
    }

    public IovArray cleanArray() {
        this.iovArray.clear();
        return this.iovArray;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void cleanup() {
        try {
            try {
                this.kqueueFd.close();
            } catch (IOException e10) {
                logger.warn("Failed to close the kqueue fd.", (Throwable) e10);
            }
        } finally {
            this.changeList.free();
            this.eventList.free();
        }
    }

    public void evSet(AbstractKQueueChannel abstractKQueueChannel, short s10, short s11, int i10) {
        this.changeList.evSet(abstractKQueueChannel, s10, s11, i10);
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.channels.size();
    }

    public void remove(AbstractKQueueChannel abstractKQueueChannel) throws Exception {
        int iIntValue = abstractKQueueChannel.fd().intValue();
        AbstractKQueueChannel abstractKQueueChannelRemove = this.channels.remove(iIntValue);
        if (abstractKQueueChannelRemove != null && abstractKQueueChannelRemove != abstractKQueueChannel) {
            this.channels.put(iIntValue, abstractKQueueChannelRemove);
        } else if (abstractKQueueChannel.isOpen()) {
            abstractKQueueChannel.unregisterFilters();
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0000 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0000 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0063 A[Catch: all -> 0x0049, Error -> 0x004b, TRY_LEAVE, TryCatch #5 {Error -> 0x004b, blocks: (B:2:0x0000, B:32:0x004e, B:41:0x005f, B:50:0x008b, B:52:0x008f, B:54:0x0097, B:39:0x005b, B:40:0x005e, B:42:0x0063, B:49:0x007d, B:47:0x006e, B:48:0x007c, B:21:0x0031, B:25:0x003d, B:27:0x0045), top: B:92:0x0000, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        int i10;
        while (true) {
            try {
                try {
                    int iCalculateStrategy = this.selectStrategy.calculateStrategy(this.selectNowSupplier, hasTasks());
                    try {
                        try {
                            if (iCalculateStrategy != -3) {
                                if (iCalculateStrategy != -2) {
                                    if (iCalculateStrategy == -1) {
                                    }
                                    i10 = this.ioRatio;
                                    if (i10 == 100) {
                                        if (iCalculateStrategy > 0) {
                                            try {
                                                processReady(iCalculateStrategy);
                                            } catch (Throwable th2) {
                                                runAllTasks();
                                                throw th2;
                                            }
                                        }
                                        runAllTasks();
                                    } else {
                                        long jNanoTime = System.nanoTime();
                                        if (iCalculateStrategy > 0) {
                                            try {
                                                processReady(iCalculateStrategy);
                                            } catch (Throwable th3) {
                                                runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i10))) / ((long) i10));
                                                throw th3;
                                            }
                                        }
                                        runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i10))) / ((long) i10));
                                    }
                                    if (this.allowGrowing && iCalculateStrategy == this.eventList.capacity()) {
                                        this.eventList.realloc(false);
                                    }
                                    if (isShuttingDown()) {
                                        closeAll();
                                        if (confirmShutdown()) {
                                            return;
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    try {
                                        if (isShuttingDown()) {
                                            closeAll();
                                            if (confirmShutdown()) {
                                                return;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } catch (Error e10) {
                                        throw e10;
                                    }
                                }
                            }
                            if (isShuttingDown()) {
                                closeAll();
                                if (confirmShutdown()) {
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } catch (Error e11) {
                            throw e11;
                        }
                    } catch (Throwable th4) {
                        handleLoopException(th4);
                    }
                    iCalculateStrategy = kqueueWait(WAKEN_UP_UPDATER.getAndSet(this, 0) == 1);
                    if (this.wakenUp == 1) {
                        wakeup();
                    }
                    i10 = this.ioRatio;
                    if (i10 == 100) {
                        if (iCalculateStrategy > 0) {
                            processReady(iCalculateStrategy);
                        }
                        runAllTasks();
                    } else {
                        long jNanoTime2 = System.nanoTime();
                        if (iCalculateStrategy > 0) {
                            processReady(iCalculateStrategy);
                        }
                        runAllTasks(((System.nanoTime() - jNanoTime2) * ((long) (100 - i10))) / ((long) i10));
                    }
                    if (this.allowGrowing) {
                        this.eventList.realloc(false);
                    }
                } catch (Error e12) {
                    throw e12;
                }
            } catch (Throwable th5) {
                try {
                    handleLoopException(th5);
                    try {
                        if (isShuttingDown()) {
                            closeAll();
                            if (confirmShutdown()) {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } catch (Error e13) {
                        throw e13;
                    }
                } catch (Throwable th6) {
                    try {
                        if (isShuttingDown()) {
                            closeAll();
                            if (confirmShutdown()) {
                                return;
                            }
                        }
                    } catch (Error e14) {
                        throw e14;
                    } catch (Throwable th7) {
                        handleLoopException(th7);
                    }
                    throw th6;
                }
            }
        }
    }

    public void setIoRatio(int i10) {
        if (i10 <= 0 || i10 > 100) {
            throw new IllegalArgumentException(b.a("ioRatio: ", i10, " (expected: 0 < ioRatio <= 100)"));
        }
        this.ioRatio = i10;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z10) {
        if (z10 || !WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
            return;
        }
        wakeup();
    }

    private void wakeup() {
        Native.keventTriggerUserEvent(this.kqueueFd.intValue(), 0);
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i10) {
        return newTaskQueue0(i10);
    }

    private int kqueueWait(int i10, int i11) throws IOException {
        int iKeventWait = Native.keventWait(this.kqueueFd.intValue(), this.changeList, this.eventList, i10, i11);
        this.changeList.clear();
        return iKeventWait;
    }
}
