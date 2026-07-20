package qo;

import eo.k0;
import eo.o0;
import java.util.Collection;
import java.util.List;
import kn.l0;
import kn.n0;
import lm.x;
import nm.y;
import uo.u;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final h f14086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final up.a<dp.c, ro.h> f14087b;

    public static final class a extends n0 implements jn.a<ro.h> {
        final /* synthetic */ u $jPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar) {
            super(0);
            this.$jPackage = uVar;
        }

        @Override // jn.a
        @os.l
        public final ro.h invoke() {
            return new ro.h(g.this.f14086a, this.$jPackage);
        }
    }

    public g(@os.l c cVar) {
        l0.p(cVar, "components");
        h hVar = new h(cVar, l.a.f14099a, new x(null));
        this.f14086a = hVar;
        this.f14087b = hVar.f14088a.f14055a.b();
    }

    @Override // eo.l0
    @os.l
    public List<ro.h> a(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return y.P(e(cVar));
    }

    @Override // eo.o0
    public boolean b(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return this.f14086a.f14088a.f14056b.b(cVar) == null;
    }

    @Override // eo.o0
    public void c(@os.l dp.c cVar, @os.l Collection<k0> collection) {
        l0.p(cVar, "fqName");
        l0.p(collection, "packageFragments");
        eq.a.a(collection, e(cVar));
    }

    public final ro.h e(dp.c cVar) {
        u uVarB = this.f14086a.f14088a.f14056b.b(cVar);
        if (uVarB == null) {
            return null;
        }
        return this.f14087b.a(cVar, new a(uVarB));
    }

    @Override // eo.l0
    @os.l
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<dp.c> p(@os.l dp.c cVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(cVar, "fqName");
        l0.p(lVar, "nameFilter");
        ro.h hVarE = e(cVar);
        List<dp.c> listI0 = hVarE == null ? null : hVarE.I0();
        return listI0 == null ? nm.k0.INSTANCE : listI0;
    }

    @os.l
    public String toString() {
        return l0.C("LazyJavaPackageFragmentProvider of module ", this.f14086a.f14088a.f14069o);
    }
}
