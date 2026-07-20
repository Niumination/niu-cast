package wj;

import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;

/* JADX INFO: loaded from: classes2.dex */
@hm.c
public class t1 implements Closeable, b0 {
    public static final int L = 5;
    public static final int M = 1;
    public static final int N = 254;
    public static final int O = 2097152;
    public int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f19274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i3 f19276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q3 f19277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vj.z f19278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w0 f19279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f19280g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19281i;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f19284v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public w f19285w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f19287y;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f19282n = e.HEADER;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19283p = 5;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public w f19286x = new w();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f19288z = false;
    public int H = -1;
    public boolean J = false;
    public volatile boolean K = false;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19289a;

        static {
            int[] iArr = new int[e.values().length];
            f19289a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19289a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface b {
        void a(k3.a aVar);

        void b(int i10);

        void c(Throwable th2);

        void e(boolean z10);
    }

    public static class c implements k3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f19290a;

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // wj.k3.a
        @gm.j
        public InputStream next() {
            InputStream inputStream = this.f19290a;
            this.f19290a = null;
            return inputStream;
        }

        public c(InputStream inputStream) {
            this.f19290a = inputStream;
        }
    }

    public enum e {
        HEADER,
        BODY
    }

    public t1(b bVar, vj.z zVar, int i10, i3 i3Var, q3 q3Var) {
        this.f19274a = (b) c1.h0.F(bVar, "sink");
        this.f19278e = (vj.z) c1.h0.F(zVar, "decompressor");
        this.f19275b = i10;
        this.f19276c = (i3) c1.h0.F(i3Var, "statsTraceCtx");
        this.f19277d = (q3) c1.h0.F(q3Var, "transportTracer");
    }

    public final boolean A() {
        return y() || this.J;
    }

    public final boolean E() {
        w0 w0Var = this.f19279f;
        if (w0Var != null) {
            return w0Var.e0();
        }
        return this.f19286x.e() == 0;
    }

    public final void O() {
        this.f19276c.f(this.H, this.I, -1L);
        this.I = 0;
        InputStream inputStreamD = this.f19284v ? d() : q();
        this.f19285w.touch();
        this.f19285w = null;
        this.f19274a.a(new c(inputStreamD));
        this.f19282n = e.HEADER;
        this.f19283p = 5;
    }

    @Override // wj.b0
    public void b(int i10) {
        c1.h0.e(i10 > 0, "numMessages must be > 0");
        if (y()) {
            return;
        }
        this.f19287y += (long) i10;
        c();
    }

    public final void b0() {
        int unsignedByte = this.f19285w.readUnsignedByte();
        if ((unsignedByte & N) != 0) {
            vj.y2 y2VarU = vj.y2.f17562s.u("gRPC frame header malformed: reserved bits not zero");
            y2VarU.getClass();
            throw new vj.a3(y2VarU);
        }
        this.f19284v = (unsignedByte & 1) != 0;
        int i10 = this.f19285w.readInt();
        this.f19283p = i10;
        if (i10 < 0 || i10 > this.f19275b) {
            vj.y2 y2VarU2 = vj.y2.f17557n.u(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f19275b), Integer.valueOf(this.f19283p)));
            y2VarU2.getClass();
            throw new vj.a3(y2VarU2);
        }
        int i11 = this.H + 1;
        this.H = i11;
        this.f19276c.e(i11);
        this.f19277d.e();
        this.f19282n = e.BODY;
    }

    public final void c() {
        if (this.f19288z) {
            return;
        }
        this.f19288z = true;
        while (!this.K && this.f19287y > 0 && e0()) {
            try {
                int i10 = a.f19289a[this.f19282n.ordinal()];
                if (i10 == 1) {
                    b0();
                } else {
                    if (i10 != 2) {
                        throw new AssertionError("Invalid state: " + this.f19282n);
                    }
                    O();
                    this.f19287y--;
                }
            } catch (Throwable th2) {
                this.f19288z = false;
                throw th2;
            }
        }
        if (this.K) {
            close();
            this.f19288z = false;
        } else {
            if (this.J && E()) {
                close();
            }
            this.f19288z = false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, wj.b0
    public void close() {
        if (y()) {
            return;
        }
        w wVar = this.f19285w;
        boolean z10 = wVar != null && wVar.e() > 0;
        try {
            w0 w0Var = this.f19279f;
            if (w0Var != null) {
                boolean z11 = z10 || w0Var.A();
                this.f19279f.close();
                z10 = z11;
            }
            w wVar2 = this.f19286x;
            if (wVar2 != null) {
                wVar2.close();
            }
            w wVar3 = this.f19285w;
            if (wVar3 != null) {
                wVar3.close();
            }
            this.f19279f = null;
            this.f19286x = null;
            this.f19285w = null;
            this.f19274a.e(z10);
        } catch (Throwable th2) {
            this.f19279f = null;
            this.f19286x = null;
            this.f19285w = null;
            throw th2;
        }
    }

    public final InputStream d() {
        vj.z zVar = this.f19278e;
        if (zVar != vj.p.b.f17223a) {
            try {
                return new d(zVar.b(j2.c(this.f19285w, true)), this.f19275b, this.f19276c);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
        vj.y2 y2VarU = vj.y2.f17562s.u("Can't decode compressed gRPC message as compression not configured");
        y2VarU.getClass();
        throw new vj.a3(y2VarU);
    }

    public final boolean e0() throws Throwable {
        int iY;
        int i10 = 0;
        try {
            if (this.f19285w == null) {
                this.f19285w = new w();
            }
            int iT = 0;
            iY = 0;
            while (true) {
                try {
                    int iE = this.f19283p - this.f19285w.e();
                    if (iE <= 0) {
                        if (iT <= 0) {
                            return true;
                        }
                        this.f19274a.b(iT);
                        if (this.f19282n != e.BODY) {
                            return true;
                        }
                        if (this.f19279f != null) {
                            this.f19276c.h(iY);
                            this.I += iY;
                            return true;
                        }
                        this.f19276c.h(iT);
                        this.I += iT;
                        return true;
                    }
                    if (this.f19279f != null) {
                        try {
                            byte[] bArr = this.f19280g;
                            if (bArr == null || this.f19281i == bArr.length) {
                                this.f19280g = new byte[Math.min(iE, 2097152)];
                                this.f19281i = 0;
                            }
                            int iO = this.f19279f.O(this.f19280g, this.f19281i, Math.min(iE, this.f19280g.length - this.f19281i));
                            iT += this.f19279f.t();
                            iY += this.f19279f.y();
                            if (iO == 0) {
                                if (iT > 0) {
                                    this.f19274a.b(iT);
                                    if (this.f19282n == e.BODY) {
                                        if (this.f19279f != null) {
                                            this.f19276c.h(iY);
                                            this.I += iY;
                                        } else {
                                            this.f19276c.h(iT);
                                            this.I += iT;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.f19285w.c(j2.i(this.f19280g, this.f19281i, iO));
                            this.f19281i += iO;
                        } catch (IOException e10) {
                            throw new RuntimeException(e10);
                        } catch (DataFormatException e11) {
                            throw new RuntimeException(e11);
                        }
                    } else {
                        if (this.f19286x.e() == 0) {
                            if (iT > 0) {
                                this.f19274a.b(iT);
                                if (this.f19282n == e.BODY) {
                                    if (this.f19279f != null) {
                                        this.f19276c.h(iY);
                                        this.I += iY;
                                    } else {
                                        this.f19276c.h(iT);
                                        this.I += iT;
                                    }
                                }
                            }
                            return false;
                        }
                        int iMin = Math.min(iE, this.f19286x.e());
                        iT += iMin;
                        this.f19285w.c(this.f19286x.u(iMin));
                    }
                } catch (Throwable th2) {
                    int i11 = iT;
                    th = th2;
                    i10 = i11;
                    if (i10 > 0) {
                        this.f19274a.b(i10);
                        if (this.f19282n == e.BODY) {
                            if (this.f19279f != null) {
                                this.f19276c.h(iY);
                                this.I += iY;
                            } else {
                                this.f19276c.h(i10);
                                this.I += i10;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            iY = 0;
        }
    }

    public void f0(b bVar) {
        this.f19274a = bVar;
    }

    public void g0() {
        this.K = true;
    }

    @Override // wj.b0
    public void h(int i10) {
        this.f19275b = i10;
    }

    @Override // wj.b0
    public void k(vj.z zVar) {
        c1.h0.h0(this.f19279f == null, "Already set full stream decompressor");
        this.f19278e = (vj.z) c1.h0.F(zVar, "Can't pass an empty decompressor");
    }

    @Override // wj.b0
    public void n(i2 i2Var) throws Throwable {
        c1.h0.F(i2Var, "data");
        boolean z10 = true;
        try {
            if (A()) {
                i2Var.close();
                return;
            }
            w0 w0Var = this.f19279f;
            if (w0Var != null) {
                w0Var.p(i2Var);
            } else {
                this.f19286x.c(i2Var);
            }
            try {
                c();
            } catch (Throwable th2) {
                th = th2;
                z10 = false;
                if (z10) {
                    i2Var.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // wj.b0
    public void o(w0 w0Var) {
        c1.h0.h0(this.f19278e == vj.p.b.f17223a, "per-message decompressor already set");
        c1.h0.h0(this.f19279f == null, "full stream decompressor already set");
        this.f19279f = (w0) c1.h0.F(w0Var, "Can't pass a null full stream decompressor");
        this.f19286x = null;
    }

    @Override // wj.b0
    public void p() {
        if (y()) {
            return;
        }
        if (E()) {
            close();
        } else {
            this.J = true;
        }
    }

    public final InputStream q() {
        this.f19276c.g(this.f19285w.e());
        return j2.c(this.f19285w, true);
    }

    public boolean t() {
        return this.f19287y != 0;
    }

    public boolean y() {
        return this.f19286x == null && this.f19279f == null;
    }

    @b1.e
    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i3 f19292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f19293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f19295e;

        public d(InputStream inputStream, int i10, i3 i3Var) {
            super(inputStream);
            this.f19295e = -1L;
            this.f19291a = i10;
            this.f19292b = i3Var;
        }

        public final void b() {
            long j10 = this.f19294d;
            long j11 = this.f19293c;
            if (j10 > j11) {
                this.f19292b.g(j10 - j11);
                this.f19293c = this.f19294d;
            }
        }

        public final void c() {
            if (this.f19294d <= this.f19291a) {
                return;
            }
            vj.y2 y2VarU = vj.y2.f17557n.u("Decompressed gRPC message exceeds maximum size " + this.f19291a);
            y2VarU.getClass();
            throw new vj.a3(y2VarU);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            ((FilterInputStream) this).in.mark(i10);
            this.f19295e = this.f19294d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 != -1) {
                this.f19294d++;
            }
            c();
            b();
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f19295e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f19294d = this.f19295e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j10);
            this.f19294d += jSkip;
            c();
            b();
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (i12 != -1) {
                this.f19294d += (long) i12;
            }
            c();
            b();
            return i12;
        }
    }
}
