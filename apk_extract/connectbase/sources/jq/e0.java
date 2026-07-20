package jq;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kn.r1;
import kn.t1;
import lm.a1;
import lm.f1;
import lm.p2;
import nm.v0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStringsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,829:1\n1174#2,2:830\n1#3:832\n1726#4,3:833\n*S KotlinDebug\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n*L\n73#1:830,2\n624#1:833,3\n*E\n"})
public class e0 extends d0 {
    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use replaceFirstChar instead.", replaceWith = @a1(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @os.l
    public static final String A1(@os.l String str) {
        kn.l0.p(str, "<this>");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        kn.l0.o(strSubstring, "substring(...)");
        kn.l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase();
        kn.l0.o(lowerCase, "toLowerCase(...)");
        sb2.append(lowerCase);
        String strSubstring2 = str.substring(1);
        kn.l0.o(strSubstring2, "substring(...)");
        sb2.append(strSubstring2);
        return sb2.toString();
    }

    public static /* synthetic */ char[] A2(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return y2(str, i10, i11);
    }

    @an.h
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use replaceFirstChar instead.", replaceWith = @a1(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @os.l
    public static final String B1(@os.l String str, @os.l Locale locale) {
        kn.l0.p(str, "<this>");
        kn.l0.p(locale, "locale");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        kn.l0.o(strSubstring, "substring(...)");
        kn.l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        sb2.append(lowerCase);
        String strSubstring2 = str.substring(1);
        kn.l0.o(strSubstring2, "substring(...)");
        sb2.append(strSubstring2);
        return sb2.toString();
    }

    public static /* synthetic */ char[] B2(String str, char[] cArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = str.length();
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(cArr, RtspHeaders.Values.DESTINATION);
        str.getChars(i11, i12, cArr, i10);
        return cArr;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final String C1(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return new String(bArr, f.f8800b);
    }

    @lm.l(warningSince = "1.5")
    @an.f
    @lm.k(message = "Use lowercase() instead.", replaceWith = @a1(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    public static final String C2(String str) {
        kn.l0.p(str, "<this>");
        String lowerCase = str.toLowerCase();
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final String D1(@os.l byte[] bArr, int i10, int i11, boolean z10) {
        kn.l0.p(bArr, "<this>");
        nm.c.Companion.a(i10, i11, bArr.length);
        if (!z10) {
            return new String(bArr, i10, i11 - i10, f.f8800b);
        }
        CharsetDecoder charsetDecoderNewDecoder = f.f8800b.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i10, i11 - i10)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @lm.l(warningSince = "1.5")
    @an.f
    @lm.k(message = "Use lowercase() instead.", replaceWith = @a1(expression = "lowercase(locale)", imports = {}))
    public static final String D2(String str, Locale locale) {
        kn.l0.p(str, "<this>");
        kn.l0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static /* synthetic */ String E1(byte[] bArr, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return D1(bArr, i10, i11, z10);
    }

    @an.f
    public static final Pattern E2(String str, int i10) {
        kn.l0.p(str, "<this>");
        Pattern patternCompile = Pattern.compile(str, i10);
        kn.l0.o(patternCompile, "compile(...)");
        return patternCompile;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final byte[] F1(@os.l String str) {
        kn.l0.p(str, "<this>");
        byte[] bytes = str.getBytes(f.f8800b);
        kn.l0.o(bytes, "getBytes(...)");
        return bytes;
    }

    public static /* synthetic */ Pattern F2(String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        kn.l0.p(str, "<this>");
        Pattern patternCompile = Pattern.compile(str, i10);
        kn.l0.o(patternCompile, "compile(...)");
        return patternCompile;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final byte[] G1(@os.l String str, int i10, int i11, boolean z10) throws CharacterCodingException {
        kn.l0.p(str, "<this>");
        nm.c.Companion.a(i10, i11, str.length());
        if (!z10) {
            String strSubstring = str.substring(i10, i11);
            kn.l0.o(strSubstring, "substring(...)");
            Charset charset = f.f8800b;
            kn.l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = strSubstring.getBytes(charset);
            kn.l0.o(bytes, "getBytes(...)");
            return bytes;
        }
        CharsetEncoder charsetEncoderNewEncoder = f.f8800b.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, i10, i11));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            kn.l0.m(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                kn.l0.m(bArrArray2);
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    @lm.l(warningSince = "1.5")
    @an.f
    @lm.k(message = "Use uppercase() instead.", replaceWith = @a1(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    public static final String G2(String str) {
        kn.l0.p(str, "<this>");
        String upperCase = str.toUpperCase();
        kn.l0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static /* synthetic */ byte[] H1(String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return G1(str, i10, i11, z10);
    }

    @lm.l(warningSince = "1.5")
    @an.f
    @lm.k(message = "Use uppercase() instead.", replaceWith = @a1(expression = "uppercase(locale)", imports = {}))
    public static final String H2(String str, Locale locale) {
        kn.l0.p(str, "<this>");
        kn.l0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        kn.l0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static final boolean I1(@os.l String str, @os.l String str2, boolean z10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "suffix");
        return !z10 ? str.endsWith(str2) : b2(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final String I2(String str) {
        kn.l0.p(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        kn.l0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static /* synthetic */ boolean J1(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return I1(str, str2, z10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final String J2(String str, Locale locale) {
        kn.l0.p(str, "<this>");
        kn.l0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        kn.l0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static boolean K1(@os.m String str, @os.m String str2, boolean z10) {
        if (str == null) {
            return str2 == null;
        }
        return !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean L1(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return K1(str, str2, z10);
    }

    @f1(version = "1.4")
    @an.f
    public static final String M1(String str, Locale locale, Object... objArr) {
        kn.l0.p(str, "<this>");
        kn.l0.p(objArr, d6.a.F);
        String str2 = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        kn.l0.o(str2, "format(...)");
        return str2;
    }

    @an.f
    public static final String N1(String str, Object... objArr) {
        kn.l0.p(str, "<this>");
        kn.l0.p(objArr, d6.a.F);
        String str2 = String.format(str, Arrays.copyOf(objArr, objArr.length));
        kn.l0.o(str2, "format(...)");
        return str2;
    }

    @an.f
    public static final String O1(t1 t1Var, String str, Object... objArr) {
        kn.l0.p(t1Var, "<this>");
        kn.l0.p(str, "format");
        kn.l0.p(objArr, d6.a.F);
        String str2 = String.format(str, Arrays.copyOf(objArr, objArr.length));
        kn.l0.o(str2, "format(...)");
        return str2;
    }

    @f1(version = "1.4")
    @an.f
    public static final String P1(t1 t1Var, Locale locale, String str, Object... objArr) {
        kn.l0.p(t1Var, "<this>");
        kn.l0.p(str, "format");
        kn.l0.p(objArr, d6.a.F);
        String str2 = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        kn.l0.o(str2, "format(...)");
        return str2;
    }

    @os.l
    public static final Comparator<String> Q1(@os.l t1 t1Var) {
        kn.l0.p(t1Var, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        kn.l0.o(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    @an.f
    public static final String R1(String str) {
        kn.l0.p(str, "<this>");
        String strIntern = str.intern();
        kn.l0.o(strIntern, "intern(...)");
        return strIntern;
    }

    public static boolean S1(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable iterableF3 = h0.f3(charSequence);
            if (!(iterableF3 instanceof Collection) || !((Collection) iterableF3).isEmpty()) {
                Iterator it = iterableF3.iterator();
                while (it.hasNext()) {
                    if (!d.r(charSequence.charAt(((v0) it).nextInt()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final String T1(String str) {
        kn.l0.p(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final String U1(String str, Locale locale) {
        kn.l0.p(str, "<this>");
        kn.l0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @an.f
    public static final int V1(String str, char c10, int i10) {
        kn.l0.p(str, "<this>");
        return str.indexOf(c10, i10);
    }

    @an.f
    public static final int W1(String str, String str2, int i10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "str");
        return str.indexOf(str2, i10);
    }

    @an.f
    public static final int X1(String str, char c10, int i10) {
        kn.l0.p(str, "<this>");
        return str.lastIndexOf(c10, i10);
    }

    @an.f
    public static final int Y1(String str, String str2, int i10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "str");
        return str.lastIndexOf(str2, i10);
    }

    @an.f
    public static final int Z1(String str, int i10, int i11) {
        kn.l0.p(str, "<this>");
        return str.offsetByCodePoints(i10, i11);
    }

    public static final boolean a2(@os.l CharSequence charSequence, int i10, @os.l CharSequence charSequence2, int i11, int i12, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "other");
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? b2((String) charSequence, i10, (String) charSequence2, i11, i12, z10) : h0.Y3(charSequence, i10, charSequence2, i11, i12, z10);
    }

    public static boolean b2(@os.l String str, int i10, @os.l String str2, int i11, int i12, boolean z10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "other");
        return !z10 ? str.regionMatches(i10, str2, i11, i12) : str.regionMatches(z10, i10, str2, i11, i12);
    }

    public static /* synthetic */ boolean c2(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return a2(charSequence, i10, charSequence2, i11, i12, z10);
    }

    @an.f
    public static final String d1(StringBuffer stringBuffer) {
        kn.l0.p(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    public static /* synthetic */ boolean d2(String str, int i10, String str2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return b2(str, i10, str2, i11, i12, z10);
    }

    @an.f
    public static final String e1(StringBuilder sb2) {
        kn.l0.p(sb2, "stringBuilder");
        return new String(sb2);
    }

    @os.l
    public static String e2(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + n1.e.f11183c).toString());
        }
        if (i10 == 0) {
            return "";
        }
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cArr[i11] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
        v0 v0VarA = nm.o.a(1, i10, 1);
        while (v0VarA.hasNext()) {
            v0VarA.nextInt();
            sb2.append(charSequence);
        }
        String string = sb2.toString();
        kn.l0.m(string);
        return string;
    }

    @an.f
    public static final String f1(byte[] bArr) {
        kn.l0.p(bArr, "bytes");
        return new String(bArr, f.f8800b);
    }

    @os.l
    public static final String f2(@os.l String str, char c10, char c11, boolean z10) {
        kn.l0.p(str, "<this>");
        if (!z10) {
            String strReplace = str.replace(c10, c11);
            kn.l0.o(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (e.J(cCharAt, c10, z10)) {
                cCharAt = c11;
            }
            sb2.append(cCharAt);
        }
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    public static final String g1(byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "bytes");
        return new String(bArr, i10, i11, f.f8800b);
    }

    @os.l
    public static final String g2(@os.l String str, @os.l String str2, @os.l String str3, boolean z10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "oldValue");
        kn.l0.p(str3, "newValue");
        int i10 = 0;
        int iL3 = h0.l3(str, str2, 0, z10);
        if (iL3 < 0) {
            return str;
        }
        int length = str2.length();
        int i11 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iL3);
            sb2.append(str3);
            i10 = iL3 + length;
            if (iL3 >= str.length()) {
                break;
            }
            iL3 = h0.l3(str, str2, iL3 + i11, z10);
        } while (iL3 > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    public static final String h1(byte[] bArr, int i10, int i11, Charset charset) {
        kn.l0.p(bArr, "bytes");
        kn.l0.p(charset, "charset");
        return new String(bArr, i10, i11, charset);
    }

    public static /* synthetic */ String h2(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return f2(str, c10, c11, z10);
    }

    @an.f
    public static final String i1(byte[] bArr, Charset charset) {
        kn.l0.p(bArr, "bytes");
        kn.l0.p(charset, "charset");
        return new String(bArr, charset);
    }

    public static /* synthetic */ String i2(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return g2(str, str2, str3, z10);
    }

    @an.f
    public static final String j1(char[] cArr) {
        kn.l0.p(cArr, "chars");
        return new String(cArr);
    }

    @os.l
    public static final String j2(@os.l String str, char c10, char c11, boolean z10) {
        kn.l0.p(str, "<this>");
        int iO3 = h0.o3(str, c10, 0, z10, 2, null);
        return iO3 < 0 ? str : h0.G4(str, iO3, iO3 + 1, String.valueOf(c11)).toString();
    }

    @an.f
    public static final String k1(char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "chars");
        return new String(cArr, i10, i11);
    }

    @os.l
    public static final String k2(@os.l String str, @os.l String str2, @os.l String str3, boolean z10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "oldValue");
        kn.l0.p(str3, "newValue");
        int iP3 = h0.p3(str, str2, 0, z10, 2, null);
        return iP3 < 0 ? str : h0.G4(str, iP3, str2.length() + iP3, str3).toString();
    }

    @an.f
    public static final String l1(int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "codePoints");
        return new String(iArr, i10, i11);
    }

    public static /* synthetic */ String l2(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return j2(str, c10, c11, z10);
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use replaceFirstChar instead.", replaceWith = @a1(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @os.l
    public static final String m1(@os.l String str) {
        kn.l0.p(str, "<this>");
        Locale locale = Locale.getDefault();
        kn.l0.o(locale, "getDefault(...)");
        return n1(str, locale);
    }

    public static /* synthetic */ String m2(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return k2(str, str2, str3, z10);
    }

    @an.h
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use replaceFirstChar instead.", replaceWith = @a1(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @os.l
    public static final String n1(@os.l String str, @os.l Locale locale) {
        kn.l0.p(str, "<this>");
        kn.l0.p(locale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb2.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            kn.l0.o(strSubstring, "substring(...)");
            kn.l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            kn.l0.o(upperCase, "toUpperCase(...)");
            sb2.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        kn.l0.o(strSubstring2, "substring(...)");
        sb2.append(strSubstring2);
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.l
    public static final List<String> n2(@os.l CharSequence charSequence, @os.l Pattern pattern, int i10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pattern, "regex");
        h0.K4(i10);
        if (i10 == 0) {
            i10 = -1;
        }
        String[] strArrSplit = pattern.split(charSequence, i10);
        kn.l0.o(strArrSplit, "split(...)");
        return nm.p.t(strArrSplit);
    }

    @an.f
    public static final int o1(String str, int i10) {
        kn.l0.p(str, "<this>");
        return str.codePointAt(i10);
    }

    public static /* synthetic */ List o2(CharSequence charSequence, Pattern pattern, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return n2(charSequence, pattern, i10);
    }

    @an.f
    public static final int p1(String str, int i10) {
        kn.l0.p(str, "<this>");
        return str.codePointBefore(i10);
    }

    public static final boolean p2(@os.l String str, @os.l String str2, int i10, boolean z10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "prefix");
        return !z10 ? str.startsWith(str2, i10) : b2(str, i10, str2, 0, str2.length(), z10);
    }

    @an.f
    public static final int q1(String str, int i10, int i11) {
        kn.l0.p(str, "<this>");
        return str.codePointCount(i10, i11);
    }

    public static boolean q2(@os.l String str, @os.l String str2, boolean z10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "prefix");
        return !z10 ? str.startsWith(str2) : b2(str, 0, str2, 0, str2.length(), z10);
    }

    public static int r1(@os.l String str, @os.l String str2, boolean z10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "other");
        return z10 ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static /* synthetic */ boolean r2(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return p2(str, str2, i10, z10);
    }

    public static /* synthetic */ int s1(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return r1(str, str2, z10);
    }

    public static /* synthetic */ boolean s2(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return q2(str, str2, z10);
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static String t1(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return new String(cArr);
    }

    @an.f
    public static final String t2(String str, int i10) {
        kn.l0.p(str, "<this>");
        String strSubstring = str.substring(i10);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final String u1(@os.l char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        nm.c.Companion.a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    @an.f
    public static final String u2(String str, int i10, int i11) {
        kn.l0.p(str, "<this>");
        String strSubstring = str.substring(i10, i11);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String v1(char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = cArr.length;
        }
        return u1(cArr, i10, i11);
    }

    @an.f
    public static final byte[] v2(String str, Charset charset) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        kn.l0.o(bytes, "getBytes(...)");
        return bytes;
    }

    @f1(version = "1.5")
    public static final boolean w1(@os.m CharSequence charSequence, @os.m CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? h0.V2(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    public static /* synthetic */ byte[] w2(String str, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = f.f8800b;
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        kn.l0.o(bytes, "getBytes(...)");
        return bytes;
    }

    @f1(version = "1.5")
    public static final boolean x1(@os.m CharSequence charSequence, @os.m CharSequence charSequence2, boolean z10) {
        return z10 ? h0.U2(charSequence, charSequence2) : w1(charSequence, charSequence2);
    }

    @an.f
    public static final char[] x2(String str) {
        kn.l0.p(str, "<this>");
        char[] charArray = str.toCharArray();
        kn.l0.o(charArray, "toCharArray(...)");
        return charArray;
    }

    @an.f
    public static final boolean y1(String str, CharSequence charSequence) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final char[] y2(@os.l String str, int i10, int i11) {
        kn.l0.p(str, "<this>");
        nm.c.Companion.a(i10, i11, str.length());
        char[] cArr = new char[i11 - i10];
        str.getChars(i10, i11, cArr, 0);
        return cArr;
    }

    @an.f
    public static final boolean z1(String str, StringBuffer stringBuffer) {
        kn.l0.p(str, "<this>");
        kn.l0.p(stringBuffer, "stringBuilder");
        return str.contentEquals(stringBuffer);
    }

    @an.f
    public static final char[] z2(String str, char[] cArr, int i10, int i11, int i12) {
        kn.l0.p(str, "<this>");
        kn.l0.p(cArr, RtspHeaders.Values.DESTINATION);
        str.getChars(i11, i12, cArr, i10);
        return cArr;
    }
}
