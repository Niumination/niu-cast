package l3;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i2 f7259a = new i2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j2 f7260b = new j2();

    public static int a(byte[] bArr, int i8, t tVar) throws b1 {
        int iN = n(bArr, i8, tVar);
        int i9 = tVar.f7294a;
        if (i9 < 0) {
            throw b1.zzd();
        }
        if (i9 > bArr.length - iN) {
            throw b1.zzg();
        }
        if (i9 == 0) {
            tVar.f7296c = b0.zzb;
            return iN;
        }
        tVar.f7296c = b0.zzr(bArr, iN, i9);
        return iN + i9;
    }

    public static String b(b0 b0Var) {
        StringBuilder sb2 = new StringBuilder(b0Var.zzd());
        for (int i8 = 0; i8 < b0Var.zzd(); i8++) {
            byte bZza = b0Var.zza(i8);
            if (bZza == 34) {
                sb2.append("\\\"");
            } else if (bZza == 39) {
                sb2.append("\\'");
            } else if (bZza != 92) {
                switch (bZza) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bZza < 32 || bZza > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bZza >>> 6) & 3) + 48));
                            sb2.append((char) (((bZza >>> 3) & 7) + 48));
                            sb2.append((char) ((bZza & 7) + 48));
                        } else {
                            sb2.append((char) bZza);
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static int c(int i8) {
        return (i8 >>> 1) ^ (-(i8 & 1));
    }

    public static int d(int i8, byte[] bArr) {
        int i9 = bArr[i8] & UByte.MAX_VALUE;
        int i10 = bArr[i8 + 1] & UByte.MAX_VALUE;
        int i11 = bArr[i8 + 2] & UByte.MAX_VALUE;
        return ((bArr[i8 + 3] & UByte.MAX_VALUE) << 24) | (i10 << 8) | i9 | (i11 << 16);
    }

    public static int e(f2 f2Var, byte[] bArr, int i8, int i9, int i10, t tVar) {
        Object objA = f2Var.a();
        int iR = r(objA, f2Var, bArr, i8, i9, i10, tVar);
        f2Var.b(objA);
        tVar.f7296c = objA;
        return iR;
    }

    public static long f(long j8) {
        return (j8 >>> 1) ^ (-(1 & j8));
    }

    public static int g(f2 f2Var, byte[] bArr, int i8, int i9, t tVar) throws b1 {
        Object objA = f2Var.a();
        int iS = s(objA, f2Var, bArr, i8, i9, tVar);
        f2Var.b(objA);
        tVar.f7296c = objA;
        return iS;
    }

    public static int h(f2 f2Var, int i8, byte[] bArr, int i9, int i10, y0 y0Var, t tVar) throws b1 {
        int iG = g(f2Var, bArr, i9, i10, tVar);
        y0Var.add(tVar.f7296c);
        while (iG < i10) {
            int iN = n(bArr, iG, tVar);
            if (i8 != tVar.f7294a) {
                break;
            }
            iG = g(f2Var, bArr, iN, i10, tVar);
            y0Var.add(tVar.f7296c);
        }
        return iG;
    }

    public static boolean i(byte b9) {
        return b9 > -65;
    }

    public static int j(byte[] bArr, int i8, y0 y0Var, t tVar) throws b1 {
        r0 r0Var = (r0) y0Var;
        int iN = n(bArr, i8, tVar);
        int i9 = tVar.f7294a + iN;
        while (iN < i9) {
            iN = n(bArr, iN, tVar);
            r0Var.g(tVar.f7294a);
        }
        if (iN == i9) {
            return iN;
        }
        throw b1.zzg();
    }

    public static int k(byte[] bArr, int i8, t tVar) throws b1 {
        int iN = n(bArr, i8, tVar);
        int i9 = tVar.f7294a;
        if (i9 < 0) {
            throw b1.zzd();
        }
        if (i9 == 0) {
            tVar.f7296c = "";
            return iN;
        }
        tVar.f7296c = new String(bArr, iN, i9, z0.f7328a);
        return iN + i9;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x009e  */
    /* JADX WARN: Code duplicated, block: B:48:0x009f A[PHI: r5
      0x009f: PHI (r5v6 byte) = (r5v5 byte), (r5v9 byte) binds: [B:45:0x009a, B:47:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00b7 A[SYNTHETIC] */
    public static int l(byte[] bArr, int i8, t tVar) throws b1 {
        int iN = n(bArr, i8, tVar);
        int i9 = tVar.f7294a;
        if (i9 < 0) {
            throw b1.zzd();
        }
        if (i9 == 0) {
            tVar.f7296c = "";
            return iN;
        }
        int length = bArr.length;
        c cVar = z2.f7333a;
        if ((iN | i9 | ((length - iN) - i9)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iN), Integer.valueOf(i9)));
        }
        int i10 = iN + i9;
        char[] cArr = new char[i9];
        int i11 = 0;
        while (iN < i10) {
            byte b9 = bArr[iN];
            if (b9 < 0) {
                break;
            }
            iN++;
            cArr[i11] = (char) b9;
            i11++;
        }
        while (iN < i10) {
            int i12 = iN + 1;
            byte b10 = bArr[iN];
            if (b10 >= 0) {
                cArr[i11] = (char) b10;
                i11++;
                iN = i12;
                while (iN < i10) {
                    byte b11 = bArr[iN];
                    if (b11 < 0) {
                        break;
                    }
                    iN++;
                    cArr[i11] = (char) b11;
                    i11++;
                }
            } else {
                if (b10 >= -32) {
                    if (b10 >= -16) {
                        if (i12 >= i10 - 2) {
                            throw b1.zzc();
                        }
                        byte b12 = bArr[i12];
                        int i13 = iN + 3;
                        byte b13 = bArr[iN + 2];
                        iN += 4;
                        byte b14 = bArr[i13];
                        if (!i(b12)) {
                            if ((((b12 + 112) + (b10 << 28)) >> 30) == 0 && !i(b13) && !i(b14)) {
                                int i14 = ((b12 & 63) << 12) | ((b10 & 7) << 18) | ((b13 & 63) << 6) | (b14 & 63);
                                cArr[i11] = (char) ((i14 >>> 10) + 55232);
                                cArr[i11 + 1] = (char) ((i14 & 1023) + 56320);
                                i11 += 2;
                            }
                        }
                        throw b1.zzc();
                    }
                    if (i12 >= i10 - 1) {
                        throw b1.zzc();
                    }
                    int i15 = iN + 2;
                    byte b15 = bArr[i12];
                    iN += 3;
                    byte b16 = bArr[i15];
                    int i16 = i11 + 1;
                    if (!i(b15)) {
                        if (b10 != -32) {
                            if (b10 != -19) {
                                if (!i(b16)) {
                                    cArr[i11] = (char) (((b15 & 63) << 6) | ((b10 & 15) << 12) | (b16 & 63));
                                    i11 = i16;
                                }
                            } else if (b15 < -96) {
                                b10 = -19;
                                if (!i(b16)) {
                                    cArr[i11] = (char) (((b15 & 63) << 6) | ((b10 & 15) << 12) | (b16 & 63));
                                    i11 = i16;
                                }
                            }
                        } else if (b15 >= -96) {
                            b10 = -32;
                            if (b10 != -19) {
                                if (!i(b16)) {
                                    cArr[i11] = (char) (((b15 & 63) << 6) | ((b10 & 15) << 12) | (b16 & 63));
                                    i11 = i16;
                                }
                            } else if (b15 < -96) {
                                b10 = -19;
                                if (!i(b16)) {
                                    cArr[i11] = (char) (((b15 & 63) << 6) | ((b10 & 15) << 12) | (b16 & 63));
                                    i11 = i16;
                                }
                            }
                        }
                    }
                    throw b1.zzc();
                }
                if (i12 >= i10) {
                    throw b1.zzc();
                }
                iN += 2;
                byte b17 = bArr[i12];
                int i17 = i11 + 1;
                if (b10 < -62 || i(b17)) {
                    throw b1.zzc();
                }
                cArr[i11] = (char) ((b17 & 63) | ((b10 & 31) << 6));
                i11 = i17;
            }
        }
        tVar.f7296c = new String(cArr, 0, i11);
        return i10;
    }

    public static int m(int i8, byte[] bArr, int i9, int i10, o2 o2Var, t tVar) throws b1 {
        if ((i8 >>> 3) == 0) {
            throw b1.zzb();
        }
        int i11 = i8 & 7;
        if (i11 == 0) {
            int iQ = q(bArr, i9, tVar);
            o2Var.c(i8, Long.valueOf(tVar.f7295b));
            return iQ;
        }
        if (i11 == 1) {
            o2Var.c(i8, Long.valueOf(u(i9, bArr)));
            return i9 + 8;
        }
        if (i11 == 2) {
            int iN = n(bArr, i9, tVar);
            int i12 = tVar.f7294a;
            if (i12 < 0) {
                throw b1.zzd();
            }
            if (i12 > bArr.length - iN) {
                throw b1.zzg();
            }
            if (i12 == 0) {
                o2Var.c(i8, b0.zzb);
            } else {
                o2Var.c(i8, b0.zzr(bArr, iN, i12));
            }
            return iN + i12;
        }
        if (i11 != 3) {
            if (i11 != 5) {
                throw b1.zzb();
            }
            o2Var.c(i8, Integer.valueOf(d(i9, bArr)));
            return i9 + 4;
        }
        int i13 = (i8 & (-8)) | 4;
        o2 o2VarB = o2.b();
        int i14 = 0;
        while (i9 < i10) {
            int iN2 = n(bArr, i9, tVar);
            int i15 = tVar.f7294a;
            i14 = i15;
            if (i15 == i13) {
                i9 = iN2;
                break;
            }
            int iM = m(i14, bArr, iN2, i10, o2VarB, tVar);
            i14 = i15;
            i9 = iM;
        }
        if (i9 > i10 || i14 != i13) {
            throw b1.zze();
        }
        o2Var.c(i8, o2VarB);
        return i9;
    }

    public static int n(byte[] bArr, int i8, t tVar) {
        int i9 = i8 + 1;
        byte b9 = bArr[i8];
        if (b9 < 0) {
            return o(b9, bArr, i9, tVar);
        }
        tVar.f7294a = b9;
        return i9;
    }

    public static int o(int i8, byte[] bArr, int i9, t tVar) {
        byte b9 = bArr[i9];
        int i10 = i9 + 1;
        int i11 = i8 & 127;
        if (b9 >= 0) {
            tVar.f7294a = i11 | (b9 << 7);
            return i10;
        }
        int i12 = i11 | ((b9 & ByteCompanionObject.MAX_VALUE) << 7);
        int i13 = i9 + 2;
        byte b10 = bArr[i10];
        if (b10 >= 0) {
            tVar.f7294a = i12 | (b10 << 14);
            return i13;
        }
        int i14 = i12 | ((b10 & ByteCompanionObject.MAX_VALUE) << 14);
        int i15 = i9 + 3;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            tVar.f7294a = i14 | (b11 << 21);
            return i15;
        }
        int i16 = i14 | ((b11 & ByteCompanionObject.MAX_VALUE) << 21);
        int i17 = i9 + 4;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            tVar.f7294a = i16 | (b12 << 28);
            return i17;
        }
        int i18 = i16 | ((b12 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] >= 0) {
                tVar.f7294a = i18;
                return i19;
            }
            i17 = i19;
        }
    }

    public static int p(int i8, byte[] bArr, int i9, int i10, y0 y0Var, t tVar) {
        r0 r0Var = (r0) y0Var;
        int iN = n(bArr, i9, tVar);
        r0Var.g(tVar.f7294a);
        while (iN < i10) {
            int iN2 = n(bArr, iN, tVar);
            if (i8 != tVar.f7294a) {
                break;
            }
            iN = n(bArr, iN2, tVar);
            r0Var.g(tVar.f7294a);
        }
        return iN;
    }

    public static int q(byte[] bArr, int i8, t tVar) {
        long j8 = bArr[i8];
        int i9 = i8 + 1;
        if (j8 >= 0) {
            tVar.f7295b = j8;
            return i9;
        }
        int i10 = i8 + 2;
        byte b9 = bArr[i9];
        long j10 = (j8 & 127) | (((long) (b9 & ByteCompanionObject.MAX_VALUE)) << 7);
        int i11 = 7;
        while (b9 < 0) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            i11 += 7;
            j10 |= ((long) (b10 & ByteCompanionObject.MAX_VALUE)) << i11;
            b9 = b10;
            i10 = i12;
        }
        tVar.f7295b = j10;
        return i10;
    }

    public static int r(Object obj, f2 f2Var, byte[] bArr, int i8, int i9, int i10, t tVar) {
        int iA = ((t1) f2Var).A(obj, bArr, i8, i9, i10, tVar);
        tVar.f7296c = obj;
        return iA;
    }

    public static int s(Object obj, f2 f2Var, byte[] bArr, int i8, int i9, t tVar) throws b1 {
        int iO = i8 + 1;
        int i10 = bArr[i8];
        if (i10 < 0) {
            iO = o(i10, bArr, iO, tVar);
            i10 = tVar.f7294a;
        }
        int i11 = iO;
        if (i10 < 0 || i10 > i9 - i11) {
            throw b1.zzg();
        }
        int i12 = i10 + i11;
        f2Var.d(obj, bArr, i11, i12, tVar);
        tVar.f7296c = obj;
        return i12;
    }

    public static int t(int i8, byte[] bArr, int i9, int i10, t tVar) throws b1 {
        if ((i8 >>> 3) == 0) {
            throw b1.zzb();
        }
        int i11 = i8 & 7;
        if (i11 == 0) {
            return q(bArr, i9, tVar);
        }
        if (i11 == 1) {
            return i9 + 8;
        }
        if (i11 == 2) {
            return n(bArr, i9, tVar) + tVar.f7294a;
        }
        if (i11 != 3) {
            if (i11 == 5) {
                return i9 + 4;
            }
            throw b1.zzb();
        }
        int i12 = (i8 & (-8)) | 4;
        int i13 = 0;
        while (i9 < i10) {
            i9 = n(bArr, i9, tVar);
            i13 = tVar.f7294a;
            if (i13 == i12) {
                break;
            }
            i9 = t(i13, bArr, i9, i10, tVar);
        }
        if (i9 > i10 || i13 != i12) {
            throw b1.zze();
        }
        return i9;
    }

    public static long u(int i8, byte[] bArr) {
        return (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48) | ((((long) bArr[i8 + 7]) & 255) << 56);
    }
}
