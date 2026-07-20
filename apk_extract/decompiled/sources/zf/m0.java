package zf;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import m3.d6;
import m3.e6;
import m3.f6;
import m3.l6;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f11520a = CollectionsKt.listOf("");

    public static final int a(int i8, int i9, String str) {
        boolean z2 = false;
        while (i8 < i9) {
            char cCharAt = str.charAt(i8);
            if (cCharAt != ':') {
                if (cCharAt == '[') {
                    z2 = true;
                } else if (cCharAt == ']') {
                    z2 = false;
                }
            } else if (!z2) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static final j0 b(j0 j0Var, String urlString) {
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (StringsKt.isBlank(urlString)) {
            return j0Var;
        }
        try {
            c(j0Var, urlString);
            return j0Var;
        } catch (Throwable th2) {
            throw new l0(urlString, th2);
        }
    }

    public static final void c(j0 j0Var, String urlString) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        List listSplit$default;
        int iIntValue;
        int i14;
        char c9;
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        int length = urlString.length();
        int i15 = 0;
        while (true) {
            if (i15 >= length) {
                i15 = -1;
                break;
            } else if (!CharsKt.isWhitespace(urlString.charAt(i15))) {
                break;
            } else {
                i15++;
            }
        }
        int length2 = urlString.length() - 1;
        if (length2 < 0) {
            length2 = -1;
            break;
        }
        while (true) {
            int i16 = length2 - 1;
            if (!CharsKt.isWhitespace(urlString.charAt(length2))) {
                break;
            }
            if (i16 < 0) {
                length2 = -1;
                break;
            }
            length2 = i16;
        }
        int i17 = length2 + 1;
        char cCharAt = urlString.charAt(i15);
        if (('a' > cCharAt || cCharAt >= '{') && ('A' > cCharAt || cCharAt >= '[')) {
            i8 = i15;
            i9 = i8;
        } else {
            i9 = -1;
            i8 = i15;
        }
        while (true) {
            if (i8 < i17) {
                char cCharAt2 = urlString.charAt(i8);
                if (cCharAt2 == ':') {
                    if (i9 != -1) {
                        throw new IllegalArgumentException(a1.a.o(i9, "Illegal character in scheme at position "));
                    }
                    i10 = i8 - i15;
                    break;
                }
                if (cCharAt2 != '#' && cCharAt2 != '/' && cCharAt2 != '?') {
                    if (i9 != -1 || ('a' <= cCharAt2 && cCharAt2 < '{')) {
                        c9 = '[';
                    } else {
                        c9 = '[';
                        if (('A' > cCharAt2 || cCharAt2 >= '[') && (('0' > cCharAt2 || cCharAt2 >= ':') && cCharAt2 != '.' && cCharAt2 != '+' && cCharAt2 != '-')) {
                            i9 = i8;
                        }
                    }
                    i8++;
                }
            }
            i10 = -1;
            break;
        }
        if (i10 > 0) {
            String strSubstring = urlString.substring(i15, i15 + i10);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            n0 n0Var = n0.f11524c;
            n0 value = f6.a(strSubstring);
            j0Var.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            j0Var.f11512d = value;
            i11 = 1;
            i15 += i10 + 1;
        } else {
            i11 = 1;
        }
        int i18 = 0;
        while (true) {
            i12 = i15 + i18;
            if (i12 >= i17 || urlString.charAt(i12) != '/') {
                break;
            } else {
                i18 += i11;
            }
        }
        if (Intrinsics.areEqual(j0Var.c().f11526a, "file")) {
            if (i18 != 2) {
                if (i18 != 3) {
                    throw new IllegalArgumentException("Invalid file url: ".concat(urlString));
                }
                Intrinsics.checkNotNullParameter("", "<set-?>");
                j0Var.f11509a = "";
                StringBuilder sb2 = new StringBuilder("/");
                String strSubstring2 = urlString.substring(i12, i17);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                sb2.append(strSubstring2);
                e6.d(j0Var, sb2.toString());
                return;
            }
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) urlString, '/', i12, false, 4, (Object) null);
            if (iIndexOf$default == -1 || iIndexOf$default == i17) {
                String strSubstring3 = urlString.substring(i12, i17);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                j0Var.e(strSubstring3);
                return;
            } else {
                String strSubstring4 = urlString.substring(i12, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                j0Var.e(strSubstring4);
                String strSubstring5 = urlString.substring(iIndexOf$default, i17);
                Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                e6.d(j0Var, strSubstring5);
                return;
            }
        }
        if (Intrinsics.areEqual(j0Var.c().f11526a, "mailto")) {
            if (i18 != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) urlString, "@", i12, false, 4, (Object) null);
            if (iIndexOf$default2 == -1) {
                throw new IllegalArgumentException(h0.a.j("Invalid mailto url: ", urlString, ", it should contain '@'."));
            }
            String strSubstring6 = urlString.substring(i12, iIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
            String strC = d.c(strSubstring6, 0, 0, 7);
            j0Var.e = strC != null ? d.e(strC, false) : null;
            String strSubstring7 = urlString.substring(iIndexOf$default2 + 1, i17);
            Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
            j0Var.e(strSubstring7);
            return;
        }
        if (Intrinsics.areEqual(j0Var.c().f11526a, "about")) {
            if (i18 != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strSubstring8 = urlString.substring(i12, i17);
            Intrinsics.checkNotNullExpressionValue(strSubstring8, "substring(...)");
            j0Var.e(strSubstring8);
            return;
        }
        if (i18 >= 2) {
            while (true) {
                int iIndexOfAny$default = StringsKt__StringsKt.indexOfAny$default((CharSequence) urlString, l6.a("@/\\?#"), i12, false, 4, (Object) null);
                Integer numValueOf = Integer.valueOf(iIndexOfAny$default);
                if (iIndexOfAny$default <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : i17;
                if (iIntValue >= i17 || urlString.charAt(iIntValue) != '@') {
                    break;
                }
                int iA = a(i12, iIntValue, urlString);
                if (iA != -1) {
                    String strSubstring9 = urlString.substring(i12, iA);
                    Intrinsics.checkNotNullExpressionValue(strSubstring9, "substring(...)");
                    j0Var.e = strSubstring9;
                    String strSubstring10 = urlString.substring(iA + 1, iIntValue);
                    Intrinsics.checkNotNullExpressionValue(strSubstring10, "substring(...)");
                    j0Var.f = strSubstring10;
                } else {
                    String strSubstring11 = urlString.substring(i12, iIntValue);
                    Intrinsics.checkNotNullExpressionValue(strSubstring11, "substring(...)");
                    j0Var.e = strSubstring11;
                }
                i12 = iIntValue + 1;
            }
            int iA2 = a(i12, iIntValue, urlString);
            Integer numValueOf2 = Integer.valueOf(iA2);
            if (iA2 <= 0) {
                numValueOf2 = null;
            }
            int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : iIntValue;
            String strSubstring12 = urlString.substring(i12, iIntValue2);
            Intrinsics.checkNotNullExpressionValue(strSubstring12, "substring(...)");
            j0Var.e(strSubstring12);
            int i19 = iIntValue2 + 1;
            if (i19 < iIntValue) {
                String strSubstring13 = urlString.substring(i19, iIntValue);
                Intrinsics.checkNotNullExpressionValue(strSubstring13, "substring(...)");
                i14 = Integer.parseInt(strSubstring13);
            } else {
                i14 = 0;
            }
            j0Var.f(i14);
            i12 = iIntValue;
        }
        List listEmptyList = f11520a;
        if (i12 >= i17) {
            if (urlString.charAt(length2) != '/') {
                listEmptyList = CollectionsKt.emptyList();
            }
            j0Var.d(listEmptyList);
            return;
        }
        j0Var.d(i18 == 0 ? CollectionsKt___CollectionsKt.dropLast(j0Var.f11514h, 1) : CollectionsKt.emptyList());
        int iIndexOfAny$default2 = StringsKt__StringsKt.indexOfAny$default((CharSequence) urlString, l6.a("?#"), i12, false, 4, (Object) null);
        Integer numValueOf3 = Integer.valueOf(iIndexOfAny$default2);
        if (iIndexOfAny$default2 <= 0) {
            numValueOf3 = null;
        }
        int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : i17;
        if (iIntValue3 > i12) {
            String strSubstring14 = urlString.substring(i12, iIntValue3);
            Intrinsics.checkNotNullExpressionValue(strSubstring14, "substring(...)");
            List listEmptyList2 = (j0Var.f11514h.size() == 1 && ((CharSequence) CollectionsKt.first(j0Var.f11514h)).length() == 0) ? CollectionsKt.emptyList() : j0Var.f11514h;
            if (Intrinsics.areEqual(strSubstring14, "/")) {
                listSplit$default = listEmptyList;
                i13 = 1;
            } else {
                i13 = 1;
                listSplit$default = StringsKt__StringsKt.split$default(strSubstring14, new char[]{'/'}, false, 0, 6, (Object) null);
            }
            if (i18 != i13) {
                listEmptyList = CollectionsKt.emptyList();
            }
            j0Var.d(CollectionsKt.plus((Collection) listEmptyList2, (Iterable) CollectionsKt.plus((Collection) listEmptyList, (Iterable) listSplit$default)));
            i12 = iIntValue3;
        }
        if (i12 < i17 && urlString.charAt(i12) == '?') {
            int i20 = i12 + 1;
            if (i20 == i17) {
                j0Var.f11510b = true;
                i12 = i17;
            } else {
                int iIndexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) urlString, '#', i20, false, 4, (Object) null);
                Integer numValueOf4 = iIndexOf$default3 > 0 ? Integer.valueOf(iIndexOf$default3) : null;
                int iIntValue4 = numValueOf4 != null ? numValueOf4.intValue() : i17;
                String strSubstring15 = urlString.substring(i20, iIntValue4);
                Intrinsics.checkNotNullExpressionValue(strSubstring15, "substring(...)");
                d6.b(0, 6, strSubstring15).c(new lc.a(j0Var, 10));
                i12 = iIntValue4;
            }
        }
        if (i12 >= i17 || urlString.charAt(i12) != '#') {
            return;
        }
        String strSubstring16 = urlString.substring(i12 + 1, i17);
        Intrinsics.checkNotNullExpressionValue(strSubstring16, "substring(...)");
        Intrinsics.checkNotNullParameter(strSubstring16, "<set-?>");
        j0Var.f11513g = strSubstring16;
    }
}
