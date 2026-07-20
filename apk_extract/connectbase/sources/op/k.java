package op;

import eo.y;
import java.util.Collection;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface k {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static Collection a(k kVar, d dVar, jn.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i10 & 1) != 0) {
                dVar = d.f12380o;
            }
            if ((i10 & 2) != 0) {
                h.f12403a.getClass();
                lVar = h.a.f12405b;
            }
            return kVar.e(dVar, lVar);
        }

        public static void b(@os.l k kVar, @os.l dp.f fVar, @os.l mo.b bVar) {
            l0.p(kVar, "this");
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            kVar.a(fVar, bVar);
        }
    }

    @os.l
    Collection<? extends y> a(@os.l dp.f fVar, @os.l mo.b bVar);

    @os.l
    Collection<eo.m> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar);

    @os.m
    eo.h f(@os.l dp.f fVar, @os.l mo.b bVar);

    void g(@os.l dp.f fVar, @os.l mo.b bVar);
}
