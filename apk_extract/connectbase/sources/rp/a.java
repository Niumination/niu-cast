package rp;

import eo.h0;
import eo.k0;
import eo.o0;
import java.util.Collection;
import java.util.List;
import kn.l0;
import kn.n0;
import nm.m0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final up.n f14680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final t f14681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final h0 f14682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f14683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final up.h<dp.c, k0> f14684e;

    /* JADX INFO: renamed from: rp.a$a, reason: collision with other inner class name */
    public static final class C0363a extends n0 implements jn.l<dp.c, k0> {
        public C0363a() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final k0 invoke(@os.l dp.c cVar) {
            l0.p(cVar, "fqName");
            o oVarD = a.this.d(cVar);
            if (oVarD == null) {
                return null;
            }
            oVarD.F0(a.this.e());
            return oVarD;
        }
    }

    public a(@os.l up.n nVar, @os.l t tVar, @os.l h0 h0Var) {
        l0.p(nVar, "storageManager");
        l0.p(tVar, "finder");
        l0.p(h0Var, "moduleDescriptor");
        this.f14680a = nVar;
        this.f14681b = tVar;
        this.f14682c = h0Var;
        this.f14684e = nVar.f(new C0363a());
    }

    @Override // eo.l0
    @os.l
    public List<k0> a(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return nm.y.P(this.f14684e.invoke(cVar));
    }

    @Override // eo.o0
    public boolean b(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return (this.f14684e.y(cVar) ? (k0) this.f14684e.invoke(cVar) : d(cVar)) == null;
    }

    @Override // eo.o0
    public void c(@os.l dp.c cVar, @os.l Collection<k0> collection) {
        l0.p(cVar, "fqName");
        l0.p(collection, "packageFragments");
        eq.a.a(collection, this.f14684e.invoke(cVar));
    }

    @os.m
    public abstract o d(@os.l dp.c cVar);

    @os.l
    public final j e() {
        j jVar = this.f14683d;
        if (jVar != null) {
            return jVar;
        }
        l0.S("components");
        return null;
    }

    @os.l
    public final t f() {
        return this.f14681b;
    }

    @os.l
    public final h0 g() {
        return this.f14682c;
    }

    @os.l
    public final up.n h() {
        return this.f14680a;
    }

    public final void i(@os.l j jVar) {
        l0.p(jVar, "<set-?>");
        this.f14683d = jVar;
    }

    @Override // eo.l0
    @os.l
    public Collection<dp.c> p(@os.l dp.c cVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(cVar, "fqName");
        l0.p(lVar, "nameFilter");
        return m0.INSTANCE;
    }
}
