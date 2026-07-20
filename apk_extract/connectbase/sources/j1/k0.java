package j1;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public final class k0 extends c implements Serializable {
    static final r SIP_HASH_24 = new k0(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8410d;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final long f8411k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private final long f8412k1;

    public static final class a extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f8413l = 8;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f8415e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8416f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8417g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f8418h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f8419i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f8420j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f8421k;

        public a(int c10, int d10, long k10, long k11) {
            super(8, 8);
            this.f8420j = 0L;
            this.f8421k = 0L;
            this.f8414d = c10;
            this.f8415e = d10;
            this.f8416f = 8317987319222330741L ^ k10;
            this.f8417g = 7237128888997146477L ^ k11;
            this.f8418h = 7816392313619706465L ^ k10;
            this.f8419i = 8387220255154660723L ^ k11;
        }

        @Override // j1.f
        public q j() {
            long j10 = this.f8421k ^ (this.f8420j << 56);
            this.f8421k = j10;
            p(j10);
            this.f8418h ^= 255;
            q(this.f8415e);
            return q.fromLong(((this.f8416f ^ this.f8417g) ^ this.f8418h) ^ this.f8419i);
        }

        @Override // j1.f
        public void m(ByteBuffer buffer) {
            this.f8420j += 8;
            p(buffer.getLong());
        }

        @Override // j1.f
        public void n(ByteBuffer buffer) {
            this.f8420j += (long) buffer.remaining();
            int i10 = 0;
            while (buffer.hasRemaining()) {
                this.f8421k ^= (((long) buffer.get()) & 255) << i10;
                i10 += 8;
            }
        }

        public final void p(long m10) {
            this.f8419i ^= m10;
            q(this.f8414d);
            this.f8416f = m10 ^ this.f8416f;
        }

        public final void q(int iterations) {
            for (int i10 = 0; i10 < iterations; i10++) {
                long j10 = this.f8416f;
                long j11 = this.f8417g;
                this.f8416f = j10 + j11;
                this.f8418h += this.f8419i;
                this.f8417g = Long.rotateLeft(j11, 13);
                long jRotateLeft = Long.rotateLeft(this.f8419i, 16);
                long j12 = this.f8417g;
                long j13 = this.f8416f;
                this.f8417g = j12 ^ j13;
                this.f8419i = jRotateLeft ^ this.f8418h;
                long jRotateLeft2 = Long.rotateLeft(j13, 32);
                long j14 = this.f8418h;
                long j15 = this.f8417g;
                this.f8418h = j14 + j15;
                this.f8416f = jRotateLeft2 + this.f8419i;
                this.f8417g = Long.rotateLeft(j15, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f8419i, 21);
                long j16 = this.f8417g;
                long j17 = this.f8418h;
                this.f8417g = j16 ^ j17;
                this.f8419i = jRotateLeft3 ^ this.f8416f;
                this.f8418h = Long.rotateLeft(j17, 32);
            }
        }
    }

    public k0(int c10, int d10, long k10, long k11) {
        c1.h0.k(c10 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", c10);
        c1.h0.k(d10 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", d10);
        this.f8409c = c10;
        this.f8410d = d10;
        this.f8411k0 = k10;
        this.f8412k1 = k11;
    }

    @Override // j1.r
    public int bits() {
        return 64;
    }

    public boolean equals(@gm.a Object object) {
        if (!(object instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) object;
        return this.f8409c == k0Var.f8409c && this.f8410d == k0Var.f8410d && this.f8411k0 == k0Var.f8411k0 && this.f8412k1 == k0Var.f8412k1;
    }

    public int hashCode() {
        return (int) ((((long) ((k0.class.hashCode() ^ this.f8409c) ^ this.f8410d)) ^ this.f8411k0) ^ this.f8412k1);
    }

    @Override // j1.r
    public s newHasher() {
        return new a(this.f8409c, this.f8410d, this.f8411k0, this.f8412k1);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Hashing.sipHash");
        sb2.append(this.f8409c);
        sb2.append("");
        sb2.append(this.f8410d);
        sb2.append("(");
        sb2.append(this.f8411k0);
        sb2.append(", ");
        return k.d.a(sb2, this.f8412k1, ")");
    }
}
