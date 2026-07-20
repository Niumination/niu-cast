package cr;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import jq.m0;
import nq.v1;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f3401c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3402d = 65533;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.j
    public w f3403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3404b;

    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return c.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            c.this.writeByte((byte) i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            c.this.write(bArr, i10, i11);
        }
    }

    public class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f3404b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f3404b > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            return c.this.read(bArr, i10, i11);
        }
    }

    /* JADX INFO: renamed from: cr.c$c, reason: collision with other inner class name */
    public static final class C0080c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f3407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public w f3409c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f3411e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f3410d = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3412f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3413g = -1;

        public final long b(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException(h.a.a("minByteCount <= 0: ", i10));
            }
            if (i10 > 8192) {
                throw new IllegalArgumentException(h.a.a("minByteCount > Segment.SIZE: ", i10));
            }
            c cVar = this.f3407a;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f3408b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j10 = cVar.f3404b;
            w wVarS0 = cVar.S0(i10);
            int i11 = 8192 - wVarS0.f3488c;
            wVarS0.f3488c = 8192;
            long j11 = i11;
            this.f3407a.f3404b = j10 + j11;
            this.f3409c = wVarS0;
            this.f3410d = j10;
            this.f3411e = wVarS0.f3486a;
            this.f3412f = 8192 - i11;
            this.f3413g = 8192;
            return j11;
        }

        public final int c() {
            long j10 = this.f3410d;
            if (j10 != this.f3407a.f3404b) {
                return j10 == -1 ? h(0L) : h(j10 + ((long) (this.f3413g - this.f3412f)));
            }
            throw new IllegalStateException();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f3407a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f3407a = null;
            this.f3409c = null;
            this.f3410d = -1L;
            this.f3411e = null;
            this.f3412f = -1;
            this.f3413g = -1;
        }

        public final long d(long j10) {
            c cVar = this.f3407a;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f3408b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j11 = cVar.f3404b;
            if (j10 <= j11) {
                if (j10 < 0) {
                    throw new IllegalArgumentException(h0.b.a("newSize < 0: ", j10));
                }
                long j12 = j11 - j10;
                while (j12 > 0) {
                    c cVar2 = this.f3407a;
                    w wVar = cVar2.f3403a.f3492g;
                    int i10 = wVar.f3488c;
                    long j13 = i10 - wVar.f3487b;
                    if (j13 > j12) {
                        wVar.f3488c = (int) (((long) i10) - j12);
                        break;
                    }
                    cVar2.f3403a = wVar.b();
                    x.a(wVar);
                    j12 -= j13;
                }
                this.f3409c = null;
                this.f3410d = j10;
                this.f3411e = null;
                this.f3412f = -1;
                this.f3413g = -1;
            } else if (j10 > j11) {
                long j14 = j10 - j11;
                boolean z10 = true;
                while (j14 > 0) {
                    w wVarS0 = this.f3407a.S0(1);
                    int iMin = (int) Math.min(j14, 8192 - wVarS0.f3488c);
                    int i11 = wVarS0.f3488c + iMin;
                    wVarS0.f3488c = i11;
                    j14 -= (long) iMin;
                    if (z10) {
                        this.f3409c = wVarS0;
                        this.f3410d = j11;
                        this.f3411e = wVarS0.f3486a;
                        this.f3412f = i11 - iMin;
                        this.f3413g = i11;
                        z10 = false;
                    }
                }
            }
            this.f3407a.f3404b = j10;
            return j11;
        }

        public final int h(long j10) {
            if (j10 >= -1) {
                c cVar = this.f3407a;
                long j11 = cVar.f3404b;
                if (j10 <= j11) {
                    if (j10 == -1 || j10 == j11) {
                        this.f3409c = null;
                        this.f3410d = j10;
                        this.f3411e = null;
                        this.f3412f = -1;
                        this.f3413g = -1;
                        return -1;
                    }
                    w wVar = cVar.f3403a;
                    w wVarC = this.f3409c;
                    long j12 = 0;
                    if (wVarC != null) {
                        long j13 = this.f3410d - ((long) (this.f3412f - wVarC.f3487b));
                        if (j13 > j10) {
                            j11 = j13;
                            wVarC = wVar;
                            wVar = wVarC;
                        } else {
                            j12 = j13;
                        }
                    } else {
                        wVarC = wVar;
                    }
                    if (j11 - j10 > j10 - j12) {
                        while (true) {
                            int i10 = wVarC.f3488c;
                            int i11 = wVarC.f3487b;
                            if (j10 < ((long) (i10 - i11)) + j12) {
                                break;
                            }
                            j12 += (long) (i10 - i11);
                            wVarC = wVarC.f3491f;
                        }
                    } else {
                        while (j11 > j10) {
                            wVar = wVar.f3492g;
                            j11 -= (long) (wVar.f3488c - wVar.f3487b);
                        }
                        wVarC = wVar;
                        j12 = j11;
                    }
                    if (this.f3408b && wVarC.f3489d) {
                        w wVarF = wVarC.f();
                        c cVar2 = this.f3407a;
                        if (cVar2.f3403a == wVarC) {
                            cVar2.f3403a = wVarF;
                        }
                        wVarC = wVarC.c(wVarF);
                        wVarC.f3492g.b();
                    }
                    this.f3409c = wVarC;
                    this.f3410d = j10;
                    this.f3411e = wVarC.f3486a;
                    int i12 = wVarC.f3487b + ((int) (j10 - j12));
                    this.f3412f = i12;
                    int i13 = wVarC.f3488c;
                    this.f3413g = i13;
                    return i13 - i12;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j10), Long.valueOf(this.f3407a.f3404b)));
        }
    }

    public final f A(f fVar) {
        return y("HmacSHA1", fVar);
    }

    @Override // cr.e
    public void A0(long j10) throws EOFException {
        if (this.f3404b < j10) {
            throw new EOFException();
        }
    }

    @Override // cr.d
    /* JADX INFO: renamed from: B1, reason: merged with bridge method [inline-methods] */
    public c writeByte(int i10) {
        w wVarS0 = S0(1);
        byte[] bArr = wVarS0.f3486a;
        int i11 = wVarS0.f3488c;
        wVarS0.f3488c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f3404b++;
        return this;
    }

    @Override // cr.e
    public c C() {
        return this;
    }

    @Override // cr.e
    public long D0(byte b10) {
        return L(b10, 0L, Long.MAX_VALUE);
    }

    @Override // cr.d
    /* JADX INFO: renamed from: D1, reason: merged with bridge method [inline-methods] */
    public c C0(long j10) {
        boolean z10;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return V("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 < 100000000) {
            if (j10 < 10000) {
                if (j10 >= 100) {
                    i10 = j10 < 1000 ? 3 : 4;
                } else if (j10 >= 10) {
                    i10 = 2;
                }
            } else if (j10 < v1.f11967e) {
                i10 = j10 < 100000 ? 5 : 6;
            } else {
                i10 = j10 < 10000000 ? 7 : 8;
            }
        } else if (j10 < 1000000000000L) {
            if (j10 < 10000000000L) {
                i10 = j10 < 1000000000 ? 9 : 10;
            } else {
                i10 = j10 < 100000000000L ? 11 : 12;
            }
        } else if (j10 < 1000000000000000L) {
            if (j10 < 10000000000000L) {
                i10 = 13;
            } else {
                i10 = j10 < 100000000000000L ? 14 : 15;
            }
        } else if (j10 < 100000000000000000L) {
            i10 = j10 < 10000000000000000L ? 16 : 17;
        } else {
            i10 = j10 < 1000000000000000000L ? 18 : 19;
        }
        if (z10) {
            i10++;
        }
        w wVarS0 = S0(i10);
        byte[] bArr = wVarS0.f3486a;
        int i11 = wVarS0.f3488c + i10;
        while (j10 != 0) {
            i11--;
            bArr[i11] = f3401c[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z10) {
            bArr[i11 - 1] = kk.k.f9234c;
        }
        wVarS0.f3488c += i10;
        this.f3404b += (long) i10;
        return this;
    }

    public final f E(f fVar) {
        return y("HmacSHA256", fVar);
    }

    public final f F0() {
        return p("SHA-256");
    }

    @Override // cr.d
    public long F1(a0 a0Var) throws IOException {
        if (a0Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long jY0 = a0Var.Y0(this, 8192L);
            if (jY0 == -1) {
                return j10;
            }
            j10 += jY0;
        }
    }

    @Override // cr.e
    public long G1(z zVar) throws IOException {
        long j10 = this.f3404b;
        if (j10 > 0) {
            zVar.Z0(this, j10);
        }
        return j10;
    }

    @Override // cr.e
    public long H(byte b10, long j10) {
        return L(b10, j10, Long.MAX_VALUE);
    }

    @Override // cr.e
    public int H1() {
        return d0.c(readInt());
    }

    @Override // cr.e
    public String I0(long j10) throws EOFException {
        return L1(j10, d0.f3414a);
    }

    @Override // cr.d
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public c u1(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        w wVarS0 = S0(iNumberOfTrailingZeros);
        byte[] bArr = wVarS0.f3486a;
        int i10 = wVarS0.f3488c;
        for (int i11 = (i10 + iNumberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = f3401c[(int) (15 & j10)];
            j10 >>>= 4;
        }
        wVarS0.f3488c += iNumberOfTrailingZeros;
        this.f3404b += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // cr.e
    public boolean J(long j10, f fVar) {
        return T(j10, fVar, 0, fVar.size());
    }

    public final f J0() {
        return p("SHA-512");
    }

    @Override // cr.d
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public c writeInt(int i10) {
        w wVarS0 = S0(4);
        byte[] bArr = wVarS0.f3486a;
        int i11 = wVarS0.f3488c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        wVarS0.f3488c = i11 + 4;
        this.f3404b += 4;
        return this;
    }

    @Override // cr.e
    public f K0(long j10) throws EOFException {
        return new f(n0(j10));
    }

    @Override // cr.e
    public String K1() {
        try {
            return L1(this.f3404b, d0.f3414a);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // cr.e
    public long L(byte b10, long j10, long j11) {
        w wVar;
        long j12 = 0;
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f3404b), Long.valueOf(j10), Long.valueOf(j11)));
        }
        long j13 = this.f3404b;
        long j14 = j11 > j13 ? j13 : j11;
        if (j10 == j14 || (wVar = this.f3403a) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                wVar = wVar.f3492g;
                j13 -= (long) (wVar.f3488c - wVar.f3487b);
            }
        } else {
            while (true) {
                long j15 = ((long) (wVar.f3488c - wVar.f3487b)) + j12;
                if (j15 >= j10) {
                    break;
                }
                wVar = wVar.f3491f;
                j12 = j15;
            }
            j13 = j12;
        }
        w wVar2 = wVar;
        long j16 = j10;
        while (j13 < j14) {
            byte[] bArr = wVar2.f3486a;
            int iMin = (int) Math.min(wVar2.f3488c, (((long) wVar2.f3487b) + j14) - j13);
            for (int i10 = (int) ((((long) wVar2.f3487b) + j16) - j13); i10 < iMin; i10++) {
                if (bArr[i10] == b10) {
                    return ((long) (i10 - wVar2.f3487b)) + j13;
                }
            }
            j13 += (long) (wVar2.f3488c - wVar2.f3487b);
            wVar2 = wVar2.f3491f;
            j16 = j13;
        }
        return -1L;
    }

    @Override // cr.e
    public String L1(long j10, Charset charset) throws EOFException {
        d0.b(this.f3404b, 0L, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j10 > 2147483647L) {
            throw new IllegalArgumentException(h0.b.a("byteCount > Integer.MAX_VALUE: ", j10));
        }
        if (j10 == 0) {
            return "";
        }
        w wVar = this.f3403a;
        int i10 = wVar.f3487b;
        if (((long) i10) + j10 > wVar.f3488c) {
            return new String(n0(j10), charset);
        }
        String str = new String(wVar.f3486a, i10, (int) j10, charset);
        int i11 = (int) (((long) wVar.f3487b) + j10);
        wVar.f3487b = i11;
        this.f3404b -= j10;
        if (i11 == wVar.f3488c) {
            this.f3403a = wVar.b();
            x.a(wVar);
        }
        return str;
    }

    @Override // cr.e
    @gm.j
    public String M() throws EOFException {
        long jD0 = D0((byte) 10);
        if (jD0 != -1) {
            return u0(jD0);
        }
        long j10 = this.f3404b;
        if (j10 != 0) {
            return L1(j10, d0.f3414a);
        }
        return null;
    }

    @Override // cr.d
    public d N() throws IOException {
        return this;
    }

    public final f O(f fVar) {
        return y("HmacSHA512", fVar);
    }

    public final long O0() {
        return this.f3404b;
    }

    @Override // cr.e
    public String P(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("limit < 0: ", j10));
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jL = L((byte) 10, 0L, j11);
        if (jL != -1) {
            return u0(jL);
        }
        if (j11 < this.f3404b && t(j11 - 1) == 13 && t(j11) == 10) {
            return u0(j11);
        }
        c cVar = new c();
        k(cVar, 0L, Math.min(32L, this.f3404b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f3404b, j10) + " content=" + cVar.v1().hex() + m0.F);
    }

    public final f P0() {
        long j10 = this.f3404b;
        if (j10 <= 2147483647L) {
            return Q0((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f3404b);
    }

    @Override // cr.e
    public long Q(f fVar, long j10) {
        int i10;
        int i11;
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        w wVar = this.f3403a;
        if (wVar == null) {
            return -1L;
        }
        long j12 = this.f3404b;
        if (j12 - j10 < j10) {
            while (j12 > j10) {
                wVar = wVar.f3492g;
                j12 -= (long) (wVar.f3488c - wVar.f3487b);
            }
        } else {
            while (true) {
                long j13 = ((long) (wVar.f3488c - wVar.f3487b)) + j11;
                if (j13 >= j10) {
                    break;
                }
                wVar = wVar.f3491f;
                j11 = j13;
            }
            j12 = j11;
        }
        if (fVar.size() == 2) {
            byte b10 = fVar.getByte(0);
            byte b11 = fVar.getByte(1);
            while (j12 < this.f3404b) {
                byte[] bArr = wVar.f3486a;
                i10 = (int) ((((long) wVar.f3487b) + j10) - j12);
                int i12 = wVar.f3488c;
                while (i10 < i12) {
                    byte b12 = bArr[i10];
                    if (b12 == b10 || b12 == b11) {
                        i11 = wVar.f3487b;
                        return ((long) (i10 - i11)) + j12;
                    }
                    i10++;
                }
                j12 += (long) (wVar.f3488c - wVar.f3487b);
                wVar = wVar.f3491f;
                j10 = j12;
            }
            return -1L;
        }
        byte[] bArrInternalArray = fVar.internalArray();
        while (j12 < this.f3404b) {
            byte[] bArr2 = wVar.f3486a;
            i10 = (int) ((((long) wVar.f3487b) + j10) - j12);
            int i13 = wVar.f3488c;
            while (i10 < i13) {
                byte b13 = bArr2[i10];
                for (byte b14 : bArrInternalArray) {
                    if (b13 == b14) {
                        i11 = wVar.f3487b;
                        return ((long) (i10 - i11)) + j12;
                    }
                }
                i10++;
            }
            j12 += (long) (wVar.f3488c - wVar.f3487b);
            wVar = wVar.f3491f;
            j10 = j12;
        }
        return -1L;
    }

    public final f Q0(int i10) {
        return i10 == 0 ? f.EMPTY : new y(this, i10);
    }

    public w S0(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        w wVar = this.f3403a;
        if (wVar != null) {
            w wVar2 = wVar.f3492g;
            return (wVar2.f3488c + i10 > 8192 || !wVar2.f3490e) ? wVar2.c(x.b()) : wVar2;
        }
        w wVarB = x.b();
        this.f3403a = wVarB;
        wVarB.f3492g = wVarB;
        wVarB.f3491f = wVarB;
        return wVarB;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public c a1(int i10) {
        return writeInt(d0.c(i10));
    }

    @Override // cr.e
    public boolean T(long j10, f fVar, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.f3404b - j10 < i11 || fVar.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (t(((long) i12) + j10) != fVar.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public c T1(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.write(this);
        return this;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // cr.e
    public byte[] X0() {
        try {
            return n0(this.f3404b);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // cr.a0
    public long Y0(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        long j11 = this.f3404b;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        cVar.Z0(this, j10);
        return j10;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public c writeLong(long j10) {
        w wVarS0 = S0(8);
        byte[] bArr = wVarS0.f3486a;
        int i10 = wVarS0.f3488c;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        bArr[i10 + 1] = (byte) ((j10 >>> 48) & 255);
        bArr[i10 + 2] = (byte) ((j10 >>> 40) & 255);
        bArr[i10 + 3] = (byte) ((j10 >>> 32) & 255);
        bArr[i10 + 4] = (byte) ((j10 >>> 24) & 255);
        bArr[i10 + 5] = (byte) ((j10 >>> 16) & 255);
        bArr[i10 + 6] = (byte) ((j10 >>> 8) & 255);
        bArr[i10 + 7] = (byte) (j10 & 255);
        wVarS0.f3488c = i10 + 8;
        this.f3404b += 8;
        return this;
    }

    @Override // cr.z
    public void Z0(c cVar, long j10) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        d0.b(cVar.f3404b, 0L, j10);
        while (j10 > 0) {
            w wVar = cVar.f3403a;
            if (j10 < wVar.f3488c - wVar.f3487b) {
                w wVar2 = this.f3403a;
                w wVar3 = wVar2 != null ? wVar2.f3492g : null;
                if (wVar3 != null && wVar3.f3490e) {
                    if ((((long) wVar3.f3488c) + j10) - ((long) (wVar3.f3489d ? 0 : wVar3.f3487b)) <= 8192) {
                        wVar.g(wVar3, (int) j10);
                        cVar.f3404b -= j10;
                        this.f3404b += j10;
                        return;
                    }
                }
                cVar.f3403a = wVar.e((int) j10);
            }
            w wVar4 = cVar.f3403a;
            long j11 = wVar4.f3488c - wVar4.f3487b;
            cVar.f3403a = wVar4.b();
            w wVar5 = this.f3403a;
            if (wVar5 == null) {
                this.f3403a = wVar4;
                wVar4.f3492g = wVar4;
                wVar4.f3491f = wVar4;
            } else {
                wVar5.f3492g.c(wVar4).a();
            }
            cVar.f3404b -= j11;
            this.f3404b += j11;
            j10 -= j11;
        }
    }

    @Override // cr.e
    public long Z1() {
        int i10;
        if (this.f3404b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i11 = 0;
        boolean z10 = false;
        long j10 = 0;
        do {
            w wVar = this.f3403a;
            byte[] bArr = wVar.f3486a;
            int i12 = wVar.f3487b;
            int i13 = wVar.f3488c;
            while (i12 < i13) {
                byte b10 = bArr[i12];
                if (b10 >= 48 && b10 <= 57) {
                    i10 = b10 - 48;
                } else if (b10 >= 97 && b10 <= 102) {
                    i10 = b10 - 87;
                } else {
                    if (b10 < 65 || b10 > 70) {
                        if (i11 != 0) {
                            z10 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b10));
                    }
                    i10 = b10 - 55;
                }
                if (((-1152921504606846976L) & j10) != 0) {
                    throw new NumberFormatException("Number too large: " + new c().u1(j10).writeByte(b10).K1());
                }
                j10 = (j10 << 4) | ((long) i10);
                i12++;
                i11++;
            }
            if (i12 == i13) {
                this.f3403a = wVar.b();
                x.a(wVar);
            } else {
                wVar.f3487b = i12;
            }
            if (z10) {
                break;
            }
        } while (this.f3403a != null);
        this.f3404b -= (long) i11;
        return j10;
    }

    public final void b() {
        try {
            skip(this.f3404b);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public final f b0() {
        return p("MD5");
    }

    @Override // cr.e
    public boolean b1() {
        return this.f3404b == 0;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public c x(long j10) {
        return writeLong(d0.d(j10));
    }

    @Override // cr.e, cr.d
    public c buffer() {
        return this;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = i11;
        d0.b(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            w wVarS0 = S0(1);
            int iMin = Math.min(i12 - i10, 8192 - wVarS0.f3488c);
            System.arraycopy(bArr, i10, wVarS0.f3486a, wVarS0.f3488c, iMin);
            i10 += iMin;
            wVarS0.f3488c += iMin;
        }
        this.f3404b += j10;
        return this;
    }

    @Override // cr.e
    public InputStream c2() {
        return new b();
    }

    @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.f3404b == 0) {
            return cVar;
        }
        w wVarD = this.f3403a.d();
        cVar.f3403a = wVarD;
        wVarD.f3492g = wVarD;
        wVarD.f3491f = wVarD;
        w wVar = this.f3403a;
        while (true) {
            wVar = wVar.f3491f;
            if (wVar == this.f3403a) {
                cVar.f3404b = this.f3404b;
                return cVar;
            }
            cVar.f3403a.f3492g.c(wVar.d());
        }
    }

    @Override // cr.e
    public boolean d0(long j10) {
        return this.f3404b >= j10;
    }

    @Override // cr.e
    public long d2(f fVar, long j10) throws IOException {
        if (fVar.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        w wVar = this.f3403a;
        long j12 = -1;
        if (wVar == null) {
            return -1L;
        }
        long j13 = this.f3404b;
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                wVar = wVar.f3492g;
                j13 -= (long) (wVar.f3488c - wVar.f3487b);
            }
        } else {
            while (true) {
                long j14 = ((long) (wVar.f3488c - wVar.f3487b)) + j11;
                if (j14 >= j10) {
                    break;
                }
                wVar = wVar.f3491f;
                j11 = j14;
            }
            j13 = j11;
        }
        byte b10 = fVar.getByte(0);
        int size = fVar.size();
        long j15 = 1 + (this.f3404b - ((long) size));
        long j16 = j10;
        w wVar2 = wVar;
        long j17 = j13;
        while (j17 < j15) {
            byte[] bArr = wVar2.f3486a;
            int iMin = (int) Math.min(wVar2.f3488c, (((long) wVar2.f3487b) + j15) - j17);
            int i10 = (int) ((((long) wVar2.f3487b) + j16) - j17);
            while (i10 < iMin) {
                if (bArr[i10] == b10) {
                    if (e0(wVar2, i10 + 1, fVar, 1, size)) {
                        return ((long) (i10 - wVar2.f3487b)) + j17;
                    }
                }
                i10++;
                bArr = bArr;
            }
            j17 += (long) (wVar2.f3488c - wVar2.f3487b);
            wVar2 = wVar2.f3491f;
            j16 = j17;
            j12 = -1;
        }
        return j12;
    }

    public final boolean e0(w wVar, int i10, f fVar, int i11, int i12) {
        int i13 = wVar.f3488c;
        byte[] bArr = wVar.f3486a;
        while (i11 < i12) {
            if (i10 == i13) {
                w wVar2 = wVar.f3491f;
                byte[] bArr2 = wVar2.f3486a;
                i10 = wVar2.f3487b;
                wVar = wVar2;
                i13 = wVar2.f3488c;
                bArr = bArr2;
            }
            if (bArr[i10] != fVar.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    @Override // cr.d
    public d e1(a0 a0Var, long j10) throws IOException {
        while (j10 > 0) {
            long jY0 = a0Var.Y0(this, j10);
            if (jY0 == -1) {
                throw new EOFException();
            }
            j10 -= jY0;
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j10 = this.f3404b;
        if (j10 != cVar.f3404b) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        w wVar = this.f3403a;
        w wVar2 = cVar.f3403a;
        int i10 = wVar.f3487b;
        int i11 = wVar2.f3487b;
        while (j11 < this.f3404b) {
            long jMin = Math.min(wVar.f3488c - i10, wVar2.f3488c - i11);
            int i12 = 0;
            while (i12 < jMin) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (wVar.f3486a[i10] != wVar2.f3486a[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == wVar.f3488c) {
                wVar = wVar.f3491f;
                i10 = wVar.f3487b;
            }
            if (i11 == wVar2.f3488c) {
                wVar2 = wVar2.f3491f;
                i11 = wVar2.f3487b;
            }
            j11 += jMin;
        }
        return true;
    }

    @Override // cr.a0
    public b0 f() {
        return b0.f3397d;
    }

    public final C0080c f0() {
        return g0(new C0080c());
    }

    @Override // cr.d
    /* JADX INFO: renamed from: f2, reason: merged with bridge method [inline-methods] */
    public c writeShort(int i10) {
        w wVarS0 = S0(2);
        byte[] bArr = wVarS0.f3486a;
        int i11 = wVarS0.f3488c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        wVarS0.f3488c = i11 + 2;
        this.f3404b += 2;
        return this;
    }

    @Override // cr.d, cr.z, java.io.Flushable
    public void flush() {
    }

    public final C0080c g0(C0080c c0080c) {
        if (c0080c.f3407a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        c0080c.f3407a = this;
        c0080c.f3408b = true;
        return c0080c;
    }

    @Override // cr.e
    public long g1() {
        if (this.f3404b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i10 = 0;
        boolean z10 = false;
        long j10 = -7;
        long j11 = 0;
        boolean z11 = false;
        do {
            w wVar = this.f3403a;
            byte[] bArr = wVar.f3486a;
            int i11 = wVar.f3487b;
            int i12 = wVar.f3488c;
            while (i11 < i12) {
                byte b10 = bArr[i11];
                if (b10 >= 48 && b10 <= 57) {
                    int i13 = 48 - b10;
                    if (j11 < y0.e.f20586y || (j11 == y0.e.f20586y && i13 < j10)) {
                        c cVarWriteByte = new c().C0(j11).writeByte(b10);
                        if (!z10) {
                            cVarWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + cVarWriteByte.K1());
                    }
                    j11 = (j11 * 10) + ((long) i13);
                } else {
                    if (b10 != 45 || i10 != 0) {
                        if (i10 != 0) {
                            z11 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b10));
                    }
                    j10--;
                    z10 = true;
                }
                i11++;
                i10++;
            }
            if (i11 == i12) {
                this.f3403a = wVar.b();
                x.a(wVar);
            } else {
                wVar.f3487b = i11;
            }
            if (z11) {
                break;
            }
        } while (this.f3403a != null);
        this.f3404b -= (long) i10;
        return z10 ? j11 : -j11;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: g2, reason: merged with bridge method [inline-methods] */
    public c j1(int i10) {
        return writeShort(d0.e((short) i10));
    }

    public final long h() {
        long j10 = this.f3404b;
        if (j10 == 0) {
            return 0L;
        }
        w wVar = this.f3403a.f3492g;
        int i10 = wVar.f3488c;
        return (i10 >= 8192 || !wVar.f3490e) ? j10 : j10 - ((long) (i10 - wVar.f3487b));
    }

    @Override // cr.e
    public void h1(c cVar, long j10) throws EOFException {
        long j11 = this.f3404b;
        if (j11 >= j10) {
            cVar.Z0(this, j10);
        } else {
            cVar.Z0(this, j11);
            throw new EOFException();
        }
    }

    @Override // cr.d
    /* JADX INFO: renamed from: h2, reason: merged with bridge method [inline-methods] */
    public c z0(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalAccessError(h.a.a("beginIndex < 0: ", i10));
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(e0.a.a("endIndex < beginIndex: ", i11, " < ", i10));
        }
        if (i11 > str.length()) {
            StringBuilder sbA = h.b.a("endIndex > string.length: ", i11, " > ");
            sbA.append(str.length());
            throw new IllegalArgumentException(sbA.toString());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(d0.f3414a)) {
            return c0(str, i10, i11);
        }
        byte[] bytes = str.substring(i10, i11).getBytes(charset);
        return write(bytes, 0, bytes.length);
    }

    public int hashCode() {
        w wVar = this.f3403a;
        if (wVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = wVar.f3488c;
            for (int i12 = wVar.f3487b; i12 < i11; i12++) {
                i10 = (i10 * 31) + wVar.f3486a[i12];
            }
            wVar = wVar.f3491f;
        } while (wVar != this.f3403a);
        return i10;
    }

    @Override // cr.e
    public String i0() throws EOFException {
        return P(Long.MAX_VALUE);
    }

    @Override // cr.d
    /* JADX INFO: renamed from: i2, reason: merged with bridge method [inline-methods] */
    public c w1(String str, Charset charset) {
        return z0(str, 0, str.length(), charset);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final c j0(InputStream inputStream) throws IOException {
        l0(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final c j2(OutputStream outputStream) throws IOException {
        return k2(outputStream, this.f3404b);
    }

    public final c k(c cVar, long j10, long j11) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        d0.b(this.f3404b, j10, j11);
        if (j11 == 0) {
            return this;
        }
        cVar.f3404b += j11;
        w wVar = this.f3403a;
        while (true) {
            int i10 = wVar.f3488c;
            int i11 = wVar.f3487b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= (long) (i10 - i11);
            wVar = wVar.f3491f;
        }
        while (j11 > 0) {
            w wVarD = wVar.d();
            int i12 = (int) (((long) wVarD.f3487b) + j10);
            wVarD.f3487b = i12;
            wVarD.f3488c = Math.min(i12 + ((int) j11), wVarD.f3488c);
            w wVar2 = cVar.f3403a;
            if (wVar2 == null) {
                wVarD.f3492g = wVarD;
                wVarD.f3491f = wVarD;
                cVar.f3403a = wVarD;
            } else {
                wVar2.f3492g.c(wVarD);
            }
            j11 -= (long) (wVarD.f3488c - wVarD.f3487b);
            wVar = wVar.f3491f;
            j10 = 0;
        }
        return this;
    }

    public final c k0(InputStream inputStream, long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        l0(inputStream, j10, false);
        return this;
    }

    public final c k2(OutputStream outputStream, long j10) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        d0.b(this.f3404b, 0L, j10);
        w wVar = this.f3403a;
        while (j10 > 0) {
            int iMin = (int) Math.min(j10, wVar.f3488c - wVar.f3487b);
            outputStream.write(wVar.f3486a, wVar.f3487b, iMin);
            int i10 = wVar.f3487b + iMin;
            wVar.f3487b = i10;
            long j11 = iMin;
            this.f3404b -= j11;
            j10 -= j11;
            if (i10 == wVar.f3488c) {
                w wVarB = wVar.b();
                this.f3403a = wVarB;
                x.a(wVar);
                wVar = wVarB;
            }
        }
        return this;
    }

    public final void l0(InputStream inputStream, long j10, boolean z10) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j10 <= 0 && !z10) {
                return;
            }
            w wVarS0 = S0(1);
            int i10 = inputStream.read(wVarS0.f3486a, wVarS0.f3488c, (int) Math.min(j10, 8192 - wVarS0.f3488c));
            if (i10 == -1) {
                if (wVarS0.f3487b == wVarS0.f3488c) {
                    this.f3403a = wVarS0.b();
                    x.a(wVarS0);
                }
                if (!z10) {
                    throw new EOFException();
                }
                return;
            }
            wVarS0.f3488c += i10;
            long j11 = i10;
            this.f3404b += j11;
            j10 -= j11;
        }
    }

    @Override // cr.e
    public long l1(f fVar) {
        return Q(fVar, 0L);
    }

    @Override // cr.d
    /* JADX INFO: renamed from: l2, reason: merged with bridge method [inline-methods] */
    public c V(String str) {
        return c0(str, 0, str.length());
    }

    @Override // cr.d
    /* JADX INFO: renamed from: m2, reason: merged with bridge method [inline-methods] */
    public c c0(String str, int i10, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException(h.a.a("beginIndex < 0: ", i10));
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(e0.a.a("endIndex < beginIndex: ", i11, " < ", i10));
        }
        if (i11 > str.length()) {
            StringBuilder sbA = h.b.a("endIndex > string.length: ", i11, " > ");
            sbA.append(str.length());
            throw new IllegalArgumentException(sbA.toString());
        }
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                w wVarS0 = S0(1);
                byte[] bArr = wVarS0.f3486a;
                int i12 = wVarS0.f3488c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt;
                while (i13 < iMin) {
                    char cCharAt2 = str.charAt(i13);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i13 + i12] = (byte) cCharAt2;
                    i13++;
                }
                int i14 = wVarS0.f3488c;
                int i15 = (i12 + i13) - i14;
                wVarS0.f3488c = i14 + i15;
                this.f3404b += (long) i15;
                i10 = i13;
            } else {
                if (cCharAt < 2048) {
                    writeByte((cCharAt >> 6) | 192);
                    writeByte((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    writeByte((cCharAt >> '\f') | 224);
                    writeByte(((cCharAt >> 6) & 63) | 128);
                    writeByte((cCharAt & '?') | 128);
                } else {
                    int i16 = i10 + 1;
                    char cCharAt3 = i16 < i11 ? str.charAt(i16) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        writeByte(63);
                        i10 = i16;
                    } else {
                        int i17 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        writeByte((i17 >> 18) | p5.m0.f12864d);
                        writeByte(((i17 >> 12) & 63) | 128);
                        writeByte(((i17 >> 6) & 63) | 128);
                        writeByte((i17 & 63) | 128);
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
        return this;
    }

    public final c n(OutputStream outputStream) throws IOException {
        return o(outputStream, 0L, this.f3404b);
    }

    @Override // cr.e
    public byte[] n0(long j10) throws EOFException {
        d0.b(this.f3404b, 0L, j10);
        if (j10 > 2147483647L) {
            throw new IllegalArgumentException(h0.b.a("byteCount > Integer.MAX_VALUE: ", j10));
        }
        byte[] bArr = new byte[(int) j10];
        readFully(bArr);
        return bArr;
    }

    @Override // cr.d
    /* JADX INFO: renamed from: n2, reason: merged with bridge method [inline-methods] */
    public c s(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            writeByte((i10 >> 6) | 192);
            writeByte((i10 & 63) | 128);
        } else if (i10 < 65536) {
            if (i10 < 55296 || i10 > 57343) {
                writeByte((i10 >> 12) | 224);
                writeByte(((i10 >> 6) & 63) | 128);
                writeByte((i10 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else {
            if (i10 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
            }
            writeByte((i10 >> 18) | p5.m0.f12864d);
            writeByte(((i10 >> 12) & 63) | 128);
            writeByte(((i10 >> 6) & 63) | 128);
            writeByte((i10 & 63) | 128);
        }
        return this;
    }

    public final c o(OutputStream outputStream, long j10, long j11) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        d0.b(this.f3404b, j10, j11);
        if (j11 == 0) {
            return this;
        }
        w wVar = this.f3403a;
        while (true) {
            int i10 = wVar.f3488c;
            int i11 = wVar.f3487b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= (long) (i10 - i11);
            wVar = wVar.f3491f;
        }
        while (j11 > 0) {
            int i12 = (int) (((long) wVar.f3487b) + j10);
            int iMin = (int) Math.min(wVar.f3488c - i12, j11);
            outputStream.write(wVar.f3486a, i12, iMin);
            j11 -= (long) iMin;
            wVar = wVar.f3491f;
            j10 = 0;
        }
        return this;
    }

    @Override // cr.e
    public String o1(Charset charset) {
        try {
            return L1(this.f3404b, charset);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // cr.d
    public OutputStream outputStream() {
        return new a();
    }

    public final f p(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            w wVar = this.f3403a;
            if (wVar != null) {
                byte[] bArr = wVar.f3486a;
                int i10 = wVar.f3487b;
                messageDigest.update(bArr, i10, wVar.f3488c - i10);
                w wVar2 = this.f3403a;
                while (true) {
                    wVar2 = wVar2.f3491f;
                    if (wVar2 == this.f3403a) {
                        break;
                    }
                    byte[] bArr2 = wVar2.f3486a;
                    int i11 = wVar2.f3487b;
                    messageDigest.update(bArr2, i11, wVar2.f3488c - i11);
                }
            }
            return f.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final C0080c p0() {
        return q0(new C0080c());
    }

    @Override // cr.e
    public e peek() {
        return p.d(new r(this));
    }

    public c q() {
        return this;
    }

    public final C0080c q0(C0080c c0080c) {
        if (c0080c.f3407a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        c0080c.f3407a = this;
        c0080c.f3408b = false;
        return c0080c;
    }

    @Override // cr.e
    public int q1() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (this.f3404b == 0) {
            throw new EOFException();
        }
        byte bT = t(0L);
        if ((bT & 128) == 0) {
            i10 = bT & 127;
            i12 = 0;
            i11 = 1;
        } else if ((bT & 224) == 192) {
            i10 = bT & c1.c.I;
            i11 = 2;
            i12 = 128;
        } else if ((bT & 240) == 224) {
            i10 = bT & c1.c.f1123q;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((bT & 248) != 240) {
                skip(1L);
                return f3402d;
            }
            i10 = bT & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (this.f3404b < j10) {
            StringBuilder sbA = h.b.a("size < ", i11, ": ");
            sbA.append(this.f3404b);
            sbA.append(" (to read code point prefixed 0x");
            sbA.append(Integer.toHexString(bT));
            sbA.append(")");
            throw new EOFException(sbA.toString());
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte bT2 = t(j11);
            if ((bT2 & 192) != 128) {
                skip(j11);
                return f3402d;
            }
            i10 = (i10 << 6) | (bT2 & fl.h.f6042b);
        }
        skip(j10);
        if (i10 > 1114111) {
            return f3402d;
        }
        return ((i10 < 55296 || i10 > 57343) && i10 >= i12) ? i10 : f3402d;
    }

    @Override // cr.d
    public d r() {
        return this;
    }

    @Override // cr.e
    public short r0() {
        return d0.e(readShort());
    }

    @Override // cr.e
    public int r1(q qVar) {
        int iW0 = w0(qVar, false);
        if (iW0 == -1) {
            return -1;
        }
        try {
            skip(qVar.f3453a[iW0].size());
            return iW0;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    @Override // cr.e
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // cr.e
    public byte readByte() {
        long j10 = this.f3404b;
        if (j10 == 0) {
            throw new IllegalStateException("size == 0");
        }
        w wVar = this.f3403a;
        int i10 = wVar.f3487b;
        int i11 = wVar.f3488c;
        int i12 = i10 + 1;
        byte b10 = wVar.f3486a[i10];
        this.f3404b = j10 - 1;
        if (i12 == i11) {
            this.f3403a = wVar.b();
            x.a(wVar);
        } else {
            wVar.f3487b = i12;
        }
        return b10;
    }

    @Override // cr.e
    public void readFully(byte[] bArr) throws EOFException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = read(bArr, i10, bArr.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // cr.e
    public int readInt() {
        long j10 = this.f3404b;
        if (j10 < 4) {
            throw new IllegalStateException("size < 4: " + this.f3404b);
        }
        w wVar = this.f3403a;
        int i10 = wVar.f3487b;
        int i11 = wVar.f3488c;
        if (i11 - i10 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = wVar.f3486a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.f3404b = j10 - 4;
        if (i14 == i11) {
            this.f3403a = wVar.b();
            x.a(wVar);
        } else {
            wVar.f3487b = i14;
        }
        return i15;
    }

    @Override // cr.e
    public long readLong() {
        long j10 = this.f3404b;
        if (j10 < 8) {
            throw new IllegalStateException("size < 8: " + this.f3404b);
        }
        w wVar = this.f3403a;
        int i10 = wVar.f3487b;
        int i11 = wVar.f3488c;
        if (i11 - i10 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = wVar.f3486a;
        int i12 = i10 + 7;
        long j11 = ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8);
        int i13 = i10 + 8;
        long j12 = j11 | (((long) bArr[i12]) & 255);
        this.f3404b = j10 - 8;
        if (i13 == i11) {
            this.f3403a = wVar.b();
            x.a(wVar);
        } else {
            wVar.f3487b = i13;
        }
        return j12;
    }

    @Override // cr.e
    public short readShort() {
        long j10 = this.f3404b;
        if (j10 < 2) {
            throw new IllegalStateException("size < 2: " + this.f3404b);
        }
        w wVar = this.f3403a;
        int i10 = wVar.f3487b;
        int i11 = wVar.f3488c;
        if (i11 - i10 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = wVar.f3486a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.f3404b = j10 - 2;
        if (i14 == i11) {
            this.f3403a = wVar.b();
            x.a(wVar);
        } else {
            wVar.f3487b = i14;
        }
        return (short) i15;
    }

    @Override // cr.e
    public long s0() {
        return d0.d(readLong());
    }

    @Override // cr.e
    public long s1(f fVar) throws IOException {
        return d2(fVar, 0L);
    }

    @Override // cr.e
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            w wVar = this.f3403a;
            if (wVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, wVar.f3488c - wVar.f3487b);
            long j11 = iMin;
            this.f3404b -= j11;
            j10 -= j11;
            w wVar2 = this.f3403a;
            int i10 = wVar2.f3487b + iMin;
            wVar2.f3487b = i10;
            if (i10 == wVar2.f3488c) {
                this.f3403a = wVar2.b();
                x.a(wVar2);
            }
        }
    }

    public final byte t(long j10) {
        int i10;
        d0.b(this.f3404b, j10, 1L);
        long j11 = this.f3404b;
        if (j11 - j10 <= j10) {
            long j12 = j10 - j11;
            w wVar = this.f3403a;
            do {
                wVar = wVar.f3492g;
                int i11 = wVar.f3488c;
                i10 = wVar.f3487b;
                j12 += (long) (i11 - i10);
            } while (j12 < 0);
            return wVar.f3486a[i10 + ((int) j12)];
        }
        w wVar2 = this.f3403a;
        while (true) {
            int i12 = wVar2.f3488c;
            int i13 = wVar2.f3487b;
            long j13 = i12 - i13;
            if (j10 < j13) {
                return wVar2.f3486a[i13 + ((int) j10)];
            }
            j10 -= j13;
            wVar2 = wVar2.f3491f;
        }
    }

    public String toString() {
        return P0().toString();
    }

    public String u0(long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (t(j11) == 13) {
                String strL1 = L1(j11, d0.f3414a);
                skip(2L);
                return strL1;
            }
        }
        String strL2 = L1(j10, d0.f3414a);
        skip(1L);
        return strL2;
    }

    public List<Integer> v0() {
        if (this.f3403a == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        w wVar = this.f3403a;
        arrayList.add(Integer.valueOf(wVar.f3488c - wVar.f3487b));
        w wVar2 = this.f3403a;
        while (true) {
            wVar2 = wVar2.f3491f;
            if (wVar2 == this.f3403a) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(wVar2.f3488c - wVar2.f3487b));
        }
    }

    @Override // cr.e
    public f v1() {
        return new f(X0());
    }

    public int w0(q qVar, boolean z10) {
        int i10;
        int i11;
        w wVar;
        int i12;
        int i13;
        w wVar2 = this.f3403a;
        if (wVar2 == null) {
            if (z10) {
                return -2;
            }
            return qVar.indexOf(f.EMPTY);
        }
        byte[] bArr = wVar2.f3486a;
        int i14 = wVar2.f3487b;
        int i15 = wVar2.f3488c;
        int[] iArr = qVar.f3454b;
        w wVar3 = wVar2;
        int i16 = 0;
        int i17 = -1;
        loop0: while (true) {
            int i18 = i16 + 1;
            int i19 = iArr[i16];
            int i20 = i16 + 2;
            int i21 = iArr[i18];
            if (i21 != -1) {
                i17 = i21;
            }
            if (wVar3 == null) {
                break;
            }
            if (i19 >= 0) {
                i10 = i14 + 1;
                int i22 = bArr[i14] & 255;
                int i23 = i20 + i19;
                while (i20 != i23) {
                    if (i22 == iArr[i20]) {
                        i11 = iArr[i20 + i19];
                        if (i10 == i15) {
                            wVar3 = wVar3.f3491f;
                            i10 = wVar3.f3487b;
                            bArr = wVar3.f3486a;
                            i15 = wVar3.f3488c;
                            if (wVar3 == wVar2) {
                                wVar3 = null;
                            }
                        }
                    } else {
                        i20++;
                    }
                }
                return i17;
            }
            int i24 = (i19 * (-1)) + i20;
            while (true) {
                int i25 = i14 + 1;
                int i26 = i20 + 1;
                if ((bArr[i14] & 255) != iArr[i20]) {
                    return i17;
                }
                boolean z11 = i26 == i24;
                if (i25 == i15) {
                    w wVar4 = wVar3.f3491f;
                    i13 = wVar4.f3487b;
                    byte[] bArr2 = wVar4.f3486a;
                    i12 = wVar4.f3488c;
                    if (wVar4 != wVar2) {
                        wVar = wVar4;
                        bArr = bArr2;
                    } else {
                        if (!z11) {
                            break loop0;
                        }
                        bArr = bArr2;
                        wVar = null;
                    }
                } else {
                    wVar = wVar3;
                    i12 = i15;
                    i13 = i25;
                }
                if (z11) {
                    i11 = iArr[i26];
                    i10 = i13;
                    i15 = i12;
                    wVar3 = wVar;
                    break;
                }
                i14 = i13;
                i15 = i12;
                wVar3 = wVar;
                i20 = i26;
            }
            if (i11 >= 0) {
                return i11;
            }
            i16 = -i11;
            i14 = i10;
        }
        if (z10) {
            return -2;
        }
        return i17;
    }

    public final f y(String str, f fVar) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(fVar.toByteArray(), str));
            w wVar = this.f3403a;
            if (wVar != null) {
                byte[] bArr = wVar.f3486a;
                int i10 = wVar.f3487b;
                mac.update(bArr, i10, wVar.f3488c - i10);
                w wVar2 = this.f3403a;
                while (true) {
                    wVar2 = wVar2.f3491f;
                    if (wVar2 == this.f3403a) {
                        break;
                    }
                    byte[] bArr2 = wVar2.f3486a;
                    int i11 = wVar2.f3487b;
                    mac.update(bArr2, i11, wVar2.f3488c - i11);
                }
            }
            return f.of(mac.doFinal());
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final f y0() {
        return p("SHA-1");
    }

    @Override // cr.e
    public int read(byte[] bArr, int i10, int i11) {
        d0.b(bArr.length, i10, i11);
        w wVar = this.f3403a;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(i11, wVar.f3488c - wVar.f3487b);
        System.arraycopy(wVar.f3486a, wVar.f3487b, bArr, i10, iMin);
        int i12 = wVar.f3487b + iMin;
        wVar.f3487b = i12;
        this.f3404b -= (long) iMin;
        if (i12 == wVar.f3488c) {
            this.f3403a = wVar.b();
            x.a(wVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int iRemaining = byteBuffer.remaining();
            int i10 = iRemaining;
            while (i10 > 0) {
                w wVarS0 = S0(1);
                int iMin = Math.min(i10, 8192 - wVarS0.f3488c);
                byteBuffer.get(wVarS0.f3486a, wVarS0.f3488c, iMin);
                i10 -= iMin;
                wVarS0.f3488c += iMin;
            }
            this.f3404b += (long) iRemaining;
            return iRemaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        w wVar = this.f3403a;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), wVar.f3488c - wVar.f3487b);
        byteBuffer.put(wVar.f3486a, wVar.f3487b, iMin);
        int i10 = wVar.f3487b + iMin;
        wVar.f3487b = i10;
        this.f3404b -= (long) iMin;
        if (i10 == wVar.f3488c) {
            this.f3403a = wVar.b();
            x.a(wVar);
        }
        return iMin;
    }
}
