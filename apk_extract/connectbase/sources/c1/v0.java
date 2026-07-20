package c1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@k
public final class v0 {
    public static int a(CharSequence sequence) {
        int length = sequence.length();
        int i10 = 0;
        while (i10 < length && sequence.charAt(i10) < 128) {
            i10++;
        }
        int iB = length;
        while (i10 < length) {
            char cCharAt = sequence.charAt(i10);
            if (cCharAt >= 2048) {
                iB += b(sequence, i10);
                break;
            }
            iB += (127 - cCharAt) >>> 31;
            i10++;
        }
        if (iB >= length) {
            return iB;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iB) + 4294967296L));
    }

    public static int b(CharSequence sequence, int start) {
        int length = sequence.length();
        int i10 = 0;
        while (start < length) {
            char cCharAt = sequence.charAt(start);
            if (cCharAt < 2048) {
                i10 += (127 - cCharAt) >>> 31;
            } else {
                i10 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(sequence, start) == cCharAt) {
                        throw new IllegalArgumentException(f(start));
                    }
                    start++;
                }
            }
            start++;
        }
        return i10;
    }

    public static boolean c(byte[] bytes) {
        return d(bytes, 0, bytes.length);
    }

    public static boolean d(byte[] bytes, int off, int len) {
        int i10 = len + off;
        h0.f0(off, i10, bytes.length);
        while (off < i10) {
            if (bytes[off] < 0) {
                return e(bytes, off, i10);
            }
            off++;
        }
        return true;
    }

    public static boolean e(byte[] bytes, int off, int end) {
        byte b10;
        while (off < end) {
            int i10 = off + 1;
            byte b11 = bytes[off];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i10 != end && b11 >= -62) {
                        off += 2;
                        if (bytes[i10] > -65) {
                        }
                    }
                    return false;
                }
                if (b11 < -16) {
                    int i11 = off + 2;
                    if (i11 < end && (b10 = bytes[i10]) <= -65 && ((b11 != -32 || b10 >= -96) && (b11 != -19 || -96 > b10))) {
                        off += 3;
                        if (bytes[i11] > -65) {
                        }
                    }
                    return false;
                }
                if (off + 3 >= end) {
                    return false;
                }
                int i12 = off + 2;
                byte b12 = bytes[i10];
                if (b12 <= -65) {
                    if ((((b12 + 112) + (b11 << c.F)) >> 30) == 0) {
                        int i13 = off + 3;
                        if (bytes[i12] <= -65) {
                            off += 4;
                            if (bytes[i13] > -65) {
                            }
                        }
                    }
                }
                return false;
            }
            off = i10;
        }
        return true;
    }

    public static String f(int i10) {
        return h.a.a("Unpaired surrogate at index ", i10);
    }
}
