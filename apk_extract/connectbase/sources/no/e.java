package no;

import eo.y0;
import java.util.Map;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends g0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final e f11734n = new e();

    public static final class a extends n0 implements jn.l<eo.b, Boolean> {
        final /* synthetic */ y0 $functionDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y0 y0Var) {
            super(1);
            this.$functionDescriptor = y0Var;
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            g0.f11742a.getClass();
            return Boolean.valueOf(g0.f11752k.containsKey(wo.u.d(this.$functionDescriptor)));
        }
    }

    @os.m
    public final dp.f i(@os.l y0 y0Var) {
        l0.p(y0Var, "functionDescriptor");
        g0.f11742a.getClass();
        Map map = g0.f11752k;
        String strD = wo.u.d(y0Var);
        if (strD == null) {
            return null;
        }
        return (dp.f) map.get(strD);
    }

    public final boolean j(@os.l y0 y0Var) {
        l0.p(y0Var, "functionDescriptor");
        return ao.h.e0(y0Var) && lp.a.d(y0Var, false, new a(y0Var), 1, null) != null;
    }

    public final boolean k(@os.l y0 y0Var) {
        l0.p(y0Var, "<this>");
        if (l0.g(y0Var.getName().b(), "removeAt")) {
            String strD = wo.u.d(y0Var);
            g0.f11742a.getClass();
            if (l0.g(strD, g0.f11750i.f11756b)) {
                return true;
            }
        }
        return false;
    }
}
