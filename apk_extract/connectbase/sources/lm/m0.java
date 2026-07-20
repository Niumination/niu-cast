package lm;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: loaded from: classes3.dex */
public class m0 extends l0 {
    @f1(version = "1.2")
    @an.f
    public static final BigInteger A(BigInteger bigInteger, int i10) {
        kn.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(i10);
        kn.l0.o(bigIntegerShiftRight, "shiftRight(...)");
        return bigIntegerShiftRight;
    }

    @an.f
    public static final BigInteger B(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2);
        kn.l0.o(bigIntegerMultiply, "multiply(...)");
        return bigIntegerMultiply;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal C(BigInteger bigInteger) {
        kn.l0.p(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    @f1(version = "1.2")
    @an.f
    public static final BigDecimal D(BigInteger bigInteger, int i10, MathContext mathContext) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i10, mathContext);
    }

    public static /* synthetic */ BigDecimal E(BigInteger bigInteger, int i10, MathContext mathContext, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            kn.l0.o(mathContext, "UNLIMITED");
        }
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i10, mathContext);
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger F(int i10) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i10);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        return bigIntegerValueOf;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger G(long j10) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j10);
        kn.l0.o(bigIntegerValueOf, "valueOf(...)");
        return bigIntegerValueOf;
    }

    @an.f
    public static final BigInteger H(BigInteger bigInteger) {
        kn.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerNegate = bigInteger.negate();
        kn.l0.o(bigIntegerNegate, "negate(...)");
        return bigIntegerNegate;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger I(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerXor = bigInteger.xor(bigInteger2);
        kn.l0.o(bigIntegerXor, "xor(...)");
        return bigIntegerXor;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger q(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerAnd = bigInteger.and(bigInteger2);
        kn.l0.o(bigIntegerAnd, "and(...)");
        return bigIntegerAnd;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger r(BigInteger bigInteger) {
        kn.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerSubtract = bigInteger.subtract(BigInteger.ONE);
        kn.l0.o(bigIntegerSubtract, "subtract(...)");
        return bigIntegerSubtract;
    }

    @an.f
    public static final BigInteger s(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerDivide = bigInteger.divide(bigInteger2);
        kn.l0.o(bigIntegerDivide, "divide(...)");
        return bigIntegerDivide;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger t(BigInteger bigInteger) {
        kn.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerAdd = bigInteger.add(BigInteger.ONE);
        kn.l0.o(bigIntegerAdd, "add(...)");
        return bigIntegerAdd;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger u(BigInteger bigInteger) {
        kn.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerNot = bigInteger.not();
        kn.l0.o(bigIntegerNot, "not(...)");
        return bigIntegerNot;
    }

    @an.f
    public static final BigInteger v(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
        kn.l0.o(bigIntegerSubtract, "subtract(...)");
        return bigIntegerSubtract;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger w(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerOr = bigInteger.or(bigInteger2);
        kn.l0.o(bigIntegerOr, "or(...)");
        return bigIntegerOr;
    }

    @an.f
    public static final BigInteger x(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
        kn.l0.o(bigIntegerAdd, "add(...)");
        return bigIntegerAdd;
    }

    @f1(version = "1.1")
    @an.f
    public static final BigInteger y(BigInteger bigInteger, BigInteger bigInteger2) {
        kn.l0.p(bigInteger, "<this>");
        kn.l0.p(bigInteger2, "other");
        BigInteger bigIntegerRemainder = bigInteger.remainder(bigInteger2);
        kn.l0.o(bigIntegerRemainder, "remainder(...)");
        return bigIntegerRemainder;
    }

    @f1(version = "1.2")
    @an.f
    public static final BigInteger z(BigInteger bigInteger, int i10) {
        kn.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(i10);
        kn.l0.o(bigIntegerShiftLeft, "shiftLeft(...)");
        return bigIntegerShiftLeft;
    }
}
