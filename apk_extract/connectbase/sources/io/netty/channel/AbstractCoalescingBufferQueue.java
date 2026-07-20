package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractCoalescingBufferQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractCoalescingBufferQueue.class);
    private final ArrayDeque<Object> bufAndListenerPairs;
    private int readableBytes;
    private final PendingBytesTracker tracker;

    public AbstractCoalescingBufferQueue(Channel channel, int i10) {
        this.bufAndListenerPairs = new ArrayDeque<>(i10);
        this.tracker = channel == null ? null : PendingBytesTracker.newTracker(channel);
    }

    private void decrementReadableBytes(int i10) {
        this.readableBytes -= i10;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.decrementPendingOutboundBytes(i10);
        }
    }

    private void incrementReadableBytes(int i10) {
        int i11 = this.readableBytes;
        int i12 = i11 + i10;
        if (i12 < i11) {
            throw new IllegalStateException("buffer queue length overflow: " + this.readableBytes + " + " + i10);
        }
        this.readableBytes = i12;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.incrementPendingOutboundBytes(i10);
        }
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture) {
        Throwable th2 = null;
        while (true) {
            Object objPoll = this.bufAndListenerPairs.poll();
            if (objPoll == null) {
                break;
            }
            try {
                if (objPoll instanceof ByteBuf) {
                    ByteBuf byteBuf = (ByteBuf) objPoll;
                    decrementReadableBytes(byteBuf.readableBytes());
                    ReferenceCountUtil.safeRelease(byteBuf);
                } else {
                    ((ChannelFutureListener) objPoll).operationComplete(channelFuture);
                }
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    logger.info("Throwable being suppressed because Throwable {} is already pending", th2, th3);
                }
            }
        }
        if (th2 != null) {
            throw new IllegalStateException(th2);
        }
    }

    private static ChannelFutureListener toChannelFutureListener(ChannelPromise channelPromise) {
        if (channelPromise.isVoid()) {
            return null;
        }
        return new DelegatingChannelPromiseNotifier(channelPromise);
    }

    public final void add(ByteBuf byteBuf) {
        add(byteBuf, (ChannelFutureListener) null);
    }

    public final void addFirst(ByteBuf byteBuf, ChannelPromise channelPromise) {
        addFirst(byteBuf, toChannelFutureListener(channelPromise));
    }

    public abstract ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);

    public ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        return byteBuf;
    }

    public final ByteBuf composeIntoComposite(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        CompositeByteBuf compositeByteBufCompositeBuffer = byteBufAllocator.compositeBuffer(size() + 2);
        try {
            compositeByteBufCompositeBuffer.addComponent(true, byteBuf);
            compositeByteBufCompositeBuffer.addComponent(true, byteBuf2);
        } catch (Throwable th2) {
            compositeByteBufCompositeBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th2);
        }
        return compositeByteBufCompositeBuffer;
    }

    public final ByteBuf copyAndCompose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        ByteBuf byteBufIoBuffer = byteBufAllocator.ioBuffer(byteBuf2.readableBytes() + byteBuf.readableBytes());
        try {
            byteBufIoBuffer.writeBytes(byteBuf).writeBytes(byteBuf2);
        } catch (Throwable th2) {
            byteBufIoBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th2);
        }
        byteBuf.release();
        byteBuf2.release();
        return byteBufIoBuffer;
    }

    public final void copyTo(AbstractCoalescingBufferQueue abstractCoalescingBufferQueue) {
        abstractCoalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        abstractCoalescingBufferQueue.incrementReadableBytes(this.readableBytes);
    }

    public final boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public final int readableBytes() {
        return this.readableBytes;
    }

    public final void releaseAndFailAll(ChannelOutboundInvoker channelOutboundInvoker, Throwable th2) {
        releaseAndCompleteAll(channelOutboundInvoker.newFailedFuture(th2));
    }

    public final ByteBuf remove(ByteBufAllocator byteBufAllocator, int i10, ChannelPromise channelPromise) throws Throwable {
        ObjectUtil.checkPositiveOrZero(i10, "bytes");
        ObjectUtil.checkNotNull(channelPromise, "aggregatePromise");
        if (this.bufAndListenerPairs.isEmpty()) {
            return removeEmptyValue();
        }
        int iMin = Math.min(i10, this.readableBytes);
        ByteBuf retainedSlice = null;
        int i11 = iMin;
        ByteBuf byteBufCompose = null;
        while (true) {
            try {
                Object objPoll = this.bufAndListenerPairs.poll();
                if (objPoll == null) {
                    break;
                }
                if (objPoll instanceof ChannelFutureListener) {
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) objPoll);
                } else {
                    ByteBuf byteBufComposeFirst = (ByteBuf) objPoll;
                    try {
                        int i12 = byteBufComposeFirst.readableBytes();
                        if (i12 > i11) {
                            this.bufAndListenerPairs.addFirst(byteBufComposeFirst);
                            if (i11 <= 0) {
                                break;
                            }
                            retainedSlice = byteBufComposeFirst.readRetainedSlice(i11);
                            byteBufCompose = byteBufCompose == null ? retainedSlice : compose(byteBufAllocator, byteBufCompose, retainedSlice);
                            i11 = 0;
                            break;
                        }
                        i11 -= i12;
                        if (byteBufCompose == null) {
                            if (i12 != this.readableBytes) {
                                byteBufComposeFirst = composeFirst(byteBufAllocator, byteBufComposeFirst);
                            }
                            byteBufCompose = byteBufComposeFirst;
                        } else {
                            byteBufCompose = compose(byteBufAllocator, byteBufCompose, byteBufComposeFirst);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        retainedSlice = byteBufComposeFirst;
                        ReferenceCountUtil.safeRelease(retainedSlice);
                        ReferenceCountUtil.safeRelease(byteBufCompose);
                        channelPromise.setFailure(th);
                        PlatformDependent.throwException(th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        decrementReadableBytes(iMin - i11);
        return byteBufCompose;
    }

    public abstract ByteBuf removeEmptyValue();

    public final ByteBuf removeFirst(ChannelPromise channelPromise) {
        Object objPoll = this.bufAndListenerPairs.poll();
        if (objPoll == null) {
            return null;
        }
        ByteBuf byteBuf = (ByteBuf) objPoll;
        decrementReadableBytes(byteBuf.readableBytes());
        Object objPeek = this.bufAndListenerPairs.peek();
        if (objPeek instanceof ChannelFutureListener) {
            channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) objPeek);
            this.bufAndListenerPairs.poll();
        }
        return byteBuf;
    }

    public final int size() {
        return this.bufAndListenerPairs.size();
    }

    public String toString() {
        return "bytes: " + this.readableBytes + " buffers: " + (size() >> 1);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0064 A[SYNTHETIC] */
    public final void writeAndRemoveAll(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = null;
        Throwable th2 = null;
        while (true) {
            Object objPoll = this.bufAndListenerPairs.poll();
            if (objPoll == null) {
                if (byteBuf == null) {
                    break;
                }
                decrementReadableBytes(byteBuf.readableBytes());
                channelHandlerContext.write(byteBuf, channelHandlerContext.voidPromise());
                break;
            }
            try {
                if (objPoll instanceof ByteBuf) {
                    if (byteBuf != null) {
                        decrementReadableBytes(byteBuf.readableBytes());
                        channelHandlerContext.write(byteBuf, channelHandlerContext.voidPromise());
                    }
                    byteBuf = (ByteBuf) objPoll;
                } else {
                    if (objPoll instanceof ChannelPromise) {
                        decrementReadableBytes(byteBuf.readableBytes());
                        channelHandlerContext.write(byteBuf, (ChannelPromise) objPoll);
                    } else {
                        decrementReadableBytes(byteBuf.readableBytes());
                        channelHandlerContext.write(byteBuf).addListener((GenericFutureListener<? extends Future<? super Void>>) objPoll);
                    }
                    byteBuf = null;
                }
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    logger.info("Throwable being suppressed because Throwable {} is already pending", th2, th3);
                }
            }
            if (th2 == null) {
                th2 = th3;
            } else {
                logger.info("Throwable being suppressed because Throwable {} is already pending", th2, th3);
            }
        }
        if (th2 != null) {
            throw new IllegalStateException(th2);
        }
    }

    private void addFirst(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.addFirst(channelFutureListener);
        }
        this.bufAndListenerPairs.addFirst(byteBuf);
        incrementReadableBytes(byteBuf.readableBytes());
    }

    public final void add(ByteBuf byteBuf, ChannelPromise channelPromise) {
        add(byteBuf, toChannelFutureListener(channelPromise));
    }

    public final void add(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        this.bufAndListenerPairs.add(byteBuf);
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.add(channelFutureListener);
        }
        incrementReadableBytes(byteBuf.readableBytes());
    }
}
