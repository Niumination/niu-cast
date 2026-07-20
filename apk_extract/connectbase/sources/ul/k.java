package ul;

import java.nio.ByteBuffer;
import kn.l0;
import lm.m;
import os.l;
import tl.g0;
import tl.j0;
import tl.o0;
import tl.q0;
import tl.s;
import tl.s0;
import tl.v;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @l
    public static final byte[] f16328a = new byte[0];

    @lm.k(level = m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void a(q0 q0Var, o0 o0Var) {
        l0.p(q0Var, "<this>");
        l0.p(o0Var, "current");
        b(q0Var, o0Var);
    }

    @d
    public static final void b(@l q0 q0Var, @l b bVar) {
        l0.p(q0Var, "<this>");
        l0.p(bVar, "current");
        if (q0Var instanceof tl.c) {
            ((tl.c) q0Var).d();
        } else {
            c(q0Var, bVar);
        }
    }

    public static final void c(q0 q0Var, b bVar) {
        s0.p(q0Var, bVar, 0, 2, null);
        b.f16311i.getClass();
        bVar.j2(b.f16315w);
    }

    @lm.k(level = m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void d(g0 g0Var, o0 o0Var) {
        l0.p(g0Var, "<this>");
        l0.p(o0Var, "current");
        e(g0Var, o0Var);
    }

    @d
    public static final void e(@l g0 g0Var, @l b bVar) {
        l0.p(g0Var, "<this>");
        l0.p(bVar, "current");
        if (bVar == g0Var) {
            return;
        }
        if (!(g0Var instanceof tl.a)) {
            f(g0Var, bVar);
            return;
        }
        tl.m mVar = bVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15873b;
        if (i10 <= i11) {
            ((tl.a) g0Var).E(bVar);
        } else if (bVar.f15822c - mVar.f15872a < 8) {
            ((tl.a) g0Var).g0(bVar);
        } else {
            ((tl.a) g0Var).f15790b.f15800c = i11;
        }
    }

    public static final void f(g0 g0Var, b bVar) {
        int i10 = bVar.f15822c;
        tl.m mVar = bVar.f15821b;
        int i11 = mVar.f15872a;
        int i12 = mVar.f15874c;
        j0.b(g0Var, (i10 - (i11 - i12)) - (i12 - mVar.f15873b));
        b.f16311i.getClass();
        bVar.j2(b.f16315w);
    }

    public static /* synthetic */ void g() {
    }

    public static final b h(g0 g0Var, b bVar) {
        int i10 = bVar.f15822c;
        tl.m mVar = bVar.f15821b;
        int i11 = mVar.f15872a;
        int i12 = mVar.f15874c;
        j0.b(g0Var, (i10 - (i11 - i12)) - (i12 - mVar.f15873b));
        bVar.v0();
        if (!g0Var.B1() && tl.l0.c(g0Var, bVar, 0, 0, 0, 14, null) > 0) {
            return bVar;
        }
        b.f16311i.getClass();
        bVar.j2(b.f16315w);
        return null;
    }

    @in.i(name = "prepareReadFirstHead")
    @lm.k(level = m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ o0 i(g0 g0Var, int i10) {
        l0.p(g0Var, "<this>");
        return (o0) j(g0Var, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    @d
    public static final b j(@l g0 g0Var, int i10) {
        l0.p(g0Var, "<this>");
        if (g0Var instanceof tl.a) {
            return ((tl.a) g0Var).k2(i10);
        }
        if (!(g0Var instanceof b)) {
            return k(g0Var, i10);
        }
        tl.m mVar = ((tl.e) g0Var).f15821b;
        if (mVar.f15874c > mVar.f15873b) {
            return (b) g0Var;
        }
        return null;
    }

    public static final b k(g0 g0Var, int i10) {
        if (g0Var.B1()) {
            return null;
        }
        b.f16311i.getClass();
        b bVar = (b) b.f16315w.W0();
        ByteBuffer byteBuffer = bVar.f15820a;
        tl.m mVar = bVar.f15821b;
        int i11 = mVar.f15874c;
        int iV0 = (int) g0Var.V0(byteBuffer, i11, 0L, i10, mVar.f15872a - i11);
        bVar.b(iV0);
        if (iV0 >= i10) {
            return bVar;
        }
        throw pl.h.a(i10);
    }

    @in.i(name = "prepareReadNextHead")
    @lm.k(level = m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ o0 l(g0 g0Var, o0 o0Var) {
        l0.p(g0Var, "<this>");
        l0.p(o0Var, "current");
        return (o0) m(g0Var, o0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    @d
    public static final b m(@l g0 g0Var, @l b bVar) {
        l0.p(g0Var, "<this>");
        l0.p(bVar, "current");
        if (bVar != g0Var) {
            return g0Var instanceof tl.a ? ((tl.a) g0Var).b0(bVar) : h(g0Var, bVar);
        }
        tl.m mVar = ((tl.e) g0Var).f15821b;
        if (mVar.f15874c > mVar.f15873b) {
            return (b) g0Var;
        }
        return null;
    }

    @lm.k(level = m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ o0 n(q0 q0Var, int i10, o0 o0Var) {
        l0.p(q0Var, "<this>");
        return (o0) o(q0Var, i10, o0Var);
    }

    @d
    @l
    public static final b o(@l q0 q0Var, int i10, @os.m b bVar) {
        l0.p(q0Var, "<this>");
        if (!(q0Var instanceof tl.c)) {
            return p(q0Var, bVar);
        }
        if (bVar != null) {
            ((tl.c) q0Var).d();
        }
        return ((tl.c) q0Var).T0(i10);
    }

    public static final b p(q0 q0Var, b bVar) {
        if (bVar == null) {
            b.f16311i.getClass();
            return (b) b.f16315w.W0();
        }
        s0.p(q0Var, bVar, 0, 2, null);
        bVar.v0();
        return bVar;
    }

    public static final int q(@l v vVar, @l s sVar) {
        l0.p(vVar, "<this>");
        l0.p(sVar, "builder");
        int iP0 = sVar.P0();
        b bVarH2 = sVar.h2();
        if (bVarH2 == null) {
            return 0;
        }
        if (iP0 <= w0.c() && bVarH2.f2() == null && vVar.K2(bVarH2)) {
            sVar.c();
            return iP0;
        }
        vVar.c(bVarH2);
        return iP0;
    }
}
