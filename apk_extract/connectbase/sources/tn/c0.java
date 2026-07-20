package tn;

import java.util.NoSuchElementException;
import kn.l0;
import lm.a2;
import lm.f1;
import lm.g2;
import lm.o2;
import lm.p2;
import lm.s1;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
public class c0 {
    @f1(version = "1.7")
    public static final int A(@os.l v vVar) {
        l0.p(vVar, "<this>");
        if (!vVar.isEmpty()) {
            return vVar.f15935a;
        }
        throw new NoSuchElementException("Progression " + vVar + " is empty.");
    }

    @f1(version = "1.7")
    public static final long B(@os.l y yVar) {
        l0.p(yVar, "<this>");
        if (!yVar.isEmpty()) {
            return yVar.f15945a;
        }
        throw new NoSuchElementException("Progression " + yVar + " is empty.");
    }

    @os.m
    @f1(version = "1.7")
    public static final w1 C(@os.l v vVar) {
        l0.p(vVar, "<this>");
        if (vVar.isEmpty()) {
            return null;
        }
        return w1.b(vVar.f15935a);
    }

    @os.m
    @f1(version = "1.7")
    public static final a2 D(@os.l y yVar) {
        l0.p(yVar, "<this>");
        if (yVar.isEmpty()) {
            return null;
        }
        return a2.b(yVar.f15945a);
    }

    @f1(version = "1.7")
    public static final int E(@os.l v vVar) {
        l0.p(vVar, "<this>");
        if (!vVar.isEmpty()) {
            return vVar.f15936b;
        }
        throw new NoSuchElementException("Progression " + vVar + " is empty.");
    }

    @f1(version = "1.7")
    public static final long F(@os.l y yVar) {
        l0.p(yVar, "<this>");
        if (!yVar.isEmpty()) {
            return yVar.f15946b;
        }
        throw new NoSuchElementException("Progression " + yVar + " is empty.");
    }

    @os.m
    @f1(version = "1.7")
    public static final w1 G(@os.l v vVar) {
        l0.p(vVar, "<this>");
        if (vVar.isEmpty()) {
            return null;
        }
        return w1.b(vVar.f15936b);
    }

    @os.m
    @f1(version = "1.7")
    public static final a2 H(@os.l y yVar) {
        l0.p(yVar, "<this>");
        if (yVar.isEmpty()) {
            return null;
        }
        return a2.b(yVar.f15946b);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.t.class})
    public static final int I(x xVar) {
        l0.p(xVar, "<this>");
        return J(xVar, rn.f.Default);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final int J(@os.l x xVar, @os.l rn.f fVar) {
        l0.p(xVar, "<this>");
        l0.p(fVar, "random");
        try {
            return rn.h.h(fVar, xVar);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.t.class})
    public static final long K(a0 a0Var) {
        l0.p(a0Var, "<this>");
        return L(a0Var, rn.f.Default);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final long L(@os.l a0 a0Var, @os.l rn.f fVar) {
        l0.p(a0Var, "<this>");
        l0.p(fVar, "random");
        try {
            return rn.h.l(fVar, a0Var);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class, lm.t.class})
    public static final w1 M(x xVar) {
        l0.p(xVar, "<this>");
        return N(xVar, rn.f.Default);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class, lm.t.class})
    public static final w1 N(@os.l x xVar, @os.l rn.f fVar) {
        l0.p(xVar, "<this>");
        l0.p(fVar, "random");
        if (xVar.isEmpty()) {
            return null;
        }
        return w1.b(rn.h.h(fVar, xVar));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.r.class, lm.t.class})
    public static final a2 O(a0 a0Var) {
        l0.p(a0Var, "<this>");
        return P(a0Var, rn.f.Default);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {lm.r.class, lm.t.class})
    public static final a2 P(@os.l a0 a0Var, @os.l rn.f fVar) {
        l0.p(a0Var, "<this>");
        l0.p(fVar, "random");
        if (a0Var.isEmpty()) {
            return null;
        }
        return a2.b(rn.h.l(fVar, a0Var));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final v Q(@os.l v vVar) {
        l0.p(vVar, "<this>");
        v.a aVar = v.f15934d;
        int i10 = vVar.f15936b;
        int i11 = vVar.f15935a;
        int i12 = -vVar.f15937c;
        aVar.getClass();
        return new v(i10, i11, i12);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final y R(@os.l y yVar) {
        l0.p(yVar, "<this>");
        y.a aVar = y.f15944d;
        long j10 = yVar.f15946b;
        long j11 = yVar.f15945a;
        long j12 = -yVar.f15947c;
        aVar.getClass();
        return new y(j10, j11, j12);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final v S(@os.l v vVar, int i10) {
        l0.p(vVar, "<this>");
        t.a(i10 > 0, Integer.valueOf(i10));
        v.a aVar = v.f15934d;
        int i11 = vVar.f15935a;
        int i12 = vVar.f15936b;
        if (vVar.f15937c <= 0) {
            i10 = -i10;
        }
        aVar.getClass();
        return new v(i11, i12, i10);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final y T(@os.l y yVar, long j10) {
        l0.p(yVar, "<this>");
        t.a(j10 > 0, Long.valueOf(j10));
        y.a aVar = y.f15944d;
        long j11 = yVar.f15945a;
        long j12 = yVar.f15946b;
        if (yVar.f15947c <= 0) {
            j10 = -j10;
        }
        long j13 = j10;
        aVar.getClass();
        return new y(j11, j12, j13);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final x U(short s10, short s11) {
        int i10 = s11 & g2.f10190d;
        if (l0.t(i10, 0) > 0) {
            return new x(w1.m(s10 & g2.f10190d), i10 - 1, 1);
        }
        x.f15942e.getClass();
        return x.f15943f;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static x V(int i10, int i11) {
        if (Integer.compareUnsigned(i11, 0) > 0) {
            return new x(i10, w1.m(i11 - 1), 1);
        }
        x.f15942e.getClass();
        return x.f15943f;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final x W(byte b10, byte b11) {
        int i10 = b11 & 255;
        if (l0.t(i10, 0) > 0) {
            return new x(w1.m(b10 & 255), i10 - 1, 1);
        }
        x.f15942e.getClass();
        return x.f15943f;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static a0 X(long j10, long j11) {
        if (Long.compareUnsigned(j11, 0L) > 0) {
            return new a0(j10, j11 - a2.m(((long) 1) & 4294967295L));
        }
        a0.f15894e.getClass();
        return a0.f15895f;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final short a(short s10, short s11) {
        return l0.t(s10 & g2.f10190d, 65535 & s11) < 0 ? s11 : s10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final int b(int i10, int i11) {
        return Integer.compareUnsigned(i10, i11) < 0 ? i11 : i10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final byte c(byte b10, byte b11) {
        return l0.t(b10 & 255, b11 & 255) < 0 ? b11 : b10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final long d(long j10, long j11) {
        return Long.compareUnsigned(j10, j11) < 0 ? j11 : j10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final short e(short s10, short s11) {
        return l0.t(s10 & g2.f10190d, 65535 & s11) > 0 ? s11 : s10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final int f(int i10, int i11) {
        return Integer.compareUnsigned(i10, i11) > 0 ? i11 : i10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final byte g(byte b10, byte b11) {
        return l0.t(b10 & 255, b11 & 255) > 0 ? b11 : b10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final long h(long j10, long j11) {
        return Long.compareUnsigned(j10, j11) > 0 ? j11 : j10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final long i(long j10, @os.l g<a2> gVar) {
        l0.p(gVar, "range");
        if (gVar instanceof f) {
            return ((a2) u.N(a2.b(j10), (f) gVar)).f10177a;
        }
        if (!gVar.isEmpty()) {
            if (Long.compareUnsigned(j10, ((a2) gVar.getStart()).f10177a) < 0) {
                return ((a2) gVar.getStart()).f10177a;
            }
            return Long.compareUnsigned(j10, ((a2) gVar.getEndInclusive()).f10177a) > 0 ? ((a2) gVar.getEndInclusive()).f10177a : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + n1.e.f11183c);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final short j(short s10, short s11, short s12) {
        int i10 = s11 & g2.f10190d;
        int i11 = s12 & g2.f10190d;
        if (l0.t(i10, i11) <= 0) {
            int i12 = 65535 & s10;
            if (l0.t(i12, i10) < 0) {
                return s11;
            }
            return l0.t(i12, i11) > 0 ? s12 : s10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) g2.f0(s12)) + " is less than minimum " + ((Object) g2.f0(s11)) + n1.e.f11183c);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final int k(int i10, int i11, int i12) {
        if (Integer.compareUnsigned(i11, i12) <= 0) {
            if (Integer.compareUnsigned(i10, i11) < 0) {
                return i11;
            }
            return Integer.compareUnsigned(i10, i12) > 0 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) w1.h0(i12)) + " is less than minimum " + ((Object) w1.h0(i11)) + n1.e.f11183c);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final byte l(byte b10, byte b11, byte b12) {
        int i10 = b11 & 255;
        int i11 = b12 & 255;
        if (l0.t(i10, i11) <= 0) {
            int i12 = b10 & 255;
            if (l0.t(i12, i10) < 0) {
                return b11;
            }
            return l0.t(i12, i11) > 0 ? b12 : b10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) s1.f0(b12)) + " is less than minimum " + ((Object) s1.f0(b11)) + n1.e.f11183c);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final long m(long j10, long j11, long j12) {
        if (Long.compareUnsigned(j11, j12) <= 0) {
            if (Long.compareUnsigned(j10, j11) < 0) {
                return j11;
            }
            return Long.compareUnsigned(j10, j12) > 0 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) a2.h0(j12)) + " is less than minimum " + ((Object) o2.l(j11, 10)) + n1.e.f11183c);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final int n(int i10, @os.l g<w1> gVar) {
        l0.p(gVar, "range");
        if (gVar instanceof f) {
            return ((w1) u.N(w1.b(i10), (f) gVar)).f10227a;
        }
        if (!gVar.isEmpty()) {
            if (Integer.compareUnsigned(i10, ((w1) gVar.getStart()).f10227a) < 0) {
                return ((w1) gVar.getStart()).f10227a;
            }
            return Integer.compareUnsigned(i10, ((w1) gVar.getEndInclusive()).f10227a) > 0 ? ((w1) gVar.getEndInclusive()).f10227a : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + n1.e.f11183c);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final boolean o(@os.l x xVar, byte b10) {
        l0.p(xVar, "$this$contains");
        return xVar.j(w1.m(b10 & 255));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.t.class})
    public static final boolean p(a0 a0Var, a2 a2Var) {
        l0.p(a0Var, "$this$contains");
        return a2Var != null && a0Var.j(a2Var.f10177a);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final boolean q(@os.l a0 a0Var, int i10) {
        l0.p(a0Var, "$this$contains");
        return a0Var.j(a2.m(((long) i10) & 4294967295L));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final boolean r(@os.l a0 a0Var, byte b10) {
        l0.p(a0Var, "$this$contains");
        return a0Var.j(a2.m(((long) b10) & 255));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final boolean s(@os.l x xVar, short s10) {
        l0.p(xVar, "$this$contains");
        return xVar.j(w1.m(s10 & g2.f10190d));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {lm.t.class})
    public static final boolean t(x xVar, w1 w1Var) {
        l0.p(xVar, "$this$contains");
        return w1Var != null && xVar.j(w1Var.f10227a);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final boolean u(@os.l x xVar, long j10) {
        l0.p(xVar, "$this$contains");
        return a2.m(j10 >>> 32) == 0 && xVar.j(w1.m((int) j10));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    public static final boolean v(@os.l a0 a0Var, short s10) {
        l0.p(a0Var, "$this$contains");
        return a0Var.j(a2.m(((long) s10) & 65535));
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final v w(short s10, short s11) {
        v.a aVar = v.f15934d;
        int iM = w1.m(s10 & g2.f10190d);
        int i10 = s11 & g2.f10190d;
        aVar.getClass();
        return new v(iM, i10, -1);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final v x(int i10, int i11) {
        v.f15934d.getClass();
        return new v(i10, i11, -1);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final v y(byte b10, byte b11) {
        v.f15934d.getClass();
        return new v(w1.m(b10 & 255), b11 & 255, -1);
    }

    @f1(version = "1.5")
    @p2(markerClass = {lm.t.class})
    @os.l
    public static final y z(long j10, long j11) {
        y.f15944d.getClass();
        return new y(j10, j11, -1L);
    }
}
