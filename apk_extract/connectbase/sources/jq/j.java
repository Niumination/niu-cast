package jq;

import java.util.Arrays;
import kn.r1;
import lm.a2;
import lm.f1;
import lm.o2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,591:1\n1#2:592\n1183#3,3:593\n1183#3,3:596\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n13#1:593,3\n14#1:596,3\n*E\n"})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f8821a = "0123456789abcdef";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f8822b = "0123456789ABCDEF";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final int[] f8823c;

    static {
        int[] iArr = new int[128];
        int i10 = 0;
        for (int i11 = 0; i11 < 128; i11++) {
            iArr[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < f8821a.length()) {
            iArr[f8821a.charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        while (i10 < f8822b.length()) {
            iArr[f8822b.charAt(i10)] = i14;
            i10++;
            i14++;
        }
        f8823c = iArr;
    }

    public static short A(String str, int i10, int i11, k kVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return y(str, i10, i11, kVar);
    }

    public static short B(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return z(str, kVar);
    }

    public static final int C(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        long jA;
        if (i10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j10 = ((long) i15) + 2 + ((long) i16);
        long jA2 = a(j10, i12, i14);
        if (i11 <= i12) {
            jA = a(j10, i11, i14);
        } else {
            jA = a(jA2, i11 / i12, i13);
            int i17 = i11 % i12;
            if (i17 != 0) {
                jA = a(j10, i17, i14) + jA + ((long) i13);
            }
        }
        long j11 = i10;
        long jQ = Q(j11, jA, 1);
        long j12 = j11 - ((jA + 1) * jQ);
        long jQ2 = Q(j12, jA2, i13);
        long j13 = j12 - ((jA2 + ((long) i13)) * jQ2);
        long jQ3 = Q(j13, j10, i14);
        return (int) ((jQ2 * ((long) i12)) + (jQ * ((long) i11)) + jQ3 + ((long) (j13 - ((j10 + ((long) i14)) * jQ3) > 0 ? 1 : 0)));
    }

    @f1(version = "1.9")
    @lm.r
    @os.l
    public static final String D(byte b10, @os.l k kVar) {
        kn.l0.p(kVar, "format");
        return P(b10, kVar, 8);
    }

    @f1(version = "1.9")
    @lm.r
    @os.l
    public static final String E(int i10, @os.l k kVar) {
        kn.l0.p(kVar, "format");
        return P(i10, kVar, 32);
    }

    @f1(version = "1.9")
    @lm.r
    @os.l
    public static final String F(long j10, @os.l k kVar) {
        kn.l0.p(kVar, "format");
        return P(j10, kVar, 64);
    }

    @f1(version = "1.9")
    @lm.r
    @os.l
    public static final String G(short s10, @os.l k kVar) {
        kn.l0.p(kVar, "format");
        return P(s10, kVar, 16);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x0073 A[SYNTHETIC] */
    @f1(version = "1.9")
    @lm.r
    @os.l
    public static final String H(@os.l byte[] bArr, int i10, int i11, @os.l k kVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(kVar, "format");
        nm.c.Companion.a(i10, i11, bArr.length);
        if (i10 == i11) {
            return "";
        }
        String str = kVar.f8831a ? f8822b : f8821a;
        k.b bVar = kVar.f8832b;
        int i12 = bVar.f8839a;
        int i13 = bVar.f8840b;
        String str2 = bVar.f8843e;
        String str3 = bVar.f8844f;
        String str4 = bVar.f8842d;
        String str5 = bVar.f8841c;
        int iF = f(i11 - i10, i12, i13, str5.length(), str4.length(), str2.length(), str3.length());
        StringBuilder sb2 = new StringBuilder(iF);
        int i14 = 0;
        int i15 = 0;
        for (int i16 = i10; i16 < i11; i16++) {
            byte b10 = bArr[i16];
            int i17 = b10 & 255;
            if (i14 == i12) {
                sb2.append('\n');
                i14 = 0;
            } else {
                if (i15 == i13) {
                    sb2.append(str5);
                }
                if (i15 != 0) {
                    sb2.append(str4);
                }
                sb2.append(str2);
                sb2.append(str.charAt(i17 >> 4));
                sb2.append(str.charAt(b10 & c1.c.f1123q));
                sb2.append(str3);
                i15++;
                i14++;
            }
            i15 = 0;
            if (i15 != 0) {
                sb2.append(str4);
            }
            sb2.append(str2);
            sb2.append(str.charAt(i17 >> 4));
            sb2.append(str.charAt(b10 & c1.c.f1123q));
            sb2.append(str3);
            i15++;
            i14++;
        }
        if (iF != sb2.length()) {
            throw new IllegalStateException("Check failed.");
        }
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @f1(version = "1.9")
    @lm.r
    @os.l
    public static final String I(@os.l byte[] bArr, @os.l k kVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(kVar, "format");
        return H(bArr, 0, bArr.length, kVar);
    }

    public static String J(byte b10, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return D(b10, kVar);
    }

    public static String K(int i10, k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return E(i10, kVar);
    }

    public static String L(long j10, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return F(j10, kVar);
    }

    public static String M(short s10, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return G(s10, kVar);
    }

    public static String N(byte[] bArr, int i10, int i11, k kVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 4) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return H(bArr, i10, i11, kVar);
    }

    public static String O(byte[] bArr, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return I(bArr, kVar);
    }

    @lm.r
    public static final String P(long j10, k kVar, int i10) {
        if ((i10 & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        String str = kVar.f8831a ? f8822b : f8821a;
        k.d dVar = kVar.f8833c;
        String str2 = dVar.f8853a;
        String str3 = dVar.f8854b;
        int length = str3.length() + str2.length() + (i10 >> 2);
        boolean z10 = kVar.f8833c.f8855c;
        StringBuilder sb2 = new StringBuilder(length);
        sb2.append(str2);
        while (i10 > 0) {
            i10 -= 4;
            int i11 = (int) ((j10 >> i10) & 15);
            z10 = z10 && i11 == 0 && i10 > 0;
            if (!z10) {
                sb2.append(str.charAt(i11));
            }
        }
        sb2.append(str3);
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    public static final long Q(long j10, long j11, int i10) {
        if (j10 <= 0 || j11 <= 0) {
            return 0L;
        }
        long j12 = i10;
        return (j10 + j12) / (j11 + j12);
    }

    public static final long a(long j10, int i10, int i11) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j11 = i10;
        return ((j11 - 1) * ((long) i11)) + (j10 * j11);
    }

    public static final int b(String str, String str2, int i10, int i11, String str3) {
        int length = str2.length() + i10;
        if (length <= i11 && e0.b2(str, i10, str2, 0, str2.length(), true)) {
            return length;
        }
        StringBuilder sb2 = new StringBuilder("Expected ");
        sb2.append(str3);
        sb2.append(" \"");
        sb2.append(str2);
        sb2.append("\" at index ");
        sb2.append(i10);
        sb2.append(", but was ");
        if (length <= i11) {
            i11 = length;
        }
        kn.l0.n(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, i11);
        kn.l0.o(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        throw new NumberFormatException(sb2.toString());
    }

    public static final void c(String str, int i10, int i11, int i12, boolean z10) {
        int i13 = i11 - i10;
        if (z10) {
            if (i13 == i12) {
                return;
            }
        } else if (i13 <= i12) {
            return;
        }
        String str2 = z10 ? "exactly" : "at most";
        kn.l0.n(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, i11);
        kn.l0.o(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i12 + " hexadecimal digits at index " + i10 + ", but was " + strSubstring + " of length " + i13);
    }

    public static final int d(String str, int i10, int i11) {
        if (str.charAt(i10) == '\r') {
            int i12 = i10 + 1;
            return (i12 >= i11 || str.charAt(i12) != '\n') ? i12 : i10 + 2;
        }
        if (str.charAt(i10) == '\n') {
            return i10 + 1;
        }
        StringBuilder sbA = h.b.a("Expected a new line at index ", i10, ", but was ");
        sbA.append(str.charAt(i10));
        throw new NumberFormatException(sbA.toString());
    }

    public static final int e(String str, int i10) {
        int i11;
        char cCharAt = str.charAt(i10);
        if (cCharAt <= 127 && (i11 = f8823c[cCharAt]) >= 0) {
            return i11;
        }
        StringBuilder sbA = h.b.a("Expected a hexadecimal digit at index ", i10, ", but was ");
        sbA.append(str.charAt(i10));
        throw new NumberFormatException(sbA.toString());
    }

    public static final int f(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i17 = i10 - 1;
        int i18 = i17 / i11;
        int i19 = (i11 - 1) / i12;
        int i20 = i10 % i11;
        if (i20 != 0) {
            i11 = i20;
        }
        int i21 = (i19 * i18) + ((i11 - 1) / i12);
        long j10 = ((((long) i15) + 2 + ((long) i16)) * ((long) i10)) + (((long) ((i17 - i18) - i21)) * ((long) i14)) + (((long) i21) * ((long) i13)) + ((long) i18);
        if (tn.u.K0(new tn.l(0, Integer.MAX_VALUE, 1), j10)) {
            return (int) j10;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) o2.l(a2.m(j10), 10)));
    }

    @lm.r
    public static final byte g(String str, int i10, int i11, k kVar) {
        return (byte) w(str, i10, i11, kVar, 2);
    }

    @f1(version = "1.9")
    @lm.r
    public static final byte h(@os.l String str, @os.l k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return g(str, 0, str.length(), kVar);
    }

    public static byte i(String str, int i10, int i11, k kVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return g(str, i10, i11, kVar);
    }

    public static byte j(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return h(str, kVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006e  */
    /* JADX WARN: Code duplicated, block: B:25:0x006f A[SYNTHETIC] */
    @lm.r
    public static final byte[] k(String str, int i10, int i11, k kVar) {
        int i12;
        int iB = i10;
        nm.c.Companion.a(iB, i11, str.length());
        if (iB == i11) {
            return new byte[0];
        }
        k.b bVar = kVar.f8832b;
        int i13 = bVar.f8839a;
        int i14 = bVar.f8840b;
        String str2 = bVar.f8843e;
        String str3 = bVar.f8844f;
        String str4 = bVar.f8842d;
        String str5 = bVar.f8841c;
        String str6 = str4;
        int iC = C(i11 - iB, i13, i14, str5.length(), str4.length(), str2.length(), str3.length());
        byte[] bArr = new byte[iC];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (iB < i11) {
            if (i16 == i13) {
                iB = d(str, iB, i11);
                i16 = 0;
            } else {
                if (i17 == i14) {
                    iB = b(str, str5, iB, i11, "group separator");
                } else if (i17 != 0) {
                    iB = b(str, str6, iB, i11, "byte separator");
                }
                i16++;
                i17++;
                int iB2 = b(str, str2, iB, i11, "byte prefix");
                i12 = iB2 + 2;
                if (i12 > i11) {
                    i12 = i11;
                }
                c(str, iB2, i12, 2, true);
                int iE = e(str, iB2) << 4;
                bArr[i15] = (byte) (e(str, iB2 + 1) | iE);
                iB = b(str, str3, iB2 + 2, i11, "byte suffix");
                i15++;
                str6 = str6;
            }
            i17 = 0;
            i16++;
            i17++;
            int iB3 = b(str, str2, iB, i11, "byte prefix");
            i12 = iB3 + 2;
            if (i12 > i11) {
                i12 = i11;
            }
            c(str, iB3, i12, 2, true);
            int iE2 = e(str, iB3) << 4;
            bArr[i15] = (byte) (e(str, iB3 + 1) | iE2);
            iB = b(str, str3, iB3 + 2, i11, "byte suffix");
            i15++;
            str6 = str6;
        }
        if (i15 == iC) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i15);
        kn.l0.o(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @f1(version = "1.9")
    @lm.r
    @os.l
    public static final byte[] l(@os.l String str, @os.l k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return k(str, 0, str.length(), kVar);
    }

    public static byte[] m(String str, int i10, int i11, k kVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return k(str, i10, i11, kVar);
    }

    public static byte[] n(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return l(str, kVar);
    }

    @lm.r
    public static final int o(String str, int i10, int i11, k kVar) {
        return (int) w(str, i10, i11, kVar, 8);
    }

    @f1(version = "1.9")
    @lm.r
    public static final int p(@os.l String str, @os.l k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return o(str, 0, str.length(), kVar);
    }

    public static int q(String str, int i10, int i11, k kVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return o(str, i10, i11, kVar);
    }

    public static int r(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return p(str, kVar);
    }

    @lm.r
    public static final long s(String str, int i10, int i11, k kVar) {
        return w(str, i10, i11, kVar, 16);
    }

    @f1(version = "1.9")
    @lm.r
    public static final long t(@os.l String str, @os.l k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return w(str, 0, str.length(), kVar, 16);
    }

    public static long u(String str, int i10, int i11, k kVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return w(str, i10, i11, kVar, 16);
    }

    public static long v(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        return t(str, kVar);
    }

    @lm.r
    public static final long w(String str, int i10, int i11, k kVar, int i12) {
        nm.c.Companion.a(i10, i11, str.length());
        k.d dVar = kVar.f8833c;
        String str2 = dVar.f8853a;
        String str3 = dVar.f8854b;
        if (str3.length() + str2.length() < i11 - i10) {
            int iB = b(str, str2, i10, i11, "prefix");
            int length = i11 - str3.length();
            b(str, str3, length, i11, "suffix");
            c(str, iB, length, i12, false);
            long jE = 0;
            while (iB < length) {
                jE = (jE << 4) | ((long) e(str, iB));
                iB++;
            }
            return jE;
        }
        StringBuilder sb2 = new StringBuilder("Expected a hexadecimal number with prefix \"");
        sb2.append(str2);
        sb2.append("\" and suffix \"");
        sb2.append(str3);
        sb2.append("\", but was ");
        kn.l0.n(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, i11);
        kn.l0.o(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        throw new NumberFormatException(sb2.toString());
    }

    public static /* synthetic */ long x(String str, int i10, int i11, k kVar, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = 0;
        }
        if ((i13 & 2) != 0) {
            i11 = str.length();
        }
        return w(str, i10, i11, kVar, i12);
    }

    @lm.r
    public static final short y(String str, int i10, int i11, k kVar) {
        return (short) w(str, i10, i11, kVar, 4);
    }

    @f1(version = "1.9")
    @lm.r
    public static final short z(@os.l String str, @os.l k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return y(str, 0, str.length(), kVar);
    }
}
