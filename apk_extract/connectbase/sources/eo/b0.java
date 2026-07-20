package eo;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g0<c0> f4592a = new g0<>("InvalidModuleNotifier");

    public static final void a(@os.l h0 h0Var) {
        kn.l0.p(h0Var, "<this>");
        c0 c0Var = (c0) h0Var.M(f4592a);
        if (c0Var == null) {
            throw new a0(kn.l0.C("Accessing invalid module descriptor ", h0Var));
        }
        c0Var.a(h0Var);
    }
}
