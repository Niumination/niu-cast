package bq;

import eo.y;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    @os.l
    public final c a(@os.l y yVar) {
        l0.p(yVar, "functionDescriptor");
        for (d dVar : b()) {
            if (dVar.b(yVar)) {
                return dVar.a(yVar);
            }
        }
        return c.a.f1047b;
    }

    @os.l
    public abstract List<d> b();
}
