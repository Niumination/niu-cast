package io.netty.handler.codec.json;

import h.b;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class JsonObjectDecoder extends ByteToMessageDecoder {
    private static final int ST_CORRUPTED = -1;
    private static final int ST_DECODING_ARRAY_STREAM = 2;
    private static final int ST_DECODING_NORMAL = 1;
    private static final int ST_INIT = 0;
    private int idx;
    private boolean insideString;
    private int lastReaderIndex;
    private final int maxObjectLength;
    private int openBraces;
    private int state;
    private final boolean streamArrayElements;

    public JsonObjectDecoder() {
        this(1048576);
    }

    private void decodeByte(byte b10, ByteBuf byteBuf, int i10) {
        if ((b10 == 123 || b10 == 91) && !this.insideString) {
            this.openBraces++;
            return;
        }
        if ((b10 == 125 || b10 == 93) && !this.insideString) {
            this.openBraces--;
            return;
        }
        if (b10 == 34) {
            if (!this.insideString) {
                this.insideString = true;
                return;
            }
            int i11 = 0;
            for (int i12 = i10 - 1; i12 >= 0 && byteBuf.getByte(i12) == 92; i12--) {
                i11++;
            }
            if (i11 % 2 == 0) {
                this.insideString = false;
            }
        }
    }

    private void initDecoding(byte b10) {
        this.openBraces = 1;
        if (b10 == 91 && this.streamArrayElements) {
            this.state = 2;
        } else {
            this.state = 1;
        }
    }

    private void reset() {
        this.insideString = false;
        this.state = 0;
        this.openBraces = 0;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i10;
        if (this.state == -1) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        if (this.idx > byteBuf.readerIndex() && this.lastReaderIndex != byteBuf.readerIndex()) {
            this.idx = (this.idx - this.lastReaderIndex) + byteBuf.readerIndex();
        }
        int i11 = this.idx;
        int iWriterIndex = byteBuf.writerIndex();
        if (iWriterIndex > this.maxObjectLength) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            reset();
            throw new TooLongFrameException("object length exceeds " + this.maxObjectLength + ": " + iWriterIndex + " bytes discarded");
        }
        while (i11 < iWriterIndex) {
            byte b10 = byteBuf.getByte(i11);
            int i12 = this.state;
            if (i12 == 1) {
                decodeByte(b10, byteBuf, i11);
                if (this.openBraces == 0) {
                    int i13 = i11 + 1;
                    ByteBuf byteBufExtractObject = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i13 - byteBuf.readerIndex());
                    if (byteBufExtractObject != null) {
                        list.add(byteBufExtractObject);
                    }
                    byteBuf.readerIndex(i13);
                    reset();
                }
            } else if (i12 == 2) {
                decodeByte(b10, byteBuf, i11);
                if (!this.insideString && (((i10 = this.openBraces) == 1 && b10 == 44) || (i10 == 0 && b10 == 93))) {
                    for (int i14 = byteBuf.readerIndex(); Character.isWhitespace(byteBuf.getByte(i14)); i14++) {
                        byteBuf.skipBytes(1);
                    }
                    int i15 = i11 - 1;
                    while (i15 >= byteBuf.readerIndex() && Character.isWhitespace(byteBuf.getByte(i15))) {
                        i15--;
                    }
                    ByteBuf byteBufExtractObject2 = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), (i15 + 1) - byteBuf.readerIndex());
                    if (byteBufExtractObject2 != null) {
                        list.add(byteBufExtractObject2);
                    }
                    byteBuf.readerIndex(i11 + 1);
                    if (b10 == 93) {
                        reset();
                    }
                }
            } else if (b10 == 123 || b10 == 91) {
                initDecoding(b10);
                if (this.state == 2) {
                    byteBuf.skipBytes(1);
                }
            } else {
                if (!Character.isWhitespace(b10)) {
                    this.state = -1;
                    StringBuilder sbA = b.a("invalid JSON received at byte position ", i11, ": ");
                    sbA.append(ByteBufUtil.hexDump(byteBuf));
                    throw new CorruptedFrameException(sbA.toString());
                }
                byteBuf.skipBytes(1);
            }
            i11++;
        }
        if (byteBuf.readableBytes() == 0) {
            this.idx = 0;
        } else {
            this.idx = i11;
        }
        this.lastReaderIndex = byteBuf.readerIndex();
    }

    public ByteBuf extractObject(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, int i11) {
        return byteBuf.retainedSlice(i10, i11);
    }

    public JsonObjectDecoder(int i10) {
        this(i10, false);
    }

    public JsonObjectDecoder(boolean z10) {
        this(1048576, z10);
    }

    public JsonObjectDecoder(int i10, boolean z10) {
        this.maxObjectLength = ObjectUtil.checkPositive(i10, "maxObjectLength");
        this.streamArrayElements = z10;
    }
}
