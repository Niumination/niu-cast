package io.netty.channel;

import androidx.core.app.NotificationCompat;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class PendingWriteQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long bytes;
    private final EventExecutor executor;
    private PendingWrite head;
    private final ChannelOutboundInvoker invoker;
    private int size;
    private PendingWrite tail;
    private final PendingBytesTracker tracker;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PendingWriteQueue.class);
    private static final int PENDING_WRITE_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.pendingWriteSizeOverhead", 64);

    public static final class PendingWrite {
        private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PendingWrite>() { // from class: io.netty.channel.PendingWriteQueue.PendingWrite.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public PendingWrite newObject(ObjectPool.Handle<PendingWrite> handle) {
                return new PendingWrite(handle);
            }
        });
        private final ObjectPool.Handle<PendingWrite> handle;
        private Object msg;
        private PendingWrite next;
        private ChannelPromise promise;
        private long size;

        public static PendingWrite newInstance(Object obj, int i10, ChannelPromise channelPromise) {
            PendingWrite pendingWrite = RECYCLER.get();
            pendingWrite.size = i10;
            pendingWrite.msg = obj;
            pendingWrite.promise = channelPromise;
            return pendingWrite;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle() {
            this.size = 0L;
            this.next = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        private PendingWrite(ObjectPool.Handle<PendingWrite> handle) {
            this.handle = handle;
        }
    }

    public PendingWriteQueue(ChannelHandlerContext channelHandlerContext) {
        this.tracker = PendingBytesTracker.newTracker(channelHandlerContext.channel());
        this.invoker = channelHandlerContext;
        this.executor = channelHandlerContext.executor();
    }

    private void assertEmpty() {
    }

    private void recycle(PendingWrite pendingWrite, boolean z10) {
        PendingWrite pendingWrite2 = pendingWrite.next;
        long j10 = pendingWrite.size;
        if (z10) {
            if (pendingWrite2 == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
            } else {
                this.head = pendingWrite2;
                this.size--;
                this.bytes -= j10;
            }
        }
        pendingWrite.recycle();
        this.tracker.decrementPendingOutboundBytes(j10);
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th2) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th2)) {
            return;
        }
        logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th2);
    }

    public void add(Object obj, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_MESSAGE);
        ObjectUtil.checkNotNull(channelPromise, "promise");
        int size = size(obj);
        PendingWrite pendingWriteNewInstance = PendingWrite.newInstance(obj, size, channelPromise);
        PendingWrite pendingWrite = this.tail;
        if (pendingWrite == null) {
            this.head = pendingWriteNewInstance;
            this.tail = pendingWriteNewInstance;
        } else {
            pendingWrite.next = pendingWriteNewInstance;
            this.tail = pendingWriteNewInstance;
        }
        this.size++;
        this.bytes += (long) size;
        this.tracker.incrementPendingOutboundBytes(pendingWriteNewInstance.size);
    }

    public long bytes() {
        return this.bytes;
    }

    public Object current() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        return pendingWrite.msg;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public ChannelPromise remove() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        ChannelPromise channelPromise = pendingWrite.promise;
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        recycle(pendingWrite, true);
        return channelPromise;
    }

    public void removeAndFail(Throwable th2) {
        ObjectUtil.checkNotNull(th2, "cause");
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return;
        }
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        safeFail(pendingWrite.promise, th2);
        recycle(pendingWrite, true);
    }

    public void removeAndFailAll(Throwable th2) {
        ObjectUtil.checkNotNull(th2, "cause");
        while (true) {
            PendingWrite pendingWrite = this.head;
            if (pendingWrite == null) {
                assertEmpty();
                return;
            }
            this.tail = null;
            this.head = null;
            this.size = 0;
            this.bytes = 0L;
            while (pendingWrite != null) {
                PendingWrite pendingWrite2 = pendingWrite.next;
                ReferenceCountUtil.safeRelease(pendingWrite.msg);
                ChannelPromise channelPromise = pendingWrite.promise;
                recycle(pendingWrite, false);
                safeFail(channelPromise, th2);
                pendingWrite = pendingWrite2;
            }
        }
    }

    public ChannelFuture removeAndWrite() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        Object obj = pendingWrite.msg;
        ChannelPromise channelPromise = pendingWrite.promise;
        recycle(pendingWrite, true);
        return this.invoker.write(obj, channelPromise);
    }

    public ChannelFuture removeAndWriteAll() {
        if (isEmpty()) {
            return null;
        }
        ChannelPromise channelPromiseNewPromise = this.invoker.newPromise();
        PromiseCombiner promiseCombiner = new PromiseCombiner(this.executor);
        while (true) {
            try {
                PendingWrite pendingWrite = this.head;
                if (pendingWrite == null) {
                    break;
                }
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
                while (pendingWrite != null) {
                    PendingWrite pendingWrite2 = pendingWrite.next;
                    Object obj = pendingWrite.msg;
                    ChannelPromise channelPromise = pendingWrite.promise;
                    recycle(pendingWrite, false);
                    if (!(channelPromise instanceof VoidChannelPromise)) {
                        promiseCombiner.add((Promise) channelPromise);
                    }
                    this.invoker.write(obj, channelPromise);
                    pendingWrite = pendingWrite2;
                }
            } catch (Throwable th2) {
                channelPromiseNewPromise.setFailure(th2);
            }
        }
        promiseCombiner.finish(channelPromiseNewPromise);
        assertEmpty();
        return channelPromiseNewPromise;
    }

    public int size() {
        return this.size;
    }

    private int size(Object obj) {
        int size = this.tracker.size(obj);
        if (size < 0) {
            size = 0;
        }
        return size + PENDING_WRITE_OVERHEAD;
    }

    public PendingWriteQueue(Channel channel) {
        this.tracker = PendingBytesTracker.newTracker(channel);
        this.invoker = channel;
        this.executor = channel.eventLoop();
    }
}
