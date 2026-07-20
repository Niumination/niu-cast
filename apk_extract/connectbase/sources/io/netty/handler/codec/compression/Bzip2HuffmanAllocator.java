package io.netty.handler.codec.compression;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2HuffmanAllocator {
    private Bzip2HuffmanAllocator() {
    }

    public static void allocateHuffmanCodeLengths(int[] iArr, int i10) {
        int length = iArr.length;
        if (length != 1) {
            if (length != 2) {
                setExtendedParentPointers(iArr);
                int iFindNodesToRelocate = findNodesToRelocate(iArr, i10);
                if (iArr[0] % iArr.length >= iFindNodesToRelocate) {
                    allocateNodeLengths(iArr);
                    return;
                } else {
                    allocateNodeLengthsWithRelocation(iArr, iFindNodesToRelocate, i10 - (32 - Integer.numberOfLeadingZeros(iFindNodesToRelocate - 1)));
                    return;
                }
            }
            iArr[1] = 1;
        }
        iArr[0] = 1;
    }

    private static void allocateNodeLengths(int[] iArr) {
        int i10 = 2;
        int length = iArr.length - 2;
        int i11 = 1;
        int length2 = iArr.length - 1;
        while (i10 > 0) {
            int iFirst = first(iArr, length - 1, 0);
            int i12 = length - iFirst;
            int i13 = i10 - i12;
            while (i13 > 0) {
                iArr[length2] = i11;
                i13--;
                length2--;
            }
            i10 = i12 << 1;
            i11++;
            length = iFirst;
        }
    }

    private static void allocateNodeLengthsWithRelocation(int[] iArr, int i10, int i11) {
        int iMin;
        int length = iArr.length - 2;
        int length2 = iArr.length - 1;
        int i12 = i11 != 1 ? 1 : 2;
        int i13 = i11 == 1 ? i10 - 2 : i10;
        int i14 = i12 << 1;
        while (i14 > 0) {
            int iFirst = length <= i10 ? length : first(iArr, length - 1, i10);
            if (i12 >= i11) {
                iMin = Math.min(i13, 1 << (i12 - i11));
            } else if (i12 == i11 - 1) {
                if (iArr[iFirst] == length) {
                    iFirst++;
                }
                iMin = 1;
            } else {
                iMin = 0;
            }
            int i15 = (length - iFirst) + iMin;
            int i16 = i14 - i15;
            while (i16 > 0) {
                iArr[length2] = i12;
                i16--;
                length2--;
            }
            i13 -= iMin;
            i14 = i15 << 1;
            i12++;
            length = iFirst;
        }
    }

    private static int findNodesToRelocate(int[] iArr, int i10) {
        int length = iArr.length - 2;
        for (int i11 = 1; i11 < i10 - 1 && length > 1; i11++) {
            length = first(iArr, length - 1, 0);
        }
        return length;
    }

    private static int first(int[] iArr, int i10, int i11) {
        int length = iArr.length;
        int length2 = iArr.length - 2;
        int i12 = i10;
        while (i12 >= i11 && iArr[i12] % length > i10) {
            length2 = i12;
            i12 -= (i10 - i12) + 1;
        }
        int iMax = Math.max(i11 - 1, i12);
        while (length2 > iMax + 1) {
            int i13 = (iMax + length2) >>> 1;
            if (iArr[i13] % length > i10) {
                length2 = i13;
            } else {
                iMax = i13;
            }
        }
        return length2;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b  */
    private static void setExtendedParentPointers(int[] iArr) {
        int i10;
        int i11;
        int length = iArr.length;
        int i12 = 0;
        iArr[0] = iArr[0] + iArr[1];
        int i13 = 2;
        for (int i14 = 1; i14 < length - 1; i14++) {
            if (i13 < length) {
                int i15 = iArr[i12];
                i10 = iArr[i13];
                if (i15 < i10) {
                    i10 = iArr[i12];
                    iArr[i12] = i14;
                    i12++;
                } else {
                    i13++;
                }
            } else {
                i10 = iArr[i12];
                iArr[i12] = i14;
                i12++;
            }
            if (i13 >= length || (i12 < i14 && iArr[i12] < iArr[i13])) {
                i11 = i10 + iArr[i12];
                iArr[i12] = i14 + length;
                i12++;
            } else {
                i11 = i10 + iArr[i13];
                i13++;
            }
            iArr[i14] = i11;
        }
    }
}
