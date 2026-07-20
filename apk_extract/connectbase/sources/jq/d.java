package jq;

import java.util.Locale;
import lm.a1;
import lm.f1;
import lm.p2;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final String A(char c10) {
        String strValueOf = String.valueOf(c10);
        kn.l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        kn.l0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final String B(char c10, @os.l Locale locale) {
        kn.l0.p(locale, "locale");
        String strValueOf = String.valueOf(c10);
        kn.l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        kn.l0.o(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final char C(char c10) {
        return Character.toUpperCase(c10);
    }

    @z0
    public static int a(int i10) {
        if (new tn.l(2, 36, 1).l(i10)) {
            return i10;
        }
        StringBuilder sbA = h.b.a("radix ", i10, " was not in valid range ");
        sbA.append(new tn.l(2, 36, 1));
        throw new IllegalArgumentException(sbA.toString());
    }

    public static final int b(char c10, int i10) {
        return Character.digit((int) c10, i10);
    }

    @os.l
    public static final a c(char c10) {
        return a.Companion.a(Character.getType(c10));
    }

    @os.l
    public static final b d(char c10) {
        return b.Companion.b(Character.getDirectionality(c10));
    }

    @an.f
    public static final boolean e(char c10) {
        return Character.isDefined(c10);
    }

    @an.f
    public static final boolean f(char c10) {
        return Character.isDigit(c10);
    }

    @an.f
    public static final boolean g(char c10) {
        return Character.isHighSurrogate(c10);
    }

    @an.f
    public static final boolean h(char c10) {
        return Character.isISOControl(c10);
    }

    @an.f
    public static final boolean i(char c10) {
        return Character.isIdentifierIgnorable(c10);
    }

    @an.f
    public static final boolean j(char c10) {
        return Character.isJavaIdentifierPart(c10);
    }

    @an.f
    public static final boolean k(char c10) {
        return Character.isJavaIdentifierStart(c10);
    }

    @an.f
    public static final boolean l(char c10) {
        return Character.isLetter(c10);
    }

    @an.f
    public static final boolean m(char c10) {
        return Character.isLetterOrDigit(c10);
    }

    @an.f
    public static final boolean n(char c10) {
        return Character.isLowSurrogate(c10);
    }

    @an.f
    public static final boolean o(char c10) {
        return Character.isLowerCase(c10);
    }

    @an.f
    public static final boolean p(char c10) {
        return Character.isTitleCase(c10);
    }

    @an.f
    public static final boolean q(char c10) {
        return Character.isUpperCase(c10);
    }

    public static boolean r(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final String s(char c10) {
        String strValueOf = String.valueOf(c10);
        kn.l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final String t(char c10, @os.l Locale locale) {
        kn.l0.p(locale, "locale");
        String strValueOf = String.valueOf(c10);
        kn.l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final char u(char c10) {
        return Character.toLowerCase(c10);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final String v(char c10, @os.l Locale locale) {
        kn.l0.p(locale, "locale");
        String strB = B(c10, locale);
        if (strB.length() <= 1) {
            String strValueOf = String.valueOf(c10);
            kn.l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            kn.l0.o(upperCase, "toUpperCase(...)");
            return !kn.l0.g(strB, upperCase) ? strB : String.valueOf(Character.toTitleCase(c10));
        }
        if (c10 == 329) {
            return strB;
        }
        char cCharAt = strB.charAt(0);
        kn.l0.n(strB, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strB.substring(1);
        kn.l0.o(strSubstring, "substring(...)");
        kn.l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        kn.l0.o(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final char w(char c10) {
        return Character.toTitleCase(c10);
    }

    @lm.l(warningSince = "1.5")
    @an.f
    @lm.k(message = "Use lowercaseChar() instead.", replaceWith = @a1(expression = "lowercaseChar()", imports = {}))
    public static final char x(char c10) {
        return Character.toLowerCase(c10);
    }

    @lm.l(warningSince = "1.5")
    @an.f
    @lm.k(message = "Use titlecaseChar() instead.", replaceWith = @a1(expression = "titlecaseChar()", imports = {}))
    public static final char y(char c10) {
        return Character.toTitleCase(c10);
    }

    @lm.l(warningSince = "1.5")
    @an.f
    @lm.k(message = "Use uppercaseChar() instead.", replaceWith = @a1(expression = "uppercaseChar()", imports = {}))
    public static final char z(char c10) {
        return Character.toUpperCase(c10);
    }
}
