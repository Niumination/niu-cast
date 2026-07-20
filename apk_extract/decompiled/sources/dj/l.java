package dj;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f4603b = new l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f4604c = new l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f4605d = new l();

    public static final h a(l lVar, String str) {
        h hVar = new h(str);
        h.f4542c.put(str, hVar);
        return hVar;
    }

    public static String b(String canonicalize, int i8, int i9, String encodeSet, boolean z2, boolean z3, boolean z5, boolean z10, int i10) throws EOFException {
        int i11 = (i10 & 1) != 0 ? 0 : i8;
        int length = (i10 & 2) != 0 ? canonicalize.length() : i9;
        boolean z11 = (i10 & 8) != 0 ? false : z2;
        boolean z12 = (i10 & 16) != 0 ? false : z3;
        boolean z13 = (i10 & 32) != 0 ? false : z5;
        boolean z14 = (i10 & 64) == 0 ? z10 : false;
        Intrinsics.checkNotNullParameter(canonicalize, "$this$canonicalize");
        Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
        int iCharCount = i11;
        while (iCharCount < length) {
            int iCodePointAt = canonicalize.codePointAt(iCharCount);
            int i12 = 32;
            int i13 = 128;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z14) || StringsKt__StringsKt.contains$default(encodeSet, (char) iCodePointAt, false, 2, (Object) null) || ((iCodePointAt == 37 && (!z11 || (z12 && !e(iCharCount, length, canonicalize)))) || (iCodePointAt == 43 && z13)))) {
                qj.f fVar = new qj.f();
                fVar.l0(i11, iCharCount, canonicalize);
                qj.f fVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = canonicalize.codePointAt(iCharCount);
                    if (!z11 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z13) {
                            fVar.m0(z11 ? vj.e.ANY_NON_NULL_MARKER : "%2B");
                        } else if (iCodePointAt2 < i12 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i13 && !z14) || StringsKt__StringsKt.contains$default(encodeSet, (char) iCodePointAt2, false, 2, (Object) null) || (iCodePointAt2 == 37 && (!z11 || (z12 && !e(iCharCount, length, canonicalize)))))) {
                            if (fVar2 == null) {
                                fVar2 = new qj.f();
                            }
                            fVar2.n0(iCodePointAt2);
                            while (!fVar2.T()) {
                                byte b9 = fVar2.readByte();
                                int i14 = b9 & UByte.MAX_VALUE;
                                fVar.S(37);
                                char[] cArr = u.f4632k;
                                fVar.S(cArr[(i14 >> 4) & 15]);
                                fVar.S(cArr[b9 & 15]);
                            }
                        } else {
                            fVar.n0(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i12 = 32;
                    i13 = 128;
                }
                return fVar.w();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = canonicalize.substring(i11, length);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static int c(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        int iHashCode = scheme.hashCode();
        if (iHashCode != 3213448) {
            if (iHashCode == 99617003 && scheme.equals("https")) {
                return 443;
            }
        } else if (scheme.equals("http")) {
            return 80;
        }
        return -1;
    }

    public static boolean e(int i8, int i9, String str) {
        int i10 = i8 + 2;
        return i10 < i9 && str.charAt(i8) == '%' && ej.b.r(str.charAt(i8 + 1)) != -1 && ej.b.r(str.charAt(i10)) != -1;
    }

    public static String f(String percentDecode, int i8, int i9, boolean z2, int i10) {
        int i11;
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = percentDecode.length();
        }
        if ((i10 & 4) != 0) {
            z2 = false;
        }
        Intrinsics.checkNotNullParameter(percentDecode, "$this$percentDecode");
        int iCharCount = i8;
        while (iCharCount < i9) {
            char cCharAt = percentDecode.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                qj.f fVar = new qj.f();
                fVar.l0(i8, iCharCount, percentDecode);
                while (iCharCount < i9) {
                    int iCodePointAt = percentDecode.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i11 = iCharCount + 2) < i9) {
                        int iR = ej.b.r(percentDecode.charAt(iCharCount + 1));
                        int iR2 = ej.b.r(percentDecode.charAt(i11));
                        if (iR == -1 || iR2 == -1) {
                            fVar.n0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            fVar.S((iR << 4) + iR2);
                            iCharCount = Character.charCount(iCodePointAt) + i11;
                        }
                    } else if (iCodePointAt == 43 && z2) {
                        fVar.S(32);
                        iCharCount++;
                    } else {
                        fVar.n0(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return fVar.w();
            }
            iCharCount++;
        }
        String strSubstring = percentDecode.substring(i8, i9);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String g(String str) {
        if (StringsKt__StringsJVMKt.startsWith$default(str, "TLS_", false, 2, null)) {
            StringBuilder sb2 = new StringBuilder("SSL_");
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            sb2.append(strSubstring);
            return sb2.toString();
        }
        if (!StringsKt__StringsJVMKt.startsWith$default(str, "SSL_", false, 2, null)) {
            return str;
        }
        StringBuilder sb3 = new StringBuilder("TLS_");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = str.substring(4);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb3.append(strSubstring2);
        return sb3.toString();
    }

    public static ArrayList h(String toQueryNamesAndValues) {
        Intrinsics.checkNotNullParameter(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        while (i8 <= toQueryNamesAndValues.length()) {
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default(toQueryNamesAndValues, Typography.amp, i8, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = toQueryNamesAndValues.length();
            }
            int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) toQueryNamesAndValues, '=', i8, false, 4, (Object) null);
            if (iIndexOf$default2 == -1 || iIndexOf$default2 > iIndexOf$default) {
                String strSubstring = toQueryNamesAndValues.substring(i8, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = toQueryNamesAndValues.substring(i8, iIndexOf$default2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                String strSubstring3 = toQueryNamesAndValues.substring(iIndexOf$default2 + 1, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(strSubstring3);
            }
            i8 = iIndexOf$default + 1;
        }
        return arrayList;
    }

    public synchronized h d(String javaName) {
        h hVar;
        try {
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            LinkedHashMap linkedHashMap = h.f4542c;
            hVar = (h) linkedHashMap.get(javaName);
            if (hVar == null) {
                hVar = (h) linkedHashMap.get(g(javaName));
                if (hVar == null) {
                    hVar = new h(javaName);
                }
                linkedHashMap.put(javaName, hVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return hVar;
    }
}
