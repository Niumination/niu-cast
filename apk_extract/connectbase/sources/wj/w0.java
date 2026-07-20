package wj;

import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes2.dex */
@hm.c
public class w0 implements Closeable {
    public static final int H = 512;
    public static final int I = 2;
    public static final int J = 35615;
    public static final int K = 10;
    public static final int L = 8;
    public static final int M = 2;
    public static final int N = 4;
    public static final int O = 8;
    public static final int P = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Inflater f19422g;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19425p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f19426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f19427w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f19416a = new w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CRC32 f19417b = new CRC32();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f19418c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f19419d = new byte[512];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f19423i = c.HEADER;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19424n = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f19428x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f19429y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f19430z = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19431a;

        static {
            int[] iArr = new int[c.values().length];
            f19431a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19431a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19431a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19431a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19431a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19431a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19431a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19431a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19431a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19431a[c.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public class b {
        public b() {
        }

        public final boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        public final int h() {
            int unsignedByte;
            w0 w0Var = w0.this;
            int i10 = w0Var.f19421f;
            int i11 = w0Var.f19420e;
            if (i10 - i11 > 0) {
                unsignedByte = w0Var.f19419d[i11] & 255;
                w0.d(w0Var, 1);
            } else {
                unsignedByte = w0Var.f19416a.readUnsignedByte();
            }
            w0.this.f19417b.update(unsignedByte);
            w0.o(w0.this, 1);
            return unsignedByte;
        }

        public final long i() {
            return ((long) j()) | (((long) j()) << 16);
        }

        public final int j() {
            return (h() << 8) | h();
        }

        public final int k() {
            w0 w0Var = w0.this;
            return w0Var.f19416a.e() + (w0Var.f19421f - w0Var.f19420e);
        }

        public final void l(int i10) {
            int i11;
            w0 w0Var = w0.this;
            int i12 = w0Var.f19421f - w0Var.f19420e;
            if (i12 > 0) {
                int iMin = Math.min(i12, i10);
                w0 w0Var2 = w0.this;
                w0Var2.f19417b.update(w0Var2.f19419d, w0Var2.f19420e, iMin);
                w0.d(w0.this, iMin);
                i11 = i10 - iMin;
            } else {
                i11 = i10;
            }
            if (i11 > 0) {
                byte[] bArr = new byte[512];
                int i13 = 0;
                while (i13 < i11) {
                    int iMin2 = Math.min(i11 - i13, 512);
                    w0.this.f19416a.p1(bArr, 0, iMin2);
                    w0.this.f19417b.update(bArr, 0, iMin2);
                    i13 += iMin2;
                }
            }
            w0.o(w0.this, i10);
        }

        public /* synthetic */ b(w0 w0Var, a aVar) {
            this();
        }
    }

    public enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    public static /* synthetic */ int d(w0 w0Var, int i10) {
        int i11 = w0Var.f19420e + i10;
        w0Var.f19420e = i11;
        return i11;
    }

    public static /* synthetic */ int o(w0 w0Var, int i10) {
        int i11 = w0Var.f19428x + i10;
        w0Var.f19428x = i11;
        return i11;
    }

    public boolean A() {
        c1.h0.h0(!this.f19424n, "GzipInflatingBuffer is closed");
        return (this.f19418c.k() == 0 && this.f19423i == c.HEADER) ? false : true;
    }

    public final int E(byte[] bArr, int i10, int i11) throws ZipException, DataFormatException {
        c1.h0.h0(this.f19422g != null, "inflater is null");
        try {
            int totalIn = this.f19422g.getTotalIn();
            int iInflate = this.f19422g.inflate(bArr, i10, i11);
            int totalIn2 = this.f19422g.getTotalIn() - totalIn;
            this.f19428x += totalIn2;
            this.f19429y += totalIn2;
            this.f19420e += totalIn2;
            this.f19417b.update(bArr, i10, iInflate);
            if (this.f19422g.finished()) {
                this.f19427w = this.f19422g.getBytesWritten() & 4294967295L;
                this.f19423i = c.TRAILER;
            } else if (this.f19422g.needsInput()) {
                this.f19423i = c.INFLATER_NEEDS_INPUT;
            }
            return iInflate;
        } catch (DataFormatException e10) {
            throw new DataFormatException("Inflater data format exception: " + e10.getMessage());
        }
    }

    public int O(byte[] bArr, int i10, int i11) throws ZipException, DataFormatException {
        boolean zQ0;
        boolean z10 = true;
        c1.h0.h0(!this.f19424n, "GzipInflatingBuffer is closed");
        int iE = 0;
        while (true) {
            zQ0 = true;
            while (true) {
                if (zQ0) {
                    int i12 = i11 - iE;
                    if (i12 > 0) {
                        switch (a.f19431a[this.f19423i.ordinal()]) {
                            case 1:
                                zQ0 = f0();
                                break;
                            case 2:
                                zQ0 = l0();
                                break;
                            case 3:
                                zQ0 = k0();
                                break;
                            case 4:
                                zQ0 = p0();
                                break;
                            case 5:
                                zQ0 = g0();
                                break;
                            case 6:
                                zQ0 = j0();
                                break;
                            case 7:
                                zQ0 = b0();
                                break;
                            case 8:
                                iE += E(bArr, i10 + iE, i12);
                                if (this.f19423i == c.TRAILER) {
                                    zQ0 = q0();
                                }
                                break;
                            case 9:
                                zQ0 = q();
                                break;
                            case 10:
                                zQ0 = q0();
                                break;
                            default:
                                throw new AssertionError("Invalid state: " + this.f19423i);
                        }
                    }
                }
            }
        }
        if (zQ0 && (this.f19423i != c.HEADER || this.f19418c.k() >= 10)) {
            z10 = false;
        }
        this.f19430z = z10;
        return iE;
    }

    public final boolean b0() {
        Inflater inflater = this.f19422g;
        if (inflater == null) {
            this.f19422g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f19417b.reset();
        int i10 = this.f19421f;
        int i11 = this.f19420e;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f19422g.setInput(this.f19419d, i11, i12);
            this.f19423i = c.INFLATING;
        } else {
            this.f19423i = c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19424n) {
            return;
        }
        this.f19424n = true;
        this.f19416a.close();
        Inflater inflater = this.f19422g;
        if (inflater != null) {
            inflater.end();
            this.f19422g = null;
        }
    }

    public boolean e0() {
        c1.h0.h0(!this.f19424n, "GzipInflatingBuffer is closed");
        return this.f19430z;
    }

    public final boolean f0() throws ZipException {
        if (this.f19418c.k() < 10) {
            return false;
        }
        if (this.f19418c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        }
        if (this.f19418c.h() != 8) {
            throw new ZipException("Unsupported compression method");
        }
        this.f19425p = this.f19418c.h();
        this.f19418c.l(6);
        this.f19423i = c.HEADER_EXTRA_LEN;
        return true;
    }

    public final boolean g0() {
        if ((this.f19425p & 16) != 16) {
            this.f19423i = c.HEADER_CRC;
            return true;
        }
        if (!this.f19418c.g()) {
            return false;
        }
        this.f19423i = c.HEADER_CRC;
        return true;
    }

    public final boolean j0() throws ZipException {
        if ((this.f19425p & 2) != 2) {
            this.f19423i = c.INITIALIZE_INFLATER;
            return true;
        }
        if (this.f19418c.k() < 2) {
            return false;
        }
        if ((((int) this.f19417b.getValue()) & 65535) != this.f19418c.j()) {
            throw new ZipException("Corrupt GZIP header");
        }
        this.f19423i = c.INITIALIZE_INFLATER;
        return true;
    }

    public final boolean k0() {
        int iK = this.f19418c.k();
        int i10 = this.f19426v;
        if (iK < i10) {
            return false;
        }
        this.f19418c.l(i10);
        this.f19423i = c.HEADER_NAME;
        return true;
    }

    public final boolean l0() {
        if ((this.f19425p & 4) != 4) {
            this.f19423i = c.HEADER_NAME;
            return true;
        }
        if (this.f19418c.k() < 2) {
            return false;
        }
        this.f19426v = this.f19418c.j();
        this.f19423i = c.HEADER_EXTRA;
        return true;
    }

    public void p(i2 i2Var) {
        c1.h0.h0(!this.f19424n, "GzipInflatingBuffer is closed");
        this.f19416a.c(i2Var);
        this.f19430z = false;
    }

    public final boolean p0() {
        if ((this.f19425p & 8) != 8) {
            this.f19423i = c.HEADER_COMMENT;
            return true;
        }
        if (!this.f19418c.g()) {
            return false;
        }
        this.f19423i = c.HEADER_COMMENT;
        return true;
    }

    public final boolean q() {
        c1.h0.h0(this.f19422g != null, "inflater is null");
        c1.h0.h0(this.f19420e == this.f19421f, "inflaterInput has unconsumed bytes");
        int iMin = Math.min(this.f19416a.e(), 512);
        if (iMin == 0) {
            return false;
        }
        this.f19420e = 0;
        this.f19421f = iMin;
        this.f19416a.p1(this.f19419d, 0, iMin);
        this.f19422g.setInput(this.f19419d, this.f19420e, iMin);
        this.f19423i = c.INFLATING;
        return true;
    }

    public final boolean q0() throws ZipException {
        if (this.f19422g != null && this.f19418c.k() <= 18) {
            this.f19422g.end();
            this.f19422g = null;
        }
        if (this.f19418c.k() < 8) {
            return false;
        }
        if (this.f19417b.getValue() != this.f19418c.i() || this.f19427w != this.f19418c.i()) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        this.f19417b.reset();
        this.f19423i = c.HEADER;
        return true;
    }

    public int t() {
        int i10 = this.f19428x;
        this.f19428x = 0;
        return i10;
    }

    public int y() {
        int i10 = this.f19429y;
        this.f19429y = 0;
        return i10;
    }
}
