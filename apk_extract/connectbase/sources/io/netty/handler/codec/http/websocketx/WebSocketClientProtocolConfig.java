package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.ObjectUtil;
import java.net.URI;

/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketClientProtocolConfig {
    static final boolean DEFAULT_ALLOW_MASK_MISMATCH = false;
    static final boolean DEFAULT_DROP_PONG_FRAMES = true;
    static final boolean DEFAULT_GENERATE_ORIGIN_HEADER = true;
    static final boolean DEFAULT_HANDLE_CLOSE_FRAMES = true;
    static final boolean DEFAULT_PERFORM_MASKING = true;
    private final boolean absoluteUpgradeUrl;
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private final HttpHeaders customHeaders;
    private final boolean dropPongFrames;
    private final long forceCloseTimeoutMillis;
    private final boolean generateOriginHeader;
    private final boolean handleCloseFrames;
    private final long handshakeTimeoutMillis;
    private final int maxFramePayloadLength;
    private final boolean performMasking;
    private final WebSocketCloseStatus sendCloseFrame;
    private final String subprotocol;
    private final WebSocketVersion version;
    private final URI webSocketUri;
    private final boolean withUTF8Validator;

    public static final class Builder {
        private boolean absoluteUpgradeUrl;
        private boolean allowExtensions;
        private boolean allowMaskMismatch;
        private HttpHeaders customHeaders;
        private boolean dropPongFrames;
        private long forceCloseTimeoutMillis;
        private boolean generateOriginHeader;
        private boolean handleCloseFrames;
        private long handshakeTimeoutMillis;
        private int maxFramePayloadLength;
        private boolean performMasking;
        private WebSocketCloseStatus sendCloseFrame;
        private String subprotocol;
        private WebSocketVersion version;
        private URI webSocketUri;
        private boolean withUTF8Validator;

        public Builder absoluteUpgradeUrl(boolean z10) {
            this.absoluteUpgradeUrl = z10;
            return this;
        }

        public Builder allowExtensions(boolean z10) {
            this.allowExtensions = z10;
            return this;
        }

        public Builder allowMaskMismatch(boolean z10) {
            this.allowMaskMismatch = z10;
            return this;
        }

        public WebSocketClientProtocolConfig build() {
            return new WebSocketClientProtocolConfig(this.webSocketUri, this.subprotocol, this.version, this.allowExtensions, this.customHeaders, this.maxFramePayloadLength, this.performMasking, this.allowMaskMismatch, this.handleCloseFrames, this.sendCloseFrame, this.dropPongFrames, this.handshakeTimeoutMillis, this.forceCloseTimeoutMillis, this.absoluteUpgradeUrl, this.generateOriginHeader, this.withUTF8Validator);
        }

        public Builder customHeaders(HttpHeaders httpHeaders) {
            this.customHeaders = httpHeaders;
            return this;
        }

        public Builder dropPongFrames(boolean z10) {
            this.dropPongFrames = z10;
            return this;
        }

        public Builder forceCloseTimeoutMillis(long j10) {
            this.forceCloseTimeoutMillis = j10;
            return this;
        }

        public Builder generateOriginHeader(boolean z10) {
            this.generateOriginHeader = z10;
            return this;
        }

        public Builder handleCloseFrames(boolean z10) {
            this.handleCloseFrames = z10;
            return this;
        }

        public Builder handshakeTimeoutMillis(long j10) {
            this.handshakeTimeoutMillis = j10;
            return this;
        }

        public Builder maxFramePayloadLength(int i10) {
            this.maxFramePayloadLength = i10;
            return this;
        }

        public Builder performMasking(boolean z10) {
            this.performMasking = z10;
            return this;
        }

        public Builder sendCloseFrame(WebSocketCloseStatus webSocketCloseStatus) {
            this.sendCloseFrame = webSocketCloseStatus;
            return this;
        }

        public Builder subprotocol(String str) {
            this.subprotocol = str;
            return this;
        }

        public Builder version(WebSocketVersion webSocketVersion) {
            this.version = webSocketVersion;
            return this;
        }

        public Builder webSocketUri(String str) {
            return webSocketUri(URI.create(str));
        }

        public Builder withUTF8Validator(boolean z10) {
            this.withUTF8Validator = z10;
            return this;
        }

        public Builder webSocketUri(URI uri) {
            this.webSocketUri = uri;
            return this;
        }

        private Builder(WebSocketClientProtocolConfig webSocketClientProtocolConfig) {
            this(((WebSocketClientProtocolConfig) ObjectUtil.checkNotNull(webSocketClientProtocolConfig, "clientConfig")).webSocketUri(), webSocketClientProtocolConfig.subprotocol(), webSocketClientProtocolConfig.version(), webSocketClientProtocolConfig.allowExtensions(), webSocketClientProtocolConfig.customHeaders(), webSocketClientProtocolConfig.maxFramePayloadLength(), webSocketClientProtocolConfig.performMasking(), webSocketClientProtocolConfig.allowMaskMismatch(), webSocketClientProtocolConfig.handleCloseFrames(), webSocketClientProtocolConfig.sendCloseFrame(), webSocketClientProtocolConfig.dropPongFrames(), webSocketClientProtocolConfig.handshakeTimeoutMillis(), webSocketClientProtocolConfig.forceCloseTimeoutMillis(), webSocketClientProtocolConfig.absoluteUpgradeUrl(), webSocketClientProtocolConfig.generateOriginHeader(), webSocketClientProtocolConfig.withUTF8Validator());
        }

        private Builder(URI uri, String str, WebSocketVersion webSocketVersion, boolean z10, HttpHeaders httpHeaders, int i10, boolean z11, boolean z12, boolean z13, WebSocketCloseStatus webSocketCloseStatus, boolean z14, long j10, long j11, boolean z15, boolean z16, boolean z17) {
            this.webSocketUri = uri;
            this.subprotocol = str;
            this.version = webSocketVersion;
            this.allowExtensions = z10;
            this.customHeaders = httpHeaders;
            this.maxFramePayloadLength = i10;
            this.performMasking = z11;
            this.allowMaskMismatch = z12;
            this.handleCloseFrames = z13;
            this.sendCloseFrame = webSocketCloseStatus;
            this.dropPongFrames = z14;
            this.handshakeTimeoutMillis = j10;
            this.forceCloseTimeoutMillis = j11;
            this.absoluteUpgradeUrl = z15;
            this.generateOriginHeader = z16;
            this.withUTF8Validator = z17;
        }
    }

    public static Builder newBuilder() {
        return new Builder(URI.create("https://localhost/"), null, WebSocketVersion.V13, false, EmptyHttpHeaders.INSTANCE, 65536, true, false, true, WebSocketCloseStatus.NORMAL_CLOSURE, true, 10000L, -1L, false, true, true);
    }

    public boolean absoluteUpgradeUrl() {
        return this.absoluteUpgradeUrl;
    }

    public boolean allowExtensions() {
        return this.allowExtensions;
    }

    public boolean allowMaskMismatch() {
        return this.allowMaskMismatch;
    }

    public HttpHeaders customHeaders() {
        return this.customHeaders;
    }

    public boolean dropPongFrames() {
        return this.dropPongFrames;
    }

    public long forceCloseTimeoutMillis() {
        return this.forceCloseTimeoutMillis;
    }

    public boolean generateOriginHeader() {
        return this.generateOriginHeader;
    }

    public boolean handleCloseFrames() {
        return this.handleCloseFrames;
    }

    public long handshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public boolean performMasking() {
        return this.performMasking;
    }

    public WebSocketCloseStatus sendCloseFrame() {
        return this.sendCloseFrame;
    }

    public String subprotocol() {
        return this.subprotocol;
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public String toString() {
        return "WebSocketClientProtocolConfig {webSocketUri=" + this.webSocketUri + ", subprotocol=" + this.subprotocol + ", version=" + this.version + ", allowExtensions=" + this.allowExtensions + ", customHeaders=" + this.customHeaders + ", maxFramePayloadLength=" + this.maxFramePayloadLength + ", performMasking=" + this.performMasking + ", allowMaskMismatch=" + this.allowMaskMismatch + ", handleCloseFrames=" + this.handleCloseFrames + ", sendCloseFrame=" + this.sendCloseFrame + ", dropPongFrames=" + this.dropPongFrames + ", handshakeTimeoutMillis=" + this.handshakeTimeoutMillis + ", forceCloseTimeoutMillis=" + this.forceCloseTimeoutMillis + ", absoluteUpgradeUrl=" + this.absoluteUpgradeUrl + ", generateOriginHeader=" + this.generateOriginHeader + "}";
    }

    public WebSocketVersion version() {
        return this.version;
    }

    public URI webSocketUri() {
        return this.webSocketUri;
    }

    public boolean withUTF8Validator() {
        return this.withUTF8Validator;
    }

    private WebSocketClientProtocolConfig(URI uri, String str, WebSocketVersion webSocketVersion, boolean z10, HttpHeaders httpHeaders, int i10, boolean z11, boolean z12, boolean z13, WebSocketCloseStatus webSocketCloseStatus, boolean z14, long j10, long j11, boolean z15, boolean z16, boolean z17) {
        this.webSocketUri = uri;
        this.subprotocol = str;
        this.version = webSocketVersion;
        this.allowExtensions = z10;
        this.customHeaders = httpHeaders;
        this.maxFramePayloadLength = i10;
        this.performMasking = z11;
        this.allowMaskMismatch = z12;
        this.forceCloseTimeoutMillis = j11;
        this.handleCloseFrames = z13;
        this.sendCloseFrame = webSocketCloseStatus;
        this.dropPongFrames = z14;
        this.handshakeTimeoutMillis = ObjectUtil.checkPositive(j10, "handshakeTimeoutMillis");
        this.absoluteUpgradeUrl = z15;
        this.generateOriginHeader = z16;
        this.withUTF8Validator = z17;
    }
}
