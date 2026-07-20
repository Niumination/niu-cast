package ks;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9488a = "@|";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9489b = "|@";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9490c = " ";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9491d = ",";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9492e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9493f = 2;

    public static Appendable a(String str, Appendable appendable) throws IOException {
        int i10 = 0;
        while (true) {
            int iIndexOf = str.indexOf(f9488a, i10);
            if (iIndexOf == -1) {
                if (i10 == 0) {
                    appendable.append(str);
                    return appendable;
                }
                appendable.append(str.substring(i10));
                return appendable;
            }
            appendable.append(str.substring(i10, iIndexOf));
            int iIndexOf2 = str.indexOf(f9489b, iIndexOf);
            if (iIndexOf2 == -1) {
                appendable.append(str);
                return appendable;
            }
            String[] strArrSplit = str.substring(iIndexOf + 2, iIndexOf2).split(" ", 2);
            if (strArrSplit.length == 1) {
                appendable.append(str);
                return appendable;
            }
            appendable.append(c(strArrSplit[1], strArrSplit[0].split(f9491d)));
            i10 = iIndexOf2 + 2;
        }
    }

    public static String b(String str) throws IllegalArgumentException {
        try {
            return a(str, new StringBuilder()).toString();
        } catch (IOException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static String c(String str, String... strArr) {
        return d(ks.a.r(), strArr).l(str).S0().toString();
    }

    public static ks.a d(ks.a aVar, String... strArr) {
        for (String str : strArr) {
            a aVarValueOf = a.valueOf(str.toUpperCase(Locale.ENGLISH));
            if (aVarValueOf.isColor()) {
                if (aVarValueOf.isBackground()) {
                    aVar.D(aVarValueOf.getColor());
                } else {
                    aVar.p0(aVarValueOf.getColor());
                }
            } else if (aVarValueOf.isAttribute()) {
                aVar.n(aVarValueOf.getAttribute());
            }
        }
        return aVar;
    }

    public static String e(String str) {
        return f(str.split("\\s"));
    }

    public static String f(String... strArr) {
        return d(ks.a.r(), strArr).toString();
    }

    public static boolean g(String str) {
        return str != null && str.contains(f9488a);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BLACK' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        public static final a BG_BLACK;
        public static final a BG_BLUE;
        public static final a BG_CYAN;
        public static final a BG_DEFAULT;
        public static final a BG_GREEN;
        public static final a BG_MAGENTA;
        public static final a BG_RED;
        public static final a BG_WHITE;
        public static final a BG_YELLOW;
        public static final a BLACK;
        public static final a BLINK_FAST;
        public static final a BLINK_OFF;
        public static final a BLINK_SLOW;
        public static final a BLUE;
        public static final a BOLD;
        public static final a CONCEAL_OFF;
        public static final a CONCEAL_ON;
        public static final a CYAN;
        public static final a DEFAULT;
        public static final a FAINT;
        public static final a FG_BLACK;
        public static final a FG_BLUE;
        public static final a FG_CYAN;
        public static final a FG_DEFAULT;
        public static final a FG_GREEN;
        public static final a FG_MAGENTA;
        public static final a FG_RED;
        public static final a FG_WHITE;
        public static final a FG_YELLOW;
        public static final a GREEN;
        public static final a INTENSITY_BOLD;
        public static final a INTENSITY_FAINT;
        public static final a ITALIC;
        public static final a MAGENTA;
        public static final a NEGATIVE_OFF;
        public static final a NEGATIVE_ON;
        public static final a RED;
        public static final a RESET;
        public static final a UNDERLINE;
        public static final a UNDERLINE_DOUBLE;
        public static final a UNDERLINE_OFF;
        public static final a WHITE;
        public static final a YELLOW;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a[] f9494a;
        private final boolean background;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Enum<?> f9495n;

        static {
            ks.a.d dVar = ks.a.d.BLACK;
            a aVar = new a("BLACK", 0, dVar, false);
            BLACK = aVar;
            ks.a.d dVar2 = ks.a.d.RED;
            a aVar2 = new a("RED", 1, dVar2, false);
            RED = aVar2;
            ks.a.d dVar3 = ks.a.d.GREEN;
            a aVar3 = new a("GREEN", 2, dVar3, false);
            GREEN = aVar3;
            ks.a.d dVar4 = ks.a.d.YELLOW;
            a aVar4 = new a("YELLOW", 3, dVar4, false);
            YELLOW = aVar4;
            ks.a.d dVar5 = ks.a.d.BLUE;
            a aVar5 = new a("BLUE", 4, dVar5, false);
            BLUE = aVar5;
            ks.a.d dVar6 = ks.a.d.MAGENTA;
            a aVar6 = new a("MAGENTA", 5, dVar6, false);
            MAGENTA = aVar6;
            ks.a.d dVar7 = ks.a.d.CYAN;
            a aVar7 = new a("CYAN", 6, dVar7, false);
            CYAN = aVar7;
            ks.a.d dVar8 = ks.a.d.WHITE;
            a aVar8 = new a("WHITE", 7, dVar8, false);
            WHITE = aVar8;
            ks.a.d dVar9 = ks.a.d.DEFAULT;
            a aVar9 = new a("DEFAULT", 8, dVar9, false);
            DEFAULT = aVar9;
            a aVar10 = new a("FG_BLACK", 9, dVar, false);
            FG_BLACK = aVar10;
            a aVar11 = new a("FG_RED", 10, dVar2, false);
            FG_RED = aVar11;
            a aVar12 = new a("FG_GREEN", 11, dVar3, false);
            FG_GREEN = aVar12;
            a aVar13 = new a("FG_YELLOW", 12, dVar4, false);
            FG_YELLOW = aVar13;
            a aVar14 = new a("FG_BLUE", 13, dVar5, false);
            FG_BLUE = aVar14;
            a aVar15 = new a("FG_MAGENTA", 14, dVar6, false);
            FG_MAGENTA = aVar15;
            a aVar16 = new a("FG_CYAN", 15, dVar7, false);
            FG_CYAN = aVar16;
            a aVar17 = new a("FG_WHITE", 16, dVar8, false);
            FG_WHITE = aVar17;
            a aVar18 = new a("FG_DEFAULT", 17, dVar9, false);
            FG_DEFAULT = aVar18;
            a aVar19 = new a("BG_BLACK", 18, dVar, true);
            BG_BLACK = aVar19;
            a aVar20 = new a("BG_RED", 19, dVar2, true);
            BG_RED = aVar20;
            a aVar21 = new a("BG_GREEN", 20, dVar3, true);
            BG_GREEN = aVar21;
            a aVar22 = new a("BG_YELLOW", 21, dVar4, true);
            BG_YELLOW = aVar22;
            a aVar23 = new a("BG_BLUE", 22, dVar5, true);
            BG_BLUE = aVar23;
            a aVar24 = new a("BG_MAGENTA", 23, dVar6, true);
            BG_MAGENTA = aVar24;
            a aVar25 = new a("BG_CYAN", 24, dVar7, true);
            BG_CYAN = aVar25;
            a aVar26 = new a("BG_WHITE", 25, dVar8, true);
            BG_WHITE = aVar26;
            a aVar27 = new a("BG_DEFAULT", 26, dVar9, true);
            BG_DEFAULT = aVar27;
            a aVar28 = new a("RESET", 27, ks.a.c.RESET, false);
            RESET = aVar28;
            ks.a.c cVar = ks.a.c.INTENSITY_BOLD;
            a aVar29 = new a("INTENSITY_BOLD", 28, cVar, false);
            INTENSITY_BOLD = aVar29;
            ks.a.c cVar2 = ks.a.c.INTENSITY_FAINT;
            a aVar30 = new a("INTENSITY_FAINT", 29, cVar2, false);
            INTENSITY_FAINT = aVar30;
            a aVar31 = new a("ITALIC", 30, ks.a.c.ITALIC, false);
            ITALIC = aVar31;
            a aVar32 = new a("UNDERLINE", 31, ks.a.c.UNDERLINE, false);
            UNDERLINE = aVar32;
            a aVar33 = new a("BLINK_SLOW", 32, ks.a.c.BLINK_SLOW, false);
            BLINK_SLOW = aVar33;
            a aVar34 = new a("BLINK_FAST", 33, ks.a.c.BLINK_FAST, false);
            BLINK_FAST = aVar34;
            a aVar35 = new a("BLINK_OFF", 34, ks.a.c.BLINK_OFF, false);
            BLINK_OFF = aVar35;
            a aVar36 = new a("NEGATIVE_ON", 35, ks.a.c.NEGATIVE_ON, false);
            NEGATIVE_ON = aVar36;
            a aVar37 = new a("NEGATIVE_OFF", 36, ks.a.c.NEGATIVE_OFF, false);
            NEGATIVE_OFF = aVar37;
            a aVar38 = new a("CONCEAL_ON", 37, ks.a.c.CONCEAL_ON, false);
            CONCEAL_ON = aVar38;
            a aVar39 = new a("CONCEAL_OFF", 38, ks.a.c.CONCEAL_OFF, false);
            CONCEAL_OFF = aVar39;
            a aVar40 = new a("UNDERLINE_DOUBLE", 39, ks.a.c.UNDERLINE_DOUBLE, false);
            UNDERLINE_DOUBLE = aVar40;
            a aVar41 = new a("UNDERLINE_OFF", 40, ks.a.c.UNDERLINE_OFF, false);
            UNDERLINE_OFF = aVar41;
            a aVar42 = new a("BOLD", 41, cVar, false);
            BOLD = aVar42;
            a aVar43 = new a("FAINT", 42, cVar2, false);
            FAINT = aVar43;
            f9494a = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17, aVar18, aVar19, aVar20, aVar21, aVar22, aVar23, aVar24, aVar25, aVar26, aVar27, aVar28, aVar29, aVar30, aVar31, aVar32, aVar33, aVar34, aVar35, aVar36, aVar37, aVar38, aVar39, aVar40, aVar41, aVar42, aVar43};
        }

        public a(String str, int i10, Enum r10, boolean z10) {
            super(str, i10);
            this.f9495n = r10;
            this.background = z10;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f9494a.clone();
        }

        public ks.a.c getAttribute() {
            return (ks.a.c) this.f9495n;
        }

        public ks.a.d getColor() {
            return (ks.a.d) this.f9495n;
        }

        public boolean isAttribute() {
            return this.f9495n instanceof ks.a.c;
        }

        public boolean isBackground() {
            return this.background;
        }

        public boolean isColor() {
            return this.f9495n instanceof ks.a.d;
        }

        public a(String str, int i10, Enum r10) {
            this(str, i10, r10, false);
        }
    }
}
