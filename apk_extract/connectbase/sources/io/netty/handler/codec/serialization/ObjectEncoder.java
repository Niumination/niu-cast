package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
@ChannelHandler.Sharable
@Deprecated
public class ObjectEncoder extends MessageToByteEncoder<Serializable> {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) throws Exception {
        int iWriterIndex = byteBuf.writerIndex();
        ByteBufOutputStream byteBufOutputStream = new ByteBufOutputStream(byteBuf);
        CompactObjectOutputStream compactObjectOutputStream = null;
        try {
            byteBufOutputStream.write(LENGTH_PLACEHOLDER);
            CompactObjectOutputStream compactObjectOutputStream2 = new CompactObjectOutputStream(byteBufOutputStream);
            try {
                compactObjectOutputStream2.writeObject(serializable);
                compactObjectOutputStream2.flush();
                compactObjectOutputStream2.close();
                byteBuf.setInt(iWriterIndex, (byteBuf.writerIndex() - iWriterIndex) - 4);
            } catch (Throwable th2) {
                th = th2;
                compactObjectOutputStream = compactObjectOutputStream2;
                if (compactObjectOutputStream != null) {
                    compactObjectOutputStream.close();
                } else {
                    byteBufOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
