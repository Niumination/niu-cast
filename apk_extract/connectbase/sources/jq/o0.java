package jq;

import lm.a2;
import lm.f1;
import lm.g2;
import lm.o2;
import lm.p2;
import lm.s1;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "UStringsKt")
public final class o0 {
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final String a(long j10, int i10) {
        return o2.l(j10, d.a(i10));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final String b(byte b10, int i10) {
        String string = Integer.toString(b10 & 255, d.a(i10));
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final String c(int i10, int i11) {
        String string = Long.toString(((long) i10) & 4294967295L, d.a(i11));
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final String d(short s10, int i10) {
        String string = Integer.toString(s10 & g2.f10190d, d.a(i10));
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final byte e(@os.l String str) {
        kn.l0.p(str, "<this>");
        s1 s1VarG = g(str);
        if (s1VarG != null) {
            return s1VarG.f10218a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final byte f(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        s1 s1VarH = h(str, i10);
        if (s1VarH != null) {
            return s1VarH.f10218a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final s1 g(@os.l String str) {
        kn.l0.p(str, "<this>");
        return h(str, 10);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final s1 h(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        w1 w1VarL = l(str, i10);
        if (w1VarL == null) {
            return null;
        }
        int i11 = w1VarL.f10227a;
        if (Integer.compareUnsigned(i11, 255) > 0) {
            return null;
        }
        return new s1(s1.m((byte) i11));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final int i(@os.l String str) {
        kn.l0.p(str, "<this>");
        w1 w1VarK = k(str);
        if (w1VarK != null) {
            return w1VarK.f10227a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final int j(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        w1 w1VarL = l(str, i10);
        if (w1VarL != null) {
            return w1VarL.f10227a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final w1 k(@os.l String str) {
        kn.l0.p(str, "<this>");
        return l(str, 10);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final w1 l(@os.l String str, int i10) {
        int i11;
        kn.l0.p(str, "<this>");
        d.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char cCharAt = str.charAt(0);
        if (kn.l0.t(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i11 = 0;
        }
        int iM = w1.m(i10);
        int iDivideUnsigned = 119304647;
        while (i11 < length) {
            int iDigit = Character.digit((int) str.charAt(i11), i10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i12, iDivideUnsigned) > 0) {
                if (iDivideUnsigned == 119304647) {
                    iDivideUnsigned = Integer.divideUnsigned(-1, iM);
                    if (Integer.compareUnsigned(i12, iDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            int i13 = i12 * iM;
            int i14 = iDigit + i13;
            if (Integer.compareUnsigned(i14, i13) < 0) {
                return null;
            }
            i11++;
            i12 = i14;
        }
        return new w1(i12);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final long m(@os.l String str) {
        kn.l0.p(str, "<this>");
        a2 a2VarO = o(str);
        if (a2VarO != null) {
            return a2VarO.f10177a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final long n(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        a2 a2VarP = p(str, i10);
        if (a2VarP != null) {
            return a2VarP.f10177a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final a2 o(@os.l String str) {
        kn.l0.p(str, "<this>");
        return p(str, 10);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final a2 p(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        d.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        if (kn.l0.t(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jM = a2.m(i10);
        long j10 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i11 < length) {
            int iDigit = Character.digit((int) str.charAt(i11), i10);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j10, jDivideUnsigned) > 0) {
                if (jDivideUnsigned == 512409557603043100L) {
                    jDivideUnsigned = Long.divideUnsigned(-1L, jM);
                    if (Long.compareUnsigned(j10, jDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            long j11 = j10 * jM;
            long jM2 = (((long) w1.m(iDigit)) & 4294967295L) + j11;
            if (Long.compareUnsigned(jM2, j11) < 0) {
                return null;
            }
            i11++;
            j10 = jM2;
        }
        return new a2(j10);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final short q(@os.l String str) {
        kn.l0.p(str, "<this>");
        g2 g2VarS = s(str);
        if (g2VarS != null) {
            return g2VarS.f10193a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final short r(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        g2 g2VarT = t(str, i10);
        if (g2VarT != null) {
            return g2VarT.f10193a;
        }
        d0.U0(str);
        throw new lm.y();
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final g2 s(@os.l String str) {
        kn.l0.p(str, "<this>");
        return t(str, 10);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final g2 t(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        w1 w1VarL = l(str, i10);
        if (w1VarL == null) {
            return null;
        }
        int i11 = w1VarL.f10227a;
        if (Integer.compareUnsigned(i11, 65535) > 0) {
            return null;
        }
        return new g2(g2.m((short) i11));
    }
}
