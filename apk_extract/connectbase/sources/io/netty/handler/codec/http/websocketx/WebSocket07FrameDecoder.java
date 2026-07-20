package io.netty.handler.codec.http.websocketx;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocket07FrameDecoder extends WebSocket08FrameDecoder {
    public WebSocket07FrameDecoder(boolean z10, boolean z11, int i10) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z10).allowExtensions(z11).maxFramePayloadLength(i10).build());
    }

    public WebSocket07FrameDecoder(boolean z10, boolean z11, int i10, boolean z12) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z10).allowExtensions(z11).maxFramePayloadLength(i10).allowMaskMismatch(z12).build());
    }

    public WebSocket07FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        super(webSocketDecoderConfig);
    }
}
