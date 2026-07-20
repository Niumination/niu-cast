package k3;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class t1 {
    public static int a(String str, int i8, int i9, boolean z2) {
        while (i8 < i9) {
            char cCharAt = str.charAt(i8);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z2)) {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00b1  */
    public static long b(int i8, String str) {
        int iA = a(str, 0, i8, false);
        Matcher matcher = dj.k.f4591m.matcher(str);
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int iIndexOf$default = -1;
        int i12 = -1;
        int i13 = -1;
        while (iA < i8) {
            int iA2 = a(str, iA + 1, i8, true);
            matcher.region(iA, iA2);
            if (i10 == -1 && matcher.usePattern(dj.k.f4591m).matches()) {
                String strGroup = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
                i10 = Integer.parseInt(strGroup);
                String strGroup2 = matcher.group(2);
                Intrinsics.checkNotNullExpressionValue(strGroup2, "matcher.group(2)");
                i12 = Integer.parseInt(strGroup2);
                String strGroup3 = matcher.group(3);
                Intrinsics.checkNotNullExpressionValue(strGroup3, "matcher.group(3)");
                i13 = Integer.parseInt(strGroup3);
            } else if (i11 == -1 && matcher.usePattern(dj.k.f4590l).matches()) {
                String strGroup4 = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(strGroup4, "matcher.group(1)");
                i11 = Integer.parseInt(strGroup4);
            } else if (iIndexOf$default == -1) {
                Pattern pattern = dj.k.f4589k;
                if (matcher.usePattern(pattern).matches()) {
                    String strGroup5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                    if (strGroup5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = strGroup5.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = pattern.pattern();
                    Intrinsics.checkNotNullExpressionValue(strPattern, "MONTH_PATTERN.pattern()");
                    iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i9 != -1 && matcher.usePattern(dj.k.f4588j).matches()) {
                    String strGroup6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup6, "matcher.group(1)");
                    i9 = Integer.parseInt(strGroup6);
                }
            } else if (i9 != -1) {
            }
            iA = a(str, iA2 + 1, i8, false);
        }
        if (70 <= i9 && 99 >= i9) {
            i9 += 1900;
        }
        if (i9 >= 0 && 69 >= i9) {
            i9 += 2000;
        }
        if (!(i9 >= 1601)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (iIndexOf$default == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (1 > i11 || 31 < i11) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i10 < 0 || 23 < i10) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i12 < 0 || 59 < i12) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i13 < 0 || 59 < i13) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(ej.b.e);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i9);
        gregorianCalendar.set(2, iIndexOf$default - 1);
        gregorianCalendar.set(5, i11);
        gregorianCalendar.set(11, i10);
        gregorianCalendar.set(12, i12);
        gregorianCalendar.set(13, i13);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }
}
