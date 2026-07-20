package j1;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public final class h0 extends c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8385a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8386b = -862048943;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8387e = 461845907;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;
    static final r MURMUR3_32 = new h0(0, false);
    static final r MURMUR3_32_FIXED = new h0(0, true);
    static final r GOOD_FAST_HASH_32 = new h0(t.f8457a, true);

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8391d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8392e = false;

        public a(int seed) {
            this.f8388a = seed;
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public s b(char c10) {
            j(2, c10);
            return this;
        }

        @Override // j1.s
        public q i() {
            c1.h0.g0(!this.f8392e);
            this.f8392e = true;
            int iG = this.f8388a ^ h0.g((int) this.f8389b);
            this.f8388a = iG;
            return h0.d(iG, this.f8391d);
        }

        public final void j(int nBytes, long update) {
            long j10 = this.f8389b;
            int i10 = this.f8390c;
            long j11 = ((update & 4294967295L) << i10) | j10;
            this.f8389b = j11;
            int i11 = (nBytes * 8) + i10;
            this.f8390c = i11;
            this.f8391d += nBytes;
            if (i11 >= 32) {
                this.f8388a = h0.f(this.f8388a, h0.g((int) j11));
                this.f8389b >>>= 32;
                this.f8390c -= 32;
            }
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public s putInt(int i10) {
            j(4, i10);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public j0 b(char c10) {
            j(2, c10);
            return this;
        }

        @Override // j1.s, j1.j0
        @t1.a
        public s c(byte b10) {
            j(1, b10 & 255);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public s e(byte[] bytes, int off, int len) {
            c1.h0.f0(off, off + len, bytes.length);
            int i10 = 0;
            while (true) {
                int i11 = i10 + 4;
                if (i11 > len) {
                    break;
                }
                j(4, h0.e(bytes, i10 + off));
                i10 = i11;
            }
            while (i10 < len) {
                c(bytes[off + i10]);
                i10++;
            }
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public s f(ByteBuffer buffer) {
            ByteOrder byteOrderOrder = buffer.order();
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            while (buffer.remaining() >= 4) {
                putInt(buffer.getInt());
            }
            while (buffer.hasRemaining()) {
                c(buffer.get());
            }
            buffer.order(byteOrderOrder);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public s g(CharSequence input, Charset charset) {
            if (!c1.f.f1179c.equals(charset)) {
                return super.g(input, charset);
            }
            int length = input.length();
            int i10 = 0;
            while (true) {
                int i11 = i10 + 4;
                if (i11 > length) {
                    break;
                }
                char cCharAt = input.charAt(i10);
                char cCharAt2 = input.charAt(i10 + 1);
                char cCharAt3 = input.charAt(i10 + 2);
                char cCharAt4 = input.charAt(i10 + 3);
                if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                    break;
                }
                j(4, (cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24));
                i10 = i11;
            }
            while (i10 < length) {
                char cCharAt5 = input.charAt(i10);
                if (cCharAt5 < 128) {
                    j(1, cCharAt5);
                } else if (cCharAt5 < 2048) {
                    j(2, h0.b(cCharAt5));
                } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                    j(3, h0.a(cCharAt5));
                } else {
                    int iCodePointAt = Character.codePointAt(input, i10);
                    if (iCodePointAt == cCharAt5) {
                        a(input.subSequence(i10, length).toString().getBytes(charset));
                        return this;
                    }
                    i10++;
                    j(4, h0.c(iCodePointAt));
                }
                i10++;
            }
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public j0 putInt(int i10) {
            j(4, i10);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        @t1.a
        public s putLong(long l10) {
            j(4, (int) l10);
            j(4, l10 >>> 32);
            return this;
        }
    }

    public h0(int seed, boolean supplementaryPlaneFix) {
        this.seed = seed;
        this.supplementaryPlaneFix = supplementaryPlaneFix;
    }

    public static long a(char c10) {
        return ((long) (c10 >>> '\f')) | 224 | ((long) ((((c10 >>> 6) & 63) | 128) << 8)) | ((long) (((c10 & '?') | 128) << 16));
    }

    public static long b(char c10) {
        return ((long) (c10 >>> 6)) | 192 | ((long) (((c10 & '?') | 128) << 8));
    }

    public static long c(int codePoint) {
        return ((long) (codePoint >>> 18)) | 240 | ((((long) ((codePoint >>> 12) & 63)) | 128) << 8) | ((((long) ((codePoint >>> 6) & 63)) | 128) << 16) | ((((long) (codePoint & 63)) | 128) << 24);
    }

    public static q d(int h10, int length) {
        int i10 = h10 ^ length;
        int i11 = (i10 ^ (i10 >>> 16)) * (-2048144789);
        int i12 = (i11 ^ (i11 >>> 13)) * (-1028477387);
        return q.fromInt(i12 ^ (i12 >>> 16));
    }

    public static int e(byte[] input, int offset) {
        return o1.l.k(input[offset + 3], input[offset + 2], input[offset + 1], input[offset]);
    }

    public static int f(int h10, int k10) {
        return (Integer.rotateLeft(h10 ^ k10, 13) * 5) - 430675100;
    }

    public static int g(int k10) {
        return Integer.rotateLeft(k10 * (-862048943), 15) * 461845907;
    }

    @Override // j1.r
    public int bits() {
        return 32;
    }

    public boolean equals(@gm.a Object object) {
        if (!(object instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) object;
        return this.seed == h0Var.seed && this.supplementaryPlaneFix == h0Var.supplementaryPlaneFix;
    }

    @Override // j1.c, j1.r
    public q hashBytes(byte[] input, int off, int len) {
        c1.h0.f0(off, off + len, input.length);
        int iF = this.seed;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i11 + 4;
            if (i12 > len) {
                break;
            }
            iF = f(iF, g(e(input, i11 + off)));
            i11 = i12;
        }
        int i13 = i11;
        int i14 = 0;
        while (i13 < len) {
            i10 ^= (input[off + i13] & 255) << i14;
            i13++;
            i14 += 8;
        }
        return d(iF ^ g(i10), len);
    }

    public int hashCode() {
        return this.seed ^ h0.class.hashCode();
    }

    @Override // j1.c, j1.r
    public q hashInt(int input) {
        return d(f(this.seed, g(input)), 4);
    }

    @Override // j1.c, j1.r
    public q hashLong(long input) {
        return d(f(f(this.seed, g((int) input)), g((int) (input >>> 32))), 8);
    }

    @Override // j1.c, j1.r
    public q hashString(CharSequence input, Charset charset) {
        if (!c1.f.f1179c.equals(charset)) {
            return hashBytes(input.toString().getBytes(charset));
        }
        int length = input.length();
        int iF = this.seed;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 4;
            if (i13 > length) {
                break;
            }
            char cCharAt = input.charAt(i11);
            char cCharAt2 = input.charAt(i11 + 1);
            char cCharAt3 = input.charAt(i11 + 2);
            char cCharAt4 = input.charAt(i11 + 3);
            if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                break;
            }
            iF = f(iF, g((cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24)));
            i12 += 4;
            i11 = i13;
        }
        long jA = 0;
        while (i11 < length) {
            char cCharAt5 = input.charAt(i11);
            if (cCharAt5 < 128) {
                jA |= ((long) cCharAt5) << i10;
                i10 += 8;
                i12++;
            } else if (cCharAt5 < 2048) {
                jA |= b(cCharAt5) << i10;
                i10 += 16;
                i12 += 2;
            } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                jA |= a(cCharAt5) << i10;
                i10 += 24;
                i12 += 3;
            } else {
                int iCodePointAt = Character.codePointAt(input, i11);
                if (iCodePointAt == cCharAt5) {
                    return hashBytes(input.toString().getBytes(charset));
                }
                i11++;
                jA |= c(iCodePointAt) << i10;
                if (this.supplementaryPlaneFix) {
                    i10 += 32;
                }
                i12 += 4;
            }
            if (i10 >= 32) {
                iF = f(iF, g((int) jA));
                jA >>>= 32;
                i10 -= 32;
            }
            i11++;
        }
        return d(g((int) jA) ^ iF, i12);
    }

    @Override // j1.c, j1.r
    public q hashUnencodedChars(CharSequence input) {
        int iG = this.seed;
        for (int i10 = 1; i10 < input.length(); i10 += 2) {
            iG = f(iG, g(input.charAt(i10 - 1) | (input.charAt(i10) << 16)));
        }
        if ((input.length() & 1) == 1) {
            iG ^= g(input.charAt(input.length() - 1));
        }
        return d(iG, input.length() * 2);
    }

    @Override // j1.r
    public s newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return c.a.a(new StringBuilder("Hashing.murmur3_32("), this.seed, ")");
    }
}
