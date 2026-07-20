package al;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends ByteToMessageDecoder {
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(@os.l ChannelHandlerContext channelHandlerContext, @os.l ByteBuf byteBuf, @os.l List<Object> list) {
        l0.p(channelHandlerContext, "ctx");
        l0.p(byteBuf, "buf");
        l0.p(list, "out");
        ByteBuf byteBufCopy = byteBuf.copy();
        l0.o(byteBufCopy, "buf.copy()");
        list.add(byteBufCopy);
        byteBuf.readerIndex(byteBuf.writerIndex());
    }
}
