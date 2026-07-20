package wo;

import eo.c1;
import eo.h0;
import eo.j0;
import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    public static final class a implements qo.b {
        @Override // qo.b
        @os.m
        public List<uo.a> a(@os.l dp.b bVar) {
            l0.p(bVar, "classId");
            return null;
        }
    }

    @os.l
    public static final d a(@os.l h0 h0Var, @os.l up.n nVar, @os.l j0 j0Var, @os.l qo.g gVar, @os.l n nVar2, @os.l f fVar, @os.l rp.q qVar) {
        l0.p(h0Var, "module");
        l0.p(nVar, "storageManager");
        l0.p(j0Var, "notFoundClasses");
        l0.p(gVar, "lazyJavaPackageFragmentProvider");
        l0.p(nVar2, "reflectKotlinClassFinder");
        l0.p(fVar, "deserializedDescriptorResolver");
        l0.p(qVar, "errorReporter");
        g gVar2 = new g(nVar2, fVar);
        b bVar = new b(h0Var, j0Var, nVar, nVar2);
        rp.k.a aVar = rp.k.a.f14747a;
        mo.c.a aVar2 = mo.c.a.f10855a;
        rp.i.f14724a.getClass();
        rp.i iVar = rp.i.a.f14726b;
        wp.l.f19866b.getClass();
        return new d(nVar, h0Var, aVar, gVar2, bVar, gVar, j0Var, qVar, aVar2, iVar, wp.l.a.f19868b);
    }

    @os.l
    public static final qo.g b(@os.l no.o oVar, @os.l h0 h0Var, @os.l up.n nVar, @os.l j0 j0Var, @os.l n nVar2, @os.l f fVar, @os.l rp.q qVar, @os.l to.b bVar, @os.l qo.j jVar, @os.l v vVar) {
        l0.p(oVar, "javaClassFinder");
        l0.p(h0Var, "module");
        l0.p(nVar, "storageManager");
        l0.p(j0Var, "notFoundClasses");
        l0.p(nVar2, "reflectKotlinClassFinder");
        l0.p(fVar, "deserializedDescriptorResolver");
        l0.p(qVar, "errorReporter");
        l0.p(bVar, "javaSourceElementFactory");
        l0.p(jVar, "singleModuleClassResolver");
        l0.p(vVar, "packagePartProvider");
        no.v.b bVar2 = no.v.f11785d;
        bVar2.getClass();
        no.c cVar = new no.c(nVar, no.v.f11786e);
        bVar2.getClass();
        no.v vVar2 = no.v.f11786e;
        oo.j jVar2 = oo.j.f12354a;
        l0.o(jVar2, "DO_NOTHING");
        oo.g gVar = oo.g.f12349a;
        l0.o(gVar, "EMPTY");
        oo.f.a aVar = oo.f.a.f12348a;
        np.b bVar3 = new np.b(nVar, k0.INSTANCE);
        c1.a aVar2 = c1.a.f4596a;
        mo.c.a aVar3 = mo.c.a.f10855a;
        ao.j jVar3 = new ao.j(h0Var, j0Var);
        bVar2.getClass();
        no.v vVar3 = no.v.f11786e;
        qo.d.b bVar4 = qo.d.b.f14081b;
        vo.k kVar = new vo.k(cVar, vVar3, new vo.c(bVar4));
        no.p.a aVar4 = no.p.a.f11767a;
        wp.l.f19866b.getClass();
        return new qo.g(new qo.c(nVar, oVar, nVar2, fVar, jVar2, qVar, gVar, aVar, bVar3, bVar, jVar, vVar, aVar2, aVar3, h0Var, jVar3, cVar, kVar, aVar4, bVar4, wp.l.a.f19868b, vVar2, new a(), null, 8388608, null));
    }
}
