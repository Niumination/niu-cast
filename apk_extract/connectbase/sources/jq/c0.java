package jq;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kn.r1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n1#1,274:1\n265#1,7:275\n265#1,7:282\n265#1,7:289\n265#1,7:296\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n142#1:275,7\n149#1:282,7\n229#1:289,7\n240#1:296,7\n*E\n"})
public class c0 extends b0 {
    @f1(version = "1.2")
    @an.f
    public static final BigInteger A0(String str, int i10) {
        kn.l0.p(str, "<this>");
        return new BigInteger(str, d.a(i10));
    }

    @os.m
    @f1(version = "1.2")
    public static final BigInteger B0(@os.l String str) {
        kn.l0.p(str, "<this>");
        return C0(str, 10);
    }

    @os.m
    @f1(version = "1.2")
    public static final BigInteger C0(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        d.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i11 = str.charAt(0) == '-' ? 1 : 0; i11 < length; i11++) {
                if (Character.digit((int) str.charAt(i11), i10) < 0) {
                    return null;
                }
            }
        } else if (Character.digit((int) str.charAt(0), i10) < 0) {
            return null;
        }
        return new BigInteger(str, d.a(i10));
    }

    @f1(version = "1.4")
    @an.f
    public static final boolean D0(String str) {
        return Boolean.parseBoolean(str);
    }

    @an.f
    public static final byte E0(String str) {
        kn.l0.p(str, "<this>");
        return Byte.parseByte(str);
    }

    @f1(version = "1.1")
    @an.f
    public static final byte F0(String str, int i10) {
        kn.l0.p(str, "<this>");
        return Byte.parseByte(str, d.a(i10));
    }

    @an.f
    public static final double G0(String str) {
        kn.l0.p(str, "<this>");
        return Double.parseDouble(str);
    }

    @os.m
    @f1(version = "1.1")
    public static Double H0(@os.l String str) {
        kn.l0.p(str, "<this>");
        try {
            if (u.f8899b.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @an.f
    public static final float I0(String str) {
        kn.l0.p(str, "<this>");
        return Float.parseFloat(str);
    }

    @os.m
    @f1(version = "1.1")
    public static final Float J0(@os.l String str) {
        kn.l0.p(str, "<this>");
        try {
            if (u.f8899b.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @an.f
    public static final int K0(String str) {
        kn.l0.p(str, "<this>");
        return Integer.parseInt(str);
    }

    @f1(version = "1.1")
    @an.f
    public static final int L0(String str, int i10) {
        kn.l0.p(str, "<this>");
        return Integer.parseInt(str, d.a(i10));
    }

    @an.f
    public static final long M0(String str) {
        kn.l0.p(str, "<this>");
        return Long.parseLong(str);
    }

    @f1(version = "1.1")
    @an.f
    public static final long N0(String str, int i10) {
        kn.l0.p(str, "<this>");
        return Long.parseLong(str, d.a(i10));
    }

    @an.f
    public static final short O0(String str) {
        kn.l0.p(str, "<this>");
        return Short.parseShort(str);
    }

    @f1(version = "1.1")
    @an.f
    public static final short P0(String str, int i10) {
        kn.l0.p(str, "<this>");
        return Short.parseShort(str, d.a(i10));
    }

    @f1(version = "1.1")
    @an.f
    public static final String Q0(byte b10, int i10) {
        String string = Integer.toString(b10, d.a(i10));
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @f1(version = "1.1")
    @an.f
    public static final String R0(int i10, int i11) {
        String string = Integer.toString(i10, d.a(i11));
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @f1(version = "1.1")
    @an.f
    public static final String S0(long j10, int i10) {
        String string = Long.toString(j10, d.a(i10));
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @f1(version = "1.1")
    @an.f
    public static final String T0(short s10, int i10) {
        String string = Integer.toString(s10, d.a(i10));
        kn.l0.o(string, "toString(...)");
        return string;
    }

    public static final <T> T u0(String str, jn.l<? super String, ? extends T> lVar) {
        try {
            if (u.f8899b.matches(str)) {
                return lVar.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal v0(String str) {
        kn.l0.p(str, "<this>");
        return new BigDecimal(str);
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal w0(String str, MathContext mathContext) {
        kn.l0.p(str, "<this>");
        kn.l0.p(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @os.m
    @f1(version = "1.2")
    public static final BigDecimal x0(@os.l String str) {
        kn.l0.p(str, "<this>");
        try {
            if (u.f8899b.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @os.m
    @f1(version = "1.2")
    public static final BigDecimal y0(@os.l String str, @os.l MathContext mathContext) {
        kn.l0.p(str, "<this>");
        kn.l0.p(mathContext, "mathContext");
        try {
            if (u.f8899b.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger z0(String str) {
        kn.l0.p(str, "<this>");
        return new BigInteger(str);
    }
}
