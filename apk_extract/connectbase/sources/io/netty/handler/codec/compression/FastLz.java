package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import s1.c;

/* JADX INFO: loaded from: classes3.dex */
final class FastLz {
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int CHECKSUM_OFFSET = 4;
    private static final int HASH_LOG = 13;
    private static final int HASH_MASK = 8191;
    private static final int HASH_SIZE = 8192;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final int LEVEL_AUTO = 0;
    static final int MAGIC_NUMBER = 4607066;
    static final int MAX_CHUNK_LENGTH = 65535;
    private static final int MAX_COPY = 32;
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int MAX_LEN = 264;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int OPTIONS_OFFSET = 3;

    private FastLz() {
    }

    public static int calculateOutputBufferLength(int i10) {
        return Math.max((int) (((double) i10) * 1.06d), 66);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x020b  */
    /* JADX WARN: Code duplicated, block: B:101:0x022a  */
    /* JADX WARN: Code duplicated, block: B:104:0x0241 A[LOOP:4: B:102:0x023d->B:104:0x0241, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:106:0x025f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0265  */
    /* JADX WARN: Code duplicated, block: B:109:0x0290  */
    /* JADX WARN: Code duplicated, block: B:111:0x029f A[LOOP:5: B:110:0x029d->B:111:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:113:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:115:0x02d4 A[LOOP:6: B:115:0x02d4->B:117:0x02d8, LOOP_START, PHI: r8 r9 r14
      0x02d4: PHI (r8v12 char) = (r8v6 char), (r8v18 char) binds: [B:114:0x02d2, B:117:0x02d8] A[DONT_GENERATE, DONT_INLINE]
      0x02d4: PHI (r9v24 int) = (r9v16 int), (r9v30 int) binds: [B:114:0x02d2, B:117:0x02d8] A[DONT_GENERATE, DONT_INLINE]
      0x02d4: PHI (r14v15 int) = (r14v11 int), (r14v16 int) binds: [B:114:0x02d2, B:117:0x02d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x02d8 A[LOOP:6: B:115:0x02d4->B:117:0x02d8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:119:0x0302  */
    /* JADX WARN: Code duplicated, block: B:120:0x031f  */
    /* JADX WARN: Code duplicated, block: B:139:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x01ea A[EDGE_INSN: B:150:0x01ea->B:92:0x01ea BREAK  A[LOOP:3: B:74:0x019b->B:78:0x01a8], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x01ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x01e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0092  */
    /* JADX WARN: Code duplicated, block: B:67:0x0165  */
    /* JADX WARN: Code duplicated, block: B:73:0x0191  */
    /* JADX WARN: Code duplicated, block: B:75:0x019d  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a8 A[LOOP:3: B:74:0x019b->B:78:0x01a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:81:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c8 A[LOOP:7: B:80:0x01af->B:84:0x01c8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x01d1 A[ADDED_TO_REGION, LOOP:8: B:87:0x01d1->B:91:0x01e7, LOOP_START, PHI: r1 r9
      0x01d1: PHI (r1v13 int) = (r1v12 int), (r1v17 int) binds: [B:86:0x01cf, B:91:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x01d1: PHI (r9v8 int) = (r9v7 int), (r9v11 int) binds: [B:86:0x01cf, B:91:0x01e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e7 A[LOOP:8: B:87:0x01d1->B:91:0x01e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:97:0x0204  */
    /* JADX WARN: Code duplicated, block: B:99:0x0209 A[DONT_INVERT] */
    public static int compress(ByteBuf byteBuf, int i10, int i11, ByteBuf byteBuf2, int i12, int i13) {
        int i14;
        long j10;
        int i15;
        boolean z10;
        int i16;
        int i17;
        int i18;
        int i19;
        long j11;
        char c10;
        int i20;
        int i21;
        boolean z11;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int[] iArr;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        byte b10;
        int i32;
        int i33;
        int i34;
        char c11;
        int i35 = 2;
        boolean z12 = true;
        int i36 = i13 == 0 ? i11 < 65536 ? 1 : 2 : i13;
        int i37 = i11 - 2;
        int i38 = i11 - 12;
        int[] iArr2 = new int[8192];
        if (i11 < 4) {
            if (i11 == 0) {
                return 0;
            }
            byteBuf2.setByte(i12, (byte) (i11 - 1));
            int i39 = i11 - 1;
            int i40 = 1;
            for (int i41 = 0; i41 <= i39; i41++) {
                byteBuf2.setByte(i40 + i12, byteBuf.getByte(i10 + i41));
                i40++;
            }
            return i11 + 1;
        }
        for (int i42 = 0; i42 < 8192; i42++) {
            iArr2[i42] = 0;
        }
        byteBuf2.setByte(i12, 31);
        byteBuf2.setByte(i12 + 1, byteBuf.getByte(i10));
        byteBuf2.setByte(i12 + 2, byteBuf.getByte(i10 + 1));
        int i43 = 2;
        int i44 = 2;
        int i45 = 3;
        while (i43 < i38) {
            if (i36 == i35) {
                int i46 = i10 + i43;
                int i47 = i46 - 1;
                if (byteBuf.getByte(i46) == byteBuf.getByte(i47) && readU16(byteBuf, i47) == readU16(byteBuf, i46 + 1)) {
                    i14 = i43 + 3;
                    i15 = i43 + 2;
                    z10 = z12;
                    j10 = 1;
                } else {
                    i14 = i43;
                    j10 = 0;
                    i15 = 0;
                    z10 = false;
                }
            } else {
                i14 = i43;
                j10 = 0;
                i15 = 0;
                z10 = false;
            }
            if (z10) {
                i16 = i37;
                i17 = i38;
            } else {
                int i48 = i10 + i14;
                int iHashFunction = hashFunction(byteBuf, i48);
                int i49 = iArr2[iHashFunction];
                i16 = i37;
                i17 = i38;
                long j12 = i43 - i49;
                iArr2[iHashFunction] = i43;
                if (j12 == 0 || (i36 != 1 ? j12 >= 73725 : j12 >= 8191)) {
                    i33 = i45 + 1;
                    i34 = i43 + 1;
                    byteBuf2.setByte(i12 + i45, byteBuf.getByte(i10 + i43));
                    i44++;
                    if (i44 == 32) {
                        i45 += 2;
                        c11 = c.f14922b;
                        byteBuf2.setByte(i33 + i12, 31);
                        i43 = i34;
                        i37 = i16;
                        i38 = i17;
                        i35 = 2;
                        z12 = true;
                        i44 = 0;
                    } else {
                        i45 = i33;
                        i43 = i34;
                        i37 = i16;
                        i38 = i17;
                        i35 = 2;
                        z12 = true;
                    }
                } else {
                    int i50 = i49 + 1;
                    int i51 = i14 + 1;
                    if (byteBuf.getByte(i10 + i49) == byteBuf.getByte(i48)) {
                        int i52 = i49 + 2;
                        int i53 = i14 + 2;
                        if (byteBuf.getByte(i10 + i50) == byteBuf.getByte(i10 + i51)) {
                            int i54 = i49 + 3;
                            byte b11 = byteBuf.getByte(i10 + i52);
                            int i55 = i14 + 3;
                            if (b11 != byteBuf.getByte(i10 + i53)) {
                                i33 = i45 + 1;
                                i34 = i43 + 1;
                                byteBuf2.setByte(i12 + i45, byteBuf.getByte(i10 + i43));
                                i44++;
                                if (i44 == 32) {
                                    i45 += 2;
                                    c11 = c.f14922b;
                                    byteBuf2.setByte(i33 + i12, 31);
                                    i43 = i34;
                                    i37 = i16;
                                    i38 = i17;
                                    i35 = 2;
                                    z12 = true;
                                    i44 = 0;
                                } else {
                                    i45 = i33;
                                    i43 = i34;
                                    i37 = i16;
                                    i38 = i17;
                                    i35 = 2;
                                    z12 = true;
                                }
                            } else {
                                if (i36 != 2 || j12 < 8191) {
                                    i15 = i54;
                                    j10 = j12;
                                } else {
                                    int i56 = i14 + 4;
                                    byte b12 = byteBuf.getByte(i10 + i55);
                                    int i57 = i49 + 4;
                                    if (b12 == byteBuf.getByte(i10 + i54)) {
                                        byte b13 = byteBuf.getByte(i10 + i56);
                                        int i58 = i49 + 5;
                                        if (b13 == byteBuf.getByte(i10 + i57)) {
                                            i18 = 5;
                                            i15 = i58;
                                            j10 = j12;
                                        }
                                    }
                                    i33 = i45 + 1;
                                    i34 = i43 + 1;
                                    byteBuf2.setByte(i12 + i45, byteBuf.getByte(i10 + i43));
                                    i44++;
                                    if (i44 == 32) {
                                        i45 += 2;
                                        c11 = c.f14922b;
                                        byteBuf2.setByte(i33 + i12, 31);
                                        i43 = i34;
                                        i37 = i16;
                                        i38 = i17;
                                        i35 = 2;
                                        z12 = true;
                                        i44 = 0;
                                    } else {
                                        i45 = i33;
                                        i43 = i34;
                                        i37 = i16;
                                        i38 = i17;
                                        i35 = 2;
                                        z12 = true;
                                    }
                                }
                                i19 = i18 + i43;
                                j11 = j10 - 1;
                                c10 = '\b';
                                if (j11 == 0) {
                                    b10 = byteBuf.getByte((i10 + i19) - 1);
                                    i20 = i16;
                                    while (i19 < i20) {
                                        i32 = i15 + 1;
                                        if (byteBuf.getByte(i10 + i15) != b10) {
                                            break;
                                        }
                                        i19++;
                                        i15 = i32;
                                    }
                                } else {
                                    i20 = i16;
                                    i21 = 0;
                                    while (true) {
                                        if (i21 < 8) {
                                            z11 = false;
                                            break;
                                        }
                                        i24 = i15 + 1;
                                        i25 = i19 + 1;
                                        if (byteBuf.getByte(i10 + i15) != byteBuf.getByte(i10 + i19)) {
                                            i15 = i24;
                                            i19 = i25;
                                            z11 = true;
                                            break;
                                        }
                                        i21++;
                                        i15 = i24;
                                        i19 = i25;
                                    }
                                    if (!z11) {
                                        while (i19 < i20) {
                                            i22 = i15 + 1;
                                            i23 = i19 + 1;
                                            if (byteBuf.getByte(i10 + i15) != byteBuf.getByte(i10 + i19)) {
                                                i19 = i23;
                                                break;
                                            }
                                            i15 = i22;
                                            i19 = i23;
                                        }
                                    }
                                }
                                if (i44 != 0) {
                                    byteBuf2.setByte(((i12 + i45) - i44) - 1, (byte) (i44 - 1));
                                } else {
                                    i45--;
                                }
                                int i59 = i19 - 3;
                                i26 = i59 - i43;
                                if (i36 == 2) {
                                    iArr = iArr2;
                                    if (i26 > 262) {
                                        while (i26 > 262) {
                                            byteBuf2.setByte(i12 + i45, (byte) ((j11 >>> c10) + 224));
                                            int i60 = i45 + 2;
                                            byteBuf2.setByte(i12 + i45 + 1, -3);
                                            i45 += 3;
                                            byteBuf2.setByte(i60 + i12, (byte) (j11 & 255));
                                            i26 -= 262;
                                            c10 = '\b';
                                        }
                                    }
                                    if (i26 < 7) {
                                        int i61 = i45 + 1;
                                        byteBuf2.setByte(i12 + i45, (byte) (((long) (i26 << 5)) + (j11 >>> 8)));
                                        i27 = i45 + 2;
                                        byteBuf2.setByte(i61 + i12, (byte) (j11 & 255));
                                    } else {
                                        byteBuf2.setByte(i12 + i45, (byte) ((j11 >>> 8) + 224));
                                        int i62 = i45 + 2;
                                        byteBuf2.setByte(i45 + 1 + i12, (byte) (i26 - 7));
                                        i27 = i45 + 3;
                                        byteBuf2.setByte(i12 + i62, (byte) (j11 & 255));
                                    }
                                } else if (j11 < 8191) {
                                    iArr = iArr2;
                                    if (i26 < 7) {
                                        long j13 = j10 - 8192;
                                        byteBuf2.setByte(i12 + i45, (byte) ((i26 << 5) + 31));
                                        byteBuf2.setByte(i45 + 1 + i12, -1);
                                        int i63 = i45 + 3;
                                        byteBuf2.setByte(i45 + 2 + i12, (byte) (j13 >>> 8));
                                        i27 = i45 + 4;
                                        byteBuf2.setByte(i63 + i12, (byte) (j13 & 255));
                                    } else {
                                        long j14 = j10 - 8192;
                                        i28 = i45 + 1;
                                        byteBuf2.setByte(i12 + i45, -1);
                                        i29 = i26 - 7;
                                        while (i29 >= 255) {
                                            byteBuf2.setByte(i28 + i12, -1);
                                            i29 -= 255;
                                            i28++;
                                        }
                                        byteBuf2.setByte(i12 + i28, (byte) i29);
                                        byteBuf2.setByte(i28 + 1 + i12, -1);
                                        byteBuf2.setByte(i28 + 2 + i12, (byte) (j14 >>> 8));
                                        i27 = i28 + 4;
                                        byteBuf2.setByte(i12 + i28 + 3, (byte) (j14 & 255));
                                    }
                                } else if (i26 < 7) {
                                    int i64 = i45 + 1;
                                    iArr = iArr2;
                                    byteBuf2.setByte(i12 + i45, (byte) (((long) (i26 << 5)) + (j11 >>> 8)));
                                    i27 = i45 + 2;
                                    byteBuf2.setByte(i12 + i64, (byte) (j11 & 255));
                                } else {
                                    iArr = iArr2;
                                    i30 = i45 + 1;
                                    byteBuf2.setByte(i12 + i45, (byte) ((j11 >>> 8) + 224));
                                    i31 = i26 - 7;
                                    while (i31 >= 255) {
                                        byteBuf2.setByte(i30 + i12, -1);
                                        i31 -= 255;
                                        i30++;
                                    }
                                    byteBuf2.setByte(i12 + i30, (byte) i31);
                                    i27 = i30 + 2;
                                    byteBuf2.setByte(i30 + 1 + i12, (byte) (j11 & 255));
                                }
                                int i65 = i19 - 2;
                                iArr[hashFunction(byteBuf, i10 + i59)] = i59;
                                i43 = i19 - 1;
                                iArr[hashFunction(byteBuf, i10 + i65)] = i65;
                                byteBuf2.setByte(i12 + i27, 31);
                                i45 = i27 + 1;
                                i37 = i20;
                                iArr2 = iArr;
                                i38 = i17;
                                i35 = 2;
                                z12 = true;
                                i44 = 0;
                            }
                        } else {
                            i33 = i45 + 1;
                            i34 = i43 + 1;
                            byteBuf2.setByte(i12 + i45, byteBuf.getByte(i10 + i43));
                            i44++;
                            if (i44 == 32) {
                                i45 += 2;
                                c11 = c.f14922b;
                                byteBuf2.setByte(i33 + i12, 31);
                                i43 = i34;
                                i37 = i16;
                                i38 = i17;
                                i35 = 2;
                                z12 = true;
                                i44 = 0;
                            } else {
                                i45 = i33;
                                i43 = i34;
                                i37 = i16;
                                i38 = i17;
                                i35 = 2;
                                z12 = true;
                            }
                        }
                    } else {
                        i33 = i45 + 1;
                        i34 = i43 + 1;
                        byteBuf2.setByte(i12 + i45, byteBuf.getByte(i10 + i43));
                        i44++;
                        if (i44 == 32) {
                            i45 += 2;
                            c11 = c.f14922b;
                            byteBuf2.setByte(i33 + i12, 31);
                            i43 = i34;
                            i37 = i16;
                            i38 = i17;
                            i35 = 2;
                            z12 = true;
                            i44 = 0;
                        } else {
                            i45 = i33;
                            i43 = i34;
                            i37 = i16;
                            i38 = i17;
                            i35 = 2;
                            z12 = true;
                        }
                    }
                }
            }
            i18 = 3;
            i19 = i18 + i43;
            j11 = j10 - 1;
            c10 = '\b';
            if (j11 == 0) {
                b10 = byteBuf.getByte((i10 + i19) - 1);
                i20 = i16;
                while (i19 < i20) {
                    i32 = i15 + 1;
                    if (byteBuf.getByte(i10 + i15) != b10) {
                        break;
                        break;
                    }
                    i19++;
                    i15 = i32;
                }
            } else {
                i20 = i16;
                i21 = 0;
                while (true) {
                    if (i21 < 8) {
                        z11 = false;
                        break;
                    }
                    i24 = i15 + 1;
                    i25 = i19 + 1;
                    if (byteBuf.getByte(i10 + i15) != byteBuf.getByte(i10 + i19)) {
                        i15 = i24;
                        i19 = i25;
                        z11 = true;
                        break;
                    }
                    i21++;
                    i15 = i24;
                    i19 = i25;
                }
                if (!z11) {
                    while (i19 < i20) {
                        i22 = i15 + 1;
                        i23 = i19 + 1;
                        if (byteBuf.getByte(i10 + i15) != byteBuf.getByte(i10 + i19)) {
                            i19 = i23;
                            break;
                        }
                        i15 = i22;
                        i19 = i23;
                    }
                }
            }
            if (i44 != 0) {
                byteBuf2.setByte(((i12 + i45) - i44) - 1, (byte) (i44 - 1));
            } else {
                i45--;
            }
            int i510 = i19 - 3;
            i26 = i510 - i43;
            if (i36 == 2) {
                iArr = iArr2;
                if (i26 > 262) {
                    while (i26 > 262) {
                        byteBuf2.setByte(i12 + i45, (byte) ((j11 >>> c10) + 224));
                        int i66 = i45 + 2;
                        byteBuf2.setByte(i12 + i45 + 1, -3);
                        i45 += 3;
                        byteBuf2.setByte(i66 + i12, (byte) (j11 & 255));
                        i26 -= 262;
                        c10 = '\b';
                    }
                }
                if (i26 < 7) {
                    int i67 = i45 + 1;
                    byteBuf2.setByte(i12 + i45, (byte) (((long) (i26 << 5)) + (j11 >>> 8)));
                    i27 = i45 + 2;
                    byteBuf2.setByte(i67 + i12, (byte) (j11 & 255));
                } else {
                    byteBuf2.setByte(i12 + i45, (byte) ((j11 >>> 8) + 224));
                    int i68 = i45 + 2;
                    byteBuf2.setByte(i45 + 1 + i12, (byte) (i26 - 7));
                    i27 = i45 + 3;
                    byteBuf2.setByte(i12 + i68, (byte) (j11 & 255));
                }
            } else if (j11 < 8191) {
                iArr = iArr2;
                if (i26 < 7) {
                    long j15 = j10 - 8192;
                    byteBuf2.setByte(i12 + i45, (byte) ((i26 << 5) + 31));
                    byteBuf2.setByte(i45 + 1 + i12, -1);
                    int i69 = i45 + 3;
                    byteBuf2.setByte(i45 + 2 + i12, (byte) (j15 >>> 8));
                    i27 = i45 + 4;
                    byteBuf2.setByte(i69 + i12, (byte) (j15 & 255));
                } else {
                    long j16 = j10 - 8192;
                    i28 = i45 + 1;
                    byteBuf2.setByte(i12 + i45, -1);
                    i29 = i26 - 7;
                    while (i29 >= 255) {
                        byteBuf2.setByte(i28 + i12, -1);
                        i29 -= 255;
                        i28++;
                    }
                    byteBuf2.setByte(i12 + i28, (byte) i29);
                    byteBuf2.setByte(i28 + 1 + i12, -1);
                    byteBuf2.setByte(i28 + 2 + i12, (byte) (j16 >>> 8));
                    i27 = i28 + 4;
                    byteBuf2.setByte(i12 + i28 + 3, (byte) (j16 & 255));
                }
            } else if (i26 < 7) {
                int i610 = i45 + 1;
                iArr = iArr2;
                byteBuf2.setByte(i12 + i45, (byte) (((long) (i26 << 5)) + (j11 >>> 8)));
                i27 = i45 + 2;
                byteBuf2.setByte(i12 + i610, (byte) (j11 & 255));
            } else {
                iArr = iArr2;
                i30 = i45 + 1;
                byteBuf2.setByte(i12 + i45, (byte) ((j11 >>> 8) + 224));
                i31 = i26 - 7;
                while (i31 >= 255) {
                    byteBuf2.setByte(i30 + i12, -1);
                    i31 -= 255;
                    i30++;
                }
                byteBuf2.setByte(i12 + i30, (byte) i31);
                i27 = i30 + 2;
                byteBuf2.setByte(i30 + 1 + i12, (byte) (j11 & 255));
            }
            int i611 = i19 - 2;
            iArr[hashFunction(byteBuf, i10 + i510)] = i510;
            i43 = i19 - 1;
            iArr[hashFunction(byteBuf, i10 + i611)] = i611;
            byteBuf2.setByte(i12 + i27, 31);
            i45 = i27 + 1;
            i37 = i20;
            iArr2 = iArr;
            i38 = i17;
            i35 = 2;
            z12 = true;
            i44 = 0;
        }
        int i70 = i11 - 1;
        while (i43 <= i70) {
            int i71 = i45 + 1;
            i43++;
            byteBuf2.setByte(i12 + i45, byteBuf.getByte(i10 + i43));
            i44++;
            if (i44 == 32) {
                i45 += 2;
                byteBuf2.setByte(i71 + i12, 31);
                i44 = 0;
            } else {
                i45 = i71;
            }
        }
        if (i44 != 0) {
            byteBuf2.setByte(((i12 + i45) - i44) - 1, (byte) (i44 - 1));
        } else {
            i45--;
        }
        if (i36 == 2) {
            byteBuf2.setByte(i12, byteBuf2.getByte(i12) | 32);
        }
        return i45;
    }

    public static int decompress(ByteBuf byteBuf, int i10, int i11, ByteBuf byteBuf2, int i12, int i13) {
        boolean z10;
        int i14;
        long unsignedByte;
        int i15;
        int unsignedByte2;
        int i16;
        char c10 = 5;
        boolean z11 = true;
        int i17 = (byteBuf.getByte(i10) >> 5) + 1;
        if (i17 != 1 && i17 != 2) {
            throw new DecompressionException(String.format("invalid level: %d (expected: %d or %d)", Integer.valueOf(i17), 1, 2));
        }
        long unsignedByte3 = byteBuf.getByte(i10) & c1.c.I;
        int i18 = 1;
        boolean z12 = true;
        int i19 = 0;
        while (true) {
            long j10 = unsignedByte3 >> c10;
            long j11 = (31 & unsignedByte3) << 8;
            if (unsignedByte3 >= 32) {
                long unsignedByte4 = j10 - 1;
                long j12 = i19;
                int i20 = i19;
                int i21 = (int) (j12 - j11);
                boolean z13 = z12;
                if (unsignedByte4 != 6) {
                    unsignedByte = unsignedByte3;
                } else if (i17 == 1) {
                    unsignedByte4 += (long) byteBuf.getUnsignedByte(i10 + i18);
                    i18++;
                    unsignedByte = unsignedByte3;
                } else {
                    while (true) {
                        i16 = i18 + 1;
                        short unsignedByte5 = byteBuf.getUnsignedByte(i10 + i18);
                        unsignedByte = unsignedByte3;
                        unsignedByte4 += (long) unsignedByte5;
                        if (unsignedByte5 != 255) {
                            break;
                        }
                        i18 = i16;
                        unsignedByte3 = unsignedByte;
                    }
                    i18 = i16;
                }
                if (i17 == 1) {
                    i15 = i18 + 1;
                    unsignedByte2 = i21 - byteBuf.getUnsignedByte(i10 + i18);
                } else {
                    i15 = i18 + 1;
                    short unsignedByte6 = byteBuf.getUnsignedByte(i10 + i18);
                    unsignedByte2 = i21 - unsignedByte6;
                    if (unsignedByte6 == 255 && j11 == 7936) {
                        long unsignedByte7 = byteBuf.getUnsignedByte(i10 + i15) << 8;
                        i15 = i18 + 3;
                        unsignedByte2 = (int) ((j12 - (unsignedByte7 + ((long) byteBuf.getUnsignedByte(i10 + (i18 + 2))))) - 8191);
                    }
                }
                if (j12 + unsignedByte4 + 3 > i13 || unsignedByte2 - 1 < 0) {
                    return 0;
                }
                if (i15 < i11) {
                    unsignedByte = byteBuf.getUnsignedByte(i10 + i15);
                    z12 = z13;
                    i15++;
                } else {
                    z12 = false;
                }
                if (unsignedByte2 == i20) {
                    z10 = true;
                    byte b10 = byteBuf2.getByte((i12 + unsignedByte2) - 1);
                    byteBuf2.setByte(i12 + i20, b10);
                    byteBuf2.setByte(i12 + i20 + 1, b10);
                    i14 = i20 + 3;
                    byteBuf2.setByte(i12 + i20 + 2, b10);
                    while (unsignedByte4 != 0) {
                        byteBuf2.setByte(i12 + i14, b10);
                        unsignedByte4--;
                        i14++;
                    }
                } else {
                    z10 = true;
                    byteBuf2.setByte(i12 + i20, byteBuf2.getByte(i12 + (unsignedByte2 - 1)));
                    int i22 = unsignedByte2 + 1;
                    byteBuf2.setByte(i12 + i20 + 1, byteBuf2.getByte(i12 + unsignedByte2));
                    i14 = i20 + 3;
                    int i23 = unsignedByte2 + 2;
                    byteBuf2.setByte(i12 + i20 + 2, byteBuf2.getByte(i12 + i22));
                    while (unsignedByte4 != 0) {
                        byteBuf2.setByte(i12 + i14, byteBuf2.getByte(i12 + i23));
                        unsignedByte4--;
                        i14++;
                        i23++;
                    }
                }
                i18 = i15;
                unsignedByte3 = unsignedByte;
            } else {
                long j13 = unsignedByte3;
                int i24 = i19;
                z10 = z11;
                long j14 = j13 + 1;
                if (((long) i24) + j14 > i13 || ((long) i18) + j14 > i11) {
                    return 0;
                }
                byteBuf2.setByte(i12 + i24, byteBuf.getByte(i10 + i18));
                i14 = i24 + 1;
                int i25 = i18 + 1;
                unsignedByte3 = j13;
                while (unsignedByte3 != 0) {
                    byteBuf2.setByte(i12 + i14, byteBuf.getByte(i10 + i25));
                    unsignedByte3--;
                    i14++;
                    i25++;
                }
                boolean z14 = i25 < i11 ? z10 : false;
                if (z14) {
                    z12 = z14;
                    i18 = i25 + 1;
                    unsignedByte3 = byteBuf.getUnsignedByte(i10 + i25);
                } else {
                    z12 = z14;
                    i18 = i25;
                }
            }
            if (!z12) {
                return i14;
            }
            z11 = z10;
            i19 = i14;
            c10 = 5;
        }
    }

    private static int hashFunction(ByteBuf byteBuf, int i10) {
        int u16 = readU16(byteBuf, i10);
        return ((readU16(byteBuf, i10 + 1) ^ (u16 >> 3)) ^ u16) & 8191;
    }

    private static int readU16(ByteBuf byteBuf, int i10) {
        int i11 = i10 + 1;
        if (i11 >= byteBuf.readableBytes()) {
            return byteBuf.getUnsignedByte(i10);
        }
        return byteBuf.getUnsignedByte(i10) | (byteBuf.getUnsignedByte(i11) << 8);
    }
}
