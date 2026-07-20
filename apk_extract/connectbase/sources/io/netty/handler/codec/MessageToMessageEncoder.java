package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessageToMessageEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    public MessageToMessageEncoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
    }

    private static void writePromiseCombiner(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, ChannelPromise channelPromise) {
        PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
        for (int i10 = 0; i10 < codecOutputList.size(); i10++) {
            promiseCombiner.add(channelHandlerContext.write(codecOutputList.getUnsafe(i10)));
        }
        promiseCombiner.finish(channelPromise);
    }

    private static void writeVoidPromise(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList) {
        ChannelPromise channelPromiseVoidPromise = channelHandlerContext.voidPromise();
        for (int i10 = 0; i10 < codecOutputList.size(); i10++) {
            channelHandlerContext.write(codecOutputList.getUnsafe(i10), channelPromiseVoidPromise);
        }
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i10, List<Object> list) throws Exception;

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        CodecOutputList codecOutputListNewInstance = null;
        try {
            try {
                if (acceptOutboundMessage(obj)) {
                    codecOutputListNewInstance = CodecOutputList.newInstance();
                    try {
                        encode(channelHandlerContext, obj, codecOutputListNewInstance);
                    } catch (Throwable th2) {
                        ReferenceCountUtil.safeRelease(obj);
                        PlatformDependent.throwException(th2);
                    }
                    ReferenceCountUtil.release(obj);
                    if (codecOutputListNewInstance.isEmpty()) {
                        throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                    }
                } else {
                    channelHandlerContext.write(obj, channelPromise);
                }
                if (codecOutputListNewInstance != null) {
                    try {
                        int size = codecOutputListNewInstance.size() - 1;
                        if (size == 0) {
                            channelHandlerContext.write(codecOutputListNewInstance.getUnsafe(0), channelPromise);
                        } else if (size > 0) {
                            if (channelPromise == channelHandlerContext.voidPromise()) {
                                writeVoidPromise(channelHandlerContext, codecOutputListNewInstance);
                            } else {
                                writePromiseCombiner(channelHandlerContext, codecOutputListNewInstance, channelPromise);
                            }
                        }
                    } finally {
                        codecOutputListNewInstance.recycle();
                    }
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    try {
                        int size2 = codecOutputListNewInstance.size() - 1;
                        if (size2 == 0) {
                            channelHandlerContext.write(codecOutputListNewInstance.getUnsafe(0), channelPromise);
                        } else if (size2 > 0) {
                            if (channelPromise == channelHandlerContext.voidPromise()) {
                                writeVoidPromise(channelHandlerContext, null);
                            } else {
                                writePromiseCombiner(channelHandlerContext, null, channelPromise);
                            }
                        }
                    } finally {
                        codecOutputListNewInstance.recycle();
                    }
                }
                throw th3;
            }
        } catch (EncoderException e10) {
            throw e10;
        } catch (Throwable th4) {
            throw new EncoderException(th4);
        }
    }

    public MessageToMessageEncoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }
}
