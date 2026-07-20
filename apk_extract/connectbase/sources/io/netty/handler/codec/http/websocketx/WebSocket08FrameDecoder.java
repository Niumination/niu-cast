package io.netty.handler.codec.http.websocketx;

import c1.c;
import h.a;
import h0.b;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocket08FrameDecoder extends ByteToMessageDecoder implements WebSocketFrameDecoder {
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameDecoder.class);
    private final WebSocketDecoderConfig config;
    private int fragmentedFramesCount;
    private boolean frameFinalFlag;
    private boolean frameMasked;
    private int frameOpcode;
    private int framePayloadLen1;
    private long framePayloadLength;
    private int frameRsv;
    private int mask;
    private boolean receivedClosingHandshake;
    private State state;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State = iArr;
            try {
                iArr[State.READING_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.READING_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.MASKING_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.PAYLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[State.CORRUPT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum State {
        READING_FIRST,
        READING_SECOND,
        READING_SIZE,
        MASKING_KEY,
        PAYLOAD,
        CORRUPT
    }

    public WebSocket08FrameDecoder(boolean z10, boolean z11, int i10) {
        this(z10, z11, i10, false);
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, String str) {
        protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.PROTOCOL_ERROR, str);
    }

    private static int toFrameLength(long j10) {
        if (j10 <= 2147483647L) {
            return (int) j10;
        }
        throw new TooLongFrameException(b.a("Length:", j10));
    }

    private void unmask(ByteBuf byteBuf) {
        int i10 = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex();
        ByteOrder byteOrderOrder = byteBuf.order();
        int iReverseBytes = this.mask;
        long j10 = ((long) iReverseBytes) & 4294967295L;
        long j11 = j10 | (j10 << 32);
        int i11 = iWriterIndex - 7;
        while (i10 < i11) {
            byteBuf.setLong(i10, byteBuf.getLong(i10) ^ j11);
            i10 += 8;
        }
        if (i10 < iWriterIndex - 3) {
            byteBuf.setInt(i10, ((int) j11) ^ byteBuf.getInt(i10));
            i10 += 4;
        }
        if (byteOrderOrder == ByteOrder.LITTLE_ENDIAN) {
            iReverseBytes = Integer.reverseBytes(iReverseBytes);
        }
        int i12 = 0;
        while (i10 < iWriterIndex) {
            byteBuf.setByte(i10, WebSocketUtil.byteAtIndex(iReverseBytes, i12 & 3) ^ byteBuf.getByte(i10));
            i10++;
            i12++;
        }
    }

    public void checkCloseFrameBody(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (byteBuf == null || !byteBuf.isReadable()) {
            return;
        }
        if (byteBuf.readableBytes() < 2) {
            protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "Invalid close frame body");
        }
        short s10 = byteBuf.getShort(byteBuf.readerIndex());
        if (!WebSocketCloseStatus.isValidStatusCode(s10)) {
            protocolViolation(channelHandlerContext, byteBuf, a.a("Invalid close frame getStatus code: ", s10));
        }
        if (byteBuf.readableBytes() > 2) {
            try {
                new Utf8Validator().check(byteBuf, byteBuf.readerIndex() + 2, byteBuf.readableBytes() - 2);
            } catch (CorruptedWebSocketFrameException e10) {
                protocolViolation(channelHandlerContext, byteBuf, e10);
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[this.state.ordinal()]) {
            case 1:
                if (byteBuf.isReadable()) {
                    this.framePayloadLength = 0L;
                    byte b10 = byteBuf.readByte();
                    this.frameFinalFlag = (b10 & 128) != 0;
                    this.frameRsv = (b10 & 112) >> 4;
                    this.frameOpcode = b10 & c.f1123q;
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isTraceEnabled()) {
                        internalLogger.trace("Decoding WebSocket Frame opCode={}", Integer.valueOf(this.frameOpcode));
                    }
                    this.state = State.READING_SECOND;
                    break;
                } else {
                    return;
                }
            case 2:
                if (byteBuf.isReadable()) {
                    byte b11 = byteBuf.readByte();
                    this.frameMasked = (b11 & 128) != 0;
                    this.framePayloadLen1 = b11 & 127;
                    if (this.frameRsv != 0 && !this.config.allowExtensions()) {
                        protocolViolation(channelHandlerContext, byteBuf, "RSV != 0 and no extension negotiated, RSV:" + this.frameRsv);
                        return;
                    }
                    if (!this.config.allowMaskMismatch() && this.config.expectMaskedFrames() != this.frameMasked) {
                        protocolViolation(channelHandlerContext, byteBuf, "received a frame that is not masked as expected");
                        return;
                    }
                    int i10 = this.frameOpcode;
                    if (i10 > 7) {
                        if (!this.frameFinalFlag) {
                            protocolViolation(channelHandlerContext, byteBuf, "fragmented control frame");
                            return;
                        }
                        int i11 = this.framePayloadLen1;
                        if (i11 > 125) {
                            protocolViolation(channelHandlerContext, byteBuf, "control frame with payload length > 125 octets");
                            return;
                        }
                        if (i10 != 8 && i10 != 9 && i10 != 10) {
                            protocolViolation(channelHandlerContext, byteBuf, "control frame using reserved opcode " + this.frameOpcode);
                            return;
                        } else if (i10 == 8 && i11 == 1) {
                            protocolViolation(channelHandlerContext, byteBuf, "received close control frame with payload len 1");
                            return;
                        }
                    } else {
                        if (i10 != 0 && i10 != 1 && i10 != 2) {
                            protocolViolation(channelHandlerContext, byteBuf, "data frame using reserved opcode " + this.frameOpcode);
                            return;
                        }
                        int i12 = this.fragmentedFramesCount;
                        if (i12 == 0 && i10 == 0) {
                            protocolViolation(channelHandlerContext, byteBuf, "received continuation data frame outside fragmented message");
                            return;
                        } else if (i12 != 0 && i10 != 0) {
                            protocolViolation(channelHandlerContext, byteBuf, "received non-continuation data frame while inside fragmented message");
                            return;
                        }
                    }
                    this.state = State.READING_SIZE;
                    break;
                } else {
                    return;
                }
            case 3:
                int i13 = this.framePayloadLen1;
                if (i13 == 126) {
                    if (byteBuf.readableBytes() < 2) {
                        return;
                    }
                    long unsignedShort = byteBuf.readUnsignedShort();
                    this.framePayloadLength = unsignedShort;
                    if (unsignedShort < 126) {
                        protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                        return;
                    }
                } else if (i13 != 127) {
                    this.framePayloadLength = i13;
                } else {
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    long j10 = byteBuf.readLong();
                    this.framePayloadLength = j10;
                    if (j10 < 0) {
                        protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (negative length)");
                        return;
                    } else if (j10 < 65536) {
                        protocolViolation(channelHandlerContext, byteBuf, "invalid data frame length (not using minimal length encoding)");
                        return;
                    }
                }
                if (this.framePayloadLength <= this.config.maxFramePayloadLength()) {
                    InternalLogger internalLogger2 = logger;
                    if (internalLogger2.isTraceEnabled()) {
                        internalLogger2.trace("Decoding WebSocket Frame length={}", Long.valueOf(this.framePayloadLength));
                    }
                    this.state = State.MASKING_KEY;
                    break;
                } else {
                    protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.MESSAGE_TOO_BIG, "Max frame length of " + this.config.maxFramePayloadLength() + " has been exceeded.");
                    return;
                }
            case 4:
                if (this.frameMasked) {
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    } else {
                        this.mask = byteBuf.readInt();
                    }
                }
                this.state = State.PAYLOAD;
            case 5:
                long j11 = byteBuf.readableBytes();
                long j12 = this.framePayloadLength;
                if (j11 < j12) {
                    return;
                }
                ByteBuf bytes = Unpooled.EMPTY_BUFFER;
                if (j12 > 0) {
                    try {
                        bytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, toFrameLength(this.framePayloadLength));
                    } catch (Throwable th2) {
                        if (bytes != null) {
                            bytes.release();
                        }
                        throw th2;
                    }
                }
                this.state = State.READING_FIRST;
                if (this.frameMasked & (this.framePayloadLength > 0)) {
                    unmask(bytes);
                }
                int i14 = this.frameOpcode;
                if (i14 == 9) {
                    list.add(new PingWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                    return;
                }
                if (i14 == 10) {
                    list.add(new PongWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                    return;
                }
                if (i14 == 8) {
                    this.receivedClosingHandshake = true;
                    checkCloseFrameBody(channelHandlerContext, bytes);
                    list.add(new CloseWebSocketFrame(this.frameFinalFlag, this.frameRsv, bytes));
                    return;
                }
                boolean z10 = this.frameFinalFlag;
                if (z10) {
                    this.fragmentedFramesCount = 0;
                } else {
                    this.fragmentedFramesCount++;
                }
                if (i14 == 1) {
                    list.add(new TextWebSocketFrame(z10, this.frameRsv, bytes));
                    return;
                }
                if (i14 == 2) {
                    list.add(new BinaryWebSocketFrame(z10, this.frameRsv, bytes));
                    return;
                } else if (i14 == 0) {
                    list.add(new ContinuationWebSocketFrame(z10, this.frameRsv, bytes));
                    return;
                } else {
                    throw new UnsupportedOperationException("Cannot decode web socket frame with opcode: " + this.frameOpcode);
                }
            case 6:
                if (byteBuf.isReadable()) {
                    byteBuf.readByte();
                    return;
                }
                return;
            default:
                throw new Error("Shouldn't reach here.");
        }
    }

    public WebSocket08FrameDecoder(boolean z10, boolean z11, int i10, boolean z12) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z10).allowExtensions(z11).maxFramePayloadLength(i10).allowMaskMismatch(z12).build());
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, WebSocketCloseStatus webSocketCloseStatus, String str) {
        protocolViolation(channelHandlerContext, byteBuf, new CorruptedWebSocketFrameException(webSocketCloseStatus, str));
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, CorruptedWebSocketFrameException corruptedWebSocketFrameException) {
        Object closeWebSocketFrame;
        this.state = State.CORRUPT;
        int i10 = byteBuf.readableBytes();
        if (i10 > 0) {
            byteBuf.skipBytes(i10);
        }
        if (channelHandlerContext.channel().isActive() && this.config.closeOnProtocolViolation()) {
            if (!this.receivedClosingHandshake) {
                WebSocketCloseStatus webSocketCloseStatusCloseStatus = corruptedWebSocketFrameException.closeStatus();
                String message = corruptedWebSocketFrameException.getMessage();
                if (message == null) {
                    message = webSocketCloseStatusCloseStatus.reasonText();
                }
                closeWebSocketFrame = new CloseWebSocketFrame(webSocketCloseStatusCloseStatus, message);
            } else {
                closeWebSocketFrame = Unpooled.EMPTY_BUFFER;
            }
            channelHandlerContext.writeAndFlush(closeWebSocketFrame).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            throw corruptedWebSocketFrameException;
        }
        throw corruptedWebSocketFrameException;
    }

    public WebSocket08FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.state = State.READING_FIRST;
        this.config = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }
}
