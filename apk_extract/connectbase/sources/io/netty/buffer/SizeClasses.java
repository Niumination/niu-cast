package io.netty.buffer;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
abstract class SizeClasses implements SizeClassesMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INDEX_IDX = 0;
    private static final int LOG2DELTA_IDX = 2;
    private static final int LOG2GROUP_IDX = 1;
    private static final int LOG2_DELTA_LOOKUP_IDX = 6;
    private static final int LOG2_MAX_LOOKUP_SIZE = 12;
    static final int LOG2_QUANTUM = 4;
    private static final int LOG2_SIZE_CLASS_GROUP = 2;
    private static final int NDELTA_IDX = 3;
    private static final int PAGESIZE_IDX = 4;
    private static final int SUBPAGE_IDX = 5;

    /* JADX INFO: renamed from: no, reason: collision with root package name */
    private static final byte f8289no = 0;
    private static final byte yes = 1;
    protected final int chunkSize;
    protected final int directMemoryCacheAlignment;
    final int lookupMaxSize;
    final int nPSizes;
    final int nSizes;
    final int nSubpages;
    private final int[] pageIdx2sizeTab;
    protected final int pageShifts;
    protected final int pageSize;
    private final int[] size2idxTab;
    private final int[] sizeIdx2sizeTab;
    final int smallMaxSizeIdx;

    public SizeClasses(int i10, int i11, int i12, int i13) {
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) Short.TYPE, (PoolThreadCache.log2(i12) - 5) << 2, 7);
        int i14 = 0;
        int i15 = 0;
        int iSizeOf = 0;
        while (i14 < 4) {
            short[] sArrNewSizeClass = newSizeClass(i15, 4, 4, i14, i11);
            sArr[i15] = sArrNewSizeClass;
            iSizeOf = sizeOf(sArrNewSizeClass, i13);
            i14++;
            i15++;
        }
        int i16 = 4;
        int i17 = 6;
        while (iSizeOf < i12) {
            int i18 = 1;
            while (i18 <= 4 && iSizeOf < i12) {
                short[] sArrNewSizeClass2 = newSizeClass(i15, i17, i16, i18, i11);
                sArr[i15] = sArrNewSizeClass2;
                iSizeOf = sizeOf(sArrNewSizeClass2, i13);
                i18++;
                i15++;
            }
            i17++;
            i16++;
        }
        int i19 = 0;
        int iSizeOf2 = 0;
        int i20 = 0;
        int i21 = 0;
        for (int i22 = 0; i22 < i15; i22++) {
            short[] sArr2 = sArr[i22];
            i20 = sArr2[4] == 1 ? i20 + 1 : i20;
            if (sArr2[5] == 1) {
                i21++;
                i19 = i22;
            }
            if (sArr2[6] != 0) {
                iSizeOf2 = sizeOf(sArr2, i13);
            }
        }
        this.smallMaxSizeIdx = i19;
        this.lookupMaxSize = iSizeOf2;
        this.nPSizes = i20;
        this.nSubpages = i21;
        this.nSizes = i15;
        this.pageSize = i10;
        this.pageShifts = i11;
        this.chunkSize = i12;
        this.directMemoryCacheAlignment = i13;
        this.sizeIdx2sizeTab = newIdx2SizeTab(sArr, i15, i13);
        this.pageIdx2sizeTab = newPageIdx2sizeTab(sArr, i15, i20, i13);
        this.size2idxTab = newSize2idxTab(iSizeOf2, sArr);
    }

    private static int alignSizeIfNeeded(int i10, int i11) {
        int i12;
        return (i11 > 0 && (i12 = (i11 + (-1)) & i10) != 0) ? (i10 + i11) - i12 : i10;
    }

    private static int calculateSize(int i10, int i11, int i12) {
        return (1 << i10) + (i11 << i12);
    }

    private static int[] newIdx2SizeTab(short[][] sArr, int i10, int i11) {
        int[] iArr = new int[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            iArr[i12] = sizeOf(sArr[i12], i11);
        }
        return iArr;
    }

    private static int[] newPageIdx2sizeTab(short[][] sArr, int i10, int i11, int i12) {
        int[] iArr = new int[i11];
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            short[] sArr2 = sArr[i14];
            if (sArr2[4] == 1) {
                iArr[i13] = sizeOf(sArr2, i12);
                i13++;
            }
        }
        return iArr;
    }

    private static int[] newSize2idxTab(int i10, short[][] sArr) {
        int[] iArr = new int[i10 >> 4];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 <= i10) {
            int i14 = 1 << (sArr[i12][2] - 4);
            while (i11 <= i10) {
                int i15 = i14 - 1;
                if (i14 <= 0) {
                    break;
                }
                int i16 = i13 + 1;
                iArr[i13] = i12;
                int i17 = (i13 + 2) << 4;
                i14 = i15;
                i13 = i16;
                i11 = i17;
            }
            i12++;
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0005  */
    private static short[] newSizeClass(int i10, int i11, int i12, int i13, int i14) {
        short s10;
        if (i12 >= i14) {
            s10 = 1;
        } else {
            int i15 = 1 << i14;
            int iCalculateSize = calculateSize(i11, i13, i12);
            if (iCalculateSize == (iCalculateSize / i15) * i15) {
                s10 = 1;
            } else {
                s10 = 0;
            }
        }
        int iLog2 = i13 == 0 ? 0 : PoolThreadCache.log2(i13);
        boolean z10 = (1 << iLog2) < i13;
        int i16 = iLog2 + i12 == i11 ? i11 + 1 : i11;
        if (i16 == i11) {
            z10 = true;
        }
        return new short[]{(short) i10, (short) i11, (short) i12, (short) i13, s10, i16 < i14 + 2 ? (short) 1 : (short) 0, (short) ((i16 < 12 || (i16 == 12 && !z10)) ? i12 : 0)};
    }

    private static int normalizeSizeCompute(int i10) {
        int iLog2 = PoolThreadCache.log2((i10 << 1) - 1);
        int i11 = (1 << (iLog2 < 7 ? 4 : iLog2 - 3)) - 1;
        return (i10 + i11) & (~i11);
    }

    private int pages2pageIdxCompute(int i10, boolean z10) {
        int i11 = i10 << this.pageShifts;
        if (i11 > this.chunkSize) {
            return this.nPSizes;
        }
        int iLog2 = PoolThreadCache.log2((i11 << 1) - 1);
        int i12 = this.pageShifts;
        int i13 = ((iLog2 < i12 + 2 ? 0 : iLog2 - (i12 + 2)) << 2) + (((i11 - 1) >> (iLog2 < i12 + 3 ? i12 : iLog2 - 3)) & 3);
        return (!z10 || this.pageIdx2sizeTab[i13] <= (i10 << i12)) ? i13 : i13 - 1;
    }

    private static int sizeOf(short[] sArr, int i10) {
        return alignSizeIfNeeded(calculateSize(sArr[1], sArr[3], sArr[2]), i10);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int normalizeSize(int i10) {
        if (i10 == 0) {
            return this.sizeIdx2sizeTab[0];
        }
        int iAlignSizeIfNeeded = alignSizeIfNeeded(i10, this.directMemoryCacheAlignment);
        return iAlignSizeIfNeeded <= this.lookupMaxSize ? this.sizeIdx2sizeTab[this.size2idxTab[(iAlignSizeIfNeeded - 1) >> 4]] : normalizeSizeCompute(iAlignSizeIfNeeded);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public long pageIdx2size(int i10) {
        return this.pageIdx2sizeTab[i10];
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public long pageIdx2sizeCompute(int i10) {
        int i11 = i10 >> 2;
        int i12 = i10 & 3;
        long j10 = i11 == 0 ? 0L : (1 << (this.pageShifts + 1)) << i11;
        if (i11 == 0) {
            i11 = 1;
        }
        return j10 + ((long) ((i12 + 1) << ((i11 + this.pageShifts) - 1)));
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdx(int i10) {
        return pages2pageIdxCompute(i10, false);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdxFloor(int i10) {
        return pages2pageIdxCompute(i10, true);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int size2SizeIdx(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 > this.chunkSize) {
            return this.nSizes;
        }
        int iAlignSizeIfNeeded = alignSizeIfNeeded(i10, this.directMemoryCacheAlignment);
        if (iAlignSizeIfNeeded <= this.lookupMaxSize) {
            return this.size2idxTab[(iAlignSizeIfNeeded - 1) >> 4];
        }
        int iLog2 = PoolThreadCache.log2((iAlignSizeIfNeeded << 1) - 1);
        return ((iLog2 >= 7 ? iLog2 - 6 : 0) << 2) + (((iAlignSizeIfNeeded - 1) >> (iLog2 >= 7 ? iLog2 - 3 : 4)) & 3);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2size(int i10) {
        return this.sizeIdx2sizeTab[i10];
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2sizeCompute(int i10) {
        int i11 = i10 >> 2;
        int i12 = i10 & 3;
        int i13 = i11 == 0 ? 0 : 32 << i11;
        if (i11 == 0) {
            i11 = 1;
        }
        return i13 + ((i12 + 1) << (i11 + 3));
    }
}
