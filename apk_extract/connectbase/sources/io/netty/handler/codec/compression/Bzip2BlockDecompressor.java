package io.netty.handler.codec.compression;

import k.b;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2BlockDecompressor {
    private final int blockCRC;
    private final boolean blockRandomised;
    private final byte[] bwtBlock;
    private int bwtBlockLength;
    private int bwtBytesDecoded;
    private int bwtCurrentMergedPointer;
    private int[] bwtMergedPointers;
    private final int bwtStartPointer;
    int huffmanEndOfBlockSymbol;
    int huffmanInUse16;
    private int mtfValue;
    private int randomIndex;
    private final Bzip2BitReader reader;
    private int repeatCount;
    private int rleAccumulator;
    private int rleRepeat;
    private final Crc32 crc = new Crc32();
    final byte[] huffmanSymbolMap = new byte[256];
    private final int[] bwtByteCounts = new int[256];
    private int rleLastDecodedByte = -1;
    private int randomCount = Bzip2Rand.rNums(0) - 1;
    private final Bzip2MoveToFrontTable symbolMTF = new Bzip2MoveToFrontTable();
    private int repeatIncrement = 1;

    public Bzip2BlockDecompressor(int i10, int i11, boolean z10, int i12, Bzip2BitReader bzip2BitReader) {
        this.bwtBlock = new byte[i10];
        this.blockCRC = i11;
        this.blockRandomised = z10;
        this.bwtStartPointer = i12;
        this.reader = bzip2BitReader;
    }

    private int decodeNextBWTByte() {
        int i10 = this.bwtCurrentMergedPointer;
        int i11 = i10 & 255;
        this.bwtCurrentMergedPointer = this.bwtMergedPointers[i10 >>> 8];
        if (this.blockRandomised) {
            int i12 = this.randomCount - 1;
            this.randomCount = i12;
            if (i12 == 0) {
                i11 ^= 1;
                int i13 = (this.randomIndex + 1) % 512;
                this.randomIndex = i13;
                this.randomCount = Bzip2Rand.rNums(i13);
            }
        }
        this.bwtBytesDecoded++;
        return i11;
    }

    private void initialiseInverseBWT() {
        int i10 = this.bwtStartPointer;
        byte[] bArr = this.bwtBlock;
        int i11 = this.bwtBlockLength;
        int[] iArr = new int[i11];
        int[] iArr2 = new int[256];
        if (i10 < 0 || i10 >= i11) {
            throw new DecompressionException("start pointer invalid");
        }
        System.arraycopy(this.bwtByteCounts, 0, iArr2, 1, 255);
        for (int i12 = 2; i12 <= 255; i12++) {
            iArr2[i12] = iArr2[i12] + iArr2[i12 - 1];
        }
        for (int i13 = 0; i13 < this.bwtBlockLength; i13++) {
            int i14 = bArr[i13] & 255;
            int i15 = iArr2[i14];
            iArr2[i14] = i15 + 1;
            iArr[i15] = (i13 << 8) + i14;
        }
        this.bwtMergedPointers = iArr;
        this.bwtCurrentMergedPointer = iArr[i10];
    }

    public int blockLength() {
        return this.bwtBlockLength;
    }

    public int checkCRC() {
        int crc = this.crc.getCRC();
        if (this.blockCRC == crc) {
            return crc;
        }
        throw new DecompressionException("block CRC error");
    }

    public boolean decodeHuffmanData(Bzip2HuffmanStageDecoder bzip2HuffmanStageDecoder) {
        Bzip2BitReader bzip2BitReader = this.reader;
        byte[] bArr = this.bwtBlock;
        byte[] bArr2 = this.huffmanSymbolMap;
        int length = bArr.length;
        int i10 = this.huffmanEndOfBlockSymbol;
        int[] iArr = this.bwtByteCounts;
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = this.symbolMTF;
        int i11 = this.bwtBlockLength;
        int i12 = this.repeatCount;
        int i13 = this.repeatIncrement;
        int iIndexToFront = this.mtfValue;
        while (bzip2BitReader.hasReadableBits(23)) {
            int iNextSymbol = bzip2HuffmanStageDecoder.nextSymbol();
            if (iNextSymbol == 0) {
                i12 += i13;
                i13 <<= 1;
            } else if (iNextSymbol == 1) {
                i13 <<= 1;
                i12 += i13;
            } else {
                if (i12 > 0) {
                    if (i11 + i12 > length) {
                        throw new DecompressionException("block exceeds declared block size");
                    }
                    byte b10 = bArr2[iIndexToFront];
                    int i14 = b10 & 255;
                    iArr[i14] = iArr[i14] + i12;
                    while (true) {
                        i12--;
                        if (i12 < 0) {
                            break;
                        }
                        bArr[i11] = b10;
                        i11++;
                    }
                    i12 = 0;
                    i13 = 1;
                }
                if (iNextSymbol == i10) {
                    if (i11 > 900000) {
                        throw new DecompressionException(b.a("block length exceeds max block length: ", i11, " > 900000"));
                    }
                    this.bwtBlockLength = i11;
                    initialiseInverseBWT();
                    return true;
                }
                if (i11 >= length) {
                    throw new DecompressionException("block exceeds declared block size");
                }
                iIndexToFront = bzip2MoveToFrontTable.indexToFront(iNextSymbol - 1) & 255;
                byte b11 = bArr2[iIndexToFront];
                int i15 = b11 & 255;
                iArr[i15] = iArr[i15] + 1;
                bArr[i11] = b11;
                i11++;
            }
        }
        this.bwtBlockLength = i11;
        this.repeatCount = i12;
        this.repeatIncrement = i13;
        this.mtfValue = iIndexToFront;
        return false;
    }

    public int read() {
        while (true) {
            int i10 = this.rleRepeat;
            if (i10 >= 1) {
                this.rleRepeat = i10 - 1;
                return this.rleLastDecodedByte;
            }
            if (this.bwtBytesDecoded == this.bwtBlockLength) {
                return -1;
            }
            int iDecodeNextBWTByte = decodeNextBWTByte();
            if (iDecodeNextBWTByte != this.rleLastDecodedByte) {
                this.rleLastDecodedByte = iDecodeNextBWTByte;
                this.rleRepeat = 1;
                this.rleAccumulator = 1;
                this.crc.updateCRC(iDecodeNextBWTByte);
            } else {
                int i11 = this.rleAccumulator + 1;
                this.rleAccumulator = i11;
                if (i11 == 4) {
                    int iDecodeNextBWTByte2 = decodeNextBWTByte() + 1;
                    this.rleRepeat = iDecodeNextBWTByte2;
                    this.rleAccumulator = 0;
                    this.crc.updateCRC(iDecodeNextBWTByte, iDecodeNextBWTByte2);
                } else {
                    this.rleRepeat = 1;
                    this.crc.updateCRC(iDecodeNextBWTByte);
                }
            }
        }
    }
}
