package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes3.dex */
public class FastLzFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private final ByteBufChecksum checksum;
    private final int level;

    public FastLzFrameEncoder() {
        this(0, null);
    }

    public FastLzFrameEncoder(int i10) {
        this(i10, null);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    /* JADX WARN: Code duplicated, block: B:29:0x008c A[SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        int iCompress;
        int i10;
        ByteBufChecksum byteBufChecksum = this.checksum;
        while (byteBuf.isReadable()) {
            int i11 = byteBuf.readerIndex();
            int iMin = Math.min(byteBuf.readableBytes(), 65535);
            int iWriterIndex = byteBuf2.writerIndex();
            byteBuf2.setMedium(iWriterIndex, 4607066);
            int i12 = iWriterIndex + 4;
            int i13 = 0;
            int i14 = i12 + (byteBufChecksum != null ? 4 : 0);
            if (iMin < 32) {
                int i15 = i14 + 2;
                byteBuf2.ensureWritable(i15 + iMin);
                if (byteBufChecksum != null) {
                    byteBufChecksum.reset();
                    byteBufChecksum.update(byteBuf, i11, iMin);
                    byteBuf2.setInt(i12, (int) byteBufChecksum.getValue());
                }
                byteBuf2.setBytes(i15, byteBuf, i11, iMin);
            } else {
                if (byteBufChecksum != null) {
                    byteBufChecksum.reset();
                    byteBufChecksum.update(byteBuf, i11, iMin);
                    byteBuf2.setInt(i12, (int) byteBufChecksum.getValue());
                }
                int i16 = i14 + 4;
                byteBuf2.ensureWritable(FastLz.calculateOutputBufferLength(iMin) + i16);
                iCompress = FastLz.compress(byteBuf, byteBuf.readerIndex(), iMin, byteBuf2, i16, this.level);
                if (iCompress < iMin) {
                    byteBuf2.setShort(i14, iCompress);
                    i14 += 2;
                    i10 = 1;
                } else {
                    byteBuf2.setBytes(i14 + 2, byteBuf, i11, iMin);
                }
                byteBuf2.setShort(i14, iMin);
                int i17 = iWriterIndex + 3;
                if (byteBufChecksum != null) {
                    i13 = 16;
                }
                byteBuf2.setByte(i17, i10 | i13);
                byteBuf2.writerIndex(i14 + 2 + iCompress);
                byteBuf.skipBytes(iMin);
            }
            iCompress = iMin;
            i10 = 0;
            byteBuf2.setShort(i14, iMin);
            int i18 = iWriterIndex + 3;
            if (byteBufChecksum != null) {
                i13 = 16;
            }
            byteBuf2.setByte(i18, i10 | i13);
            byteBuf2.writerIndex(i14 + 2 + iCompress);
            byteBuf.skipBytes(iMin);
        }
    }

    public FastLzFrameEncoder(boolean z10) {
        this(0, z10 ? new Adler32() : null);
    }

    public FastLzFrameEncoder(int i10, Checksum checksum) {
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(String.format("level: %d (expected: %d or %d or %d)", Integer.valueOf(i10), 0, 1, 2));
        }
        this.level = i10;
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }
}
