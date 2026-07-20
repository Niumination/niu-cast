package jq;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kn.r1;
import lm.a1;
import lm.f1;
import lm.s0;
import nm.v0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1239#2,14:109\n1521#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
public class i0 extends h0 {
    @an.f
    public static final char U5(CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.charAt(i10);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ Character V5(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return j0.N7(charSequence);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxByOrNull instead.", replaceWith = @a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Character W5(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iG3 = h0.g3(charSequence);
        if (iG3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        v0 v0VarA = nm.o.a(1, iG3, 1);
        while (v0VarA.hasNext()) {
            char cCharAt2 = charSequence.charAt(v0VarA.nextInt());
            R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                cCharAt = cCharAt2;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use maxWithOrNull instead.", replaceWith = @a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Character X5(CharSequence charSequence, Comparator comparator) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        return j0.P7(charSequence, comparator);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ Character Y5(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return j0.b8(charSequence);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minByOrNull instead.", replaceWith = @a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> Character Z5(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iG3 = h0.g3(charSequence);
        if (iG3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        v0 v0VarA = nm.o.a(1, iG3, 1);
        while (v0VarA.hasNext()) {
            char cCharAt2 = charSequence.charAt(v0VarA.nextInt());
            R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                cCharAt = cCharAt2;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @lm.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @lm.k(message = "Use minWithOrNull instead.", replaceWith = @a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ Character a6(CharSequence charSequence, Comparator comparator) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        return j0.d8(charSequence, comparator);
    }

    @s0
    @an.f
    @in.i(name = "sumOfBigDecimal")
    @f1(version = "1.4")
    public static final BigDecimal b6(CharSequence charSequence, jn.l<? super Character, ? extends BigDecimal> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) g0.a(charSequence, i10, lVar));
            kn.l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @s0
    @an.f
    @in.i(name = "sumOfBigInteger")
    @f1(version = "1.4")
    public static final BigInteger c6(CharSequence charSequence, jn.l<? super Character, ? extends BigInteger> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) g0.a(charSequence, i10, lVar));
            kn.l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @os.l
    public static final SortedSet<Character> d6(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return (SortedSet) j0.c9(charSequence, new TreeSet());
    }
}
