package io.netty.handler.codec.http.websocketx;

import h.a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/* JADX INFO: loaded from: classes3.dex */
public class CloseWebSocketFrame extends WebSocketFrame {
    public CloseWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    private static ByteBuf newBinaryData(int i10, String str) {
        if (str == null) {
            str = "";
        }
        ByteBuf byteBufBuffer = Unpooled.buffer(str.length() + 2);
        byteBufBuffer.writeShort(i10);
        if (!str.isEmpty()) {
            byteBufBuffer.writeCharSequence(str, CharsetUtil.UTF_8);
        }
        return byteBufBuffer;
    }

    public static int requireValidStatusCode(int i10) {
        if (WebSocketCloseStatus.isValidStatusCode(i10)) {
            return i10;
        }
        throw new IllegalArgumentException(a.a("WebSocket close status code does NOT comply with RFC-6455: ", i10));
    }

    public String reasonText() {
        ByteBuf byteBufContent = content();
        return (byteBufContent == null || byteBufContent.readableBytes() <= 2) ? "" : byteBufContent.toString(byteBufContent.readerIndex() + 2, byteBufContent.readableBytes() - 2, CharsetUtil.UTF_8);
    }

    public int statusCode() {
        ByteBuf byteBufContent = content();
        if (byteBufContent == null || byteBufContent.readableBytes() < 2) {
            return -1;
        }
        return byteBufContent.getUnsignedShort(byteBufContent.readerIndex());
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus) {
        this(requireValidStatusCode(webSocketCloseStatus.code()), webSocketCloseStatus.reasonText());
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus, String str) {
        this(requireValidStatusCode(webSocketCloseStatus.code()), str);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame copy() {
        return (CloseWebSocketFrame) super.copy();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame duplicate() {
        return (CloseWebSocketFrame) super.duplicate();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame replace(ByteBuf byteBuf) {
        return new CloseWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame retainedDuplicate() {
        return (CloseWebSocketFrame) super.retainedDuplicate();
    }

    public CloseWebSocketFrame(int i10, String str) {
        this(true, 0, requireValidStatusCode(i10), str);
    }

    public CloseWebSocketFrame(boolean z10, int i10) {
        this(z10, i10, Unpooled.buffer(0));
    }

    public CloseWebSocketFrame(boolean z10, int i10, int i11, String str) {
        super(z10, i10, newBinaryData(requireValidStatusCode(i11), str));
    }

    public CloseWebSocketFrame(boolean z10, int i10, ByteBuf byteBuf) {
        super(z10, i10, byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain(int i10) {
        super.retain(i10);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
