package io.netty.handler.codec.http2;

import cb.b;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2Connection implements Http2Connection {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2Connection.class);
    final ActiveStreams activeStreams;
    Promise<Void> closePromise;
    final ConnectionStream connectionStream;
    final List<Http2Connection.Listener> listeners;
    final DefaultEndpoint<Http2LocalFlowController> localEndpoint;
    final PropertyKeyRegistry propertyKeyRegistry;
    final DefaultEndpoint<Http2RemoteFlowController> remoteEndpoint;
    final IntObjectMap<Http2Stream> streamMap;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.DefaultHttp2Connection$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final class ActiveStreams {
        private final List<Http2Connection.Listener> listeners;
        private int pendingIterations;
        private final Queue<Event> pendingEvents = new ArrayDeque(4);
        private final Set<Http2Stream> streams = new LinkedHashSet();

        public ActiveStreams(List<Http2Connection.Listener> list) {
            this.listeners = list;
        }

        public void activate(final DefaultStream defaultStream) {
            if (allowModifications()) {
                addToActiveStreams(defaultStream);
            } else {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.1
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        ActiveStreams.this.addToActiveStreams(defaultStream);
                    }
                });
            }
        }

        public void addToActiveStreams(DefaultStream defaultStream) {
            if (this.streams.add(defaultStream)) {
                defaultStream.createdBy().numActiveStreams++;
                for (int i10 = 0; i10 < this.listeners.size(); i10++) {
                    try {
                        this.listeners.get(i10).onStreamActive(defaultStream);
                    } catch (Throwable th2) {
                        DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamActive.", th2);
                    }
                }
            }
        }

        public boolean allowModifications() {
            return this.pendingIterations == 0;
        }

        public void deactivate(final DefaultStream defaultStream, final Iterator<?> it) {
            if (allowModifications() || it != null) {
                removeFromActiveStreams(defaultStream, it);
            } else {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.2
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        ActiveStreams.this.removeFromActiveStreams(defaultStream, it);
                    }
                });
            }
        }

        public void decrementPendingIterations() {
            this.pendingIterations--;
            if (!allowModifications()) {
                return;
            }
            while (true) {
                Event eventPoll = this.pendingEvents.poll();
                if (eventPoll == null) {
                    return;
                }
                try {
                    eventPoll.process();
                } catch (Throwable th2) {
                    DefaultHttp2Connection.logger.error("Caught Throwable while processing pending ActiveStreams$Event.", th2);
                }
            }
        }

        public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
            incrementPendingIterations();
            try {
                for (Http2Stream http2Stream : this.streams) {
                    if (!http2StreamVisitor.visit(http2Stream)) {
                        return http2Stream;
                    }
                }
                return null;
            } finally {
                decrementPendingIterations();
            }
        }

        public void incrementPendingIterations() {
            this.pendingIterations++;
        }

        public void removeFromActiveStreams(DefaultStream defaultStream, Iterator<?> it) {
            if (this.streams.remove(defaultStream)) {
                defaultStream.createdBy().numActiveStreams--;
                DefaultHttp2Connection.this.notifyClosed(defaultStream);
            }
            DefaultHttp2Connection.this.removeStream(defaultStream, it);
        }

        public int size() {
            return this.streams.size();
        }
    }

    public final class ConnectionStream extends DefaultStream {
        public ConnectionStream() {
            super(0, Http2Stream.State.IDLE);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream
        public DefaultEndpoint<? extends Http2FlowController> createdBy() {
            return null;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersSent(boolean z10) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isPushPromiseSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z10) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream pushPromiseSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            throw new UnsupportedOperationException();
        }
    }

    public final class DefaultEndpoint<F extends Http2FlowController> implements Http2Connection.Endpoint<F> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private F flowController;
        private int lastStreamKnownByPeer = -1;
        private int maxActiveStreams;
        private final int maxReservedStreams;
        private int maxStreams;
        private int nextReservationStreamId;
        private int nextStreamIdToCreate;
        int numActiveStreams;
        int numStreams;
        private boolean pushToAllowed;
        private final boolean server;

        public DefaultEndpoint(boolean z10, int i10) {
            this.server = z10;
            if (z10) {
                this.nextStreamIdToCreate = 2;
                this.nextReservationStreamId = 0;
            } else {
                this.nextStreamIdToCreate = 1;
                this.nextReservationStreamId = 1;
            }
            this.pushToAllowed = true ^ z10;
            this.maxActiveStreams = Integer.MAX_VALUE;
            this.maxReservedStreams = ObjectUtil.checkPositiveOrZero(i10, "maxReservedStreams");
            updateMaxStreams();
        }

        private void addStream(DefaultStream defaultStream) {
            DefaultHttp2Connection.this.streamMap.put(defaultStream.id(), defaultStream);
            for (int i10 = 0; i10 < DefaultHttp2Connection.this.listeners.size(); i10++) {
                try {
                    DefaultHttp2Connection.this.listeners.get(i10).onStreamAdded(defaultStream);
                } catch (Throwable th2) {
                    DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamAdded.", th2);
                }
            }
        }

        private void checkNewStreamAllowed(int i10, Http2Stream.State state) throws Http2Exception {
            int i11 = this.lastStreamKnownByPeer;
            if (i11 >= 0 && i10 > i11) {
                throw Http2Exception.streamError(i10, Http2Error.REFUSED_STREAM, "Cannot create stream %d greater than Last-Stream-ID %d from GOAWAY.", Integer.valueOf(i10), Integer.valueOf(this.lastStreamKnownByPeer));
            }
            if (!isValidStreamId(i10)) {
                if (i10 < 0) {
                    throw new Http2NoMoreStreamIdsException();
                }
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Request stream %d is not correct for %s connection", Integer.valueOf(i10), this.server ? "server" : "client");
            }
            int i12 = this.nextStreamIdToCreate;
            if (i10 < i12) {
                throw Http2Exception.closedStreamError(Http2Error.PROTOCOL_ERROR, "Request stream %d is behind the next expected stream %d", Integer.valueOf(i10), Integer.valueOf(this.nextStreamIdToCreate));
            }
            if (i12 <= 0) {
                throw new Http2Exception(Http2Error.REFUSED_STREAM, "Stream IDs are exhausted for this endpoint.", Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN);
            }
            boolean z10 = state == Http2Stream.State.RESERVED_LOCAL || state == Http2Stream.State.RESERVED_REMOTE;
            if ((z10 || canOpenStream()) && (!z10 || this.numStreams < this.maxStreams)) {
                if (DefaultHttp2Connection.this.isClosed()) {
                    throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Attempted to create stream id %d after connection was closed", Integer.valueOf(i10));
                }
            } else {
                Http2Error http2Error = Http2Error.REFUSED_STREAM;
                StringBuilder sb2 = new StringBuilder("Maximum active streams violated for this endpoint: ");
                sb2.append(z10 ? this.maxStreams : this.maxActiveStreams);
                throw Http2Exception.streamError(i10, http2Error, sb2.toString(), new Object[0]);
            }
        }

        private void incrementExpectedStreamId(int i10) {
            int i11 = this.nextReservationStreamId;
            if (i10 > i11 && i11 >= 0) {
                this.nextReservationStreamId = i10;
            }
            this.nextStreamIdToCreate = i10 + 2;
            this.numStreams++;
        }

        private boolean isLocal() {
            return this == DefaultHttp2Connection.this.localEndpoint;
        }

        private void updateMaxStreams() {
            this.maxStreams = (int) Math.min(2147483647L, ((long) this.maxActiveStreams) + ((long) this.maxReservedStreams));
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void allowPushTo(boolean z10) {
            if (z10 && this.server) {
                throw new IllegalArgumentException("Servers do not allow push");
            }
            this.pushToAllowed = z10;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean canOpenStream() {
            return this.numActiveStreams < this.maxActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean created(Http2Stream http2Stream) {
            return (http2Stream instanceof DefaultStream) && ((DefaultStream) http2Stream).createdBy() == this;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public F flowController() {
            return this.flowController;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int incrementAndGetNextStreamId() {
            int i10 = this.nextReservationStreamId;
            if (i10 < 0) {
                return i10;
            }
            int i11 = i10 + 2;
            this.nextReservationStreamId = i11;
            return i11;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isServer() {
            return this.server;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isValidStreamId(int i10) {
            if (i10 > 0) {
                return this.server == ((i10 & 1) == 0);
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamCreated() {
            int i10 = this.nextStreamIdToCreate;
            if (i10 > 1) {
                return i10 - 2;
            }
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamKnownByPeer() {
            return this.lastStreamKnownByPeer;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int maxActiveStreams() {
            return this.maxActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean mayHaveCreatedStream(int i10) {
            return isValidStreamId(i10) && i10 <= lastStreamCreated();
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int numActiveStreams() {
            return this.numActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public Http2Connection.Endpoint<? extends Http2FlowController> opposite() {
            boolean zIsLocal = isLocal();
            DefaultHttp2Connection defaultHttp2Connection = DefaultHttp2Connection.this;
            return zIsLocal ? defaultHttp2Connection.remoteEndpoint : defaultHttp2Connection.localEndpoint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lastStreamKnownByPeer(int i10) {
            this.lastStreamKnownByPeer = i10;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream createStream(int i10, boolean z10) throws Http2Exception {
            Http2Stream.State stateActiveState = DefaultHttp2Connection.activeState(i10, Http2Stream.State.IDLE, isLocal(), z10);
            checkNewStreamAllowed(i10, stateActiveState);
            DefaultStream defaultStream = DefaultHttp2Connection.this.new DefaultStream(i10, stateActiveState);
            incrementExpectedStreamId(i10);
            addStream(defaultStream);
            defaultStream.activate();
            return defaultStream;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void flowController(F f10) {
            this.flowController = (F) ObjectUtil.checkNotNull(f10, "flowController");
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void maxActiveStreams(int i10) {
            this.maxActiveStreams = i10;
            updateMaxStreams();
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream reservePushStream(int i10, Http2Stream http2Stream) throws Http2Exception {
            if (http2Stream == null) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Parent stream missing", new Object[0]);
            }
            if (!isLocal() ? http2Stream.state().remoteSideOpen() : http2Stream.state().localSideOpen()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d is not open for sending push promise", Integer.valueOf(http2Stream.id()));
            }
            if (!opposite().allowPushTo()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server push not allowed to opposite endpoint", new Object[0]);
            }
            Http2Stream.State state = isLocal() ? Http2Stream.State.RESERVED_LOCAL : Http2Stream.State.RESERVED_REMOTE;
            checkNewStreamAllowed(i10, state);
            DefaultStream defaultStream = DefaultHttp2Connection.this.new DefaultStream(i10, state);
            incrementExpectedStreamId(i10);
            addStream(defaultStream);
            return defaultStream;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean allowPushTo() {
            return this.pushToAllowed;
        }
    }

    public final class DefaultPropertyKey implements Http2Connection.PropertyKey {
        final int index;

        public DefaultPropertyKey(int i10) {
            this.index = i10;
        }

        public DefaultPropertyKey verifyConnection(Http2Connection http2Connection) {
            if (http2Connection == DefaultHttp2Connection.this) {
                return this;
            }
            throw new IllegalArgumentException("Using a key that was not created by this connection");
        }
    }

    public interface Event {
        void process();
    }

    public final class PropertyKeyRegistry {
        final List<DefaultPropertyKey> keys;

        private PropertyKeyRegistry() {
            this.keys = new ArrayList(4);
        }

        public DefaultPropertyKey newKey() {
            DefaultPropertyKey defaultPropertyKey = DefaultHttp2Connection.this.new DefaultPropertyKey(this.keys.size());
            this.keys.add(defaultPropertyKey);
            return defaultPropertyKey;
        }

        public int size() {
            return this.keys.size();
        }
    }

    public DefaultHttp2Connection(boolean z10) {
        this(z10, 100);
    }

    public static Http2Stream.State activeState(int i10, Http2Stream.State state, boolean z10, boolean z11) throws Http2Exception {
        int i11 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[state.ordinal()];
        if (i11 == 1) {
            if (z11) {
                return z10 ? Http2Stream.State.HALF_CLOSED_LOCAL : Http2Stream.State.HALF_CLOSED_REMOTE;
            }
            return Http2Stream.State.OPEN;
        }
        if (i11 == 2) {
            return Http2Stream.State.HALF_CLOSED_REMOTE;
        }
        if (i11 == 3) {
            return Http2Stream.State.HALF_CLOSED_LOCAL;
        }
        throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Attempting to open a stream in an invalid state: " + state, new Object[0]);
    }

    private void closeStreamsGreaterThanLastKnownStreamId(final int i10, final DefaultEndpoint<?> defaultEndpoint) throws Http2Exception {
        forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.1
            @Override // io.netty.handler.codec.http2.Http2StreamVisitor
            public boolean visit(Http2Stream http2Stream) {
                if (http2Stream.id() <= i10 || !defaultEndpoint.isValidStreamId(http2Stream.id())) {
                    return true;
                }
                http2Stream.close();
                return true;
            }
        });
    }

    private boolean isStreamMapEmpty() {
        return this.streamMap.size() == 1;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void addListener(Http2Connection.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Future<Void> close(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        Promise<Void> promise2 = this.closePromise;
        if (promise2 == null) {
            this.closePromise = promise;
        } else if (promise2 != promise) {
            if ((promise instanceof ChannelPromise) && ((ChannelFuture) promise2).isVoid()) {
                this.closePromise = promise;
            } else {
                PromiseNotifier.cascade(this.closePromise, promise);
            }
        }
        if (isStreamMapEmpty()) {
            promise.trySuccess(null);
            return promise;
        }
        Iterator<IntObjectMap.PrimitiveEntry<Http2Stream>> it = this.streamMap.entries().iterator();
        if (this.activeStreams.allowModifications()) {
            this.activeStreams.incrementPendingIterations();
            while (it.hasNext()) {
                try {
                    DefaultStream defaultStream = (DefaultStream) it.next().value();
                    if (defaultStream.id() != 0) {
                        defaultStream.close(it);
                    }
                } finally {
                    this.activeStreams.decrementPendingIterations();
                }
            }
        } else {
            while (it.hasNext()) {
                Http2Stream http2StreamValue = it.next().value();
                if (http2StreamValue.id() != 0) {
                    http2StreamValue.close();
                }
            }
        }
        return this.closePromise;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream connectionStream() {
        return this.connectionStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
        return this.activeStreams.forEachActiveStream(http2StreamVisitor);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwayReceived() {
        return ((DefaultEndpoint) this.localEndpoint).lastStreamKnownByPeer >= 0;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwaySent() {
        return ((DefaultEndpoint) this.remoteEndpoint).lastStreamKnownByPeer >= 0;
    }

    public final boolean isClosed() {
        return this.closePromise != null;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean isServer() {
        return this.localEndpoint.isServer();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2LocalFlowController> local() {
        return this.localEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.PropertyKey newKey() {
        return this.propertyKeyRegistry.newKey();
    }

    public void notifyClosed(Http2Stream http2Stream) {
        for (int i10 = 0; i10 < this.listeners.size(); i10++) {
            try {
                this.listeners.get(i10).onStreamClosed(http2Stream);
            } catch (Throwable th2) {
                logger.error("Caught Throwable from listener onStreamClosed.", th2);
            }
        }
    }

    public void notifyHalfClosed(Http2Stream http2Stream) {
        for (int i10 = 0; i10 < this.listeners.size(); i10++) {
            try {
                this.listeners.get(i10).onStreamHalfClosed(http2Stream);
            } catch (Throwable th2) {
                logger.error("Caught Throwable from listener onStreamHalfClosed.", th2);
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public int numActiveStreams() {
        return this.activeStreams.size();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2RemoteFlowController> remote() {
        return this.remoteEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void removeListener(Http2Connection.Listener listener) {
        this.listeners.remove(listener);
    }

    public void removeStream(DefaultStream defaultStream, Iterator<?> it) {
        if (it != null) {
            it.remove();
        } else if (this.streamMap.remove(defaultStream.id()) == null) {
            return;
        }
        for (int i10 = 0; i10 < this.listeners.size(); i10++) {
            try {
                this.listeners.get(i10).onStreamRemoved(defaultStream);
            } catch (Throwable th2) {
                logger.error("Caught Throwable from listener onStreamRemoved.", th2);
            }
        }
        if (this.closePromise == null || !isStreamMapEmpty()) {
            return;
        }
        this.closePromise.trySuccess(null);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream stream(int i10) {
        return this.streamMap.get(i10);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean streamMayHaveExisted(int i10) {
        return this.remoteEndpoint.mayHaveCreatedStream(i10) || this.localEndpoint.mayHaveCreatedStream(i10);
    }

    public final DefaultPropertyKey verifyKey(Http2Connection.PropertyKey propertyKey) {
        return ((DefaultPropertyKey) ObjectUtil.checkNotNull((DefaultPropertyKey) propertyKey, b.c.f1408o)).verifyConnection(this);
    }

    public DefaultHttp2Connection(boolean z10, int i10) {
        IntObjectHashMap intObjectHashMap = new IntObjectHashMap();
        this.streamMap = intObjectHashMap;
        this.propertyKeyRegistry = new PropertyKeyRegistry();
        ConnectionStream connectionStream = new ConnectionStream();
        this.connectionStream = connectionStream;
        ArrayList arrayList = new ArrayList(4);
        this.listeners = arrayList;
        this.activeStreams = new ActiveStreams(arrayList);
        this.localEndpoint = new DefaultEndpoint<>(z10, z10 ? Integer.MAX_VALUE : i10);
        this.remoteEndpoint = new DefaultEndpoint<>(!z10, i10);
        intObjectHashMap.put(connectionStream.id(), connectionStream);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void goAwayReceived(int i10, long j10, ByteBuf byteBuf) throws Http2Exception {
        if (this.localEndpoint.lastStreamKnownByPeer() >= 0 && this.localEndpoint.lastStreamKnownByPeer() < i10) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "lastStreamId MUST NOT increase. Current value: %d new value: %d", Integer.valueOf(this.localEndpoint.lastStreamKnownByPeer()), Integer.valueOf(i10));
        }
        this.localEndpoint.lastStreamKnownByPeer(i10);
        for (int i11 = 0; i11 < this.listeners.size(); i11++) {
            try {
                this.listeners.get(i11).onGoAwayReceived(i10, j10, byteBuf);
            } catch (Throwable th2) {
                logger.error("Caught Throwable from listener onGoAwayReceived.", th2);
            }
        }
        closeStreamsGreaterThanLastKnownStreamId(i10, this.localEndpoint);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwaySent(int i10, long j10, ByteBuf byteBuf) throws Http2Exception {
        if (this.remoteEndpoint.lastStreamKnownByPeer() >= 0) {
            if (i10 == this.remoteEndpoint.lastStreamKnownByPeer()) {
                return false;
            }
            if (i10 > this.remoteEndpoint.lastStreamKnownByPeer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Last stream identifier must not increase between sending multiple GOAWAY frames (was '%d', is '%d').", Integer.valueOf(this.remoteEndpoint.lastStreamKnownByPeer()), Integer.valueOf(i10));
            }
        }
        this.remoteEndpoint.lastStreamKnownByPeer(i10);
        for (int i11 = 0; i11 < this.listeners.size(); i11++) {
            try {
                this.listeners.get(i11).onGoAwaySent(i10, j10, byteBuf);
            } catch (Throwable th2) {
                logger.error("Caught Throwable from listener onGoAwaySent.", th2);
            }
        }
        closeStreamsGreaterThanLastKnownStreamId(i10, this.remoteEndpoint);
        return true;
    }

    public class DefaultStream implements Http2Stream {
        private static final byte META_STATE_RECV_HEADERS = 16;
        private static final byte META_STATE_RECV_TRAILERS = 32;
        private static final byte META_STATE_SENT_HEADERS = 2;
        private static final byte META_STATE_SENT_PUSHPROMISE = 8;
        private static final byte META_STATE_SENT_RST = 1;
        private static final byte META_STATE_SENT_TRAILERS = 4;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f8314id;
        private byte metaState;
        private final PropertyMap properties = new PropertyMap();
        private Http2Stream.State state;

        public class PropertyMap {
            Object[] values;

            private PropertyMap() {
                this.values = EmptyArrays.EMPTY_OBJECTS;
            }

            public <V> V add(DefaultPropertyKey defaultPropertyKey, V v10) {
                resizeIfNecessary(defaultPropertyKey.index);
                Object[] objArr = this.values;
                int i10 = defaultPropertyKey.index;
                V v11 = (V) objArr[i10];
                objArr[i10] = v10;
                return v11;
            }

            public <V> V get(DefaultPropertyKey defaultPropertyKey) {
                int i10 = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i10 >= objArr.length) {
                    return null;
                }
                return (V) objArr[i10];
            }

            public <V> V remove(DefaultPropertyKey defaultPropertyKey) {
                int i10 = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i10 >= objArr.length) {
                    return null;
                }
                V v10 = (V) objArr[i10];
                objArr[i10] = null;
                return v10;
            }

            public void resizeIfNecessary(int i10) {
                Object[] objArr = this.values;
                if (i10 >= objArr.length) {
                    this.values = Arrays.copyOf(objArr, DefaultHttp2Connection.this.propertyKeyRegistry.size());
                }
            }
        }

        public DefaultStream(int i10, Http2Stream.State state) {
            this.f8314id = i10;
            this.state = state;
        }

        public void activate() {
            Http2Stream.State state = this.state;
            if (state == Http2Stream.State.HALF_CLOSED_LOCAL) {
                headersSent(false);
            } else if (state == Http2Stream.State.HALF_CLOSED_REMOTE) {
                headersReceived(false);
            }
            DefaultHttp2Connection.this.activeStreams.activate(this);
        }

        public Http2Stream close(Iterator<?> it) {
            Http2Stream.State state = this.state;
            Http2Stream.State state2 = Http2Stream.State.CLOSED;
            if (state == state2) {
                return this;
            }
            this.state = state2;
            createdBy().numStreams--;
            DefaultHttp2Connection.this.activeStreams.deactivate(this, it);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            int i10 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i10 == 4) {
                this.state = Http2Stream.State.HALF_CLOSED_LOCAL;
                DefaultHttp2Connection.this.notifyHalfClosed(this);
            } else if (i10 != 5) {
                close();
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            int i10 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i10 == 4) {
                this.state = Http2Stream.State.HALF_CLOSED_REMOTE;
                DefaultHttp2Connection.this.notifyHalfClosed(this);
            } else if (i10 != 6) {
                close();
            }
            return this;
        }

        public DefaultEndpoint<? extends Http2FlowController> createdBy() {
            boolean zIsValidStreamId = DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.f8314id);
            DefaultHttp2Connection defaultHttp2Connection = DefaultHttp2Connection.this;
            return zIsValidStreamId ? defaultHttp2Connection.localEndpoint : defaultHttp2Connection.remoteEndpoint;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V getProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.get(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersReceived(boolean z10) {
            if (!z10) {
                this.metaState = (byte) (this.metaState | (isHeadersReceived() ? (byte) 32 : (byte) 16));
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersSent(boolean z10) {
            if (!z10) {
                this.metaState = (byte) (this.metaState | (isHeadersSent() ? (byte) 4 : (byte) 2));
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final int id() {
            return this.f8314id;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersReceived() {
            return (this.metaState & 16) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersSent() {
            return (this.metaState & 2) != 0;
        }

        public final boolean isLocal() {
            return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.f8314id);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isPushPromiseSent() {
            return (this.metaState & 8) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return (this.metaState & 1) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isTrailersReceived() {
            return (this.metaState & 32) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isTrailersSent() {
            return (this.metaState & 4) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z10) throws Http2Exception {
            this.state = DefaultHttp2Connection.activeState(this.f8314id, this.state, isLocal(), z10);
            DefaultEndpoint<? extends Http2FlowController> defaultEndpointCreatedBy = createdBy();
            if (defaultEndpointCreatedBy.canOpenStream()) {
                activate();
                return this;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Maximum active streams violated for this endpoint: " + defaultEndpointCreatedBy.maxActiveStreams(), new Object[0]);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream pushPromiseSent() {
            this.metaState = (byte) (this.metaState | 8);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V removeProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.remove(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            this.metaState = (byte) (this.metaState | 1);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V setProperty(Http2Connection.PropertyKey propertyKey, V v10) {
            return (V) this.properties.add(DefaultHttp2Connection.this.verifyKey(propertyKey), v10);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final Http2Stream.State state() {
            return this.state;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            return close(null);
        }
    }
}
