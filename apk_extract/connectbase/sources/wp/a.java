package wp;

import kn.l0;
import vp.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    @os.l
    public static final z0 a(boolean z10, boolean z11, @os.l b bVar, @os.l f fVar, @os.l g gVar) {
        l0.p(bVar, "typeSystemContext");
        l0.p(fVar, "kotlinTypePreparator");
        l0.p(gVar, "kotlinTypeRefiner");
        return new z0(z10, z11, true, bVar, fVar, gVar);
    }

    public static /* synthetic */ z0 b(boolean z10, boolean z11, b bVar, f fVar, g gVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            bVar = q.f19874a;
        }
        if ((i10 & 8) != 0) {
            fVar = f.a.f19852a;
        }
        if ((i10 & 16) != 0) {
            gVar = g.a.f19853a;
        }
        return a(z10, z11, bVar, fVar, gVar);
    }
}
