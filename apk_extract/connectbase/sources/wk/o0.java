package wk;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final o0 f19650b = new o0();

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        kn.l0.p(j0Var, "context");
        if (i.b(j0Var.f19625b)) {
            x.f19664e.getClass();
            return x.f19678s;
        }
        if (j0Var.f19627d.isEmpty()) {
            x.f19664e.getClass();
            return x.f19677r;
        }
        if (i10 < nm.y.J(j0Var.f19627d)) {
            x.f19664e.getClass();
            return x.f19678s;
        }
        if (i10 > nm.y.J(j0Var.f19627d)) {
            x.f19664e.getClass();
            return x.f19675p;
        }
        if (j0Var.f19627d.get(i10).length() > 0) {
            x.f19664e.getClass();
            return x.f19678s;
        }
        if (j0Var.f19628e) {
            x.f19664e.getClass();
            return x.f19679t;
        }
        x.f19664e.getClass();
        return x.f19675p;
    }

    @os.l
    public String toString() {
        return "<slash>";
    }
}
