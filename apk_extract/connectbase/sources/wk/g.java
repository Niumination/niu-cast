package wk;

import ik.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final p0 f19614b;

    public g(@os.l p0 p0Var) {
        kn.l0.p(p0Var, "method");
        this.f19614b = p0Var;
    }

    public static /* synthetic */ g f(g gVar, p0 p0Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            p0Var = gVar.f19614b;
        }
        return gVar.e(p0Var);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        if (kn.l0.g(uk.e.n(j0Var.f19625b.d()), this.f19614b)) {
            x.f19664e.getClass();
            return x.f19677r;
        }
        x.f19664e.getClass();
        return x.f19675p;
    }

    @os.l
    public final p0 d() {
        return this.f19614b;
    }

    @os.l
    public final g e(@os.l p0 p0Var) {
        kn.l0.p(p0Var, "method");
        return new g(p0Var);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && kn.l0.g(this.f19614b, ((g) obj).f19614b);
    }

    @os.l
    public final p0 g() {
        return this.f19614b;
    }

    public int hashCode() {
        return this.f19614b.f8144a.hashCode();
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("(method:"), this.f19614b.f8144a, ')');
    }
}
