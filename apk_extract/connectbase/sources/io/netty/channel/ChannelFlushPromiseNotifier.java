package io.netty.channel;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class ChannelFlushPromiseNotifier {
    private final Queue<FlushCheckpoint> flushCheckpoints;
    private final boolean tryNotify;
    private long writeCounter;

    public static class DefaultFlushCheckpoint implements FlushCheckpoint {
        private long checkpoint;
        private final ChannelPromise future;

        public DefaultFlushCheckpoint(long j10, ChannelPromise channelPromise) {
            this.checkpoint = j10;
            this.future = channelPromise;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public long flushCheckpoint() {
            return this.checkpoint;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public ChannelPromise promise() {
            return this.future;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public void flushCheckpoint(long j10) {
            this.checkpoint = j10;
        }
    }

    public interface FlushCheckpoint {
        long flushCheckpoint();

        void flushCheckpoint(long j10);

        ChannelPromise promise();
    }

    public ChannelFlushPromiseNotifier(boolean z10) {
        this.flushCheckpoints = new ArrayDeque();
        this.tryNotify = z10;
    }

    private void notifyPromises0(Throwable th2) {
        if (this.flushCheckpoints.isEmpty()) {
            this.writeCounter = 0L;
            return;
        }
        long j10 = this.writeCounter;
        while (true) {
            FlushCheckpoint flushCheckpointPeek = this.flushCheckpoints.peek();
            if (flushCheckpointPeek == null) {
                this.writeCounter = 0L;
                break;
            }
            if (flushCheckpointPeek.flushCheckpoint() > j10) {
                if (j10 > 0 && this.flushCheckpoints.size() == 1) {
                    this.writeCounter = 0L;
                    flushCheckpointPeek.flushCheckpoint(flushCheckpointPeek.flushCheckpoint() - j10);
                    break;
                } else {
                    break;
                    break;
                }
            }
            this.flushCheckpoints.remove();
            ChannelPromise channelPromisePromise = flushCheckpointPeek.promise();
            if (th2 == null) {
                if (this.tryNotify) {
                    channelPromisePromise.trySuccess();
                } else {
                    channelPromisePromise.setSuccess();
                }
            } else if (this.tryNotify) {
                channelPromisePromise.tryFailure(th2);
            } else {
                channelPromisePromise.setFailure(th2);
            }
        }
        long j11 = this.writeCounter;
        if (j11 >= 549755813888L) {
            this.writeCounter = 0L;
            for (FlushCheckpoint flushCheckpoint : this.flushCheckpoints) {
                flushCheckpoint.flushCheckpoint(flushCheckpoint.flushCheckpoint() - j11);
            }
        }
    }

    @Deprecated
    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, int i10) {
        return add(channelPromise, i10);
    }

    public ChannelFlushPromiseNotifier increaseWriteCounter(long j10) {
        ObjectUtil.checkPositiveOrZero(j10, "delta");
        this.writeCounter += j10;
        return this;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures() {
        return notifyPromises();
    }

    public ChannelFlushPromiseNotifier notifyPromises() {
        notifyPromises0(null);
        return this;
    }

    public long writeCounter() {
        return this.writeCounter;
    }

    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, long j10) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        ObjectUtil.checkPositiveOrZero(j10, "pendingDataSize");
        long j11 = this.writeCounter + j10;
        if (channelPromise instanceof FlushCheckpoint) {
            FlushCheckpoint flushCheckpoint = (FlushCheckpoint) channelPromise;
            flushCheckpoint.flushCheckpoint(j11);
            this.flushCheckpoints.add(flushCheckpoint);
        } else {
            this.flushCheckpoints.add(new DefaultFlushCheckpoint(j11, channelPromise));
        }
        return this;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th2) {
        return notifyPromises(th2);
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable th2) {
        notifyPromises();
        while (true) {
            FlushCheckpoint flushCheckpointPoll = this.flushCheckpoints.poll();
            if (flushCheckpointPoll == null) {
                return this;
            }
            if (this.tryNotify) {
                flushCheckpointPoll.promise().tryFailure(th2);
            } else {
                flushCheckpointPoll.promise().setFailure(th2);
            }
        }
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th2, Throwable th3) {
        return notifyPromises(th2, th3);
    }

    public ChannelFlushPromiseNotifier() {
        this(false);
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable th2, Throwable th3) {
        notifyPromises0(th2);
        while (true) {
            FlushCheckpoint flushCheckpointPoll = this.flushCheckpoints.poll();
            if (flushCheckpointPoll == null) {
                return this;
            }
            if (this.tryNotify) {
                flushCheckpointPoll.promise().tryFailure(th3);
            } else {
                flushCheckpointPoll.promise().setFailure(th3);
            }
        }
    }
}
