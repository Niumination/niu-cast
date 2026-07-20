package jq;

import kn.r1;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,344:1\n1#2:345\n*E\n"})
public class e extends d {
    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    public static final char D(int i10) {
        if (new tn.l(0, 9, 1).l(i10)) {
            return (char) (i10 + 48);
        }
        throw new IllegalArgumentException(k.b.a("Int ", i10, " is not a decimal digit"));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    public static final char E(int i10, int i11) {
        if (!new tn.l(2, 36, 1).l(i11)) {
            throw new IllegalArgumentException(k.b.a("Invalid radix: ", i11, ". Valid radix values are in range 2..36"));
        }
        if (i10 < 0 || i10 >= i11) {
            throw new IllegalArgumentException(e0.a.a("Digit ", i10, " does not represent a valid digit in radix ", i11));
        }
        return (char) (i10 < 10 ? i10 + 48 : ((char) (i10 + 65)) - '\n');
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    public static final int F(char c10) {
        int iDigit = Character.digit((int) c10, 10);
        if (iDigit >= 0) {
            return iDigit;
        }
        throw new IllegalArgumentException("Char " + c10 + " is not a decimal digit");
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    public static final int G(char c10, int i10) {
        Integer numI = I(c10, i10);
        if (numI != null) {
            return numI.intValue();
        }
        throw new IllegalArgumentException("Char " + c10 + " is not a digit in the given radix=" + i10);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    public static final Integer H(char c10) {
        Integer numValueOf = Integer.valueOf(Character.digit((int) c10, 10));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    public static final Integer I(char c10, int i10) {
        d.a(i10);
        Integer numValueOf = Integer.valueOf(Character.digit((int) c10, i10));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    public static final boolean J(char c10, char c11, boolean z10) {
        if (c10 == c11) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c10);
        char upperCase2 = Character.toUpperCase(c11);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static /* synthetic */ boolean K(char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return J(c10, c11, z10);
    }

    public static boolean L(char c10) {
        return new tn.c((char) 55296, (char) 57343, 1).l(c10);
    }

    @an.f
    public static final String M(char c10, String str) {
        kn.l0.p(str, "other");
        return c10 + str;
    }

    @f1(version = "1.5")
    @os.l
    public static final String N(char c10) {
        return p0.a(c10);
    }
}
