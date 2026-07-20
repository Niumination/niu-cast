package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.Unmarshaller;

/* JADX INFO: loaded from: classes3.dex */
public class CompatibleMarshallingDecoder extends ReplayingDecoder<Void> {
    private boolean discardingTooLongFrame;
    protected final int maxObjectSize;
    protected final UnmarshallerProvider provider;

    public CompatibleMarshallingDecoder(UnmarshallerProvider unmarshallerProvider, int i10) {
        this.provider = unmarshallerProvider;
        this.maxObjectSize = i10;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.discardingTooLongFrame) {
            byteBuf.skipBytes(actualReadableBytes());
            checkpoint();
            return;
        }
        Unmarshaller unmarshaller = this.provider.getUnmarshaller(channelHandlerContext);
        ByteInput channelBufferByteInput = new ChannelBufferByteInput(byteBuf);
        if (this.maxObjectSize != Integer.MAX_VALUE) {
            channelBufferByteInput = new LimitingByteInput(channelBufferByteInput, this.maxObjectSize);
        }
        try {
            try {
                unmarshaller.start(channelBufferByteInput);
                Object object = unmarshaller.readObject();
                unmarshaller.finish();
                list.add(object);
                unmarshaller.close();
            } catch (LimitingByteInput.TooBigObjectException unused) {
                this.discardingTooLongFrame = true;
                throw new TooLongFrameException();
            }
        } catch (Throwable th2) {
            unmarshaller.close();
            throw th2;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i10 = byteBuf.readableBytes();
        if (i10 != 0) {
            if (i10 == 1 && byteBuf.getByte(byteBuf.readerIndex()) == 121) {
                byteBuf.skipBytes(1);
            } else {
                decode(channelHandlerContext, byteBuf, list);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        if (th2 instanceof TooLongFrameException) {
            channelHandlerContext.close();
        } else {
            super.exceptionCaught(channelHandlerContext, th2);
        }
    }
}
