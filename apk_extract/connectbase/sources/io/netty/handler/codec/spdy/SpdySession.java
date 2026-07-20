package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelPromise;
import io.netty.util.internal.PlatformDependent;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class SpdySession {
    private final AtomicInteger receiveWindowSize;
    private final AtomicInteger sendWindowSize;
    private final AtomicInteger activeLocalStreams = new AtomicInteger();
    private final AtomicInteger activeRemoteStreams = new AtomicInteger();
    private final Map<Integer, StreamState> activeStreams = PlatformDependent.newConcurrentHashMap();
    private final StreamComparator streamComparator = new StreamComparator();

    public static final class PendingWrite {
        final ChannelPromise promise;
        final SpdyDataFrame spdyDataFrame;

        public PendingWrite(SpdyDataFrame spdyDataFrame, ChannelPromise channelPromise) {
            this.spdyDataFrame = spdyDataFrame;
            this.promise = channelPromise;
        }

        public void fail(Throwable th2) {
            this.spdyDataFrame.release();
            this.promise.setFailure(th2);
        }
    }

    public final class StreamComparator implements Comparator<Integer> {
        public StreamComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            int priority = ((StreamState) SpdySession.this.activeStreams.get(num)).getPriority() - ((StreamState) SpdySession.this.activeStreams.get(num2)).getPriority();
            return priority != 0 ? priority : num.intValue() - num2.intValue();
        }
    }

    public static final class StreamState {
        private boolean localSideClosed;
        private final Queue<PendingWrite> pendingWriteQueue = new ConcurrentLinkedQueue();
        private final byte priority;
        private final AtomicInteger receiveWindowSize;
        private int receiveWindowSizeLowerBound;
        private boolean receivedReply;
        private boolean remoteSideClosed;
        private final AtomicInteger sendWindowSize;

        public StreamState(byte b10, boolean z10, boolean z11, int i10, int i11) {
            this.priority = b10;
            this.remoteSideClosed = z10;
            this.localSideClosed = z11;
            this.sendWindowSize = new AtomicInteger(i10);
            this.receiveWindowSize = new AtomicInteger(i11);
        }

        public void clearPendingWrites(Throwable th2) {
            while (true) {
                PendingWrite pendingWritePoll = this.pendingWriteQueue.poll();
                if (pendingWritePoll == null) {
                    return;
                } else {
                    pendingWritePoll.fail(th2);
                }
            }
        }

        public void closeLocalSide() {
            this.localSideClosed = true;
        }

        public void closeRemoteSide() {
            this.remoteSideClosed = true;
        }

        public PendingWrite getPendingWrite() {
            return this.pendingWriteQueue.peek();
        }

        public byte getPriority() {
            return this.priority;
        }

        public int getReceiveWindowSizeLowerBound() {
            return this.receiveWindowSizeLowerBound;
        }

        public int getSendWindowSize() {
            return this.sendWindowSize.get();
        }

        public boolean hasReceivedReply() {
            return this.receivedReply;
        }

        public boolean isLocalSideClosed() {
            return this.localSideClosed;
        }

        public boolean isRemoteSideClosed() {
            return this.remoteSideClosed;
        }

        public boolean putPendingWrite(PendingWrite pendingWrite) {
            return this.pendingWriteQueue.offer(pendingWrite);
        }

        public void receivedReply() {
            this.receivedReply = true;
        }

        public PendingWrite removePendingWrite() {
            return this.pendingWriteQueue.poll();
        }

        public void setReceiveWindowSizeLowerBound(int i10) {
            this.receiveWindowSizeLowerBound = i10;
        }

        public int updateReceiveWindowSize(int i10) {
            return this.receiveWindowSize.addAndGet(i10);
        }

        public int updateSendWindowSize(int i10) {
            return this.sendWindowSize.addAndGet(i10);
        }
    }

    public SpdySession(int i10, int i11) {
        this.sendWindowSize = new AtomicInteger(i10);
        this.receiveWindowSize = new AtomicInteger(i11);
    }

    private StreamState removeActiveStream(int i10, boolean z10) {
        StreamState streamStateRemove = this.activeStreams.remove(Integer.valueOf(i10));
        if (streamStateRemove != null) {
            if (z10) {
                this.activeRemoteStreams.decrementAndGet();
            } else {
                this.activeLocalStreams.decrementAndGet();
            }
        }
        return streamStateRemove;
    }

    public void acceptStream(int i10, byte b10, boolean z10, boolean z11, int i11, int i12, boolean z12) {
        if (!(z10 && z11) && this.activeStreams.put(Integer.valueOf(i10), new StreamState(b10, z10, z11, i11, i12)) == null) {
            if (z12) {
                this.activeRemoteStreams.incrementAndGet();
            } else {
                this.activeLocalStreams.incrementAndGet();
            }
        }
    }

    public Map<Integer, StreamState> activeStreams() {
        TreeMap treeMap = new TreeMap(this.streamComparator);
        treeMap.putAll(this.activeStreams);
        return treeMap;
    }

    public void closeLocalSide(int i10, boolean z10) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        if (streamState != null) {
            streamState.closeLocalSide();
            if (streamState.isRemoteSideClosed()) {
                removeActiveStream(i10, z10);
            }
        }
    }

    public void closeRemoteSide(int i10, boolean z10) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        if (streamState != null) {
            streamState.closeRemoteSide();
            if (streamState.isLocalSideClosed()) {
                removeActiveStream(i10, z10);
            }
        }
    }

    public PendingWrite getPendingWrite(int i10) {
        PendingWrite pendingWrite;
        if (i10 != 0) {
            StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
            if (streamState != null) {
                return streamState.getPendingWrite();
            }
            return null;
        }
        Iterator<Map.Entry<Integer, StreamState>> it = activeStreams().entrySet().iterator();
        while (it.hasNext()) {
            StreamState value = it.next().getValue();
            if (value.getSendWindowSize() > 0 && (pendingWrite = value.getPendingWrite()) != null) {
                return pendingWrite;
            }
        }
        return null;
    }

    public int getReceiveWindowSizeLowerBound(int i10) {
        StreamState streamState;
        if (i10 == 0 || (streamState = this.activeStreams.get(Integer.valueOf(i10))) == null) {
            return 0;
        }
        return streamState.getReceiveWindowSizeLowerBound();
    }

    public int getSendWindowSize(int i10) {
        if (i10 == 0) {
            return this.sendWindowSize.get();
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        if (streamState != null) {
            return streamState.getSendWindowSize();
        }
        return -1;
    }

    public boolean hasReceivedReply(int i10) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        return streamState != null && streamState.hasReceivedReply();
    }

    public boolean isActiveStream(int i10) {
        return this.activeStreams.containsKey(Integer.valueOf(i10));
    }

    public boolean isLocalSideClosed(int i10) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        return streamState == null || streamState.isLocalSideClosed();
    }

    public boolean isRemoteSideClosed(int i10) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        return streamState == null || streamState.isRemoteSideClosed();
    }

    public boolean noActiveStreams() {
        return this.activeStreams.isEmpty();
    }

    public int numActiveStreams(boolean z10) {
        return z10 ? this.activeRemoteStreams.get() : this.activeLocalStreams.get();
    }

    public boolean putPendingWrite(int i10, PendingWrite pendingWrite) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        return streamState != null && streamState.putPendingWrite(pendingWrite);
    }

    public void receivedReply(int i10) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        if (streamState != null) {
            streamState.receivedReply();
        }
    }

    public PendingWrite removePendingWrite(int i10) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        if (streamState != null) {
            return streamState.removePendingWrite();
        }
        return null;
    }

    public void removeStream(int i10, Throwable th2, boolean z10) {
        StreamState streamStateRemoveActiveStream = removeActiveStream(i10, z10);
        if (streamStateRemoveActiveStream != null) {
            streamStateRemoveActiveStream.clearPendingWrites(th2);
        }
    }

    public void updateAllReceiveWindowSizes(int i10) {
        for (StreamState streamState : this.activeStreams.values()) {
            streamState.updateReceiveWindowSize(i10);
            if (i10 < 0) {
                streamState.setReceiveWindowSizeLowerBound(i10);
            }
        }
    }

    public void updateAllSendWindowSizes(int i10) {
        Iterator<StreamState> it = this.activeStreams.values().iterator();
        while (it.hasNext()) {
            it.next().updateSendWindowSize(i10);
        }
    }

    public int updateReceiveWindowSize(int i10, int i11) {
        if (i10 == 0) {
            return this.receiveWindowSize.addAndGet(i11);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        if (streamState == null) {
            return -1;
        }
        if (i11 > 0) {
            streamState.setReceiveWindowSizeLowerBound(0);
        }
        return streamState.updateReceiveWindowSize(i11);
    }

    public int updateSendWindowSize(int i10, int i11) {
        if (i10 == 0) {
            return this.sendWindowSize.addAndGet(i11);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i10));
        if (streamState != null) {
            return streamState.updateSendWindowSize(i11);
        }
        return -1;
    }
}
