package io.netty.handler.codec.compression;

import androidx.core.app.FrameMetricsAggregator;
import io.netty.buffer.ByteBuf;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2HuffmanStageEncoder {
    private static final int HUFFMAN_HIGH_SYMBOL_COST = 15;
    private final int[][] huffmanCodeLengths;
    private final int[][] huffmanMergedCodeSymbols;
    private final int mtfAlphabetSize;
    private final char[] mtfBlock;
    private final int mtfLength;
    private final int[] mtfSymbolFrequencies;
    private final byte[] selectors;
    private final Bzip2BitWriter writer;

    public Bzip2HuffmanStageEncoder(Bzip2BitWriter bzip2BitWriter, char[] cArr, int i10, int i11, int[] iArr) {
        this.writer = bzip2BitWriter;
        this.mtfBlock = cArr;
        this.mtfLength = i10;
        this.mtfAlphabetSize = i11;
        this.mtfSymbolFrequencies = iArr;
        int iSelectTableCount = selectTableCount(i10);
        Class cls = Integer.TYPE;
        this.huffmanCodeLengths = (int[][]) Array.newInstance((Class<?>) cls, iSelectTableCount, i11);
        this.huffmanMergedCodeSymbols = (int[][]) Array.newInstance((Class<?>) cls, iSelectTableCount, i11);
        this.selectors = new byte[(i10 + 49) / 50];
    }

    private void assignHuffmanCodeSymbols() {
        int[][] iArr = this.huffmanMergedCodeSymbols;
        int[][] iArr2 = this.huffmanCodeLengths;
        int i10 = this.mtfAlphabetSize;
        int length = iArr2.length;
        for (int i11 = 0; i11 < length; i11++) {
            int[] iArr3 = iArr2[i11];
            int i12 = 32;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = iArr3[i14];
                if (i15 > i13) {
                    i13 = i15;
                }
                if (i15 < i12) {
                    i12 = i15;
                }
            }
            int i16 = 0;
            while (i12 <= i13) {
                for (int i17 = 0; i17 < i10; i17++) {
                    if ((iArr2[i11][i17] & 255) == i12) {
                        iArr[i11][i17] = (i12 << 24) | i16;
                        i16++;
                    }
                }
                i16 <<= 1;
                i12++;
            }
        }
    }

    private static void generateHuffmanCodeLengths(int i10, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[i10];
        int[] iArr4 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr3[i11] = (iArr[i11] << 9) | i11;
        }
        Arrays.sort(iArr3);
        for (int i12 = 0; i12 < i10; i12++) {
            iArr4[i12] = iArr3[i12] >>> 9;
        }
        Bzip2HuffmanAllocator.allocateHuffmanCodeLengths(iArr4, 20);
        for (int i13 = 0; i13 < i10; i13++) {
            iArr2[iArr3[i13] & FrameMetricsAggregator.EVERY_DURATION] = iArr4[i13];
        }
    }

    private void generateHuffmanOptimisationSeeds() {
        int[][] iArr = this.huffmanCodeLengths;
        int[] iArr2 = this.mtfSymbolFrequencies;
        int i10 = this.mtfAlphabetSize;
        int length = iArr.length;
        int i11 = this.mtfLength;
        int i12 = -1;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = length - i13;
            int i15 = i11 / i14;
            int i16 = i12 + 1;
            int i17 = 0;
            while (i17 < i15 && i12 < i10 - 1) {
                i12++;
                i17 += iArr2[i12];
            }
            if (i12 > i16 && i13 != 0 && i13 != length - 1 && (i14 & 1) == 0) {
                i17 -= iArr2[i12];
                i12--;
            }
            int[] iArr3 = iArr[i13];
            for (int i18 = 0; i18 < i10; i18++) {
                if (i18 < i16 || i18 > i12) {
                    iArr3[i18] = 15;
                }
            }
            i11 -= i17;
        }
    }

    private void optimiseSelectorsAndHuffmanTables(boolean z10) {
        char[] cArr = this.mtfBlock;
        byte[] bArr = this.selectors;
        int[][] iArr = this.huffmanCodeLengths;
        int i10 = this.mtfLength;
        int i11 = this.mtfAlphabetSize;
        int length = iArr.length;
        byte b10 = 0;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, i11);
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int iMin = Math.min(i12 + 50, i10);
            int i14 = iMin - 1;
            int[] iArr3 = new int[length];
            for (int i15 = i12; i15 <= i14; i15++) {
                char c10 = cArr[i15];
                for (int i16 = b10; i16 < length; i16++) {
                    iArr3[i16] = iArr3[i16] + iArr[i16][c10];
                }
            }
            int i17 = iArr3[b10];
            byte b11 = b10;
            for (byte b12 = 1; b12 < length; b12 = (byte) (b12 + 1)) {
                int i18 = iArr3[b12];
                if (i18 < i17) {
                    i17 = i18;
                    b11 = b12;
                }
            }
            int[] iArr4 = iArr2[b11];
            while (i12 <= i14) {
                char c11 = cArr[i12];
                iArr4[c11] = iArr4[c11] + 1;
                i12++;
            }
            if (z10) {
                bArr[i13] = b11;
                i13++;
            }
            i12 = iMin;
            b10 = 0;
        }
        for (int i19 = 0; i19 < length; i19++) {
            generateHuffmanCodeLengths(i11, iArr2[i19], iArr[i19]);
        }
    }

    private static int selectTableCount(int i10) {
        if (i10 >= 2400) {
            return 6;
        }
        if (i10 >= 1200) {
            return 5;
        }
        if (i10 >= 600) {
            return 4;
        }
        return i10 >= 200 ? 3 : 2;
    }

    private void writeBlockData(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        int[][] iArr = this.huffmanMergedCodeSymbols;
        byte[] bArr = this.selectors;
        int i10 = this.mtfLength;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int iMin = Math.min(i11 + 50, i10) - 1;
            int i13 = i12 + 1;
            int[] iArr2 = iArr[bArr[i12]];
            while (i11 <= iMin) {
                int i14 = i11 + 1;
                int i15 = iArr2[this.mtfBlock[i11]];
                bzip2BitWriter.writeBits(byteBuf, i15 >>> 24, i15);
                i11 = i14;
            }
            i12 = i13;
        }
    }

    private void writeSelectorsAndHuffmanTables(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        byte[] bArr = this.selectors;
        int length = bArr.length;
        int[][] iArr = this.huffmanCodeLengths;
        int length2 = iArr.length;
        int i10 = this.mtfAlphabetSize;
        int i11 = 3;
        bzip2BitWriter.writeBits(byteBuf, 3, length2);
        bzip2BitWriter.writeBits(byteBuf, 15, length);
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        for (byte b10 : bArr) {
            bzip2BitWriter.writeUnary(byteBuf, bzip2MoveToFrontTable.valueToFront(b10));
        }
        int length3 = iArr.length;
        int i12 = 0;
        while (i12 < length3) {
            int[] iArr2 = iArr[i12];
            int i13 = iArr2[0];
            bzip2BitWriter.writeBits(byteBuf, 5, i13);
            int i14 = 0;
            while (i14 < i10) {
                int i15 = iArr2[i14];
                int i16 = i13 < i15 ? 2 : i11;
                int iAbs = Math.abs(i15 - i13);
                while (true) {
                    int i17 = iAbs - 1;
                    if (iAbs > 0) {
                        bzip2BitWriter.writeBits(byteBuf, 2, i16);
                        iAbs = i17;
                    }
                }
                bzip2BitWriter.writeBoolean(byteBuf, false);
                i14++;
                i13 = i15;
                i11 = 3;
            }
            i12++;
            i11 = 3;
        }
    }

    public void encode(ByteBuf byteBuf) {
        generateHuffmanOptimisationSeeds();
        int i10 = 3;
        while (i10 >= 0) {
            optimiseSelectorsAndHuffmanTables(i10 == 0);
            i10--;
        }
        assignHuffmanCodeSymbols();
        writeSelectorsAndHuffmanTables(byteBuf);
        writeBlockData(byteBuf);
    }
}
