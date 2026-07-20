package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public final class PerMessageDeflateServerExtensionHandshaker implements WebSocketServerExtensionHandshaker {
    static final String CLIENT_MAX_WINDOW = "client_max_window_bits";
    static final String CLIENT_NO_CONTEXT = "client_no_context_takeover";
    public static final int MAX_WINDOW_SIZE = 15;
    public static final int MIN_WINDOW_SIZE = 8;
    static final String PERMESSAGE_DEFLATE_EXTENSION = "permessage-deflate";
    static final String SERVER_MAX_WINDOW = "server_max_window_bits";
    static final String SERVER_NO_CONTEXT = "server_no_context_takeover";
    private final boolean allowServerNoContext;
    private final boolean allowServerWindowSize;
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean preferredClientNoContext;
    private final int preferredClientWindowSize;

    public static class PermessageDeflateExtension implements WebSocketServerExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final int compressionLevel;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        public PermessageDeflateExtension(int i10, boolean z10, int i11, boolean z11, int i12, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.compressionLevel = i10;
            this.serverNoContext = z10;
            this.serverWindowSize = i11;
            this.clientNoContext = z11;
            this.clientWindowSize = i12;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerMessageDeflateDecoder(this.clientNoContext, this.extensionFilterProvider.decoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerMessageDeflateEncoder(this.compressionLevel, this.serverWindowSize, this.serverNoContext, this.extensionFilterProvider.encoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension
        public WebSocketExtensionData newReponseData() {
            HashMap map = new HashMap(4);
            if (this.serverNoContext) {
                map.put("server_no_context_takeover", null);
            }
            if (this.clientNoContext) {
                map.put("client_no_context_takeover", null);
            }
            int i10 = this.serverWindowSize;
            if (i10 != 15) {
                map.put("server_max_window_bits", Integer.toString(i10));
            }
            int i11 = this.clientWindowSize;
            if (i11 != 15) {
                map.put("client_max_window_bits", Integer.toString(i11));
            }
            return new WebSocketExtensionData("permessage-deflate", map);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }
    }

    public PerMessageDeflateServerExtensionHandshaker() {
        this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker
    public WebSocketServerExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (!"permessage-deflate".equals(webSocketExtensionData.name())) {
            return null;
        }
        Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
        boolean z10 = true;
        int i10 = 15;
        int i11 = 15;
        boolean z11 = false;
        boolean z12 = false;
        while (z10 && it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if ("client_max_window_bits".equalsIgnoreCase(next.getKey())) {
                i11 = this.preferredClientWindowSize;
            } else if ("server_max_window_bits".equalsIgnoreCase(next.getKey())) {
                if (!this.allowServerWindowSize || (i10 = Integer.parseInt(next.getValue())) > 15 || i10 < 8) {
                    z10 = false;
                }
            } else if ("client_no_context_takeover".equalsIgnoreCase(next.getKey())) {
                z12 = this.preferredClientNoContext;
            } else if ("server_no_context_takeover".equalsIgnoreCase(next.getKey()) && this.allowServerNoContext) {
                z11 = true;
            } else {
                z10 = false;
            }
        }
        if (z10) {
            return new PermessageDeflateExtension(this.compressionLevel, z11, i10, z12, i11, this.extensionFilterProvider);
        }
        return null;
    }

    public PerMessageDeflateServerExtensionHandshaker(int i10, boolean z10, int i11, boolean z11, boolean z12) {
        this(i10, z10, i11, z11, z12, WebSocketExtensionFilterProvider.DEFAULT);
    }

    public PerMessageDeflateServerExtensionHandshaker(int i10, boolean z10, int i11, boolean z11, boolean z12, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i11 > 15 || i11 < 8) {
            throw new IllegalArgumentException(b.a("preferredServerWindowSize: ", i11, " (expected: 8-15)"));
        }
        if (i10 >= 0 && i10 <= 9) {
            this.compressionLevel = i10;
            this.allowServerWindowSize = z10;
            this.preferredClientWindowSize = i11;
            this.allowServerNoContext = z11;
            this.preferredClientNoContext = z12;
            this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
            return;
        }
        throw new IllegalArgumentException(b.a("compressionLevel: ", i10, " (expected: 0-9)"));
    }
}
