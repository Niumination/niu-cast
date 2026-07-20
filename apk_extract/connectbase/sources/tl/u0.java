package tl;

import io.netty.handler.codec.http2.Http2CodecUtil;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 {
    public static final void a(@os.l q0 q0Var, double d10) {
        kn.l0.p(q0Var, "<this>");
        if (q0Var instanceof c) {
            d dVar = ((c) q0Var).f15807c;
            int i10 = dVar.f15812d;
            if (dVar.f15813e - i10 > 8) {
                dVar.f15812d = i10 + 8;
                dVar.f15811c.putDouble(i10, d10);
                return;
            }
        }
        g(q0Var, Double.doubleToRawLongBits(d10));
    }

    public static final void b(@os.l q0 q0Var, float f10) {
        kn.l0.p(q0Var, "<this>");
        if (q0Var instanceof c) {
            d dVar = ((c) q0Var).f15807c;
            int i10 = dVar.f15812d;
            if (dVar.f15813e - i10 > 4) {
                dVar.f15812d = i10 + 4;
                dVar.f15811c.putFloat(i10, f10);
                return;
            }
        }
        e(q0Var, Float.floatToRawIntBits(f10));
    }

    public static final void c(@os.l q0 q0Var, int i10) {
        kn.l0.p(q0Var, "<this>");
        if (q0Var instanceof c) {
            d dVar = ((c) q0Var).f15807c;
            int i11 = dVar.f15812d;
            if (dVar.f15813e - i11 > 4) {
                dVar.f15812d = i11 + 4;
                dVar.f15811c.putInt(i11, i10);
                return;
            }
        }
        e(q0Var, i10);
    }

    public static final void d(q0 q0Var, int i10) {
        short s10 = (short) (i10 >>> 16);
        q0Var.d1((byte) (s10 >>> 8));
        q0Var.d1((byte) (s10 & Http2CodecUtil.MAX_UNSIGNED_BYTE));
        short s11 = (short) (i10 & 65535);
        q0Var.d1((byte) (s11 >>> 8));
        q0Var.d1((byte) (s11 & Http2CodecUtil.MAX_UNSIGNED_BYTE));
    }

    public static final void e(q0 q0Var, int i10) {
        if (!(q0Var instanceof c)) {
            d(q0Var, i10);
            return;
        }
        c cVar = (c) q0Var;
        l.T0(cVar.T0(4), i10);
        cVar.d();
    }

    public static final void f(@os.l q0 q0Var, long j10) {
        kn.l0.p(q0Var, "<this>");
        if (q0Var instanceof c) {
            d dVar = ((c) q0Var).f15807c;
            int i10 = dVar.f15812d;
            if (dVar.f15813e - i10 > 8) {
                dVar.f15812d = i10 + 8;
                dVar.f15811c.putLong(i10, j10);
                return;
            }
        }
        g(q0Var, j10);
    }

    public static final void g(q0 q0Var, long j10) {
        if (!(q0Var instanceof c)) {
            d(q0Var, (int) (j10 >>> 32));
            d(q0Var, (int) (j10 & 4294967295L));
        } else {
            c cVar = (c) q0Var;
            l.V0(cVar.T0(8), j10);
            cVar.d();
        }
    }

    public static final boolean h(q0 q0Var, int i10, jn.l<? super e, l2> lVar) {
        if (!(q0Var instanceof c)) {
            return false;
        }
        c cVar = (c) q0Var;
        lVar.invoke(cVar.T0(i10));
        cVar.d();
        return true;
    }

    public static final boolean i(q0 q0Var, int i10, jn.p<? super ql.f, ? super Integer, l2> pVar) {
        if (!(q0Var instanceof c)) {
            return false;
        }
        d dVar = ((c) q0Var).f15807c;
        int i11 = dVar.f15812d;
        if (dVar.f15813e - i11 <= i10) {
            return false;
        }
        dVar.f15812d = i10 + i11;
        pVar.invoke(ql.f.b(dVar.f15811c), Integer.valueOf(i11));
        return true;
    }

    public static final void j(@os.l q0 q0Var, short s10) {
        kn.l0.p(q0Var, "<this>");
        if (q0Var instanceof c) {
            d dVar = ((c) q0Var).f15807c;
            int i10 = dVar.f15812d;
            if (dVar.f15813e - i10 > 2) {
                dVar.f15812d = i10 + 2;
                dVar.f15811c.putShort(i10, s10);
                return;
            }
        }
        k(q0Var, s10);
    }

    public static final void k(q0 q0Var, short s10) {
        if (!(q0Var instanceof c)) {
            q0Var.d1((byte) (s10 >>> 8));
            q0Var.d1((byte) (s10 & Http2CodecUtil.MAX_UNSIGNED_BYTE));
        } else {
            c cVar = (c) q0Var;
            l.X0(cVar.T0(2), s10);
            cVar.d();
        }
    }
}
