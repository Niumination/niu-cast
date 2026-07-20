package wk;

import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19649b;

    public o(@os.l String str) {
        kn.l0.p(str, "value");
        this.f19649b = str;
    }

    public static /* synthetic */ o f(o oVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = oVar.f19649b;
        }
        return oVar.e(str);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        if (i10 >= j0Var.f19627d.size() || !kn.l0.g(j0Var.f19627d.get(i10), this.f19649b)) {
            x.f19664e.getClass();
            return x.f19675p;
        }
        x.f19664e.getClass();
        return x.f19679t;
    }

    @os.l
    public final String d() {
        return this.f19649b;
    }

    @os.l
    public final o e(@os.l String str) {
        kn.l0.p(str, "value");
        return new o(str);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o) && kn.l0.g(this.f19649b, ((o) obj).f19649b);
    }

    @os.l
    public final String g() {
        return this.f19649b;
    }

    public int hashCode() {
        return this.f19649b.hashCode();
    }

    @os.l
    public String toString() {
        return this.f19649b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.WARNING, message = "hasTrailingSlash is not used anymore. This is going to be removed", replaceWith = @a1(expression = "PathSegmentConstantRouteSelector(value)", imports = {}))
    public o(@os.l String str, boolean z10) {
        this(str);
        kn.l0.p(str, "value");
    }
}
