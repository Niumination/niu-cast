package wk;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f19615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h0 f19616b;

    public g0(@os.l String str, @os.l h0 h0Var) {
        kn.l0.p(str, "value");
        kn.l0.p(h0Var, "kind");
        this.f19615a = str;
        this.f19616b = h0Var;
    }

    public static /* synthetic */ g0 d(g0 g0Var, String str, h0 h0Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = g0Var.f19615a;
        }
        if ((i10 & 2) != 0) {
            h0Var = g0Var.f19616b;
        }
        return g0Var.c(str, h0Var);
    }

    @os.l
    public final String a() {
        return this.f19615a;
    }

    @os.l
    public final h0 b() {
        return this.f19616b;
    }

    @os.l
    public final g0 c(@os.l String str, @os.l h0 h0Var) {
        kn.l0.p(str, "value");
        kn.l0.p(h0Var, "kind");
        return new g0(str, h0Var);
    }

    @os.l
    public final h0 e() {
        return this.f19616b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return kn.l0.g(this.f19615a, g0Var.f19615a) && this.f19616b == g0Var.f19616b;
    }

    @os.l
    public final String f() {
        return this.f19615a;
    }

    public int hashCode() {
        return this.f19616b.hashCode() + (this.f19615a.hashCode() * 31);
    }

    @os.l
    public String toString() {
        return "RoutingPathSegment(value=" + this.f19615a + ", kind=" + this.f19616b + ')';
    }
}
