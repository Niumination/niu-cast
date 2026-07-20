package io.netty.handler.codec.compression;

import h.a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/* JADX INFO: loaded from: classes3.dex */
public class SnappyFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_COMPRESSIBLE_LENGTH = 18;
    private static final byte[] STREAM_START = {-1, 6, 0, 0, 115, 78, 97, 80, 112, 89};
    private final Snappy snappy = new Snappy();
    private boolean started;

    private static void calculateAndWriteChecksum(ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf2.writeIntLE(Snappy.calculateChecksum(byteBuf));
    }

    private static void setChunkLength(ByteBuf byteBuf, int i10) {
        int iWriterIndex = (byteBuf.writerIndex() - i10) - 3;
        if ((iWriterIndex >>> 24) != 0) {
            throw new CompressionException(a.a("compressed data too large: ", iWriterIndex));
        }
        byteBuf.setMediumLE(i10, iWriterIndex);
    }

    private static void writeChunkLength(ByteBuf byteBuf, int i10) {
        byteBuf.writeMediumLE(i10);
    }

    private static void writeUnencodedChunk(ByteBuf byteBuf, ByteBuf byteBuf2, int i10) {
        byteBuf2.writeByte(1);
        writeChunkLength(byteBuf2, i10 + 4);
        calculateAndWriteChecksum(byteBuf, byteBuf2);
        byteBuf2.writeBytes(byteBuf, i10);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        if (!byteBuf.isReadable()) {
            return;
        }
        if (!this.started) {
            this.started = true;
            byteBuf2.writeBytes(STREAM_START);
        }
        int i10 = byteBuf.readableBytes();
        if (i10 <= 18) {
            writeUnencodedChunk(byteBuf, byteBuf2, i10);
            return;
        }
        while (true) {
            int iWriterIndex = byteBuf2.writerIndex() + 1;
            if (i10 < 18) {
                writeUnencodedChunk(byteBuf.readSlice(i10), byteBuf2, i10);
                return;
            }
            byteBuf2.writeInt(0);
            if (i10 <= 32767) {
                ByteBuf slice = byteBuf.readSlice(i10);
                calculateAndWriteChecksum(slice, byteBuf2);
                this.snappy.encode(slice, byteBuf2, i10);
                setChunkLength(byteBuf2, iWriterIndex);
                return;
            }
            ByteBuf slice2 = byteBuf.readSlice(32767);
            calculateAndWriteChecksum(slice2, byteBuf2);
            this.snappy.encode(slice2, byteBuf2, 32767);
            setChunkLength(byteBuf2, iWriterIndex);
            i10 -= 32767;
        }
    }
}
