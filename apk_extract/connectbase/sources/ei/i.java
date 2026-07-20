package ei;

import bi.s;
import bi.x;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i extends a {
    @Override // ei.n
    public void a(Object obj) {
        bi.j jVarC = c();
        s sVarX = jVarC.x();
        Map map = (Map) obj;
        try {
            x xVarH = c().H();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                sVarX.a(next != null ? next.toString() : null);
                if (jVarC.o(next != null ? next.toString() : null, map.get(next))) {
                    n nVarB = jVarC.b(null, map.get(next));
                    if (!(nVarB instanceof g) || !((g) nVarB).b().booleanValue()) {
                        if (xVarH.e()) {
                            c().E();
                        }
                        xVarH.d();
                        if (next != null) {
                            c().u(next.toString());
                        } else {
                            c().u(null);
                        }
                    }
                    if (next != null) {
                        xVarH.b(next.toString());
                    } else {
                        xVarH.b(null);
                    }
                    nVarB.a(map.get(next));
                }
                sVarX.d();
            }
            c().D();
        } catch (Exception e10) {
            throw new bi.l(String.format("%s: Error while trying to serialize.", sVarX), e10);
        }
    }
}
