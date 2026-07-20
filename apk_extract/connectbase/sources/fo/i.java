package fo;

import kn.l0;
import y1.o;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    @os.l
    public static final g a(@os.l g gVar, @os.l g gVar2) {
        l0.p(gVar, "first");
        l0.p(gVar2, o.r.f20674f);
        if (gVar.isEmpty()) {
            return gVar2;
        }
        return gVar2.isEmpty() ? gVar : new k(gVar, gVar2);
    }
}
