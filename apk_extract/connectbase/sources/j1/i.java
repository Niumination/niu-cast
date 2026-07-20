package j1;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
@l
public abstract class i implements h.c {
    public static final i MURMUR128_MITZ_32 = new a("MURMUR128_MITZ_32", 0);
    public static final i MURMUR128_MITZ_64 = new i("MURMUR128_MITZ_64", 1) { // from class: j1.i.b
        public final long b(byte[] bytes) {
            return o1.n.k(bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]);
        }

        public final long d(byte[] bytes) {
            return o1.n.k(bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]);
        }

        @Override // j1.h.c
        public <T> boolean mightContain(@i0 T object, o<? super T> funnel, int numHashFunctions, c bits) {
            long jB = bits.b();
            byte[] bytesInternal = t.x().hashObject(object, funnel).getBytesInternal();
            long jB2 = b(bytesInternal);
            long jD = d(bytesInternal);
            for (int i10 = 0; i10 < numHashFunctions; i10++) {
                if (!bits.e((Long.MAX_VALUE & jB2) % jB)) {
                    return false;
                }
                jB2 += jD;
            }
            return true;
        }

        @Override // j1.h.c
        public <T> boolean put(@i0 T object, o<? super T> funnel, int numHashFunctions, c bits) {
            long jB = bits.b();
            byte[] bytesInternal = t.x().hashObject(object, funnel).getBytesInternal();
            long jB2 = b(bytesInternal);
            long jD = d(bytesInternal);
            long j10 = jB2;
            boolean zH = false;
            for (int i10 = 0; i10 < numHashFunctions; i10++) {
                zH |= bits.h((Long.MAX_VALUE & j10) % jB);
                j10 += jD;
            }
            return zH;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ i[] f8393a = a();

    public final enum a extends i {
        public a(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }

        @Override // j1.h.c
        public <T> boolean mightContain(@i0 T object, o<? super T> funnel, int numHashFunctions, c bits) {
            long jB = bits.b();
            long jAsLong = t.x().hashObject(object, funnel).asLong();
            int i10 = (int) jAsLong;
            int i11 = (int) (jAsLong >>> 32);
            for (int i12 = 1; i12 <= numHashFunctions; i12++) {
                int i13 = (i12 * i11) + i10;
                if (i13 < 0) {
                    i13 = ~i13;
                }
                if (!bits.e(((long) i13) % jB)) {
                    return false;
                }
            }
            return true;
        }

        @Override // j1.h.c
        public <T> boolean put(@i0 T object, o<? super T> funnel, int numHashFunctions, c bits) {
            long jB = bits.b();
            long jAsLong = t.x().hashObject(object, funnel).asLong();
            int i10 = (int) jAsLong;
            int i11 = (int) (jAsLong >>> 32);
            boolean zH = false;
            for (int i12 = 1; i12 <= numHashFunctions; i12++) {
                int i13 = (i12 * i11) + i10;
                if (i13 < 0) {
                    i13 = ~i13;
                }
                zH |= bits.h(((long) i13) % jB);
            }
            return zH;
        }
    }

    public i(String $enum$name, int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }

    public static /* synthetic */ i[] a() {
        return new i[]{MURMUR128_MITZ_32, MURMUR128_MITZ_64};
    }

    public static i valueOf(String name) {
        return (i) Enum.valueOf(i.class, name);
    }

    public static i[] values() {
        return (i[]) f8393a.clone();
    }

    public i(String str, int i10, a aVar) {
        super(str, i10);
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f8394c = 6;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLongArray f8395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b0 f8396b;

        public c(long bits) {
            c1.h0.e(bits > 0, "data length is zero!");
            this.f8395a = new AtomicLongArray(o1.l.d(m1.h.g(bits, 64L, RoundingMode.CEILING)));
            this.f8396b = c0.a();
        }

        public static long[] i(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = atomicLongArray.get(i10);
            }
            return jArr;
        }

        public long a() {
            return this.f8396b.sum();
        }

        public long b() {
            return ((long) this.f8395a.length()) * 64;
        }

        public c c() {
            return new c(i(this.f8395a));
        }

        public int d() {
            return this.f8395a.length();
        }

        public boolean e(long bitIndex) {
            return ((1 << ((int) bitIndex)) & this.f8395a.get((int) (bitIndex >>> 6))) != 0;
        }

        public boolean equals(@gm.a Object o10) {
            if (o10 instanceof c) {
                return Arrays.equals(i(this.f8395a), i(((c) o10).f8395a));
            }
            return false;
        }

        public void f(c other) {
            c1.h0.m(this.f8395a.length() == other.f8395a.length(), "BitArrays must be of equal length (%s != %s)", this.f8395a.length(), other.f8395a.length());
            for (int i10 = 0; i10 < this.f8395a.length(); i10++) {
                g(i10, other.f8395a.get(i10));
            }
        }

        public void g(int i10, long longValue) {
            long j10;
            long j11;
            do {
                j10 = this.f8395a.get(i10);
                j11 = j10 | longValue;
                if (j10 == j11) {
                    return;
                }
            } while (!this.f8395a.compareAndSet(i10, j10, j11));
            this.f8396b.add(Long.bitCount(j11) - Long.bitCount(j10));
        }

        public boolean h(long bitIndex) {
            long j10;
            long j11;
            if (e(bitIndex)) {
                return false;
            }
            int i10 = (int) (bitIndex >>> 6);
            long j12 = 1 << ((int) bitIndex);
            do {
                j10 = this.f8395a.get(i10);
                j11 = j10 | j12;
                if (j10 == j11) {
                    return false;
                }
            } while (!this.f8395a.compareAndSet(i10, j10, j11));
            this.f8396b.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(i(this.f8395a));
        }

        public c(long[] data) {
            c1.h0.e(data.length > 0, "data length is zero!");
            this.f8395a = new AtomicLongArray(data);
            this.f8396b = c0.a();
            long jBitCount = 0;
            for (long j10 : data) {
                jBitCount += (long) Long.bitCount(j10);
            }
            this.f8396b.add(jBitCount);
        }
    }
}
