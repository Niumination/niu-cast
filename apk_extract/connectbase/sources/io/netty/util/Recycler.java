package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import os.t;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Recycler<T> {
    private static final boolean BATCH_FAST_TL_ONLY;
    private static final boolean BLOCKING_POOL;
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final int DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD;
    private static final EnhancedHandle<?> NOOP_HANDLE;
    private static final int RATIO;
    private static final InternalLogger logger;
    private final int chunkSize;
    private final int interval;
    private final int maxCapacityPerThread;
    private final FastThreadLocal<LocalPool<T>> threadLocal;

    public static final class BlockingMessageQueue<T> implements MessagePassingQueue<T> {
        private final Queue<T> deque = new ArrayDeque();
        private final int maxCapacity;

        public BlockingMessageQueue(int i10) {
            this.maxCapacity = i10;
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int capacity() {
            return this.maxCapacity;
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized void clear() {
            this.deque.clear();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int drain(MessagePassingQueue.Consumer<T> consumer, int i10) {
            int i11 = 0;
            while (i11 < i10) {
                T tPoll = poll();
                if (tPoll == null) {
                    break;
                }
                consumer.accept(tPoll);
                i11++;
            }
            return i11;
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int fill(MessagePassingQueue.Supplier<T> supplier, int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized boolean isEmpty() {
            return this.deque.isEmpty();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized boolean offer(T t10) {
            if (this.deque.size() == this.maxCapacity) {
                return false;
            }
            return this.deque.offer(t10);
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized T peek() {
            return this.deque.peek();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized T poll() {
            return this.deque.poll();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public boolean relaxedOffer(T t10) {
            return offer(t10);
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public T relaxedPeek() {
            return peek();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public T relaxedPoll() {
            return poll();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized int size() {
            return this.deque.size();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int fill(MessagePassingQueue.Supplier<T> supplier) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int drain(MessagePassingQueue.Consumer<T> consumer) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public void fill(MessagePassingQueue.Supplier<T> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public void drain(MessagePassingQueue.Consumer<T> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class DefaultHandle<T> extends EnhancedHandle<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int STATE_AVAILABLE = 1;
        private static final int STATE_CLAIMED = 0;
        private static final AtomicIntegerFieldUpdater<DefaultHandle<?>> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultHandle.class, "state");
        private final LocalPool<T> localPool;
        private volatile int state;
        private T value;

        public DefaultHandle(LocalPool<T> localPool) {
            super();
            this.localPool = localPool;
        }

        public T get() {
            return this.value;
        }

        @Override // io.netty.util.internal.ObjectPool.Handle
        public void recycle(Object obj) {
            if (obj != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.localPool.release(this, true);
        }

        public void set(T t10) {
            this.value = t10;
        }

        public void toAvailable() {
            if (STATE_UPDATER.getAndSet(this, 1) == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
        }

        public void toClaimed() {
            STATE_UPDATER.lazySet(this, 0);
        }

        @Override // io.netty.util.Recycler.EnhancedHandle
        public void unguardedRecycle(Object obj) {
            if (obj != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.localPool.release(this, false);
        }

        public void unguardedToAvailable() {
            if (this.state == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
            STATE_UPDATER.lazySet(this, 1);
        }
    }

    public static abstract class EnhancedHandle<T> implements Handle<T> {
        public abstract void unguardedRecycle(Object obj);

        private EnhancedHandle() {
        }
    }

    public interface Handle<T> extends ObjectPool.Handle<T> {
    }

    public static final class LocalPool<T> implements MessagePassingQueue.Consumer<DefaultHandle<T>> {
        private final ArrayDeque<DefaultHandle<T>> batch;
        private final int chunkSize;
        private volatile Thread owner;
        private volatile MessagePassingQueue<DefaultHandle<T>> pooledHandles;
        private int ratioCounter;
        private final int ratioInterval;

        public LocalPool(int i10, int i11, int i12) {
            this.ratioInterval = i11;
            this.chunkSize = i12;
            this.batch = new ArrayDeque<>(i12);
            Thread threadCurrentThread = Thread.currentThread();
            if (Recycler.BATCH_FAST_TL_ONLY && !(threadCurrentThread instanceof FastThreadLocalThread)) {
                threadCurrentThread = null;
            }
            this.owner = threadCurrentThread;
            if (Recycler.BLOCKING_POOL) {
                this.pooledHandles = new BlockingMessageQueue(i10);
            } else {
                this.pooledHandles = (MessagePassingQueue) PlatformDependent.newMpscQueue(i12, i10);
            }
            this.ratioCounter = i11;
        }

        private static boolean isTerminated(Thread thread) {
            if (PlatformDependent.isJ9Jvm()) {
                if (thread.isAlive()) {
                    return false;
                }
            } else if (thread.getState() != Thread.State.TERMINATED) {
                return false;
            }
            return true;
        }

        public DefaultHandle<T> claim() {
            MessagePassingQueue<DefaultHandle<T>> messagePassingQueue = this.pooledHandles;
            if (messagePassingQueue == null) {
                return null;
            }
            if (this.batch.isEmpty()) {
                messagePassingQueue.drain(this, this.chunkSize);
            }
            DefaultHandle<T> defaultHandlePollFirst = this.batch.pollFirst();
            if (defaultHandlePollFirst != null) {
                defaultHandlePollFirst.toClaimed();
            }
            return defaultHandlePollFirst;
        }

        public DefaultHandle<T> newHandle() {
            int i10 = this.ratioCounter + 1;
            this.ratioCounter = i10;
            if (i10 < this.ratioInterval) {
                return null;
            }
            this.ratioCounter = 0;
            return new DefaultHandle<>(this);
        }

        public void release(DefaultHandle<T> defaultHandle, boolean z10) {
            if (z10) {
                defaultHandle.toAvailable();
            } else {
                defaultHandle.unguardedToAvailable();
            }
            Thread thread = this.owner;
            if (thread != null && Thread.currentThread() == thread && this.batch.size() < this.chunkSize) {
                accept((DefaultHandle) defaultHandle);
                return;
            }
            if (thread != null && isTerminated(thread)) {
                this.owner = null;
                this.pooledHandles = null;
            } else {
                MessagePassingQueue<DefaultHandle<T>> messagePassingQueue = this.pooledHandles;
                if (messagePassingQueue != null) {
                    messagePassingQueue.relaxedOffer(defaultHandle);
                }
            }
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer
        public void accept(DefaultHandle<T> defaultHandle) {
            this.batch.addLast(defaultHandle);
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) Recycler.class);
        logger = internalLoggerFactory;
        NOOP_HANDLE = new EnhancedHandle<Object>() { // from class: io.netty.util.Recycler.1
            @Override // io.netty.util.internal.ObjectPool.Handle
            public void recycle(Object obj) {
            }

            public String toString() {
                return "NOOP_HANDLE";
            }

            @Override // io.netty.util.Recycler.EnhancedHandle
            public void unguardedRecycle(Object obj) {
            }
        };
        int i10 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        int i11 = i10 >= 0 ? i10 : 4096;
        DEFAULT_MAX_CAPACITY_PER_THREAD = i11;
        int i12 = SystemPropertyUtil.getInt("io.netty.recycler.chunkSize", 32);
        DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD = i12;
        int iMax = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = iMax;
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.recycler.blocking", false);
        BLOCKING_POOL = z10;
        boolean z11 = SystemPropertyUtil.getBoolean("io.netty.recycler.batchFastThreadLocalOnly", true);
        BATCH_FAST_TL_ONLY = z11;
        if (internalLoggerFactory.isDebugEnabled()) {
            if (i11 == 0) {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.chunkSize: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.blocking: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.batchFastThreadLocalOnly: disabled");
                return;
            }
            internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i11));
            internalLoggerFactory.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(iMax));
            internalLoggerFactory.debug("-Dio.netty.recycler.chunkSize: {}", Integer.valueOf(i12));
            internalLoggerFactory.debug("-Dio.netty.recycler.blocking: {}", Boolean.valueOf(z10));
            internalLoggerFactory.debug("-Dio.netty.recycler.batchFastThreadLocalOnly: {}", Boolean.valueOf(z11));
        }
    }

    public Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    public final T get() {
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        LocalPool<T> localPool = this.threadLocal.get();
        DefaultHandle<T> defaultHandleClaim = localPool.claim();
        if (defaultHandleClaim != null) {
            return defaultHandleClaim.get();
        }
        DefaultHandle<T> defaultHandleNewHandle = localPool.newHandle();
        if (defaultHandleNewHandle == null) {
            return newObject(NOOP_HANDLE);
        }
        T tNewObject = newObject(defaultHandleNewHandle);
        defaultHandleNewHandle.set(tNewObject);
        return tNewObject;
    }

    public abstract T newObject(Handle<T> handle);

    @Deprecated
    public final boolean recycle(T t10, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        handle.recycle(t10);
        return true;
    }

    @t
    public final int threadLocalSize() {
        LocalPool<T> ifExists = this.threadLocal.getIfExists();
        if (ifExists == null) {
            return 0;
        }
        return ((LocalPool) ifExists).batch.size() + ((LocalPool) ifExists).pooledHandles.size();
    }

    public Recycler(int i10) {
        this(i10, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int i10, int i11) {
        this(i10, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int i10, int i11, int i12, int i13) {
        this(i10, i12, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int i10, int i11, int i12, int i13, int i14) {
        this(i10, i12, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    public Recycler(int i10, int i11, int i12) {
        this.threadLocal = new FastThreadLocal<LocalPool<T>>() { // from class: io.netty.util.Recycler.2
            @Override // io.netty.util.concurrent.FastThreadLocal
            public LocalPool<T> initialValue() {
                return new LocalPool<>(Recycler.this.maxCapacityPerThread, Recycler.this.interval, Recycler.this.chunkSize);
            }

            @Override // io.netty.util.concurrent.FastThreadLocal
            public void onRemoval(LocalPool<T> localPool) throws Exception {
                super.onRemoval(localPool);
                MessagePassingQueue messagePassingQueue = ((LocalPool) localPool).pooledHandles;
                ((LocalPool) localPool).pooledHandles = null;
                ((LocalPool) localPool).owner = null;
                messagePassingQueue.clear();
            }
        };
        this.interval = Math.max(0, i11);
        if (i10 <= 0) {
            this.maxCapacityPerThread = 0;
            this.chunkSize = 0;
        } else {
            int iMax = Math.max(4, i10);
            this.maxCapacityPerThread = iMax;
            this.chunkSize = Math.max(2, Math.min(i12, iMax >> 1));
        }
    }
}
