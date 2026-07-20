package tl;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface q0 extends Closeable, Appendable {

    public static final class a {
        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void a(q0 q0Var, long j10, byte b10) {
            kn.l0.p(q0Var, "this");
            s0.e(q0Var, j10, b10);
        }

        @lm.k(message = "Write with writeXXXLittleEndian or do X.reverseByteOrder() and then writeXXX instead.")
        public static /* synthetic */ void b() {
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void c(q0 q0Var, double d10) {
            kn.l0.p(q0Var, "this");
            u0.a(q0Var, d10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void d(q0 q0Var, float f10) {
            kn.l0.p(q0Var, "this");
            u0.b(q0Var, f10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void e(q0 q0Var, ByteBuffer byteBuffer) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(byteBuffer, "bb");
            r0.a(q0Var, byteBuffer);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void f(q0 q0Var, o0 o0Var, int i10) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(o0Var, "src");
            s0.h(q0Var, o0Var, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void g(q0 q0Var, byte[] bArr, int i10, int i11) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(bArr, "src");
            s0.j(q0Var, bArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void h(q0 q0Var, double[] dArr, int i10, int i11) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(dArr, "src");
            s0.k(q0Var, dArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void i(q0 q0Var, float[] fArr, int i10, int i11) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(fArr, "src");
            s0.l(q0Var, fArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void j(q0 q0Var, int[] iArr, int i10, int i11) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(iArr, "src");
            s0.m(q0Var, iArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void k(q0 q0Var, long[] jArr, int i10, int i11) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(jArr, "src");
            s0.n(q0Var, jArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void l(q0 q0Var, short[] sArr, int i10, int i11) {
            kn.l0.p(q0Var, "this");
            kn.l0.p(sArr, "src");
            s0.o(q0Var, sArr, i10, i11);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void m(q0 q0Var, int i10) {
            kn.l0.p(q0Var, "this");
            u0.c(q0Var, i10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void n(q0 q0Var, long j10) {
            kn.l0.p(q0Var, "this");
            u0.f(q0Var, j10);
        }

        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ void o(q0 q0Var, short s10) {
            kn.l0.p(q0Var, "this");
            u0.j(q0Var, s10);
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void B(ByteBuffer byteBuffer);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void F(long[] jArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void M0(short s10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void R0(byte[] bArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void V1(double[] dArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void Y(o0 o0Var, int i10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void a0(long j10, byte b10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void d1(byte b10);

    @os.l
    Appendable f1(@os.l char[] cArr, int i10, int i11);

    void flush();

    void g(@os.l q qVar);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void h0(float[] fArr, int i10, int i11);

    @os.l
    q j();

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void m1(short[] sArr, int i10, int i11);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeDouble(double d10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeFloat(float f10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeInt(int i10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void writeLong(long j10);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ void z1(int[] iArr, int i10, int i11);
}
