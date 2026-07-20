package f1;

import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class w0<C extends Comparable> {
    final boolean supportsFastOffset;

    public static final class b extends w0<BigInteger> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5511a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final BigInteger f5512b = BigInteger.valueOf(Long.MIN_VALUE);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final BigInteger f5513c = BigInteger.valueOf(Long.MAX_VALUE);
        private static final long serialVersionUID = 0;

        public b() {
            super(true);
        }

        private Object readResolve() {
            return f5511a;
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }

        @Override // f1.w0
        public long distance(BigInteger start, BigInteger end) {
            return end.subtract(start).max(f5512b).min(f5513c).longValue();
        }

        @Override // f1.w0
        public BigInteger next(BigInteger value) {
            return value.add(BigInteger.ONE);
        }

        @Override // f1.w0
        public BigInteger offset(BigInteger origin, long distance) {
            b0.c(distance, "distance");
            return origin.add(BigInteger.valueOf(distance));
        }

        @Override // f1.w0
        public BigInteger previous(BigInteger value) {
            return value.subtract(BigInteger.ONE);
        }
    }

    public static final class c extends w0<Integer> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5514a = new c();
        private static final long serialVersionUID = 0;

        public c() {
            super(true);
        }

        private Object readResolve() {
            return f5514a;
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }

        @Override // f1.w0
        public long distance(Integer start, Integer end) {
            return ((long) end.intValue()) - ((long) start.intValue());
        }

        @Override // f1.w0
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        @Override // f1.w0
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // f1.w0
        @gm.a
        public Integer next(Integer value) {
            int iIntValue = value.intValue();
            if (iIntValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue + 1);
        }

        @Override // f1.w0
        public Integer offset(Integer origin, long distance) {
            b0.c(distance, "distance");
            return Integer.valueOf(o1.l.d(origin.longValue() + distance));
        }

        @Override // f1.w0
        @gm.a
        public Integer previous(Integer value) {
            int iIntValue = value.intValue();
            if (iIntValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue - 1);
        }
    }

    public static final class d extends w0<Long> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5515a = new d();
        private static final long serialVersionUID = 0;

        public d() {
            super(true);
        }

        private Object readResolve() {
            return f5515a;
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }

        @Override // f1.w0
        public long distance(Long start, Long end) {
            long jLongValue = end.longValue() - start.longValue();
            if (end.longValue() > start.longValue() && jLongValue < 0) {
                return Long.MAX_VALUE;
            }
            if (end.longValue() >= start.longValue() || jLongValue <= 0) {
                return jLongValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // f1.w0
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        @Override // f1.w0
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // f1.w0
        @gm.a
        public Long next(Long value) {
            long jLongValue = value.longValue();
            if (jLongValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue + 1);
        }

        @Override // f1.w0
        public Long offset(Long origin, long distance) {
            b0.c(distance, "distance");
            long jLongValue = origin.longValue() + distance;
            if (jLongValue < 0) {
                c1.h0.e(origin.longValue() < 0, "overflow");
            }
            return Long.valueOf(jLongValue);
        }

        @Override // f1.w0
        @gm.a
        public Long previous(Long value) {
            long jLongValue = value.longValue();
            if (jLongValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue - 1);
        }
    }

    public static w0<BigInteger> bigIntegers() {
        return b.f5511a;
    }

    public static w0<Integer> integers() {
        return c.f5514a;
    }

    public static w0<Long> longs() {
        return d.f5515a;
    }

    public abstract long distance(C start, C end);

    @t1.a
    public C maxValue() {
        throw new NoSuchElementException();
    }

    @t1.a
    public C minValue() {
        throw new NoSuchElementException();
    }

    @gm.a
    public abstract C next(C value);

    public C offset(C c10, long j10) {
        b0.c(j10, "distance");
        C c11 = c10;
        for (long j11 = 0; j11 < j10; j11++) {
            c11 = (C) next(c11);
            if (c11 == null) {
                throw new IllegalArgumentException("overflowed computing offset(" + c10 + ", " + j10 + ")");
            }
        }
        return c11;
    }

    @gm.a
    public abstract C previous(C value);

    public w0() {
        this(false);
    }

    public w0(boolean supportsFastOffset) {
        this.supportsFastOffset = supportsFastOffset;
    }
}
