package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k.b;
import mk.v;

/* JADX INFO: loaded from: classes3.dex */
public final class PerMessageDeflateClientExtensionHandshaker implements WebSocketClientExtensionHandshaker {
    private final boolean allowClientNoContext;
    private final boolean allowClientWindowSize;
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean requestedServerNoContext;
    private final int requestedServerWindowSize;

    public final class PermessageDeflateExtension implements WebSocketClientExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        public PermessageDeflateExtension(boolean z10, int i10, boolean z11, int i11, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.serverNoContext = z10;
            this.serverWindowSize = i10;
            this.clientNoContext = z11;
            this.clientWindowSize = i11;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerMessageDeflateDecoder(this.serverNoContext, this.extensionFilterProvider.decoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerMessageDeflateEncoder(PerMessageDeflateClientExtensionHandshaker.this.compressionLevel, this.clientWindowSize, this.clientNoContext, this.extensionFilterProvider.encoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }
    }

    public PerMessageDeflateClientExtensionHandshaker() {
        this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketClientExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (!v.f10846e.equals(webSocketExtensionData.name())) {
            return null;
        }
        Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
        boolean z10 = false;
        boolean z11 = true;
        int i10 = 15;
        int i11 = 15;
        boolean z12 = false;
        boolean z13 = false;
        while (z11 && it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (v.f10845d.equalsIgnoreCase(next.getKey())) {
                if (!this.allowClientWindowSize || (i11 = Integer.parseInt(next.getValue())) > 15 || i11 < 8) {
                    z11 = false;
                }
            } else if (v.f10842a.equalsIgnoreCase(next.getKey())) {
                i10 = Integer.parseInt(next.getValue());
                if (i10 > 15 || i10 < 8) {
                    z11 = false;
                }
            } else if (v.f10843b.equalsIgnoreCase(next.getKey())) {
                if (this.allowClientNoContext) {
                    z13 = true;
                } else {
                    z11 = false;
                }
            } else if (v.f10844c.equalsIgnoreCase(next.getKey())) {
                z12 = true;
            } else {
                z11 = false;
            }
        }
        if ((!this.requestedServerNoContext || z12) && this.requestedServerWindowSize >= i10) {
            z10 = z11;
        }
        if (z10) {
            return new PermessageDeflateExtension(z12, i10, z13, i11, this.extensionFilterProvider);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketExtensionData newRequestData() {
        HashMap map = new HashMap(4);
        if (this.requestedServerNoContext) {
            map.put(v.f10844c, null);
        }
        if (this.allowClientNoContext) {
            map.put(v.f10843b, null);
        }
        int i10 = this.requestedServerWindowSize;
        if (i10 != 15) {
            map.put(v.f10842a, Integer.toString(i10));
        }
        if (this.allowClientWindowSize) {
            map.put(v.f10845d, null);
        }
        return new WebSocketExtensionData(v.f10846e, map);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i10, boolean z10, int i11, boolean z11, boolean z12) {
        this(i10, z10, i11, z11, z12, WebSocketExtensionFilterProvider.DEFAULT);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i10, boolean z10, int i11, boolean z11, boolean z12, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i11 > 15 || i11 < 8) {
            throw new IllegalArgumentException(b.a("requestedServerWindowSize: ", i11, " (expected: 8-15)"));
        }
        if (i10 >= 0 && i10 <= 9) {
            this.compressionLevel = i10;
            this.allowClientWindowSize = z10;
            this.requestedServerWindowSize = i11;
            this.allowClientNoContext = z11;
            this.requestedServerNoContext = z12;
            this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
            return;
        }
        throw new IllegalArgumentException(b.a("compressionLevel: ", i10, " (expected: 0-9)"));
    }
}
