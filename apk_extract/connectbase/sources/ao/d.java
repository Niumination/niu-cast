package ao;

import java.util.Set;
import kn.l0;
import nm.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final boolean a(@os.l c cVar, @os.l eo.e eVar) {
        l0.p(cVar, "<this>");
        l0.p(eVar, "classDescriptor");
        if (hp.d.x(eVar)) {
            cVar.getClass();
            Set<dp.b> set = c.f520b;
            dp.b bVarH = lp.a.h(eVar);
            if (h0.W1(set, bVarH == null ? null : bVarH.g())) {
                return true;
            }
        }
        return false;
    }
}
