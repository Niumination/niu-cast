package io.netty.handler.codec.http2;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.hubsdk.api.provider.TranSearchIndexablesProvider;
import io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.util.internal.ObjectUtil;
import j1.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractHttp2ConnectionHandlerBuilder<T extends Http2ConnectionHandler, B extends AbstractHttp2ConnectionHandlerBuilder<T, B>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Http2HeadersEncoder.SensitivityDetector DEFAULT_HEADER_SENSITIVITY_DETECTOR = Http2HeadersEncoder.NEVER_SENSITIVE;
    private Http2Connection connection;
    private Http2ConnectionDecoder decoder;
    private boolean decoupleCloseAndGoAway;
    private Http2ConnectionEncoder encoder;
    private Boolean encoderEnforceMaxConcurrentStreams;
    private Boolean encoderIgnoreMaxHeaderListSize;
    private Http2FrameListener frameListener;
    private Http2FrameLogger frameLogger;
    private Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector;
    private Boolean isServer;
    private Integer maxReservedStreams;
    private Boolean validateHeaders;
    private Http2Settings initialSettings = Http2Settings.defaultSettings();
    private long gracefulShutdownTimeoutMillis = Http2CodecUtil.DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS;
    private boolean flushPreface = true;
    private Http2PromisedRequestVerifier promisedRequestVerifier = Http2PromisedRequestVerifier.ALWAYS_VERIFY;
    private boolean autoAckSettingsFrame = true;
    private boolean autoAckPingFrame = true;
    private int maxQueuedControlFrames = 10000;
    private int maxConsecutiveEmptyFrames = 2;
    private int maxRstFramesPerWindow = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private int secondsPerWindow = 30;

    private T buildFromCodec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        int i10;
        int iDecoderEnforceMaxConsecutiveEmptyDataFrames = decoderEnforceMaxConsecutiveEmptyDataFrames();
        if (iDecoderEnforceMaxConsecutiveEmptyDataFrames > 0) {
            http2ConnectionDecoder = new Http2EmptyDataFrameConnectionDecoder(http2ConnectionDecoder, iDecoderEnforceMaxConsecutiveEmptyDataFrames);
        }
        int i11 = this.maxRstFramesPerWindow;
        if (i11 > 0 && (i10 = this.secondsPerWindow) > 0) {
            http2ConnectionDecoder = new Http2MaxRstFrameDecoder(http2ConnectionDecoder, i11, i10);
        }
        try {
            T t10 = (T) build(http2ConnectionDecoder, http2ConnectionEncoder, this.initialSettings);
            t10.gracefulShutdownTimeoutMillis(this.gracefulShutdownTimeoutMillis);
            if (t10.decoder().frameListener() == null) {
                t10.decoder().frameListener(this.frameListener);
            }
            return t10;
        } catch (Throwable th2) {
            http2ConnectionEncoder.close();
            http2ConnectionDecoder.close();
            throw new IllegalStateException("failed to build an Http2ConnectionHandler", th2);
        }
    }

    private T buildFromConnection(Http2Connection http2Connection) {
        Http2FrameReader http2FrameReader;
        Http2ConnectionEncoder streamBufferingEncoder;
        Long lMaxHeaderListSize = this.initialSettings.maxHeaderListSize();
        DefaultHttp2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(new DefaultHttp2HeadersDecoder(isValidateHeaders(), lMaxHeaderListSize == null ? 8192L : lMaxHeaderListSize.longValue(), -1));
        Http2FrameWriter defaultHttp2FrameWriter = this.encoderIgnoreMaxHeaderListSize == null ? new DefaultHttp2FrameWriter(headerSensitivityDetector()) : new DefaultHttp2FrameWriter(headerSensitivityDetector(), this.encoderIgnoreMaxHeaderListSize.booleanValue());
        Http2FrameLogger http2FrameLogger = this.frameLogger;
        if (http2FrameLogger != null) {
            Http2InboundFrameLogger http2InboundFrameLogger = new Http2InboundFrameLogger(defaultHttp2FrameReader, http2FrameLogger);
            defaultHttp2FrameWriter = new Http2OutboundFrameLogger(defaultHttp2FrameWriter, this.frameLogger);
            http2FrameReader = http2InboundFrameLogger;
        } else {
            http2FrameReader = defaultHttp2FrameReader;
        }
        Http2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(http2Connection, defaultHttp2FrameWriter);
        boolean zEncoderEnforceMaxConcurrentStreams = encoderEnforceMaxConcurrentStreams();
        if (this.maxQueuedControlFrames != 0) {
            defaultHttp2ConnectionEncoder = new Http2ControlFrameLimitEncoder(defaultHttp2ConnectionEncoder, this.maxQueuedControlFrames);
        }
        if (!zEncoderEnforceMaxConcurrentStreams) {
            streamBufferingEncoder = defaultHttp2ConnectionEncoder;
        } else {
            if (http2Connection.isServer()) {
                defaultHttp2ConnectionEncoder.close();
                http2FrameReader.close();
                throw new IllegalArgumentException("encoderEnforceMaxConcurrentStreams: " + zEncoderEnforceMaxConcurrentStreams + " not supported for server");
            }
            streamBufferingEncoder = new StreamBufferingEncoder(defaultHttp2ConnectionEncoder);
        }
        return (T) buildFromCodec(new DefaultHttp2ConnectionDecoder(http2Connection, streamBufferingEncoder, http2FrameReader, promisedRequestVerifier(), isAutoAckSettingsFrame(), isAutoAckPingFrame()), streamBufferingEncoder);
    }

    private static void enforceConstraint(String str, String str2, Object obj) {
        if (obj == null) {
            return;
        }
        throw new IllegalStateException(str + "() cannot be called because " + str2 + "() has been called already.");
    }

    private void enforceNonCodecConstraints(String str) {
        enforceConstraint(str, "server/connection", this.decoder);
        enforceConstraint(str, "server/connection", this.encoder);
    }

    public B autoAckPingFrame(boolean z10) {
        enforceNonCodecConstraints("autoAckPingFrame");
        this.autoAckPingFrame = z10;
        return (B) self();
    }

    public B autoAckSettingsFrame(boolean z10) {
        enforceNonCodecConstraints("autoAckSettingsFrame");
        this.autoAckSettingsFrame = z10;
        return (B) self();
    }

    public T build() {
        Http2ConnectionEncoder http2ConnectionEncoder = this.encoder;
        if (http2ConnectionEncoder != null) {
            return (T) buildFromCodec(this.decoder, http2ConnectionEncoder);
        }
        Http2Connection defaultHttp2Connection = this.connection;
        if (defaultHttp2Connection == null) {
            defaultHttp2Connection = new DefaultHttp2Connection(isServer(), maxReservedStreams());
        }
        return (T) buildFromConnection(defaultHttp2Connection);
    }

    public abstract T build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) throws Exception;

    public B codec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        enforceConstraint("codec", "server", this.isServer);
        enforceConstraint("codec", "maxReservedStreams", this.maxReservedStreams);
        enforceConstraint("codec", "connection", this.connection);
        enforceConstraint("codec", "frameLogger", this.frameLogger);
        enforceConstraint("codec", "validateHeaders", this.validateHeaders);
        enforceConstraint("codec", "headerSensitivityDetector", this.headerSensitivityDetector);
        enforceConstraint("codec", "encoderEnforceMaxConcurrentStreams", this.encoderEnforceMaxConcurrentStreams);
        ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        if (http2ConnectionDecoder.connection() != http2ConnectionEncoder.connection()) {
            throw new IllegalArgumentException("The specified encoder and decoder have different connections.");
        }
        this.decoder = http2ConnectionDecoder;
        this.encoder = http2ConnectionEncoder;
        return (B) self();
    }

    public Http2Connection connection() {
        return this.connection;
    }

    public Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    public int decoderEnforceMaxConsecutiveEmptyDataFrames() {
        return this.maxConsecutiveEmptyFrames;
    }

    public B decoderEnforceMaxRstFramesPerWindow(int i10, int i11) {
        enforceNonCodecConstraints("decoderEnforceMaxRstFramesPerWindow");
        this.maxRstFramesPerWindow = ObjectUtil.checkPositiveOrZero(i10, "maxRstFramesPerWindow");
        this.secondsPerWindow = ObjectUtil.checkPositiveOrZero(i11, "secondsPerWindow");
        return (B) self();
    }

    public B decoupleCloseAndGoAway(boolean z10) {
        this.decoupleCloseAndGoAway = z10;
        return (B) self();
    }

    public Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    public boolean encoderEnforceMaxConcurrentStreams() {
        Boolean bool = this.encoderEnforceMaxConcurrentStreams;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public int encoderEnforceMaxQueuedControlFrames() {
        return this.maxQueuedControlFrames;
    }

    public B encoderIgnoreMaxHeaderListSize(boolean z10) {
        enforceNonCodecConstraints("encoderIgnoreMaxHeaderListSize");
        this.encoderIgnoreMaxHeaderListSize = Boolean.valueOf(z10);
        return (B) self();
    }

    public B flushPreface(boolean z10) {
        this.flushPreface = z10;
        return (B) self();
    }

    public Http2FrameListener frameListener() {
        return this.frameListener;
    }

    public Http2FrameLogger frameLogger() {
        return this.frameLogger;
    }

    public long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    public Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector() {
        Http2HeadersEncoder.SensitivityDetector sensitivityDetector = this.headerSensitivityDetector;
        return sensitivityDetector != null ? sensitivityDetector : DEFAULT_HEADER_SENSITIVITY_DETECTOR;
    }

    @Deprecated
    public B initialHuffmanDecodeCapacity(int i10) {
        return (B) self();
    }

    public Http2Settings initialSettings() {
        return this.initialSettings;
    }

    public boolean isAutoAckPingFrame() {
        return this.autoAckPingFrame;
    }

    public boolean isAutoAckSettingsFrame() {
        return this.autoAckSettingsFrame;
    }

    public boolean isServer() {
        Boolean bool = this.isServer;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public boolean isValidateHeaders() {
        Boolean bool = this.validateHeaders;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public int maxReservedStreams() {
        Integer num = this.maxReservedStreams;
        if (num != null) {
            return num.intValue();
        }
        return 100;
    }

    public B promisedRequestVerifier(Http2PromisedRequestVerifier http2PromisedRequestVerifier) {
        enforceNonCodecConstraints("promisedRequestVerifier");
        this.promisedRequestVerifier = (Http2PromisedRequestVerifier) ObjectUtil.checkNotNull(http2PromisedRequestVerifier, "promisedRequestVerifier");
        return (B) self();
    }

    public final B self() {
        return this;
    }

    public B server(boolean z10) {
        enforceConstraint("server", "connection", this.connection);
        enforceConstraint("server", "codec", this.decoder);
        enforceConstraint("server", "codec", this.encoder);
        this.isServer = Boolean.valueOf(z10);
        return (B) self();
    }

    public B validateHeaders(boolean z10) {
        enforceNonCodecConstraints("validateHeaders");
        this.validateHeaders = Boolean.valueOf(z10);
        return (B) self();
    }

    public B connection(Http2Connection http2Connection) {
        enforceConstraint("connection", "maxReservedStreams", this.maxReservedStreams);
        enforceConstraint("connection", "server", this.isServer);
        enforceConstraint("connection", "codec", this.decoder);
        enforceConstraint("connection", "codec", this.encoder);
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        return (B) self();
    }

    public B decoderEnforceMaxConsecutiveEmptyDataFrames(int i10) {
        enforceNonCodecConstraints("maxConsecutiveEmptyFrames");
        this.maxConsecutiveEmptyFrames = ObjectUtil.checkPositiveOrZero(i10, "maxConsecutiveEmptyFrames");
        return (B) self();
    }

    public B encoderEnforceMaxConcurrentStreams(boolean z10) {
        enforceNonCodecConstraints("encoderEnforceMaxConcurrentStreams");
        this.encoderEnforceMaxConcurrentStreams = Boolean.valueOf(z10);
        return (B) self();
    }

    public B encoderEnforceMaxQueuedControlFrames(int i10) {
        enforceNonCodecConstraints("encoderEnforceMaxQueuedControlFrames");
        this.maxQueuedControlFrames = ObjectUtil.checkPositiveOrZero(i10, "maxQueuedControlFrames");
        return (B) self();
    }

    public B frameListener(Http2FrameListener http2FrameListener) {
        this.frameListener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, "frameListener");
        return (B) self();
    }

    public B frameLogger(Http2FrameLogger http2FrameLogger) {
        enforceNonCodecConstraints("frameLogger");
        this.frameLogger = (Http2FrameLogger) ObjectUtil.checkNotNull(http2FrameLogger, "frameLogger");
        return (B) self();
    }

    public B gracefulShutdownTimeoutMillis(long j10) {
        if (j10 < -1) {
            throw new IllegalArgumentException(g.a("gracefulShutdownTimeoutMillis: ", j10, " (expected: -1 for indefinite or >= 0)"));
        }
        this.gracefulShutdownTimeoutMillis = j10;
        return (B) self();
    }

    public B headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        enforceNonCodecConstraints("headerSensitivityDetector");
        this.headerSensitivityDetector = (Http2HeadersEncoder.SensitivityDetector) ObjectUtil.checkNotNull(sensitivityDetector, "headerSensitivityDetector");
        return (B) self();
    }

    public B initialSettings(Http2Settings http2Settings) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, TranSearchIndexablesProvider.f2243v);
        return (B) self();
    }

    public B maxReservedStreams(int i10) {
        enforceConstraint("server", "connection", this.connection);
        enforceConstraint("server", "codec", this.decoder);
        enforceConstraint("server", "codec", this.encoder);
        this.maxReservedStreams = Integer.valueOf(ObjectUtil.checkPositiveOrZero(i10, "maxReservedStreams"));
        return (B) self();
    }

    public boolean decoupleCloseAndGoAway() {
        return this.decoupleCloseAndGoAway;
    }

    public boolean flushPreface() {
        return this.flushPreface;
    }

    public Http2PromisedRequestVerifier promisedRequestVerifier() {
        return this.promisedRequestVerifier;
    }
}
