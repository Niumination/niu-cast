package ho;

import eo.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class h0 extends op.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final eo.h0 f7355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final dp.c f7356c;

    public h0(@os.l eo.h0 h0Var, @os.l dp.c cVar) {
        kn.l0.p(h0Var, "moduleDescriptor");
        kn.l0.p(cVar, "fqName");
        this.f7355b = h0Var;
        this.f7356c = cVar;
    }

    @Override // op.i, op.k
    @os.l
    public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        kn.l0.p(dVar, "kindFilter");
        kn.l0.p(lVar, "nameFilter");
        op.d.f12368c.getClass();
        if (!dVar.a(op.d.f12373h)) {
            return nm.k0.INSTANCE;
        }
        if (this.f7356c.d() && dVar.f12392a.contains(op.c.b.f12367a)) {
            return nm.k0.INSTANCE;
        }
        Collection<dp.c> collectionP = this.f7355b.p(this.f7356c, lVar);
        ArrayList arrayList = new ArrayList(collectionP.size());
        Iterator<dp.c> it = collectionP.iterator();
        while (it.hasNext()) {
            dp.f fVarG = it.next().g();
            kn.l0.o(fVarG, "subFqName.shortName()");
            if (lVar.invoke(fVarG).booleanValue()) {
                eq.a.a(arrayList, i(fVarG));
            }
        }
        return arrayList;
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> h() {
        return nm.m0.INSTANCE;
    }

    @os.m
    public final p0 i(@os.l dp.f fVar) {
        kn.l0.p(fVar, "name");
        if (fVar.f3821b) {
            return null;
        }
        eo.h0 h0Var = this.f7355b;
        dp.c cVarC = this.f7356c.c(fVar);
        kn.l0.o(cVarC, "fqName.child(name)");
        p0 p0VarO0 = h0Var.o0(cVarC);
        if (p0VarO0.isEmpty()) {
            return null;
        }
        return p0VarO0;
    }

    @os.l
    public String toString() {
        return "subpackages of " + this.f7356c + " from " + this.f7355b;
    }
}
