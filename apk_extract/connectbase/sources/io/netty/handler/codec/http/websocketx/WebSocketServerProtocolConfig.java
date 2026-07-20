package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketServerProtocolConfig {
    static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = 10000;
    private final boolean checkStartsWith;
    private final WebSocketDecoderConfig decoderConfig;
    private final boolean dropPongFrames;
    private final long forceCloseTimeoutMillis;
    private final boolean handleCloseFrames;
    private final long handshakeTimeoutMillis;
    private final WebSocketCloseStatus sendCloseFrame;
    private final String subprotocols;
    private final String websocketPath;

    public static Builder newBuilder() {
        return new Builder("/", null, false, DEFAULT_HANDSHAKE_TIMEOUT_MILLIS, 0L, true, WebSocketCloseStatus.NORMAL_CLOSURE, true, WebSocketDecoderConfig.DEFAULT);
    }

    public boolean checkStartsWith() {
        return this.checkStartsWith;
    }

    public WebSocketDecoderConfig decoderConfig() {
        return this.decoderConfig;
    }

    public boolean dropPongFrames() {
        return this.dropPongFrames;
    }

    public long forceCloseTimeoutMillis() {
        return this.forceCloseTimeoutMillis;
    }

    public boolean handleCloseFrames() {
        return this.handleCloseFrames;
    }

    public long handshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    public WebSocketCloseStatus sendCloseFrame() {
        return this.sendCloseFrame;
    }

    public String subprotocols() {
        return this.subprotocols;
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public String toString() {
        return "WebSocketServerProtocolConfig {websocketPath=" + this.websocketPath + ", subprotocols=" + this.subprotocols + ", checkStartsWith=" + this.checkStartsWith + ", handshakeTimeoutMillis=" + this.handshakeTimeoutMillis + ", forceCloseTimeoutMillis=" + this.forceCloseTimeoutMillis + ", handleCloseFrames=" + this.handleCloseFrames + ", sendCloseFrame=" + this.sendCloseFrame + ", dropPongFrames=" + this.dropPongFrames + ", decoderConfig=" + this.decoderConfig + "}";
    }

    public String websocketPath() {
        return this.websocketPath;
    }

    public static final class Builder {
        private boolean checkStartsWith;
        private WebSocketDecoderConfig decoderConfig;
        private WebSocketDecoderConfig.Builder decoderConfigBuilder;
        private boolean dropPongFrames;
        private long forceCloseTimeoutMillis;
        private boolean handleCloseFrames;
        private long handshakeTimeoutMillis;
        private WebSocketCloseStatus sendCloseFrame;
        private String subprotocols;
        private String websocketPath;

        private WebSocketDecoderConfig.Builder decoderConfigBuilder() {
            if (this.decoderConfigBuilder == null) {
                this.decoderConfigBuilder = this.decoderConfig.toBuilder();
            }
            return this.decoderConfigBuilder;
        }

        public Builder allowExtensions(boolean z10) {
            decoderConfigBuilder().allowExtensions(z10);
            return this;
        }

        public Builder allowMaskMismatch(boolean z10) {
            decoderConfigBuilder().allowMaskMismatch(z10);
            return this;
        }

        public WebSocketServerProtocolConfig build() {
            String str = this.websocketPath;
            String str2 = this.subprotocols;
            boolean z10 = this.checkStartsWith;
            long j10 = this.handshakeTimeoutMillis;
            long j11 = this.forceCloseTimeoutMillis;
            boolean z11 = this.handleCloseFrames;
            WebSocketCloseStatus webSocketCloseStatus = this.sendCloseFrame;
            boolean z12 = this.dropPongFrames;
            WebSocketDecoderConfig.Builder builder = this.decoderConfigBuilder;
            return new WebSocketServerProtocolConfig(str, str2, z10, j10, j11, z11, webSocketCloseStatus, z12, builder == null ? this.decoderConfig : builder.build());
        }

        public Builder checkStartsWith(boolean z10) {
            this.checkStartsWith = z10;
            return this;
        }

        public Builder closeOnProtocolViolation(boolean z10) {
            decoderConfigBuilder().closeOnProtocolViolation(z10);
            return this;
        }

        public Builder decoderConfig(WebSocketDecoderConfig webSocketDecoderConfig) {
            if (webSocketDecoderConfig == null) {
                webSocketDecoderConfig = WebSocketDecoderConfig.DEFAULT;
            }
            this.decoderConfig = webSocketDecoderConfig;
            this.decoderConfigBuilder = null;
            return this;
        }

        public Builder dropPongFrames(boolean z10) {
            this.dropPongFrames = z10;
            return this;
        }

        public Builder expectMaskedFrames(boolean z10) {
            decoderConfigBuilder().expectMaskedFrames(z10);
            return this;
        }

        public Builder forceCloseTimeoutMillis(long j10) {
            this.forceCloseTimeoutMillis = j10;
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
            decoderConfigBuilder().maxFramePayloadLength(i10);
            return this;
        }

        public Builder sendCloseFrame(WebSocketCloseStatus webSocketCloseStatus) {
            this.sendCloseFrame = webSocketCloseStatus;
            return this;
        }

        public Builder subprotocols(String str) {
            this.subprotocols = str;
            return this;
        }

        public Builder websocketPath(String str) {
            this.websocketPath = str;
            return this;
        }

        public Builder withUTF8Validator(boolean z10) {
            decoderConfigBuilder().withUTF8Validator(z10);
            return this;
        }

        private Builder(WebSocketServerProtocolConfig webSocketServerProtocolConfig) {
            this(((WebSocketServerProtocolConfig) ObjectUtil.checkNotNull(webSocketServerProtocolConfig, "serverConfig")).websocketPath(), webSocketServerProtocolConfig.subprotocols(), webSocketServerProtocolConfig.checkStartsWith(), webSocketServerProtocolConfig.handshakeTimeoutMillis(), webSocketServerProtocolConfig.forceCloseTimeoutMillis(), webSocketServerProtocolConfig.handleCloseFrames(), webSocketServerProtocolConfig.sendCloseFrame(), webSocketServerProtocolConfig.dropPongFrames(), webSocketServerProtocolConfig.decoderConfig());
        }

        private Builder(String str, String str2, boolean z10, long j10, long j11, boolean z11, WebSocketCloseStatus webSocketCloseStatus, boolean z12, WebSocketDecoderConfig webSocketDecoderConfig) {
            this.websocketPath = str;
            this.subprotocols = str2;
            this.checkStartsWith = z10;
            this.handshakeTimeoutMillis = j10;
            this.forceCloseTimeoutMillis = j11;
            this.handleCloseFrames = z11;
            this.sendCloseFrame = webSocketCloseStatus;
            this.dropPongFrames = z12;
            this.decoderConfig = webSocketDecoderConfig;
        }
    }

    private WebSocketServerProtocolConfig(String str, String str2, boolean z10, long j10, long j11, boolean z11, WebSocketCloseStatus webSocketCloseStatus, boolean z12, WebSocketDecoderConfig webSocketDecoderConfig) {
        this.websocketPath = str;
        this.subprotocols = str2;
        this.checkStartsWith = z10;
        this.handshakeTimeoutMillis = ObjectUtil.checkPositive(j10, "handshakeTimeoutMillis");
        this.forceCloseTimeoutMillis = j11;
        this.handleCloseFrames = z11;
        this.sendCloseFrame = webSocketCloseStatus;
        this.dropPongFrames = z12;
        this.decoderConfig = webSocketDecoderConfig == null ? WebSocketDecoderConfig.DEFAULT : webSocketDecoderConfig;
    }
}
