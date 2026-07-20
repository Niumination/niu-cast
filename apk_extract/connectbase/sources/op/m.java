package op;

import eo.b1;
import eo.t0;
import eo.y0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import vp.f1;
import vp.h1;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h f12410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final h1 f12411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public Map<eo.m, eo.m> f12412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final d0 f12413e;

    public static final class a extends n0 implements jn.a<Collection<? extends eo.m>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Collection<? extends eo.m> invoke() {
            m mVar = m.this;
            return mVar.m(k.a.a(mVar.f12410b, null, null, 3, null));
        }
    }

    public m(@os.l h hVar, @os.l h1 h1Var) {
        l0.p(hVar, "workerScope");
        l0.p(h1Var, "givenSubstitutor");
        this.f12410b = hVar;
        f1 f1VarJ = h1Var.j();
        l0.o(f1VarJ, "givenSubstitutor.substitution");
        this.f12411c = ip.d.f(f1VarJ, false, 1, null).c();
        this.f12413e = f0.b(new a());
    }

    @Override // op.h, op.k
    @os.l
    public Collection<? extends y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return m(this.f12410b.a(fVar, bVar));
    }

    @Override // op.h
    @os.l
    public Set<dp.f> b() {
        return this.f12410b.b();
    }

    @Override // op.h
    @os.l
    public Collection<? extends t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return m(this.f12410b.c(fVar, bVar));
    }

    @Override // op.h
    @os.l
    public Set<dp.f> d() {
        return this.f12410b.d();
    }

    @Override // op.k
    @os.l
    public Collection<eo.m> e(@os.l d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        return k();
    }

    @Override // op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        eo.h hVarF = this.f12410b.f(fVar, bVar);
        if (hVarF == null) {
            return null;
        }
        return (eo.h) l(hVarF);
    }

    @Override // op.k
    public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
        h.b.a(this, fVar, bVar);
    }

    @Override // op.h
    @os.m
    public Set<dp.f> h() {
        return this.f12410b.h();
    }

    public final Collection<eo.m> k() {
        return (Collection) this.f12413e.getValue();
    }

    public final <D extends eo.m> D l(D d10) {
        if (this.f12411c.k()) {
            return d10;
        }
        if (this.f12412d == null) {
            this.f12412d = new HashMap();
        }
        Map<eo.m, eo.m> map = this.f12412d;
        l0.m(map);
        eo.m mVarC = map.get(d10);
        if (mVarC == null) {
            if (!(d10 instanceof b1)) {
                throw new IllegalStateException(l0.C("Unknown descriptor in scope: ", d10).toString());
            }
            mVarC = ((b1) d10).c(this.f12411c);
            if (mVarC == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d10 + " substitution fails");
            }
            map.put(d10, mVarC);
        }
        return (D) mVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends eo.m> Collection<D> m(Collection<? extends D> collection) {
        if (this.f12411c.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetG = eq.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetG.add(l((eo.m) it.next()));
        }
        return linkedHashSetG;
    }
}
