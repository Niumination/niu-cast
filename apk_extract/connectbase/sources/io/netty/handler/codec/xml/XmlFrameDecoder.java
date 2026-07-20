package io.netty.handler.codec.xml;

import c.a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class XmlFrameDecoder extends ByteToMessageDecoder {
    private final int maxFrameLength;

    public XmlFrameDecoder(int i10) {
        this.maxFrameLength = ObjectUtil.checkPositive(i10, "maxFrameLength");
    }

    private static ByteBuf extractFrame(ByteBuf byteBuf, int i10, int i11) {
        return byteBuf.copy(i10, i11);
    }

    private void fail(long j10) {
        if (j10 <= 0) {
            throw new TooLongFrameException(a.a(new StringBuilder("frame length exceeds "), this.maxFrameLength, " - discarding"));
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j10 + " - discarded");
    }

    private static boolean isCDATABlockStart(ByteBuf byteBuf, int i10) {
        return i10 < byteBuf.writerIndex() + (-8) && byteBuf.getByte(i10 + 2) == 91 && byteBuf.getByte(i10 + 3) == 67 && byteBuf.getByte(i10 + 4) == 68 && byteBuf.getByte(i10 + 5) == 65 && byteBuf.getByte(i10 + 6) == 84 && byteBuf.getByte(i10 + 7) == 65 && byteBuf.getByte(i10 + 8) == 91;
    }

    private static boolean isCommentBlockStart(ByteBuf byteBuf, int i10) {
        return i10 < byteBuf.writerIndex() + (-3) && byteBuf.getByte(i10 + 2) == 45 && byteBuf.getByte(i10 + 3) == 45;
    }

    private static boolean isValidStartCharForXmlElement(byte b10) {
        return (b10 >= 97 && b10 <= 122) || (b10 >= 65 && b10 <= 90) || b10 == 58 || b10 == 95;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i10;
        int i11;
        int iWriterIndex = byteBuf.writerIndex();
        if (iWriterIndex > this.maxFrameLength) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            fail(iWriterIndex);
            return;
        }
        boolean z10 = false;
        int i12 = 0;
        boolean z11 = false;
        long j10 = 0;
        int i13 = 0;
        boolean z12 = false;
        for (int i14 = byteBuf.readerIndex(); i14 < iWriterIndex; i14++) {
            byte b10 = byteBuf.getByte(i14);
            if (!z10 && Character.isWhitespace(b10)) {
                i12++;
            } else {
                if (!z10 && b10 != 60) {
                    fail(channelHandlerContext);
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                }
                if (!z11 && b10 == 60) {
                    int i15 = iWriterIndex - 1;
                    z10 = true;
                    if (i14 < i15) {
                        byte b11 = byteBuf.getByte(i14 + 1);
                        if (b11 == 47) {
                            for (int i16 = i14 + 2; i16 <= i15; i16++) {
                                if (byteBuf.getByte(i16) == 62) {
                                    j10--;
                                    break;
                                    break;
                                }
                            }
                        } else if (isValidStartCharForXmlElement(b11)) {
                            j10++;
                            z12 = true;
                        } else if (b11 == 33) {
                            if (isCommentBlockStart(byteBuf, i14)) {
                                j10++;
                            } else if (isCDATABlockStart(byteBuf, i14)) {
                                j10++;
                                z11 = true;
                            }
                        } else if (b11 == 63) {
                            j10++;
                        }
                    }
                } else if (!z11 && b10 == 47) {
                    if (i14 < iWriterIndex - 1 && byteBuf.getByte(i14 + 1) == 62) {
                        j10--;
                        break;
                    }
                } else if (b10 == 62) {
                    i13 = i14 + 1;
                    int i17 = i14 - 1;
                    if (i17 > -1) {
                        byte b12 = byteBuf.getByte(i17);
                        if (z11) {
                            if (b12 == 93 && (i10 = i14 - 2) > -1 && byteBuf.getByte(i10) == 93) {
                                j10--;
                                z11 = false;
                            }
                        } else if (b12 == 63 || (b12 == 45 && (i11 = i14 - 2) > -1 && byteBuf.getByte(i11) == 45)) {
                            j10--;
                        }
                    }
                    if (z12 && j10 == 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        int i18 = byteBuf.readerIndex();
        int i19 = i13 - i18;
        if (j10 != 0 || i19 <= 0) {
            return;
        }
        if (i18 + i19 >= iWriterIndex) {
            i19 = byteBuf.readableBytes();
        }
        ByteBuf byteBufExtractFrame = extractFrame(byteBuf, i18 + i12, i19 - i12);
        byteBuf.skipBytes(i19);
        list.add(byteBufExtractFrame);
    }

    private static void fail(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireExceptionCaught((Throwable) new CorruptedFrameException("frame contains content before the xml starts"));
    }
}
