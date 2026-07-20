package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@ChannelHandler.Sharable
public class WebSocket00FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final ByteBuf _0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(0)).asReadOnly();
    private static final ByteBuf _0XFF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(-1)).asReadOnly();
    private static final ByteBuf _0XFF_0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2, 2).writeByte(-1).writeByte(0)).asReadOnly();

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (webSocketFrame instanceof TextWebSocketFrame) {
            ByteBuf byteBufContent = webSocketFrame.content();
            list.add(_0X00.duplicate());
            list.add(byteBufContent.retain());
            list.add(_0XFF.duplicate());
            return;
        }
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            list.add(_0XFF_0X00.duplicate());
            return;
        }
        ByteBuf byteBufContent2 = webSocketFrame.content();
        int i10 = byteBufContent2.readableBytes();
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(5);
        try {
            byteBufBuffer.writeByte(-128);
            int i11 = (i10 >>> 28) & 127;
            int i12 = (i10 >>> 14) & 127;
            int i13 = (i10 >>> 7) & 127;
            int i14 = i10 & 127;
            if (i11 != 0) {
                byteBufBuffer.writeByte(i11 | 128);
                byteBufBuffer.writeByte(i12 | 128);
                byteBufBuffer.writeByte(i13 | 128);
                byteBufBuffer.writeByte(i14);
            } else if (i12 == 0) {
                if (i13 != 0) {
                    byteBufBuffer.writeByte(i13 | 128);
                }
                byteBufBuffer.writeByte(i14);
            } else {
                byteBufBuffer.writeByte(i12 | 128);
                byteBufBuffer.writeByte(i13 | 128);
                byteBufBuffer.writeByte(i14);
            }
            list.add(byteBufBuffer);
            list.add(byteBufContent2.retain());
        } catch (Throwable th2) {
            byteBufBuffer.release();
            throw th2;
        }
    }
}
