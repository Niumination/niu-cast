package cr;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import lm.g2;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f3426f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f3427g = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f3428i = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte f3429n = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte f3430p = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final byte f3431v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte f3432w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte f3433x = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f3435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f3436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f3437d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3434a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f3438e = new CRC32();

    public l(a0 a0Var) {
        if (a0Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f3436c = inflater;
        e eVarD = p.d(a0Var);
        this.f3435b = eVarD;
        this.f3437d = new o(eVarD, inflater);
    }

    @Override // cr.a0
    public long Y0(c cVar, long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f3434a == 0) {
            c();
            this.f3434a = 1;
        }
        if (this.f3434a == 1) {
            long j11 = cVar.f3404b;
            long jY0 = this.f3437d.Y0(cVar, j10);
            if (jY0 != -1) {
                h(cVar, j11, jY0);
                return jY0;
            }
            this.f3434a = 2;
        }
        if (this.f3434a == 2) {
            d();
            this.f3434a = 3;
            if (!this.f3435b.b1()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    public final void b(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public final void c() throws IOException {
        this.f3435b.A0(10L);
        byte bT = this.f3435b.buffer().t(3L);
        boolean z10 = ((bT >> 1) & 1) == 1;
        if (z10) {
            h(this.f3435b.buffer(), 0L, 10L);
        }
        b("ID1ID2", 8075, this.f3435b.readShort());
        this.f3435b.skip(8L);
        if (((bT >> 2) & 1) == 1) {
            this.f3435b.A0(2L);
            if (z10) {
                h(this.f3435b.buffer(), 0L, 2L);
            }
            long jR0 = this.f3435b.buffer().r0() & g2.f10190d;
            this.f3435b.A0(jR0);
            if (z10) {
                h(this.f3435b.buffer(), 0L, jR0);
            }
            this.f3435b.skip(jR0);
        }
        if (((bT >> 3) & 1) == 1) {
            long jD0 = this.f3435b.D0((byte) 0);
            if (jD0 == -1) {
                throw new EOFException();
            }
            if (z10) {
                h(this.f3435b.buffer(), 0L, jD0 + 1);
            }
            this.f3435b.skip(jD0 + 1);
        }
        if (((bT >> 4) & 1) == 1) {
            long jD1 = this.f3435b.D0((byte) 0);
            if (jD1 == -1) {
                throw new EOFException();
            }
            if (z10) {
                h(this.f3435b.buffer(), 0L, jD1 + 1);
            }
            this.f3435b.skip(jD1 + 1);
        }
        if (z10) {
            b("FHCRC", this.f3435b.r0(), (short) this.f3438e.getValue());
            this.f3438e.reset();
        }
    }

    @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3437d.close();
    }

    public final void d() throws IOException {
        b("CRC", this.f3435b.H1(), (int) this.f3438e.getValue());
        b("ISIZE", this.f3435b.H1(), (int) this.f3436c.getBytesWritten());
    }

    @Override // cr.a0
    public b0 f() {
        return this.f3435b.f();
    }

    public final void h(c cVar, long j10, long j11) {
        w wVar = cVar.f3403a;
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
            this.f3438e.update(wVar.f3486a, i12, iMin);
            j11 -= (long) iMin;
            wVar = wVar.f3491f;
            j10 = 0;
        }
    }
}
