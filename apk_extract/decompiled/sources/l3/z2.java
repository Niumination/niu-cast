package l3;

/* JADX INFO: loaded from: classes.dex */
public abstract class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7333a;

    static {
        if (x2.e && x2.f7323d) {
            int i8 = s.f7291a;
        }
        f7333a = new c();
    }

    public static int a(byte[] bArr, int i8, int i9) {
        int i10 = i9 - i8;
        byte b9 = bArr[i8 - 1];
        if (i10 != 0) {
            if (i10 == 1) {
                return e(b9, bArr[i8]);
            }
            if (i10 != 2) {
                throw new AssertionError();
            }
            byte b10 = bArr[i8];
            byte b11 = bArr[i8 + 1];
            if (b9 <= -12 && b10 <= -65 && b11 <= -65) {
                return (b11 << 16) ^ ((b10 << 8) ^ b9);
            }
        } else if (b9 <= -12) {
            return b9;
        }
        return -1;
    }

    public static int b(String str, int i8, int i9, byte[] bArr) {
        int i10;
        int i11;
        int i12;
        char cCharAt;
        int length = str.length();
        int i13 = 0;
        while (true) {
            i10 = i8 + i9;
            if (i13 >= length || (i12 = i13 + i8) >= i10 || (cCharAt = str.charAt(i13)) >= 128) {
                break;
            }
            bArr[i12] = (byte) cCharAt;
            i13++;
        }
        if (i13 == length) {
            return i8 + length;
        }
        int i14 = i8 + i13;
        while (i13 < length) {
            char cCharAt2 = str.charAt(i13);
            if (cCharAt2 < 128 && i14 < i10) {
                bArr[i14] = (byte) cCharAt2;
                i14++;
            } else if (cCharAt2 < 2048 && i14 <= i10 - 2) {
                int i15 = i14 + 1;
                bArr[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                i14 += 2;
                bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i14 > i10 - 3) {
                    if (i14 > i10 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i11 = i13 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i11)))) {
                            throw new y2(i13, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i14);
                    }
                    int i16 = i13 + 1;
                    if (i16 != str.length()) {
                        char cCharAt3 = str.charAt(i16);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i14] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i14 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i17 = i14 + 3;
                            bArr[i14 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i14 += 4;
                            bArr[i17] = (byte) ((codePoint & 63) | 128);
                            i13 = i16;
                        } else {
                            i13 = i16;
                        }
                    }
                    throw new y2(i13 - 1, length);
                }
                bArr[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i18 = i14 + 2;
                bArr[i14 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i14 += 3;
                bArr[i18] = (byte) ((cCharAt2 & '?') | 128);
            }
            i13++;
        }
        return i14;
    }

    public static int c(String str) {
        int length = str.length();
        int i8 = 0;
        int i9 = 0;
        while (i9 < length && str.charAt(i9) < 128) {
            i9++;
        }
        int i10 = length;
        while (i9 < length) {
            char cCharAt = str.charAt(i9);
            if (cCharAt >= 2048) {
                int length2 = str.length();
                while (i9 < length2) {
                    char cCharAt2 = str.charAt(i9);
                    if (cCharAt2 < 2048) {
                        i8 += (127 - cCharAt2) >>> 31;
                    } else {
                        i8 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i9) < 65536) {
                                throw new y2(i9, length2);
                            }
                            i9++;
                        }
                    }
                    i9++;
                }
                i10 += i8;
                break;
            }
            i10 += (127 - cCharAt) >>> 31;
            i9++;
        }
        if (i10 >= length) {
            return i10;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i10) + 4294967296L));
    }

    public static boolean d(byte[] bArr, int i8, int i9) {
        f7333a.getClass();
        return c.a(0, bArr, i8, i9) == 0;
    }

    public static int e(int i8, int i9) {
        if (i8 > -12 || i9 > -65) {
            return -1;
        }
        return i8 ^ (i9 << 8);
    }
}
