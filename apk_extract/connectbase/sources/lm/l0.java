package lm;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
public class l0 {
    @f1(version = "1.2")
    @an.f
    public static final BigDecimal a(BigDecimal bigDecimal) {
        kn.l0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(BigDecimal.ONE);
        kn.l0.o(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    @an.f
    public static final BigDecimal b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        kn.l0.p(bigDecimal, "<this>");
        kn.l0.p(bigDecimal2, "other");
        BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        kn.l0.o(bigDecimalDivide, "divide(...)");
        return bigDecimalDivide;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal c(BigDecimal bigDecimal) {
        kn.l0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalAdd = bigDecimal.add(BigDecimal.ONE);
        kn.l0.o(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    @an.f
    public static final BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        kn.l0.p(bigDecimal, "<this>");
        kn.l0.p(bigDecimal2, "other");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(bigDecimal2);
        kn.l0.o(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    @an.f
    public static final BigDecimal e(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        kn.l0.p(bigDecimal, "<this>");
        kn.l0.p(bigDecimal2, "other");
        BigDecimal bigDecimalAdd = bigDecimal.add(bigDecimal2);
        kn.l0.o(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    @an.f
    public static final BigDecimal f(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        kn.l0.p(bigDecimal, "<this>");
        kn.l0.p(bigDecimal2, "other");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(bigDecimal2);
        kn.l0.o(bigDecimalRemainder, "remainder(...)");
        return bigDecimalRemainder;
    }

    @an.f
    public static final BigDecimal g(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        kn.l0.p(bigDecimal, "<this>");
        kn.l0.p(bigDecimal2, "other");
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
        kn.l0.o(bigDecimalMultiply, "multiply(...)");
        return bigDecimalMultiply;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal h(double d10) {
        return new BigDecimal(String.valueOf(d10));
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal i(double d10, MathContext mathContext) {
        kn.l0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d10), mathContext);
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal j(float f10) {
        return new BigDecimal(String.valueOf(f10));
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal k(float f10, MathContext mathContext) {
        kn.l0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f10), mathContext);
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal l(int i10) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i10);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal m(int i10, MathContext mathContext) {
        kn.l0.p(mathContext, "mathContext");
        return new BigDecimal(i10, mathContext);
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal n(long j10) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j10);
        kn.l0.o(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal o(long j10, MathContext mathContext) {
        kn.l0.p(mathContext, "mathContext");
        return new BigDecimal(j10, mathContext);
    }

    @an.f
    public static final BigDecimal p(BigDecimal bigDecimal) {
        kn.l0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalNegate = bigDecimal.negate();
        kn.l0.o(bigDecimalNegate, "negate(...)");
        return bigDecimalNegate;
    }
}
