package m3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class r6 {
    public static final zg.g a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new zg.g(str);
    }

    public static final String b(String str) {
        char lowerCase;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            char cCharAt = str.charAt(i8);
            if ('A' > cCharAt || cCharAt >= '[') {
                lowerCase = (cCharAt < 0 || cCharAt >= 128) ? Character.toLowerCase(cCharAt) : cCharAt;
            } else {
                lowerCase = (char) (cCharAt + ' ');
            }
            if (lowerCase != cCharAt) {
                break;
            }
            i8++;
        }
        if (i8 == -1) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        sb2.append((CharSequence) str, 0, i8);
        int lastIndex = StringsKt.getLastIndex(str);
        if (i8 <= lastIndex) {
            while (true) {
                char cCharAt2 = str.charAt(i8);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    cCharAt2 = (char) (cCharAt2 + ' ');
                } else if (cCharAt2 < 0 || cCharAt2 >= 128) {
                    cCharAt2 = Character.toLowerCase(cCharAt2);
                }
                sb2.append(cCharAt2);
                if (i8 == lastIndex) {
                    break;
                }
                i8++;
            }
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String c(String str) {
        char lowerCase;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            char cCharAt = str.charAt(i8);
            if ('a' > cCharAt || cCharAt >= '{') {
                lowerCase = (cCharAt < 0 || cCharAt >= 128) ? Character.toLowerCase(cCharAt) : cCharAt;
            } else {
                lowerCase = (char) (cCharAt - ' ');
            }
            if (lowerCase != cCharAt) {
                break;
            }
            i8++;
        }
        if (i8 == -1) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        sb2.append((CharSequence) str, 0, i8);
        int lastIndex = StringsKt.getLastIndex(str);
        if (i8 <= lastIndex) {
            while (true) {
                char cCharAt2 = str.charAt(i8);
                if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    cCharAt2 = (char) (cCharAt2 - ' ');
                } else if (cCharAt2 < 0 || cCharAt2 >= 128) {
                    cCharAt2 = Character.toLowerCase(cCharAt2);
                }
                sb2.append(cCharAt2);
                if (i8 == lastIndex) {
                    break;
                }
                i8++;
            }
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
