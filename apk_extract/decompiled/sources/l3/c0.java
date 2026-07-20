package l3;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends u {
    public static final Logger e = Logger.getLogger(c0.class.getName());
    public static final boolean f = x2.e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l1 f7207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f7208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7210d;

    public c0(byte[] bArr, int i8) {
        int length = bArr.length;
        if (((length - i8) | i8) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i8)));
        }
        this.f7208b = bArr;
        this.f7210d = 0;
        this.f7209c = i8;
    }

    public static int n(int i8, q1 q1Var, f2 f2Var) {
        int iB = ((q) q1Var).b(f2Var);
        int iQ = q(i8 << 3);
        return iQ + iQ + iB;
    }

    public static int o(int i8) {
        if (i8 >= 0) {
            return q(i8);
        }
        return 10;
    }

    public static int p(String str) {
        int length;
        try {
            length = z2.c(str);
        } catch (y2 unused) {
            length = str.getBytes(z0.f7328a).length;
        }
        return q(length) + length;
    }

    public static int q(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int r(long j8) {
        int i8;
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (j8 < 0) {
            return 10;
        }
        if (((-34359738368L) & j8) != 0) {
            j8 >>>= 28;
            i8 = 6;
        } else {
            i8 = 2;
        }
        if (((-2097152) & j8) != 0) {
            j8 >>>= 14;
            i8 += 2;
        }
        return (j8 & (-16384)) != 0 ? i8 + 1 : i8;
    }

    public final void a(byte b9) {
        try {
            byte[] bArr = this.f7208b;
            int i8 = this.f7210d;
            this.f7210d = i8 + 1;
            bArr[i8] = b9;
        } catch (IndexOutOfBoundsException e4) {
            throw new d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7210d), Integer.valueOf(this.f7209c), 1), e4);
        }
    }

    public final void b(byte[] bArr, int i8, int i9) throws d0 {
        try {
            System.arraycopy(bArr, i8, this.f7208b, this.f7210d, i9);
            this.f7210d += i9;
        } catch (IndexOutOfBoundsException e4) {
            throw new d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7210d), Integer.valueOf(this.f7209c), Integer.valueOf(i9)), e4);
        }
    }

    public final void c(int i8, b0 b0Var) {
        k((i8 << 3) | 2);
        k(b0Var.zzd());
        b0Var.zzm(this);
    }

    public final void d(int i8, int i9) {
        k((i8 << 3) | 5);
        e(i9);
    }

    public final void e(int i8) throws d0 {
        try {
            byte[] bArr = this.f7208b;
            int i9 = this.f7210d;
            int i10 = i9 + 1;
            this.f7210d = i10;
            bArr[i9] = (byte) (i8 & 255);
            int i11 = i9 + 2;
            this.f7210d = i11;
            bArr[i10] = (byte) ((i8 >> 8) & 255);
            int i12 = i9 + 3;
            this.f7210d = i12;
            bArr[i11] = (byte) ((i8 >> 16) & 255);
            this.f7210d = i9 + 4;
            bArr[i12] = (byte) ((i8 >> 24) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7210d), Integer.valueOf(this.f7209c), 1), e4);
        }
    }

    public final void f(int i8, long j8) {
        k((i8 << 3) | 1);
        g(j8);
    }

    public final void g(long j8) throws d0 {
        try {
            byte[] bArr = this.f7208b;
            int i8 = this.f7210d;
            int i9 = i8 + 1;
            this.f7210d = i9;
            bArr[i8] = (byte) (((int) j8) & 255);
            int i10 = i8 + 2;
            this.f7210d = i10;
            bArr[i9] = (byte) (((int) (j8 >> 8)) & 255);
            int i11 = i8 + 3;
            this.f7210d = i11;
            bArr[i10] = (byte) (((int) (j8 >> 16)) & 255);
            int i12 = i8 + 4;
            this.f7210d = i12;
            bArr[i11] = (byte) (((int) (j8 >> 24)) & 255);
            int i13 = i8 + 5;
            this.f7210d = i13;
            bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
            int i14 = i8 + 6;
            this.f7210d = i14;
            bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
            int i15 = i8 + 7;
            this.f7210d = i15;
            bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
            this.f7210d = i8 + 8;
            bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e4) {
            throw new d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7210d), Integer.valueOf(this.f7209c), 1), e4);
        }
    }

    public final void h(int i8, String str) throws d0 {
        k((i8 << 3) | 2);
        int i9 = this.f7210d;
        try {
            int iQ = q(str.length() * 3);
            int iQ2 = q(str.length());
            byte[] bArr = this.f7208b;
            int i10 = this.f7209c;
            if (iQ2 == iQ) {
                int i11 = i9 + iQ2;
                this.f7210d = i11;
                int iB = z2.b(str, i11, i10 - i11, bArr);
                this.f7210d = i9;
                k((iB - i9) - iQ2);
                this.f7210d = iB;
            } else {
                k(z2.c(str));
                int i12 = this.f7210d;
                this.f7210d = z2.b(str, i12, i10 - i12, bArr);
            }
        } catch (IndexOutOfBoundsException e4) {
            throw new d0(e4);
        } catch (y2 e10) {
            this.f7210d = i9;
            e.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e10);
            byte[] bytes = str.getBytes(z0.f7328a);
            try {
                int length = bytes.length;
                k(length);
                b(bytes, 0, length);
            } catch (IndexOutOfBoundsException e11) {
                throw new d0(e11);
            }
        }
    }

    public final void i(int i8, int i9) {
        k((i8 << 3) | i9);
    }

    public final void j(int i8, int i9) {
        k(i8 << 3);
        k(i9);
    }

    public final void k(int i8) {
        while (true) {
            int i9 = i8 & (-128);
            byte[] bArr = this.f7208b;
            if (i9 == 0) {
                int i10 = this.f7210d;
                this.f7210d = i10 + 1;
                bArr[i10] = (byte) i8;
                return;
            } else {
                try {
                    int i11 = this.f7210d;
                    this.f7210d = i11 + 1;
                    bArr[i11] = (byte) ((i8 & 127) | 128);
                    i8 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7210d), Integer.valueOf(this.f7209c), 1), e4);
                }
            }
            throw new d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7210d), Integer.valueOf(this.f7209c), 1), e4);
        }
    }

    public final void l(int i8, long j8) {
        k(i8 << 3);
        m(j8);
    }

    public final void m(long j8) {
        byte[] bArr = this.f7208b;
        boolean z2 = f;
        int i8 = this.f7209c;
        if (!z2 || i8 - this.f7210d < 10) {
            while ((j8 & (-128)) != 0) {
                try {
                    int i9 = this.f7210d;
                    this.f7210d = i9 + 1;
                    bArr[i9] = (byte) ((((int) j8) & 127) | 128);
                    j8 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7210d), Integer.valueOf(i8), 1), e4);
                }
            }
            int i10 = this.f7210d;
            this.f7210d = i10 + 1;
            bArr[i10] = (byte) j8;
            return;
        }
        while ((j8 & (-128)) != 0) {
            int i11 = this.f7210d;
            this.f7210d = i11 + 1;
            x2.f7322c.d(bArr, x2.f + ((long) i11), (byte) ((((int) j8) & 127) | 128));
            j8 >>>= 7;
        }
        int i12 = this.f7210d;
        this.f7210d = i12 + 1;
        x2.f7322c.d(bArr, x2.f + ((long) i12), (byte) j8);
    }
}
