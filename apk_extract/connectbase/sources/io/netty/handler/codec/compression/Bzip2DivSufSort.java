package io.netty.handler.codec.compression;

import wj.t1;

/* JADX INFO: loaded from: classes3.dex */
final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;
    private final int[] SA;
    private final byte[] T;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f8307n;

    public static class PartitionResult {
        final int first;
        final int last;

        public PartitionResult(int i10, int i11) {
            this.first = i10;
            this.last = i11;
        }
    }

    public static class StackEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f8308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f8309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f8310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f8311d;

        public StackEntry(int i10, int i11, int i12, int i13) {
            this.f8308a = i10;
            this.f8309b = i11;
            this.f8310c = i12;
            this.f8311d = i13;
        }
    }

    public static class TRBudget {
        int budget;
        int chance;

        public TRBudget(int i10, int i11) {
            this.budget = i10;
            this.chance = i11;
        }

        public boolean update(int i10, int i11) {
            int i12 = this.budget - i11;
            this.budget = i12;
            if (i12 <= 0) {
                int i13 = this.chance - 1;
                this.chance = i13;
                if (i13 == 0) {
                    return false;
                }
                this.budget = i12 + i10;
            }
            return true;
        }
    }

    public Bzip2DivSufSort(byte[] bArr, int[] iArr, int i10) {
        this.T = bArr;
        this.SA = iArr;
        this.f8307n = i10;
    }

    private static int BUCKET_B(int i10, int i11) {
        return i10 | (i11 << 8);
    }

    private static int BUCKET_BSTAR(int i10, int i11) {
        return (i10 << 8) | i11;
    }

    private int constructBWT(int[] iArr, int[] iArr2) {
        byte[] bArr = this.T;
        int[] iArr3 = this.SA;
        int i10 = this.f8307n;
        int i11 = t1.N;
        int i12 = 0;
        int i13 = 0;
        while (i11 >= 0) {
            int i14 = i11 + 1;
            int i15 = iArr2[BUCKET_BSTAR(i11, i14)];
            int i16 = -1;
            int i17 = 0;
            for (int i18 = iArr[i14]; i15 <= i18; i18--) {
                int i19 = iArr3[i18];
                if (i19 >= 0) {
                    int i20 = i19 - 1;
                    if (i20 < 0) {
                        i20 = i10 - 1;
                    }
                    int i21 = bArr[i20] & 255;
                    if (i21 <= i11) {
                        iArr3[i18] = ~i19;
                        if (i20 > 0 && (bArr[i20 - 1] & 255) > i21) {
                            i20 = ~i20;
                        }
                        if (i16 == i21) {
                            i17--;
                            iArr3[i17] = i20;
                        } else {
                            if (i16 >= 0) {
                                iArr2[BUCKET_B(i16, i11)] = i17;
                            }
                            i17 = iArr2[BUCKET_B(i21, i11)] - 1;
                            iArr3[i17] = i20;
                            i16 = i21;
                        }
                    }
                } else {
                    iArr3[i18] = ~i19;
                }
            }
            i11--;
            i12 = i17;
            i13 = i16;
        }
        int i22 = -1;
        for (int i23 = 0; i23 < i10; i23++) {
            int i24 = iArr3[i23];
            if (i24 >= 0) {
                int i25 = i24 - 1;
                if (i25 < 0) {
                    i25 = i10 - 1;
                }
                int i26 = bArr[i25] & 255;
                if (i26 >= (bArr[i25 + 1] & 255)) {
                    if (i25 > 0 && (bArr[i25 - 1] & 255) < i26) {
                        i25 = ~i25;
                    }
                    if (i26 == i13) {
                        i12++;
                        iArr3[i12] = i25;
                    } else {
                        if (i13 != -1) {
                            iArr[i13] = i12;
                        }
                        i12 = iArr[i26] + 1;
                        iArr3[i12] = i25;
                        i13 = i26;
                    }
                }
            } else {
                i24 = ~i24;
            }
            if (i24 == 0) {
                iArr3[i23] = bArr[i10 - 1];
                i22 = i23;
            } else {
                iArr3[i23] = bArr[i24 - 1];
            }
        }
        return i22;
    }

    private static int getIDX(int i10) {
        return i10 >= 0 ? i10 : ~i10;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x011e A[EDGE_INSN: B:149:0x011e->B:155:? BREAK  A[LOOP:6: B:60:0x0107->B:66:0x0119], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x010a  */
    /* JADX WARN: Code duplicated, block: B:64:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0114  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0128 -> B:56:0x00fc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    private void lsIntroSort(int r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.lsIntroSort(int, int, int, int, int):void");
    }

    private void lsSort(int i10, int i11, int i12) {
        int i13;
        int[] iArr = this.SA;
        int i14 = i12 + i10;
        while (true) {
            int i15 = 0;
            if ((-i11) >= iArr[0]) {
                return;
            }
            int i16 = 0;
            int i17 = 0;
            do {
                int i18 = iArr[i17];
                if (i18 < 0) {
                    i17 -= i18;
                    i16 += i18;
                } else {
                    if (i16 != 0) {
                        iArr[i17 + i16] = i16;
                        i13 = 0;
                    } else {
                        i13 = i16;
                    }
                    int i19 = iArr[i18 + i10] + 1;
                    lsIntroSort(i10, i14, i10 + i11, i17, i19);
                    i16 = i13;
                    i17 = i19;
                }
            } while (i17 < i11);
            if (i16 != 0) {
                iArr[i17 + i16] = i16;
            }
            int i20 = i14 - i10;
            if (i11 < i20) {
                do {
                    int i21 = iArr[i15];
                    if (i21 < 0) {
                        i15 -= i21;
                    } else {
                        int i22 = iArr[i21 + i10] + 1;
                        while (i15 < i22) {
                            iArr[iArr[i15] + i10] = i15;
                            i15++;
                        }
                        i15 = i22;
                    }
                } while (i15 < i11);
                return;
            }
            i14 += i20;
        }
    }

    private void lsUpdateGroup(int i10, int i11, int i12) {
        int i13;
        int[] iArr = this.SA;
        while (i11 < i12) {
            if (iArr[i11] >= 0) {
                int i14 = i11;
                do {
                    iArr[iArr[i14] + i10] = i14;
                    i14++;
                    if (i14 >= i12) {
                        break;
                    }
                } while (iArr[i14] >= 0);
                iArr[i11] = i11 - i14;
                if (i12 <= i14) {
                    return;
                } else {
                    i11 = i14;
                }
            }
            int i15 = i11;
            while (true) {
                iArr[i15] = ~iArr[i15];
                i13 = i15 + 1;
                if (iArr[i13] >= 0) {
                    break;
                } else {
                    i15 = i13;
                }
            }
            do {
                iArr[iArr[i11] + i10] = i13;
                i11++;
            } while (i11 <= i13);
            i11 = i15 + 2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0213 A[LOOP:13: B:109:0x0213->B:167:?, LOOP_START, PHI: r13
      0x0213: PHI (r13v6 int) = (r13v5 int), (r13v7 int) binds: [B:108:0x0211, B:167:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:111:0x0217  */
    /* JADX WARN: Code duplicated, block: B:118:0x0230  */
    /* JADX WARN: Code duplicated, block: B:123:0x0240  */
    /* JADX WARN: Code duplicated, block: B:125:0x0243  */
    /* JADX WARN: Code duplicated, block: B:127:0x025d A[LOOP:17: B:126:0x025b->B:127:0x025d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:131:0x027b  */
    /* JADX WARN: Code duplicated, block: B:158:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0211 A[EDGE_INSN: B:162:0x0211->B:160:0x0211 BREAK  A[LOOP:14: B:116:0x022c->B:168:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0222 A[EDGE_INSN: B:166:0x0222->B:114:0x0222 BREAK  A[LOOP:13: B:109:0x0213->B:167:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x0284 A[SYNTHETIC] */
    private int sortTypeBstar(int[] iArr, int[] iArr2) {
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr3;
        int i15;
        int i16;
        byte b10;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        byte[] bArr = this.T;
        int[] iArr4 = this.SA;
        int i25 = this.f8307n;
        int[] iArr5 = new int[256];
        int i26 = 1;
        while (true) {
            z10 = false;
            i10 = 255;
            if (i26 < i25) {
                byte b11 = bArr[i26 - 1];
                byte b12 = bArr[i26];
                if (b11 != b12) {
                    if ((b11 & 255) > (b12 & 255)) {
                        z11 = false;
                        break;
                    }
                } else {
                    i26++;
                }
            }
            z11 = true;
            break;
        }
        int i27 = i25 - 1;
        byte b13 = bArr[i27];
        int i28 = b13 & 255;
        byte b14 = bArr[0];
        int i29 = b14 & 255;
        if (i28 >= i29 && (b13 != b14 || !z11)) {
            i11 = i25;
            i12 = i27;
            break;
        }
        if (z11) {
            int iBUCKET_B = BUCKET_B(i28, i29);
            iArr2[iBUCKET_B] = iArr2[iBUCKET_B] + 1;
            i11 = i25;
        } else {
            int iBUCKET_BSTAR = BUCKET_BSTAR(i28, i29);
            iArr2[iBUCKET_BSTAR] = iArr2[iBUCKET_BSTAR] + 1;
            i11 = i25 - 1;
            iArr4[i11] = i27;
        }
        i12 = i25 - 2;
        while (i12 >= 0) {
            int i30 = bArr[i12] & 255;
            int i31 = bArr[i12 + 1] & 255;
            if (i30 > i31) {
                break;
            }
            int iBUCKET_B2 = BUCKET_B(i30, i31);
            iArr2[iBUCKET_B2] = iArr2[iBUCKET_B2] + 1;
            i12--;
        }
        while (i12 >= 0) {
            while (true) {
                int i32 = bArr[i12] & 255;
                iArr[i32] = iArr[i32] + 1;
                i24 = i12 - 1;
                if (i24 < 0 || (bArr[i24] & 255) < (bArr[i12] & 255)) {
                    break;
                }
                i12 = i24;
            }
            if (i24 >= 0) {
                int iBUCKET_BSTAR2 = BUCKET_BSTAR(bArr[i24] & 255, bArr[i12] & 255);
                iArr2[iBUCKET_BSTAR2] = iArr2[iBUCKET_BSTAR2] + 1;
                i11--;
                iArr4[i11] = i24;
                i12 -= 2;
                while (i12 >= 0) {
                    int i33 = bArr[i12] & 255;
                    int i34 = bArr[i12 + 1] & 255;
                    if (i33 > i34) {
                        break;
                    }
                    int iBUCKET_B3 = BUCKET_B(i33, i34);
                    iArr2[iBUCKET_B3] = iArr2[iBUCKET_B3] + 1;
                    i12--;
                }
            } else {
                i12 = i24;
            }
        }
        int i35 = i25 - i11;
        if (i35 == 0) {
            for (int i36 = 0; i36 < i25; i36++) {
                iArr4[i36] = i36;
            }
            return 0;
        }
        int i37 = -1;
        int i38 = 0;
        int i39 = 0;
        while (i38 < 256) {
            int i40 = iArr[i38] + i37;
            iArr[i38] = i37 + i39;
            int i41 = i40 + iArr2[BUCKET_B(i38, i38)];
            int i42 = i38 + 1;
            for (int i43 = i42; i43 < 256; i43++) {
                i39 += iArr2[BUCKET_BSTAR(i38, i43)];
                iArr2[(i38 << 8) | i43] = i39;
                i41 += iArr2[BUCKET_B(i38, i43)];
            }
            i38 = i42;
            i37 = i41;
        }
        int i44 = i25 - i35;
        for (int i45 = i35 - 2; i45 >= 0; i45--) {
            int i46 = iArr4[i44 + i45];
            int iBUCKET_BSTAR3 = BUCKET_BSTAR(bArr[i46] & 255, bArr[i46 + 1] & 255);
            int i47 = iArr2[iBUCKET_BSTAR3] - 1;
            iArr2[iBUCKET_BSTAR3] = i47;
            iArr4[i47] = i45;
        }
        int i48 = iArr4[(i44 + i35) - 1];
        int iBUCKET_BSTAR4 = BUCKET_BSTAR(bArr[i48] & 255, bArr[i48 + 1] & 255);
        int i49 = iArr2[iBUCKET_BSTAR4] - 1;
        iArr2[iBUCKET_BSTAR4] = i49;
        int i50 = i35 - 1;
        iArr4[i49] = i50;
        int i51 = i25 - (i35 * 2);
        if (i51 <= 256) {
            i13 = 256;
            iArr3 = iArr5;
            i14 = 0;
        } else {
            i13 = i51;
            i14 = i35;
            iArr3 = iArr4;
        }
        int i52 = i35;
        int i53 = 255;
        while (i52 > 0) {
            int i54 = i52;
            int i55 = i10;
            while (i53 < i55) {
                int i56 = iArr2[BUCKET_BSTAR(i53, i55)];
                if (1 < i54 - i56) {
                    subStringSort(i44, i56, i54, iArr3, i14, i13, 2, iArr4[i56] == i50 ? true : z10, i25);
                }
                i55--;
                i35 = i35;
                i54 = i56;
                i53 = i53;
                i50 = i50;
                z10 = false;
            }
            i53--;
            i52 = i54;
            i10 = 255;
            z10 = false;
        }
        int i57 = i50;
        int i58 = i35;
        while (i50 >= 0) {
            if (iArr4[i50] >= 0) {
                int i59 = i50;
                while (true) {
                    iArr4[i58 + iArr4[i59]] = i59;
                    i23 = i59 - 1;
                    if (i23 < 0 || iArr4[i23] < 0) {
                        break;
                    }
                    i59 = i23;
                }
                iArr4[i59] = i23 - i50;
                if (i23 <= 0) {
                    break;
                }
                i50 = i23;
            }
            int i60 = i50;
            while (true) {
                int i61 = ~iArr4[i60];
                iArr4[i60] = i61;
                iArr4[i58 + i61] = i50;
                int i62 = i60 - 1;
                i22 = iArr4[i62];
                if (i22 >= 0) {
                    break;
                }
                i60 = i62;
            }
            iArr4[i58 + i22] = i50;
            i50 = i60 - 2;
        }
        trSort(i58, i58, 1);
        byte b15 = bArr[i27];
        int i63 = b15 & 255;
        byte b16 = bArr[0];
        if (i63 < (b16 & 255) || (b15 == b16 && z11)) {
            if (z11) {
                i15 = i58;
            } else {
                i15 = i58 - 1;
                iArr4[iArr4[i58 + i15]] = i27;
            }
            i16 = i25 - 2;
            while (true) {
                if (i16 >= 0) {
                    b10 = 255;
                    if ((bArr[i16] & 255) > (bArr[i16 + 1] & 255)) {
                        break;
                    }
                    i16--;
                }
            }
            while (i16 >= 0) {
                do {
                    i16--;
                    if (i16 >= 0) {
                        break;
                    }
                } while ((bArr[i16] & b10) >= (bArr[i16 + 1] & b10));
                if (i16 >= 0) {
                    i15--;
                    iArr4[iArr4[i58 + i15]] = i16;
                    do {
                        i16--;
                        if (i16 >= 0) {
                            break;
                        }
                    } while ((bArr[i16] & b10) <= (bArr[i16 + 1] & b10));
                }
            }
            i18 = i57;
            for (i17 = b10; i17 >= 0; i17--) {
                for (i19 = b10; i17 < i19; i19--) {
                    int i64 = i27 - iArr2[BUCKET_B(i17, i19)];
                    iArr2[BUCKET_B(i17, i19)] = i27 + 1;
                    i21 = iArr2[BUCKET_BSTAR(i17, i19)];
                    i27 = i64;
                    while (i21 <= i18) {
                        iArr4[i27] = iArr4[i18];
                        i27--;
                        i18--;
                    }
                }
                i20 = i27 - iArr2[BUCKET_B(i17, i17)];
                iArr2[BUCKET_B(i17, i17)] = i27 + 1;
                if (i17 < b10) {
                    iArr2[BUCKET_BSTAR(i17, i17 + 1)] = i20 + 1;
                }
                i27 = iArr[i17];
            }
            return i58;
        }
        i15 = i58;
        i16 = i27;
        b10 = 255;
        while (i16 >= 0) {
            do {
                i16--;
                if (i16 >= 0) {
                    break;
                    break;
                }
            } while ((bArr[i16] & b10) >= (bArr[i16 + 1] & b10));
            if (i16 >= 0) {
                i15--;
                iArr4[iArr4[i58 + i15]] = i16;
                do {
                    i16--;
                    if (i16 >= 0) {
                        break;
                        break;
                    }
                } while ((bArr[i16] & b10) <= (bArr[i16 + 1] & b10));
            }
        }
        i18 = i57;
        while (i17 >= 0) {
            while (i17 < i19) {
                int i65 = i27 - iArr2[BUCKET_B(i17, i19)];
                iArr2[BUCKET_B(i17, i19)] = i27 + 1;
                i21 = iArr2[BUCKET_BSTAR(i17, i19)];
                i27 = i65;
                while (i21 <= i18) {
                    iArr4[i27] = iArr4[i18];
                    i27--;
                    i18--;
                }
            }
            i20 = i27 - iArr2[BUCKET_B(i17, i17)];
            iArr2[BUCKET_B(i17, i17)] = i27 + 1;
            if (i17 < b10) {
                iArr2[BUCKET_BSTAR(i17, i17 + 1)] = i20 + 1;
            }
            i27 = iArr[i17];
        }
        return i58;
    }

    private static void ssBlockSwap(int[] iArr, int i10, int[] iArr2, int i11, int i12) {
        while (i12 > 0) {
            swapElements(iArr, i10, iArr2, i11);
            i12--;
            i10++;
            i11++;
        }
    }

    private int ssCompare(int i10, int i11, int i12) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i13 = iArr[i10 + 1] + 2;
        int i14 = iArr[i11 + 1] + 2;
        int i15 = iArr[i10] + i12;
        int i16 = i12 + iArr[i11];
        while (i15 < i13 && i16 < i14 && bArr[i15] == bArr[i16]) {
            i15++;
            i16++;
        }
        if (i15 >= i13) {
            return i16 < i14 ? -1 : 0;
        }
        if (i16 < i14) {
            return (bArr[i15] & 255) - (bArr[i16] & 255);
        }
        return 1;
    }

    private int ssCompareLast(int i10, int i11, int i12, int i13, int i14) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i15 = iArr[i11] + i13;
        int i16 = i13 + iArr[i12];
        int i17 = iArr[i12 + 1] + 2;
        while (i15 < i14 && i16 < i17 && bArr[i15] == bArr[i16]) {
            i15++;
            i16++;
        }
        if (i15 < i14) {
            if (i16 < i17) {
                return (bArr[i15] & 255) - (bArr[i16] & 255);
            }
            return 1;
        }
        if (i16 == i17) {
            return 1;
        }
        int i18 = i15 % i14;
        int i19 = iArr[i10] + 2;
        while (i18 < i19 && i16 < i17 && bArr[i18] == bArr[i16]) {
            i18++;
            i16++;
        }
        if (i18 >= i19) {
            return i16 < i17 ? -1 : 0;
        }
        if (i16 < i17) {
            return (bArr[i18] & 255) - (bArr[i16] & 255);
        }
        return 1;
    }

    private void ssFixdown(int i10, int i11, int i12, int i13, int i14) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i15 = iArr[i12 + i13];
        int i16 = bArr[iArr[i11 + i15] + i10] & 255;
        while (true) {
            int i17 = i13 * 2;
            int i18 = i17 + 1;
            if (i18 >= i14) {
                break;
            }
            int i19 = i17 + 2;
            int i20 = bArr[iArr[iArr[i12 + i18] + i11] + i10] & 255;
            int i21 = bArr[iArr[iArr[i12 + i19] + i11] + i10] & 255;
            if (i20 < i21) {
                i20 = i21;
            } else {
                i19 = i18;
            }
            if (i20 <= i16) {
                break;
            }
            iArr[i13 + i12] = iArr[i12 + i19];
            i13 = i19;
        }
        iArr[i12 + i13] = i15;
    }

    private void ssHeapSort(int i10, int i11, int i12, int i13) {
        int i14;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i15 = i13 % 2;
        if (i15 == 0) {
            int i16 = i13 - 1;
            int i17 = (i16 / 2) + i12;
            int i18 = i12 + i16;
            if ((bArr[iArr[iArr[i17] + i11] + i10] & 255) < (bArr[iArr[iArr[i18] + i11] + i10] & 255)) {
                swapElements(iArr, i18, iArr, i17);
            }
            i14 = i16;
        } else {
            i14 = i13;
        }
        for (int i19 = (i14 / 2) - 1; i19 >= 0; i19--) {
            ssFixdown(i10, i11, i12, i19, i14);
        }
        if (i15 == 0) {
            swapElements(iArr, i12, iArr, i12 + i14);
            ssFixdown(i10, i11, i12, 0, i14);
        }
        for (int i20 = i14 - 1; i20 > 0; i20--) {
            int i21 = iArr[i12];
            int i22 = i12 + i20;
            iArr[i12] = iArr[i22];
            ssFixdown(i10, i11, i12, 0, i20);
            iArr[i22] = i21;
        }
    }

    private void ssInsertionSort(int i10, int i11, int i12, int i13) {
        int iSsCompare;
        int[] iArr = this.SA;
        for (int i14 = i12 - 2; i11 <= i14; i14--) {
            int i15 = iArr[i14];
            int i16 = i14 + 1;
            do {
                iSsCompare = ssCompare(i10 + i15, iArr[i16] + i10, i13);
                if (iSsCompare <= 0) {
                    break;
                }
                do {
                    iArr[i16 - 1] = iArr[i16];
                    i16++;
                    if (i16 >= i12) {
                        break;
                    }
                } while (iArr[i16] < 0);
            } while (i12 > i16);
            if (iSsCompare == 0) {
                iArr[i16] = ~iArr[i16];
            }
            iArr[i16 - 1] = i15;
        }
    }

    private static int ssLog(int i10) {
        return (65280 & i10) != 0 ? LOG_2_TABLE[(i10 >> 8) & 255] + 8 : LOG_2_TABLE[i10 & 255];
    }

    private int ssMedian3(int i10, int i11, int i12, int i13, int i14) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i15 = bArr[iArr[iArr[i12] + i11] + i10] & 255;
        int i16 = bArr[iArr[iArr[i13] + i11] + i10] & 255;
        int i17 = bArr[i10 + iArr[i11 + iArr[i14]]] & 255;
        if (i15 <= i16) {
            i13 = i12;
            i12 = i13;
            i16 = i15;
            i15 = i16;
        }
        if (i15 > i17) {
            return i16 > i17 ? i13 : i14;
        }
        return i12;
    }

    private int ssMedian5(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i17 = bArr[iArr[iArr[i12] + i11] + i10] & 255;
        int i18 = bArr[iArr[iArr[i13] + i11] + i10] & 255;
        int i19 = bArr[iArr[iArr[i14] + i11] + i10] & 255;
        int i20 = bArr[iArr[iArr[i15] + i11] + i10] & 255;
        int i21 = bArr[i10 + iArr[i11 + iArr[i16]]] & 255;
        if (i18 > i19) {
            i14 = i13;
            i13 = i14;
            i19 = i18;
            i18 = i19;
        }
        if (i20 > i21) {
            i20 = i21;
            i21 = i20;
        } else {
            i16 = i15;
            i15 = i16;
        }
        if (i18 > i20) {
            int i22 = i19;
            i19 = i21;
            i21 = i22;
            int i23 = i15;
            i15 = i14;
            i14 = i23;
        } else {
            i13 = i16;
            i18 = i20;
        }
        if (i17 > i19) {
            int i24 = i14;
            i14 = i12;
            i12 = i24;
            int i25 = i19;
            i19 = i17;
            i17 = i25;
        }
        if (i17 > i18) {
            i13 = i12;
            i18 = i17;
        } else {
            i15 = i14;
            i21 = i19;
        }
        return i21 > i18 ? i13 : i15;
    }

    private void ssMerge(int i10, int i11, int i12, int i13, int[] iArr, int i14, int i15, int i16) {
        int i17;
        int i18;
        int i19;
        int i20;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i21 = i11;
        int i22 = i12;
        int i23 = i13;
        int i24 = 0;
        int i25 = 0;
        while (true) {
            int i26 = i23 - i22;
            if (i26 <= i15) {
                if (i21 < i22 && i22 < i23) {
                    ssMergeBackward(i10, iArr, i14, i21, i22, i23, i16);
                }
                if ((i24 & 1) != 0) {
                    ssMergeCheckEqual(i10, i16, i21);
                }
                if ((i24 & 2) != 0) {
                    ssMergeCheckEqual(i10, i16, i23);
                }
                if (i25 == 0) {
                    return;
                }
                i25--;
                StackEntry stackEntry = stackEntryArr[i25];
                i21 = stackEntry.f8308a;
                i22 = stackEntry.f8309b;
                i23 = stackEntry.f8310c;
                i17 = stackEntry.f8311d;
            } else {
                int i27 = i23;
                int i28 = i22 - i21;
                if (i28 <= i15) {
                    if (i21 < i22) {
                        ssMergeForward(i10, iArr, i14, i21, i22, i27, i16);
                    }
                    if ((i24 & 1) != 0) {
                        ssMergeCheckEqual(i10, i16, i21);
                    }
                    if ((i24 & 2) != 0) {
                        ssMergeCheckEqual(i10, i16, i27);
                    }
                    if (i25 == 0) {
                        return;
                    }
                    i25--;
                    StackEntry stackEntry2 = stackEntryArr[i25];
                    i21 = stackEntry2.f8308a;
                    i22 = stackEntry2.f8309b;
                    i23 = stackEntry2.f8310c;
                    i17 = stackEntry2.f8311d;
                } else {
                    int iMin = Math.min(i28, i26);
                    int i29 = iMin >> 1;
                    int i30 = 0;
                    while (iMin > 0) {
                        if (ssCompare(getIDX(iArr2[i22 + i30 + i29]) + i10, getIDX(iArr2[((i22 - i30) - i29) - 1]) + i10, i16) < 0) {
                            i30 += i29 + 1;
                            i29 -= (iMin & 1) ^ 1;
                        }
                        iMin = i29;
                        i29 = iMin >> 1;
                    }
                    if (i30 > 0) {
                        int i31 = i22 - i30;
                        ssBlockSwap(iArr2, i31, iArr2, i22, i30);
                        int i32 = i22 + i30;
                        if (i32 < i27) {
                            if (iArr2[i32] < 0) {
                                i20 = i22;
                                while (iArr2[i20 - 1] < 0) {
                                    i20--;
                                }
                                iArr2[i32] = ~iArr2[i32];
                            } else {
                                i20 = i22;
                            }
                            i18 = i22;
                            while (iArr2[i18] < 0) {
                                i18++;
                            }
                            i23 = i20;
                            i19 = 1;
                        } else {
                            i18 = i22;
                            i23 = i18;
                            i19 = 0;
                        }
                        if (i23 - i21 <= i27 - i18) {
                            stackEntryArr[i25] = new StackEntry(i18, i32, i27, i19 | (i24 & 2));
                            i24 &= 1;
                            i22 = i31;
                            i25++;
                        } else {
                            if (i23 == i22 && i22 == i18) {
                                i19 <<= 1;
                            }
                            stackEntryArr[i25] = new StackEntry(i21, i31, i23, (i24 & 1) | (i19 & 2));
                            i24 = (i24 & 2) | (i19 & 1);
                            i22 = i32;
                            i25++;
                            i21 = i18;
                            i23 = i27;
                        }
                    } else {
                        if ((i24 & 1) != 0) {
                            ssMergeCheckEqual(i10, i16, i21);
                        }
                        ssMergeCheckEqual(i10, i16, i22);
                        if ((i24 & 2) != 0) {
                            ssMergeCheckEqual(i10, i16, i27);
                        }
                        if (i25 == 0) {
                            return;
                        }
                        i25--;
                        StackEntry stackEntry3 = stackEntryArr[i25];
                        i21 = stackEntry3.f8308a;
                        i22 = stackEntry3.f8309b;
                        i23 = stackEntry3.f8310c;
                        i17 = stackEntry3.f8311d;
                    }
                }
            }
            i24 = i17;
        }
    }

    private void ssMergeBackward(int i10, int[] iArr, int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int[] iArr2 = this.SA;
        int i26 = i14 - i13;
        ssBlockSwap(iArr, i11, iArr2, i13, i26);
        int i27 = (i11 + i26) - 1;
        int i28 = iArr[i27];
        if (i28 < 0) {
            i16 = i10 + (~i28);
            i17 = 1;
        } else {
            i16 = i10 + i28;
            i17 = 0;
        }
        int i29 = i13 - 1;
        int i30 = iArr2[i29];
        if (i30 < 0) {
            i17 |= 2;
            i30 = ~i30;
        }
        int i31 = i10 + i30;
        int i32 = i14 - 1;
        int i33 = iArr2[i32];
        while (true) {
            int iSsCompare = ssCompare(i16, i31, i15);
            if (iSsCompare > 0) {
                if ((i17 & 1) != 0) {
                    while (true) {
                        i18 = i32 - 1;
                        iArr2[i32] = iArr[i27];
                        i19 = i27 - 1;
                        iArr[i27] = iArr2[i18];
                        if (iArr[i19] >= 0) {
                            break;
                        }
                        i27 = i19;
                        i32 = i18;
                    }
                    i17 ^= 1;
                    i27 = i19;
                    i32 = i18;
                }
                int i34 = i32 - 1;
                iArr2[i32] = iArr[i27];
                if (i27 <= i11) {
                    iArr[i27] = i33;
                    return;
                }
                int i35 = i27 - 1;
                iArr[i27] = iArr2[i34];
                int i36 = iArr[i35];
                if (i36 < 0) {
                    i17 |= 1;
                    i36 = ~i36;
                }
                int i37 = i10 + i36;
                i27 = i35;
                i32 = i34;
                i16 = i37;
            } else if (iSsCompare < 0) {
                if ((i17 & 2) != 0) {
                    while (true) {
                        i20 = i32 - 1;
                        iArr2[i32] = iArr2[i29];
                        i21 = i29 - 1;
                        iArr2[i29] = iArr2[i20];
                        if (iArr2[i21] >= 0) {
                            break;
                        }
                        i29 = i21;
                        i32 = i20;
                    }
                    i17 ^= 2;
                    i29 = i21;
                    i32 = i20;
                }
                int i38 = i32 - 1;
                iArr2[i32] = iArr2[i29];
                int i39 = i29 - 1;
                iArr2[i29] = iArr2[i38];
                if (i39 < i12) {
                    while (i11 < i27) {
                        int i40 = i38 - 1;
                        iArr2[i38] = iArr[i27];
                        iArr[i27] = iArr2[i40];
                        i38 = i40;
                        i27--;
                    }
                    iArr2[i38] = iArr[i27];
                    iArr[i27] = i33;
                    return;
                }
                int i41 = iArr2[i39];
                if (i41 < 0) {
                    i17 |= 2;
                    i41 = ~i41;
                }
                i31 = i10 + i41;
                i29 = i39;
                i32 = i38;
            } else {
                if ((i17 & 1) != 0) {
                    while (true) {
                        i24 = i32 - 1;
                        iArr2[i32] = iArr[i27];
                        i25 = i27 - 1;
                        iArr[i27] = iArr2[i24];
                        if (iArr[i25] >= 0) {
                            break;
                        }
                        i27 = i25;
                        i32 = i24;
                    }
                    i17 ^= 1;
                    i27 = i25;
                    i32 = i24;
                }
                int i42 = i32 - 1;
                iArr2[i32] = ~iArr[i27];
                if (i27 <= i11) {
                    iArr[i27] = i33;
                    return;
                }
                int i43 = i27 - 1;
                iArr[i27] = iArr2[i42];
                if ((i17 & 2) != 0) {
                    while (true) {
                        i22 = i42 - 1;
                        iArr2[i42] = iArr2[i29];
                        i23 = i29 - 1;
                        iArr2[i29] = iArr2[i22];
                        if (iArr2[i23] >= 0) {
                            break;
                        }
                        i29 = i23;
                        i42 = i22;
                    }
                    i17 ^= 2;
                    i29 = i23;
                    i42 = i22;
                }
                int i44 = i42 - 1;
                iArr2[i42] = iArr2[i29];
                int i45 = i29 - 1;
                iArr2[i29] = iArr2[i44];
                if (i45 < i12) {
                    while (i11 < i43) {
                        int i46 = i44 - 1;
                        iArr2[i44] = iArr[i43];
                        iArr[i43] = iArr2[i46];
                        i44 = i46;
                        i43--;
                    }
                    iArr2[i44] = iArr[i43];
                    iArr[i43] = i33;
                    return;
                }
                int i47 = iArr[i43];
                if (i47 < 0) {
                    i17 |= 1;
                    i47 = ~i47;
                }
                int i48 = i10 + i47;
                int i49 = iArr2[i45];
                if (i49 < 0) {
                    i17 |= 2;
                    i49 = ~i49;
                }
                i31 = i10 + i49;
                i16 = i48;
                i29 = i45;
                i27 = i43;
                i32 = i44;
            }
        }
    }

    private void ssMergeCheckEqual(int i10, int i11, int i12) {
        int[] iArr = this.SA;
        if (iArr[i12] < 0 || ssCompare(getIDX(iArr[i12 - 1]) + i10, i10 + iArr[i12], i11) != 0) {
            return;
        }
        iArr[i12] = ~iArr[i12];
    }

    private void ssMergeForward(int i10, int[] iArr, int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int[] iArr2 = this.SA;
        int i17 = i13 - i12;
        int i18 = (i11 + i17) - 1;
        ssBlockSwap(iArr, i11, iArr2, i12, i17);
        int i19 = iArr2[i12];
        while (true) {
            int iSsCompare = ssCompare(iArr[i11] + i10, iArr2[i13] + i10, i15);
            if (iSsCompare < 0) {
                while (true) {
                    i16 = i12 + 1;
                    iArr2[i12] = iArr[i11];
                    if (i18 <= i11) {
                        iArr[i11] = i19;
                        return;
                    }
                    int i20 = i11 + 1;
                    iArr[i11] = iArr2[i16];
                    if (iArr[i20] >= 0) {
                        i11 = i20;
                        break;
                    } else {
                        i11 = i20;
                        i12 = i16;
                    }
                }
            } else if (iSsCompare > 0) {
                while (true) {
                    i16 = i12 + 1;
                    iArr2[i12] = iArr2[i13];
                    int i21 = i13 + 1;
                    iArr2[i13] = iArr2[i16];
                    if (i14 <= i21) {
                        while (i11 < i18) {
                            int i22 = i16 + 1;
                            iArr2[i16] = iArr[i11];
                            iArr[i11] = iArr2[i22];
                            i16 = i22;
                            i11++;
                        }
                        iArr2[i16] = iArr[i11];
                        iArr[i11] = i19;
                        return;
                    }
                    if (iArr2[i21] >= 0) {
                        i13 = i21;
                        break;
                    } else {
                        i13 = i21;
                        i12 = i16;
                    }
                }
            } else {
                iArr2[i13] = ~iArr2[i13];
                while (true) {
                    int i23 = i12 + 1;
                    iArr2[i12] = iArr[i11];
                    if (i18 <= i11) {
                        iArr[i11] = i19;
                        return;
                    }
                    int i24 = i11 + 1;
                    iArr[i11] = iArr2[i23];
                    if (iArr[i24] >= 0) {
                        while (true) {
                            int i25 = i23 + 1;
                            iArr2[i23] = iArr2[i13];
                            int i26 = i13 + 1;
                            iArr2[i13] = iArr2[i25];
                            if (i14 <= i26) {
                                while (i24 < i18) {
                                    int i27 = i25 + 1;
                                    iArr2[i25] = iArr[i24];
                                    iArr[i24] = iArr2[i27];
                                    i25 = i27;
                                    i24++;
                                }
                                iArr2[i25] = iArr[i24];
                                iArr[i24] = i19;
                                return;
                            }
                            if (iArr2[i26] >= 0) {
                                i13 = i26;
                                i12 = i25;
                                i11 = i24;
                                break;
                            }
                            i13 = i26;
                            i23 = i25;
                        }
                    } else {
                        i11 = i24;
                        i12 = i23;
                    }
                }
            }
            i12 = i16;
        }
    }

    private void ssMultiKeyIntroSort(int i10, int i11, int i12, int i13) {
        int iSsLog;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int[] iArr = bzip2DivSufSort.SA;
        byte[] bArr = bzip2DivSufSort.T;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i19 = i13;
        int iSsLog2 = ssLog(i12 - i11);
        int i20 = 0;
        int i21 = 0;
        int iSsSubstringPartition = i11;
        int i22 = i12;
        while (true) {
            int i23 = i22 - iSsSubstringPartition;
            if (i23 <= 8) {
                if (1 < i23) {
                    bzip2DivSufSort.ssInsertionSort(i10, iSsSubstringPartition, i22, i19);
                }
                if (i20 == 0) {
                    return;
                }
                i20--;
                StackEntry stackEntry = stackEntryArr[i20];
                int i24 = stackEntry.f8308a;
                int i25 = stackEntry.f8309b;
                int i26 = stackEntry.f8310c;
                iSsLog2 = stackEntry.f8311d;
                iSsSubstringPartition = i24;
                i22 = i25;
                i19 = i26;
            } else {
                int i27 = iSsLog2 - 1;
                if (iSsLog2 == 0) {
                    bzip2DivSufSort.ssHeapSort(i19, i10, iSsSubstringPartition, i23);
                }
                if (i27 < 0) {
                    int i28 = bArr[iArr[iArr[iSsSubstringPartition] + i10] + i19] & 255;
                    int iSsSubstringPartition2 = iSsSubstringPartition;
                    iSsSubstringPartition++;
                    while (iSsSubstringPartition < i22) {
                        i21 = bArr[iArr[iArr[iSsSubstringPartition] + i10] + i19] & 255;
                        if (i21 != i28) {
                            if (1 < iSsSubstringPartition - iSsSubstringPartition2) {
                                break;
                            }
                            iSsSubstringPartition2 = iSsSubstringPartition;
                            i28 = i21;
                        }
                        iSsSubstringPartition++;
                    }
                    if ((bArr[(iArr[iArr[iSsSubstringPartition2] + i10] + i19) - 1] & 255) < i28) {
                        iSsSubstringPartition2 = bzip2DivSufSort.ssSubstringPartition(i10, iSsSubstringPartition2, iSsSubstringPartition, i19);
                    }
                    int i29 = iSsSubstringPartition - iSsSubstringPartition2;
                    int i30 = i22 - iSsSubstringPartition;
                    if (i29 <= i30) {
                        if (1 < i29) {
                            stackEntryArr[i20] = new StackEntry(iSsSubstringPartition, i22, i19, -1);
                            i19++;
                            iSsLog = ssLog(i29);
                            i20++;
                            int i31 = iSsLog;
                            i22 = iSsSubstringPartition;
                            iSsSubstringPartition = iSsSubstringPartition2;
                            iSsLog2 = i31;
                        } else {
                            iSsLog2 = -1;
                        }
                    } else if (1 < i30) {
                        stackEntryArr[i20] = new StackEntry(iSsSubstringPartition2, iSsSubstringPartition, i19 + 1, ssLog(i29));
                        iSsLog2 = -1;
                        i20++;
                    } else {
                        i19++;
                        iSsLog = ssLog(i29);
                        int i32 = iSsLog;
                        i22 = iSsSubstringPartition;
                        iSsSubstringPartition = iSsSubstringPartition2;
                        iSsLog2 = i32;
                    }
                } else {
                    int iSsPivot = bzip2DivSufSort.ssPivot(i19, i10, iSsSubstringPartition, i22);
                    int i33 = bArr[iArr[iArr[iSsPivot] + i10] + i19] & 255;
                    swapElements(iArr, iSsSubstringPartition, iArr, iSsPivot);
                    int i34 = iSsSubstringPartition + 1;
                    while (i34 < i22) {
                        i21 = bArr[iArr[iArr[i34] + i10] + i19] & 255;
                        if (i21 != i33) {
                            break;
                        } else {
                            i34++;
                        }
                    }
                    if (i34 >= i22 || i21 >= i33) {
                        i14 = i34;
                    } else {
                        i14 = i34;
                        while (true) {
                            i34++;
                            if (i34 >= i22 || (i21 = bArr[iArr[iArr[i34] + i10] + i19] & 255) > i33) {
                                break;
                            } else if (i21 == i33) {
                                swapElements(iArr, i34, iArr, i14);
                                i14++;
                            }
                        }
                    }
                    int i35 = i22 - 1;
                    while (i34 < i35) {
                        i21 = bArr[iArr[iArr[i35] + i10] + i19] & 255;
                        if (i21 != i33) {
                            break;
                        } else {
                            i35--;
                        }
                    }
                    if (i34 >= i35 || i21 <= i33) {
                        i15 = iSsLog2;
                        i16 = i35;
                    } else {
                        i15 = iSsLog2;
                        i16 = i35;
                        while (true) {
                            i35--;
                            if (i34 >= i35 || (i21 = bArr[iArr[iArr[i35] + i10] + i19] & 255) < i33) {
                                break;
                            } else if (i21 == i33) {
                                swapElements(iArr, i35, iArr, i16);
                                i16--;
                            }
                        }
                    }
                    while (i34 < i35) {
                        swapElements(iArr, i34, iArr, i35);
                        while (true) {
                            i34++;
                            if (i34 >= i35 || (i21 = bArr[iArr[iArr[i34] + i10] + i19] & 255) > i33) {
                                break;
                            } else if (i21 == i33) {
                                swapElements(iArr, i34, iArr, i14);
                                i14++;
                            }
                        }
                        while (true) {
                            i35--;
                            if (i34 >= i35 || (i21 = bArr[iArr[iArr[i35] + i10] + i19] & 255) < i33) {
                                break;
                            } else if (i21 == i33) {
                                swapElements(iArr, i35, iArr, i16);
                                i16--;
                            }
                        }
                    }
                    if (i14 <= i16) {
                        int i36 = i34 - 1;
                        i17 = i21;
                        int i37 = i14 - iSsSubstringPartition;
                        int i38 = i34 - i14;
                        if (i37 > i38) {
                            i37 = i38;
                        }
                        int i39 = iSsSubstringPartition;
                        int i40 = i34;
                        int i41 = i34 - i37;
                        while (i37 > 0) {
                            swapElements(iArr, i39, iArr, i41);
                            i37--;
                            i39++;
                            i41++;
                        }
                        int i42 = i16 - i36;
                        int i43 = (i22 - i16) - 1;
                        if (i42 <= i43) {
                            i43 = i42;
                        }
                        int i44 = i22 - i43;
                        int i45 = i40;
                        while (i43 > 0) {
                            swapElements(iArr, i45, iArr, i44);
                            i43--;
                            i45++;
                            i44++;
                        }
                        int i46 = iSsSubstringPartition + i38;
                        int i47 = i22 - i42;
                        int iSsSubstringPartition3 = i33 <= (bArr[(iArr[iArr[i46] + i10] + i19) + (-1)] & 255) ? i46 : bzip2DivSufSort.ssSubstringPartition(i10, i46, i47, i19);
                        int i48 = i46 - iSsSubstringPartition;
                        int i49 = i22 - i47;
                        if (i48 <= i49) {
                            int i50 = i47 - iSsSubstringPartition3;
                            if (i49 <= i50) {
                                int i51 = i20 + 1;
                                stackEntryArr[i20] = new StackEntry(iSsSubstringPartition3, i47, i19 + 1, ssLog(i50));
                                i20 += 2;
                                i18 = i27;
                                stackEntryArr[i51] = new StackEntry(i47, i22, i19, i18);
                            } else {
                                i18 = i27;
                                if (i48 <= i50) {
                                    int i52 = i20 + 1;
                                    stackEntryArr[i20] = new StackEntry(i47, i22, i19, i18);
                                    i20 += 2;
                                    stackEntryArr[i52] = new StackEntry(iSsSubstringPartition3, i47, i19 + 1, ssLog(i50));
                                } else {
                                    int i53 = i20 + 1;
                                    stackEntryArr[i20] = new StackEntry(i47, i22, i19, i18);
                                    i20 += 2;
                                    stackEntryArr[i53] = new StackEntry(iSsSubstringPartition, i46, i19, i18);
                                    i19++;
                                    iSsLog2 = ssLog(i50);
                                }
                            }
                            i21 = i17;
                            i22 = i46;
                            iSsLog2 = i18;
                        } else {
                            int i54 = i47 - iSsSubstringPartition3;
                            if (i48 <= i54) {
                                int i55 = i20 + 1;
                                stackEntryArr[i20] = new StackEntry(iSsSubstringPartition3, i47, i19 + 1, ssLog(i54));
                                i20 += 2;
                                stackEntryArr[i55] = new StackEntry(iSsSubstringPartition, i46, i19, i27);
                            } else if (i49 <= i54) {
                                int i56 = i20 + 1;
                                stackEntryArr[i20] = new StackEntry(iSsSubstringPartition, i46, i19, i27);
                                i20 += 2;
                                stackEntryArr[i56] = new StackEntry(iSsSubstringPartition3, i47, i19 + 1, ssLog(i54));
                            } else {
                                int i57 = i20 + 1;
                                stackEntryArr[i20] = new StackEntry(iSsSubstringPartition, i46, i19, i27);
                                i20 += 2;
                                stackEntryArr[i57] = new StackEntry(i47, i22, i19, i27);
                                i19++;
                                iSsLog2 = ssLog(i54);
                                bzip2DivSufSort = this;
                            }
                            bzip2DivSufSort = this;
                            iSsSubstringPartition = i47;
                            iSsLog2 = i27;
                        }
                        i22 = i47;
                        iSsSubstringPartition = iSsSubstringPartition3;
                    } else {
                        i17 = i21;
                        if ((bArr[(iArr[iArr[iSsSubstringPartition] + i10] + i19) - 1] & 255) < i33) {
                            bzip2DivSufSort = this;
                            iSsSubstringPartition = bzip2DivSufSort.ssSubstringPartition(i10, iSsSubstringPartition, i22, i19);
                            iSsLog2 = ssLog(i22 - iSsSubstringPartition);
                        } else {
                            bzip2DivSufSort = this;
                            iSsLog2 = i15;
                        }
                        i19++;
                    }
                    i21 = i17;
                }
            }
        }
    }

    private int ssPivot(int i10, int i11, int i12, int i13) {
        int i14 = i13 - i12;
        int i15 = (i14 / 2) + i12;
        if (i14 <= 512) {
            if (i14 <= 32) {
                return ssMedian3(i10, i11, i12, i15, i13 - 1);
            }
            int i16 = i14 >> 2;
            int i17 = i13 - 1;
            return ssMedian5(i10, i11, i12, i12 + i16, i15, i17 - i16, i17);
        }
        int i18 = i14 >> 3;
        int i19 = i18 << 1;
        int i20 = i13 - 1;
        return ssMedian3(i10, i11, ssMedian3(i10, i11, i12, i12 + i18, i12 + i19), ssMedian3(i10, i11, i15 - i18, i15, i15 + i18), ssMedian3(i10, i11, i20 - i19, i20 - i18, i20));
    }

    private int ssSubstringPartition(int i10, int i11, int i12, int i13) {
        int i14;
        int[] iArr = this.SA;
        int i15 = i11 - 1;
        while (true) {
            i15++;
            if (i15 < i12) {
                int i16 = iArr[i15];
                if (iArr[i10 + i16] + i13 >= iArr[i10 + i16 + 1] + 1) {
                    iArr[i15] = ~i16;
                }
            }
            do {
                i12--;
                if (i15 >= i12) {
                    break;
                }
                i14 = iArr[i12];
            } while (iArr[i10 + i14] + i13 < iArr[i14 + i10 + 1] + 1);
            if (i12 <= i15) {
                break;
            }
            int i17 = ~iArr[i12];
            iArr[i12] = iArr[i15];
            iArr[i15] = i17;
        }
        if (i11 < i15) {
            iArr[i11] = ~iArr[i11];
        }
        return i15;
    }

    private void subStringSort(int i10, int i11, int i12, int[] iArr, int i13, int i14, int i15, boolean z10, int i16) {
        int i17;
        int i18;
        int[] iArr2;
        int[] iArr3 = this.SA;
        int i19 = z10 ? i11 + 1 : i11;
        int i20 = 0;
        int i21 = i19;
        while (true) {
            int i22 = i21 + 1024;
            if (i22 >= i12) {
                break;
            }
            ssMultiKeyIntroSort(i10, i21, i22, i15);
            int i23 = i12 - i22;
            if (i23 <= i14) {
                iArr2 = iArr;
                i18 = i13;
                i17 = i14;
            } else {
                i17 = i23;
                i18 = i22;
                iArr2 = iArr3;
            }
            int i24 = i21;
            int i25 = 1024;
            int i26 = i20;
            while ((i26 & 1) != 0) {
                int i27 = i24 - i25;
                ssMerge(i10, i27, i24, i24 + i25, iArr2, i18, i17, i15);
                i25 <<= 1;
                i26 >>>= 1;
                i24 = i27;
                i22 = i22;
            }
            i20++;
            i21 = i22;
        }
        ssMultiKeyIntroSort(i10, i21, i12, i15);
        int i28 = i21;
        int i29 = 1024;
        for (int i30 = i20; i30 != 0; i30 >>= 1) {
            if ((i30 & 1) != 0) {
                int i31 = i28 - i29;
                ssMerge(i10, i31, i28, i12, iArr, i13, i14, i15);
                i28 = i31;
            }
            i29 <<= 1;
        }
        if (z10) {
            int i32 = iArr3[i19 - 1];
            int iSsCompareLast = 1;
            while (i19 < i12) {
                int i33 = iArr3[i19];
                if (i33 >= 0 && (iSsCompareLast = ssCompareLast(i10, i10 + i32, i10 + i33, i15, i16)) <= 0) {
                    break;
                }
                iArr3[i19 - 1] = iArr3[i19];
                i19++;
            }
            if (iSsCompareLast == 0) {
                iArr3[i19] = ~iArr3[i19];
            }
            iArr3[i19 - 1] = i32;
        }
    }

    private static void swapElements(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10];
        iArr[i10] = iArr2[i11];
        iArr2[i11] = i12;
    }

    private void trCopy(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int[] iArr = this.SA;
        int i17 = i14 - 1;
        int i18 = i13 - 1;
        while (i12 <= i18) {
            int i19 = iArr[i12] - i16;
            if (i19 < 0) {
                i19 += i11 - i10;
            }
            int i20 = i10 + i19;
            if (iArr[i20] == i17) {
                i18++;
                iArr[i18] = i19;
                iArr[i20] = i18;
            }
            i12++;
        }
        int i21 = i15 - 1;
        int i22 = i18 + 1;
        while (i22 < i14) {
            int i23 = iArr[i21] - i16;
            if (i23 < 0) {
                i23 += i11 - i10;
            }
            int i24 = i10 + i23;
            if (iArr[i24] == i17) {
                i14--;
                iArr[i14] = i23;
                iArr[i24] = i14;
            }
            i21--;
        }
    }

    private void trFixdown(int i10, int i11, int i12, int i13, int i14, int i15) {
        int[] iArr = this.SA;
        int i16 = iArr[i13 + i14];
        int iTrGetC = trGetC(i10, i11, i12, i16);
        while (true) {
            int i17 = i14 * 2;
            int i18 = i17 + 1;
            if (i18 >= i15) {
                break;
            }
            int i19 = i17 + 2;
            int iTrGetC2 = trGetC(i10, i11, i12, iArr[i13 + i18]);
            int iTrGetC3 = trGetC(i10, i11, i12, iArr[i13 + i19]);
            if (iTrGetC2 < iTrGetC3) {
                iTrGetC2 = iTrGetC3;
            } else {
                i19 = i18;
            }
            if (iTrGetC2 <= iTrGetC) {
                break;
            }
            iArr[i14 + i13] = iArr[i13 + i19];
            i14 = i19;
        }
        iArr[i13 + i14] = i16;
    }

    private int trGetC(int i10, int i11, int i12, int i13) {
        int i14 = i11 + i13;
        int[] iArr = this.SA;
        return i14 < i12 ? iArr[i14] : iArr[(((i11 - i10) + i13) % (i12 - i10)) + i10];
    }

    private void trHeapSort(int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int[] iArr = this.SA;
        int i16 = i14 % 2;
        if (i16 == 0) {
            int i17 = i14 - 1;
            int i18 = (i17 / 2) + i13;
            int i19 = i13 + i17;
            if (trGetC(i10, i11, i12, iArr[i18]) < trGetC(i10, i11, i12, iArr[i19])) {
                swapElements(iArr, i19, iArr, i18);
            }
            i15 = i17;
        } else {
            i15 = i14;
        }
        for (int i20 = (i15 / 2) - 1; i20 >= 0; i20--) {
            trFixdown(i10, i11, i12, i13, i20, i15);
        }
        if (i16 == 0) {
            swapElements(iArr, i13, iArr, i13 + i15);
            trFixdown(i10, i11, i12, i13, 0, i15);
        }
        for (int i21 = i15 - 1; i21 > 0; i21--) {
            int i22 = iArr[i13];
            int i23 = i13 + i21;
            iArr[i13] = iArr[i23];
            trFixdown(i10, i11, i12, i13, 0, i21);
            iArr[i23] = i22;
        }
    }

    private void trInsertionSort(int i10, int i11, int i12, int i13, int i14) {
        int iTrGetC;
        int[] iArr = this.SA;
        for (int i15 = i13 + 1; i15 < i14; i15++) {
            int i16 = iArr[i15];
            int i17 = i15 - 1;
            do {
                iTrGetC = trGetC(i10, i11, i12, i16) - trGetC(i10, i11, i12, iArr[i17]);
                if (iTrGetC >= 0) {
                    break;
                }
                do {
                    iArr[i17 + 1] = iArr[i17];
                    i17--;
                    if (i13 > i17) {
                        break;
                    }
                } while (iArr[i17] < 0);
            } while (i17 >= i13);
            if (iTrGetC == 0) {
                iArr[i17] = ~iArr[i17];
            }
            iArr[i17 + 1] = i16;
        }
    }

    private void trIntroSort(int i10, int i11, int i12, int i13, int i14, TRBudget tRBudget, int i15) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int iTrGetC;
        int iTrGetC2;
        int i23;
        int i24;
        int i25;
        int[] iArr;
        int i26;
        int i27;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i28 = i11;
        int i29 = i13;
        i29 = i14;
        int iTrLog = trLog(i14 - i13);
        int i30 = 0;
        int i31 = 0;
        while (true) {
            if (iTrLog >= 0) {
                i16 = i30;
                int i32 = i29;
                i17 = 0;
                int i33 = i29;
                int i34 = i33 - i32;
                if (i34 > 8) {
                    int i35 = iTrLog - 1;
                    if (iTrLog != 0) {
                        int i36 = iTrLog;
                        int iTrPivot = trPivot(i10, i28, i12, i32, i33);
                        i29 = i32;
                        swapElements(iArr2, i29, iArr2, iTrPivot);
                        int iTrGetC3 = trGetC(i10, i28, i12, iArr2[i29]);
                        int i37 = i29 + 1;
                        while (true) {
                            if (i37 >= i33) {
                                iTrGetC = i31;
                                break;
                            }
                            iTrGetC = trGetC(i10, i28, i12, iArr2[i37]);
                            if (iTrGetC != iTrGetC3) {
                                break;
                            }
                            i37++;
                            i31 = iTrGetC;
                        }
                        if (i37 >= i33 || iTrGetC >= iTrGetC3) {
                            iTrGetC2 = iTrGetC;
                            i23 = i37;
                        } else {
                            iTrGetC2 = iTrGetC;
                            int i38 = 1;
                            i23 = i37;
                            while (true) {
                                i37 += i38;
                                if (i37 >= i33 || (iTrGetC2 = trGetC(i10, i28, i12, iArr2[i37])) > iTrGetC3) {
                                    break;
                                }
                                if (iTrGetC2 == iTrGetC3) {
                                    swapElements(iArr2, i37, iArr2, i23);
                                    i23++;
                                }
                                i38 = 1;
                            }
                        }
                        int i39 = i33 - 1;
                        while (i37 < i39) {
                            iTrGetC2 = trGetC(i10, i28, i12, iArr2[i39]);
                            if (iTrGetC2 != iTrGetC3) {
                                break;
                            } else {
                                i39--;
                            }
                        }
                        if (i37 >= i39 || iTrGetC2 <= iTrGetC3) {
                            i24 = i23;
                            i31 = iTrGetC2;
                            i25 = i39;
                        } else {
                            int i40 = i23;
                            int i41 = i39;
                            while (true) {
                                i39--;
                                if (i37 >= i39 || (iTrGetC2 = trGetC(i10, i28, i12, iArr2[i39])) < iTrGetC3) {
                                    break;
                                } else if (iTrGetC2 == iTrGetC3) {
                                    swapElements(iArr2, i39, iArr2, i41);
                                    i41--;
                                }
                            }
                            i31 = iTrGetC2;
                            i25 = i41;
                            i24 = i40;
                        }
                        while (i37 < i39) {
                            swapElements(iArr2, i37, iArr2, i39);
                            while (true) {
                                i37++;
                                int i42 = i39;
                                if (i37 >= i39) {
                                    break;
                                }
                                int iTrGetC4 = trGetC(i10, i28, i12, iArr2[i37]);
                                if (iTrGetC4 > iTrGetC3) {
                                    i31 = iTrGetC4;
                                    i39 = i42;
                                    break;
                                } else {
                                    if (iTrGetC4 == iTrGetC3) {
                                        swapElements(iArr2, i37, iArr2, i24);
                                        i24++;
                                    }
                                    i31 = iTrGetC4;
                                    i39 = i42;
                                }
                            }
                            while (true) {
                                i39--;
                                int i43 = i37;
                                if (i37 >= i39) {
                                    break;
                                }
                                int iTrGetC5 = trGetC(i10, i28, i12, iArr2[i39]);
                                if (iTrGetC5 < iTrGetC3) {
                                    i31 = iTrGetC5;
                                    i37 = i43;
                                    break;
                                } else {
                                    if (iTrGetC5 == iTrGetC3) {
                                        swapElements(iArr2, i39, iArr2, i25);
                                        i25--;
                                    }
                                    i31 = iTrGetC5;
                                    i37 = i43;
                                }
                            }
                        }
                        if (i24 <= i25) {
                            int i44 = i37 - 1;
                            int i45 = i24 - i29;
                            int i46 = i37 - i24;
                            if (i45 > i46) {
                                i45 = i46;
                            }
                            int i47 = i37;
                            int i48 = i37 - i45;
                            int i49 = i45;
                            int i50 = i29;
                            while (i49 > 0) {
                                swapElements(iArr2, i50, iArr2, i48);
                                i49--;
                                i50++;
                                i48++;
                            }
                            int i51 = i25 - i44;
                            int i52 = (i33 - i25) - 1;
                            if (i51 <= i52) {
                                i52 = i51;
                            }
                            int i53 = i52;
                            int i54 = i33 - i52;
                            int i55 = i47;
                            while (i53 > 0) {
                                swapElements(iArr2, i55, iArr2, i54);
                                i53--;
                                i55++;
                                i54++;
                            }
                            i29 += i46;
                            int i56 = i33 - i51;
                            iTrLog = iArr2[iArr2[i29] + i10] != iTrGetC3 ? trLog(i56 - i29) : -1;
                            int i57 = i29 - 1;
                            for (int i58 = i29; i58 < i29; i58++) {
                                iArr2[iArr2[i58] + i10] = i57;
                            }
                            if (i56 < i33) {
                                int i59 = i56 - 1;
                                for (int i60 = i29; i60 < i56; i60++) {
                                    iArr2[iArr2[i60] + i10] = i59;
                                }
                            }
                            int i61 = i29 - i29;
                            int i62 = i33 - i56;
                            if (i61 <= i62) {
                                int i63 = i56 - i29;
                                if (i62 <= i63) {
                                    iArr = iArr2;
                                    if (1 < i61) {
                                        stackEntryArr[i16] = new StackEntry(i28 + 1, i29, i56, iTrLog);
                                        i26 = i35;
                                        stackEntryArr[i16 + 1] = new StackEntry(i28, i56, i33, i26);
                                        i30 = i16 + 2;
                                    } else {
                                        i26 = i35;
                                        if (1 < i62) {
                                            i30 = i16 + 1;
                                            stackEntryArr[i16] = new StackEntry(i28 + 1, i29, i56, iTrLog);
                                            i29 = i56;
                                            i29 = i33;
                                        } else if (1 < i63) {
                                            i28++;
                                            iTrLog = iTrLog;
                                            i30 = i16;
                                            iArr2 = iArr;
                                            i29 = i56;
                                        } else {
                                            if (i16 == 0) {
                                                return;
                                            }
                                            i30 = i16 - 1;
                                            StackEntry stackEntry = stackEntryArr[i30];
                                            i28 = stackEntry.f8308a;
                                            i29 = stackEntry.f8309b;
                                            i29 = stackEntry.f8310c;
                                            iTrLog = stackEntry.f8311d;
                                        }
                                    }
                                } else {
                                    iArr = iArr2;
                                    i26 = i35;
                                    if (i61 <= i63) {
                                        if (1 < i61) {
                                            stackEntryArr[i16] = new StackEntry(i28, i56, i33, i26);
                                            stackEntryArr[i16 + 1] = new StackEntry(i28 + 1, i29, i56, iTrLog);
                                            i30 = i16 + 2;
                                        } else if (1 < i63) {
                                            i30 = i16 + 1;
                                            stackEntryArr[i16] = new StackEntry(i28, i56, i33, i26);
                                            i28++;
                                            iArr2 = iArr;
                                            i29 = i56;
                                        } else {
                                            i29 = i56;
                                            i29 = i33;
                                            iTrLog = i26;
                                            i30 = i16;
                                        }
                                    } else if (1 < i63) {
                                        stackEntryArr[i16] = new StackEntry(i28, i56, i33, i26);
                                        i27 = i16 + 2;
                                        stackEntryArr[i16 + 1] = new StackEntry(i28, i29, i29, i26);
                                        i28++;
                                        i30 = i27;
                                        iArr2 = iArr;
                                        i29 = i56;
                                    } else {
                                        i30 = i16 + 1;
                                        stackEntryArr[i16] = new StackEntry(i28, i56, i33, i26);
                                    }
                                }
                                iTrLog = i26;
                            } else {
                                iArr = iArr2;
                                i26 = i35;
                                int i64 = i56 - i29;
                                if (i61 <= i64) {
                                    if (1 < i62) {
                                        stackEntryArr[i16] = new StackEntry(i28 + 1, i29, i56, iTrLog);
                                        stackEntryArr[i16 + 1] = new StackEntry(i28, i29, i29, i26);
                                        i30 = i16 + 2;
                                        i29 = i56;
                                    } else if (1 < i61) {
                                        i30 = i16 + 1;
                                        stackEntryArr[i16] = new StackEntry(i28 + 1, i29, i56, iTrLog);
                                        iTrLog = i26;
                                    } else if (1 < i64) {
                                        i28++;
                                        iTrLog = iTrLog;
                                        i30 = i16;
                                        iArr2 = iArr;
                                        i29 = i56;
                                    } else {
                                        i30 = i16 + 1;
                                        stackEntryArr[i16] = new StackEntry(i28, i29, i33, i26);
                                    }
                                } else if (i62 <= i64) {
                                    if (1 < i62) {
                                        stackEntryArr[i16] = new StackEntry(i28, i29, i29, i26);
                                        stackEntryArr[i16 + 1] = new StackEntry(i28 + 1, i29, i56, iTrLog);
                                        i29 = i56;
                                        i30 = i16 + 2;
                                    } else if (1 < i64) {
                                        i30 = i16 + 1;
                                        stackEntryArr[i16] = new StackEntry(i28, i29, i29, i26);
                                        i28++;
                                        iArr2 = iArr;
                                        i29 = i56;
                                    } else {
                                        iTrLog = i26;
                                        i30 = i16;
                                    }
                                } else if (1 < i64) {
                                    stackEntryArr[i16] = new StackEntry(i28, i29, i29, i26);
                                    i27 = i16 + 2;
                                    stackEntryArr[i16 + 1] = new StackEntry(i28, i56, i33, i26);
                                    i28++;
                                    i30 = i27;
                                    iArr2 = iArr;
                                    i29 = i56;
                                } else {
                                    i30 = i16 + 1;
                                    stackEntryArr[i16] = new StackEntry(i28, i29, i29, i26);
                                    i29 = i56;
                                }
                                i29 = i33;
                                iTrLog = i26;
                            }
                        } else {
                            iArr = iArr2;
                            if (!tRBudget.update(i15, i34)) {
                                break;
                            }
                            i28++;
                            i29 = i33;
                            i30 = i16;
                            iTrLog = i36;
                        }
                        iArr2 = iArr;
                    } else {
                        if (!tRBudget.update(i15, i34)) {
                            break;
                        }
                        trHeapSort(i10, i28, i12, i32, i34);
                        int i65 = i33 - 1;
                        while (i32 < i65) {
                            int i66 = i32;
                            int iTrGetC6 = trGetC(i10, i28, i12, iArr2[i65]);
                            i65--;
                            while (i66 <= i65 && trGetC(i10, i28, i12, iArr2[i65]) == iTrGetC6) {
                                iArr2[i65] = ~iArr2[i65];
                                i65--;
                            }
                            i31 = iTrGetC6;
                            i32 = i66;
                        }
                        i29 = i32;
                        i29 = i33;
                        i30 = i16;
                        iTrLog = -3;
                    }
                } else {
                    if (!tRBudget.update(i15, i34)) {
                        break;
                    }
                    iTrLog = -3;
                    trInsertionSort(i10, i28, i12, i32, i33);
                    i29 = i32;
                    i29 = i33;
                    i30 = i16;
                }
            } else if (iTrLog != -1) {
                int i67 = i30;
                i29 = i29;
                int i68 = i29;
                if (iTrLog == -2) {
                    int i69 = i67 - 1;
                    StackEntry stackEntry2 = stackEntryArr[i69];
                    trCopy(i10, i12, i29, stackEntry2.f8309b, stackEntry2.f8310c, i68, i28 - i10);
                    if (i69 == 0) {
                        return;
                    }
                    i30 = i67 - 2;
                    StackEntry stackEntry3 = stackEntryArr[i30];
                    i28 = stackEntry3.f8308a;
                    i29 = stackEntry3.f8309b;
                    i29 = stackEntry3.f8310c;
                    iTrLog = stackEntry3.f8311d;
                } else {
                    if (iArr2[i29] >= 0) {
                        do {
                            iArr2[iArr2[i29] + i10] = i29;
                            i29++;
                            if (i29 >= i68) {
                                break;
                            }
                        } while (iArr2[i29] >= 0);
                    }
                    if (i29 < i68) {
                        int i70 = i29;
                        while (true) {
                            iArr2[i70] = ~iArr2[i70];
                            i21 = i70 + 1;
                            i22 = iArr2[i21];
                            if (i22 >= 0) {
                                break;
                            } else {
                                i70 = i21;
                            }
                        }
                        iTrLog = iArr2[i10 + i22] != iArr2[i22 + i28] ? trLog((i21 - i29) + 1) : -1;
                        i29 = i70 + 2;
                        if (i29 < i68) {
                            int i71 = i70 + 1;
                            for (int i72 = i29; i72 < i29; i72++) {
                                iArr2[iArr2[i72] + i10] = i71;
                            }
                        }
                        int i73 = i68 - i29;
                        if (i29 - i29 <= i73) {
                            i30 = i67 + 1;
                            stackEntryArr[i67] = new StackEntry(i28, i29, i68, -3);
                            i28++;
                        } else if (1 < i73) {
                            i30 = i67 + 1;
                            stackEntryArr[i67] = new StackEntry(i28 + 1, i29, i29, iTrLog);
                            iTrLog = -3;
                            i29 = i29;
                            i29 = i68;
                        } else {
                            i28++;
                            i30 = i67;
                        }
                    } else {
                        if (i67 == 0) {
                            return;
                        }
                        i30 = i67 - 1;
                        StackEntry stackEntry4 = stackEntryArr[i30];
                        i28 = stackEntry4.f8308a;
                        i29 = stackEntry4.f8309b;
                        i29 = stackEntry4.f8310c;
                        iTrLog = stackEntry4.f8311d;
                    }
                }
            } else {
                if (!tRBudget.update(i15, i29 - i29)) {
                    i16 = i30;
                    i17 = 0;
                    break;
                }
                int i74 = i28 - 1;
                int i75 = i30;
                int i76 = i29;
                int i77 = i29;
                PartitionResult partitionResultTrPartition = trPartition(i10, i74, i12, i29, i76, i29 - 1);
                int i78 = partitionResultTrPartition.first;
                int i79 = partitionResultTrPartition.last;
                if (i77 < i78 || i79 < i76) {
                    if (i78 < i76) {
                        int i80 = i78 - 1;
                        for (int i81 = i77; i81 < i78; i81++) {
                            iArr2[iArr2[i81] + i10] = i80;
                        }
                    }
                    if (i79 < i76) {
                        int i82 = i79 - 1;
                        for (int i83 = i78; i83 < i79; i83++) {
                            iArr2[iArr2[i83] + i10] = i82;
                        }
                    }
                    stackEntryArr[i75] = new StackEntry(0, i78, i79, 0);
                    int i84 = i75 + 2;
                    stackEntryArr[i75 + 1] = new StackEntry(i74, i77, i76, -2);
                    int i85 = i78 - i77;
                    int i86 = i76 - i79;
                    if (i85 <= i86) {
                        if (1 < i85) {
                            stackEntryArr[i84] = new StackEntry(i28, i79, i76, trLog(i86));
                            int iTrLog2 = trLog(i85);
                            i29 = i78;
                            i30 = i75 + 3;
                            i29 = i77;
                            iTrLog = iTrLog2;
                        } else if (1 < i86) {
                            iTrLog = trLog(i86);
                            i30 = i84;
                            i29 = i76;
                            i29 = i79;
                        } else {
                            if (i84 == 0) {
                                return;
                            }
                            i30 = i75 + 1;
                            StackEntry stackEntry5 = stackEntryArr[i30];
                            i18 = stackEntry5.f8308a;
                            i19 = stackEntry5.f8309b;
                            i29 = stackEntry5.f8310c;
                            i20 = stackEntry5.f8311d;
                        }
                    } else if (1 < i86) {
                        stackEntryArr[i84] = new StackEntry(i28, i77, i78, trLog(i85));
                        int iTrLog3 = trLog(i86);
                        i29 = i76;
                        i30 = i75 + 3;
                        i29 = i79;
                        iTrLog = iTrLog3;
                    } else if (1 < i85) {
                        iTrLog = trLog(i85);
                        i29 = i78;
                        i30 = i84;
                        i29 = i77;
                    } else {
                        if (i84 == 0) {
                            return;
                        }
                        i30 = i75 + 1;
                        StackEntry stackEntry6 = stackEntryArr[i30];
                        i18 = stackEntry6.f8308a;
                        i19 = stackEntry6.f8309b;
                        i29 = stackEntry6.f8310c;
                        i20 = stackEntry6.f8311d;
                    }
                } else {
                    while (i77 < i76) {
                        iArr2[iArr2[i77] + i10] = i77;
                        i77++;
                    }
                    if (i75 == 0) {
                        return;
                    }
                    i30 = i75 - 1;
                    StackEntry stackEntry7 = stackEntryArr[i30];
                    i18 = stackEntry7.f8308a;
                    i19 = stackEntry7.f8309b;
                    i29 = stackEntry7.f8310c;
                    i20 = stackEntry7.f8311d;
                }
                iTrLog = i20;
                i28 = i18;
                i29 = i19;
            }
        }
        for (int i87 = i17; i87 < i16; i87++) {
            StackEntry stackEntry8 = stackEntryArr[i87];
            if (stackEntry8.f8311d == -3) {
                lsUpdateGroup(i10, stackEntry8.f8309b, stackEntry8.f8310c);
            }
        }
    }

    private static int trLog(int i10) {
        if (((-65536) & i10) != 0) {
            return ((-16777216) & i10) != 0 ? LOG_2_TABLE[(i10 >> 24) & 255] + 24 : LOG_2_TABLE[(i10 >> 16) & 271];
        }
        return (65280 & i10) != 0 ? LOG_2_TABLE[(i10 >> 8) & 255] + 8 : LOG_2_TABLE[i10 & 255];
    }

    private int trMedian3(int i10, int i11, int i12, int i13, int i14, int i15) {
        int[] iArr = this.SA;
        int iTrGetC = trGetC(i10, i11, i12, iArr[i13]);
        int iTrGetC2 = trGetC(i10, i11, i12, iArr[i14]);
        int iTrGetC3 = trGetC(i10, i11, i12, iArr[i15]);
        if (iTrGetC <= iTrGetC2) {
            i14 = i13;
            i13 = i14;
            iTrGetC2 = iTrGetC;
            iTrGetC = iTrGetC2;
        }
        if (iTrGetC > iTrGetC3) {
            return iTrGetC2 > iTrGetC3 ? i14 : i15;
        }
        return i13;
    }

    private int trMedian5(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int[] iArr = this.SA;
        int iTrGetC = trGetC(i10, i11, i12, iArr[i13]);
        int iTrGetC2 = trGetC(i10, i11, i12, iArr[i14]);
        int iTrGetC3 = trGetC(i10, i11, i12, iArr[i15]);
        int iTrGetC4 = trGetC(i10, i11, i12, iArr[i16]);
        int iTrGetC5 = trGetC(i10, i11, i12, iArr[i17]);
        if (iTrGetC2 > iTrGetC3) {
            i15 = i14;
            i14 = i15;
            iTrGetC3 = iTrGetC2;
            iTrGetC2 = iTrGetC3;
        }
        if (iTrGetC4 > iTrGetC5) {
            iTrGetC4 = iTrGetC5;
            iTrGetC5 = iTrGetC4;
        } else {
            i17 = i16;
            i16 = i17;
        }
        if (iTrGetC2 > iTrGetC4) {
            int i18 = iTrGetC3;
            iTrGetC3 = iTrGetC5;
            iTrGetC5 = i18;
            int i19 = i16;
            i16 = i15;
            i15 = i19;
        } else {
            i14 = i17;
            iTrGetC2 = iTrGetC4;
        }
        if (iTrGetC > iTrGetC3) {
            int i20 = i15;
            i15 = i13;
            i13 = i20;
            int i21 = iTrGetC3;
            iTrGetC3 = iTrGetC;
            iTrGetC = i21;
        }
        if (iTrGetC > iTrGetC2) {
            i14 = i13;
            iTrGetC2 = iTrGetC;
        } else {
            i16 = i15;
            iTrGetC5 = iTrGetC3;
        }
        return iTrGetC5 > iTrGetC2 ? i14 : i16;
    }

    private PartitionResult trPartition(int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int i17;
        int iTrGetC;
        int iTrGetC2;
        int iTrGetC3;
        int[] iArr = this.SA;
        int iTrGetC4 = 0;
        int i18 = i13;
        while (i18 < i14) {
            iTrGetC4 = trGetC(i10, i11, i12, iArr[i18]);
            if (iTrGetC4 != i15) {
                break;
            }
            i18++;
        }
        if (i18 >= i14 || iTrGetC4 >= i15) {
            i16 = i18;
        } else {
            i16 = i18;
            while (true) {
                i18++;
                if (i18 >= i14 || (iTrGetC4 = trGetC(i10, i11, i12, iArr[i18])) > i15) {
                    break;
                }
                if (iTrGetC4 == i15) {
                    swapElements(iArr, i18, iArr, i16);
                    i16++;
                }
            }
        }
        int i19 = i14 - 1;
        while (i18 < i19) {
            iTrGetC4 = trGetC(i10, i11, i12, iArr[i19]);
            if (iTrGetC4 != i15) {
                break;
            }
            i19--;
        }
        if (i18 >= i19 || iTrGetC4 <= i15) {
            i17 = i19;
        } else {
            i17 = i19;
            while (true) {
                i19--;
                if (i18 >= i19 || (iTrGetC3 = trGetC(i10, i11, i12, iArr[i19])) < i15) {
                    break;
                }
                if (iTrGetC3 == i15) {
                    swapElements(iArr, i19, iArr, i17);
                    i17--;
                }
            }
        }
        while (i18 < i19) {
            swapElements(iArr, i18, iArr, i19);
            while (true) {
                i18++;
                if (i18 >= i19 || (iTrGetC2 = trGetC(i10, i11, i12, iArr[i18])) > i15) {
                    break;
                }
                if (iTrGetC2 == i15) {
                    swapElements(iArr, i18, iArr, i16);
                    i16++;
                }
            }
            while (true) {
                i19--;
                if (i18 >= i19 || (iTrGetC = trGetC(i10, i11, i12, iArr[i19])) < i15) {
                    break;
                }
                if (iTrGetC == i15) {
                    swapElements(iArr, i19, iArr, i17);
                    i17--;
                }
            }
        }
        if (i16 <= i17) {
            int i20 = i18 - 1;
            int i21 = i16 - i13;
            int i22 = i18 - i16;
            if (i21 > i22) {
                i21 = i22;
            }
            int i23 = i18 - i21;
            int i24 = i13;
            while (i21 > 0) {
                swapElements(iArr, i24, iArr, i23);
                i21--;
                i24++;
                i23++;
            }
            int i25 = i17 - i20;
            int i26 = (i14 - i17) - 1;
            if (i25 <= i26) {
                i26 = i25;
            }
            int i27 = i14 - i26;
            while (i26 > 0) {
                swapElements(iArr, i18, iArr, i27);
                i26--;
                i18++;
                i27++;
            }
            i13 += i22;
            i14 -= i25;
        }
        return new PartitionResult(i13, i14);
    }

    private int trPivot(int i10, int i11, int i12, int i13, int i14) {
        int i15 = i14 - i13;
        int i16 = (i15 / 2) + i13;
        if (i15 <= 512) {
            if (i15 <= 32) {
                return trMedian3(i10, i11, i12, i13, i16, i14 - 1);
            }
            int i17 = i15 >> 2;
            int i18 = i14 - 1;
            return trMedian5(i10, i11, i12, i13, i13 + i17, i16, i18 - i17, i18);
        }
        int i19 = i15 >> 3;
        int i20 = i19 << 1;
        int i21 = i14 - 1;
        return trMedian3(i10, i11, i12, trMedian3(i10, i11, i12, i13, i13 + i19, i13 + i20), trMedian3(i10, i11, i12, i16 - i19, i16, i16 + i19), trMedian3(i10, i11, i12, i21 - i20, i21 - i19, i21));
    }

    private void trSort(int i10, int i11, int i12) {
        int[] iArr = this.SA;
        if ((-i11) < iArr[0]) {
            TRBudget tRBudget = new TRBudget(i11, ((trLog(i11) * 2) / 3) + 1);
            int i13 = 0;
            do {
                int i14 = iArr[i13];
                if (i14 < 0) {
                    i13 -= i14;
                } else {
                    int i15 = iArr[i10 + i14] + 1;
                    if (1 < i15 - i13) {
                        trIntroSort(i10, i10 + i12, i10 + i11, i13, i15, tRBudget, i11);
                        if (tRBudget.chance == 0) {
                            if (i13 > 0) {
                                iArr[0] = -i13;
                            }
                            lsSort(i10, i11, i12);
                            return;
                        }
                    }
                    i13 = i15;
                }
            } while (i13 < i11);
        }
    }

    public int bwt() {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i10 = this.f8307n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            iArr[0] = bArr[0];
            return 0;
        }
        if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        }
        return 0;
    }
}
