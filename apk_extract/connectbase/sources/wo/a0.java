package wo;

import ik.y0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import vp.i1;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    @os.l
    public static final <T> T a(@os.l l<T> lVar, @os.l T t10, boolean z10) {
        l0.p(lVar, "<this>");
        l0.p(t10, "possiblyPrimitiveType");
        return z10 ? lVar.b(t10) : t10;
    }

    @os.m
    public static final <T> T b(@os.l i1 i1Var, @os.l yp.i iVar, @os.l l<T> lVar, @os.l z zVar) {
        l0.p(i1Var, "<this>");
        l0.p(iVar, y0.a.f8215h);
        l0.p(lVar, "typeFactory");
        l0.p(zVar, "mode");
        yp.o oVarS0 = i1Var.s0(iVar);
        if (!i1Var.v0(oVarS0)) {
            return null;
        }
        ao.i iVarI = i1Var.i(oVarS0);
        if (iVarI != null) {
            return (T) a(lVar, lVar.c(iVarI), i1Var.P(iVar) || vo.s.b(i1Var, iVar));
        }
        ao.i iVarZ = i1Var.Z(oVarS0);
        if (iVarZ != null) {
            return lVar.a(l0.C("[", mp.e.get(iVarZ).getDesc()));
        }
        if (i1Var.t0(oVarS0)) {
            dp.d dVarM0 = i1Var.m0(oVarS0);
            dp.b bVarO = dVarM0 == null ? null : co.c.f1685a.o(dVarM0);
            if (bVarO != null) {
                if (!zVar.f19844g) {
                    co.c.f1685a.getClass();
                    List<co.c.a> list = co.c.f1699o;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (l0.g(((co.c.a) it.next()).f1700a, bVarO)) {
                                return null;
                            }
                        }
                    }
                }
                String strF = mp.d.b(bVarO).f();
                l0.o(strF, "byClassId(classId).internalName");
                return lVar.e(strF);
            }
        }
        return null;
    }
}
