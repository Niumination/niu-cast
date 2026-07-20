package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2BlockCompressor {
    private final byte[] block;
    private int blockLength;
    private final int blockLengthLimit;
    private final int[] bwtBlock;
    private int rleLength;
    private final Bzip2BitWriter writer;
    private final ByteProcessor writeProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.Bzip2BlockCompressor.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) throws Exception {
            return Bzip2BlockCompressor.this.write(b10);
        }
    };
    private final Crc32 crc = new Crc32();
    private final boolean[] blockValuesPresent = new boolean[256];
    private int rleCurrentValue = -1;

    public Bzip2BlockCompressor(Bzip2BitWriter bzip2BitWriter, int i10) {
        this.writer = bzip2BitWriter;
        int i11 = i10 + 1;
        this.block = new byte[i11];
        this.bwtBlock = new int[i11];
        this.blockLengthLimit = i10 - 6;
    }

    private void writeRun(int i10, int i11) {
        int i12 = this.blockLength;
        byte[] bArr = this.block;
        this.blockValuesPresent[i10] = true;
        this.crc.updateCRC(i10, i11);
        byte b10 = (byte) i10;
        if (i11 == 1) {
            bArr[i12] = b10;
            this.blockLength = i12 + 1;
            return;
        }
        if (i11 == 2) {
            bArr[i12] = b10;
            bArr[i12 + 1] = b10;
            this.blockLength = i12 + 2;
        } else {
            if (i11 == 3) {
                bArr[i12] = b10;
                bArr[i12 + 1] = b10;
                bArr[i12 + 2] = b10;
                this.blockLength = i12 + 3;
                return;
            }
            int i13 = i11 - 4;
            this.blockValuesPresent[i13] = true;
            bArr[i12] = b10;
            bArr[i12 + 1] = b10;
            bArr[i12 + 2] = b10;
            bArr[i12 + 3] = b10;
            bArr[i12 + 4] = (byte) i13;
            this.blockLength = i12 + 5;
        }
    }

    private void writeSymbolMap(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        boolean[] zArr = this.blockValuesPresent;
        boolean[] zArr2 = new boolean[16];
        for (int i10 = 0; i10 < 16; i10++) {
            int i11 = i10 << 4;
            int i12 = 0;
            while (i12 < 16) {
                if (zArr[i11]) {
                    zArr2[i10] = true;
                    break;
                } else {
                    i12++;
                    i11++;
                }
            }
        }
        for (int i13 = 0; i13 < 16; i13++) {
            bzip2BitWriter.writeBoolean(byteBuf, zArr2[i13]);
        }
        for (int i14 = 0; i14 < 16; i14++) {
            if (zArr2[i14]) {
                int i15 = i14 << 4;
                int i16 = 0;
                while (i16 < 16) {
                    bzip2BitWriter.writeBoolean(byteBuf, zArr[i15]);
                    i16++;
                    i15++;
                }
            }
        }
    }

    public int availableSize() {
        int i10 = this.blockLength;
        return i10 == 0 ? this.blockLengthLimit + 2 : (this.blockLengthLimit - i10) + 1;
    }

    public void close(ByteBuf byteBuf) {
        int i10 = this.rleLength;
        if (i10 > 0) {
            writeRun(this.rleCurrentValue & 255, i10);
        }
        byte[] bArr = this.block;
        bArr[this.blockLength] = bArr[0];
        int iBwt = new Bzip2DivSufSort(this.block, this.bwtBlock, this.blockLength).bwt();
        Bzip2BitWriter bzip2BitWriter = this.writer;
        bzip2BitWriter.writeBits(byteBuf, 24, 3227993L);
        bzip2BitWriter.writeBits(byteBuf, 24, 2511705L);
        bzip2BitWriter.writeInt(byteBuf, this.crc.getCRC());
        bzip2BitWriter.writeBoolean(byteBuf, false);
        bzip2BitWriter.writeBits(byteBuf, 24, iBwt);
        writeSymbolMap(byteBuf);
        Bzip2MTFAndRLE2StageEncoder bzip2MTFAndRLE2StageEncoder = new Bzip2MTFAndRLE2StageEncoder(this.bwtBlock, this.blockLength, this.blockValuesPresent);
        bzip2MTFAndRLE2StageEncoder.encode();
        new Bzip2HuffmanStageEncoder(bzip2BitWriter, bzip2MTFAndRLE2StageEncoder.mtfBlock(), bzip2MTFAndRLE2StageEncoder.mtfLength(), bzip2MTFAndRLE2StageEncoder.mtfAlphabetSize(), bzip2MTFAndRLE2StageEncoder.mtfSymbolFrequencies()).encode(byteBuf);
    }

    public int crc() {
        return this.crc.getCRC();
    }

    public boolean isEmpty() {
        return this.blockLength == 0 && this.rleLength == 0;
    }

    public boolean isFull() {
        return this.blockLength > this.blockLengthLimit;
    }

    public boolean write(int i10) {
        if (this.blockLength > this.blockLengthLimit) {
            return false;
        }
        int i11 = this.rleCurrentValue;
        int i12 = this.rleLength;
        if (i12 == 0) {
            this.rleCurrentValue = i10;
            this.rleLength = 1;
        } else if (i11 != i10) {
            writeRun(i11 & 255, i12);
            this.rleCurrentValue = i10;
            this.rleLength = 1;
        } else if (i12 == 254) {
            writeRun(i11 & 255, 255);
            this.rleLength = 0;
        } else {
            this.rleLength = i12 + 1;
        }
        return true;
    }

    public int write(ByteBuf byteBuf, int i10, int i11) {
        int iForEachByte = byteBuf.forEachByte(i10, i11, this.writeProcessor);
        return iForEachByte == -1 ? i11 : iForEachByte - i10;
    }
}
