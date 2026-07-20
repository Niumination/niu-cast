package io.netty.handler.codec.http2;

import io.netty.util.collection.IntCollections;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.EmptyPriorityQueue;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import io.netty.util.internal.SystemPropertyUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class WeightedFairQueueByteDistributor implements StreamByteDistributor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_MAX_STATE_ONLY_SIZE = 5;
    static final int INITIAL_CHILDREN_MAP_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.http2.childrenMapSize", 2));
    private int allocationQuantum;
    private final Http2Connection connection;
    private final State connectionState;
    private final int maxStateOnlySize;
    private final Http2Connection.PropertyKey stateKey;
    private final IntObjectMap<State> stateOnlyMap;
    private final PriorityQueue<State> stateOnlyRemovalQueue;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.WeightedFairQueueByteDistributor$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class ParentChangedEvent {
        final State oldParent;
        final State state;

        public ParentChangedEvent(State state, State state2) {
            this.state = state;
            this.oldParent = state2;
        }
    }

    public final class State implements PriorityQueueNode {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte STATE_IS_ACTIVE = 1;
        private static final byte STATE_IS_DISTRIBUTING = 2;
        private static final byte STATE_STREAM_ACTIVATED = 4;
        int activeCountForTree;
        IntObjectMap<State> children;
        int dependencyTreeDepth;
        private byte flags;
        State parent;
        long pseudoTime;
        private final PriorityQueue<State> pseudoTimeQueue;
        private int pseudoTimeQueueIndex;
        long pseudoTimeToWrite;
        private int stateOnlyQueueIndex;
        Http2Stream stream;
        final int streamId;
        int streamableBytes;
        long totalQueuedWeights;
        short weight;

        public State(WeightedFairQueueByteDistributor weightedFairQueueByteDistributor, int i10) {
            this(i10, null, 0);
        }

        private long getTotalWeight() {
            Iterator<State> it = this.children.values().iterator();
            long j10 = 0;
            while (it.hasNext()) {
                j10 += (long) it.next().weight;
            }
            return j10;
        }

        private void initChildren() {
            this.children = new IntObjectHashMap(WeightedFairQueueByteDistributor.INITIAL_CHILDREN_MAP_SIZE);
        }

        private void initChildrenIfEmpty() {
            if (this.children == IntCollections.emptyMap()) {
                initChildren();
            }
        }

        private IntObjectMap<State> removeAllChildrenExcept(State state) {
            State stateRemove = this.children.remove(state.streamId);
            IntObjectMap<State> intObjectMap = this.children;
            initChildren();
            if (stateRemove != null) {
                this.children.put(stateRemove.streamId, stateRemove);
            }
            return intObjectMap;
        }

        private void setActive() {
            this.flags = (byte) (this.flags | 1);
        }

        private void setParent(State state) {
            State state2;
            if (this.activeCountForTree != 0 && (state2 = this.parent) != null) {
                state2.removePseudoTimeQueue(this);
                this.parent.activeCountChangeForTree(-this.activeCountForTree);
            }
            this.parent = state;
            this.dependencyTreeDepth = state == null ? Integer.MAX_VALUE : state.dependencyTreeDepth + 1;
        }

        private void unsetActive() {
            this.flags = (byte) (this.flags & (-2));
        }

        public void activeCountChangeForTree(int i10) {
            int i11 = this.activeCountForTree + i10;
            this.activeCountForTree = i11;
            State state = this.parent;
            if (state != null) {
                if (i11 == 0) {
                    state.removePseudoTimeQueue(this);
                } else if (i11 == i10 && !isDistributing()) {
                    this.parent.offerAndInitializePseudoTime(this);
                }
                this.parent.activeCountChangeForTree(i10);
            }
        }

        public void close() {
            updateStreamableBytes(0, false);
            this.stream = null;
        }

        public boolean isActive() {
            return (this.flags & 1) != 0;
        }

        public boolean isDescendantOf(State state) {
            for (State state2 = this.parent; state2 != null; state2 = state2.parent) {
                if (state2 == state) {
                    return true;
                }
            }
            return false;
        }

        public boolean isDistributing() {
            return (this.flags & 2) != 0;
        }

        public void offerAndInitializePseudoTime(State state) {
            state.pseudoTimeToWrite = this.pseudoTime;
            offerPseudoTimeQueue(state);
        }

        public void offerPseudoTimeQueue(State state) {
            this.pseudoTimeQueue.offer(state);
            this.totalQueuedWeights += (long) state.weight;
        }

        public State peekPseudoTimeQueue() {
            return this.pseudoTimeQueue.peek();
        }

        public State pollPseudoTimeQueue() {
            State statePoll = this.pseudoTimeQueue.poll();
            this.totalQueuedWeights -= (long) statePoll.weight;
            return statePoll;
        }

        @Override // io.netty.util.internal.PriorityQueueNode
        public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
            return defaultPriorityQueue == WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue ? this.stateOnlyQueueIndex : this.pseudoTimeQueueIndex;
        }

        public void removeChild(State state) {
            if (this.children.remove(state.streamId) != null) {
                ArrayList arrayList = new ArrayList(state.children.size() + 1);
                arrayList.add(new ParentChangedEvent(state, state.parent));
                state.setParent(null);
                if (!state.children.isEmpty()) {
                    Iterator<IntObjectMap.PrimitiveEntry<State>> it = state.children.entries().iterator();
                    long totalWeight = state.getTotalWeight();
                    do {
                        State stateValue = it.next().value();
                        stateValue.weight = (short) Math.max(1L, ((long) (stateValue.weight * state.weight)) / totalWeight);
                        takeChild(it, stateValue, false, arrayList);
                    } while (it.hasNext());
                }
                WeightedFairQueueByteDistributor.this.notifyParentChanged(arrayList);
            }
        }

        public void removePseudoTimeQueue(State state) {
            if (this.pseudoTimeQueue.removeTyped(state)) {
                this.totalQueuedWeights -= (long) state.weight;
            }
        }

        public void setDistributing() {
            this.flags = (byte) (this.flags | 2);
        }

        public void setStreamReservedOrActivated() {
            this.flags = (byte) (this.flags | 4);
        }

        public void takeChild(State state, boolean z10, List<ParentChangedEvent> list) {
            takeChild(null, state, z10, list);
        }

        public String toString() {
            int i10 = this.activeCountForTree;
            if (i10 <= 0) {
                i10 = 1;
            }
            StringBuilder sb2 = new StringBuilder(i10 * 256);
            toString(sb2);
            return sb2.toString();
        }

        public void unsetDistributing() {
            this.flags = (byte) (this.flags & (-3));
        }

        public void updatePseudoTime(State state, int i10, long j10) {
            this.pseudoTimeToWrite = ((((long) i10) * j10) / ((long) this.weight)) + Math.min(this.pseudoTimeToWrite, state.pseudoTime);
        }

        public void updateStreamableBytes(int i10, boolean z10) {
            if (isActive() != z10) {
                if (z10) {
                    activeCountChangeForTree(1);
                    setActive();
                } else {
                    activeCountChangeForTree(-1);
                    unsetActive();
                }
            }
            this.streamableBytes = i10;
        }

        public boolean wasStreamReservedOrActivated() {
            return (this.flags & 4) != 0;
        }

        public void write(int i10, StreamByteDistributor.Writer writer) throws Http2Exception {
            try {
                writer.write(this.stream, i10);
            } catch (Throwable th2) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "byte distribution write error", new Object[0]);
            }
        }

        public State(WeightedFairQueueByteDistributor weightedFairQueueByteDistributor, Http2Stream http2Stream) {
            this(weightedFairQueueByteDistributor, http2Stream, 0);
        }

        @Override // io.netty.util.internal.PriorityQueueNode
        public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i10) {
            if (defaultPriorityQueue == WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue) {
                this.stateOnlyQueueIndex = i10;
            } else {
                this.pseudoTimeQueueIndex = i10;
            }
        }

        public void takeChild(Iterator<IntObjectMap.PrimitiveEntry<State>> it, State state, boolean z10, List<ParentChangedEvent> list) {
            State state2 = state.parent;
            if (state2 != this) {
                list.add(new ParentChangedEvent(state, state2));
                state.setParent(this);
                if (it != null) {
                    it.remove();
                } else if (state2 != null) {
                    state2.children.remove(state.streamId);
                }
                initChildrenIfEmpty();
                this.children.put(state.streamId, state);
            }
            if (!z10 || this.children.isEmpty()) {
                return;
            }
            Iterator<IntObjectMap.PrimitiveEntry<State>> it2 = removeAllChildrenExcept(state).entries().iterator();
            while (it2.hasNext()) {
                state.takeChild(it2, it2.next().value(), false, list);
            }
        }

        public State(WeightedFairQueueByteDistributor weightedFairQueueByteDistributor, Http2Stream http2Stream, int i10) {
            this(http2Stream.id(), http2Stream, i10);
        }

        public State(int i10, Http2Stream http2Stream, int i11) {
            this.children = IntCollections.emptyMap();
            this.pseudoTimeQueueIndex = -1;
            this.stateOnlyQueueIndex = -1;
            this.weight = (short) 16;
            this.stream = http2Stream;
            this.streamId = i10;
            this.pseudoTimeQueue = new DefaultPriorityQueue(StatePseudoTimeComparator.INSTANCE, i11);
        }

        private void toString(StringBuilder sb2) {
            sb2.append("{streamId ");
            sb2.append(this.streamId);
            sb2.append(" streamableBytes ");
            sb2.append(this.streamableBytes);
            sb2.append(" activeCountForTree ");
            sb2.append(this.activeCountForTree);
            sb2.append(" pseudoTimeQueueIndex ");
            sb2.append(this.pseudoTimeQueueIndex);
            sb2.append(" pseudoTimeToWrite ");
            sb2.append(this.pseudoTimeToWrite);
            sb2.append(" pseudoTime ");
            sb2.append(this.pseudoTime);
            sb2.append(" flags ");
            sb2.append((int) this.flags);
            sb2.append(" pseudoTimeQueue.size() ");
            sb2.append(this.pseudoTimeQueue.size());
            sb2.append(" stateOnlyQueueIndex ");
            sb2.append(this.stateOnlyQueueIndex);
            sb2.append(" parent.streamId ");
            State state = this.parent;
            sb2.append(state == null ? -1 : state.streamId);
            sb2.append("} [");
            if (!this.pseudoTimeQueue.isEmpty()) {
                Iterator<State> it = this.pseudoTimeQueue.iterator();
                while (it.hasNext()) {
                    it.next().toString(sb2);
                    sb2.append(", ");
                }
                sb2.setLength(sb2.length() - 2);
            }
            sb2.append(']');
        }
    }

    public static final class StateOnlyComparator implements Comparator<State>, Serializable {
        static final StateOnlyComparator INSTANCE = new StateOnlyComparator();
        private static final long serialVersionUID = -4806936913002105966L;

        private StateOnlyComparator() {
        }

        @Override // java.util.Comparator
        public int compare(State state, State state2) {
            boolean zWasStreamReservedOrActivated = state.wasStreamReservedOrActivated();
            if (zWasStreamReservedOrActivated != state2.wasStreamReservedOrActivated()) {
                return zWasStreamReservedOrActivated ? -1 : 1;
            }
            int i10 = state2.dependencyTreeDepth - state.dependencyTreeDepth;
            return i10 != 0 ? i10 : state.streamId - state2.streamId;
        }
    }

    public static final class StatePseudoTimeComparator implements Comparator<State>, Serializable {
        static final StatePseudoTimeComparator INSTANCE = new StatePseudoTimeComparator();
        private static final long serialVersionUID = -1437548640227161828L;

        private StatePseudoTimeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(State state, State state2) {
            return MathUtil.compare(state.pseudoTimeToWrite, state2.pseudoTimeToWrite);
        }
    }

    public WeightedFairQueueByteDistributor(Http2Connection http2Connection) {
        this(http2Connection, 5);
    }

    private int distributeToChildren(int i10, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        long j10 = state.totalQueuedWeights;
        State statePollPseudoTimeQueue = state.pollPseudoTimeQueue();
        State statePeekPseudoTimeQueue = state.peekPseudoTimeQueue();
        statePollPseudoTimeQueue.setDistributing();
        if (statePeekPseudoTimeQueue != null) {
            try {
                i10 = Math.min(i10, (int) Math.min((((statePeekPseudoTimeQueue.pseudoTimeToWrite - statePollPseudoTimeQueue.pseudoTimeToWrite) * ((long) statePollPseudoTimeQueue.weight)) / j10) + ((long) this.allocationQuantum), 2147483647L));
            } finally {
                statePollPseudoTimeQueue.unsetDistributing();
                if (statePollPseudoTimeQueue.activeCountForTree != 0) {
                    state.offerPseudoTimeQueue(statePollPseudoTimeQueue);
                }
            }
        }
        int iDistribute = distribute(i10, writer, statePollPseudoTimeQueue);
        state.pseudoTime += (long) iDistribute;
        statePollPseudoTimeQueue.updatePseudoTime(state, iDistribute, j10);
        return iDistribute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State state(Http2Stream http2Stream) {
        return (State) http2Stream.getProperty(this.stateKey);
    }

    public void allocationQuantum(int i10) {
        ObjectUtil.checkPositive(i10, "allocationQuantum");
        this.allocationQuantum = i10;
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public boolean distribute(int i10, StreamByteDistributor.Writer writer) throws Http2Exception {
        int i11;
        if (this.connectionState.activeCountForTree == 0) {
            return false;
        }
        while (true) {
            State state = this.connectionState;
            int i12 = state.activeCountForTree;
            i10 -= distributeToChildren(i10, writer, state);
            i11 = this.connectionState.activeCountForTree;
            if (i11 == 0 || (i10 <= 0 && i12 == i11)) {
                break;
            }
        }
        return i11 != 0;
    }

    public boolean isChild(int i10, int i11, short s10) {
        State state = state(i11);
        if (state.children.containsKey(i10)) {
            State state2 = state(i10);
            if (state2.parent == state && state2.weight == s10) {
                return true;
            }
        }
        return false;
    }

    public void notifyParentChanged(List<ParentChangedEvent> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            ParentChangedEvent parentChangedEvent = list.get(i10);
            this.stateOnlyRemovalQueue.priorityChanged(parentChangedEvent.state);
            State state = parentChangedEvent.state;
            State state2 = state.parent;
            if (state2 != null && state.activeCountForTree != 0) {
                state2.offerAndInitializePseudoTime(state);
                State state3 = parentChangedEvent.state;
                state3.parent.activeCountChangeForTree(state3.activeCountForTree);
            }
        }
    }

    public int numChildren(int i10) {
        State state = state(i10);
        if (state == null) {
            return 0;
        }
        return state.children.size();
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateDependencyTree(int i10, int i11, short s10, boolean z10) {
        ArrayList arrayList;
        State state;
        State state2 = state(i10);
        if (state2 == null) {
            if (this.maxStateOnlySize == 0) {
                return;
            }
            state2 = new State(this, i10);
            this.stateOnlyRemovalQueue.add(state2);
            this.stateOnlyMap.put(i10, state2);
        }
        State state3 = state(i11);
        if (state3 == null) {
            if (this.maxStateOnlySize == 0) {
                return;
            }
            state3 = new State(this, i11);
            this.stateOnlyRemovalQueue.add(state3);
            this.stateOnlyMap.put(i11, state3);
            ArrayList arrayList2 = new ArrayList(1);
            this.connectionState.takeChild(state3, false, arrayList2);
            notifyParentChanged(arrayList2);
        }
        if (state2.activeCountForTree != 0 && (state = state2.parent) != null) {
            state.totalQueuedWeights += (long) (s10 - state2.weight);
        }
        state2.weight = s10;
        if (state3 != state2.parent || (z10 && state3.children.size() != 1)) {
            if (state3.isDescendantOf(state2)) {
                arrayList = new ArrayList((z10 ? state3.children.size() : 0) + 2);
                state2.parent.takeChild(state3, false, arrayList);
            } else {
                arrayList = new ArrayList((z10 ? state3.children.size() : 0) + 1);
            }
            state3.takeChild(state2, z10, arrayList);
            notifyParentChanged(arrayList);
        }
        while (this.stateOnlyRemovalQueue.size() > this.maxStateOnlySize) {
            State statePoll = this.stateOnlyRemovalQueue.poll();
            statePoll.parent.removeChild(statePoll);
            this.stateOnlyMap.remove(statePoll.streamId);
        }
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame() && streamState.windowSize() >= 0);
    }

    public WeightedFairQueueByteDistributor(Http2Connection http2Connection, int i10) {
        this.allocationQuantum = 1024;
        ObjectUtil.checkPositiveOrZero(i10, "maxStateOnlySize");
        if (i10 == 0) {
            this.stateOnlyMap = IntCollections.emptyMap();
            this.stateOnlyRemovalQueue = EmptyPriorityQueue.instance();
        } else {
            this.stateOnlyMap = new IntObjectHashMap(i10);
            this.stateOnlyRemovalQueue = new DefaultPriorityQueue(StateOnlyComparator.INSTANCE, i10 + 2);
        }
        this.maxStateOnlySize = i10;
        this.connection = http2Connection;
        Http2Connection.PropertyKey propertyKeyNewKey = http2Connection.newKey();
        this.stateKey = propertyKeyNewKey;
        Http2Stream http2StreamConnectionStream = http2Connection.connectionStream();
        State state = new State(this, http2StreamConnectionStream, 16);
        this.connectionState = state;
        http2StreamConnectionStream.setProperty(propertyKeyNewKey, state);
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.WeightedFairQueueByteDistributor.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                WeightedFairQueueByteDistributor.this.state(http2Stream).setStreamReservedOrActivated();
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                State state2 = (State) WeightedFairQueueByteDistributor.this.stateOnlyMap.remove(http2Stream.id());
                if (state2 == null) {
                    state2 = new State(WeightedFairQueueByteDistributor.this, http2Stream);
                    ArrayList arrayList = new ArrayList(1);
                    WeightedFairQueueByteDistributor.this.connectionState.takeChild(state2, false, arrayList);
                    WeightedFairQueueByteDistributor.this.notifyParentChanged(arrayList);
                } else {
                    WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.removeTyped(state2);
                    state2.stream = http2Stream;
                }
                int i11 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
                if (i11 == 1 || i11 == 2) {
                    state2.setStreamReservedOrActivated();
                }
                http2Stream.setProperty(WeightedFairQueueByteDistributor.this.stateKey, state2);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                WeightedFairQueueByteDistributor.this.state(http2Stream).close();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                State state2 = WeightedFairQueueByteDistributor.this.state(http2Stream);
                state2.stream = null;
                if (WeightedFairQueueByteDistributor.this.maxStateOnlySize == 0) {
                    state2.parent.removeChild(state2);
                    return;
                }
                if (WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.size() == WeightedFairQueueByteDistributor.this.maxStateOnlySize) {
                    State state3 = (State) WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.peek();
                    if (StateOnlyComparator.INSTANCE.compare(state3, state2) >= 0) {
                        state2.parent.removeChild(state2);
                        return;
                    } else {
                        WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.poll();
                        state3.parent.removeChild(state3);
                        WeightedFairQueueByteDistributor.this.stateOnlyMap.remove(state3.streamId);
                    }
                }
                WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.add(state2);
                WeightedFairQueueByteDistributor.this.stateOnlyMap.put(state2.streamId, state2);
            }
        });
    }

    private State state(int i10) {
        Http2Stream http2StreamStream = this.connection.stream(i10);
        return http2StreamStream != null ? state(http2StreamStream) : this.stateOnlyMap.get(i10);
    }

    private int distribute(int i10, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        if (state.isActive()) {
            int iMin = Math.min(i10, state.streamableBytes);
            state.write(iMin, writer);
            if (iMin == 0 && i10 != 0) {
                state.updateStreamableBytes(state.streamableBytes, false);
            }
            return iMin;
        }
        return distributeToChildren(i10, writer, state);
    }
}
