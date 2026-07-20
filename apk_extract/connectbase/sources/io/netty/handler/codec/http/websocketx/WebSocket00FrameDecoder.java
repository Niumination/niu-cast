package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocket00FrameDecoder extends ReplayingDecoder<Void> implements WebSocketFrameDecoder {
    static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    private final long maxFrameSize;
    private boolean receivedClosingHandshake;

    public WebSocket00FrameDecoder() {
        this(16384);
    }

    private WebSocketFrame decodeBinaryFrame(ChannelHandlerContext channelHandlerContext, byte b10, ByteBuf byteBuf) {
        byte b11;
        long j10 = 0;
        int i10 = 0;
        do {
            b11 = byteBuf.readByte();
            j10 = (j10 << 7) | ((long) (b11 & 127));
            if (j10 > this.maxFrameSize) {
                throw new TooLongFrameException();
            }
            i10++;
            if (i10 > 8) {
                throw new TooLongFrameException();
            }
        } while ((b11 & 128) == 128);
        if (b10 != -1 || j10 != 0) {
            return new BinaryWebSocketFrame(ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, (int) j10));
        }
        this.receivedClosingHandshake = true;
        return new CloseWebSocketFrame(true, 0, channelHandlerContext.alloc().buffer(0));
    }

    private WebSocketFrame decodeTextFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int i10 = byteBuf.readerIndex();
        int iActualReadableBytes = actualReadableBytes();
        int iIndexOf = byteBuf.indexOf(i10, i10 + iActualReadableBytes, (byte) -1);
        if (iIndexOf == -1) {
            if (iActualReadableBytes <= this.maxFrameSize) {
                return null;
            }
            throw new TooLongFrameException();
        }
        int i11 = iIndexOf - i10;
        if (i11 > this.maxFrameSize) {
            throw new TooLongFrameException();
        }
        ByteBuf bytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, i11);
        byteBuf.skipBytes(1);
        if (bytes.indexOf(bytes.readerIndex(), bytes.writerIndex(), (byte) -1) < 0) {
            return new TextWebSocketFrame(bytes);
        }
        bytes.release();
        throw new IllegalArgumentException("a text frame should not contain 0xFF.");
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        byte b10 = byteBuf.readByte();
        WebSocketFrame webSocketFrameDecodeBinaryFrame = (b10 & 128) == 128 ? decodeBinaryFrame(channelHandlerContext, b10, byteBuf) : decodeTextFrame(channelHandlerContext, byteBuf);
        if (webSocketFrameDecodeBinaryFrame != null) {
            list.add(webSocketFrameDecodeBinaryFrame);
        }
    }

    public WebSocket00FrameDecoder(int i10) {
        this.maxFrameSize = i10;
    }

    public WebSocket00FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.maxFrameSize = ((WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig")).maxFramePayloadLength();
    }
}
