package hp;

import eo.t;
import java.util.Collection;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    @os.l
    public static final eo.b a(@os.l Collection<? extends eo.b> collection) {
        Integer numD;
        l0.p(collection, "descriptors");
        collection.isEmpty();
        eo.b bVar = null;
        for (eo.b bVar2 : collection) {
            if (bVar == null || ((numD = t.d(bVar.getVisibility(), bVar2.getVisibility())) != null && numD.intValue() < 0)) {
                bVar = bVar2;
            }
        }
        l0.m(bVar);
        return bVar;
    }
}
