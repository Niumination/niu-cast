package j1;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public final class g0 extends c implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final r MURMUR3_128 = new g0(0);
    static final r GOOD_FAST_HASH_128 = new g0(t.f8457a);

    public static final class a extends f {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f8379g = 16;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final long f8380h = -8663945395140668459L;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final long f8381i = 5545529020109919103L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8383e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8384f;

        public a(int seed) {
            super(16, 16);
            long j10 = seed;
            this.f8382d = j10;
            this.f8383e = j10;
            this.f8384f = 0;
        }

        public static long q(long k10) {
            long j10 = (k10 ^ (k10 >>> 33)) * (-49064778989728563L);
            long j11 = (j10 ^ (j10 >>> 33)) * (-4265267296055464877L);
            return j11 ^ (j11 >>> 33);
        }

        public static long r(long k10) {
            return Long.rotateLeft(k10 * f8380h, 31) * f8381i;
        }

        public static long s(long k10) {
            return Long.rotateLeft(k10 * f8381i, 33) * f8380h;
        }

        @Override // j1.f
        public q j() {
            long j10 = this.f8382d;
            int i10 = this.f8384f;
            long j11 = j10 ^ ((long) i10);
            long j12 = this.f8383e ^ ((long) i10);
            long j13 = j11 + j12;
            this.f8382d = j13;
            this.f8383e = j12 + j13;
            this.f8382d = q(j13);
            long jQ = q(this.f8383e);
            long j14 = this.f8382d + jQ;
            this.f8382d = j14;
            this.f8383e = jQ + j14;
            return q.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f8382d).putLong(this.f8383e).array());
        }

        @Override // j1.f
        public void m(ByteBuffer bb2) {
            p(bb2.getLong(), bb2.getLong());
            this.f8384f += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // j1.f
        public void n(ByteBuffer bb2) {
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long j16;
            this.f8384f = bb2.remaining() + this.f8384f;
            long j17 = 0;
            switch (bb2.remaining()) {
                case 1:
                    j10 = 0;
                    j16 = j10 ^ ((long) (bb2.get(0) & 255));
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 2:
                    j11 = 0;
                    j10 = j11 ^ (((long) (bb2.get(1) & 255)) << 8);
                    j16 = j10 ^ ((long) (bb2.get(0) & 255));
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 3:
                    j12 = 0;
                    j11 = (((long) (bb2.get(2) & 255)) << 16) ^ j12;
                    j10 = j11 ^ (((long) (bb2.get(1) & 255)) << 8);
                    j16 = j10 ^ ((long) (bb2.get(0) & 255));
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 4:
                    j13 = 0;
                    j12 = j13 ^ (((long) (bb2.get(3) & 255)) << 24);
                    j11 = (((long) (bb2.get(2) & 255)) << 16) ^ j12;
                    j10 = j11 ^ (((long) (bb2.get(1) & 255)) << 8);
                    j16 = j10 ^ ((long) (bb2.get(0) & 255));
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 5:
                    j14 = 0;
                    j13 = j14 ^ (((long) (bb2.get(4) & 255)) << 32);
                    j12 = j13 ^ (((long) (bb2.get(3) & 255)) << 24);
                    j11 = (((long) (bb2.get(2) & 255)) << 16) ^ j12;
                    j10 = j11 ^ (((long) (bb2.get(1) & 255)) << 8);
                    j16 = j10 ^ ((long) (bb2.get(0) & 255));
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 6:
                    j15 = 0;
                    j14 = (((long) (bb2.get(5) & 255)) << 40) ^ j15;
                    j13 = j14 ^ (((long) (bb2.get(4) & 255)) << 32);
                    j12 = j13 ^ (((long) (bb2.get(3) & 255)) << 24);
                    j11 = (((long) (bb2.get(2) & 255)) << 16) ^ j12;
                    j10 = j11 ^ (((long) (bb2.get(1) & 255)) << 8);
                    j16 = j10 ^ ((long) (bb2.get(0) & 255));
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 7:
                    j15 = ((long) (bb2.get(6) & 255)) << 48;
                    j14 = (((long) (bb2.get(5) & 255)) << 40) ^ j15;
                    j13 = j14 ^ (((long) (bb2.get(4) & 255)) << 32);
                    j12 = j13 ^ (((long) (bb2.get(3) & 255)) << 24);
                    j11 = (((long) (bb2.get(2) & 255)) << 16) ^ j12;
                    j10 = j11 ^ (((long) (bb2.get(1) & 255)) << 8);
                    j16 = j10 ^ ((long) (bb2.get(0) & 255));
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 8:
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 9:
                    j17 ^= (long) (bb2.get(8) & 255);
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 10:
                    j17 ^= ((long) (bb2.get(9) & 255)) << 8;
                    j17 ^= (long) (bb2.get(8) & 255);
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 11:
                    j17 ^= ((long) (bb2.get(10) & 255)) << 16;
                    j17 ^= ((long) (bb2.get(9) & 255)) << 8;
                    j17 ^= (long) (bb2.get(8) & 255);
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 12:
                    j17 ^= ((long) (bb2.get(11) & 255)) << 24;
                    j17 ^= ((long) (bb2.get(10) & 255)) << 16;
                    j17 ^= ((long) (bb2.get(9) & 255)) << 8;
                    j17 ^= (long) (bb2.get(8) & 255);
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 13:
                    j17 ^= ((long) (bb2.get(12) & 255)) << 32;
                    j17 ^= ((long) (bb2.get(11) & 255)) << 24;
                    j17 ^= ((long) (bb2.get(10) & 255)) << 16;
                    j17 ^= ((long) (bb2.get(9) & 255)) << 8;
                    j17 ^= (long) (bb2.get(8) & 255);
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 14:
                    j17 ^= ((long) (bb2.get(13) & 255)) << 40;
                    j17 ^= ((long) (bb2.get(12) & 255)) << 32;
                    j17 ^= ((long) (bb2.get(11) & 255)) << 24;
                    j17 ^= ((long) (bb2.get(10) & 255)) << 16;
                    j17 ^= ((long) (bb2.get(9) & 255)) << 8;
                    j17 ^= (long) (bb2.get(8) & 255);
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                case 15:
                    j17 = ((long) (bb2.get(14) & 255)) << 48;
                    j17 ^= ((long) (bb2.get(13) & 255)) << 40;
                    j17 ^= ((long) (bb2.get(12) & 255)) << 32;
                    j17 ^= ((long) (bb2.get(11) & 255)) << 24;
                    j17 ^= ((long) (bb2.get(10) & 255)) << 16;
                    j17 ^= ((long) (bb2.get(9) & 255)) << 8;
                    j17 ^= (long) (bb2.get(8) & 255);
                    j16 = bb2.getLong();
                    this.f8382d = r(j16) ^ this.f8382d;
                    this.f8383e ^= s(j17);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        public final void p(long k10, long k11) {
            long jR = r(k10) ^ this.f8382d;
            this.f8382d = jR;
            long jRotateLeft = Long.rotateLeft(jR, 27);
            long j10 = this.f8383e;
            this.f8382d = ((jRotateLeft + j10) * 5) + 1390208809;
            long jS = s(k11) ^ j10;
            this.f8383e = jS;
            this.f8383e = ((Long.rotateLeft(jS, 31) + this.f8382d) * 5) + 944331445;
        }
    }

    public g0(int seed) {
        this.seed = seed;
    }

    @Override // j1.r
    public int bits() {
        return 128;
    }

    public boolean equals(@gm.a Object object) {
        return (object instanceof g0) && this.seed == ((g0) object).seed;
    }

    public int hashCode() {
        return this.seed ^ g0.class.hashCode();
    }

    @Override // j1.r
    public s newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return c.a.a(new StringBuilder("Hashing.murmur3_128("), this.seed, ")");
    }
}
