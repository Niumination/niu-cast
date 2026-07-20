package tj;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f15645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f15646b;

    public l0(d dVar, p0 p0Var) {
        this.f15645a = dVar;
        this.f15646b = p0Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            if (l0Var.f15645a != this.f15645a) {
                return false;
            }
            p0 p0Var = l0Var.f15646b;
            p0 p0Var2 = this.f15646b;
            if (p0Var == p0Var2) {
                return true;
            }
            if (p0Var != null && p0Var2 != null) {
                return p0Var.equals(p0Var2);
            }
        }
        return false;
    }

    public final int hashCode() {
        int iIdentityHashCode = System.identityHashCode(this.f15645a);
        p0 p0Var = this.f15646b;
        return p0Var != null ? ((p0Var.hashCode() + 41) * 41) + iIdentityHashCode : iIdentityHashCode;
    }

    public final String toString() {
        return "MemoKey(" + this.f15645a + "@" + System.identityHashCode(this.f15645a) + ks.g.f9491d + this.f15646b + ")";
    }
}
