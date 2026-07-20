package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import j1.g;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpClientCodec extends CombinedChannelDuplexHandler<HttpResponseDecoder, HttpRequestEncoder> implements HttpClientUpgradeHandler.SourceCodec {
    public static final boolean DEFAULT_FAIL_ON_MISSING_RESPONSE = false;
    public static final boolean DEFAULT_PARSE_HTTP_AFTER_CONNECT_REQUEST = false;
    private boolean done;
    private final boolean failOnMissingResponse;
    private final boolean parseHttpAfterConnectRequest;
    private final Queue<HttpMethod> queue;
    private final AtomicLong requestResponseCounter;

    public final class Encoder extends HttpRequestEncoder {
        boolean upgraded;

        private Encoder() {
        }

        @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
        public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
            if (this.upgraded) {
                list.add(obj);
                return;
            }
            if (obj instanceof HttpRequest) {
                HttpClientCodec.this.queue.offer(((HttpRequest) obj).method());
            }
            super.encode(channelHandlerContext, obj, list);
            if (HttpClientCodec.this.failOnMissingResponse && !HttpClientCodec.this.done && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.incrementAndGet();
            }
        }
    }

    public HttpClientCodec() {
        this(4096, 8192, 8192, false);
    }

    public boolean isSingleDecode() {
        return inboundHandler().isSingleDecode();
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.SourceCodec
    public void prepareUpgradeFrom(ChannelHandlerContext channelHandlerContext) {
        ((Encoder) outboundHandler()).upgraded = true;
    }

    public void setSingleDecode(boolean z10) {
        inboundHandler().setSingleDecode(z10);
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    public final class Decoder extends HttpResponseDecoder {
        public Decoder(int i10, int i11, int i12, boolean z10) {
            super(i10, i11, i12, z10);
        }

        private void decrement(Object obj) {
            if (obj != null && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.decrementAndGet();
            }
        }

        @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelInactive(channelHandlerContext);
            if (HttpClientCodec.this.failOnMissingResponse) {
                long j10 = HttpClientCodec.this.requestResponseCounter.get();
                if (j10 > 0) {
                    channelHandlerContext.fireExceptionCaught((Throwable) new PrematureChannelClosureException(g.a("channel gone inactive with ", j10, " missing response(s)")));
                }
            }
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder, io.netty.handler.codec.ByteToMessageDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            if (HttpClientCodec.this.done) {
                int iActualReadableBytes = actualReadableBytes();
                if (iActualReadableBytes == 0) {
                    return;
                }
                list.add(byteBuf.readBytes(iActualReadableBytes));
                return;
            }
            super.decode(channelHandlerContext, byteBuf, list);
            if (HttpClientCodec.this.failOnMissingResponse) {
                int size = list.size();
                for (int size2 = list.size(); size2 < size; size2++) {
                    decrement(list.get(size2));
                }
            }
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder
        public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
            HttpMethod httpMethod = (HttpMethod) HttpClientCodec.this.queue.poll();
            HttpResponseStatus httpResponseStatusStatus = ((HttpResponse) httpMessage).status();
            HttpStatusClass httpStatusClassCodeClass = httpResponseStatusStatus.codeClass();
            int iCode = httpResponseStatusStatus.code();
            if (httpStatusClassCodeClass == HttpStatusClass.INFORMATIONAL) {
                return super.isContentAlwaysEmpty(httpMessage);
            }
            if (httpMethod != null) {
                char cCharAt = httpMethod.name().charAt(0);
                if (cCharAt != 'C') {
                    if (cCharAt == 'H' && HttpMethod.HEAD.equals(httpMethod)) {
                        return true;
                    }
                } else if (iCode == 200 && HttpMethod.CONNECT.equals(httpMethod)) {
                    if (!HttpClientCodec.this.parseHttpAfterConnectRequest) {
                        HttpClientCodec.this.done = true;
                        HttpClientCodec.this.queue.clear();
                    }
                    return true;
                }
            }
            return super.isContentAlwaysEmpty(httpMessage);
        }

        public Decoder(int i10, int i11, int i12, boolean z10, int i13, boolean z11, boolean z12) {
            super(i10, i11, i12, z10, i13, z11, z12);
        }
    }

    public HttpClientCodec(int i10, int i11, int i12) {
        this(i10, i11, i12, false);
    }

    public HttpClientCodec(int i10, int i11, int i12, boolean z10) {
        this(i10, i11, i12, z10, true);
    }

    public HttpClientCodec(int i10, int i11, int i12, boolean z10, boolean z11) {
        this(i10, i11, i12, z10, z11, false);
    }

    public HttpClientCodec(int i10, int i11, int i12, boolean z10, boolean z11, boolean z12) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i10, i11, i12, z11), new Encoder());
        this.failOnMissingResponse = z10;
        this.parseHttpAfterConnectRequest = z12;
    }

    public HttpClientCodec(int i10, int i11, int i12, boolean z10, boolean z11, int i13) {
        this(i10, i11, i12, z10, z11, i13, false);
    }

    public HttpClientCodec(int i10, int i11, int i12, boolean z10, boolean z11, int i13, boolean z12) {
        this(i10, i11, i12, z10, z11, i13, z12, false);
    }

    public HttpClientCodec(int i10, int i11, int i12, boolean z10, boolean z11, int i13, boolean z12, boolean z13) {
        this(i10, i11, i12, z10, z11, i13, z12, z13, true);
    }

    public HttpClientCodec(int i10, int i11, int i12, boolean z10, boolean z11, int i13, boolean z12, boolean z13, boolean z14) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i10, i11, i12, z11, i13, z13, z14), new Encoder());
        this.parseHttpAfterConnectRequest = z12;
        this.failOnMissingResponse = z10;
    }
}
