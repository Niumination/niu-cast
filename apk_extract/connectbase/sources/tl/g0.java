package tl;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface g0 extends Closeable {

    public static final class a {
        @lm.k(level = lm.m.ERROR, message = "Not supported anymore. All operations are big endian by default. Use readXXXLittleEndian or readXXX then X.reverseByteOrder() instead.")
        public static /* synthetic */ void a() {
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int b(g0 g0Var, o0 o0Var) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(o0Var, "buffer");
            return l0.c(g0Var, o0Var, 0, 0, 0, 14, null);
        }

        public static /* synthetic */ long c(g0 g0Var, ByteBuffer byteBuffer, long j10, long j11, long j12, long j13, int i10, Object obj) {
            if (obj == null) {
                return g0Var.V0(byteBuffer, j10, (i10 & 4) != 0 ? 0L : j11, (i10 & 8) != 0 ? 1L : j12, (i10 & 16) != 0 ? Long.MAX_VALUE : j13);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peekTo-1dgeIsk");
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int d(g0 g0Var, ByteBuffer byteBuffer, int i10) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(byteBuffer, "dst");
            return h0.a(g0Var, byteBuffer, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int e(g0 g0Var, o0 o0Var, int i10) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(o0Var, "dst");
            return i0.a(g0Var, o0Var, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int f(g0 g0Var, byte[] bArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(bArr, "dst");
            return i0.b(g0Var, bArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int g(g0 g0Var, double[] dArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(dArr, "dst");
            return i0.c(g0Var, dArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int h(g0 g0Var, float[] fArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(fArr, "dst");
            return i0.d(g0Var, fArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int i(g0 g0Var, int[] iArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(iArr, "dst");
            return i0.e(g0Var, iArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int j(g0 g0Var, long[] jArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(jArr, "dst");
            return i0.f(g0Var, jArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int k(g0 g0Var, short[] sArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(sArr, "dst");
            return i0.g(g0Var, sArr, i10, i11);
        }

        public static /* synthetic */ int l(g0 g0Var, ByteBuffer byteBuffer, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAvailable");
            }
            if ((i11 & 2) != 0) {
                i10 = byteBuffer.remaining();
            }
            return g0Var.L0(byteBuffer, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ double m(g0 g0Var) {
            kn.l0.p(g0Var, "this");
            return m0.a(g0Var);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ float n(g0 g0Var) {
            kn.l0.p(g0Var, "this");
            return m0.c(g0Var);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void o(g0 g0Var, ByteBuffer byteBuffer, int i10) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(byteBuffer, "dst");
            h0.c(g0Var, byteBuffer, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void p(g0 g0Var, o0 o0Var, int i10) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(o0Var, "dst");
            i0.q(g0Var, o0Var, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void q(g0 g0Var, byte[] bArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(bArr, "dst");
            i0.r(g0Var, bArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void r(g0 g0Var, double[] dArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(dArr, "dst");
            i0.s(g0Var, dArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void s(g0 g0Var, float[] fArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(fArr, "dst");
            i0.t(g0Var, fArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void t(g0 g0Var, int[] iArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(iArr, "dst");
            i0.u(g0Var, iArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void u(g0 g0Var, long[] jArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(jArr, "dst");
            i0.v(g0Var, jArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void v(g0 g0Var, short[] sArr, int i10, int i11) {
            kn.l0.p(g0Var, "this");
            kn.l0.p(sArr, "dst");
            i0.w(g0Var, sArr, i10, i11);
        }

        public static /* synthetic */ void w(g0 g0Var, ByteBuffer byteBuffer, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readFully");
            }
            if ((i11 & 2) != 0) {
                i10 = byteBuffer.remaining();
            }
            g0Var.x0(byteBuffer, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ int x(g0 g0Var) {
            kn.l0.p(g0Var, "this");
            return m0.e(g0Var);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ long y(g0 g0Var) {
            kn.l0.p(g0Var, "this");
            return m0.g(g0Var);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ short z(g0 g0Var) {
            kn.l0.p(g0Var, "this");
            return m0.k(g0Var);
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int A1(o0 o0Var);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void C1(o0 o0Var, int i10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void E0(int[] iArr, int i10, int i11);

    int G();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int H0(o0 o0Var, int i10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int L0(ByteBuffer byteBuffer, int i10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void N0(short[] sArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void R(long[] jArr, int i10, int i11);

    long V0(@os.l ByteBuffer byteBuffer, long j10, long j11, long j12, long j13);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int W(int[] iArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int W1(byte[] bArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void X1(float[] fArr, int i10, int i11);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void g(@os.l q qVar);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int i1(float[] fArr, int i10, int i11);

    @os.l
    q j();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void m0(double[] dArr, int i10, int i11);

    /* JADX INFO: renamed from: n1 */
    boolean B1();

    byte readByte();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ double readDouble();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ float readFloat();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void readFully(byte[] bArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int readInt();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ long readLong();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ short readShort();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int t0(long[] jArr, int i10, int i11);

    long t1(long j10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int v(double[] dArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void x0(ByteBuffer byteBuffer, int i10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ int x1(short[] sArr, int i10, int i11);
}
