package fp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f6210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InputStream f6215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f6223n;

    public interface a {
        void onRefill();
    }

    public e(InputStream inputStream) {
        this.f6217h = false;
        this.f6219j = Integer.MAX_VALUE;
        this.f6221l = 64;
        this.f6222m = oa.e.f12145r;
        this.f6223n = null;
        this.f6210a = new byte[4096];
        this.f6212c = 0;
        this.f6214e = 0;
        this.f6218i = 0;
        this.f6215f = inputStream;
        this.f6211b = false;
    }

    public static int B(int i10, InputStream inputStream) throws IOException {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & 127;
        int i12 = 7;
        while (i12 < 32) {
            int i13 = inputStream.read();
            if (i13 == -1) {
                throw k.truncatedMessage();
            }
            i11 |= (i13 & 127) << i12;
            if ((i13 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        while (i12 < 64) {
            int i14 = inputStream.read();
            if (i14 == -1) {
                throw k.truncatedMessage();
            }
            if ((i14 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        throw k.malformedVarint();
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static e g(p pVar) {
        e eVar = new e(pVar);
        try {
            eVar.j(pVar.size());
            return eVar;
        } catch (k e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static e h(InputStream inputStream) {
        return new e(inputStream);
    }

    public int A() throws IOException {
        int i10;
        int i11 = this.f6214e;
        int i12 = this.f6212c;
        if (i12 != i11) {
            byte[] bArr = this.f6210a;
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f6214e = i13;
                return b10;
            }
            if (i12 - i13 >= 9) {
                int i14 = i11 + 2;
                int i15 = (bArr[i13] << 7) ^ b10;
                long j10 = i15;
                if (j10 < 0) {
                    i10 = (int) ((-128) ^ j10);
                } else {
                    int i16 = i11 + 3;
                    int i17 = (bArr[i14] << c1.c.f1122p) ^ i15;
                    long j11 = i17;
                    if (j11 >= 0) {
                        i10 = (int) (16256 ^ j11);
                    } else {
                        int i18 = i11 + 4;
                        int i19 = i17 ^ (bArr[i16] << c1.c.f1131y);
                        long j12 = i19;
                        if (j12 < 0) {
                            i10 = (int) ((-2080896) ^ j12);
                        } else {
                            i16 = i11 + 5;
                            byte b11 = bArr[i18];
                            int i20 = (int) (((long) (i19 ^ (b11 << c1.c.F))) ^ 266354560);
                            if (b11 < 0) {
                                i18 = i11 + 6;
                                if (bArr[i16] < 0) {
                                    i16 = i11 + 7;
                                    if (bArr[i18] < 0) {
                                        i18 = i11 + 8;
                                        if (bArr[i16] < 0) {
                                            i16 = i11 + 9;
                                            if (bArr[i18] < 0) {
                                                int i21 = i11 + 10;
                                                if (bArr[i16] >= 0) {
                                                    i14 = i21;
                                                    i10 = i20;
                                                }
                                            }
                                        }
                                    }
                                }
                                i10 = i20;
                            }
                            i10 = i20;
                        }
                        i14 = i18;
                    }
                    i14 = i16;
                }
                this.f6214e = i14;
                return i10;
            }
        }
        return (int) D();
    }

    public long C() throws IOException {
        long j10;
        long j11;
        long j12;
        int i10 = this.f6214e;
        int i11 = this.f6212c;
        if (i11 != i10) {
            byte[] bArr = this.f6210a;
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f6214e = i12;
                return b10;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                long j13 = (bArr[i12] << 7) ^ b10;
                if (j13 >= 0) {
                    int i14 = i10 + 3;
                    long j14 = j13 ^ ((long) (bArr[i13] << c1.c.f1122p));
                    if (j14 >= 0) {
                        j12 = 16256;
                    } else {
                        i13 = i10 + 4;
                        j13 = j14 ^ ((long) (bArr[i14] << c1.c.f1131y));
                        if (j13 < 0) {
                            j11 = -2080896;
                        } else {
                            i14 = i10 + 5;
                            j14 = j13 ^ (((long) bArr[i13]) << 28);
                            if (j14 >= 0) {
                                j12 = 266354560;
                            } else {
                                i13 = i10 + 6;
                                j13 = j14 ^ (((long) bArr[i14]) << 35);
                                if (j13 >= 0) {
                                    i14 = i10 + 7;
                                    j14 = j13 ^ (((long) bArr[i13]) << 42);
                                    if (j14 >= 0) {
                                        j12 = 4363953127296L;
                                    } else {
                                        i13 = i10 + 8;
                                        j13 = j14 ^ (((long) bArr[i14]) << 49);
                                        if (j13 < 0) {
                                            j11 = -558586000294016L;
                                        } else {
                                            i14 = i10 + 9;
                                            long j15 = (j13 ^ (((long) bArr[i13]) << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                i13 = i10 + 10;
                                                if (bArr[i14] >= 0) {
                                                    j10 = j15;
                                                }
                                            } else {
                                                j10 = j15;
                                                i13 = i14;
                                            }
                                        }
                                    }
                                    this.f6214e = i13;
                                    return j10;
                                }
                                j11 = -34093383808L;
                            }
                        }
                    }
                    j10 = j14 ^ j12;
                    i13 = i14;
                    this.f6214e = i13;
                    return j10;
                }
                j11 = -128;
                j10 = j13 ^ j11;
                this.f6214e = i13;
                return j10;
            }
        }
        return D();
    }

    public long D() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            byte bW = w();
            j10 |= ((long) (bW & 127)) << i10;
            if ((bW & 128) == 0) {
                return j10;
            }
        }
        throw k.malformedVarint();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int iA = A();
        int i10 = this.f6212c;
        int i11 = this.f6214e;
        if (iA > i10 - i11 || iA <= 0) {
            return iA == 0 ? "" : new String(x(iA), "UTF-8");
        }
        String str = new String(this.f6210a, i11, iA, "UTF-8");
        this.f6214e += iA;
        return str;
    }

    public String J() throws IOException {
        byte[] bArrX;
        int iA = A();
        int i10 = this.f6214e;
        if (iA <= this.f6212c - i10 && iA > 0) {
            bArrX = this.f6210a;
            this.f6214e = i10 + iA;
        } else {
            if (iA == 0) {
                return "";
            }
            bArrX = x(iA);
            i10 = 0;
        }
        if (y.f(bArrX, i10, i10 + iA)) {
            return new String(bArrX, i10, iA, "UTF-8");
        }
        throw k.invalidUtf8();
    }

    public int K() throws IOException {
        if (f()) {
            this.f6216g = 0;
            return 0;
        }
        int iA = A();
        this.f6216g = iA;
        if (z.a(iA) != 0) {
            return this.f6216g;
        }
        throw k.invalidTag();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public final void N() {
        int i10 = this.f6212c + this.f6213d;
        this.f6212c = i10;
        int i11 = this.f6218i + i10;
        int i12 = this.f6219j;
        if (i11 <= i12) {
            this.f6213d = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f6213d = i13;
        this.f6212c = i10 - i13;
    }

    public final void O(int i10) throws IOException {
        if (!T(i10)) {
            throw k.truncatedMessage();
        }
    }

    public boolean P(int i10, f fVar) throws IOException {
        int iB = z.b(i10);
        if (iB == 0) {
            long jC = C();
            fVar.o0(i10);
            fVar.p0(jC);
            return true;
        }
        if (iB == 1) {
            long jZ = z();
            fVar.o0(i10);
            fVar.n0(jZ);
            return true;
        }
        if (iB == 2) {
            d dVarL = l();
            fVar.o0(i10);
            fVar.P(dVarL);
            return true;
        }
        if (iB == 3) {
            fVar.o0(i10);
            Q(fVar);
            int i11 = ((i10 >>> 3) << 3) | 4;
            a(i11);
            fVar.o0(i11);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw k.invalidWireType();
        }
        int iY = y();
        fVar.o0(i10);
        fVar.m0(iY);
        return true;
    }

    public void Q(f fVar) throws IOException {
        int iK;
        do {
            iK = K();
            if (iK == 0) {
                return;
            }
        } while (P(iK, fVar));
    }

    public void R(int i10) throws IOException {
        int i11 = this.f6212c;
        int i12 = this.f6214e;
        if (i10 > i11 - i12 || i10 < 0) {
            S(i10);
        } else {
            this.f6214e = i12 + i10;
        }
    }

    public final void S(int i10) throws IOException {
        if (i10 < 0) {
            throw k.negativeSize();
        }
        int i11 = this.f6218i;
        int i12 = this.f6214e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f6219j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw k.truncatedMessage();
        }
        int i15 = this.f6212c;
        int i16 = i15 - i12;
        this.f6214e = i15;
        O(1);
        while (true) {
            int i17 = i10 - i16;
            int i18 = this.f6212c;
            if (i17 <= i18) {
                this.f6214e = i17;
                return;
            } else {
                i16 += i18;
                this.f6214e = i18;
                O(1);
            }
        }
    }

    public final boolean T(int i10) throws IOException {
        int i11 = this.f6214e;
        if (i11 + i10 <= this.f6212c) {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i10);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
        if (this.f6218i + i11 + i10 > this.f6219j) {
            return false;
        }
        a aVar = this.f6223n;
        if (aVar != null) {
            aVar.onRefill();
        }
        if (this.f6215f != null) {
            int i12 = this.f6214e;
            if (i12 > 0) {
                int i13 = this.f6212c;
                if (i13 > i12) {
                    byte[] bArr = this.f6210a;
                    System.arraycopy(bArr, i12, bArr, 0, i13 - i12);
                }
                this.f6218i += i12;
                this.f6212c -= i12;
                this.f6214e = 0;
            }
            InputStream inputStream = this.f6215f;
            byte[] bArr2 = this.f6210a;
            int i14 = this.f6212c;
            int i15 = inputStream.read(bArr2, i14, bArr2.length - i14);
            if (i15 == 0 || i15 < -1 || i15 > this.f6210a.length) {
                StringBuilder sb3 = new StringBuilder(102);
                sb3.append("InputStream#read(byte[]) returned invalid result: ");
                sb3.append(i15);
                sb3.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb3.toString());
            }
            if (i15 > 0) {
                this.f6212c += i15;
                if ((this.f6218i + i10) - this.f6222m > 0) {
                    throw k.sizeLimitExceeded();
                }
                N();
                if (this.f6212c >= i10) {
                    return true;
                }
                return T(i10);
            }
        }
        return false;
    }

    public void a(int i10) throws k {
        if (this.f6216g != i10) {
            throw k.invalidEndTag();
        }
    }

    public final void d(int i10) throws IOException {
        if (this.f6212c - this.f6214e < i10) {
            O(i10);
        }
    }

    public int e() {
        int i10 = this.f6219j;
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10 - (this.f6218i + this.f6214e);
    }

    public boolean f() throws IOException {
        return this.f6214e == this.f6212c && !T(1);
    }

    public void i(int i10) {
        this.f6219j = i10;
        N();
    }

    public int j(int i10) throws k {
        if (i10 < 0) {
            throw k.negativeSize();
        }
        int i11 = this.f6218i + this.f6214e + i10;
        int i12 = this.f6219j;
        if (i11 > i12) {
            throw k.truncatedMessage();
        }
        this.f6219j = i11;
        N();
        return i12;
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public d l() throws IOException {
        int iA = A();
        int i10 = this.f6212c;
        int i11 = this.f6214e;
        if (iA > i10 - i11 || iA <= 0) {
            return iA == 0 ? d.f6202a : new p(x(iA));
        }
        d cVar = (this.f6211b && this.f6217h) ? new c(this.f6210a, this.f6214e, iA) : d.f(this.f6210a, i11, iA);
        this.f6214e += iA;
        return cVar;
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i10, q.a aVar, g gVar) throws IOException {
        int i11 = this.f6220k;
        if (i11 >= this.f6221l) {
            throw k.recursionLimitExceeded();
        }
        this.f6220k = i11 + 1;
        aVar.c(this, gVar);
        a(z.c(i10, 4));
        this.f6220k--;
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends q> T u(s<T> sVar, g gVar) throws IOException {
        int iA = A();
        if (this.f6220k >= this.f6221l) {
            throw k.recursionLimitExceeded();
        }
        int iJ = j(iA);
        this.f6220k++;
        T tC = sVar.c(this, gVar);
        a(0);
        this.f6220k--;
        i(iJ);
        return tC;
    }

    public void v(q.a aVar, g gVar) throws IOException {
        int iA = A();
        if (this.f6220k >= this.f6221l) {
            throw k.recursionLimitExceeded();
        }
        int iJ = j(iA);
        this.f6220k++;
        aVar.c(this, gVar);
        a(0);
        this.f6220k--;
        i(iJ);
    }

    public byte w() throws IOException {
        if (this.f6214e == this.f6212c) {
            O(1);
        }
        byte[] bArr = this.f6210a;
        int i10 = this.f6214e;
        this.f6214e = i10 + 1;
        return bArr[i10];
    }

    public final byte[] x(int i10) throws IOException {
        if (i10 <= 0) {
            if (i10 == 0) {
                return j.f6259a;
            }
            throw k.negativeSize();
        }
        int i11 = this.f6218i;
        int i12 = this.f6214e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f6219j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw k.truncatedMessage();
        }
        if (i10 < 4096) {
            byte[] bArr = new byte[i10];
            int i15 = this.f6212c - i12;
            System.arraycopy(this.f6210a, i12, bArr, 0, i15);
            this.f6214e = this.f6212c;
            int i16 = i10 - i15;
            d(i16);
            System.arraycopy(this.f6210a, 0, bArr, i15, i16);
            this.f6214e = i16;
            return bArr;
        }
        int i17 = this.f6212c;
        this.f6218i = i11 + i17;
        this.f6214e = 0;
        this.f6212c = 0;
        int length = i17 - i12;
        int i18 = i10 - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i18 > 0) {
            int iMin = Math.min(i18, 4096);
            byte[] bArr2 = new byte[iMin];
            int i19 = 0;
            while (i19 < iMin) {
                InputStream inputStream = this.f6215f;
                int i20 = inputStream == null ? -1 : inputStream.read(bArr2, i19, iMin - i19);
                if (i20 == -1) {
                    throw k.truncatedMessage();
                }
                this.f6218i += i20;
                i19 += i20;
            }
            i18 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(this.f6210a, i12, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    public int y() throws IOException {
        int i10 = this.f6214e;
        if (this.f6212c - i10 < 4) {
            O(4);
            i10 = this.f6214e;
        }
        byte[] bArr = this.f6210a;
        this.f6214e = i10 + 4;
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
    }

    public long z() throws IOException {
        int i10 = this.f6214e;
        if (this.f6212c - i10 < 8) {
            O(8);
            i10 = this.f6214e;
        }
        byte[] bArr = this.f6210a;
        this.f6214e = i10 + 8;
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    public e(p pVar) {
        this.f6217h = false;
        this.f6219j = Integer.MAX_VALUE;
        this.f6221l = 64;
        this.f6222m = oa.e.f12145r;
        this.f6223n = null;
        this.f6210a = pVar.f6270c;
        int iB = pVar.B();
        this.f6214e = iB;
        this.f6212c = pVar.size() + iB;
        this.f6218i = -this.f6214e;
        this.f6215f = null;
        this.f6211b = true;
    }
}
