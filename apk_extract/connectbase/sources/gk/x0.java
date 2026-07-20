package gk;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {
    public static final boolean d(List<tn.o> list) {
        lm.t0 t0Var = new lm.t0(Boolean.TRUE, 0L);
        for (tn.o oVar : list) {
            t0Var = new lm.t0(Boolean.valueOf(((Boolean) t0Var.getFirst()).booleanValue() && ((Number) t0Var.getSecond()).longValue() <= oVar.f15921a), Long.valueOf(oVar.f15921a));
        }
        return ((Boolean) t0Var.getFirst()).booleanValue();
    }

    public static final List<ik.x> e(String str) {
        return jq.e0.J1(str, " GMT", false, 2, null) ? nm.x.k(new ik.x(str, null, 2, null)) : ik.i0.e(str, false);
    }

    public static final nk.a0 f(String str) {
        if (jq.e0.S1(str)) {
            return null;
        }
        if (jq.e0.s2(str, "W/", false, 2, null)) {
            throw new IllegalStateException("Check failed.");
        }
        return jq.e0.s2(str, "\"", false, 2, null) ? nk.i.f11522d.c(str) : new nk.m(ik.r.b(str));
    }

    public static final List<nk.a0> g(List<ik.x> list) {
        ArrayList arrayList = new ArrayList();
        for (ik.x xVar : list) {
            if (xVar.f8202c != 1.0d) {
                throw new IllegalStateException("If-Range doesn't support quality");
            }
            if (!xVar.f8201b.isEmpty()) {
                throw new IllegalStateException("If-Range doesn't support parameters");
            }
            nk.a0 a0VarF = f(xVar.f8200a);
            if (a0VarF != null) {
                arrayList.add(a0VarF);
            }
        }
        return arrayList;
    }
}
