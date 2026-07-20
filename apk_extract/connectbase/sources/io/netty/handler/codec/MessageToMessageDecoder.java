package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessageToMessageDecoder<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    public MessageToMessageDecoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
    }

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        CodecOutputList codecOutputListNewInstance = CodecOutputList.newInstance();
        int i10 = 0;
        try {
            try {
                try {
                    if (acceptInboundMessage(obj)) {
                        try {
                            decode(channelHandlerContext, obj, codecOutputListNewInstance);
                            ReferenceCountUtil.release(obj);
                        } catch (Throwable th2) {
                            ReferenceCountUtil.release(obj);
                            throw th2;
                        }
                    } else {
                        codecOutputListNewInstance.add(obj);
                    }
                    try {
                        int size = codecOutputListNewInstance.size();
                        while (i10 < size) {
                            channelHandlerContext.fireChannelRead(codecOutputListNewInstance.getUnsafe(i10));
                            i10++;
                        }
                        codecOutputListNewInstance.recycle();
                    } catch (Throwable th3) {
                        codecOutputListNewInstance.recycle();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    try {
                        int size2 = codecOutputListNewInstance.size();
                        while (i10 < size2) {
                            channelHandlerContext.fireChannelRead(codecOutputListNewInstance.getUnsafe(i10));
                            i10++;
                        }
                        codecOutputListNewInstance.recycle();
                        throw th4;
                    } catch (Throwable th5) {
                        codecOutputListNewInstance.recycle();
                        throw th5;
                    }
                }
            } catch (Exception e10) {
                throw new DecoderException(e10);
            }
        } catch (DecoderException e11) {
            throw e11;
        }
    }

    public abstract void decode(ChannelHandlerContext channelHandlerContext, I i10, List<Object> list) throws Exception;

    public MessageToMessageDecoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }
}
