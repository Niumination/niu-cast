package op;

import eo.t0;
import eo.y0;
import java.util.Collection;
import java.util.Set;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements h {
    @Override // op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return j().a(fVar, bVar);
    }

    @Override // op.h
    @os.l
    public Set<dp.f> b() {
        return j().b();
    }

    @Override // op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return j().c(fVar, bVar);
    }

    @Override // op.h
    @os.l
    public Set<dp.f> d() {
        return j().d();
    }

    @Override // op.k
    @os.l
    public Collection<eo.m> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        return j().e(dVar, lVar);
    }

    @Override // op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return j().f(fVar, bVar);
    }

    @Override // op.k
    public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        j().g(fVar, bVar);
    }

    @Override // op.h
    @os.m
    public Set<dp.f> h() {
        return j().h();
    }

    @os.l
    public final h i() {
        return j() instanceof a ? ((a) j()).i() : j();
    }

    @os.l
    public abstract h j();
}
