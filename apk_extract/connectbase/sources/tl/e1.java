package tl;

import lm.a2;
import lm.g2;
import lm.s1;
import lm.w1;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {
    @lm.t
    public static final void a(@os.l g0 g0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(sArr, "dst");
        i0.w(g0Var, sArr, i10, i11);
    }

    public static void b(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(sArr, "dst");
        i0.w(g0Var, sArr, i10, i11);
    }

    @lm.t
    public static final void c(@os.l g0 g0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(iArr, "dst");
        i0.u(g0Var, iArr, i10, i11);
    }

    public static void d(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(iArr, "dst");
        i0.u(g0Var, iArr, i10, i11);
    }

    @lm.t
    public static final void e(@os.l g0 g0Var, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(bArr, "dst");
        i0.r(g0Var, bArr, i10, i11);
    }

    public static void f(g0 g0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(bArr, "dst");
        i0.r(g0Var, bArr, i10, i11);
    }

    @lm.t
    public static final void g(@os.l g0 g0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(jArr, "dst");
        i0.v(g0Var, jArr, i10, i11);
    }

    public static void h(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(jArr, "dst");
        i0.v(g0Var, jArr, i10, i11);
    }

    @lm.t
    public static final byte i(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return s1.m(g0Var.readByte());
    }

    @lm.t
    public static final int j(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return w1.m(m0.e(g0Var));
    }

    @lm.t
    public static final long k(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return a2.m(m0.g(g0Var));
    }

    @lm.t
    public static final short l(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return g2.m(m0.k(g0Var));
    }

    @lm.t
    public static final void m(@os.l q0 q0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(jArr, dc.d.f3685p);
        s0.n(q0Var, jArr, i10, i11);
    }

    public static void n(q0 q0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(jArr, dc.d.f3685p);
        s0.n(q0Var, jArr, i10, i11);
    }

    @lm.t
    public static final void o(@os.l q0 q0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(sArr, dc.d.f3685p);
        s0.o(q0Var, sArr, i10, i11);
    }

    public static void p(q0 q0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(sArr, dc.d.f3685p);
        s0.o(q0Var, sArr, i10, i11);
    }

    @lm.t
    public static final void q(@os.l q0 q0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(iArr, dc.d.f3685p);
        s0.m(q0Var, iArr, i10, i11);
    }

    public static void r(q0 q0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(iArr, dc.d.f3685p);
        s0.m(q0Var, iArr, i10, i11);
    }

    @lm.t
    public static final void s(@os.l q0 q0Var, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(bArr, dc.d.f3685p);
        s0.j(q0Var, bArr, i10, i11);
    }

    public static void t(q0 q0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(bArr, dc.d.f3685p);
        s0.j(q0Var, bArr, i10, i11);
    }

    @lm.t
    public static final void u(@os.l q0 q0Var, byte b10) {
        kn.l0.p(q0Var, "$this$writeUByte");
        q0Var.d1(b10);
    }

    @lm.t
    public static final void v(@os.l q0 q0Var, int i10) {
        kn.l0.p(q0Var, "$this$writeUInt");
        u0.c(q0Var, i10);
    }

    @lm.t
    public static final void w(@os.l q0 q0Var, long j10) {
        kn.l0.p(q0Var, "$this$writeULong");
        u0.f(q0Var, j10);
    }

    @lm.t
    public static final void x(@os.l q0 q0Var, short s10) {
        kn.l0.p(q0Var, "$this$writeUShort");
        u0.j(q0Var, s10);
    }
}
