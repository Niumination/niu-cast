package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.decoder.DecoderJNI;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class BrotliDecoder extends ByteToMessageDecoder {
    private DecoderJNI.Wrapper decoder;
    private boolean destroyed;
    private final int inputBufferSize;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.BrotliDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status;

        static {
            int[] iArr = new int[DecoderJNI.Status.values().length];
            $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status = iArr;
            try {
                iArr[DecoderJNI.Status.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status[DecoderJNI.Status.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status[DecoderJNI.Status.NEEDS_MORE_INPUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status[DecoderJNI.Status.NEEDS_MORE_OUTPUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum State {
        DONE,
        NEEDS_MORE_INPUT,
        ERROR
    }

    static {
        try {
            Brotli.ensureAvailability();
        } catch (Throwable th2) {
            throw new ExceptionInInitializerError(th2);
        }
    }

    public BrotliDecoder() {
        this(8192);
    }

    private State decompress(ByteBuf byteBuf, List<Object> list, ByteBufAllocator byteBufAllocator) {
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$com$aayushatharva$brotli4j$decoder$DecoderJNI$Status[this.decoder.getStatus().ordinal()];
            if (i10 == 1) {
                return State.DONE;
            }
            if (i10 == 2) {
                this.decoder.push(0);
            } else if (i10 == 3) {
                if (this.decoder.hasOutput()) {
                    list.add(pull(byteBufAllocator));
                }
                if (!byteBuf.isReadable()) {
                    return State.NEEDS_MORE_INPUT;
                }
                ByteBuffer inputBuffer = this.decoder.getInputBuffer();
                inputBuffer.clear();
                this.decoder.push(readBytes(byteBuf, inputBuffer));
            } else {
                if (i10 != 4) {
                    return State.ERROR;
                }
                list.add(pull(byteBufAllocator));
            }
        }
    }

    private void destroy() {
        if (this.destroyed) {
            return;
        }
        this.destroyed = true;
        this.decoder.destroy();
    }

    private ByteBuf pull(ByteBufAllocator byteBufAllocator) {
        ByteBuffer byteBufferPull = this.decoder.pull();
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(byteBufferPull.remaining());
        byteBufBuffer.writeBytes(byteBufferPull);
        return byteBufBuffer;
    }

    private static int readBytes(ByteBuf byteBuf, ByteBuffer byteBuffer) {
        int iMin = Math.min(byteBuf.readableBytes(), byteBuffer.remaining());
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(iMin);
        byteBuf.readBytes(byteBufferSlice);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            destroy();
        } finally {
            super.channelInactive(channelHandlerContext);
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.destroyed) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        if (byteBuf.isReadable()) {
            try {
                State stateDecompress = decompress(byteBuf, list, channelHandlerContext.alloc());
                if (stateDecompress == State.DONE) {
                    destroy();
                } else if (stateDecompress == State.ERROR) {
                    throw new DecompressionException("Brotli stream corrupted");
                }
            } catch (Exception e10) {
                destroy();
                throw e10;
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.decoder = new DecoderJNI.Wrapper(this.inputBufferSize);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            destroy();
        } finally {
            super.handlerRemoved0(channelHandlerContext);
        }
    }

    public BrotliDecoder(int i10) {
        this.inputBufferSize = ObjectUtil.checkPositive(i10, "inputBufferSize");
    }
}
