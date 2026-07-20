package io.netty.handler.codec.compression;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2MTFAndRLE2StageEncoder {
    private int alphabetSize;
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[258];

    public Bzip2MTFAndRLE2StageEncoder(int[] iArr, int i10, boolean[] zArr) {
        this.bwtBlock = iArr;
        this.bwtLength = i10;
        this.bwtValuesPresent = zArr;
        this.mtfBlock = new char[i10 + 1];
    }

    public void encode() {
        int i10;
        int i11;
        int i12 = this.bwtLength;
        boolean[] zArr = this.bwtValuesPresent;
        int[] iArr = this.bwtBlock;
        char[] cArr = this.mtfBlock;
        int[] iArr2 = this.mtfSymbolFrequencies;
        byte[] bArr = new byte[256];
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        char c10 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < 256; i14++) {
            if (zArr[i14]) {
                bArr[i14] = (byte) i13;
                i13++;
            }
        }
        int i15 = i13 + 1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i16 < i12) {
            int iValueToFront = bzip2MoveToFrontTable.valueToFront(bArr[iArr[i16] & 255]);
            if (iValueToFront == 0) {
                i17++;
            } else {
                if (i17 > 0) {
                    int i21 = i17 - 1;
                    while (true) {
                        if ((i21 & 1) == 0) {
                            cArr[i18] = c10;
                            i19++;
                            i18++;
                            i11 = 1;
                        } else {
                            i11 = 1;
                            cArr[i18] = 1;
                            i20++;
                            i18++;
                        }
                        if (i21 <= i11) {
                            break;
                        }
                        i21 = (i21 - 2) >>> i11;
                        c10 = 0;
                    }
                    i17 = 0;
                }
                int i22 = iValueToFront + 1;
                cArr[i18] = (char) i22;
                iArr2[i22] = iArr2[i22] + 1;
                i18++;
            }
            i16++;
            c10 = 0;
        }
        if (i17 > 0) {
            int i23 = i17 - 1;
            while (true) {
                if ((i23 & 1) == 0) {
                    cArr[i18] = 0;
                    i19++;
                    i18++;
                    i10 = 1;
                } else {
                    i10 = 1;
                    cArr[i18] = 1;
                    i20++;
                    i18++;
                }
                if (i23 <= i10) {
                    break;
                } else {
                    i23 = (i23 - 2) >>> i10;
                }
            }
        } else {
            i10 = 1;
        }
        cArr[i18] = (char) i15;
        iArr2[i15] = iArr2[i15] + i10;
        iArr2[0] = iArr2[0] + i19;
        iArr2[i10] = iArr2[i10] + i20;
        this.mtfLength = i18 + i10;
        this.alphabetSize = i13 + 2;
    }

    public int mtfAlphabetSize() {
        return this.alphabetSize;
    }

    public char[] mtfBlock() {
        return this.mtfBlock;
    }

    public int mtfLength() {
        return this.mtfLength;
    }

    public int[] mtfSymbolFrequencies() {
        return this.mtfSymbolFrequencies;
    }
}
