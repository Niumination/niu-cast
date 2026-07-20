package io.netty.handler.codec.compression;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2HuffmanStageDecoder {
    final int alphabetSize;
    private final int[][] codeBases;
    private final int[][] codeLimits;
    private final int[][] codeSymbols;
    int currentAlpha;
    int currentGroup;
    int currentSelector;
    private int currentTable;
    private final int[] minimumLengths;
    boolean modifyLength;
    private final Bzip2BitReader reader;
    byte[] selectors;
    final byte[][] tableCodeLengths;
    final int totalTables;
    private int groupIndex = -1;
    private int groupPosition = -1;
    final Bzip2MoveToFrontTable tableMTF = new Bzip2MoveToFrontTable();
    int currentLength = -1;

    public Bzip2HuffmanStageDecoder(Bzip2BitReader bzip2BitReader, int i10, int i11) {
        this.reader = bzip2BitReader;
        this.totalTables = i10;
        this.alphabetSize = i11;
        this.minimumLengths = new int[i10];
        Class cls = Integer.TYPE;
        this.codeBases = (int[][]) Array.newInstance((Class<?>) cls, i10, 25);
        this.codeLimits = (int[][]) Array.newInstance((Class<?>) cls, i10, 24);
        this.codeSymbols = (int[][]) Array.newInstance((Class<?>) cls, i10, 258);
        this.tableCodeLengths = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i10, 258);
    }

    public void createHuffmanDecodingTables() {
        int i10 = this.alphabetSize;
        int i11 = 0;
        while (true) {
            byte[][] bArr = this.tableCodeLengths;
            if (i11 >= bArr.length) {
                this.currentTable = this.selectors[0];
                return;
            }
            int[] iArr = this.codeBases[i11];
            int[] iArr2 = this.codeLimits[i11];
            int[] iArr3 = this.codeSymbols[i11];
            byte[] bArr2 = bArr[i11];
            int iMin = 23;
            int iMax = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                byte b10 = bArr2[i12];
                iMax = Math.max((int) b10, iMax);
                iMin = Math.min((int) b10, iMin);
            }
            this.minimumLengths[i11] = iMin;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = bArr2[i13] + 1;
                iArr[i14] = iArr[i14] + 1;
            }
            int i15 = iArr[0];
            for (int i16 = 1; i16 < 25; i16++) {
                i15 += iArr[i16];
                iArr[i16] = i15;
            }
            int i17 = 0;
            int i18 = iMin;
            while (i18 <= iMax) {
                int i19 = i18 + 1;
                int i20 = iArr[i19];
                int i21 = iArr[i18];
                int i22 = (i20 - i21) + i17;
                iArr[i18] = i17 - i21;
                iArr2[i18] = i22 - 1;
                i17 = i22 << 1;
                i18 = i19;
            }
            int i23 = 0;
            while (iMin <= iMax) {
                for (int i24 = 0; i24 < i10; i24++) {
                    if (bArr2[i24] == iMin) {
                        iArr3[i23] = i24;
                        i23++;
                    }
                }
                iMin++;
            }
            i11++;
        }
    }

    public int nextSymbol() {
        int i10 = this.groupPosition + 1;
        this.groupPosition = i10;
        if (i10 % 50 == 0) {
            int i11 = this.groupIndex + 1;
            this.groupIndex = i11;
            byte[] bArr = this.selectors;
            if (i11 == bArr.length) {
                throw new DecompressionException("error decoding block");
            }
            this.currentTable = bArr[i11] & 255;
        }
        Bzip2BitReader bzip2BitReader = this.reader;
        int i12 = this.currentTable;
        int[] iArr = this.codeLimits[i12];
        int[] iArr2 = this.codeBases[i12];
        int[] iArr3 = this.codeSymbols[i12];
        int i13 = this.minimumLengths[i12];
        int bits = bzip2BitReader.readBits(i13);
        while (i13 <= 23) {
            if (bits <= iArr[i13]) {
                return iArr3[bits - iArr2[i13]];
            }
            bits = (bits << 1) | bzip2BitReader.readBits(1);
            i13++;
        }
        throw new DecompressionException("a valid code was not recognised");
    }
}
