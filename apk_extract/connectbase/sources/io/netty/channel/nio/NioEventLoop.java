package io.netty.channel.nio;

import h.b;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import nq.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class NioEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long AWAKE = -1;
    private static final int CLEANUP_INTERVAL = 256;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final long NONE = Long.MAX_VALUE;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private boolean needsToSelectAgain;
    private final AtomicLong nextWakeupNanos;
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    private Selector selector;
    private Selector unwrappedSelector;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioEventLoop.class);
    private static final boolean DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);

    static {
        if (PlatformDependent.javaVersion() < 7 && SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.channel.nio.NioEventLoop.2
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e10) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e10);
            }
        }
        int i10 = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        int i11 = i10 >= 3 ? i10 : 0;
        SELECTOR_AUTO_REBUILD_THRESHOLD = i11;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEY_SET_OPTIMIZATION));
            internalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(i11));
        }
    }

    public NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory, EventLoopTaskQueueFactory eventLoopTaskQueueFactory2) {
        super(nioEventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory2), rejectedExecutionHandler);
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.nio.NioEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return NioEventLoop.this.selectNow();
            }
        };
        this.nextWakeupNanos = new AtomicLong(-1L);
        this.ioRatio = 50;
        this.provider = (SelectorProvider) ObjectUtil.checkNotNull(selectorProvider, "selectorProvider");
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "selectStrategy");
        SelectorTuple selectorTupleOpenSelector = openSelector();
        this.selector = selectorTupleOpenSelector.selector;
        this.unwrappedSelector = selectorTupleOpenSelector.unwrappedSelector;
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> setKeys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList(setKeys.size());
        for (SelectionKey selectionKey : setKeys) {
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) objAttachment);
            } else {
                selectionKey.cancel();
                invokeChannelUnregistered((NioTask) objAttachment, selectionKey, null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable th2) {
        logger.warn("Unexpected exception in the selector loop.", th2);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th2) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th2);
        } catch (Exception e10) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e10);
        }
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        return eventLoopTaskQueueFactory == null ? newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS) : eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private static Queue<Runnable> newTaskQueue0(int i10) {
        return i10 == Integer.MAX_VALUE ? PlatformDependent.newMpscQueue() : PlatformDependent.newMpscQueue(i10);
    }

    private SelectorTuple openSelector() {
        try {
            final AbstractSelector abstractSelectorOpenSelector = this.provider.openSelector();
            if (DISABLE_KEY_SET_OPTIMIZATION) {
                return new SelectorTuple(abstractSelectorOpenSelector);
            }
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (Throwable th2) {
                        return th2;
                    }
                }
            });
            if (objDoPrivileged instanceof Class) {
                final Class cls = (Class) objDoPrivileged;
                if (cls.isAssignableFrom(abstractSelectorOpenSelector.getClass())) {
                    final SelectedSelectionKeySet selectedSelectionKeySet = new SelectedSelectionKeySet();
                    Object objDoPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.4
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                Field declaredField = cls.getDeclaredField("selectedKeys");
                                Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
                                if (PlatformDependent.javaVersion() >= 9 && PlatformDependent.hasUnsafe()) {
                                    long jObjectFieldOffset = PlatformDependent.objectFieldOffset(declaredField);
                                    long jObjectFieldOffset2 = PlatformDependent.objectFieldOffset(declaredField2);
                                    if (jObjectFieldOffset != -1 && jObjectFieldOffset2 != -1) {
                                        PlatformDependent.putObject(abstractSelectorOpenSelector, jObjectFieldOffset, selectedSelectionKeySet);
                                        PlatformDependent.putObject(abstractSelectorOpenSelector, jObjectFieldOffset2, selectedSelectionKeySet);
                                        return null;
                                    }
                                }
                                Throwable thTrySetAccessible = ReflectionUtil.trySetAccessible(declaredField, true);
                                if (thTrySetAccessible != null) {
                                    return thTrySetAccessible;
                                }
                                Throwable thTrySetAccessible2 = ReflectionUtil.trySetAccessible(declaredField2, true);
                                if (thTrySetAccessible2 != null) {
                                    return thTrySetAccessible2;
                                }
                                declaredField.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
                                declaredField2.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
                                return null;
                            } catch (IllegalAccessException e10) {
                                e = e10;
                                return e;
                            } catch (NoSuchFieldException e11) {
                                e = e11;
                                return e;
                            }
                        }
                    });
                    if (!(objDoPrivileged2 instanceof Exception)) {
                        this.selectedKeys = selectedSelectionKeySet;
                        logger.trace("instrumented a special java.util.Set into: {}", abstractSelectorOpenSelector);
                        return new SelectorTuple(abstractSelectorOpenSelector, new SelectedSelectionKeySetSelector(abstractSelectorOpenSelector, selectedSelectionKeySet));
                    }
                    this.selectedKeys = null;
                    logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelectorOpenSelector, (Exception) objDoPrivileged2);
                    return new SelectorTuple(abstractSelectorOpenSelector);
                }
            }
            if (objDoPrivileged instanceof Throwable) {
                logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelectorOpenSelector, (Throwable) objDoPrivileged);
            }
            return new SelectorTuple(abstractSelectorOpenSelector);
        } catch (IOException e10) {
            throw new ChannelException("failed to open a new selector", e10);
        }
    }

    private void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe nioUnsafeUnsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            try {
                if (abstractNioChannel.eventLoop() == this) {
                    nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            int i10 = selectionKey.readyOps();
            if ((i10 & 8) != 0) {
                selectionKey.interestOps(selectionKey.interestOps() & (-9));
                nioUnsafeUnsafe.finishConnect();
            }
            if ((i10 & 4) != 0) {
                nioUnsafeUnsafe.forceFlush();
            }
            if ((i10 & 17) != 0 || i10 == 0) {
                nioUnsafeUnsafe.read();
            }
        } catch (CancelledKeyException unused2) {
            nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
        }
    }

    private void processSelectedKeys() {
        if (this.selectedKeys != null) {
            processSelectedKeysOptimized();
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    private void processSelectedKeysOptimized() {
        int i10 = 0;
        while (true) {
            SelectedSelectionKeySet selectedSelectionKeySet = this.selectedKeys;
            if (i10 >= selectedSelectionKeySet.size) {
                return;
            }
            SelectionKey[] selectionKeyArr = selectedSelectionKeySet.keys;
            SelectionKey selectionKey = selectionKeyArr[i10];
            selectionKeyArr[i10] = null;
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                processSelectedKey(selectionKey, (AbstractNioChannel) objAttachment);
            } else {
                processSelectedKey(selectionKey, (NioTask<SelectableChannel>) objAttachment);
            }
            if (this.needsToSelectAgain) {
                this.selectedKeys.reset(i10 + 1);
                selectAgain();
                i10 = -1;
            }
            i10++;
        }
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator<SelectionKey> it = set.iterator();
        while (true) {
            SelectionKey next = it.next();
            Object objAttachment = next.attachment();
            it.remove();
            if (objAttachment instanceof AbstractNioChannel) {
                processSelectedKey(next, (AbstractNioChannel) objAttachment);
            } else {
                processSelectedKey(next, (NioTask<SelectableChannel>) objAttachment);
            }
            if (!it.hasNext()) {
                return;
            }
            if (this.needsToSelectAgain) {
                selectAgain();
                Set<SelectionKey> setSelectedKeys = this.selector.selectedKeys();
                if (setSelectedKeys.isEmpty()) {
                    return;
                } else {
                    it = setSelectedKeys.iterator();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebuildSelector0() {
        Selector selector = this.selector;
        if (selector == null) {
            return;
        }
        try {
            SelectorTuple selectorTupleOpenSelector = openSelector();
            int i10 = 0;
            for (SelectionKey selectionKey : selector.keys()) {
                Object objAttachment = selectionKey.attachment();
                try {
                    if (selectionKey.isValid() && selectionKey.channel().keyFor(selectorTupleOpenSelector.unwrappedSelector) == null) {
                        int iInterestOps = selectionKey.interestOps();
                        selectionKey.cancel();
                        SelectionKey selectionKeyRegister = selectionKey.channel().register(selectorTupleOpenSelector.unwrappedSelector, iInterestOps, objAttachment);
                        if (objAttachment instanceof AbstractNioChannel) {
                            ((AbstractNioChannel) objAttachment).selectionKey = selectionKeyRegister;
                        }
                        i10++;
                    }
                } catch (Exception e10) {
                    logger.warn("Failed to re-register a Channel to the new Selector.", (Throwable) e10);
                    if (objAttachment instanceof AbstractNioChannel) {
                        AbstractNioChannel abstractNioChannel = (AbstractNioChannel) objAttachment;
                        abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
                    } else {
                        invokeChannelUnregistered((NioTask) objAttachment, selectionKey, e10);
                    }
                }
            }
            this.selector = selectorTupleOpenSelector.selector;
            this.unwrappedSelector = selectorTupleOpenSelector.unwrappedSelector;
            try {
                selector.close();
            } catch (Throwable th2) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close the old Selector.", th2);
                }
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isInfoEnabled()) {
                internalLogger.info("Migrated " + i10 + " channel(s) to the new Selector.");
            }
        } catch (Exception e11) {
            logger.warn("Failed to create a new Selector.", (Throwable) e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register0(SelectableChannel selectableChannel, int i10, NioTask<?> nioTask) {
        try {
            selectableChannel.register(this.unwrappedSelector, i10, nioTask);
        } catch (Exception e10) {
            throw new EventLoopException("failed to register a channel", e10);
        }
    }

    private int select(long j10) throws IOException {
        if (j10 == Long.MAX_VALUE) {
            return this.selector.select();
        }
        long jDeadlineToDelayNanos = AbstractScheduledEventExecutor.deadlineToDelayNanos(j10 + 995000) / v1.f11967e;
        Selector selector = this.selector;
        return jDeadlineToDelayNanos <= 0 ? selector.selectNow() : selector.select(jDeadlineToDelayNanos);
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th2) {
            logger.warn("Failed to update SelectionKeys.", th2);
        }
    }

    private boolean unexpectedSelectorWakeup(int i10) {
        if (Thread.interrupted()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
            }
            return true;
        }
        int i11 = SELECTOR_AUTO_REBUILD_THRESHOLD;
        if (i11 <= 0 || i10 < i11) {
            return false;
        }
        logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", Integer.valueOf(i10), this.selector);
        rebuildSelector();
        return true;
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public boolean afterScheduledTaskSubmitted(long j10) {
        return j10 < this.nextWakeupNanos.get();
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public boolean beforeScheduledTaskSubmitted(long j10) {
        return j10 < this.nextWakeupNanos.get();
    }

    public void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        int i10 = this.cancelledKeys + 1;
        this.cancelledKeys = i10;
        if (i10 >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e10) {
            logger.warn("Failed to close a selector.", (Throwable) e10);
        }
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public void rebuildSelector() {
        if (inEventLoop()) {
            rebuildSelector0();
        } else {
            execute(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.6
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.rebuildSelector0();
                }
            });
        }
    }

    public void register(final SelectableChannel selectableChannel, final int i10, final NioTask<?> nioTask) {
        ObjectUtil.checkNotNull(selectableChannel, "ch");
        if (i10 == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        }
        if (((~selectableChannel.validOps()) & i10) != 0) {
            StringBuilder sbA = b.a("invalid interestOps: ", i10, "(validOps: ");
            sbA.append(selectableChannel.validOps());
            sbA.append(')');
            throw new IllegalArgumentException(sbA.toString());
        }
        ObjectUtil.checkNotNull(nioTask, "task");
        if (isShutdown()) {
            throw new IllegalStateException("event loop shut down");
        }
        if (inEventLoop()) {
            register0(selectableChannel, i10, nioTask);
            return;
        }
        try {
            submit(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.5
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.register0(selectableChannel, i10, nioTask);
                }
            }).sync();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.selector.keys().size() - this.cancelledKeys;
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public Iterator<Channel> registeredChannelsIterator() {
        Set<SelectionKey> setKeys = this.selector.keys();
        return setKeys.isEmpty() ? SingleThreadEventLoop.ChannelsReadOnlyIterator.empty() : new Iterator<Channel>(setKeys) { // from class: io.netty.channel.nio.NioEventLoop.7
            boolean isDone;
            Channel next;
            final Iterator<SelectionKey> selectionKeyIterator;
            final /* synthetic */ Set val$keys;

            {
                this.val$keys = setKeys;
                this.selectionKeyIterator = ((Set) ObjectUtil.checkNotNull(setKeys, "selectionKeys")).iterator();
            }

            private Channel nextOrDone() {
                Iterator<SelectionKey> it = this.selectionKeyIterator;
                while (it.hasNext()) {
                    SelectionKey next = it.next();
                    if (next.isValid()) {
                        Object objAttachment = next.attachment();
                        if (objAttachment instanceof AbstractNioChannel) {
                            return (AbstractNioChannel) objAttachment;
                        }
                    }
                }
                this.isDone = true;
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.isDone) {
                    return false;
                }
                if (this.next != null) {
                    return true;
                }
                Channel channelNextOrDone = nextOrDone();
                this.next = channelNextOrDone;
                return channelNextOrDone != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Channel next() {
                if (this.isDone) {
                    throw new NoSuchElementException();
                }
                Channel channelNextOrDone = this.next;
                if (channelNextOrDone == null && (channelNextOrDone = nextOrDone()) == null) {
                    throw new NoSuchElementException();
                }
                this.next = nextOrDone();
                return channelNextOrDone;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:111:0x012a A[Catch: all -> 0x0134, Error -> 0x0136, TRY_LEAVE, TryCatch #17 {Error -> 0x0136, all -> 0x0134, blocks: (B:109:0x0124, B:111:0x012a), top: B:166:0x0124 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0143 A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #19 {all -> 0x0138, blocks: (B:108:0x0121, B:121:0x013b, B:123:0x0143, B:120:0x013a, B:4:0x0002, B:35:0x005a, B:50:0x0078, B:62:0x00b1, B:67:0x00bc, B:69:0x00c4, B:42:0x006b, B:43:0x006e, B:52:0x007f, B:54:0x0086, B:56:0x0097, B:57:0x00a5, B:58:0x00a6, B:23:0x0031, B:26:0x0040, B:33:0x0053, B:89:0x00f5, B:90:0x00fa, B:91:0x00fb, B:92:0x00fe), top: B:153:0x0121, inners: #22 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0161 A[Catch: all -> 0x016b, Error -> 0x016e, TRY_LEAVE, TryCatch #22 {Error -> 0x016e, all -> 0x016b, blocks: (B:124:0x015b, B:126:0x0161), top: B:158:0x015b }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x00df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x016a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0001 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0001 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x007f A[Catch: all -> 0x006f, Error -> 0x0072, CancelledKeyException -> 0x0075, TRY_LEAVE, TryCatch #22 {Error -> 0x0072, blocks: (B:4:0x0002, B:35:0x005a, B:50:0x0078, B:62:0x00b1, B:67:0x00bc, B:69:0x00c4, B:42:0x006b, B:43:0x006e, B:52:0x007f, B:54:0x0086, B:56:0x0097, B:57:0x00a5, B:58:0x00a6, B:23:0x0031, B:26:0x0040, B:33:0x0053, B:89:0x00f5, B:90:0x00fa, B:91:0x00fb, B:92:0x00fe), top: B:145:0x0002, outer: #19 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6 A[Catch: all -> 0x006f, Error -> 0x0072, CancelledKeyException -> 0x0075, TryCatch #22 {Error -> 0x0072, blocks: (B:4:0x0002, B:35:0x005a, B:50:0x0078, B:62:0x00b1, B:67:0x00bc, B:69:0x00c4, B:42:0x006b, B:43:0x006e, B:52:0x007f, B:54:0x0086, B:56:0x0097, B:57:0x00a5, B:58:0x00a6, B:23:0x0031, B:26:0x0040, B:33:0x0053, B:89:0x00f5, B:90:0x00fa, B:91:0x00fb, B:92:0x00fe), top: B:145:0x0002, outer: #19 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc A[Catch: all -> 0x006f, Error -> 0x0072, CancelledKeyException -> 0x0075, TryCatch #22 {Error -> 0x0072, blocks: (B:4:0x0002, B:35:0x005a, B:50:0x0078, B:62:0x00b1, B:67:0x00bc, B:69:0x00c4, B:42:0x006b, B:43:0x006e, B:52:0x007f, B:54:0x0086, B:56:0x0097, B:57:0x00a5, B:58:0x00a6, B:23:0x0031, B:26:0x0040, B:33:0x0053, B:89:0x00f5, B:90:0x00fa, B:91:0x00fb, B:92:0x00fe), top: B:145:0x0002, outer: #19 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4 A[Catch: all -> 0x006f, Error -> 0x0072, CancelledKeyException -> 0x0075, TRY_LEAVE, TryCatch #22 {Error -> 0x0072, blocks: (B:4:0x0002, B:35:0x005a, B:50:0x0078, B:62:0x00b1, B:67:0x00bc, B:69:0x00c4, B:42:0x006b, B:43:0x006e, B:52:0x007f, B:54:0x0086, B:56:0x0097, B:57:0x00a5, B:58:0x00a6, B:23:0x0031, B:26:0x0040, B:33:0x0053, B:89:0x00f5, B:90:0x00fa, B:91:0x00fb, B:92:0x00fe), top: B:145:0x0002, outer: #19 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d6 A[Catch: all -> 0x00e0, Error -> 0x00e2, TRY_LEAVE, TryCatch #23 {Error -> 0x00e2, all -> 0x00e0, blocks: (B:71:0x00d0, B:73:0x00d6), top: B:156:0x00d0 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:123:0x0143, please report this as an issue */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        int i10;
        Throwable th2;
        CancelledKeyException e10;
        InternalLogger internalLogger;
        int i11;
        boolean zRunAllTasks;
        long jNanoTime;
        InternalLogger internalLogger2;
        long jNextScheduledTaskDeadlineNanos;
        while (true) {
            int i12 = 0;
            while (true) {
                try {
                    try {
                        try {
                            int iCalculateStrategy = this.selectStrategy.calculateStrategy(this.selectNowSupplier, hasTasks());
                            try {
                                try {
                                    try {
                                        if (iCalculateStrategy != -3) {
                                            if (iCalculateStrategy != -2) {
                                                if (iCalculateStrategy == -1) {
                                                }
                                                i10 = i12 + 1;
                                                this.cancelledKeys = 0;
                                                this.needsToSelectAgain = false;
                                                i11 = this.ioRatio;
                                                if (i11 == 100) {
                                                    if (iCalculateStrategy > 0) {
                                                        try {
                                                            processSelectedKeys();
                                                        } catch (Throwable th3) {
                                                            runAllTasks();
                                                            throw th3;
                                                        }
                                                    }
                                                    zRunAllTasks = runAllTasks();
                                                } else if (iCalculateStrategy > 0) {
                                                    jNanoTime = System.nanoTime();
                                                    try {
                                                        processSelectedKeys();
                                                        zRunAllTasks = runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i11))) / ((long) i11));
                                                    } catch (Throwable th4) {
                                                        runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i11))) / ((long) i11));
                                                        throw th4;
                                                    }
                                                } else {
                                                    zRunAllTasks = runAllTasks(0L);
                                                }
                                                if (zRunAllTasks && iCalculateStrategy <= 0) {
                                                    if (unexpectedSelectorWakeup(i10)) {
                                                    }
                                                    if (isShuttingDown()) {
                                                        closeAll();
                                                        if (confirmShutdown()) {
                                                            return;
                                                        }
                                                    }
                                                    i12 = i10;
                                                } else if (i10 > 3) {
                                                    internalLogger2 = logger;
                                                    if (internalLogger2.isDebugEnabled()) {
                                                        internalLogger2.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", Integer.valueOf(i12), this.selector);
                                                    }
                                                }
                                                i10 = 0;
                                                if (isShuttingDown()) {
                                                    closeAll();
                                                    if (confirmShutdown()) {
                                                        return;
                                                    }
                                                }
                                                i12 = i10;
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
                                                } catch (Error e11) {
                                                    throw e11;
                                                } catch (Throwable th5) {
                                                    handleLoopException(th5);
                                                }
                                            }
                                        }
                                        if (isShuttingDown()) {
                                            closeAll();
                                            if (confirmShutdown()) {
                                                return;
                                            }
                                        }
                                    } catch (Error e12) {
                                        throw e12;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        handleLoopException(th);
                                    }
                                    this.cancelledKeys = 0;
                                    this.needsToSelectAgain = false;
                                    i11 = this.ioRatio;
                                    if (i11 == 100) {
                                        if (iCalculateStrategy > 0) {
                                            processSelectedKeys();
                                        }
                                        zRunAllTasks = runAllTasks();
                                    } else if (iCalculateStrategy > 0) {
                                        jNanoTime = System.nanoTime();
                                        processSelectedKeys();
                                        zRunAllTasks = runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i11))) / ((long) i11));
                                    } else {
                                        zRunAllTasks = runAllTasks(0L);
                                    }
                                    if (zRunAllTasks) {
                                        if (i10 > 3) {
                                            internalLogger2 = logger;
                                            if (internalLogger2.isDebugEnabled()) {
                                                internalLogger2.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", Integer.valueOf(i12), this.selector);
                                            }
                                        }
                                        i10 = 0;
                                    } else {
                                        if (i10 > 3) {
                                            internalLogger2 = logger;
                                            if (internalLogger2.isDebugEnabled()) {
                                                internalLogger2.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", Integer.valueOf(i12), this.selector);
                                            }
                                        }
                                        i10 = 0;
                                    }
                                } catch (CancelledKeyException e13) {
                                    e10 = e13;
                                    internalLogger = logger;
                                    if (internalLogger.isDebugEnabled()) {
                                        internalLogger.debug("CancelledKeyException raised by a Selector {} - JDK bug?", this.selector, e10);
                                    }
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
                                        th = th7;
                                        handleLoopException(th);
                                    }
                                } catch (Throwable th8) {
                                    th2 = th8;
                                    try {
                                        handleLoopException(th2);
                                        try {
                                            if (isShuttingDown()) {
                                                closeAll();
                                                if (confirmShutdown()) {
                                                    return;
                                                }
                                            }
                                        } catch (Error e15) {
                                            throw e15;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            handleLoopException(th);
                                        }
                                    } catch (Throwable th10) {
                                        try {
                                            if (isShuttingDown()) {
                                                closeAll();
                                                if (confirmShutdown()) {
                                                    return;
                                                }
                                            }
                                        } catch (Error e16) {
                                            throw e16;
                                        } catch (Throwable th11) {
                                            handleLoopException(th11);
                                        }
                                        throw th10;
                                    }
                                }
                                if (!hasTasks()) {
                                    iCalculateStrategy = select(jNextScheduledTaskDeadlineNanos);
                                }
                                this.nextWakeupNanos.lazySet(-1L);
                                i10 = i12 + 1;
                            } catch (Throwable th12) {
                                this.nextWakeupNanos.lazySet(-1L);
                                throw th12;
                            }
                            jNextScheduledTaskDeadlineNanos = nextScheduledTaskDeadlineNanos();
                            if (jNextScheduledTaskDeadlineNanos == -1) {
                                jNextScheduledTaskDeadlineNanos = Long.MAX_VALUE;
                            }
                            this.nextWakeupNanos.set(jNextScheduledTaskDeadlineNanos);
                        } catch (IOException e17) {
                            rebuildSelector0();
                            try {
                                handleLoopException(e17);
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (CancelledKeyException e18) {
                                e10 = e18;
                                i10 = 0;
                                internalLogger = logger;
                                if (internalLogger.isDebugEnabled()) {
                                    internalLogger.debug("CancelledKeyException raised by a Selector {} - JDK bug?", this.selector, e10);
                                }
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                }
                                i12 = i10;
                            } catch (Throwable th13) {
                                th2 = th13;
                                i10 = 0;
                                handleLoopException(th2);
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                }
                                i12 = i10;
                            }
                        }
                    } catch (Error e19) {
                        throw e19;
                    }
                } catch (CancelledKeyException e20) {
                    i10 = i12;
                    e10 = e20;
                } catch (Throwable th14) {
                    i10 = i12;
                    th2 = th14;
                }
                i12 = i10;
            }
            try {
                if (isShuttingDown()) {
                    closeAll();
                    if (confirmShutdown()) {
                        return;
                    }
                } else {
                    continue;
                }
            } catch (Error e21) {
                throw e21;
            } catch (Throwable th15) {
                handleLoopException(th15);
            }
        }
    }

    public int selectNow() throws IOException {
        return this.selector.selectNow();
    }

    public SelectorProvider selectorProvider() {
        return this.provider;
    }

    public void setIoRatio(int i10) {
        if (i10 <= 0 || i10 > 100) {
            throw new IllegalArgumentException(k.b.a("ioRatio: ", i10, " (expected: 0 < ioRatio <= 100)"));
        }
        this.ioRatio = i10;
    }

    public Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z10) {
        if (z10 || this.nextWakeupNanos.getAndSet(-1L) == -1) {
            return;
        }
        this.selector.wakeup();
    }

    public static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        public SelectorTuple(Selector selector) {
            this.unwrappedSelector = selector;
            this.selector = selector;
        }

        public SelectorTuple(Selector selector, Selector selector2) {
            this.unwrappedSelector = selector;
            this.selector = selector2;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i10) {
        return newTaskQueue0(i10);
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            try {
                nioTask.channelReady(selectionKey.channel(), selectionKey);
                if (!selectionKey.isValid()) {
                    invokeChannelUnregistered(nioTask, selectionKey, null);
                }
            } catch (Exception e10) {
                selectionKey.cancel();
                invokeChannelUnregistered(nioTask, selectionKey, e10);
            }
        } catch (Throwable th2) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, null);
            throw th2;
        }
    }
}
