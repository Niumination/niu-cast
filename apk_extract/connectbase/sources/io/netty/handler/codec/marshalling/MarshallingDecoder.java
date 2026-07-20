package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.jboss.marshalling.Unmarshaller;

/* JADX INFO: loaded from: classes3.dex */
public class MarshallingDecoder extends LengthFieldBasedFrameDecoder {
    private final UnmarshallerProvider provider;

    public MarshallingDecoder(UnmarshallerProvider unmarshallerProvider) {
        this(unmarshallerProvider, 1048576);
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        Unmarshaller unmarshaller = this.provider.getUnmarshaller(channelHandlerContext);
        try {
            unmarshaller.start(new ChannelBufferByteInput(byteBuf2));
            Object object = unmarshaller.readObject();
            unmarshaller.finish();
            return object;
        } finally {
            unmarshaller.close();
        }
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    public ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, int i11) {
        return byteBuf.slice(i10, i11);
    }

    public MarshallingDecoder(UnmarshallerProvider unmarshallerProvider, int i10) {
        super(i10, 0, 4, 0, 4);
        this.provider = unmarshallerProvider;
    }
}
