package wj;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class u1 implements t0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19307n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f19308o = 5;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte f19309p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte f19310q = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f19311a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r3 f19313c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s3 f19318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i3 f19319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19321k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f19323m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19312b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vj.s f19314d = vj.p.b.f17223a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19315e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f19316f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f19317g = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19322l = -1;

    public interface d {
        void w(@gm.j r3 r3Var, boolean z10, boolean z11, int i10);
    }

    public u1(d dVar, s3 s3Var, i3 i3Var) {
        this.f19311a = (d) c1.h0.F(dVar, "sink");
        this.f19318h = (s3) c1.h0.F(s3Var, "bufferAllocator");
        this.f19319i = (i3) c1.h0.F(i3Var, "statsTraceCtx");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int r(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof vj.c0) {
            return ((vj.c0) inputStream).b(outputStream);
        }
        long jB = l1.h.b(inputStream, outputStream);
        c1.h0.p(jB <= 2147483647L, "Message size overflow: %s", jB);
        return (int) jB;
    }

    public final void c(boolean z10, boolean z11) {
        r3 r3Var = this.f19313c;
        this.f19313c = null;
        this.f19311a.w(r3Var, z10, z11, this.f19321k);
        this.f19321k = 0;
    }

    @Override // wj.t0
    public void close() {
        if (g()) {
            return;
        }
        this.f19320j = true;
        r3 r3Var = this.f19313c;
        if (r3Var != null && r3Var.e() == 0) {
            j();
        }
        c(true, true);
    }

    public final int d(InputStream inputStream) throws IOException {
        if ((inputStream instanceof vj.n1) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    @Override // wj.t0
    public void dispose() {
        this.f19320j = true;
        j();
    }

    @Override // wj.t0
    public void flush() {
        r3 r3Var = this.f19313c;
        if (r3Var == null || r3Var.e() <= 0) {
            return;
        }
        c(false, true);
    }

    @Override // wj.t0
    public boolean g() {
        return this.f19320j;
    }

    @Override // wj.t0
    public void h(InputStream inputStream) {
        m();
        this.f19321k++;
        int i10 = this.f19322l + 1;
        this.f19322l = i10;
        this.f19323m = 0L;
        this.f19319i.k(i10);
        boolean z10 = this.f19315e && this.f19314d != vj.p.b.f17223a;
        try {
            int iD = d(inputStream);
            int iS = (iD == 0 || !z10) ? s(inputStream, iD) : o(inputStream, iD);
            if (iD != -1 && iS != iD) {
                vj.y2 y2VarU = vj.y2.f17562s.u(String.format("Message length inaccurate %s != %s", Integer.valueOf(iS), Integer.valueOf(iD)));
                y2VarU.getClass();
                throw new vj.a3(y2VarU);
            }
            long j10 = iS;
            this.f19319i.m(j10);
            this.f19319i.n(this.f19323m);
            this.f19319i.l(this.f19322l, this.f19323m, j10);
        } catch (IOException e10) {
            vj.y2 y2VarT = vj.y2.f17562s.u("Failed to frame message").t(e10);
            y2VarT.getClass();
            throw new vj.a3(y2VarT);
        } catch (vj.a3 e11) {
            throw e11;
        } catch (RuntimeException e12) {
            vj.y2 y2VarT2 = vj.y2.f17562s.u("Failed to frame message").t(e12);
            y2VarT2.getClass();
            throw new vj.a3(y2VarT2);
        }
    }

    @Override // wj.t0
    public void i(int i10) {
        c1.h0.h0(this.f19312b == -1, "max size already set");
        this.f19312b = i10;
    }

    public final void j() {
        r3 r3Var = this.f19313c;
        if (r3Var != null) {
            r3Var.release();
            this.f19313c = null;
        }
    }

    @Override // wj.t0
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public u1 f(vj.s sVar) {
        this.f19314d = (vj.s) c1.h0.F(sVar, "Can't pass an empty compressor");
        return this;
    }

    @Override // wj.t0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public u1 e(boolean z10) {
        this.f19315e = z10;
        return this;
    }

    public final void m() {
        if (g()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void n(b bVar, boolean z10) {
        int iE = bVar.e();
        int i10 = this.f19312b;
        if (i10 >= 0 && iE > i10) {
            vj.y2 y2VarU = vj.y2.f17557n.u(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iE), Integer.valueOf(this.f19312b)));
            y2VarU.getClass();
            throw new vj.a3(y2VarU);
        }
        this.f19317g.clear();
        this.f19317g.put(z10 ? (byte) 1 : (byte) 0).putInt(iE);
        r3 r3VarA = this.f19318h.a(5);
        r3VarA.write(this.f19317g.array(), 0, this.f19317g.position());
        if (iE == 0) {
            this.f19313c = r3VarA;
            return;
        }
        this.f19311a.w(r3VarA, false, false, this.f19321k - 1);
        this.f19321k = 1;
        List<r3> list = bVar.f19324a;
        for (int i11 = 0; i11 < list.size() - 1; i11++) {
            this.f19311a.w(list.get(i11), false, false, 0);
        }
        this.f19313c = list.get(list.size() - 1);
        this.f19323m = iE;
    }

    public final int o(InputStream inputStream, int i10) throws IOException {
        b bVar = new b();
        OutputStream outputStreamC = this.f19314d.c(bVar);
        try {
            int iR = r(inputStream, outputStreamC);
            outputStreamC.close();
            int i11 = this.f19312b;
            if (i11 < 0 || iR <= i11) {
                n(bVar, true);
                return iR;
            }
            vj.y2 y2VarU = vj.y2.f17557n.u(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iR), Integer.valueOf(this.f19312b)));
            y2VarU.getClass();
            throw new vj.a3(y2VarU);
        } catch (Throwable th2) {
            outputStreamC.close();
            throw th2;
        }
    }

    public final int p(InputStream inputStream, int i10) throws IOException {
        int i11 = this.f19312b;
        if (i11 >= 0 && i10 > i11) {
            vj.y2 y2VarU = vj.y2.f17557n.u(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i10), Integer.valueOf(this.f19312b)));
            y2VarU.getClass();
            throw new vj.a3(y2VarU);
        }
        this.f19317g.clear();
        this.f19317g.put((byte) 0).putInt(i10);
        if (this.f19313c == null) {
            this.f19313c = this.f19318h.a(this.f19317g.position() + i10);
        }
        q(this.f19317g.array(), 0, this.f19317g.position());
        return r(inputStream, this.f19316f);
    }

    public final void q(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            r3 r3Var = this.f19313c;
            if (r3Var != null && r3Var.a() == 0) {
                c(false, false);
            }
            if (this.f19313c == null) {
                this.f19313c = this.f19318h.a(i11);
            }
            int iMin = Math.min(i11, this.f19313c.a());
            this.f19313c.write(bArr, i10, iMin);
            i10 += iMin;
            i11 -= iMin;
        }
    }

    public final int s(InputStream inputStream, int i10) throws IOException {
        if (i10 != -1) {
            this.f19323m = i10;
            return p(inputStream, i10);
        }
        b bVar = new b();
        int iR = r(inputStream, bVar);
        n(bVar, false);
        return iR;
    }

    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            write(new byte[]{(byte) i10}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            u1.this.q(bArr, i10, i11);
        }
    }

    public final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<r3> f19324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r3 f19325b;

        public b() {
            this.f19324a = new ArrayList();
        }

        public final int e() {
            Iterator<r3> it = this.f19324a.iterator();
            int iE = 0;
            while (it.hasNext()) {
                iE += it.next().e();
            }
            return iE;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            r3 r3Var = this.f19325b;
            if (r3Var == null || r3Var.a() <= 0) {
                write(new byte[]{(byte) i10}, 0, 1);
            } else {
                this.f19325b.b((byte) i10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            if (this.f19325b == null) {
                r3 r3VarA = u1.this.f19318h.a(i11);
                this.f19325b = r3VarA;
                this.f19324a.add(r3VarA);
            }
            while (i11 > 0) {
                int iMin = Math.min(i11, this.f19325b.a());
                if (iMin == 0) {
                    r3 r3VarA2 = u1.this.f19318h.a(Math.max(i11, this.f19325b.e() * 2));
                    this.f19325b = r3VarA2;
                    this.f19324a.add(r3VarA2);
                } else {
                    this.f19325b.write(bArr, i10, iMin);
                    i10 += iMin;
                    i11 -= iMin;
                }
            }
        }
    }
}
