package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HttpObjectEncoder<H extends HttpMessage> extends MessageToMessageEncoder<Object> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ByteBuf CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2).writeByte(13).writeByte(10)).asReadOnly();
    static final int CRLF_SHORT = 3338;
    private static final float HEADERS_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_WEIGHT_NEW = 0.2f;
    private static final int ST_CONTENT_ALWAYS_EMPTY = 3;
    private static final int ST_CONTENT_CHUNK = 2;
    private static final int ST_CONTENT_NON_CHUNK = 1;
    private static final int ST_INIT = 0;
    private static final float TRAILERS_WEIGHT_HISTORICAL = 0.8f;
    private static final float TRAILERS_WEIGHT_NEW = 0.2f;
    private static final byte[] ZERO_CRLF_CRLF;
    private static final ByteBuf ZERO_CRLF_CRLF_BUF;
    private static final int ZERO_CRLF_MEDIUM = 3149066;
    private int state = 0;
    private float headersEncodedSizeAccumulator = 256.0f;
    private float trailersEncodedSizeAccumulator = 256.0f;
    private final List<Object> out = new ArrayList();

    static {
        byte[] bArr = {48, 13, 10, 13, 10};
        ZERO_CRLF_CRLF = bArr;
        ZERO_CRLF_CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(bArr.length).writeBytes(bArr)).asReadOnly();
    }

    private static void addEncodedLengthHex(ChannelHandlerContext channelHandlerContext, long j10, List<Object> list) {
        String hexString = Long.toHexString(j10);
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(hexString.length() + 2);
        byteBufBuffer.writeCharSequence(hexString, CharsetUtil.US_ASCII);
        ByteBufUtil.writeShortBE(byteBufBuffer, CRLF_SHORT);
        list.add(byteBufBuffer);
    }

    private static boolean bypassEncoderIfEmpty(ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.isReadable()) {
            return false;
        }
        list.add(byteBuf.retain());
        return true;
    }

    private static boolean checkContentState(int i10) {
        return i10 == 2 || i10 == 1 || i10 == 3;
    }

    @Deprecated
    public static void encodeAscii(String str, ByteBuf byteBuf) {
        byteBuf.writeCharSequence(str, CharsetUtil.US_ASCII);
    }

    private void encodeByteBufAndTrailers(int i10, ChannelHandlerContext channelHandlerContext, List<Object> list, ByteBuf byteBuf, HttpHeaders httpHeaders) {
        if (i10 != 1) {
            if (i10 == 2) {
                encodeChunkedHttpContent(channelHandlerContext, byteBuf, httpHeaders, list);
                return;
            } else if (i10 != 3) {
                throw new Error();
            }
        } else if (byteBuf.isReadable()) {
            list.add(byteBuf.retain());
            return;
        }
        list.add(Unpooled.EMPTY_BUFFER);
    }

    private void encodeByteBufContent(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        try {
            if (bypassEncoderIfEmpty(byteBuf, list)) {
                return;
            }
            encodeByteBufAndTrailers(this.state, channelHandlerContext, list, byteBuf, null);
        } finally {
            byteBuf.release();
        }
    }

    private void encodeByteBufHttpContent(int i10, ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2, HttpHeaders httpHeaders, List<Object> list) {
        if (i10 != 1) {
            if (i10 == 2) {
                list.add(byteBuf);
                encodeChunkedHttpContent(channelHandlerContext, byteBuf2, httpHeaders, list);
                return;
            } else if (i10 != 3) {
                throw new Error();
            }
        } else if (encodeContentNonChunk(list, byteBuf, byteBuf2)) {
            return;
        }
        list.add(byteBuf);
    }

    private void encodeChunkedHttpContent(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, HttpHeaders httpHeaders, List<Object> list) {
        int i10 = byteBuf.readableBytes();
        if (i10 > 0) {
            addEncodedLengthHex(channelHandlerContext, i10, list);
            list.add(byteBuf.retain());
            list.add(CRLF_BUF.duplicate());
        }
        if (httpHeaders != null) {
            encodeTrailingHeaders(channelHandlerContext, httpHeaders, list);
        } else if (i10 == 0) {
            list.add(byteBuf.retain());
        }
    }

    private static boolean encodeContentNonChunk(List<Object> list, ByteBuf byteBuf, ByteBuf byteBuf2) {
        int i10 = byteBuf2.readableBytes();
        if (i10 <= 0) {
            return false;
        }
        if (byteBuf.writableBytes() >= i10) {
            byteBuf.writeBytes(byteBuf2);
            list.add(byteBuf);
            return true;
        }
        list.add(byteBuf);
        list.add(byteBuf2.retain());
        return true;
    }

    private static int encodeEmptyLastHttpContent(int i10, List<Object> list) {
        if (i10 != 1) {
            if (i10 == 2) {
                list.add(ZERO_CRLF_CRLF_BUF.duplicate());
                return 0;
            }
            if (i10 != 3) {
                throw new Error();
            }
        }
        list.add(Unpooled.EMPTY_BUFFER);
        return 0;
    }

    private void encodeFileRegionContent(ChannelHandlerContext channelHandlerContext, FileRegion fileRegion, List<Object> list) {
        try {
            int i10 = this.state;
            if (i10 != 1) {
                if (i10 == 2) {
                    encodedChunkedFileRegionContent(channelHandlerContext, fileRegion, list);
                } else {
                    if (i10 != 3) {
                        throw new Error();
                    }
                    list.add(Unpooled.EMPTY_BUFFER);
                }
            } else if (fileRegion.count() > 0) {
                list.add(fileRegion.retain());
            } else {
                list.add(Unpooled.EMPTY_BUFFER);
            }
            fileRegion.release();
        } catch (Throwable th2) {
            fileRegion.release();
            throw th2;
        }
    }

    private void encodeFullHttpMessage(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        int i10;
        FullHttpMessage fullHttpMessage = (FullHttpMessage) obj;
        try {
            int i11 = this.state;
            if (i11 != 0) {
                throwUnexpectedMessageTypeEx(obj, i11);
            }
            HttpMessage httpMessage = (HttpMessage) obj;
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer((int) this.headersEncodedSizeAccumulator);
            encodeInitialLine(byteBufBuffer, httpMessage);
            boolean z10 = true;
            if (isContentAlwaysEmpty(httpMessage)) {
                i10 = 3;
            } else {
                i10 = HttpUtil.isTransferEncodingChunked(httpMessage) ? 2 : 1;
            }
            if (i10 != 3) {
                z10 = false;
            }
            sanitizeHeadersBeforeEncode(httpMessage, z10);
            encodeHeaders(httpMessage.headers(), byteBufBuffer);
            ByteBufUtil.writeShortBE(byteBufBuffer, CRLF_SHORT);
            this.headersEncodedSizeAccumulator = (this.headersEncodedSizeAccumulator * 0.8f) + (padSizeForAccumulation(byteBufBuffer.readableBytes()) * 0.2f);
            encodeByteBufHttpContent(i10, channelHandlerContext, byteBufBuffer, fullHttpMessage.content(), fullHttpMessage.trailingHeaders(), list);
        } finally {
            fullHttpMessage.release();
        }
    }

    private void encodeHttpContent(ChannelHandlerContext channelHandlerContext, HttpContent httpContent, List<Object> list) {
        try {
            encodeByteBufAndTrailers(this.state, channelHandlerContext, list, httpContent.content(), null);
        } finally {
            httpContent.release();
        }
    }

    private void encodeHttpMessageLastContent(ChannelHandlerContext channelHandlerContext, H h10, List<Object> list) throws Exception {
        LastHttpContent lastHttpContent = (LastHttpContent) h10;
        try {
            int i10 = this.state;
            if (i10 != 0) {
                throwUnexpectedMessageTypeEx(h10, i10);
            }
            encodeByteBufHttpContent(this.state, channelHandlerContext, encodeInitHttpMessage(channelHandlerContext, h10), lastHttpContent.content(), lastHttpContent.trailingHeaders(), list);
            this.state = 0;
        } finally {
            lastHttpContent.release();
        }
    }

    private void encodeHttpMessageNotLastContent(ChannelHandlerContext channelHandlerContext, H h10, List<Object> list) throws Exception {
        HttpContent httpContent = (HttpContent) h10;
        try {
            int i10 = this.state;
            if (i10 != 0) {
                throwUnexpectedMessageTypeEx(h10, i10);
            }
            encodeByteBufHttpContent(this.state, channelHandlerContext, encodeInitHttpMessage(channelHandlerContext, h10), httpContent.content(), null, list);
        } finally {
            httpContent.release();
        }
    }

    private ByteBuf encodeInitHttpMessage(ChannelHandlerContext channelHandlerContext, H h10) throws Exception {
        int i10;
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer((int) this.headersEncodedSizeAccumulator);
        encodeInitialLine(byteBufBuffer, h10);
        if (isContentAlwaysEmpty(h10)) {
            i10 = 3;
        } else {
            i10 = HttpUtil.isTransferEncodingChunked(h10) ? 2 : 1;
        }
        this.state = i10;
        sanitizeHeadersBeforeEncode(h10, i10 == 3);
        encodeHeaders(h10.headers(), byteBufBuffer);
        ByteBufUtil.writeShortBE(byteBufBuffer, CRLF_SHORT);
        this.headersEncodedSizeAccumulator = (this.headersEncodedSizeAccumulator * 0.8f) + (padSizeForAccumulation(byteBufBuffer.readableBytes()) * 0.2f);
        return byteBufBuffer;
    }

    private void encodeJustHttpMessage(ChannelHandlerContext channelHandlerContext, H h10, List<Object> list) throws Exception {
        try {
            int i10 = this.state;
            if (i10 != 0) {
                throwUnexpectedMessageTypeEx(h10, i10);
            }
            list.add(encodeInitHttpMessage(channelHandlerContext, h10));
        } finally {
            ReferenceCountUtil.release(h10);
        }
    }

    private void encodeLastHttpContent(ChannelHandlerContext channelHandlerContext, LastHttpContent lastHttpContent, List<Object> list) {
        try {
            encodeByteBufAndTrailers(this.state, channelHandlerContext, list, lastHttpContent.content(), lastHttpContent.trailingHeaders());
            this.state = 0;
        } finally {
            lastHttpContent.release();
        }
    }

    private void encodeNotHttpMessageContentTypes(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) {
        if (this.state == 0) {
            try {
                if ((obj instanceof ByteBuf) && bypassEncoderIfEmpty((ByteBuf) obj, list)) {
                    ReferenceCountUtil.release(obj);
                    return;
                } else {
                    throwUnexpectedMessageTypeEx(obj, 0);
                    ReferenceCountUtil.release(obj);
                }
            } catch (Throwable th2) {
                ReferenceCountUtil.release(obj);
                throw th2;
            }
        }
        if (obj == LastHttpContent.EMPTY_LAST_CONTENT) {
            this.state = encodeEmptyLastHttpContent(this.state, list);
            return;
        }
        if (obj instanceof LastHttpContent) {
            encodeLastHttpContent(channelHandlerContext, (LastHttpContent) obj, list);
            return;
        }
        if (obj instanceof HttpContent) {
            encodeHttpContent(channelHandlerContext, (HttpContent) obj, list);
            return;
        }
        if (obj instanceof ByteBuf) {
            encodeByteBufContent(channelHandlerContext, (ByteBuf) obj, list);
        } else {
            if (obj instanceof FileRegion) {
                encodeFileRegionContent(channelHandlerContext, (FileRegion) obj, list);
                return;
            }
            try {
                throwUnexpectedMessageTypeEx(obj, this.state);
            } finally {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    private void encodeTrailingHeaders(ChannelHandlerContext channelHandlerContext, HttpHeaders httpHeaders, List<Object> list) {
        if (httpHeaders.isEmpty()) {
            list.add(ZERO_CRLF_CRLF_BUF.duplicate());
            return;
        }
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer((int) this.trailersEncodedSizeAccumulator);
        ByteBufUtil.writeMediumBE(byteBufBuffer, ZERO_CRLF_MEDIUM);
        encodeHeaders(httpHeaders, byteBufBuffer);
        ByteBufUtil.writeShortBE(byteBufBuffer, CRLF_SHORT);
        this.trailersEncodedSizeAccumulator = (this.trailersEncodedSizeAccumulator * 0.8f) + (padSizeForAccumulation(byteBufBuffer.readableBytes()) * 0.2f);
        list.add(byteBufBuffer);
    }

    private static void encodedChunkedFileRegionContent(ChannelHandlerContext channelHandlerContext, FileRegion fileRegion, List<Object> list) {
        long jCount = fileRegion.count();
        if (jCount > 0) {
            addEncodedLengthHex(channelHandlerContext, jCount, list);
            list.add(fileRegion.retain());
            list.add(CRLF_BUF.duplicate());
        } else if (jCount == 0) {
            list.add(fileRegion.retain());
        }
    }

    private static int padSizeForAccumulation(int i10) {
        return (i10 << 2) / 3;
    }

    private static void throwUnexpectedMessageTypeEx(Object obj, int i10) {
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj) + ", state: " + i10);
    }

    private static void writeOutList(ChannelHandlerContext channelHandlerContext, List<Object> list, ChannelPromise channelPromise) {
        int size = list.size();
        try {
            if (size != 1) {
                if (size > 1) {
                    if (channelPromise == channelHandlerContext.voidPromise()) {
                        writeVoidPromise(channelHandlerContext, list);
                    } else {
                        writePromiseCombiner(channelHandlerContext, list, channelPromise);
                    }
                }
                list.clear();
            }
            channelHandlerContext.write(list.get(0), channelPromise);
            list.clear();
        } catch (Throwable th2) {
            list.clear();
            throw th2;
        }
    }

    private static void writePromiseCombiner(ChannelHandlerContext channelHandlerContext, List<Object> list, ChannelPromise channelPromise) {
        PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
        for (int i10 = 0; i10 < list.size(); i10++) {
            promiseCombiner.add(channelHandlerContext.write(list.get(i10)));
        }
        promiseCombiner.finish(channelPromise);
    }

    private static void writeVoidPromise(ChannelHandlerContext channelHandlerContext, List<Object> list) {
        ChannelPromise channelPromiseVoidPromise = channelHandlerContext.voidPromise();
        for (int i10 = 0; i10 < list.size(); i10++) {
            channelHandlerContext.write(list.get(i10), channelPromiseVoidPromise);
        }
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return obj == Unpooled.EMPTY_BUFFER || obj == LastHttpContent.EMPTY_LAST_CONTENT || (obj instanceof FullHttpMessage) || (obj instanceof HttpMessage) || (obj instanceof LastHttpContent) || (obj instanceof HttpContent) || (obj instanceof ByteBuf) || (obj instanceof FileRegion);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
        if (obj == byteBuf) {
            list.add(byteBuf);
            return;
        }
        if (obj instanceof FullHttpMessage) {
            encodeFullHttpMessage(channelHandlerContext, obj, list);
            return;
        }
        if (!(obj instanceof HttpMessage)) {
            encodeNotHttpMessageContentTypes(channelHandlerContext, obj, list);
            return;
        }
        try {
            HttpMessage httpMessage = (HttpMessage) obj;
            if (httpMessage instanceof LastHttpContent) {
                encodeHttpMessageLastContent(channelHandlerContext, httpMessage, list);
            } else if (httpMessage instanceof HttpContent) {
                encodeHttpMessageNotLastContent(channelHandlerContext, httpMessage, list);
            } else {
                encodeJustHttpMessage(channelHandlerContext, httpMessage, list);
            }
        } catch (Exception e10) {
            ReferenceCountUtil.release(obj);
            throw e10;
        }
    }

    public void encodeHeaders(HttpHeaders httpHeaders, ByteBuf byteBuf) {
        Iterator<Map.Entry<CharSequence, CharSequence>> itIteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (itIteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = itIteratorCharSequence.next();
            HttpHeadersEncoder.encoderHeader(next.getKey(), next.getValue(), byteBuf);
        }
    }

    public abstract void encodeInitialLine(ByteBuf byteBuf, H h10) throws Exception;

    public boolean isContentAlwaysEmpty(H h10) {
        return false;
    }

    public void sanitizeHeadersBeforeEncode(H h10, boolean z10) {
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder, io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        try {
            try {
                try {
                    if (acceptOutboundMessage(obj)) {
                        encode(channelHandlerContext, obj, this.out);
                        if (this.out.isEmpty()) {
                            throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                        }
                    } else {
                        channelHandlerContext.write(obj, channelPromise);
                    }
                    writeOutList(channelHandlerContext, this.out, channelPromise);
                } catch (EncoderException e10) {
                    throw e10;
                }
            } catch (Throwable th2) {
                throw new EncoderException(th2);
            }
        } catch (Throwable th3) {
            writeOutList(channelHandlerContext, this.out, channelPromise);
            throw th3;
        }
    }
}
