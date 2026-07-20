package al;

import androidx.core.app.NotificationCompat;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.http.HttpContent;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends MessageToByteEncoder<HttpContent> {
    @Override // io.netty.handler.codec.MessageToByteEncoder
    @os.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ByteBuf allocateBuffer(@os.l ChannelHandlerContext channelHandlerContext, @os.m HttpContent httpContent, boolean z10) {
        ByteBuf byteBufContent;
        l0.p(channelHandlerContext, "ctx");
        int i10 = 0;
        if (httpContent != null && (byteBufContent = httpContent.content()) != null) {
            i10 = byteBufContent.readableBytes();
        }
        if (i10 == 0) {
            ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
            l0.o(byteBuf, "EMPTY_BUFFER");
            return byteBuf;
        }
        if (z10) {
            ByteBuf byteBufIoBuffer = channelHandlerContext.alloc().ioBuffer(i10);
            l0.o(byteBufIoBuffer, "ctx.alloc().ioBuffer(size)");
            return byteBufIoBuffer;
        }
        ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(i10);
        l0.o(byteBufHeapBuffer, "ctx.alloc().heapBuffer(size)");
        return byteBufHeapBuffer;
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void encode(@os.l ChannelHandlerContext channelHandlerContext, @os.l HttpContent httpContent, @os.l ByteBuf byteBuf) {
        l0.p(channelHandlerContext, "ctx");
        l0.p(httpContent, NotificationCompat.CATEGORY_MESSAGE);
        l0.p(byteBuf, "out");
        byteBuf.writeBytes(httpContent.content());
    }
}
