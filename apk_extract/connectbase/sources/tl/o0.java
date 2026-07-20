package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharsetDecoder;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(message = "Use ChunkBuffer instead.", replaceWith = @lm.a1(expression = "ChunkBuffer", imports = {"io.ktor.utils.io.core.ChunkBuffer"}))
public final class o0 extends ul.b implements g0, q0 {

    @os.l
    public static final c H = new c();
    public static final int I = dm.a.a("buffer.size", 4096);
    public static final int J;
    public static final int K;

    @os.l
    public static final o0 L;

    @os.l
    public static final bm.h<o0> M;

    @os.l
    public static final bm.h<o0> N;

    @os.l
    public static final bm.h<o0> O;

    public static final class a extends bm.g<o0> {
        @Override // bm.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public o0 W0() {
            ByteBuffer byteBufferAllocate = o0.K == 0 ? ByteBuffer.allocate(o0.I) : ByteBuffer.allocateDirect(o0.I);
            kn.l0.o(byteBufferAllocate, "buffer");
            return new o0(byteBufferAllocate);
        }
    }

    public static final class b extends bm.d<o0> {

        public static final class a extends ul.h {
            @Override // ul.h
            @os.l
            public Void a() {
                throw new IllegalArgumentException("Buffer is not yet released but tried to recycle");
            }
        }

        /* JADX INFO: renamed from: tl.o0$b$b, reason: collision with other inner class name */
        public static final class C0409b extends ul.h {
            @Override // ul.h
            @os.l
            public Void a() {
                throw new IllegalArgumentException("Unable to recycle buffer view, only origin buffers are applicable");
            }
        }

        public b(int i10) {
            super(i10);
        }

        @Override // bm.d
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public void h(@os.l o0 o0Var) {
            kn.l0.p(o0Var, "instance");
            o0Var.n2();
        }

        @Override // bm.d
        @os.l
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public o0 n() {
            ByteBuffer byteBufferAllocate = o0.K == 0 ? ByteBuffer.allocate(o0.I) : ByteBuffer.allocateDirect(o0.I);
            kn.l0.o(byteBufferAllocate, "buffer");
            return new o0(byteBufferAllocate);
        }

        @Override // bm.d
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public void t(@os.l o0 o0Var) {
            kn.l0.p(o0Var, "instance");
            if (!(o0Var.i2() == 0)) {
                new a().a();
                throw new lm.y();
            }
            if (o0Var.g2() == null) {
                return;
            }
            new C0409b().a();
            throw new lm.y();
        }

        @Override // bm.d
        @os.l
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public o0 d(@os.l o0 o0Var) {
            kn.l0.p(o0Var, "instance");
            o0Var.o2();
            o0Var.reset();
            return o0Var;
        }
    }

    public static final class c {
        public c() {
        }

        @ul.d
        public static /* synthetic */ void f() {
        }

        @os.l
        public final o0 a() {
            return o0.L;
        }

        @os.l
        public final bm.h<o0> b() {
            return o0.O;
        }

        @os.l
        public final bm.h<o0> c() {
            return o0.N;
        }

        @os.l
        public final bm.h<o0> d() {
            return o0.M;
        }

        public final int e() {
            return 8;
        }

        public c(kn.w wVar) {
        }
    }

    public static final class d extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15878b;

        public d(int i10, int i11) {
            this.f15877a = i10;
            this.f15878b = i11;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("size " + this.f15877a + " is greater than buffer's remaining capacity " + this.f15878b);
        }
    }

    static {
        int iA = dm.a.a("buffer.pool.size", 100);
        J = iA;
        K = dm.a.a("buffer.pool.direct", 0);
        ql.f.f14043b.getClass();
        ByteBuffer byteBuffer = ql.f.f14044c;
        e0 e0Var = e0.f15828a;
        L = new o0(byteBuffer, (ul.b) null, e0Var);
        M = new b(iA);
        N = new a();
        O = e0Var;
    }

    public o0(ByteBuffer byteBuffer, ul.b bVar) {
        this(byteBuffer, bVar, (bm.h<o0>) null);
    }

    @lm.k(message = "")
    @lm.z0
    public static /* synthetic */ void B2() {
    }

    @lm.k(message = "")
    @lm.z0
    public static /* synthetic */ void D2() {
    }

    public static /* synthetic */ int L2(o0 o0Var, CharsetDecoder charsetDecoder, Appendable appendable, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return o0Var.K2(charsetDecoder, appendable, z10, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "All read operations are big endian by default except functions with LittleEndian suffix. Read/write with readXXXLittleEndian/writeXXXLittleEndian or do readXXX/writeXXX with X.reverseByteOrder() instead.")
    public static /* synthetic */ void y2() {
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int A1(o0 o0Var) {
        kn.l0.p(o0Var, "buffer");
        return l0.c(this, o0Var, 0, 0, 0, 14, null);
    }

    @os.l
    public final ByteBuffer A2() {
        ByteBuffer byteBuffer = this.f15820a;
        m mVar = this.f15821b;
        int i10 = mVar.f15873b;
        return ql.i.j(byteBuffer, i10, mVar.f15874c - i10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public /* synthetic */ void B(ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "bb");
        k.b(this, byteBuffer);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void C1(o0 o0Var, int i10) {
        kn.l0.p(o0Var, "dst");
        l.E(this, o0Var, i10);
    }

    @os.l
    public final ByteBuffer C2() {
        ByteBuffer byteBuffer = this.f15820a;
        m mVar = this.f15821b;
        int i10 = mVar.f15874c;
        return ql.i.j(byteBuffer, i10, mVar.f15872a - i10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void E0(int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "dst");
        l.I(this, iArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ boolean E2() {
        return ul.c.a(this);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void F(long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "src");
        l.B0(this, jArr, i10, i11);
    }

    @Override // tl.g0
    public final int G() {
        return T0();
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void G2(int i10) {
        y0(i10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int H0(o0 o0Var, int i10) {
        kn.l0.p(o0Var, "dst");
        return l.b(this, o0Var, i10);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void H2(ByteBuffer byteBuffer, int i10) {
        kn.l0.p(byteBuffer, "dst");
        p0.d(this, byteBuffer, i10);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void I2(byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "dst");
        l.F(this, bArr, i10, i11);
    }

    public final int J2(@os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(lVar, "block");
        m mVar = this.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        ByteBuffer byteBufferDuplicate = this.f15820a.duplicate();
        kn.l0.m(byteBufferDuplicate);
        byteBufferDuplicate.limit(i11);
        byteBufferDuplicate.position(i10);
        lVar.invoke(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() - i10;
        if (iPosition < 0) {
            xl.a.b(iPosition);
            throw new lm.y();
        }
        if (byteBufferDuplicate.limit() == i11) {
            d(iPosition);
            return iPosition;
        }
        xl.a.a();
        throw new lm.y();
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int K2(CharsetDecoder charsetDecoder, Appendable appendable, boolean z10, int i10) {
        kn.l0.p(charsetDecoder, "decoder");
        kn.l0.p(appendable, "out");
        return g.s(this, charsetDecoder, appendable, z10, i10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int L0(ByteBuffer byteBuffer, int i10) {
        kn.l0.p(byteBuffer, "dst");
        return p0.a(this, byteBuffer, i10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void M0(short s10) {
        l.X0(this, s10);
    }

    @ul.d
    public final void M2(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "child");
        w0(byteBuffer.limit());
        c(byteBuffer.position());
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void N0(short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "dst");
        l.K(this, sArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void N2(o0 o0Var) {
        l2(o0Var);
    }

    @lm.k(level = lm.m.ERROR, message = "")
    public final void O2(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "$noName_0");
        throw new lm.j0(null, 1, null);
    }

    public final void P2(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "$noName_0");
        throw new lm.j0(null, 1, null);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void Q2(ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "src");
        k.b(this, byteBuffer);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void R(long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "dst");
        l.J(this, jArr, i10, i11);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void R0(byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "src");
        l.x0(this, bArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ int R2(o0 o0Var, int i10) {
        kn.l0.p(o0Var, "src");
        l.w0(this, o0Var, i10);
        return i10;
    }

    public final int S2(int i10, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(lVar, "block");
        m mVar = this.f15821b;
        int i11 = mVar.f15872a - mVar.f15874c;
        if (!(i10 <= i11)) {
            new d(i10, i11).a();
            throw new lm.y();
        }
        ByteBuffer byteBufferDuplicate = this.f15820a.duplicate();
        kn.l0.m(byteBufferDuplicate);
        m mVar2 = this.f15821b;
        int i12 = mVar2.f15874c;
        byteBufferDuplicate.limit(mVar2.f15872a);
        byteBufferDuplicate.position(i12);
        lVar.invoke(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() - i12;
        if (iPosition < 0 || iPosition > i11) {
            xl.a.c(iPosition, i10);
            throw new lm.y();
        }
        b(iPosition);
        return iPosition;
    }

    @Override // tl.g0
    public final long V0(@os.l ByteBuffer byteBuffer, long j10, long j11, long j12, long j13) {
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        return n.h(this, byteBuffer, j10, j11, j12, j13);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void V1(double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "src");
        l.y0(this, dArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int W(int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "dst");
        return l.f(this, iArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int W1(byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "dst");
        return l.c(this, bArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void X1(float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "dst");
        l.H(this, fArr, i10, i11);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void Y(o0 o0Var, int i10) {
        kn.l0.p(o0Var, "src");
        l.w0(this, o0Var, i10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void a0(long j10, byte b10) {
        g.i(this, j10, b10);
    }

    @Override // java.lang.Appendable
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ Appendable append(CharSequence charSequence, int i10, int i11) {
        g.c(this, charSequence, i10, i11);
        return this;
    }

    @Override // tl.g0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("close for buffer view is not supported");
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ Appendable f1(char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "csq");
        if (g.f(this, cArr, i10, i11) == i11) {
            return this;
        }
        throw new IllegalStateException("Not enough free space to append char sequence");
    }

    @Override // tl.q0
    public final void flush() {
    }

    @Override // tl.g0
    public final void g(@os.l q qVar) {
        kn.l0.p(qVar, "value");
        if (qVar != q.BIG_ENDIAN) {
            throw new UnsupportedOperationException("Only BIG_ENDIAN is supported");
        }
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void h0(float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "src");
        l.z0(this, fArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int i1(float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "dst");
        return l.e(this, fArr, i10, i11);
    }

    @Override // tl.g0
    @os.l
    public final q j() {
        q.a aVar = q.Companion;
        ByteOrder byteOrderOrder = A2().order();
        kn.l0.o(byteOrderOrder, "readBuffer.order()");
        return aVar.b(byteOrderOrder);
    }

    @Override // ul.b
    public final void j2(@os.l bm.h<o0> hVar) {
        kn.l0.p(hVar, "pool");
        n.m(this, hVar);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void m0(double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "dst");
        l.G(this, dArr, i10, i11);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void m1(short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "src");
        l.C0(this, sArr, i10, i11);
    }

    @Override // tl.g0
    /* JADX INFO: renamed from: n1 */
    public boolean B1() {
        m mVar = this.f15821b;
        return !(mVar.f15874c > mVar.f15873b);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ double readDouble() {
        return m0.a(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ float readFloat() {
        return m0.c(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "dst");
        l.F(this, bArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readInt() {
        return m0.e(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ long readLong() {
        return m0.g(this);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ short readShort() {
        return m0.k(this);
    }

    @lm.z0
    public final void s2() {
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int t0(long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "dst");
        return l.g(this, jArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int t2(CharSequence charSequence, int i10, int i11) {
        kn.l0.p(charSequence, "csq");
        return g.e(this, charSequence, i10, i11);
    }

    @Override // tl.e
    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Buffer[readable = ");
        m mVar = this.f15821b;
        sb2.append(mVar.f15874c - mVar.f15873b);
        sb2.append(", writable = ");
        m mVar2 = this.f15821b;
        sb2.append(mVar2.f15872a - mVar2.f15874c);
        sb2.append(", startGap = ");
        sb2.append(this.f15821b.f15875d);
        sb2.append(", endGap = ");
        sb2.append(this.f15822c - this.f15821b.f15872a);
        sb2.append(']');
        return sb2.toString();
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int u2(char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "csq");
        return g.f(this, cArr, i10, i11);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int v(double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "dst");
        return l.d(this, dArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final boolean v2() {
        m mVar = this.f15821b;
        return mVar.f15874c > mVar.f15873b;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final boolean w2() {
        m mVar = this.f15821b;
        return mVar.f15872a > mVar.f15874c;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void write(byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "src");
        l.x0(this, bArr, i10, i11);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeDouble(double d10) {
        l.q0(this, d10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFloat(float f10) {
        l.t0(this, f10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeInt(int i10) {
        l.T0(this, i10);
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeLong(long j10) {
        l.V0(this, j10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void x0(ByteBuffer byteBuffer, int i10) {
        kn.l0.p(byteBuffer, "dst");
        p0.d(this, byteBuffer, i10);
    }

    @Override // tl.g0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int x1(short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "dst");
        return l.h(this, sArr, i10, i11);
    }

    @Override // ul.b, tl.e
    @os.l
    /* JADX INFO: renamed from: x2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public o0 o() {
        ul.b bVarG2 = g2();
        ul.b bVar = bVarG2;
        if (bVarG2 == null) {
            bVar = this;
        }
        bVar.J1();
        ByteBuffer byteBuffer = this.f15820a;
        bm.h<ul.b> hVar = this.f16319f;
        if (hVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type io.ktor.utils.io.pool.ObjectPool<io.ktor.utils.io.core.IoBuffer>");
        }
        o0 o0Var = new o0(byteBuffer, bVar, (bm.h<o0>) hVar);
        p(o0Var);
        return o0Var;
    }

    @Override // tl.q0
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void z1(int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "src");
        ByteBuffer byteBufferC2 = C2();
        int i12 = i11 + i10;
        while (i10 < i12) {
            byteBufferC2.putInt(iArr[i10]);
            i10++;
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ o0 z2() {
        return (o0) f2();
    }

    public o0(ByteBuffer byteBuffer, ul.b bVar, bm.h<o0> hVar) {
        super(byteBuffer, bVar, hVar == null ? null : hVar);
    }

    @Override // java.lang.Appendable
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ Appendable append(CharSequence charSequence) {
        g.b(this, charSequence);
        return this;
    }

    public /* synthetic */ o0(ByteBuffer byteBuffer, ul.b bVar, bm.h hVar, kn.w wVar) {
        this(byteBuffer, bVar, (bm.h<o0>) hVar);
    }

    @Override // java.lang.Appendable
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public /* synthetic */ Appendable append(char c10) {
        g.a(this, c10);
        return this;
    }

    public o0(ByteBuffer byteBuffer, ul.b bVar, kn.w wVar) {
        this(byteBuffer, bVar, (bm.h<o0>) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o0(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "external");
        ql.f.a aVar = ql.f.f14043b;
        ByteBuffer byteBufferOrder = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
        kn.l0.o(byteBufferOrder, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        kn.l0.p(byteBufferOrder, "buffer");
        this(byteBufferOrder, (ul.b) null, (bm.h<o0>) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o0(@os.l ByteBuffer byteBuffer, @os.l bm.h<o0> hVar) {
        kn.l0.p(byteBuffer, "external");
        kn.l0.p(hVar, "pool");
        ql.f.a aVar = ql.f.f14043b;
        ByteBuffer byteBufferOrder = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
        kn.l0.o(byteBufferOrder, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        kn.l0.p(byteBufferOrder, "buffer");
        this(byteBufferOrder, (ul.b) null, hVar);
    }
}
