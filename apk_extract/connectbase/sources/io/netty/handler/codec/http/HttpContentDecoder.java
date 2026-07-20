package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import java.util.List;
import ks.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HttpContentDecoder extends MessageToMessageDecoder<HttpObject> {
    static final String IDENTITY = HttpHeaderValues.IDENTITY.toString();
    private boolean continueResponse;
    protected ChannelHandlerContext ctx;
    private EmbeddedChannel decoder;
    private boolean needRead = true;

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.decoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.decoder = null;
        }
    }

    private void cleanupSafely(ChannelHandlerContext channelHandlerContext) {
        try {
            cleanup();
        } catch (Throwable th2) {
            channelHandlerContext.fireExceptionCaught(th2);
        }
    }

    private void decodeContent(HttpContent httpContent, List<Object> list) {
        decode(httpContent.content(), list);
        if (httpContent instanceof LastHttpContent) {
            finishDecode(list);
            HttpHeaders httpHeadersTrailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
            if (httpHeadersTrailingHeaders.isEmpty()) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            } else {
                list.add(new ComposedLastHttpContent(httpHeadersTrailingHeaders, DecoderResult.SUCCESS));
            }
        }
    }

    private void fetchDecoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
            if (byteBuf == null) {
                return;
            }
            if (byteBuf.isReadable()) {
                list.add(new DefaultHttpContent(byteBuf));
            } else {
                byteBuf.release();
            }
        }
    }

    private void finishDecode(List<Object> list) {
        if (this.decoder.finish()) {
            fetchDecoderOutput(list);
        }
        this.decoder = null;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        boolean z10 = this.needRead;
        this.needRead = true;
        try {
            channelHandlerContext.fireChannelReadComplete();
        } finally {
            if (z10 && !channelHandlerContext.channel().config().isAutoRead()) {
                channelHandlerContext.read();
            }
        }
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        decode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    public String getTargetContentEncoding(String str) throws Exception {
        return IDENTITY;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public abstract EmbeddedChannel newContentDecoder(String str) throws Exception;

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        String strTrim;
        HttpMessage defaultHttpResponse;
        try {
            if ((httpObject instanceof HttpResponse) && ((HttpResponse) httpObject).status().code() == 100) {
                if (!(httpObject instanceof LastHttpContent)) {
                    this.continueResponse = true;
                }
                list.add(ReferenceCountUtil.retain(httpObject));
            } else {
                if (!this.continueResponse) {
                    if (httpObject instanceof HttpMessage) {
                        cleanup();
                        HttpMessage httpMessage = (HttpMessage) httpObject;
                        HttpHeaders httpHeadersHeaders = httpMessage.headers();
                        AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
                        String str = httpHeadersHeaders.get(asciiString);
                        if (str != null) {
                            strTrim = str.trim();
                        } else {
                            String str2 = httpHeadersHeaders.get(HttpHeaderNames.TRANSFER_ENCODING);
                            if (str2 != null) {
                                int iIndexOf = str2.indexOf(g.f9491d);
                                strTrim = iIndexOf != -1 ? str2.substring(0, iIndexOf).trim() : str2.trim();
                            } else {
                                strTrim = IDENTITY;
                            }
                        }
                        EmbeddedChannel embeddedChannelNewContentDecoder = newContentDecoder(strTrim);
                        this.decoder = embeddedChannelNewContentDecoder;
                        if (embeddedChannelNewContentDecoder == null) {
                            if (httpMessage instanceof HttpContent) {
                                ((HttpContent) httpMessage).retain();
                            }
                            list.add(httpMessage);
                        } else {
                            AsciiString asciiString2 = HttpHeaderNames.CONTENT_LENGTH;
                            if (httpHeadersHeaders.contains(asciiString2)) {
                                httpHeadersHeaders.remove(asciiString2);
                                httpHeadersHeaders.set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
                            }
                            String targetContentEncoding = getTargetContentEncoding(strTrim);
                            if (HttpHeaderValues.IDENTITY.contentEquals(targetContentEncoding)) {
                                httpHeadersHeaders.remove(asciiString);
                            } else {
                                httpHeadersHeaders.set(asciiString, targetContentEncoding);
                            }
                            if (httpMessage instanceof HttpContent) {
                                if (httpMessage instanceof HttpRequest) {
                                    HttpRequest httpRequest = (HttpRequest) httpMessage;
                                    defaultHttpResponse = new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri());
                                } else {
                                    if (!(httpMessage instanceof HttpResponse)) {
                                        throw new CodecException("Object of class " + httpMessage.getClass().getName() + " is not an HttpRequest or HttpResponse");
                                    }
                                    HttpResponse httpResponse = (HttpResponse) httpMessage;
                                    defaultHttpResponse = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status());
                                }
                                defaultHttpResponse.headers().set(httpMessage.headers());
                                defaultHttpResponse.setDecoderResult(httpMessage.decoderResult());
                                list.add(defaultHttpResponse);
                            } else {
                                list.add(httpMessage);
                            }
                        }
                    }
                    if (httpObject instanceof HttpContent) {
                        HttpContent httpContent = (HttpContent) httpObject;
                        if (this.decoder == null) {
                            list.add(httpContent.retain());
                        } else {
                            decodeContent(httpContent, list);
                        }
                    }
                    this.needRead = list.isEmpty();
                    return;
                }
                if (httpObject instanceof LastHttpContent) {
                    this.continueResponse = false;
                }
                list.add(ReferenceCountUtil.retain(httpObject));
            }
            this.needRead = list.isEmpty();
        } catch (Throwable th2) {
            this.needRead = list.isEmpty();
            throw th2;
        }
    }

    private void decode(ByteBuf byteBuf, List<Object> list) {
        this.decoder.writeInbound(byteBuf.retain());
        fetchDecoderOutput(list);
    }
}
