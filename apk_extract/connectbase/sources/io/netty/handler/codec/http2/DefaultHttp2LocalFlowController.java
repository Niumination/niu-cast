package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2LocalFlowController implements Http2LocalFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final FlowState REDUCED_FLOW_STATE = new FlowState() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.2
        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i10) throws Http2Exception {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z10) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i10) throws Http2Exception {
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i10) {
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i10) throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f10) {
            throw new UnsupportedOperationException();
        }
    };
    private final Http2Connection connection;
    private ChannelHandlerContext ctx;
    private Http2FrameWriter frameWriter;
    private int initialWindowSize;
    private final Http2Connection.PropertyKey stateKey;
    private float windowUpdateRatio;

    public final class AutoRefillState extends DefaultState {
        public AutoRefillState(Http2Stream http2Stream, int i10) {
            super(http2Stream, i10);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i10) throws Http2Exception {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i10) throws Http2Exception {
            super.receiveFlowControlledFrame(i10);
            super.consumeBytes(i10);
        }
    }

    public class DefaultState implements FlowState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean endOfStream;
        private int initialStreamWindowSize;
        private int lowerBound;
        private int processedWindow;
        private final Http2Stream stream;
        private float streamWindowUpdateRatio;
        private int window;

        public DefaultState(Http2Stream http2Stream, int i10) {
            this.stream = http2Stream;
            window(i10);
            this.streamWindowUpdateRatio = DefaultHttp2LocalFlowController.this.windowUpdateRatio;
        }

        private void returnProcessedBytes(int i10) throws Http2Exception {
            int i11 = this.processedWindow;
            if (i11 - i10 < this.window) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
            this.processedWindow = i11 - i10;
        }

        private void writeWindowUpdate() throws Http2Exception {
            int i10 = this.initialStreamWindowSize - this.processedWindow;
            try {
                incrementFlowControlWindows(i10);
                DefaultHttp2LocalFlowController.this.frameWriter.writeWindowUpdate(DefaultHttp2LocalFlowController.this.ctx, this.stream.id(), i10, DefaultHttp2LocalFlowController.this.ctx.newPromise());
            } catch (Throwable th2) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i10) throws Http2Exception {
            returnProcessedBytes(i10);
            return writeWindowUpdateIfNeeded();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z10) {
            this.endOfStream = z10;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i10) throws Http2Exception {
            if (i10 > 0 && this.window > Integer.MAX_VALUE - i10) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window overflowed for stream: %d", Integer.valueOf(this.stream.id()));
            }
            this.window += i10;
            this.processedWindow += i10;
            this.lowerBound = Math.min(i10, 0);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i10) {
            int iMin = (int) Math.min(2147483647L, Math.max(0L, ((long) this.initialStreamWindowSize) + ((long) i10)));
            int i11 = this.initialStreamWindowSize;
            this.initialStreamWindowSize = (iMin - i11) + i11;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return this.initialStreamWindowSize;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i10) throws Http2Exception {
            int i11 = this.window - i10;
            this.window = i11;
            if (i11 < this.lowerBound) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window exceeded for stream: %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return this.processedWindow - this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i10) {
            this.initialStreamWindowSize = i10;
            this.processedWindow = i10;
            this.window = i10;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            return this.streamWindowUpdateRatio;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            if (!this.endOfStream && this.initialStreamWindowSize > 0 && !DefaultHttp2LocalFlowController.isClosed(this.stream)) {
                if (this.processedWindow <= ((int) (this.initialStreamWindowSize * this.streamWindowUpdateRatio))) {
                    writeWindowUpdate();
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f10) {
            this.streamWindowUpdateRatio = f10;
        }
    }

    public interface FlowState {
        boolean consumeBytes(int i10) throws Http2Exception;

        void endOfStream(boolean z10);

        void incrementFlowControlWindows(int i10) throws Http2Exception;

        void incrementInitialStreamWindow(int i10);

        int initialWindowSize();

        void receiveFlowControlledFrame(int i10) throws Http2Exception;

        int unconsumedBytes();

        void window(int i10);

        int windowSize();

        float windowUpdateRatio();

        void windowUpdateRatio(float f10);

        boolean writeWindowUpdateIfNeeded() throws Http2Exception;
    }

    public final class WindowUpdateVisitor implements Http2StreamVisitor {
        private Http2Exception.CompositeStreamException compositeException;
        private final int delta;

        public WindowUpdateVisitor(int i10) {
            this.delta = i10;
        }

        public void throwIfError() throws Http2Exception.CompositeStreamException {
            Http2Exception.CompositeStreamException compositeStreamException = this.compositeException;
            if (compositeStreamException != null) {
                throw compositeStreamException;
            }
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            try {
                FlowState flowStateState = DefaultHttp2LocalFlowController.this.state(http2Stream);
                flowStateState.incrementFlowControlWindows(this.delta);
                flowStateState.incrementInitialStreamWindow(this.delta);
                return true;
            } catch (Http2Exception.StreamException e10) {
                if (this.compositeException == null) {
                    this.compositeException = new Http2Exception.CompositeStreamException(e10.error(), 4);
                }
                this.compositeException.add(e10);
                return true;
            }
        }
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection) {
        this(http2Connection, 0.5f, false);
    }

    private static void checkValidRatio(float f10) {
        double d10 = f10;
        if (Double.compare(d10, 0.0d) <= 0 || Double.compare(d10, 1.0d) >= 0) {
            throw new IllegalArgumentException("Invalid ratio: " + f10);
        }
    }

    private FlowState connectionState() {
        return (FlowState) this.connection.connectionStream().getProperty(this.stateKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean consumeAllBytes(FlowState flowState, int i10) throws Http2Exception {
        return connectionState().consumeBytes(i10) | flowState.consumeBytes(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isClosed(Http2Stream http2Stream) {
        return http2Stream.state() == Http2Stream.State.CLOSED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public boolean consumeBytes(Http2Stream http2Stream, int i10) throws Http2Exception {
        ObjectUtil.checkPositiveOrZero(i10, "numBytes");
        if (i10 == 0 || http2Stream == null || isClosed(http2Stream)) {
            return false;
        }
        if (http2Stream.id() != 0) {
            return consumeAllBytes(state(http2Stream), i10);
        }
        throw new UnsupportedOperationException("Returning bytes for the connection window is not supported");
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void incrementWindowSize(Http2Stream http2Stream, int i10) throws Http2Exception {
        FlowState flowStateState = state(http2Stream);
        flowStateState.incrementInitialStreamWindow(i10);
        flowStateState.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void initialWindowSize(int i10) throws Http2Exception {
        int i11 = i10 - this.initialWindowSize;
        this.initialWindowSize = i10;
        WindowUpdateVisitor windowUpdateVisitor = new WindowUpdateVisitor(i11);
        this.connection.forEachActiveStream(windowUpdateVisitor);
        windowUpdateVisitor.throwIfError();
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i10, boolean z10) throws Http2Exception {
        int i11 = byteBuf.readableBytes() + i10;
        FlowState flowStateConnectionState = connectionState();
        flowStateConnectionState.receiveFlowControlledFrame(i11);
        if (http2Stream == null || isClosed(http2Stream)) {
            if (i11 > 0) {
                flowStateConnectionState.consumeBytes(i11);
            }
        } else {
            FlowState flowStateState = state(http2Stream);
            flowStateState.endOfStream(z10);
            flowStateState.receiveFlowControlledFrame(i11);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int unconsumedBytes(Http2Stream http2Stream) {
        return state(http2Stream).unconsumedBytes();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    public void windowUpdateRatio(float f10) {
        checkValidRatio(f10);
        this.windowUpdateRatio = f10;
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection, float f10, boolean z10) {
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        windowUpdateRatio(f10);
        Http2Connection.PropertyKey propertyKeyNewKey = http2Connection.newKey();
        this.stateKey = propertyKeyNewKey;
        http2Connection.connectionStream().setProperty(propertyKeyNewKey, z10 ? new AutoRefillState(http2Connection.connectionStream(), this.initialWindowSize) : new DefaultState(http2Connection.connectionStream(), this.initialWindowSize));
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                Http2Connection.PropertyKey propertyKey = DefaultHttp2LocalFlowController.this.stateKey;
                DefaultHttp2LocalFlowController defaultHttp2LocalFlowController = DefaultHttp2LocalFlowController.this;
                http2Stream.setProperty(propertyKey, defaultHttp2LocalFlowController.new DefaultState(http2Stream, defaultHttp2LocalFlowController.initialWindowSize));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v5, types: [io.netty.handler.codec.http2.Http2Connection$PropertyKey] */
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                try {
                    try {
                        FlowState flowStateState = DefaultHttp2LocalFlowController.this.state(http2Stream);
                        int iUnconsumedBytes = flowStateState.unconsumedBytes();
                        if (DefaultHttp2LocalFlowController.this.ctx != null && iUnconsumedBytes > 0 && DefaultHttp2LocalFlowController.this.consumeAllBytes(flowStateState, iUnconsumedBytes)) {
                            DefaultHttp2LocalFlowController.this.ctx.flush();
                        }
                    } catch (Http2Exception e10) {
                        PlatformDependent.throwException(e10);
                    }
                } finally {
                    http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
                }
            }
        });
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public DefaultHttp2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    public float windowUpdateRatio() {
        return this.windowUpdateRatio;
    }

    public void windowUpdateRatio(Http2Stream http2Stream, float f10) throws Http2Exception {
        checkValidRatio(f10);
        FlowState flowStateState = state(http2Stream);
        flowStateState.windowUpdateRatio(f10);
        flowStateState.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int initialWindowSize(Http2Stream http2Stream) {
        return state(http2Stream).initialWindowSize();
    }

    public float windowUpdateRatio(Http2Stream http2Stream) throws Http2Exception {
        return state(http2Stream).windowUpdateRatio();
    }
}
