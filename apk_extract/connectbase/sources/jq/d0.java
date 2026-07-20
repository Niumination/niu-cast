package jq;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public class d0 extends c0 {
    @os.l
    public static final Void U0(@os.l String str) {
        kn.l0.p(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    @os.m
    @f1(version = "1.1")
    public static final Byte V0(@os.l String str) {
        kn.l0.p(str, "<this>");
        return W0(str, 10);
    }

    @os.m
    @f1(version = "1.1")
    public static final Byte W0(@os.l String str, int i10) {
        int iIntValue;
        kn.l0.p(str, "<this>");
        Integer numY0 = Y0(str, i10);
        if (numY0 == null || (iIntValue = numY0.intValue()) < -128 || iIntValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) iIntValue);
    }

    @os.m
    @f1(version = "1.1")
    public static Integer X0(@os.l String str) {
        kn.l0.p(str, "<this>");
        return Y0(str, 10);
    }

    @os.m
    @f1(version = "1.1")
    public static final Integer Y0(@os.l String str, int i10) {
        boolean z10;
        int i11;
        int i12;
        kn.l0.p(str, "<this>");
        d.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char cCharAt = str.charAt(0);
        int i14 = -2147483647;
        if (kn.l0.t(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i14 = Integer.MIN_VALUE;
                z10 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z10 = false;
            }
        } else {
            z10 = false;
            i11 = 0;
        }
        int i15 = -59652323;
        while (i11 < length) {
            int iDigit = Character.digit((int) str.charAt(i11), i10);
            if (iDigit < 0) {
                return null;
            }
            if ((i13 < i15 && (i15 != -59652323 || i13 < (i15 = i14 / i10))) || (i12 = i13 * i10) < i14 + iDigit) {
                return null;
            }
            i13 = i12 - iDigit;
            i11++;
        }
        return z10 ? Integer.valueOf(i13) : Integer.valueOf(-i13);
    }

    @os.m
    @f1(version = "1.1")
    public static Long Z0(@os.l String str) {
        kn.l0.p(str, "<this>");
        return a1(str, 10);
    }

    @os.m
    @f1(version = "1.1")
    public static final Long a1(@os.l String str, int i10) {
        boolean z10;
        kn.l0.p(str, "<this>");
        d.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        long j10 = -9223372036854775807L;
        if (kn.l0.t(cCharAt, 48) < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j10 = Long.MIN_VALUE;
                i11 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z10 = false;
                i11 = 1;
            }
        } else {
            z10 = false;
        }
        long j11 = -256204778801521550L;
        long j12 = 0;
        long j13 = -256204778801521550L;
        while (i11 < length) {
            int iDigit = Character.digit((int) str.charAt(i11), i10);
            if (iDigit < 0) {
                return null;
            }
            if (j12 < j13) {
                if (j13 == j11) {
                    j13 = j10 / ((long) i10);
                    if (j12 < j13) {
                    }
                }
                return null;
            }
            long j14 = j12 * ((long) i10);
            long j15 = iDigit;
            if (j14 < j10 + j15) {
                return null;
            }
            j12 = j14 - j15;
            i11++;
            j11 = -256204778801521550L;
        }
        return z10 ? Long.valueOf(j12) : Long.valueOf(-j12);
    }

    @os.m
    @f1(version = "1.1")
    public static final Short b1(@os.l String str) {
        kn.l0.p(str, "<this>");
        return c1(str, 10);
    }

    @os.m
    @f1(version = "1.1")
    public static final Short c1(@os.l String str, int i10) {
        int iIntValue;
        kn.l0.p(str, "<this>");
        Integer numY0 = Y0(str, i10);
        if (numY0 == null || (iIntValue = numY0.intValue()) < -32768 || iIntValue > 32767) {
            return null;
        }
        return Short.valueOf((short) iIntValue);
    }
}
