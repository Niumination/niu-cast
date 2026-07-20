package jq;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {
    @os.l
    public static final String a(char c10) {
        String strValueOf = String.valueOf(c10);
        kn.l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        kn.l0.o(upperCase, "toUpperCase(...)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c10));
        }
        if (c10 == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        kn.l0.n(upperCase, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = upperCase.substring(1);
        kn.l0.o(strSubstring, "substring(...)");
        kn.l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }
}
