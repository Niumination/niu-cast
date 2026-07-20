package ko;

import java.util.Collection;
import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends p implements uo.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dp.c f9437a;

    public w(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        this.f9437a = cVar;
    }

    @Override // uo.d
    public boolean C() {
        return false;
    }

    @os.l
    public List<uo.a> N() {
        return k0.INSTANCE;
    }

    @Override // uo.d
    @os.m
    public uo.a d(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return null;
    }

    @Override // uo.u
    @os.l
    public dp.c e() {
        return this.f9437a;
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof w) && l0.g(this.f9437a, ((w) obj).f9437a);
    }

    @Override // uo.d
    public Collection getAnnotations() {
        return k0.INSTANCE;
    }

    public int hashCode() {
        return this.f9437a.hashCode();
    }

    @os.l
    public String toString() {
        return w.class.getName() + ": " + this.f9437a;
    }

    @Override // uo.u
    @os.l
    public Collection<uo.g> u(@os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(lVar, "nameFilter");
        return k0.INSTANCE;
    }

    @Override // uo.u
    @os.l
    public Collection<uo.u> v() {
        return k0.INSTANCE;
    }
}
