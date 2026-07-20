package m1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
@b1.d
public class a {

    /* JADX INFO: renamed from: m1.a$a, reason: collision with other inner class name */
    public static class C0272a extends p<BigDecimal> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0272a f10293a = new C0272a();

        @Override // m1.p
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(BigDecimal a10, BigDecimal b10) {
            return a10.subtract(b10);
        }

        @Override // m1.p
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public double c(BigDecimal bigDecimal) {
            return bigDecimal.doubleValue();
        }

        @Override // m1.p
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int d(BigDecimal bigDecimal) {
            return bigDecimal.signum();
        }

        @Override // m1.p
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public BigDecimal e(double d10, RoundingMode mode) {
            return new BigDecimal(d10);
        }
    }

    public static double a(BigDecimal x10, RoundingMode mode) {
        return C0272a.f10293a.b(x10, mode);
    }
}
