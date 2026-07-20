package m3;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class z5 {
    public static final List a(String str) {
        int i8;
        Pair pair;
        if (str == null) {
            return CollectionsKt.emptyList();
        }
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new zb.l(3));
        for (int i9 = 0; i9 <= StringsKt.getLastIndex(str); i9 = i8) {
            Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new zb.l(4));
            Integer numValueOf = null;
            i8 = i9;
            while (true) {
                if (i8 > StringsKt.getLastIndex(str)) {
                    ((ArrayList) lazy.getValue()).add(new zf.n(c(i9, numValueOf != null ? numValueOf.intValue() : i8, str), lazy2.isInitialized() ? (List) lazy2.getValue() : CollectionsKt.emptyList()));
                    break;
                }
                char cCharAt = str.charAt(i8);
                if (cCharAt == ',') {
                    ((ArrayList) lazy.getValue()).add(new zf.n(c(i9, numValueOf != null ? numValueOf.intValue() : i8, str), lazy2.isInitialized() ? (List) lazy2.getValue() : CollectionsKt.emptyList()));
                    i8++;
                    break;
                }
                if (cCharAt == ';') {
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i8);
                    }
                    int i10 = i8 + 1;
                    int i11 = i10;
                    while (true) {
                        if (i11 <= StringsKt.getLastIndex(str)) {
                            char cCharAt2 = str.charAt(i11);
                            if (cCharAt2 == ',' || cCharAt2 == ';') {
                                b(lazy2, str, i10, i11, "");
                            } else {
                                if (cCharAt2 == '=') {
                                    int i12 = i11 + 1;
                                    if (str.length() == i12) {
                                        pair = TuplesKt.to(Integer.valueOf(i12), "");
                                    } else if (str.charAt(i12) != '\"') {
                                        int i13 = i12;
                                        while (true) {
                                            if (i13 > StringsKt.getLastIndex(str)) {
                                                pair = TuplesKt.to(Integer.valueOf(i13), c(i12, i13, str));
                                                break;
                                            }
                                            char cCharAt3 = str.charAt(i13);
                                            if (cCharAt3 == ',' || cCharAt3 == ';') {
                                                pair = TuplesKt.to(Integer.valueOf(i13), c(i12, i13, str));
                                                break;
                                            }
                                            i13++;
                                        }
                                    } else {
                                        int i14 = i11 + 2;
                                        StringBuilder sb2 = new StringBuilder();
                                        while (true) {
                                            if (i14 > StringsKt.getLastIndex(str)) {
                                                Integer numValueOf2 = Integer.valueOf(i14);
                                                String string = sb2.toString();
                                                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                                pair = TuplesKt.to(numValueOf2, "\"" + string);
                                                break;
                                            }
                                            char cCharAt4 = str.charAt(i14);
                                            if (cCharAt4 == '\"') {
                                                int i15 = i14 + 1;
                                                int i16 = i15;
                                                while (i16 < str.length() && str.charAt(i16) == ' ') {
                                                    i16++;
                                                }
                                                if (i16 == str.length() || str.charAt(i16) == ';') {
                                                    pair = TuplesKt.to(Integer.valueOf(i15), sb2.toString());
                                                    break;
                                                }
                                            }
                                            if (cCharAt4 != '\\' || i14 >= StringsKt.getLastIndex(str) - 2) {
                                                sb2.append(cCharAt4);
                                                i14++;
                                            } else {
                                                sb2.append(str.charAt(i14 + 1));
                                                i14 += 2;
                                            }
                                        }
                                    }
                                    int iIntValue = ((Number) pair.component1()).intValue();
                                    b(lazy2, str, i10, i11, (String) pair.component2());
                                    i8 = iIntValue;
                                    break;
                                }
                                i11++;
                            }
                        } else {
                            b(lazy2, str, i10, i11, "");
                        }
                        i8 = i11;
                        break;
                    }
                }
                i8++;
            }
        }
        return lazy.isInitialized() ? (List) lazy.getValue() : CollectionsKt.emptyList();
    }

    public static final void b(Lazy lazy, String str, int i8, int i9, String str2) {
        String strC = c(i8, i9, str);
        if (strC.length() == 0) {
            return;
        }
        ((ArrayList) lazy.getValue()).add(new zf.o(strC, str2));
    }

    public static final String c(int i8, int i9, String str) {
        String strSubstring = str.substring(i8, i9);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return StringsKt__StringsKt.trim((CharSequence) strSubstring).toString();
    }
}
