package io.netty.handler.codec.http.websocketx;

import h.a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;
import java.util.List;
import wj.t1;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocket08FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final int GATHERING_WRITE_THRESHOLD = 1024;
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameEncoder.class);
    private final boolean maskPayload;

    public WebSocket08FrameEncoder(boolean z10) {
        this.maskPayload = z10;
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        byte b10;
        ByteBuf byteBufBuffer;
        ByteBuf byteBufContent = webSocketFrame.content();
        int i10 = 0;
        if (webSocketFrame instanceof TextWebSocketFrame) {
            b10 = 1;
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            b10 = 9;
        } else if (webSocketFrame instanceof PongWebSocketFrame) {
            b10 = 10;
        } else if (webSocketFrame instanceof CloseWebSocketFrame) {
            b10 = 8;
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            b10 = 2;
        } else {
            if (!(webSocketFrame instanceof ContinuationWebSocketFrame)) {
                throw new UnsupportedOperationException("Cannot encode frame of type: ".concat(webSocketFrame.getClass().getName()));
            }
            b10 = 0;
        }
        int i11 = byteBufContent.readableBytes();
        InternalLogger internalLogger = logger;
        if (internalLogger.isTraceEnabled()) {
            internalLogger.trace("Encoding WebSocket Frame opCode={} length={}", Byte.valueOf(b10), Integer.valueOf(i11));
        }
        int iRsv = ((webSocketFrame.rsv() % 8) << 4) | (webSocketFrame.isFinalFragment() ? 128 : 0) | (b10 % 128);
        if (b10 == 9 && i11 > 125) {
            throw new TooLongFrameException(a.a("invalid payload for PING (payload length must be <= 125, was ", i11));
        }
        ReferenceCounted referenceCounted = null;
        try {
            boolean z10 = this.maskPayload;
            int i12 = z10 ? 4 : 0;
            if (i11 <= 125) {
                byteBufBuffer = channelHandlerContext.alloc().buffer(i12 + 2 + i11);
                byteBufBuffer.writeByte(iRsv);
                byteBufBuffer.writeByte((byte) (this.maskPayload ? ((byte) i11) | 128 : (byte) i11));
            } else {
                int i13 = 255;
                if (i11 <= 65535) {
                    int i14 = i12 + 4;
                    if (z10 || i11 <= 1024) {
                        i14 += i11;
                    }
                    byteBufBuffer = channelHandlerContext.alloc().buffer(i14);
                    byteBufBuffer.writeByte(iRsv);
                    byteBufBuffer.writeByte(this.maskPayload ? t1.N : 126);
                    byteBufBuffer.writeByte((i11 >>> 8) & 255);
                    byteBufBuffer.writeByte(i11 & 255);
                } else {
                    int i15 = i12 + 10;
                    if (z10) {
                        i15 += i11;
                    }
                    byteBufBuffer = channelHandlerContext.alloc().buffer(i15);
                    byteBufBuffer.writeByte(iRsv);
                    if (!this.maskPayload) {
                        i13 = 127;
                    }
                    byteBufBuffer.writeByte(i13);
                    byteBufBuffer.writeLong(i11);
                }
            }
            if (!this.maskPayload) {
                if (byteBufBuffer.writableBytes() >= byteBufContent.readableBytes()) {
                    byteBufBuffer.writeBytes(byteBufContent);
                    list.add(byteBufBuffer);
                    return;
                } else {
                    list.add(byteBufBuffer);
                    list.add(byteBufContent.retain());
                    return;
                }
            }
            int iNextInt = PlatformDependent.threadLocalRandom().nextInt(Integer.MAX_VALUE);
            byteBufBuffer.writeInt(iNextInt);
            if (byteBufContent.isReadable()) {
                ByteOrder byteOrderOrder = byteBufContent.order();
                ByteOrder byteOrderOrder2 = byteBufBuffer.order();
                int i16 = byteBufContent.readerIndex();
                int iWriterIndex = byteBufContent.writerIndex();
                if (byteOrderOrder == byteOrderOrder2) {
                    long j10 = ((long) iNextInt) & 4294967295L;
                    long jReverseBytes = j10 | (j10 << 32);
                    if (byteOrderOrder == ByteOrder.LITTLE_ENDIAN) {
                        jReverseBytes = Long.reverseBytes(jReverseBytes);
                    }
                    int i17 = iWriterIndex - 7;
                    while (i16 < i17) {
                        byteBufBuffer.writeLong(byteBufContent.getLong(i16) ^ jReverseBytes);
                        i16 += 8;
                    }
                    if (i16 < iWriterIndex - 3) {
                        byteBufBuffer.writeInt(byteBufContent.getInt(i16) ^ ((int) jReverseBytes));
                        i16 += 4;
                    }
                }
                while (i16 < iWriterIndex) {
                    byteBufBuffer.writeByte(byteBufContent.getByte(i16) ^ WebSocketUtil.byteAtIndex(iNextInt, i10 & 3));
                    i16++;
                    i10++;
                }
            }
            list.add(byteBufBuffer);
        } catch (Throwable th2) {
            if (0 != 0) {
                referenceCounted.release();
            }
            throw th2;
        }
    }
}
