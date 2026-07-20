package io.netty.handler.codec.http2;

import h.a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.CoalescingBufferQueue;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2ConnectionEncoder implements Http2ConnectionEncoder, Http2SettingsReceivedConsumer {
    private final Http2Connection connection;
    private final Http2FrameWriter frameWriter;
    private Http2LifecycleManager lifecycleManager;
    private final Queue<Http2Settings> outstandingLocalSettingsQueue = new ArrayDeque(4);
    private Queue<Http2Settings> outstandingRemoteSettingsQueue;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract class FlowControlledBase implements Http2RemoteFlowController.FlowControlled, ChannelFutureListener {
        protected boolean endOfStream;
        protected int padding;
        protected ChannelPromise promise;
        protected final Http2Stream stream;

        public FlowControlledBase(Http2Stream http2Stream, int i10, boolean z10, ChannelPromise channelPromise) {
            ObjectUtil.checkPositiveOrZero(i10, "padding");
            this.padding = i10;
            this.endOfStream = z10;
            this.stream = http2Stream;
            this.promise = channelPromise;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void writeComplete() {
            if (this.endOfStream) {
                DefaultHttp2ConnectionEncoder.this.lifecycleManager.closeStreamLocal(this.stream, this.promise);
            }
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            error(DefaultHttp2ConnectionEncoder.this.flowController().channelHandlerContext(), channelFuture.cause());
        }
    }

    public final class FlowControlledData extends FlowControlledBase {
        private int dataSize;
        private final CoalescingBufferQueue queue;

        public FlowControlledData(Http2Stream http2Stream, ByteBuf byteBuf, int i10, boolean z10, ChannelPromise channelPromise) {
            super(http2Stream, i10, z10, channelPromise);
            CoalescingBufferQueue coalescingBufferQueue = new CoalescingBufferQueue(channelPromise.channel());
            this.queue = coalescingBufferQueue;
            coalescingBufferQueue.add(byteBuf, channelPromise);
            this.dataSize = coalescingBufferQueue.readableBytes();
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void error(ChannelHandlerContext channelHandlerContext, Throwable th2) {
            this.queue.releaseAndFailAll(th2);
            DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, th2);
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            if (FlowControlledData.class != flowControlled.getClass()) {
                return false;
            }
            FlowControlledData flowControlledData = (FlowControlledData) flowControlled;
            if (Integer.MAX_VALUE - flowControlledData.size() < size()) {
                return false;
            }
            flowControlledData.queue.copyTo(this.queue);
            this.dataSize = this.queue.readableBytes();
            this.padding = Math.max(this.padding, flowControlledData.padding);
            this.endOfStream = flowControlledData.endOfStream;
            return true;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public int size() {
            return this.dataSize + this.padding;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v10, types: [io.netty.channel.ChannelPromise] */
        /* JADX WARN: Type inference failed for: r9v0, types: [io.netty.channel.ChannelPromise] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void write(ChannelHandlerContext channelHandlerContext, int i10) {
            int i11 = this.queue.readableBytes();
            boolean z10 = false;
            if (!this.endOfStream) {
                if (i11 == 0) {
                    if (this.queue.isEmpty()) {
                        this.dataSize = 0;
                        this.padding = 0;
                        return;
                    } else {
                        ?? AddListener = channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
                        channelHandlerContext.write(this.queue.remove(0, AddListener), AddListener);
                        return;
                    }
                }
                if (i10 == 0) {
                    return;
                }
            }
            int iMin = Math.min(i11, i10);
            ?? AddListener2 = channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
            ByteBuf byteBufRemove = this.queue.remove(iMin, AddListener2);
            this.dataSize = this.queue.readableBytes();
            int iMin2 = Math.min(i10 - iMin, this.padding);
            this.padding -= iMin2;
            Http2FrameWriter http2FrameWriterFrameWriter = DefaultHttp2ConnectionEncoder.this.frameWriter();
            int iId = this.stream.id();
            if (this.endOfStream && size() == 0) {
                z10 = true;
            }
            http2FrameWriterFrameWriter.writeData(channelHandlerContext, iId, byteBufRemove, iMin2, z10, AddListener2);
        }
    }

    public final class FlowControlledHeaders extends FlowControlledBase {
        private final boolean exclusive;
        private final boolean hasPriority;
        private final Http2Headers headers;
        private final int streamDependency;
        private final short weight;

        public FlowControlledHeaders(Http2Stream http2Stream, Http2Headers http2Headers, boolean z10, int i10, short s10, boolean z11, int i11, boolean z12, ChannelPromise channelPromise) {
            super(http2Stream, i11, z12, channelPromise.unvoid());
            this.headers = http2Headers;
            this.hasPriority = z10;
            this.streamDependency = i10;
            this.weight = s10;
            this.exclusive = z11;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void error(ChannelHandlerContext channelHandlerContext, Throwable th2) {
            if (channelHandlerContext != null) {
                DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, th2);
            }
            this.promise.tryFailure(th2);
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public int size() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.FlowControlled
        public void write(ChannelHandlerContext channelHandlerContext, int i10) {
            boolean zValidateHeadersSentState = DefaultHttp2ConnectionEncoder.validateHeadersSentState(this.stream, this.headers, DefaultHttp2ConnectionEncoder.this.connection.isServer(), this.endOfStream);
            this.promise.addListener((GenericFutureListener<? extends Future<? super Void>>) this);
            if (DefaultHttp2ConnectionEncoder.sendHeaders(DefaultHttp2ConnectionEncoder.this.frameWriter, channelHandlerContext, this.stream.id(), this.headers, this.hasPriority, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise).cause() == null) {
                this.stream.headersSent(zValidateHeadersSentState);
            }
        }
    }

    public DefaultHttp2ConnectionEncoder(Http2Connection http2Connection, Http2FrameWriter http2FrameWriter) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        if (http2Connection.remote().flowController() == null) {
            http2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(http2Connection));
        }
    }

    private void notifyLifecycleManagerOnError(ChannelFuture channelFuture, final ChannelHandlerContext channelHandlerContext) {
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                Throwable thCause = channelFuture2.cause();
                if (thCause != null) {
                    DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, thCause);
                }
            }
        });
    }

    private Http2Stream requireStream(int i10) {
        Http2Stream http2StreamStream = this.connection.stream(i10);
        if (http2StreamStream == null) {
            throw new IllegalArgumentException(this.connection.streamMayHaveExisted(i10) ? a.a("Stream no longer exists: ", i10) : a.a("Stream does not exist: ", i10));
        }
        return http2StreamStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChannelFuture sendHeaders(Http2FrameWriter http2FrameWriter, ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, boolean z10, int i11, short s10, boolean z11, int i12, boolean z12, ChannelPromise channelPromise) {
        return z10 ? http2FrameWriter.writeHeaders(channelHandlerContext, i10, http2Headers, i11, s10, z11, i12, z12, channelPromise) : http2FrameWriter.writeHeaders(channelHandlerContext, i10, http2Headers, i12, z12, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateHeadersSentState(Http2Stream http2Stream, Http2Headers http2Headers, boolean z10, boolean z11) {
        boolean z12 = z10 && HttpStatusClass.valueOf(http2Headers.status()) == HttpStatusClass.INFORMATIONAL;
        if (((!z12 && z11) || !http2Stream.isHeadersSent()) && !http2Stream.isTrailersSent()) {
            return z12;
        }
        throw new IllegalStateException("Stream " + http2Stream.id() + " sent too many headers EOS: " + z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.netty.handler.codec.http2.Http2LifecycleManager] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.netty.channel.ChannelHandlerContext] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private ChannelFuture writeHeaders0(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, boolean z10, int i11, short s10, boolean z11, int i12, boolean z12, ChannelPromise channelPromise) {
        ?? r10;
        ChannelHandlerContext channelHandlerContext2;
        ChannelPromise channelPromiseUnvoid = channelPromise;
        try {
            Http2Stream http2StreamStream = this.connection.stream(i10);
            if (http2StreamStream == null) {
                try {
                    http2StreamStream = this.connection.local().createStream(i10, false);
                } catch (Http2Exception e10) {
                    if (!this.connection.remote().mayHaveCreatedStream(i10)) {
                        throw e10;
                    }
                    channelPromiseUnvoid.tryFailure(new IllegalStateException("Stream no longer exists: " + i10, e10));
                    return channelPromiseUnvoid;
                }
            } else {
                int i13 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamStream.state().ordinal()];
                if (i13 != 1 && i13 != 2) {
                    if (i13 != 3) {
                        throw new IllegalStateException("Stream " + http2StreamStream.id() + " in unexpected state " + http2StreamStream.state());
                    }
                    http2StreamStream.open(z12);
                }
            }
            Http2Stream http2Stream = http2StreamStream;
            Http2RemoteFlowController http2RemoteFlowControllerFlowController = flowController();
            if (z12) {
                try {
                    if (http2RemoteFlowControllerFlowController.hasFlowControlled(http2Stream)) {
                        http2RemoteFlowControllerFlowController.addFlowControlled(http2Stream, new FlowControlledHeaders(http2Stream, http2Headers, z10, i11, s10, z11, i12, true, channelPromise));
                        return channelPromiseUnvoid;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r10 = channelHandlerContext;
                    this.lifecycleManager.onError(r10, true, th);
                    channelPromiseUnvoid.tryFailure(th);
                    return channelPromiseUnvoid;
                }
            }
            channelPromiseUnvoid = channelPromise.unvoid();
            boolean zValidateHeadersSentState = validateHeadersSentState(http2Stream, http2Headers, this.connection.isServer(), z12);
            ?? r11 = i10;
            ChannelFuture channelFutureSendHeaders = sendHeaders(this.frameWriter, channelHandlerContext, r11 == true ? 1 : 0, http2Headers, z10, i11, s10, z11, i12, z12, channelPromiseUnvoid);
            Throwable thCause = channelFutureSendHeaders.cause();
            try {
                if (thCause == null) {
                    http2Stream.headersSent(zValidateHeadersSentState);
                    if (channelFutureSendHeaders.isSuccess()) {
                        r11 = channelHandlerContext;
                    } else {
                        ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                        notifyLifecycleManagerOnError(channelFutureSendHeaders, channelHandlerContext3);
                        r11 = channelHandlerContext3;
                    }
                } else {
                    channelHandlerContext2 = channelHandlerContext;
                    this.lifecycleManager.onError(channelHandlerContext2, true, thCause);
                }
                if (z12) {
                    r11 = channelHandlerContext2;
                    this.lifecycleManager.closeStreamLocal(http2Stream, channelFutureSendHeaders);
                }
                r11 = channelHandlerContext2;
                return channelFutureSendHeaders;
            } catch (Throwable th3) {
                th = th3;
                r10 = r11;
                this.lifecycleManager.onError(r10, true, th);
                channelPromiseUnvoid.tryFailure(th);
                return channelPromiseUnvoid;
            }
        } catch (Throwable th4) {
            th = th4;
            r10 = channelHandlerContext;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frameWriter.close();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this.frameWriter.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Connection connection() {
        return this.connection;
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsReceivedConsumer
    public void consumeReceivedSettings(Http2Settings http2Settings) {
        if (this.outstandingRemoteSettingsQueue == null) {
            this.outstandingRemoteSettingsQueue = new ArrayDeque(2);
        }
        this.outstandingRemoteSettingsQueue.add(http2Settings);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public final Http2RemoteFlowController flowController() {
        return (Http2RemoteFlowController) connection().remote().flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2FrameWriter frameWriter() {
        return this.frameWriter;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Settings pollSentSettings() {
        return this.outstandingLocalSettingsQueue.poll();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        Boolean boolPushEnabled = http2Settings.pushEnabled();
        Http2FrameWriter.Configuration configuration = configuration();
        Http2HeadersEncoder.Configuration configurationHeadersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy http2FrameSizePolicyFrameSizePolicy = configuration.frameSizePolicy();
        if (boolPushEnabled != null) {
            if (!this.connection.isServer() && boolPushEnabled.booleanValue()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client received a value of ENABLE_PUSH specified to other than 0", new Object[0]);
            }
            this.connection.remote().allowPushTo(boolPushEnabled.booleanValue());
        }
        Long lMaxConcurrentStreams = http2Settings.maxConcurrentStreams();
        if (lMaxConcurrentStreams != null) {
            this.connection.local().maxActiveStreams((int) Math.min(lMaxConcurrentStreams.longValue(), 2147483647L));
        }
        Long lHeaderTableSize = http2Settings.headerTableSize();
        if (lHeaderTableSize != null) {
            configurationHeadersConfiguration.maxHeaderTableSize(lHeaderTableSize.longValue());
        }
        Long lMaxHeaderListSize = http2Settings.maxHeaderListSize();
        if (lMaxHeaderListSize != null) {
            configurationHeadersConfiguration.maxHeaderListSize(lMaxHeaderListSize.longValue());
        }
        Integer numMaxFrameSize = http2Settings.maxFrameSize();
        if (numMaxFrameSize != null) {
            http2FrameSizePolicyFrameSizePolicy.maxFrameSize(numMaxFrameSize.intValue());
        }
        Integer numInitialWindowSize = http2Settings.initialWindowSize();
        if (numInitialWindowSize != null) {
            flowController().initialWindowSize(numInitialWindowSize.intValue());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10, ChannelPromise channelPromise) {
        ChannelPromise channelPromiseUnvoid = channelPromise.unvoid();
        try {
            Http2Stream http2StreamRequireStream = requireStream(i10);
            int i12 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamRequireStream.state().ordinal()];
            if (i12 != 1 && i12 != 2) {
                throw new IllegalStateException("Stream " + http2StreamRequireStream.id() + " in unexpected state " + http2StreamRequireStream.state());
            }
            flowController().addFlowControlled(http2StreamRequireStream, new FlowControlledData(http2StreamRequireStream, byteBuf, i11, z10, channelPromiseUnvoid));
            return channelPromiseUnvoid;
        } catch (Throwable th2) {
            byteBuf.release();
            return channelPromiseUnvoid.setFailure(th2);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.frameWriter.writeFrame(channelHandlerContext, b10, i10, http2Flags, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.lifecycleManager.goAway(channelHandlerContext, i10, j10, byteBuf, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, ChannelPromise channelPromise) {
        return writeHeaders0(channelHandlerContext, i10, http2Headers, false, 0, (short) 0, false, i11, z10, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z10, long j10, ChannelPromise channelPromise) {
        return this.frameWriter.writePing(channelHandlerContext, z10, j10, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10, ChannelPromise channelPromise) {
        return this.frameWriter.writePriority(channelHandlerContext, i10, i11, s10, z10, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12, ChannelPromise channelPromise) {
        ChannelPromise channelPromiseUnvoid;
        try {
            if (this.connection.goAwayReceived()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Sending PUSH_PROMISE after GO_AWAY received.", new Object[0]);
            }
            Http2Stream http2StreamRequireStream = requireStream(i10);
            this.connection.local().reservePushStream(i11, http2StreamRequireStream);
            channelPromiseUnvoid = channelPromise.unvoid();
            try {
                ChannelFuture channelFutureWritePushPromise = this.frameWriter.writePushPromise(channelHandlerContext, i10, i11, http2Headers, i12, channelPromiseUnvoid);
                Throwable thCause = channelFutureWritePushPromise.cause();
                if (thCause == null) {
                    http2StreamRequireStream.pushPromiseSent();
                    if (!channelFutureWritePushPromise.isSuccess()) {
                        notifyLifecycleManagerOnError(channelFutureWritePushPromise, channelHandlerContext);
                    }
                } else {
                    this.lifecycleManager.onError(channelHandlerContext, true, thCause);
                }
                return channelFutureWritePushPromise;
            } catch (Throwable th2) {
                th = th2;
                this.lifecycleManager.onError(channelHandlerContext, true, th);
                channelPromiseUnvoid.tryFailure(th);
                return channelPromiseUnvoid;
            }
        } catch (Throwable th3) {
            th = th3;
            channelPromiseUnvoid = channelPromise;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i10, long j10, ChannelPromise channelPromise) {
        return this.lifecycleManager.resetStream(channelHandlerContext, i10, j10, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        this.outstandingLocalSettingsQueue.add(http2Settings);
        try {
            if (http2Settings.pushEnabled() != null && this.connection.isServer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
            }
            return this.frameWriter.writeSettings(channelHandlerContext, http2Settings, channelPromise);
        } catch (Throwable th2) {
            return channelPromise.setFailure(th2);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        Queue<Http2Settings> queue = this.outstandingRemoteSettingsQueue;
        if (queue == null) {
            return this.frameWriter.writeSettingsAck(channelHandlerContext, channelPromise);
        }
        Http2Settings http2SettingsPoll = queue.poll();
        if (http2SettingsPoll == null) {
            return channelPromise.setFailure((Throwable) new Http2Exception(Http2Error.INTERNAL_ERROR, "attempted to write a SETTINGS ACK with no  pending SETTINGS"));
        }
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        this.frameWriter.writeSettingsAck(channelHandlerContext, simpleChannelPromiseAggregator.newPromise());
        ChannelPromise channelPromiseNewPromise = simpleChannelPromiseAggregator.newPromise();
        try {
            remoteSettings(http2SettingsPoll);
            channelPromiseNewPromise.setSuccess();
        } catch (Throwable th2) {
            channelPromiseNewPromise.setFailure(th2);
            this.lifecycleManager.onError(channelHandlerContext, true, th2);
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i10, int i11, ChannelPromise channelPromise) {
        return channelPromise.setFailure((Throwable) new UnsupportedOperationException("Use the Http2[Inbound|Outbound]FlowController objects to control window sizes"));
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11, ChannelPromise channelPromise) {
        return writeHeaders0(channelHandlerContext, i10, http2Headers, true, i11, s10, z10, i12, z11, channelPromise);
    }
}
