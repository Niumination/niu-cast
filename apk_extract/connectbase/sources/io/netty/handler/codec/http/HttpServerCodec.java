package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpServerCodec extends CombinedChannelDuplexHandler<HttpRequestDecoder, HttpResponseEncoder> implements HttpServerUpgradeHandler.SourceCodec {
    private final Queue<HttpMethod> queue;

    public final class HttpServerResponseEncoder extends HttpResponseEncoder {
        private HttpMethod method;

        private HttpServerResponseEncoder() {
        }

        @Override // io.netty.handler.codec.http.HttpResponseEncoder, io.netty.handler.codec.http.HttpObjectEncoder
        public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
            HttpMethod httpMethod = (HttpMethod) HttpServerCodec.this.queue.poll();
            this.method = httpMethod;
            return HttpMethod.HEAD.equals(httpMethod) || super.isContentAlwaysEmpty(httpResponse);
        }

        @Override // io.netty.handler.codec.http.HttpResponseEncoder, io.netty.handler.codec.http.HttpObjectEncoder
        public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z10) {
            if (!z10 && HttpMethod.CONNECT.equals(this.method) && httpResponse.status().codeClass() == HttpStatusClass.SUCCESS) {
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            } else {
                super.sanitizeHeadersBeforeEncode(httpResponse, z10);
            }
        }
    }

    public HttpServerCodec() {
        this(4096, 8192, 8192);
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    public final class HttpServerRequestDecoder extends HttpRequestDecoder {
        public HttpServerRequestDecoder(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder, io.netty.handler.codec.ByteToMessageDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            super.decode(channelHandlerContext, byteBuf, list);
            int size = list.size();
            for (int size2 = list.size(); size2 < size; size2++) {
                Object obj = list.get(size2);
                if (obj instanceof HttpRequest) {
                    HttpServerCodec.this.queue.add(((HttpRequest) obj).method());
                }
            }
        }

        public HttpServerRequestDecoder(int i10, int i11, int i12, boolean z10) {
            super(i10, i11, i12, z10);
        }

        public HttpServerRequestDecoder(int i10, int i11, int i12, boolean z10, int i13) {
            super(i10, i11, i12, z10, i13);
        }

        public HttpServerRequestDecoder(int i10, int i11, int i12, boolean z10, int i13, boolean z11) {
            super(i10, i11, i12, z10, i13, z11);
        }

        public HttpServerRequestDecoder(int i10, int i11, int i12, boolean z10, int i13, boolean z11, boolean z12) {
            super(i10, i11, i12, z10, i13, z11, z12);
        }
    }

    public HttpServerCodec(int i10, int i11, int i12) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i10, i11, i12), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i10, int i11, int i12, boolean z10) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i10, i11, i12, z10), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i10, int i11, int i12, boolean z10, int i13) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i10, i11, i12, z10, i13), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i10, int i11, int i12, boolean z10, int i13, boolean z11) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i10, i11, i12, z10, i13, z11), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i10, int i11, int i12, boolean z10, int i13, boolean z11, boolean z12) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i10, i11, i12, z10, i13, z11, z12), new HttpServerResponseEncoder());
    }
}
