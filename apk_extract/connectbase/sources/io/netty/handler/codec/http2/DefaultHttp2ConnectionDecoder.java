package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2ConnectionDecoder implements Http2ConnectionDecoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2ConnectionDecoder.class);
    private final boolean autoAckPing;
    private final Http2Connection connection;
    private final Http2Connection.PropertyKey contentLengthKey;
    private final Http2ConnectionEncoder encoder;
    private final Http2FrameReader frameReader;
    private Http2FrameListener internalFrameListener;
    private Http2LifecycleManager lifecycleManager;
    private Http2FrameListener listener;
    private final Http2PromisedRequestVerifier requestVerifier;
    private final Http2SettingsReceivedConsumer settingsReceivedConsumer;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.IDLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static final class ContentLength {
        private final long expected;
        private long seen;

        public ContentLength(long j10) {
            this.expected = j10;
        }

        public void increaseReceivedBytes(boolean z10, int i10, int i11, boolean z11) throws Http2Exception {
            long j10 = this.seen + ((long) i11);
            this.seen = j10;
            if (j10 < 0) {
                throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Received amount of data did overflow and so not match content-length header %d", Long.valueOf(this.expected));
            }
            long j11 = this.expected;
            if (j10 > j11) {
                throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Received amount of data %d does not match content-length header %d", Long.valueOf(j10), Long.valueOf(this.expected));
            }
            if (z11) {
                if ((j10 != 0 || z10) && j11 > j10) {
                    throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Received amount of data %d does not match content-length header %d", Long.valueOf(j10), Long.valueOf(this.expected));
                }
            }
        }
    }

    public final class FrameReadListener implements Http2FrameListener {
        private FrameReadListener() {
        }

        private void applyLocalSettings(Http2Settings http2Settings) throws Http2Exception {
            Boolean boolPushEnabled = http2Settings.pushEnabled();
            Http2FrameReader.Configuration configuration = DefaultHttp2ConnectionDecoder.this.frameReader.configuration();
            Http2HeadersDecoder.Configuration configurationHeadersConfiguration = configuration.headersConfiguration();
            Http2FrameSizePolicy http2FrameSizePolicyFrameSizePolicy = configuration.frameSizePolicy();
            if (boolPushEnabled != null) {
                if (DefaultHttp2ConnectionDecoder.this.connection.isServer()) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
                }
                DefaultHttp2ConnectionDecoder.this.connection.local().allowPushTo(boolPushEnabled.booleanValue());
            }
            Long lMaxConcurrentStreams = http2Settings.maxConcurrentStreams();
            if (lMaxConcurrentStreams != null) {
                DefaultHttp2ConnectionDecoder.this.connection.remote().maxActiveStreams((int) Math.min(lMaxConcurrentStreams.longValue(), 2147483647L));
            }
            Long lHeaderTableSize = http2Settings.headerTableSize();
            if (lHeaderTableSize != null) {
                configurationHeadersConfiguration.maxHeaderTableSize(lHeaderTableSize.longValue());
            }
            Long lMaxHeaderListSize = http2Settings.maxHeaderListSize();
            if (lMaxHeaderListSize != null) {
                configurationHeadersConfiguration.maxHeaderListSize(lMaxHeaderListSize.longValue(), DefaultHttp2ConnectionDecoder.this.calculateMaxHeaderListSizeGoAway(lMaxHeaderListSize.longValue()));
            }
            Integer numMaxFrameSize = http2Settings.maxFrameSize();
            if (numMaxFrameSize != null) {
                http2FrameSizePolicyFrameSizePolicy.maxFrameSize(numMaxFrameSize.intValue());
            }
            Integer numInitialWindowSize = http2Settings.initialWindowSize();
            if (numInitialWindowSize != null) {
                DefaultHttp2ConnectionDecoder.this.flowController().initialWindowSize(numInitialWindowSize.intValue());
            }
        }

        private boolean shouldIgnoreHeadersOrDataFrame(ChannelHandlerContext channelHandlerContext, int i10, Http2Stream http2Stream, String str) throws Http2Exception {
            String str2;
            if (http2Stream == null) {
                if (streamCreatedAfterGoAwaySent(i10)) {
                    DefaultHttp2ConnectionDecoder.logger.info("{} ignoring {} frame for stream {}. Stream sent after GOAWAY sent", channelHandlerContext.channel(), str, Integer.valueOf(i10));
                    return true;
                }
                verifyStreamMayHaveExisted(i10);
                throw Http2Exception.streamError(i10, Http2Error.STREAM_CLOSED, "Received %s frame for an unknown stream %d", str, Integer.valueOf(i10));
            }
            if (!http2Stream.isResetSent() && !streamCreatedAfterGoAwaySent(i10)) {
                return false;
            }
            if (DefaultHttp2ConnectionDecoder.logger.isInfoEnabled()) {
                InternalLogger internalLogger = DefaultHttp2ConnectionDecoder.logger;
                Channel channel = channelHandlerContext.channel();
                if (http2Stream.isResetSent()) {
                    str2 = "RST_STREAM sent.";
                } else {
                    str2 = "Stream created after GOAWAY sent. Last known stream by peer " + DefaultHttp2ConnectionDecoder.this.connection.remote().lastStreamKnownByPeer();
                }
                internalLogger.info("{} ignoring {} frame for stream {}", channel, str, str2);
            }
            return true;
        }

        private boolean streamCreatedAfterGoAwaySent(int i10) {
            Http2Connection.Endpoint<Http2RemoteFlowController> endpointRemote = DefaultHttp2ConnectionDecoder.this.connection.remote();
            return DefaultHttp2ConnectionDecoder.this.connection.goAwaySent() && endpointRemote.isValidStreamId(i10) && i10 > endpointRemote.lastStreamKnownByPeer();
        }

        private void verifyStreamMayHaveExisted(int i10) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i10)) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", Integer.valueOf(i10));
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
            Http2Exception http2ExceptionStreamError;
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i10);
            Http2LocalFlowController http2LocalFlowControllerFlowController = DefaultHttp2ConnectionDecoder.this.flowController();
            int i12 = byteBuf.readableBytes();
            int i13 = i12 + i11;
            try {
                if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i10, http2StreamStream, "DATA")) {
                    http2LocalFlowControllerFlowController.receiveFlowControlledFrame(http2StreamStream, byteBuf, i11, z10);
                    http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, i13);
                    verifyStreamMayHaveExisted(i10);
                    return i13;
                }
                int i14 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamStream.state().ordinal()];
                if (i14 == 1 || i14 == 2) {
                    http2ExceptionStreamError = null;
                } else {
                    http2ExceptionStreamError = (i14 == 3 || i14 == 4) ? Http2Exception.streamError(http2StreamStream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2StreamStream.id()), http2StreamStream.state()) : Http2Exception.streamError(http2StreamStream.id(), Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(http2StreamStream.id()), http2StreamStream.state());
                }
                int iUnconsumedBytes = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream);
                try {
                    try {
                        http2LocalFlowControllerFlowController.receiveFlowControlledFrame(http2StreamStream, byteBuf, i11, z10);
                        int iUnconsumedBytes2 = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream);
                        try {
                            if (http2ExceptionStreamError != null) {
                                throw http2ExceptionStreamError;
                            }
                            DefaultHttp2ConnectionDecoder.this.verifyContentLength(http2StreamStream, i12, z10);
                            int iOnDataRead = DefaultHttp2ConnectionDecoder.this.listener.onDataRead(channelHandlerContext, i10, byteBuf, i11, z10);
                            if (z10) {
                                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(http2StreamStream, channelHandlerContext.newSucceededFuture());
                            }
                            http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, iOnDataRead);
                            return iOnDataRead;
                        } catch (Http2Exception e10) {
                            e = e10;
                            iUnconsumedBytes = iUnconsumedBytes2;
                            int iUnconsumedBytes3 = i13 - (iUnconsumedBytes - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream));
                            throw e;
                        } catch (RuntimeException e11) {
                            e = e11;
                            iUnconsumedBytes = iUnconsumedBytes2;
                            int iUnconsumedBytes4 = i13 - (iUnconsumedBytes - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(http2StreamStream));
                            throw e;
                        }
                    } catch (Throwable th2) {
                        http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, i13);
                        throw th2;
                    }
                } catch (Http2Exception e12) {
                    e = e12;
                } catch (RuntimeException e13) {
                    e = e13;
                }
            } catch (Http2Exception e14) {
                http2LocalFlowControllerFlowController.receiveFlowControlledFrame(http2StreamStream, byteBuf, i11, z10);
                http2LocalFlowControllerFlowController.consumeBytes(http2StreamStream, i13);
                throw e14;
            } catch (Throwable th3) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th3, "Unhandled error on data stream id %d", Integer.valueOf(i10));
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i10, j10, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10) throws Http2Exception {
            onHeadersRead(channelHandlerContext, i10, http2Headers, 0, (short) 16, false, i11, z10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.listener.onPingAckRead(channelHandlerContext, j10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.autoAckPing) {
                DefaultHttp2ConnectionDecoder.this.encoder.writePing(channelHandlerContext, true, j10, channelHandlerContext.newPromise());
            }
            DefaultHttp2ConnectionDecoder.this.listener.onPingRead(channelHandlerContext, j10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(i10, i11, s10, z10);
            DefaultHttp2ConnectionDecoder.this.listener.onPriorityRead(channelHandlerContext, i10, i11, s10, z10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.connection().isServer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A client cannot push.", new Object[0]);
            }
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i10);
            if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i10, http2StreamStream, "PUSH_PROMISE")) {
                return;
            }
            int i13 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamStream.state().ordinal()];
            if (i13 != 1 && i13 != 2) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state for receiving push promise: %s", Integer.valueOf(http2StreamStream.id()), http2StreamStream.state());
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isAuthoritative(channelHandlerContext, http2Headers)) {
                throw Http2Exception.streamError(i11, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not authoritative", Integer.valueOf(i10), Integer.valueOf(i11));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isCacheable(http2Headers)) {
                throw Http2Exception.streamError(i11, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be cacheable", Integer.valueOf(i10), Integer.valueOf(i11));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isSafe(http2Headers)) {
                throw Http2Exception.streamError(i11, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be safe", Integer.valueOf(i10), Integer.valueOf(i11));
            }
            DefaultHttp2ConnectionDecoder.this.connection.remote().reservePushStream(i11, http2StreamStream);
            DefaultHttp2ConnectionDecoder.this.listener.onPushPromiseRead(channelHandlerContext, i10, i11, http2Headers, i12);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception {
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i10);
            if (http2StreamStream == null) {
                verifyStreamMayHaveExisted(i10);
                return;
            }
            int i11 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2StreamStream.state().ordinal()];
            if (i11 != 4) {
                if (i11 == 6) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "RST_STREAM received for IDLE stream %d", Integer.valueOf(i10));
                }
                DefaultHttp2ConnectionDecoder.this.listener.onRstStreamRead(channelHandlerContext, i10, j10);
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStream(http2StreamStream, channelHandlerContext.newSucceededFuture());
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            Http2Settings http2SettingsPollSentSettings = DefaultHttp2ConnectionDecoder.this.encoder.pollSentSettings();
            if (http2SettingsPollSentSettings != null) {
                applyLocalSettings(http2SettingsPollSentSettings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer == null) {
                DefaultHttp2ConnectionDecoder.this.encoder.writeSettingsAck(channelHandlerContext, channelHandlerContext.newPromise());
                DefaultHttp2ConnectionDecoder.this.encoder.remoteSettings(http2Settings);
            } else {
                DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer.consumeReceivedSettings(http2Settings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b10, i10, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i10, int i11) throws Http2Exception {
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i10);
            if (http2StreamStream == null || http2StreamStream.state() == Http2Stream.State.CLOSED || streamCreatedAfterGoAwaySent(i10)) {
                verifyStreamMayHaveExisted(i10);
            } else {
                DefaultHttp2ConnectionDecoder.this.encoder.flowController().incrementWindowSize(http2StreamStream, i11);
                DefaultHttp2ConnectionDecoder.this.listener.onWindowUpdateRead(channelHandlerContext, i10, i11);
            }
        }

        public /* synthetic */ FrameReadListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception {
            Http2Stream http2Stream;
            boolean zIsHeadersReceived;
            boolean z12;
            AsciiString asciiString;
            List<CharSequence> all;
            Http2Stream http2StreamStream = DefaultHttp2ConnectionDecoder.this.connection.stream(i10);
            if (http2StreamStream == null && !DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i10)) {
                Http2Stream http2StreamCreateStream = DefaultHttp2ConnectionDecoder.this.connection.remote().createStream(i10, z11);
                z12 = http2StreamCreateStream.state() == Http2Stream.State.HALF_CLOSED_REMOTE;
                http2Stream = http2StreamCreateStream;
                zIsHeadersReceived = false;
            } else if (http2StreamStream != null) {
                http2Stream = http2StreamStream;
                zIsHeadersReceived = http2StreamStream.isHeadersReceived();
                z12 = false;
            } else {
                http2Stream = http2StreamStream;
                zIsHeadersReceived = false;
                z12 = false;
            }
            if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i10, http2Stream, "HEADERS")) {
                return;
            }
            boolean z13 = !DefaultHttp2ConnectionDecoder.this.connection.isServer() && HttpStatusClass.valueOf(http2Headers.status()) == HttpStatusClass.INFORMATIONAL;
            if (((z13 || !z11) && http2Stream.isHeadersReceived()) || http2Stream.isTrailersReceived()) {
                throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Stream %d received too many headers EOS: %s state: %s", Integer.valueOf(i10), Boolean.valueOf(z11), http2Stream.state());
            }
            int i13 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
            if (i13 != 1 && i13 != 2) {
                if (i13 != 3) {
                    if (i13 == 4) {
                        throw Http2Exception.streamError(http2Stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.id()), http2Stream.state());
                    }
                    if (i13 != 5) {
                        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.id()), http2Stream.state());
                    }
                    http2Stream.open(z11);
                } else if (!z12) {
                    throw Http2Exception.streamError(http2Stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.id()), http2Stream.state());
                }
            }
            if (!zIsHeadersReceived && (all = http2Headers.getAll((asciiString = HttpHeaderNames.CONTENT_LENGTH))) != null && !all.isEmpty()) {
                try {
                    long jNormalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, false, true);
                    if (jNormalizeAndGetContentLength != -1) {
                        http2Headers.setLong(asciiString, jNormalizeAndGetContentLength);
                        http2Stream.setProperty(DefaultHttp2ConnectionDecoder.this.contentLengthKey, new ContentLength(jNormalizeAndGetContentLength));
                    }
                } catch (IllegalArgumentException e10) {
                    throw Http2Exception.streamError(http2Stream.id(), Http2Error.PROTOCOL_ERROR, e10, "Multiple content-length headers received", new Object[0]);
                }
            }
            http2Stream.headersReceived(z13);
            DefaultHttp2ConnectionDecoder.this.verifyContentLength(http2Stream, 0, z11);
            DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(i10, i11, s10, z10);
            DefaultHttp2ConnectionDecoder.this.listener.onHeadersRead(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11);
            if (z11) {
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(http2Stream, channelHandlerContext.newSucceededFuture());
            }
        }
    }

    public final class PrefaceFrameListener implements Http2FrameListener {
        private PrefaceFrameListener() {
        }

        private void verifyPrefaceReceived() throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received non-SETTINGS as first frame.", new Object[0]);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
            verifyPrefaceReceived();
            return DefaultHttp2ConnectionDecoder.this.internalFrameListener.onDataRead(channelHandlerContext, i10, byteBuf, i11, z10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i10, j10, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i10, http2Headers, i11, z10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingAckRead(channelHandlerContext, j10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingRead(channelHandlerContext, j10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPriorityRead(channelHandlerContext, i10, i11, s10, z10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPushPromiseRead(channelHandlerContext, i10, i11, http2Headers, i12);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onRstStreamRead(channelHandlerContext, i10, j10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = DefaultHttp2ConnectionDecoder.this;
                defaultHttp2ConnectionDecoder.internalFrameListener = new FrameReadListener(defaultHttp2ConnectionDecoder, null);
            }
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b10, i10, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i10, int i11) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onWindowUpdateRead(channelHandlerContext, i10, i11);
        }

        public /* synthetic */ PrefaceFrameListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11);
        }
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, Http2PromisedRequestVerifier.ALWAYS_VERIFY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int unconsumedBytes(Http2Stream http2Stream) {
        return flowController().unconsumedBytes(http2Stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyContentLength(Http2Stream http2Stream, int i10, boolean z10) throws Http2Exception {
        ContentLength contentLength = (ContentLength) http2Stream.getProperty(this.contentLengthKey);
        if (contentLength != null) {
            try {
                contentLength.increaseReceivedBytes(this.connection.isServer(), http2Stream.id(), i10, z10);
            } finally {
                if (z10) {
                    http2Stream.removeProperty(this.contentLengthKey);
                }
            }
        }
    }

    public long calculateMaxHeaderListSizeGoAway(long j10) {
        return Http2CodecUtil.calculateMaxHeaderListSizeGoAway(j10);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frameReader.close();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Connection connection() {
        return this.connection;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Http2Exception {
        this.frameReader.readFrame(channelHandlerContext, byteBuf, this.internalFrameListener);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public final Http2LocalFlowController flowController() {
        return (Http2LocalFlowController) this.connection.local().flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void frameListener(Http2FrameListener http2FrameListener) {
        this.listener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, "listener");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Settings localSettings() {
        Http2Settings http2Settings = new Http2Settings();
        Http2FrameReader.Configuration configuration = this.frameReader.configuration();
        Http2HeadersDecoder.Configuration configurationHeadersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy http2FrameSizePolicyFrameSizePolicy = configuration.frameSizePolicy();
        http2Settings.initialWindowSize(flowController().initialWindowSize());
        http2Settings.maxConcurrentStreams(this.connection.remote().maxActiveStreams());
        http2Settings.headerTableSize(configurationHeadersConfiguration.maxHeaderTableSize());
        http2Settings.maxFrameSize(http2FrameSizePolicyFrameSizePolicy.maxFrameSize());
        http2Settings.maxHeaderListSize(configurationHeadersConfiguration.maxHeaderListSize());
        if (!this.connection.isServer()) {
            http2Settings.pushEnabled(this.connection.local().allowPushTo());
        }
        return http2Settings;
    }

    public void onGoAwayRead0(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onGoAwayRead(channelHandlerContext, i10, j10, byteBuf);
        this.connection.goAwayReceived(i10, j10, byteBuf);
    }

    public void onUnknownFrame0(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onUnknownFrame(channelHandlerContext, b10, i10, http2Flags, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public boolean prefaceReceived() {
        return FrameReadListener.class == this.internalFrameListener.getClass();
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, true);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2FrameListener frameListener() {
        return this.listener;
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z10) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, z10, true);
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z10, boolean z11) {
        this.internalFrameListener = new PrefaceFrameListener(this, null);
        this.autoAckPing = z11;
        if (z10) {
            this.settingsReceivedConsumer = null;
        } else if (http2ConnectionEncoder instanceof Http2SettingsReceivedConsumer) {
            this.settingsReceivedConsumer = (Http2SettingsReceivedConsumer) http2ConnectionEncoder;
        } else {
            throw new IllegalArgumentException("disabling autoAckSettings requires the encoder to be a " + Http2SettingsReceivedConsumer.class);
        }
        Http2Connection http2Connection2 = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.connection = http2Connection2;
        this.contentLengthKey = http2Connection2.newKey();
        this.frameReader = (Http2FrameReader) ObjectUtil.checkNotNull(http2FrameReader, "frameReader");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.requestVerifier = (Http2PromisedRequestVerifier) ObjectUtil.checkNotNull(http2PromisedRequestVerifier, "requestVerifier");
        if (http2Connection.local().flowController() == null) {
            http2Connection.local().flowController(new DefaultHttp2LocalFlowController(http2Connection));
        }
        ((Http2LocalFlowController) http2Connection.local().flowController()).frameWriter(http2ConnectionEncoder.frameWriter());
    }
}
