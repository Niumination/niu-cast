package j1;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
@l
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8457a = (int) System.currentTimeMillis();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @t1.j
    public static abstract class b implements x<Checksum> {
        public final r hashFunction;
        public static final b CRC_32 = new a("CRC_32", 0, "Hashing.crc32()");
        public static final b ADLER_32 = new C0223b("ADLER_32", 1, "Hashing.adler32()");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b[] f8458a = a();

        public final enum a extends b {
            public a(String $enum$name, int $enum$ordinal, String toString) {
                super($enum$name, $enum$ordinal, toString);
            }

            @Override // c1.q0
            public Checksum get() {
                return new CRC32();
            }
        }

        /* JADX INFO: renamed from: j1.t$b$b, reason: collision with other inner class name */
        public final enum C0223b extends b {
            public C0223b(String $enum$name, int $enum$ordinal, String toString) {
                super($enum$name, $enum$ordinal, toString);
            }

            @Override // c1.q0
            public Checksum get() {
                return new Adler32();
            }
        }

        public static /* synthetic */ b[] a() {
            return new b[]{CRC_32, ADLER_32};
        }

        public static b valueOf(String name) {
            return (b) Enum.valueOf(b.class, name);
        }

        public static b[] values() {
            return (b[]) f8458a.clone();
        }

        public b(String $enum$name, int $enum$ordinal, String toString) {
            super($enum$name, $enum$ordinal);
            this.hashFunction = new j(this, 32, toString);
        }
    }

    public static final class c extends j1.b {
        @Override // j1.b
        public q b(s[] hashers) {
            byte[] bArr = new byte[bits() / 8];
            int iWriteBytesTo = 0;
            for (s sVar : hashers) {
                q qVarI = sVar.i();
                iWriteBytesTo += qVarI.writeBytesTo(bArr, iWriteBytesTo, qVarI.bits() / 8);
            }
            return q.fromBytesNoCopy(bArr);
        }

        @Override // j1.r
        public int bits() {
            int iBits = 0;
            for (r rVar : this.f8360a) {
                iBits += rVar.bits();
            }
            return iBits;
        }

        public boolean equals(@gm.a Object object) {
            if (object instanceof c) {
                return Arrays.equals(this.f8360a, ((c) object).f8360a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f8360a);
        }

        public c(r... functions) {
            super(functions);
            for (r rVar : functions) {
                c1.h0.o(rVar.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", rVar.bits(), rVar);
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8459a;

        public d(long seed) {
            this.f8459a = seed;
        }

        public double a() {
            long j10 = (this.f8459a * 2862933555777941757L) + 1;
            this.f8459a = j10;
            return ((double) (((int) (j10 >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f8460a = new f0("MD5", "Hashing.md5()");
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f8461a = new f0("SHA-1", "Hashing.sha1()");
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f8462a = new f0("SHA-256", "Hashing.sha256()");
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f8463a = new f0("SHA-384", "Hashing.sha384()");
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f8464a = new f0("SHA-512", "Hashing.sha512()");
    }

    @Deprecated
    public static r A(int seed) {
        return new h0(seed, false);
    }

    public static r B() {
        return h0.MURMUR3_32_FIXED;
    }

    public static r C(int seed) {
        return new h0(seed, true);
    }

    @Deprecated
    public static r D() {
        return f.f8461a;
    }

    public static r E() {
        return g.f8462a;
    }

    public static r F() {
        return h.f8463a;
    }

    public static r G() {
        return i.f8464a;
    }

    public static r H() {
        return k0.SIP_HASH_24;
    }

    public static r I(long k10, long k11) {
        return new k0(2, 4, k10, k11);
    }

    public static r a() {
        return b.ADLER_32.hashFunction;
    }

    public static int b(int bits) {
        c1.h0.e(bits > 0, "Number of bits must be positive");
        return (bits + 31) & (-32);
    }

    public static q c(Iterable<q> hashCodes) {
        Iterator<q> it = hashCodes.iterator();
        c1.h0.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iBits = it.next().bits() / 8;
        byte[] bArr = new byte[iBits];
        Iterator<q> it2 = hashCodes.iterator();
        while (it2.hasNext()) {
            byte[] bArrAsBytes = it2.next().asBytes();
            c1.h0.e(bArrAsBytes.length == iBits, "All hashcodes must have the same bit length.");
            for (int i10 = 0; i10 < bArrAsBytes.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] * 37) ^ bArrAsBytes[i10]);
            }
        }
        return q.fromBytesNoCopy(bArr);
    }

    public static q d(Iterable<q> hashCodes) {
        Iterator<q> it = hashCodes.iterator();
        c1.h0.e(it.hasNext(), "Must be at least 1 hash code to combine.");
        int iBits = it.next().bits() / 8;
        byte[] bArr = new byte[iBits];
        Iterator<q> it2 = hashCodes.iterator();
        while (it2.hasNext()) {
            byte[] bArrAsBytes = it2.next().asBytes();
            c1.h0.e(bArrAsBytes.length == iBits, "All hashcodes must have the same bit length.");
            for (int i10 = 0; i10 < bArrAsBytes.length; i10++) {
                bArr[i10] = (byte) (bArr[i10] + bArrAsBytes[i10]);
            }
        }
        return q.fromBytesNoCopy(bArr);
    }

    public static r e(r first, r second, r... rest) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(first);
        arrayList.add(second);
        Collections.addAll(arrayList, rest);
        return new c((r[]) arrayList.toArray(new r[0]));
    }

    public static r f(Iterable<r> hashFunctions) {
        hashFunctions.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator<r> it = hashFunctions.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        c1.h0.k(!arrayList.isEmpty(), "number of hash functions (%s) must be > 0", arrayList.size());
        return new c((r[]) arrayList.toArray(new r[0]));
    }

    public static int g(long input, int buckets) {
        int i10 = 0;
        c1.h0.k(buckets > 0, "buckets must be positive: %s", buckets);
        d dVar = new d(input);
        while (true) {
            int iA = (int) (((double) (i10 + 1)) / dVar.a());
            if (iA < 0 || iA >= buckets) {
                break;
            }
            i10 = iA;
        }
        return i10;
    }

    public static int h(q hashCode, int buckets) {
        return g(hashCode.padToLong(), buckets);
    }

    public static r i() {
        return b.CRC_32.hashFunction;
    }

    public static r j() {
        return k.f8399a;
    }

    public static r k() {
        return m.f8442a;
    }

    public static r l() {
        return n.f8446a;
    }

    public static r m(int minimumBits) {
        int iB = b(minimumBits);
        if (iB == 32) {
            return h0.GOOD_FAST_HASH_32;
        }
        if (iB <= 128) {
            return g0.GOOD_FAST_HASH_128;
        }
        int i10 = (iB + 127) / 128;
        r[] rVarArr = new r[i10];
        rVarArr[0] = g0.GOOD_FAST_HASH_128;
        int i11 = f8457a;
        for (int i12 = 1; i12 < i10; i12++) {
            i11 += 1500450271;
            rVarArr[i12] = new g0(i11);
        }
        return new c(rVarArr);
    }

    public static r n(Key key) {
        return new e0("HmacMD5", key, v("hmacMd5", key));
    }

    public static r o(byte[] key) {
        key.getClass();
        return n(new SecretKeySpec(key, "HmacMD5"));
    }

    public static r p(Key key) {
        return new e0("HmacSHA1", key, v("hmacSha1", key));
    }

    public static r q(byte[] key) {
        key.getClass();
        return p(new SecretKeySpec(key, "HmacSHA1"));
    }

    public static r r(Key key) {
        return new e0("HmacSHA256", key, v("hmacSha256", key));
    }

    public static r s(byte[] key) {
        key.getClass();
        return r(new SecretKeySpec(key, "HmacSHA256"));
    }

    public static r t(Key key) {
        return new e0("HmacSHA512", key, v("hmacSha512", key));
    }

    public static r u(byte[] key) {
        key.getClass();
        return t(new SecretKeySpec(key, "HmacSHA512"));
    }

    public static String v(String methodName, Key key) {
        StringBuilder sbA = e.a.a("Hashing.", methodName, "(Key[algorithm=");
        sbA.append(key.getAlgorithm());
        sbA.append(", format=");
        sbA.append(key.getFormat());
        sbA.append("])");
        return sbA.toString();
    }

    @Deprecated
    public static r w() {
        return e.f8460a;
    }

    public static r x() {
        return g0.MURMUR3_128;
    }

    public static r y(int seed) {
        return new g0(seed);
    }

    @Deprecated
    public static r z() {
        return h0.MURMUR3_32;
    }
}
